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

import com.google.inject.Singleton;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;

// TODO: Auto-generated Javadoc

/**
 * The Class RandomString.
 */
@Singleton
public final class RandomString {

    /**
     * The random.
     */
    private SecureRandom random;

    /**
     * The num bits.
     */
    private int numBits;

    /**
     * Instantiates a new random string.
     */
    public RandomString() {
        this(128);
    }

    /**
     * Instantiates a new random string.
     *
     * @param numBits the num bits
     */
    public RandomString(int numBits) {
        this.numBits = numBits;
        random = new SecureRandom();
    }

    /**
     * Next random string.
     *
     * @return the string
     */
    public String nextRandomString() {
        return Base64.getEncoder().encodeToString((new BigInteger(numBits, random)
                .toString(64)).getBytes());
    }

    /**
     * Next random string.
     *
     * @param lenght the lenght
     * @return the string
     */
    public String nextRandomString(int lenght) {
        String rs = nextRandomString();
        int rand = (int) (random.nextFloat() * ((rs.length() - lenght)));
        return rs.substring(rand, lenght + rand);
    }

}
