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

import com.colistor.core.persistence.model.User;
import com.colistor.core.persistence.transaction.TransactionI;
import com.nitorcreations.junit.runners.NestedRunner;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(NestedRunner.class)
public class CommonDAOTest {

    RethinkDB r = RethinkDB.r;
    Connection conn;
    TransactionI trans;

    @Before
    public void setUp() throws Exception {
        conn = r.connection()
                .hostname("localhost").port(28015).connect();
        trans = new TransactionI() {
            @Override
            public Connection getConnection() {
                return conn;
            }

            @Override
            public void endOfRequest() {

            }

            @Override
            public void commit() {

            }

            @Override
            public void rollback() {

            }
        };
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public class TestInsert {

        CommonDAO<User> dao;

        @Before
        public void setInsert() throws Exception {
            dao = new CommonDAO<User>();

        }

        @Test
        public void testRegularInsert() throws Exception {
            User user = new User();
            user.code = "codeTestUser1";
            user.email = "joe.dalton@example.com";
            user.fullName = "Joe Dalton";
            user.lang = "fr";
            user.password = "IHateLuckyLuke";
            user.salt = "saltforpaswd";

            User res = dao.insert(trans, user);
            assertNull(res.id);
        }
    }

    public class TestUpdate {
        @Test
        public void testUpdate() throws Exception {

        }
    }

    public class TestDelete {
        @Test
        public void testDelete() throws Exception {

        }
    }
}