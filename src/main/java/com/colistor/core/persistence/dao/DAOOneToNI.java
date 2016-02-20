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

import persistence.exception.DAOException;
import persistence.model.OneToN;
import persistence.transaction.TransactionI;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface DAOInterfaceOneToN.
 *
 * @param <T> the generic type
 * @param <U> the generic type
 */
public interface DAOOneToNI<T, U> {

    /**
     * Find by criteria.
     *
     * @param trans the trans
     * @param query the query
     * @param objs  the objs
     * @return the one to n
     * @throws DAOException the DAO exception
     */
    public OneToN<T, U> findByCriteria(TransactionI trans,
                                       String query, Object... objs) throws DAOException;

    /**
     * Find list by criteria.
     *
     * @param trans the trans
     * @param query the query
     * @param objs  the objs
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<OneToN<T, U>> findListByCriteria(TransactionI trans,
                                                 String query, Object... objs) throws DAOException;

    /**
     * Find by criterion.
     *
     * @param trans the trans
     * @param query the query
     * @param objs  the objs
     * @return the one to n
     * @throws DAOException the DAO exception
     */
    public OneToN<T, U> findByCriterion(TransactionI trans,
                                        String query, Object objs) throws DAOException;

    /**
     * Find list by criterion.
     *
     * @param trans the trans
     * @param query the query
     * @param objs  the objs
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<OneToN<T, U>> findListByCriterion(TransactionI trans,
                                                  String query, Object objs) throws DAOException;
}
