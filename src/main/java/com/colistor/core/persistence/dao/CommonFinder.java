/*Colistor, collections and lists organizer
*Copyright (C) 2016  Colistor (Joel Favre)
*
*This program is free software: you can redistribute it and/or modify
*it under the terms of the GNU Affero General Public License as published
*by the Free Software Foundation, either version 3 of the License, or
*(at your option) any later version.
*
*This program is distributed in the hope that it will be useful,
*but WITHOUT ANY WARRANTY; without even the implied warranty of
*MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*GNU Affero General Public License for more details.
*
*You should have received a copy of the GNU Affero General Public License
*along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.colistor.core.persistence.dao;

import com.colistor.core.persistence.dbaccess.AccessAnnotation;
import com.colistor.core.persistence.dbaccess.DAOMapping;
import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.model.Filter;
import com.colistor.core.persistence.model.OneToOne;
import com.colistor.core.persistence.transaction.TransactionI;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.ast.ReqlFunction1;
import com.rethinkdb.gen.ast.Table;
import com.rethinkdb.net.Cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helps retrieve the data from the rethink database in a generic manner.
 *
 * @param <T> The data model object top map to from the database.
 */
public class CommonFinder<T> implements FindI<T> {

    private final RethinkDB r = RethinkDB.r;
    private final Gson gson = new Gson();
    private final Provider<T> provT;
    private T instance;

    @Inject
    public CommonFinder(Provider<T> provT) {
        this.provT = provT;
        instance = provT.get();
    }

    @Override
    public T findById(TransactionI trans, String id) throws DAOException {
        T tRet = null;
        try {
            Map<String, Object> map = r.table(AccessAnnotation.getEntity(instance))
                    .get(id)
                    .run(trans.getConnection());
            if (map != null) {
                tRet = DAOMapping.mapFromDB(map, provT.get());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return tRet;
    }

    @Override
    public T findByCode(TransactionI trans, String code) throws DAOException {
        T tRet = null;
        try {
            Cursor<HashMap> cur = r.table(AccessAnnotation.getEntity(instance))
                    .filter(r.hashMap(AccessAnnotation.getCodeFieldName(instance), code))
                    .run(trans.getConnection());
            if (cur != null) {
                tRet = DAOMapping.mapFromDB((Map<String, Object>) cur.next(), provT.get());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return tRet;
    }

    @Override
    public List<T> findByUserCodeOrPublic(TransactionI trans, String userCode, Filter filter) throws DAOException {
        List<T> tRet = new ArrayList<>();
        try {
            String userCodeFieldName = AccessAnnotation.getUserCodeFieldName(instance);
            Cursor<HashMap> cur = r.table(AccessAnnotation.getEntity(instance))
                    .filter(row ->
                            row.g(userCodeFieldName).default_("").eq(userCode).
                                    or(row.g(userCodeFieldName).default_("").eq("public")))
                    .run(trans.getConnection());
            if (cur != null) {
                for (Map<String, Object> map : cur) {
                    tRet.add(DAOMapping.mapFromDB(map, provT.get()));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return tRet;
    }

    @Override
    public List<T> findByFilter(TransactionI trans, Filter filter) throws DAOException {
        List<T> tRet = new ArrayList<>();
        try {
            Table table = r.table(AccessAnnotation.getEntity(instance));
            if (filter != null) {
                if (filter.criteria != null && filter.criteria.size() > 0) {
                    table.filter(applyFilter());
                }
                if (filter.orderBy != null && !filter.orderBy.equals("")) {
                    table.orderBy();
                }
                if (filter.offset > 0) {

                }
                if (filter.limit > 0) {

                }
            }

            Cursor<HashMap> cur = table.run(trans.getConnection());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return tRet;
    }

    @Override
    public <U> List<OneToOne<T, U>> eqjoinWithSons(TransactionI trans, Filter filter, Class<U> son) throws DAOException {
        return null;
    }

    @Override
    public <U> OneToOne<T, U> eqjoinWithSon(TransactionI trans, Filter filter, Class<U> son) throws DAOException {
        return null;
    }

    private ReqlFunction1 applyFilter() {
        return null;
    }
}
