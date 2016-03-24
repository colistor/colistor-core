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
package com.colistor.core.services;

import com.colistor.core.internalservices.CommonISI;
import com.colistor.core.internalservices.exception.InternalServiceException;
import com.colistor.core.persistence.annotation.Transaction;
import com.colistor.core.persistence.model.Filter;
import com.colistor.core.persistence.transaction.TransactionI;
import com.colistor.core.services.exception.ServiceException;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;

import java.util.List;

public class CommonS<T> implements CommonSI<T> {

    private final Provider<TransactionI> transProvider;

    @Inject
    private Provider<CommonISI<T>> providerIS;

    @Inject
    public CommonS(@Transaction Provider<TransactionI> transProvider) {
        this.transProvider = transProvider;
    }

    @Override
    public T add(String userCode, T t) throws ServiceException {
        isWithoutViolations(t, "s_i", "i");
        TransactionI trans = transProvider.get();
        T ret = null;
        boolean commit = false;
        try {
            ret = providerIS.get().add(trans, t);
            commit = true;
        } catch (InternalServiceException e) {

        } finally {
            if (commit) {
                trans.commit();
            } else {
                trans.rollback();
            }
        }
        return ret;
    }

    @Override
    public T modify(String userCode, String tCode, T t) throws ServiceException {
        isWithoutViolations(t, "s_u", "u");
        TransactionI trans = transProvider.get();
        T ret = null;
        boolean commit = false;
        try {
            ret = providerIS.get().modify(trans, t);
            commit = true;
        } catch (InternalServiceException e) {

        } finally {
            if (commit) {
                trans.commit();
            } else {
                trans.rollback();
            }
        }
        return ret;
    }

    @Override
    public T delete(String userCode, String tCode) throws ServiceException {
        if (tCode == null || tCode.equals("")) {
            throw new ServiceException(null);
        }
        return null;
    }

    @Override
    public T findByCode(String userCode, String tCode) throws ServiceException {
        if (tCode == null || tCode.equals("")) {
            throw new ServiceException(null);
        }
        return null;
    }

    @Override
    public List<T> findByUserCode(String userCode, Filter filter) throws ServiceException {
        if (userCode == null || userCode.equals("")) {
            throw new ServiceException(null);
        }
        return null;
    }

    private boolean isWithoutViolations(T t, String... profiles) throws ServiceException {
        Vtor vtor = new Vtor();
        vtor.useProfiles(profiles);
        vtor.validate(t);
        if (vtor.hasViolations()) {
            for (Violation violation : vtor.getViolations()) {
                //violation.
            }
            throw new ServiceException(null);
        }
        return false;
    }
}
