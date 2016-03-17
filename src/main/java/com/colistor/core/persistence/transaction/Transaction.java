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

package com.colistor.core.persistence.transaction;

import com.colistor.core.persistence.dbaccess.DBConnection;
import com.colistor.core.persistence.dbaccess.PoolDBConnection;
import com.google.inject.Inject;
import com.rethinkdb.net.Connection;


// TODO: Auto-generated Javadoc

/**
 * The Class Transaction.
 */
public class Transaction implements TransactionI {

    /**
     * The pool db connection.
     */
    private final PoolDBConnection poolDBConnection;

    /**
     * The db connection.
     */
    private DBConnection dbConnection;

    /**
     * Instantiates a new transaction.
     *
     * @param poolDBConnection the pool db connection
     */
    @Inject
    public Transaction(PoolDBConnection poolDBConnection) {
        this.poolDBConnection = poolDBConnection;
    }

    /* (non-Javadoc)
     * @see persistence.transaction.TransactionInterface#getConnection()
     */
    public Connection getConnection() {
        return getDBConncetion().getConn();
    }

    /* (non-Javadoc)
     * @see persistence.transaction.TransactionInterface#endOfRequest()
     */
    @Override
    public void endOfRequest() {

    }

    /* (non-Javadoc)
     * @see persistence.transaction.TransactionInterface#commit()
     */
    @Override
    public void commit() {
        if (dbConnection != null) {
            //dbConnection.getConn();
        }
        giveBack();
    }

    /* (non-Javadoc)
     * @see persistence.transaction.TransactionInterface#rollback()
     */
    @Override
    public void rollback() {
        if (dbConnection != null) {
            //dbConnection.getConn();
        }
        giveBack();
    }

    /**
     * Give back.
     */
    private void giveBack() {
        if (dbConnection != null) {
            poolDBConnection.giveBack(dbConnection);
            dbConnection = null;
        }
    }

    /**
     * Gets the DB conncetion.
     *
     * @return the DB conncetion
     */
    private DBConnection getDBConncetion() {
        if (dbConnection == null) {
            dbConnection = poolDBConnection.get();

            dbConnection.getConn();

        }
        return dbConnection;
    }
}
