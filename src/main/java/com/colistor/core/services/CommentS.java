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
import com.colistor.core.persistence.model.Drawer;
import com.colistor.core.persistence.model.Filter;
import com.colistor.core.services.exception.ServiceException;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.List;

public class CommentS implements CommentSI {

    @Inject
    private Provider<CommonFKSI<Drawer, Comment>> service;

    @Override
    public Comment post(String userCode, String drawerCode, Comment comment) throws ServiceException {
        return service.get().add(userCode, drawerCode, comment);
    }

    @Override
    public Comment modify(String userCode, String commentCode, Comment comment) throws ServiceException {
        return service.get().modify(userCode, commentCode, comment);
    }

    @Override
    public void delete(String userCode, String commentCode) throws ServiceException {
        service.get().delete(userCode, commentCode);
    }

    @Override
    public List<Comment> find(String userCode, String drawerCode, int offset, int limit, boolean asc) throws ServiceException {
        Filter f = new Filter();
        f.offset = offset;
        f.limit = limit;
        f.asc = asc;
        return service.get().findByUserCode(userCode, f);
    }
}
