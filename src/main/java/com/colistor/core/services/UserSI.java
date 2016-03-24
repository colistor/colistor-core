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

import com.colistor.core.persistence.model.User;
import com.colistor.core.services.exception.ServiceException;

/**
 * Manages a user account : registering, signing in, modifying the personal data, deleting the account.
 */
public interface UserSI {

    /**
     * Verifying that the email and the password correspond to a registered user,
     * if it is the case the user is authenticated and is returned
     *
     * @param email    The email address of the User
     * @param password The password of the User
     * @return The user if the authentication is correct and null if not
     * @throws ServiceException It will be thrown if the parameters are not correct or if something else happens
     * @see com.colistor.core.persistence.model.User for the email and the password
     */
    User authenticate(String email, String password) throws ServiceException;

    /**
     * Register a new User
     *
     * @param user The new user data. See the User class to check what is mandatory
     * @return The new User with the code and the id
     * @throws ServiceException It will be thrown if the parameters are not correct or if something else happens
     * @see com.colistor.core.persistence.model.User
     */
    User register(User user) throws ServiceException;

    /**
     * Modifies a user.
     *
     * @param userCode The user code to make sure that the user modifies only him/herself.
     * @param user The new values for the user, including the values that have not been modified.
     *             The id and the code are not needed.
     * @return The user with the new values.
     * @throws ServiceException
     */
    User modify(String userCode, User user) throws ServiceException;

    /**
     * Get the user by its code.
     *
     * @param userCode The code of the user.
     * @return The user.
     * @throws ServiceException
     */
    User getUser(String userCode) throws ServiceException;

    /**
     * Deleting an account
     *
     * @param userCode The code of the User that will be deleted
     * @throws ServiceException It will be thrown if the parameters are not correct or if something else happens
     * @see com.colistor.core.persistence.model.User for the userCode
     */
    void deleteAccount(String userCode) throws ServiceException;

}
