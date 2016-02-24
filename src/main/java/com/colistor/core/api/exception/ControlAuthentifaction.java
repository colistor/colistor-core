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
import com.colistor.core.tools.WebParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc

/**
 * The Class ControlAuthentifaction.
 */
public class ControlAuthentifaction implements WebControllerI {

    /**
     * The Constant CONTROL_AUTHENTICATION.
     */
    public static final String CONTROL_AUTHENTICATION = "contauth";

    /**
     * The redirection.
     */
    private String redirection;

    /**
     * Instantiates a new control authentifaction.
     *
     * @param redirection the redirection
     */
    public ControlAuthentifaction(String redirection) {
        this.redirection = redirection;
    }

    @Override
    public boolean controlRequest(HttpServletRequest request)
            throws WebException {
        HttpSession session = request.getSession();
        if (session != null
                && session.getAttribute(WebParam.SESSION_USER) != null) {
            return true;
        }
        session.setAttribute(WebParam.SESSION_NEXT_PAGE, request
                .getRequestURL().toString());
        throw new WebException(WebException.NOT_AUTHENTICATED,
                ExceptionLevel.VERY_LOW).setRedirection(redirection);
    }

    @Override
    public String getName() {
        return CONTROL_AUTHENTICATION;
    }

}
