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

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Helps access the variables of the data model objects through annotations.
 */
public class AccessAnnotation {

    /**
     * Gets the entity name of a model object based on the Entity annotation
     *
     * @param obj the data model.
     * @return the name of the entity or null if it is not set.
     */
    public static String getEntity(Object obj) {
        Annotation[] annotations = obj.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Entity) {
                return ((Entity) annotation).name();
            }
        }
        return null;
    }

    /**
     * Sets the code to a data model object
     *
     * @param obj  The data model.
     * @param code The code to affect to the object
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void setCode(Object obj, String code) throws NoSuchFieldException, IllegalAccessException {
        getField(obj, Code.class).set(obj, code);
    }

    /**
     * Get the code of a data model object
     *
     * @param obj The data model object
     * @return The code
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static String getCode(Object obj) throws NoSuchFieldException, IllegalAccessException {
        return (String) getField(obj, Code.class).get(obj);
    }

    public static String getCodeFieldName(Object obj) {
        return getField(obj, Code.class).getAnnotationsByType(Code.class)[0].field();
    }

    public static void setId(Object obj, String id) throws NoSuchFieldException, IllegalAccessException {
        getField(obj, PrimaryKey.class).set(obj, id);
    }

    public static String getId(Object obj) throws NoSuchFieldException, IllegalAccessException {
        return (String) getField(obj, PrimaryKey.class).get(obj);
    }

    public static String getUserCode(Object obj) throws IllegalAccessException {
        return (String) getField(obj, User.class).get(obj);
    }

    public static void setUserCode(Object obj, String userCode) throws NoSuchFieldException, IllegalAccessException {
        getField(obj, User.class).set(obj, userCode);
    }

    public static String getUserCodeFieldName(Object obj) {
        return getField(obj, User.class).getAnnotationsByType(User.class)[0].field();
    }

    public static java.lang.reflect.Field getField(Object obj, Class<? extends Annotation> annotation) {
        for (java.lang.reflect.Field field : obj.getClass().getFields()) {
            if (field.isAnnotationPresent(annotation)) {
                return field;
            }
        }
        return null;
    }

    public static List<java.lang.reflect.Field> getFields(Object obj, Class<? extends Annotation> annotation) {
        List<java.lang.reflect.Field> fields = new ArrayList<>();
        for (java.lang.reflect.Field field : obj.getClass().getFields()) {
            if (field.isAnnotationPresent(annotation)) {
                fields.add(field);
            }
        }
        return fields;
    }

    public static Sharable getShareable(Class clazz) {
        return (Sharable) getClassAnnotation(clazz, Sharable.class);
    }

    public static Annotation getClassAnnotation(Class clazz, Class<? extends Annotation> annotation) {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annoTmp : annotations) {
            if (annoTmp instanceof Annotation) {
                return annoTmp;
            }
        }
        return null;
    }

    public static java.lang.reflect.Field getFieldByDBFieldName(Object obj, String dbFieldName) {
        for (java.lang.reflect.Field field : obj.getClass().getFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annoTmp : annotations) {
                if (annoTmp instanceof Field && ((Field) annoTmp).name().equals(dbFieldName)) {
                    return field;
                }
            }
        }
        return null;
    }
}
