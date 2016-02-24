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

import com.google.inject.Inject;
import persistence.factory.DBConnection;
import persistence.factory.PoolDBConnection;

import java.sql.Connection;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc

/**
 * Establish a connection to the Database without transaction mode. That means
 * only select queries can use this mode.
 *
 * @author Joël Favre
 */
public class NoTransaction implements TransactionI {

    /**
     * The pool db connection.
     */
    private final PoolDBConnection poolDBConnection;

    /**
     * The db connection.
     */
    private DBConnection dbConnection;

    /**
     * Need the pool of connection to works.
     *
     * @param poolDBConnection the pool db connection
     */
    @Inject
    public NoTransaction(PoolDBConnection poolDBConnection) {
        this.poolDBConnection = poolDBConnection;
        dbConnection = null;
    }

    /**
     * At the first time a connection to the database is obtained with the pool
     * and start the no transaction mode. Each time this function is called, the
     * same connection is given with the no transaction mode set. You can call
     * this method multiple time but with no transaction your should not execute
     * more than one request
     *
     * @return the connection
     */
    @Override
    public Connection getConnection() {
        if (dbConnection == null) {
            Connection connection = null;
            try {
                connection = (dbConnection = poolDBConnection.get())
                        .getConnection();

                connection.setAutoCommit(true);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return connection;
        } else {
            try {
                return dbConnection.getConnection();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * After a request with no transaction it is the end of the transaction so
     * the connection is given back.
     */
    @Override
    public void endOfRequest() {
        giveBack();
    }

    /**
     * Nothing to do with no transaction.
     */
    @Override
    public void commit() {
    }

    /**
     * Nothing to do with no transaction.
     */
    @Override
    public void rollback() {
    }

    /**
     * Give the connection back to the pool of connection.
     */
    private void giveBack() {
        if (dbConnection != null) {
            poolDBConnection.giveBack(dbConnection);
            dbConnection = null;
        }
    }

}
