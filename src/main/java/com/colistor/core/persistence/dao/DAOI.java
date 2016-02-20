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
import persistence.transaction.TransactionI;

// TODO: Auto-generated Javadoc

/**
 * Interface for DAO classes with the basics functions.
 *
 * @param <T> the generic type
 * @author Joël Favre
 */
public interface DAOI<T> {

    /**
     * Insert.
     *
     * @param trans the trans
     * @param t     the t
     * @return the t
     * @throws DAOException the DAO exception
     */
    public T insert(TransactionI trans, T t) throws DAOException;

    /**
     * Modify.
     *
     * @param trans the trans
     * @param t     the t
     * @return the t
     * @throws DAOException the DAO exception
     */
    public T modify(TransactionI trans, T t) throws DAOException;

    /**
     * Erase.
     *
     * @param trans the trans
     * @param t     the t
     * @throws DAOException the DAO exception
     */
    public void erase(TransactionI trans, T t) throws DAOException;

	/*public T findById(TransactionInterface trans, String id)
            throws DAOException;

	public T findByCriteria(TransactionInterface trans, String query,
			Object... objs) throws DAOException;

	public List<T> findListByCriteria(TransactionInterface trans, String query,
			Object... objs) throws DAOException;

	public T findByCriterion(TransactionInterface trans, String query,
			Object objs) throws DAOException;

	public List<T> findListByCriterion(TransactionInterface trans,
			String query, Object objs) throws DAOException;

	public long count(TransactionInterface trans, String query, T t)
			throws DAOException;*/
}
