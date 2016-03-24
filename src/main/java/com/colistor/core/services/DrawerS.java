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
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.List;

public class DrawerS implements DrawerSI {

    @Inject
    private Provider<CommonSI<Drawer>> service;

    @Inject
    private Provider<CommonSubSI<Drawer, Share>> shareService;

    @Override
    public Drawer add(String userCode, Drawer drawer) throws ServiceException {
        return service.get().add(userCode, drawer);
    }

    @Override
    public Drawer modify(String userCode, String drawerCode, Drawer drawer) throws ServiceException {
        return service.get().modify(userCode, drawerCode, drawer);
    }

    @Override
    public void delete(String userCode, String drawerCode) throws ServiceException {
        service.get().delete(userCode, drawerCode);
    }

    @Override
    public List<Drawer> find(String userCode, Filter filter) throws ServiceException {
        return service.get().findByUserCode(userCode, filter);
    }

    @Override
    public Share share(String ownerUserCode, String grantedUserCode, String drawerCode, Share share) throws ServiceException {
        return shareService.get().add(ownerUserCode, drawerCode, share);
    }

    @Override
    public Share modifyShare(String userCode, String drawerCode, int position, Share share) throws ServiceException {
        return shareService.get().modify(userCode, drawerCode, position, share);
    }

    @Override
    public void deleteShare(String userCode, String drawerCode, int position) throws ServiceException {
        shareService.get().delete(userCode, drawerCode, position);
    }
}
