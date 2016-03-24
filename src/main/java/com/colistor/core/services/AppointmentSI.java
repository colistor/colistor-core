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

/**
 * Manages the appointments
 */
public interface AppointmentSI {

    /**
     * Adds a new appointment
     *
     * @param userCode         The user code as the owner of the new appointment
     * @param drawerCode       An appointment is associated to a drawer.
     * @param appointment      The appointment itself, id and code are not needed and will be generated.
     * @param listItemHookCode Not mandatory (can be null). Will associate the ListItemHooks to the new appointment.
     *                         It will create a new AppointmentListItemHook for each of them
     * @return The new Appointment with the code.
     * @throws ServiceException
     */
    Appointment add(String userCode, String drawerCode, Appointment appointment, String... listItemHookCode) throws ServiceException;

    /**
     * Adds ListItemHooks to an appointment
     *
     * @param userCode         The user code to verify if the user has the right to do so.
     * @param appointmentCode  The appointment code of the appointment to add the ListItemHooks to
     * @param listItemHookCode Will associate the ListItemHooks to the appointment.
     *                         It will create a new AppointmentListItemHook for each of them
     * @throws ServiceException
     */
    void addListItem(String userCode, String appointmentCode, String... listItemHookCode) throws ServiceException;

    /**
     * Removes AppointmentListItemHooks from the appointment. It deletes the AppointmentListItemHooks but not the ListItemHook.
     *
     * @param userCode                    The user code to verify if the user has the right to do so.
     * @param appointmentCode             The appointment code of the appointment to remove the ListItemHooks from
     * @param AppointmentlistItemHookCode The AppointmentListItemHooks to delete
     * @throws ServiceException
     */
    void removeListItem(String userCode, String appointmentCode, String... AppointmentlistItemHookCode) throws ServiceException;

    /**
     * Modifies an appointment
     *
     * @param userCode        The user code to verify if the user has the right to do so.
     * @param appointmentCode The appointment to modify
     * @param appointment     The new values for the appointment. The id and the code are not needed.
     * @return The appointment with the new values including the values that have not been modified.
     * @throws ServiceException
     */
    Appointment modify(String userCode, String appointmentCode, Appointment appointment) throws ServiceException;

    /**
     * Deletes an appointment and the AppointmentListItemHooks associated but not the ListItemHooks.
     *
     * @param userCode        The user code to verify if the user has the right to do so.
     * @param appointmentCode The code of the appointment to delete
     * @throws ServiceException
     */
    void delete(String userCode, String appointmentCode) throws ServiceException;

    /**
     * Gets an appointment by its code.
     *
     * @param userCode        The user code to verify if the user has the right to do so.
     * @param appointmentCode The code of the appointment
     * @return The appointment
     * @throws ServiceException
     */
    Appointment getByCode(String userCode, String appointmentCode) throws ServiceException;

    /**
     * Finds all the appointments between two dates.
     *
     * @param userCode   The user code to verify if the user has the right to do so.
     * @param startDate  The appointments starting at a date more recent or equal to startDate.
     * @param endDate    The appointments starting at a date older or equal to this endDate.
     * @param asc        If true, order the appointments by their start dates ascendant, otherwise, descendant.
     * @param drawerCode
     * @return A list of appointments corresponding to the criteria. If nothing corresponds the list is empty.
     * @throws ServiceException
     */
    List<Appointment> find(String userCode, Date startDate, Date endDate, boolean asc, String... drawerCode) throws ServiceException;

}
