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
