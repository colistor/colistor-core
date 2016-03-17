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
import com.colistor.core.persistence.dbaccess.AccessAnnotation;
import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.transaction.TransactionI;
import com.colistor.core.tools.RandomString;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class CommonIS<T> {

    private static final int CODE_LENGTH = 16;

    @Inject
    private Provider<DAOI<T>> provider;

    private RandomString randomString;

    @Inject
    public CommonIS(RandomString randomString) {
        this.randomString = randomString;
    }

    public T add(TransactionI trans, T t) throws InternalServiceException {
        T ret = null;
        String code = randomString.nextRandomString(CODE_LENGTH);
        try {
            AccessAnnotation.setCode(t, code);
            ret = provider.get().insert(trans, t);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public T modify(TransactionI trans, T t) throws InternalServiceException {
        T ret = null;
        try {
            ret = provider.get().update(trans, t);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void delete(TransactionI trans, T t) throws InternalServiceException {
        try {
            provider.get().delete(trans, t);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
