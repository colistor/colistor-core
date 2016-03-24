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

import com.colistor.core.persistence.model.Comment;
import com.colistor.core.services.exception.ServiceException;

import java.util.List;

/**
 * The services available for commenting on a Drawer
 */
public interface CommentSI {

    /**
     * Posts a new comment
     *
     * @param userCode   The owner of the comment. Check if the User has the right to post
     * @param drawerCode The code of the drawer. A comment is associated to a Drawer
     * @param comment    The Comment itself
     * @return
     * @throws ServiceException
     */
    Comment post(String userCode, String drawerCode, Comment comment) throws ServiceException;

    /**
     * Modifies a comment
     *
     * @param userCode    The user code of the owner of the comment. Only the owner can modify a comment.
     * @param commentCode The comment to modify identified by its code.
     * @param comment     The new comment. The id and the code are not needed.
     * @return
     * @throws ServiceException
     */
    Comment modify(String userCode, String commentCode, Comment comment) throws ServiceException;


    /**
     * Deletes a comment
     *
     * @param userCode    The user code of the owner of the comment. Only the owner can delete a comment.
     * @param commentCode The comment to delete identified by its code
     * @throws ServiceException
     */
    void delete(String userCode, String commentCode) throws ServiceException;

    /**
     * Retrieves all comments associated to a drawer.
     *
     * @param userCode   The user code to verify if the User has the right to do so.
     * @param drawerCode The drawer code to get the comment associated to
     * @param offset     The position of the first comment to get
     * @param limit      The number of comments to get
     * @param asc        Ascendant. If true the comments will be order by the publish date (or create date) ascendant otherwise descendant.
     * @return
     * @throws ServiceException
     */
    List<Comment> find(String userCode, String drawerCode, int offset, int limit, boolean asc) throws ServiceException;
}
