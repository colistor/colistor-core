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
import com.colistor.core.persistence.model.Filter;
import com.colistor.core.persistence.model.OneToOne;
import com.colistor.core.persistence.transaction.TransactionI;

import java.util.List;

/**
 * Specifies different manners to retrieve the data from the database.
 *
 * @param <T> The data model object to map to from the database.
 */
public interface FindI<T> {

    /**
     * Finds an entry in the database by its id.
     *
     * @param trans The Transaction which provides the connection.
     * @param id    The id of the entry to retrieve
     * @return The data model object mapped from the database
     * @throws DAOException
     */
    T findById(TransactionI trans, String id) throws DAOException;

    /**
     * Finds an entry in the database by its code
     *
     * @param trans The Transaction which provides the connection.
     * @param code  The code of the entry to retrieve
     * @return The data model object mapped from the database
     * @throws DAOException
     */
    T findByCode(TransactionI trans, String code) throws DAOException;

    /**
     * Finds every entry that is matching the usercode (owner)
     *
     * @param trans    The Transaction which provides the connection.
     * @param userCode The usercode (owner) of the entry to retrieve
     * @param filter   Apply a filter to the query. The criteria are skipped.
     *                 Only the "order by" and the "limit" are applied
     * @return A list of data model objects mapped form the database
     * @throws DAOException
     */
    List<T> findByUserCode(TransactionI trans, String userCode, Filter filter) throws DAOException;

    List<T> findByFilter(TransactionI trans, Filter filter) throws DAOException;

    <U> List<OneToOne<T, U>> eqjoinWithSons(TransactionI trans, Filter filter, Class<U> son) throws DAOException;

    <U> OneToOne<T, U> eqjoinWithSon(TransactionI trans, Filter filter, Class<U> son) throws DAOException;
}
