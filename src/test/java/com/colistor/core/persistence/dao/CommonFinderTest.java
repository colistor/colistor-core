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

import com.colistor.core.persistence.model.Drawer;
import com.colistor.core.persistence.model.User;
import com.colistor.core.persistence.transaction.TransactionI;
import com.google.inject.*;
import com.nitorcreations.junit.runners.NestedRunner;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(NestedRunner.class)
public class CommonFinderTest {

    RethinkDB r = RethinkDB.r;
    Connection conn;
    TransactionI trans;
    User user;
    Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(new TypeLiteral<FindI<User>>() {
            }).to(new TypeLiteral<CommonFinder<User>>() {
            });

            bind(new TypeLiteral<FindI<Drawer>>() {
            }).to(new TypeLiteral<CommonFinder<Drawer>>() {
            });

            bind(new TypeLiteral<DAOI<User>>() {
            }).to(new TypeLiteral<CommonDAO<User>>() {
            });

            bind(new TypeLiteral<DAOI<Drawer>>() {
            }).to(new TypeLiteral<CommonDAO<Drawer>>() {
            });
        }
    });

    @Inject
    FindI<User> userFinder;
    @Inject
    FindI<Drawer> drawerFinder;
    @Inject
    DAOI<Drawer> drawerDAO;

    @Before
    public void setUp() throws Exception {
        injector.injectMembers(this);

        conn = r.connection()
                .hostname("localhost").port(28015).db("colistor").connect();

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

        r.table("drawer").delete().run(trans.getConnection());

        user = new User();
        user.id = "bc53be98-49cf-4129-8266-621129edb9f3";
        user.code = "codeTestUser1";
        /*user.email="joe.dalton@example.com";
        user.fullName="Joe Dalton";
        user.lang="fr";
        user.password="IHateLuckyLuke";
        user.salt="saltforpaswd";*/
    }

    @After
    public void tearDown() throws Exception {
        r.table("drawer").delete().run(trans.getConnection());
        conn.close();
    }

    public class FindById {

        @Before
        public void setUpFindById() throws Exception {
            //finder = new CommonFinder<>();
        }

        @Test
        public void testFindById() throws Exception {
            User res = userFinder.findById(trans, user.id);
            assertEquals(user.code, res.code);
        }
    }

    public class FindByCode {


        @Before
        public void setUpFindByCode() throws Exception {
            //finder = new CommonFinder<>();
        }

        @Test
        public void testFindByCode() throws Exception {
            User res = userFinder.findByCode(trans, user.code);
            assertEquals(user.id, res.id);
        }
    }

    public class FindByUserCodeOrPublic {


        Drawer drawer1;
        Drawer drawer2;
        Drawer drawer3;

        @Before
        public void setUpFindByCode() throws Exception {

            drawer1 = new Drawer();
            drawer1.code = "drawer1";
            drawer1.userCode = "user1";
            drawer1.title = "Drawer 1";
            drawer1.description = "Description 1";
            drawerDAO.insert(trans, drawer1);

            drawer2 = new Drawer();
            drawer2.code = "drawer2";
            drawer2.userCode = "public";
            drawer2.title = "Drawer 2";
            drawer2.description = "Description 2";
            drawerDAO.insert(trans, drawer2);

            drawer3 = new Drawer();
            drawer3.code = "drawer3";
            drawer3.userCode = "user3";
            drawer3.title = "Drawer 3";
            drawer3.description = "Description 3";
            drawerDAO.insert(trans, drawer3);
        }

        @Test
        public void testFindByUserCodeOrPublic() throws Exception {
            List<Drawer> drawers = drawerFinder.findByUserCodeOrPublic(trans, drawer1.userCode);
            assertEquals(2, drawers.size());
            assertEquals("drawer1", drawers.get(0).code);
            assertEquals("drawer2", drawers.get(1).code);
        }


    }
}