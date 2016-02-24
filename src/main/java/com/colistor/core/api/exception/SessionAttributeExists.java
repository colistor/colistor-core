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

package com.colistor.core.api.exception;

import com.colistor.core.persistence.exception.ExceptionLevel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc

/**
 * The Class SessionAttributeExists.
 */
public class SessionAttributeExists implements WebControllerI {

    /**
     * The Constant SESSION_ATTRIBUTE_EXISTS.
     */
    public static final String SESSION_ATTRIBUTE_EXISTS = "sessattrexists";

    /**
     * The attribute.
     */
    private String attribute;

    /**
     * Instantiates a new session attribute exists.
     *
     * @param attribute the attribute
     */
    public SessionAttributeExists(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getName() {
        return SESSION_ATTRIBUTE_EXISTS + attribute;
    }

    @Override
    public boolean controlRequest(HttpServletRequest request)
            throws WebException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(attribute) != null) {
            return true;
        }
        throw new WebException(WebException.SESSION_ATTRIBUTE_NOT_FOUND,
                ExceptionLevel.LOW);
    }

}
