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

package com.colistor.core.services.controller;

import com.colistor.core.persistence.exception.ExceptionLevel;
import com.colistor.core.persistence.model.User;
import com.colistor.core.services.exception.ServiceException;

import static com.colistor.core.services.exception.ServiceException.PERSON_CONTROLLER;

/**
 * Control the information contained by a given Person in different cases. An
 * exception is raised if a control failed
 *
 * @author Joël Favre
 */
public class UserController extends Controller<User> {

	/*
     * Codes of exceptions for invalidity added as a RaisedException in a
	 * ServiceException
	 */
    /**
     * The Constant INVALID_PERSON.
     */
    public static final String INVALID_PERSON = PERSON_CONTROLLER
            + "_invalpers";

    /**
     * The Constant INVALID_OPENID.
     */
    public static final String INVALID_OPENID = PERSON_CONTROLLER
            + "_invalopenid";

    /**
     * The Constant INVALID_EMAIL.
     */
    public static final String INVALID_EMAIL = PERSON_CONTROLLER
            + "_invalemail";

    /**
     * The Constant INVALID_NAME.
     */
    public static final String INVALID_NAME = PERSON_CONTROLLER + "_invalname";

    /**
     * The Constant INVALID_PERSON_ID.
     */
    public static final String INVALID_PERSON_ID = PERSON_CONTROLLER
            + "_invalid";

	/*
	 * Codes for controls for a ServiceException
	 */
    /**
     * The Constant CONTROL_OPENID.
     */
    public static final String CONTROL_OPENID = PERSON_CONTROLLER + "_invaloi";

    /**
     * The Constant CONTROL_PERSON.
     */
    public static final String CONTROL_PERSON = PERSON_CONTROLLER + "_perscont";

    /**
     * The Constant CONTROL_PERSON_ID.
     */
    public static final String CONTROL_PERSON_ID = PERSON_CONTROLLER
            + "_contid";

    /**
     * The Constant CONTROL_MODIFY.
     */
    public static final String CONTROL_MODIFY = PERSON_CONTROLLER + "_modpers";

    /**
     * The Constant CONTROL_ERASE.
     */
    public static final String CONTROL_ERASE = PERSON_CONTROLLER + "_erapers";

    /**
     * The default Controller is used when there is no better methods.
     *
     * @param p the p
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    @Override
    protected boolean defaultController(User p) throws ServiceException {
        if (p != null) {
            if (p.getEmail() == null || p.getEmail().equals("")) {
                addException(new RaisedException(INVALID_EMAIL,
                        "The email is null or not correctly set", User.EMAIL));
            }
            if (p.getFullName() == null || p.getFullName().equals("")) {
                addException(new RaisedException(INVALID_NAME,
                        "The fullname is null or not correctly set",
                        User.FULL_NAME));
            }
        } else {
            addException(new RaisedException(INVALID_PERSON,
                    "The person is null"));
        }
        if (hasException()) {
            throw new ServiceException(CONTROL_PERSON, ExceptionLevel.VERY_LOW,
                    getExceptions());
        }
        return true;
    }

    /**
     * Control a Person on update.
     *
     * @param p the p
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    @Override
    public boolean onUpdate(User p) throws ServiceException {
        if (p != null) {
            if (p.getId() == null || p.getId().equals("")) {
                addException(new RaisedException(INVALID_PERSON_ID,
                        "The id is null or not correctly set", User.ID_PERSON));
            }
            if (p.getEmail() == null || p.getEmail().equals("")) {
                addException(new RaisedException(INVALID_EMAIL,
                        "The email is null or not correctly set", User.EMAIL));
            }
            if (p.getFullName() == null || p.getFullName().equals("")) {
                addException(new RaisedException(INVALID_NAME,
                        "The fullname is null or not correctly set",
                        User.FULL_NAME));
            }
        } else {
            addException(new RaisedException(INVALID_PERSON,
                    "The person is null"));
        }
        if (hasException()) {
            throw new ServiceException(CONTROL_MODIFY, ExceptionLevel.VERY_LOW,
                    getExceptions());
        }
        return true;
    }

    /**
     * Control a Person on delete.
     *
     * @param p the p
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    @Override
    public boolean onDelete(User p) throws ServiceException {
        if (p != null) {
            if (p.getId() == null || p.getId().equals("")) {
                addException(new RaisedException(INVALID_PERSON_ID,
                        "The id is null or not correctly set"));
            }
        } else {
            addException(new RaisedException(INVALID_PERSON_ID,
                    "The person is null"));
        }
        if (hasException()) {
            throw new ServiceException(CONTROL_ERASE, ExceptionLevel.VERY_LOW,
                    getExceptions());
        }
        return true;
    }

    /**
     * Control if the Person has an id. Used when data are bound to a Person
     *
     * @param p The Person to control
     * @return True if the control is passed
     * @throws ServiceException A ServiceException is raised with the details if control
     *                          failed
     */
    public boolean personAsUser(User p) throws ServiceException {
        if (p != null) {
            if (p.getId() == null || p.getId().equals("")) {
                addException(new RaisedException(INVALID_PERSON_ID,
                        "The id is null or not correctly set"));
            }
        } else {
            addException(new RaisedException(INVALID_PERSON_ID,
                    "The person is null"));
        }
        if (hasException()) {
            throw new ServiceException(CONTROL_PERSON_ID,
                    ExceptionLevel.VERY_LOW, getExceptions());
        }
        return true;
    }

}
