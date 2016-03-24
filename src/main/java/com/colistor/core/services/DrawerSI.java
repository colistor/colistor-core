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

import com.colistor.core.persistence.model.Drawer;
import com.colistor.core.persistence.model.Filter;
import com.colistor.core.persistence.model.Share;
import com.colistor.core.services.exception.ServiceException;

import java.util.List;

/**
 * Manages the drawers
 */
public interface DrawerSI {

    /**
     * Adds a new drawer
     *
     * @param userCode The user that will own the drawer
     * @param drawer   The values of the new drawer. The id and the code are not needed, it will be generated.
     * @return The new drawer with the code.
     * @throws ServiceException
     */
    Drawer add(String userCode, Drawer drawer) throws ServiceException;

    /**
     * Modifies a drawer.
     *
     * @param userCode   The user code to make sure that this is the owner of the drawer.
     * @param drawerCode The code of the drawer to modify
     * @param drawer     The new values including the values that have not been modified.
     * @return The Drawer with the new values.
     * @throws ServiceException
     */
    Drawer modify(String userCode, String drawerCode, Drawer drawer) throws ServiceException;

    /**
     * Deletes a drawer and all its content except the Items.
     *
     * @param userCode   The user code to verify that it is the owner of the drawer.
     * @param drawerCode The code of the drawer to delete
     * @throws ServiceException
     */
    void delete(String userCode, String drawerCode) throws ServiceException;

    /**
     * Retrieves all the drawers that the specified user can see (including shared). The selection can be filtered.
     *
     * @param userCode The user code to make sure to select only the drawers that the user is allowed to see
     * @param filter   Not mandatory, applying a filter to the selection
     * @return A list of drawers corresponding to the criteria
     * @throws ServiceException
     */
    List<Drawer> find(String userCode, Filter filter) throws ServiceException;

    /**
     * Shares the drawer with another user.
     *
     * @param ownerUserCode   The owner of the drawer.
     * @param grantedUserCode The user to share the drawer with.
     * @param drawerCode      The drawer to share.
     * @param share           The values
     * @return
     * @throws ServiceException
     */
    Share share(String ownerUserCode, String grantedUserCode, String drawerCode, Share share) throws ServiceException;

    /**
     * Modifies a share. Can only modify the permissions.
     *
     * @param userCode   The user code to make sure that the user is the owner
     * @param drawerCode The code of the drawer that is shared
     * @param position   The position of the share in the drawer
     * @param share      The new values including the values that have not been modified.
     * @return The share with the new values.
     * @throws ServiceException
     */
    Share modifyShare(String userCode, String drawerCode, int position, Share share) throws ServiceException;

    /**
     * Deletes a share.
     *
     * @param userCode   The user code to make sure that the user is the owner.
     * @param drawerCode The code of the drawer that is shaed.
     * @param position   The position of the share in the drawer
     * @throws ServiceException
     */
    void deleteShare(String userCode, String drawerCode, int position) throws ServiceException;
}
