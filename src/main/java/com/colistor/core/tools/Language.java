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

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Language.
 */
@Singleton
public class Language {

    /**
     * The Constant EN.
     */
    public static final String EN = "en";

    /**
     * The Constant ENGLISH.
     */
    public static final String ENGLISH = "English";

    /**
     * The Constant FR.
     */
    public static final String FR = "fr";

    /**
     * The Constant FRENCH.
     */
    public static final String FRENCH = "Français";

    /**
     * The Constant DEFAULT_LANGUAGE.
     */
    public static final String DEFAULT_LANGUAGE = EN;

    /**
     * The languages by code.
     */
    private Map<String, String> languagesByCode;

    /**
     * The languages by name.
     */
    private Map<String, String> languagesByName;

    /**
     * Instantiates a new language.
     */
    public Language() {
        languagesByCode = new HashMap<String, String>();
        languagesByCode.put(EN, ENGLISH);
        languagesByCode.put(FR, FRENCH);
        languagesByName = new HashMap<String, String>();
        languagesByName.put(ENGLISH, EN);
        languagesByName.put(FRENCH, FR);
    }

    /**
     * Gets the language name.
     *
     * @param code the code
     * @return the language name
     */
    public String getLanguageName(String code) {
        return languagesByCode.get(code);
    }

    /**
     * Gets the language code.
     *
     * @param name the name
     * @return the language code
     */
    public String getLanguageCode(String name) {
        return languagesByName.get(name);
    }

    /**
     * Gets the languages by code.
     *
     * @return the languages by code
     */
    public Map<String, String> getLanguagesByCode() {
        return languagesByCode;
    }

    /**
     * Gets the languages by name.
     *
     * @return the languages by name
     */
    public Map<String, String> getLanguagesByName() {
        return languagesByName;
    }

}
