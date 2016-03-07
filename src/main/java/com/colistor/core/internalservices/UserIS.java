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

import com.colistor.core.persistence.model.User;
import com.colistor.core.persistence.transaction.TransactionI;
import com.colistor.core.services.exception.ServiceException;

public class UserIS implements UserISI {

    @Override
    public User login(TransactionI trans, String email, String password) throws ServiceException {
        return null;
    }

    @Override
    public User register(TransactionI trans, User user) throws ServiceException {
        return null;
    }

    @Override
    public User modify(TransactionI trans, User currentUser, User newData) throws ServiceException {
        return null;
    }

    @Override
    public void deleteAccount(TransactionI trans, User user) throws ServiceException {

    }
}
