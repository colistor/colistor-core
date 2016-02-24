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
package com.colistor.core.persistence.dao.user;

import com.colistor.core.persistence.dao.DAOI;
import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.model.User;
import com.colistor.core.persistence.transaction.TransactionI;

public class UserDAO implements DAOI<User> {
    @Override
    public User insert(TransactionI trans, User user) throws DAOException {
        return null;
    }

    @Override
    public User update(TransactionI trans, User user) throws DAOException {
        return null;
    }

    @Override
    public void delete(TransactionI trans, User user) throws DAOException {

    }
}
