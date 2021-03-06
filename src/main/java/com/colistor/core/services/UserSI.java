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
 * Created by joel on 2/20/16.
 */
public interface UserSI {

    public User login(String email, String password) throws ServiceException;

    public User register(User user) throws ServiceException;

    public User modify(String userCode, User user) throws ServiceException;

    public void deleteAccount(String userCode) throws ServiceException;
}
