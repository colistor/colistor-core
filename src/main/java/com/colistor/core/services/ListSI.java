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

import com.colistor.core.persistence.model.ItemTemplate;
import com.colistor.core.persistence.model.List;
import com.colistor.core.services.exception.ServiceException;

public interface ListSI {

    List add(String userCode, List list) throws ServiceException;

    List modify(String userCode, String userList, List list) throws ServiceException;

    void delete(String userCode, String userList) throws ServiceException;

    java.util.List<ItemTemplate> findAll(String userCode, String drawerCode, int offset, int limit, boolean asc) throws ServiceException;

    java.util.List<ItemTemplate> findByCriteria(String userCode, String drawerCode, String criteria, int offset, int limit, boolean asc) throws ServiceException;

    java.util.List<ItemTemplate> findByTemplate(String userCode, String drawerCode, String listTemplateCode, int offset, int limit, boolean asc) throws ServiceException;

    java.util.List<ItemTemplate> findByTemplate_Criteria(String userCode, String drawerCode, String listTemplateCode, String criteria, int offset, int limit, boolean asc) throws ServiceException;


}
