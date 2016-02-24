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

package com.colistor.core.persistence.exception;

/**
 * The level for an exception, used especially by the logger.
 */
public enum ExceptionLevel {

    /**
     * The very low.
     */
    VERY_LOW("verylow"), /**
     * The low.
     */
    LOW("low"), /**
     * The medium.
     */
    MEDIUM("medium"), /**
     * The high.
     */
    HIGH("high"), /**
     * The very high.
     */
    VERY_HIGH(
                    "veryhigh");

    /**
     * The level.
     */
    String level;

    /**
     * Instantiates a new exception level.
     *
     * @param level the level
     */
    ExceptionLevel(String level) {
        this.level = level;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public String getLevel() {
        return level;
    }
}
