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

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class DBConnection {

    private RethinkDB r;

    private Connection conn;

    public DBConnection() {
        establishConnection();
    }

    public RethinkDB getR() {
        if (r == null || conn == null) {
            establishConnection();
        }

        return r;
    }

    public Connection getConn() {
        if (r == null || conn == null) {
            establishConnection();
        }
        return conn;
    }

    private void establishConnection() {
        r = RethinkDB.r;
        conn = r.connection()
                .hostname("localhost").port(28015).connect();
    }
}
