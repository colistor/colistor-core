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

import com.colistor.core.persistence.model.Filter;
import com.colistor.core.persistence.model.List;
import com.colistor.core.services.exception.ServiceException;

public class ListS implements ListSI {
    @Override
    public java.util.List<List> create(String userCode, String drawerCode, List... list) throws ServiceException {
        return null;
    }

    @Override
    public java.util.List<List> create(String userCode, String drawerCode, List[] list, String... itemCodes) throws ServiceException {
        return null;
    }

    @Override
    public List modify(String userCode, String listCode, List list) throws ServiceException {
        return null;
    }

    @Override
    public void delete(String userCode, String... listCode) throws ServiceException {

    }

    @Override
    public java.util.List<List> find(String userCode, String drawerCode, Filter filter) throws ServiceException {
        return null;
    }

    @Override
    public java.util.List<List> findByTemplate(String userCode, String drawerCode, String listTemplateCode, Filter filter) throws ServiceException {
        return null;
    }
}
