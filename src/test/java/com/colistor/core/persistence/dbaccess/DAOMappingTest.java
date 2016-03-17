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

import com.colistor.core.persistence.model.Drawer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DAOMappingTest {
    Drawer drawer1;
    Drawer drawer2;
    Drawer drawer3;

    @Before
    public void setUp() throws Exception {
        drawer1 = new Drawer();
        drawer1.id = "id1";
        drawer1.code = "drawer1";
        drawer1.userCode = "user1";
        drawer1.title = "Drawer 1";
        drawer1.description = "Description 1";

        drawer2 = new Drawer();
        drawer1.id = "id2";
        drawer2.code = "drawer2";
        drawer2.userCode = "public";
        drawer2.title = "Drawer 2";
        drawer2.description = "Description 2";

        drawer3 = new Drawer();
        drawer1.id = "id3";
        drawer3.code = "drawer3";
        drawer3.userCode = "user3";
        drawer3.title = "Drawer 3";
        drawer3.description = "Description 3";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetFieldsOnInsert() throws Exception {
        Map<String, Object> map = DAOMapping.getFieldsOnInsert(drawer1);
        assertEquals(4, map.size());
        assertEquals(drawer1.code, map.get("code"));
        assertEquals(drawer1.userCode, map.get("usercode"));
        assertEquals(drawer1.title, map.get("title"));
        assertEquals(drawer1.description, map.get("description"));
    }

    @Test
    public void testGetFieldsOnUpdate() throws Exception {
        Map<String, Object> map = DAOMapping.getFieldsOnUpdate(drawer1);
        assertEquals(2, map.size());
        assertEquals(drawer1.title, map.get("title"));
        assertEquals(drawer1.description, map.get("description"));
    }

    @Test
    public void testMapFromDB() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", drawer1.id);
        map.put("code", drawer1.code);
        map.put("usercode", drawer1.userCode);
        map.put("title", drawer1.title);
        map.put("description", drawer1.description);

        Drawer dTmp = new Drawer();
        dTmp = DAOMapping.mapFromDB(map, dTmp);
        assertEquals(drawer1.id, dTmp.id);
        assertEquals(drawer1.code, dTmp.code);
        assertEquals(drawer1.userCode, dTmp.userCode);
        assertEquals(drawer1.title, dTmp.title);
        assertEquals(drawer1.description, dTmp.description);
    }
}