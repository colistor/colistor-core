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
import com.colistor.core.persistence.model.ItemTemplate;
import com.colistor.core.persistence.model.ItemTemplateField;
import com.colistor.core.services.exception.ServiceException;

import java.util.List;

public class ItemTemplateS implements ItemTemplateSI {
    @Override
    public ItemTemplate create(String userCode, ItemTemplate itemTemplate) throws ServiceException {
        return null;
    }

    @Override
    public ItemTemplate modify(String userCode, String itemTemplateCode, ItemTemplate itemTemplate) throws ServiceException {
        return null;
    }

    @Override
    public void delete(String userCode, String itemTemplateCode) throws ServiceException {

    }

    @Override
    public void addField(String userCode, String itemTemplateCode, ItemTemplateField field) throws ServiceException {

    }

    @Override
    public void modifyField(String userCode, String itemTemplateCode, int position, ItemTemplateField field) throws ServiceException {

    }

    @Override
    public void removeField(String userCode, String itemTemplateCode, int position) throws ServiceException {

    }

    @Override
    public List<ItemTemplate> find(String userCode, Filter filter) throws ServiceException {
        return null;
    }
}
