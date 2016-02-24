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

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

// TODO: Auto-generated Javadoc

/**
 * The Class Location.
 */
@RequestScoped
public class Location {

    /**
     * The Constant GENERAL_TRANSLATION.
     */
    public static final String GENERAL_TRANSLATION = "general.general";

    /**
     * The Constant ERROR_TRANSLATION.
     */
    public static final String ERROR_TRANSLATION = "error.error";

    /**
     * The Constant TERM_TRANSLATION.
     */
    public static final String TERM_TRANSLATION = "term.term";

    /**
     * The Constant MODEL_EDITOR.
     */
    public static final String MODEL_EDITOR = "modeleditor.modeleditor";

    /**
     * The Constant ITEM_EDITOR.
     */
    public static final String ITEM_EDITOR = "itemeditor.itemeditor";

    public static final String MAIL_TRANSLATION = "mail.mail";

    /**
     * The locale.
     */
    private Locale locale;

    /**
     * The time zone.
     */
    private TimeZone timeZone;

    /**
     * The language.
     */
    private String language;

    /**
     * The country.
     */
    private String country;

    /**
     * The s time zone.
     */
    private String sTimeZone;

    /**
     * The date.
     */
    private DateFormat date;

    /**
     * The time.
     */
    private DateFormat time;

    /**
     * The date time.
     */
    private DateFormat dateTime;

    /**
     * Instantiates a new location.
     *
     * @param international the international
     */
    @Inject
    public Location(International international) {
        this.language = international.getLanguage();
        this.country = international.getLanguage();
        setTimeZone("UTC");
        locale = new Locale(language, country);
        date = DateFormat.getDateInstance(DateFormat.LONG, locale);
        date.setTimeZone(this.timeZone);
        time = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        time.setTimeZone(this.timeZone);
        dateTime = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        dateTime.setTimeZone(this.timeZone);
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
     * Gets the time zone.
     *
     * @return the time zone
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the time zone.
     *
     * @param timeZone the new time zone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = TimeZone.getTimeZone(timeZone);
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the coutry.
     *
     * @return the coutry
     */
    public String getCoutry() {
        return country;
    }

    /**
     * Gets the s time zone.
     *
     * @return the s time zone
     */
    public String getsTimeZone() {
        return sTimeZone;
    }

    /**
     * Gets the language country.
     *
     * @return the language country
     */
    public String getLanguageCountry() {
        StringBuilder sb = new StringBuilder(language);
        if (country != null) {
            sb.append("-").append(country);
        }
        return sb.toString();
    }

    /**
     * Format long.
     *
     * @param number the number
     * @return the string
     */
    public String formatLong(long number) {
        return NumberFormat.getNumberInstance(locale).format(number);
    }

    /**
     * Format double.
     *
     * @param number the number
     * @return the string
     */
    public String formatDouble(double number) {
        return NumberFormat.getNumberInstance(locale).format(number);
    }

    /**
     * Format currency.
     *
     * @param number the number
     * @return the string
     */
    public String formatCurrency(long number) {
        return NumberFormat.getCurrencyInstance(locale).format(number);
    }

    /**
     * Format currency.
     *
     * @param number the number
     * @return the string
     */
    public String formatCurrency(double number) {
        return NumberFormat.getCurrencyInstance(locale).format(number);
    }

    /**
     * Format percent.
     *
     * @param number the number
     * @return the string
     */
    public String formatPercent(long number) {
        return NumberFormat.getPercentInstance(locale).format(number);
    }

    /**
     * Format percent.
     *
     * @param number the number
     * @return the string
     */
    public String formatPercent(double number) {
        return NumberFormat.getPercentInstance(locale).format(number);
    }

    /**
     * Format int.
     *
     * @param number the number
     * @return the string
     */
    public String formatInt(long number) {
        return NumberFormat.getIntegerInstance(locale).format(number);
    }

    /**
     * Format int.
     *
     * @param number the number
     * @return the string
     */
    public String formatInt(double number) {
        return NumberFormat.getIntegerInstance(locale).format(number);
    }

    /**
     * Format date.
     *
     * @param date the date
     * @return the string
     */
    public String formatDate(Date date) {
        return date != null ? this.date.format(date) : null;
    }

    /**
     * Format time.
     *
     * @param date the date
     * @return the string
     */
    public String formatTime(Date date) {
        return time != null ? this.time.format(date) : null;
    }

    /**
     * Format date time.
     *
     * @param date the date
     * @return the string
     */
    public String formatDateTime(Date date) {
        return dateTime != null ? this.dateTime.format(date) : null;
    }

    /**
     * Gets the resource bundle.
     *
     * @param baseName the base name
     * @return the resource bundle
     */
    public ResourceBundle getResourceBundle(String baseName) {
        return ResourceBundle.getBundle(baseName, locale);
    }

}
