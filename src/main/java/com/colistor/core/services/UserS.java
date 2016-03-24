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

import com.colistor.core.internalservices.MailerIS;
import com.colistor.core.internalservices.MailerISI;
import com.colistor.core.internalservices.UserISI;
import com.colistor.core.internalservices.exception.InternalServiceException;
import com.colistor.core.persistence.annotation.Transaction;
import com.colistor.core.persistence.model.User;
import com.colistor.core.persistence.transaction.TransactionI;
import com.colistor.core.services.exception.ServiceException;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.HashMap;

/**
 * Services for a User (authentication, registering, modifying, deleting)
 */
public class UserS implements UserSI {

    private final Provider<TransactionI> transProvider;
    @Inject
    private Provider<UserISI> userIS;
    @Inject
    private Provider<MailerISI> mailerIS;

    @Inject
    public UserS(@Transaction Provider<TransactionI> transProvider) {
        this.transProvider = transProvider;
    }

    /**
     * @param email    The email address of the User
     * @param password The password of the User
     * @return
     * @throws ServiceException
     */
    @Override
    public User authenticate(String email, String password) throws ServiceException {
        TransactionI trans = transProvider.get();
        User userRet = null;
        boolean commit = false;
        try {
            userRet = userIS.get().login(trans, email, password);
            commit = true;
        } finally {
            if (commit) {
                trans.commit();
            } else {
                trans.rollback();
            }
        }
        return userRet;
    }

    @Override
    public User register(User user) throws ServiceException {
        TransactionI trans = transProvider.get();
        User userRet = null;
        boolean commit = false;
        try {
            userRet = userIS.get().register(trans, user);
            mailerIS.get().sendEmail(MailerIS.Template.REGISTERING_USER.getTemplate(),
                    userRet.lang, new HashMap<String, String>(), userRet.email);
            commit = true;
        } catch (InternalServiceException e) {
            e.printStackTrace();
        } finally {
            if (commit) {
                trans.commit();
            } else {
                trans.rollback();
            }
        }
        return userRet;
    }

    @Override
    public User modify(String userCode, User user) throws ServiceException {
        return null;
    }

    @Override
    public User getUser(String userCode) throws ServiceException {
        return null;
    }

    @Override
    public void deleteAccount(String userCode) throws ServiceException {

    }
}
