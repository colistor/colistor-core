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
package com.colistor.core.internalservices;

import com.colistor.core.internalservices.exception.InternalServiceException;

import java.util.Map;

/**
 * Send emails
 */
public interface MailerISI {

    /**
     * Send an email to one or more email address(es).
     *
     * @param templateName The name of the email template to use
     * @param subject      The subject of the email
     * @param values       The map of keys and values to replace in the template
     * @param emails       The list of email addresses
     * @throws InternalServiceException It will be thrown if the parameters are not correct or if something else happens
     */
    void sendEmail(String templateName, String subject, Map<String, String> values, String... emails) throws InternalServiceException;
}
