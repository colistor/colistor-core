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

package com.colistor.core.services;

import com.colistor.core.persistence.model.Item;
import com.colistor.core.persistence.model.List;
import com.colistor.core.services.exception.ServiceException;

/**
 * Gives the capacity to manipulate the content of a list. Basically adding, getting and removing items.
 *
 * @see com.colistor.core.persistence.model.List
 */
public interface ListManagerSI {

    /**
     * Adding items to a list
     *
     * @param userCode  The code of the User, needed to verify the grant over the list.
     * @param listCode  The code of the List to add the items to.
     * @param itemCodes The codes of the Items that will be added to the list
     * @return The List referred by listCode
     * @throws ServiceException It will be thrown if the parameters are not correct or if something else happens
     * @see com.colistor.core.persistence.model.User
     * @see com.colistor.core.persistence.model.List
     * @see com.colistor.core.persistence.model.Item
     */
    List addItems(String userCode, String listCode, String... itemCodes) throws ServiceException;

    /**
     * Getting the items contained by a List
     *
     * @param userCode The code of the User, needed to verify the grant over the list.
     * @param listCode The code of the List to get the items from.
     * @param offset   The position of the first element that will be returned
     * @param limit    The number of items returned
     * @param asc      The order of the list, true=ascendant, false=descendant
     * @return The items If the List is empty it will return an empty java.util.List<Item>
     * @throws ServiceException It will be thrown if the parameters are not correct or if something else happens
     * @see com.colistor.core.persistence.model.User
     * @see com.colistor.core.persistence.model.List
     */
    java.util.List<Item> getItems(String userCode, String listCode, int offset, int limit, boolean asc) throws ServiceException;

    /**
     * Removing items from a list. This will not delete the items, just the references to the list.
     *
     * @param userCode  The code of the User, needed to verify the grant over the list.
     * @param listCode  The code of the List to remove the items to.
     * @param itemCodes The codes of the Items that will be removed from the list
     * @return The List referred by listCode
     * @throws ServiceException It will be thrown if the parameters are not correct or if something else happens
     * @see com.colistor.core.persistence.model.User
     * @see com.colistor.core.persistence.model.List
     * @see com.colistor.core.persistence.model.Item
     */
    List removeItems(String userCode, String listCode, String... itemCodes) throws ServiceException;
}
