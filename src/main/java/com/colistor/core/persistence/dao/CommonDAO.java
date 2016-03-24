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
import com.colistor.core.persistence.transaction.TransactionI;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.rethinkdb.RethinkDB;

import java.util.ArrayList;
import java.util.Map;

public class CommonDAO<T> implements DAOI<T> {

    private final RethinkDB r = RethinkDB.r;
    private final Gson gson = new Gson();
    @Inject
    private FindI<T> find;

    @Override
    public T insert(TransactionI trans, T t) throws DAOException {
        T tRet = null;
        try {
            Map<String, Object> test = r.table(AccessAnnotation.getEntity(t)).insert(DAOMapping.getFieldsOnInsert(t)).run(trans.getConnection());
            if ((Long) test.get("errors") == 0 && (Long) test.get("inserted") == 1) {
                String id = ((ArrayList<String>) test.get("generated_keys")).get(0);
                tRet = find.findById(trans, id);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return tRet;
    }

    @Override
    public T update(TransactionI trans, T t) throws DAOException {
        T tRet = null;
        try {
            String id = AccessAnnotation.getId(t);
            Map<String, Object> test = r.table(AccessAnnotation.getEntity(t)).get(id).update(DAOMapping.getFieldsOnUpdate(t)).run(trans.getConnection());
            if ((Long) test.get("errors") == 0 && (Long) test.get("replaced") == 1) {
                tRet = find.findById(trans, id);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return tRet;
    }

    @Override
    public void delete(TransactionI trans, T t) throws DAOException {
        Map<String, Object> res = null;
        try {
            res = r.table(AccessAnnotation.getEntity(t)).get(AccessAnnotation.getId(t)).delete().run(trans.getConnection());
            if ((Long) res.get("errors") == 0 && (Long) res.get("deleted") == 1) {

            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
