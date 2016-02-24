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
import com.colistor.core.persistence.model.Item;
import com.colistor.core.services.exception.ServiceException;

import java.util.List;

public interface ItemSI {

    Item add(String userCode, Item item) throws ServiceException;

    Item modify(String userCode, String itemCode, Item newData) throws ServiceException;

    void delete(String userCode, String itemCode) throws ServiceException;

    List<Item> findAll(String userCode, int offset, int limit, boolean asc) throws ServiceException;

    List<Drawer> findByCriteria(String userCode, String criteria, int offset, int limit, boolean asc) throws ServiceException;

}
