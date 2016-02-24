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

/**
 * The Class RaisedException.
 */
public class RaisedException {

    /**
     * The code.
     */
    private String code;

    /**
     * The message.
     */
    private String message;

    /**
     * The source.
     */
    private String source;

    /**
     * The level.
     */
    private ExceptionLevel level;

    /**
     * Instantiates a new raised exception.
     *
     * @param code    the code
     * @param message the message
     * @param source  the source
     * @param level   the level
     */
    public RaisedException(String code, String message, String source,
                           ExceptionLevel level) {
        this.code = code;
        this.message = message;
        this.source = source;
        this.level = level;
    }

    /**
     * Instantiates a new raised exception.
     *
     * @param code    the code
     * @param message the message
     * @param level   the level
     */
    public RaisedException(String code, String message, ExceptionLevel level) {
        this(code, message, null, level);
    }

    /**
     * Instantiates a new raised exception.
     *
     * @param code    the code
     * @param message the message
     * @param source  the source
     */
    public RaisedException(String code, String message, String source) {
        this(code, message, source, null);
    }

    /**
     * Instantiates a new raised exception.
     *
     * @param code    the code
     * @param message the message
     */
    public RaisedException(String code, String message) {
        this(code, message, null, null);
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
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
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
     * Gets the source.
     *
     * @return the source
     */
    public String getSource() {
        return source;
    }

}
