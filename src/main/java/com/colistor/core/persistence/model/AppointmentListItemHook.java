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
package com.colistor.core.persistence.model;

import java.util.Date;

public class AppointmentListItemHook {

    private transient String id;
    private String appointmentCode;
    private ListItemHook listItemHook;
    private Date hookDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppointmentCode() {
        return appointmentCode;
    }

    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    public ListItemHook getListItemHook() {
        return listItemHook;
    }

    public void setListItemHook(ListItemHook listItemHook) {
        this.listItemHook = listItemHook;
    }

    public Date getHookDate() {
        return hookDate;
    }

    public void setHookDate(Date hookDate) {
        this.hookDate = hookDate;
    }
}
