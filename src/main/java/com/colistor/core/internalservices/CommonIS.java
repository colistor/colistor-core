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
package com.colistor.core.internalservices;

import com.colistor.core.internalservices.exception.InternalServiceException;
import com.colistor.core.persistence.dao.DAOI;
import com.colistor.core.persistence.dao.FindI;
import com.colistor.core.persistence.dbaccess.AccessAnnotation;
import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.transaction.TransactionI;
import com.colistor.core.tools.RandomString;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;

public class CommonIS<T> implements CommonISI<T> {

    private static final int CODE_LENGTH = 16;

    @Inject
    private Provider<DAOI<T>> dao;

    @Inject
    private Provider<FindI<T>> finder;

    private RandomString randomString;

    @Inject
    public CommonIS(RandomString randomString) {
        this.randomString = randomString;
    }

    @Override
    public T add(TransactionI trans, T t) throws InternalServiceException {
        isWithoutViolations(t, "is_i", "i");
        T ret = null;
        String code = randomString.nextRandomString(CODE_LENGTH);
        try {
            AccessAnnotation.setCode(t, code);
            ret = dao.get().insert(trans, t);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public T modify(TransactionI trans, T t) throws InternalServiceException {
        isWithoutViolations(t, "is_u", "u");
        T ret = null;
        try {
            ret = dao.get().update(trans, t);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void delete(TransactionI trans, T t) throws InternalServiceException {
        isWithoutViolations(t, "is_d", "d");
        try {
            dao.get().delete(trans, t);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T findById(TransactionI trans, String id) throws InternalServiceException {
        if (id == null || id.equals("")) {
            throw new InternalServiceException();
        }

        T ret = null;
        try {
            ret = finder.get().findById(trans, id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public T findByCode(TransactionI trans, String code) throws InternalServiceException {
        if (code == null || code.equals("")) {
            throw new InternalServiceException();
        }

        T ret = null;
        try {
            ret = finder.get().findByCode(trans, code);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private boolean isWithoutViolations(T t, String... profiles) throws InternalServiceException {
        Vtor vtor = new Vtor();
        vtor.useProfiles(profiles);
        vtor.validate(t);
        if (vtor.hasViolations()) {
            for (Violation violation : vtor.getViolations()) {
                //violation.
            }
            throw new InternalServiceException();
        }
        return false;
    }
}
