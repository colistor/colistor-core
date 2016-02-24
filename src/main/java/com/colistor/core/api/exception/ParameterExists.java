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

/**
 * The Class ParameterExists.
 */
public class ParameterExists implements WebControllerI {

    /**
     * The Constant CONTROL_PARAMETER_EXISTS.
     */
    public static final String CONTROL_PARAMETER_EXISTS = "contparexi";

    /**
     * The param name.
     */
    private String paramName;

    /**
     * Instantiates a new parameter exists.
     *
     * @param paramName the param name
     */
    public ParameterExists(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String getName() {
        return CONTROL_PARAMETER_EXISTS + paramName;
    }

    @Override
    public boolean controlRequest(HttpServletRequest request)
            throws WebException {
        if (request.getParameter(paramName) != null
                && !request.getParameter(paramName).equals("")) {
            return true;
        }
        throw new WebException(WebException.PARAMETER_NOT_FOUND,
                ExceptionLevel.LOW);
    }

}
