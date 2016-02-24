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

import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.transaction.TransactionI;

/*
*The data access object interface gives the methods to write the data into the persistence system.
* Inserting, modifying, and deleting are common to all objects.
* However, reading is specific for each object (find by id, or all with/without criteria), therefore,
* it is not part of this interface.
 */
public interface DAOI<T> {

    /**
     * Insert.
     *
     * @param trans the transaction
     * @param t     the object to insert
     * @return the inserted version of the object t
     * @throws DAOException the DAO exception
     */
    T insert(TransactionI trans, T t) throws DAOException;

    /**
     * Modify.
     *
     * @param trans the transaction
     * @param t     the object, it must contain the id, the remaining and the new values.
     * @return the updated version of the object t
     * @throws DAOException the DAO exception
     */
    T update(TransactionI trans, T t) throws DAOException;

    /**
     * Erase.
     *
     * @param trans the transaction
     * @param t     the object to delete, it must contain the id.
     * @throws DAOException the DAO exception
     */
    void delete(TransactionI trans, T t) throws DAOException;

}
