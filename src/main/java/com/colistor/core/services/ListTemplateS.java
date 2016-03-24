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
import com.colistor.core.persistence.model.ListTemplate;
import com.colistor.core.persistence.model.ListTemplateField;
import com.colistor.core.services.exception.ServiceException;

import java.util.List;

public class ListTemplateS implements ListTemplateSI {
    @Override
    public ListTemplate create(String userCode, ListTemplate listTemplate) throws ServiceException {
        return null;
    }

    @Override
    public ListTemplate modify(String userCode, String listTemplateCode, ListTemplate listTemplate) throws ServiceException {
        return null;
    }

    @Override
    public void delete(String userCode, String listTemplateCode) throws ServiceException {

    }

    @Override
    public void addField(String userCode, String listTemplateCode, ListTemplateField field) throws ServiceException {

    }

    @Override
    public void modifyField(String userCode, String listTemplateCode, int position, ListTemplateField field) throws ServiceException {

    }

    @Override
    public void removeField(String userCode, String listTemplateCode, int position) throws ServiceException {

    }

    @Override
    public List<ListTemplate> find(String userCode, Filter filter) throws ServiceException {
        return null;
    }
}
