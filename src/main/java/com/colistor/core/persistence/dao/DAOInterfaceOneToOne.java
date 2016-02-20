package com.colistor.core.persistence.dao;

import persistence.exception.DAOException;
import persistence.model.OneToOne;
import persistence.transaction.TransactionI;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface DAOInterfaceOneToOne.
 *
 * @param <T> the generic type
 * @param <U> the generic type
 */
public interface DAOInterfaceOneToOne<T, U> {

    /**
     * Find by criteria.
     *
     * @param trans the trans
     * @param query the query
     * @param objs  the objs
     * @return the one to one
     * @throws DAOException the DAO exception
     */
    public OneToOne<T, U> findByCriteria(TransactionI trans,
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
    public List<OneToOne<T, U>> findListByCriteria(TransactionI trans,
                                                   String query, Object... objs) throws DAOException;

    /**
     * Find by criterion.
     *
     * @param trans the trans
     * @param query the query
     * @param objs  the objs
     * @return the one to one
     * @throws DAOException the DAO exception
     */
    public OneToOne<T, U> findByCriterion(TransactionI trans,
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
    public List<OneToOne<T, U>> findListByCriterion(TransactionI trans,
                                                    String query, Object objs) throws DAOException;
}
