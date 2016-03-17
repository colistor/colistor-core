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
package com.colistor.core.persistence.dbaccess;

import com.google.inject.Provider;
import com.google.inject.Singleton;

import java.util.LinkedList;

@Singleton
public class PoolDBConnection implements Provider<DBConnection> {

    public static final int NB_CONNECTIONS = 15;

    /**
     * The connections.
     */
    private LinkedList<DBConnection> connections;

    /**
     * The stop.
     */
    private boolean stop;

    /**
     * Instantiates a new pool db connection.
     */
    public PoolDBConnection() {
        connections = new LinkedList<DBConnection>();
        stop = false;
        manageValidity();
    }

    /**
     * Provide a connection a free connection (a connection in the pool) or a
     * new connection.
     *
     * @return the DB connection
     */
    @Override
    public synchronized DBConnection get() {
        DBConnection connection = null;
        while (connection == null && !connections.isEmpty()) {
            connection = connections.pollFirst();
        }
        if (connection == null) {
            connection = new DBConnection();
        }
        return connection;
    }

    /**
     * Put the connection back in the pool when a request/transaction is ended.
     *
     * @param connection the connection
     */
    public synchronized void giveBack(DBConnection connection) {
        if (connections.size() < NB_CONNECTIONS) {
            connections.addLast(connection);
        } else {
            connection.getConn().close();
        }
    }

    /**
     * Manage validity.
     */
    private void manageValidity() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                DBConnection connection = null;
                while (!stop) {
                    if (!connections.isEmpty()) {
                        connection = get();
                        connection.getConn().close();
                        (connection = new DBConnection()).getConn();
                        giveBack(connection);
                    }
                    try {
                        sleep(60000);
                    } catch (InterruptedException e) {
                        /*Logger.getLogger(DAOException.class).log(Level.ERROR,
                                DAOException.INTERNAL_ERROR, e);*/
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#finalize()
     */
    @Override
    protected void finalize() {
        stop = true;
    }
}
