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

import com.rethinkdb.model.MapObject;

import java.util.Map;

/**
 * Data mapping for the DAO from and to the database.
 */
public class DAOMapping {

    /**
     * Gets the fields of a data model object that are necessary for an insert.
     * It includes the code and the usercode.
     *
     * @param t   The data model object
     * @param <T> The type of the data model object
     * @return Map containing the database fields (String) and their values (Object)
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> getFieldsOnInsert(T t) throws IllegalAccessException {
        Map<String, Object> fields = new MapObject();
        Field fieldAnno = null;
        Code code = null;
        User userCode = null;
        for (java.lang.reflect.Field field : t.getClass().getFields()) {
            if (field.isAnnotationPresent(Field.class)) {
                fieldAnno = field.getAnnotationsByType(Field.class)[0];
                if (fieldAnno.insert()) {
                    put(fields, fieldAnno, field, t);
                }
            } else if (field.isAnnotationPresent(Code.class)) {
                code = field.getAnnotationsByType(Code.class)[0];
                fields.put(code.field(), field.get(t));
            } else if (field.isAnnotationPresent(User.class)) {
                userCode = field.getAnnotationsByType(User.class)[0];
                fields.put(userCode.field(), field.get(t));
            }
        }
        return fields;
    }

    /**
     * Gets the fields of a data model object that are necessary for an update.
     *
     * @param t   The data model object
     * @param <T> The type of the data model object
     * @return Map containing the database fields (String) and their values (Object)
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> getFieldsOnUpdate(T t) throws IllegalAccessException {
        Map<String, Object> fields = new MapObject();
        Field fieldAnno = null;
        for (java.lang.reflect.Field field : t.getClass().getFields()) {
            if (field.isAnnotationPresent(Field.class)) {
                fieldAnno = field.getAnnotationsByType(Field.class)[0];
                if (fieldAnno.update()) {
                    put(fields, fieldAnno, field, t);
                }
            }
        }
        return fields;
    }

    /**
     * Maps from the database to a data model object.
     *
     * @param data The map that is the result from the database.
     * @param t    The data model object to map to.
     * @param <T>  The type of data model object.
     * @return The data model object mapped.
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public static <T> T mapFromDB(Map<String, Object> data, T t) throws IllegalAccessException, NoSuchFieldException {
        java.lang.reflect.Field field;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if ((field = AccessAnnotation.getFieldByDBFieldName(t, entry.getKey())) != null) {
                field.set(t, entry.getValue());
            } else if ((field = AccessAnnotation.getField(t, PrimaryKey.class)) != null && field.getAnnotationsByType(PrimaryKey.class)[0].field().equals(entry.getKey())) {
                field.set(t, entry.getValue());
            } else if ((field = AccessAnnotation.getField(t, Code.class)) != null && field.getAnnotationsByType(Code.class)[0].field().equals(entry.getKey())) {
                field.set(t, entry.getValue());
            } else if ((field = AccessAnnotation.getField(t, User.class)) != null && field.getAnnotationsByType(User.class)[0].field().equals(entry.getKey())) {
                field.set(t, entry.getValue());
            }
        }
        return t;
    }

    /**
     * Puts the values of a data model object fields to the map with the correct database field names.
     *
     * @param fields     The map with the database field names (String) and the data model object values (Object) that can be given to the database.
     * @param annotation The annotation Field that contains the info for the mapping.
     * @param field      The field to handle of the data model object.
     * @param t          The data model object
     * @param <T>        The type of the data model object
     * @throws IllegalAccessException
     */
    private static <T> void put(Map<String, Object> fields, Field annotation, java.lang.reflect.Field field, T t) throws IllegalAccessException {
        if (field.getType() == String.class) {
            String value = (String) field.get(t);
            if (value != null) {
                fields.put(annotation.name(), value);
            }
        } else if (field.getType() == int.class) {
            fields.put(annotation.name(), field.getInt(t));
        } else if (field.getType() == float.class) {
            fields.put(annotation.name(), field.getFloat(t));
        }
    }
}
