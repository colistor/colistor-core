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

package com.colistor.core.tools.international;

import com.colistor.core.tools.Context;
import com.colistor.core.tools.Language;
import com.colistor.core.tools.WebParam;
import com.colistor.core.tools.international.error.Error;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.ResourceBundle;

/**
 * The Class International.
 */
public class International {

    private static URLClassLoader classLoader = null;
    /**
     * The country.
     */
    private String country;
    /**
     * The language.
     */
    private String language;
    /**
     * The locale.
     */
    private Locale locale;
    /**
     * The request.
     */
    private HttpServletRequest request;
    /**
     * The lang.
     */
    private Provider<Language> lang;

    /**
     * Instantiates a new international.
     *
     * @param request the request
     * @param lang    the lang
     */
    @Inject
    public International(HttpServletRequest request, Provider<Language> lang) {
        if (classLoader == null) {
            try {
                classLoader = new URLClassLoader(new URL[]{new File(
                        Context.PATH_TRANSLATION).toURI().toURL()});
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        // String country;
        // String language = null;
        this.request = request;
        this.lang = lang;
        defineLanguage(request);
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
        request.getSession().setAttribute(WebParam.SESSION_COUNTRY, country);
        locale = new Locale(language, this.country);
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public String getLanguage() {
        if (language == null) {
            // return "en";
            if (request.getSession().getAttribute(WebParam.SESSION_LANGUAGE) != null) {
                language = (String) request.getSession().getAttribute(
                        WebParam.SESSION_LANGUAGE);
            } else {
                defineLanguage(request);
            }
        }
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language the new language
     */
    public void setLanguage(String language) {
        if (lang.get().getLanguagesByCode().containsKey(language)) {
            this.language = language;
        } else {
            this.language = Language.DEFAULT_LANGUAGE;
        }
        request.getSession().setAttribute(WebParam.SESSION_LANGUAGE,
                this.language);
        locale = new Locale(this.language, country);
    }

    /**
     * Gets the resource.
     *
     * @return the resource
     */
    public ResourceBundle getResource() {
        return ResourceBundle.getBundle(Location.GENERAL_TRANSLATION, locale,
                classLoader, new UTF8Control());
    }

    /**
     * Gets the string.
     *
     * @param key the key
     * @return the string
     */
    public String getString(String key) {
        return ResourceBundle.getBundle(Location.GENERAL_TRANSLATION, locale,
                classLoader, new UTF8Control()).getString(key);
    }

    /**
     * Gets the error.
     *
     * @param key the key
     * @return the error
     */
    public String getError(String key) {
        ResourceBundle rb = ResourceBundle.getBundle(
                Location.ERROR_TRANSLATION, locale, classLoader,
                new UTF8Control());
        if (rb.containsKey(key)) {
            return rb.getString(key);
        } else {
            return rb.getString(Error.SRV_INTERNAL_ERROR);
        }
    }

    /**
     * Gets the other.
     *
     * @param resource the resource
     * @param key      the key
     * @return the other
     */
    public String getOther(String resource, String key) {
        return ResourceBundle.getBundle(resource, locale, classLoader,
                new UTF8Control()).getString(key);
    }

    /**
     * Define language.
     *
     * @param request the request
     */
    private void defineLanguage(HttpServletRequest request) {
        HttpSession sessionTmp = request.getSession();
        if (sessionTmp.getAttribute(WebParam.SESSION_LANGUAGE) != null) {
            language = (String) sessionTmp
                    .getAttribute(WebParam.SESSION_LANGUAGE);
            if (sessionTmp.getAttribute(WebParam.SESSION_COUNTRY) != null) {
                country = (String) sessionTmp
                        .getAttribute(WebParam.SESSION_COUNTRY);
            }
        } else {
            Locale localeTmp;
            Enumeration<Locale> enums = request.getLocales();
            boolean find = false;
            while (enums.hasMoreElements()) {
                localeTmp = enums.nextElement();
                for (Entry<String, String> langs : lang.get()
                        .getLanguagesByCode().entrySet()) {
                    if (localeTmp.getLanguage().equals(
                            new Locale(langs.getKey()).getLanguage())
                            && !find) {
                        language = langs.getKey();
                        find = true;
                    }
                }
            }
            if (!find) {
                language = Language.DEFAULT_LANGUAGE;
            }
            country = "";
            sessionTmp.setAttribute(WebParam.SESSION_LANGUAGE, language);
            sessionTmp.setAttribute(WebParam.SESSION_COUNTRY, country);
        }
        locale = new Locale(language, country);
    }

    /**
     * Gets the locale.
     *
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the locale.
     *
     * @param locale the new locale
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
