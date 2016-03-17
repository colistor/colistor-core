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

/**
 * The Class OneToOne.
 *
 * @param <T> the generic type
 * @param <U> the generic type
 */
public class OneToOne<T, U> {

    /**
     * The first.
     */
    private T first;

    /**
     * The second.
     */
    private U second;

    /**
     * Instantiates a new one to one.
     */
    public OneToOne() {
    }

    /**
     * Instantiates a new one to one.
     *
     * @param t the t
     * @param u the u
     */
    public OneToOne(T t, U u) {
        first = t;
        second = u;
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    public T getFirst() {
        return first;
    }

    /**
     * Sets the first.
     *
     * @param first the new first
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * Gets the second.
     *
     * @return the second
     */
    public U getSecond() {
        return second;
    }

    /**
     * Sets the second.
     *
     * @param second the new second
     */
    public void setSecond(U second) {
        this.second = second;
    }

}
