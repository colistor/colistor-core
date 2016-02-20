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
