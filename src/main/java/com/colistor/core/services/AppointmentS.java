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

import com.colistor.core.persistence.model.Appointment;
import com.colistor.core.services.exception.ServiceException;

import java.util.Date;
import java.util.List;

public class AppointmentS implements AppointmentSI {
    @Override
    public Appointment add(String userCode, String drawerCode, Appointment appointment, String... listItemHookCode) throws ServiceException {
        return null;
    }

    @Override
    public void addListItem(String userCode, String appointmentCode, String... listItemHookCode) throws ServiceException {

    }

    @Override
    public void removeListItem(String userCode, String appointmentCode, String... AppointmentlistItemHookCode) throws ServiceException {

    }

    @Override
    public Appointment modify(String userCode, String appointmentCode, Appointment appointment) throws ServiceException {
        return null;
    }

    @Override
    public void delete(String userCode, String appointmentCode) throws ServiceException {

    }

    @Override
    public Appointment getByCode(String userCode, String appointmentCode) throws ServiceException {
        return null;
    }

    @Override
    public List<Appointment> find(String userCode, Date startDate, Date endDate, boolean asc, String... drawerCode) throws ServiceException {
        return null;
    }
}
