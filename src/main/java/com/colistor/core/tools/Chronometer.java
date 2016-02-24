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

package com.colistor.core.tools;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The Class Chronometer.
 */
public class Chronometer {

    /**
     * The m_start.
     */
    private Calendar m_start;

    /**
     * The m_stop.
     */
    private Calendar m_stop;

    /**
     * Instantiates a new chronometer.
     */
    public Chronometer() {
        init();
    }

    /**
     * Start.
     */
    public void start() {
        m_start.setTime(new Date());
    }

    /**
     * Stop.
     */
    public void stop() {
        m_stop.setTime(new Date());
    }

    /**
     * Inits the.
     */
    public void init() {
        m_start = new GregorianCalendar();
        m_stop = new GregorianCalendar();
    }

    /**
     * Gets the milli sec.
     *
     * @return the milli sec
     */
    public long getMilliSec() {
        return (m_stop.getTimeInMillis() - m_start.getTimeInMillis());
    }
}
