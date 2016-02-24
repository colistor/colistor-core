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

/**
 * The Class WebException.
 */
public class WebException extends Exception {

    /**
     * The Constant WEB_EXCEPTION.
     */
    public static final String WEB_EXCEPTION = "we";
    /**
     * The Constant NOT_AUTHENTICATED.
     */
    public static final String NOT_AUTHENTICATED = WEB_EXCEPTION + "_notauth";
    /**
     * The Constant PARAMETER_NOT_FOUND.
     */
    public static final String PARAMETER_NOT_FOUND = WEB_EXCEPTION
            + "_paranotfound";
    /**
     * The Constant SESSION_ATTRIBUTE_NOT_FOUND.
     */
    public static final String SESSION_ATTRIBUTE_NOT_FOUND = WEB_EXCEPTION
            + "_sessattrnotfound";
    /**
     * The Constant FUNCTION_NOT_IMPLEMENTED.
     */
    public static final String FUNCTION_NOT_IMPLEMENTED = WEB_EXCEPTION
            + "_notimp";
    /**
     * The Constant REQUESTED_ELEMENT_NOT_FOUND.
     */
    public static final String REQUESTED_ELEMENT_NOT_FOUND = WEB_EXCEPTION
            + "_elemnotfound";
    /**
     * The Constant NOT_AUTHORIZED.
     */
    public static final String NOT_AUTHORIZED = WEB_EXCEPTION + "_notauthorized";
    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5348230205923389597L;
    /**
     * The code.
     */
    private String code;

    /**
     * The level.
     */
    private ExceptionLevel level;

    /**
     * The code case.
     */
    private int codeCase;

    /**
     * The redirection.
     */
    private String redirection;

    /**
     * Instantiates a new web exception.
     *
     * @param code the code
     */
    public WebException(String code) {
        this(code, ExceptionLevel.MEDIUM,
                (int) (Math.random() * Integer.MAX_VALUE));
    }

    /**
     * Instantiates a new web exception.
     *
     * @param code  the code
     * @param level the level
     */
    public WebException(String code, ExceptionLevel level) {
        this(code, level, (int) (Math.random() * Integer.MAX_VALUE));
    }

    /**
     * Instantiates a new web exception.
     *
     * @param code     the code
     * @param level    the level
     * @param codeCase the code case
     */
    public WebException(String code, ExceptionLevel level, int codeCase) {
        this.code = code;
        this.level = level;
        this.codeCase = codeCase;
        //ErrorDBConnection.get().insertError(this);
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public ExceptionLevel getLevel() {
        return level;
    }

    /**
     * Gets the code case.
     *
     * @return the code case
     */
    public int getCodeCase() {
        return codeCase;
    }

    /**
     * Gets the redirection.
     *
     * @return the redirection
     */
    public String getRedirection() {
        return redirection;
    }

    /**
     * Sets the redirection.
     *
     * @param redirection the redirection
     * @return the web exception
     */
    public WebException setRedirection(String redirection) {
        this.redirection = redirection;
        return this;
    }

}
