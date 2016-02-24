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
 * The Class ControlModelCreatorAcess.
 */
public class ControlModelCreatorAcess implements WebControllerI {

    /**
     * The Constant CONTROL_MODELCREATOR_ACCESS.
     */
    public static final String CONTROL_MODELCREATOR_ACCESS = "conmodcreacc";

    @Override
    public String getName() {
        return CONTROL_MODELCREATOR_ACCESS;
    }

    @Override
    public boolean controlRequest(HttpServletRequest request)
            throws WebException {
        HttpSession session = request.getSession();
        /*ModelContract contract = null;
		if (session != null
				&& session.getAttribute(WebParam.SESSION_MODELCONTRACT) != null) {
			contract = (ModelContract) session
					.getAttribute(WebParam.SESSION_MODELCONTRACT);
			if (contract.getNbModels() > 0) {
				return true;
			}
		}*/
        throw new WebException(WebException.NOT_AUTHORIZED, ExceptionLevel.LOW);
    }

}
