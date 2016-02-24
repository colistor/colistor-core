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

package com.colistor.core.services.controller;

import com.colistor.core.services.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Controller.
 *
 * @param <T> the generic type
 */
public abstract class Controller<T> {

    /**
     * The exceptions.
     */
    private List<RaisedException> exceptions;

    /**
     * Instantiates a new controller.
     */
    public Controller() {
        exceptions = new ArrayList<RaisedException>();
    }

    /**
     * Default controller.
     *
     * @param t the t
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    protected abstract boolean defaultController(T t) throws ServiceException;

    /**
     * On insert.
     *
     * @param t the t
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean onInsert(T t) throws ServiceException {
        return defaultController(t);
    }

    /**
     * On update.
     *
     * @param t the t
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean onUpdate(T t) throws ServiceException {
        return defaultController(t);
    }

    /**
     * On delete.
     *
     * @param t the t
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean onDelete(T t) throws ServiceException {
        return defaultController(t);
    }

    /**
     * Adds the exception.
     *
     * @param exception the exception
     */
    public final void addException(RaisedException exception) {
        exceptions.add(exception);
    }

    /**
     * Gets the exceptions.
     *
     * @return the exceptions
     */
    public final RaisedException[] getExceptions() {
        return exceptions.toArray(new RaisedException[exceptions.size()]);
    }

    /**
     * Checks for exception.
     *
     * @return true, if successful
     */
    public final boolean hasException() {
        return !exceptions.isEmpty();
    }
}
