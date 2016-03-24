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
package com.colistor.core.internalservices.rights;

import com.colistor.core.internalservices.exception.InternalServiceException;
import com.colistor.core.persistence.dbaccess.AccessAnnotation;
import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.right.RightDAOI;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class CommonRight<T> implements RightI<T> {

    @Inject
    private Provider<RightDAOI<T>> rightDAO;

    @Override
    public boolean canView(String userCode, String tCode, T type) throws InternalServiceException {
        if (isOwner(userCode, tCode, type)) {
            return true;
        } else if (AccessAnnotation.getShareable(type.getClass()) != null) {
            try {
                rightDAO.get().canView(userCode, tCode, type);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean canEdit(String userCode, String tCode, T type) throws InternalServiceException {
        if (isOwner(userCode, tCode, type)) {
            return true;
        } else if (AccessAnnotation.getShareable(type.getClass()) != null) {
            try {
                rightDAO.get().canEdit(userCode, tCode, type);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean isOwner(String userCode, String tCode, T type) throws InternalServiceException {
        try {
            return rightDAO.get().isOwner(userCode, tCode, type);
        } catch (DAOException e) {
            throw new InternalServiceException();
        }
    }
}
