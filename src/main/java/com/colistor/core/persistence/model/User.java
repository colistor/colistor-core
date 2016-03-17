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

import com.colistor.core.persistence.dbaccess.Entity;
import com.colistor.core.persistence.dbaccess.Field;
import jodd.vtor.constraint.MinLength;
import jodd.vtor.constraint.NotBlank;

import java.util.Date;

/**
 * A user refers to the basic values of an account, the owner of some lists, templates, items, ...
 * and an authenticated final user
 */
@Entity(name = "user")
public class User extends StandardObject {

    /**
     * i = in services and internal services on insert
     * u = in services and internal services on update
     */
    @NotBlank(profiles = {"i,u"})
    @Field(name = "email", insert = true, update = true)
    public String email;

    /**
     * i = in services and internal services on insert
     * u = in services and internal services on update
     */
    @MinLength(value = 2, profiles = {"i,u"})
    @Field(name = "fullname", insert = true, update = true)
    public String fullName;

    /**
     * The language
     */
    @Field(name = "lang", insert = true, update = true)
    public String lang;

    /**
     * i = in services and internal services on insert
     * u = in services and internal services on update
     * <p>
     * The password cannot be reached outside the dao.
     * It can only be used to set a new password
     */
    @MinLength(value = 8, profiles = {"i,u"})
    @Field(name = "password", insert = true, update = true)
    public transient String password;

    /**
     * Is used by the internal services and dao to secure the password
     * The salt cannot be reached outside the dao
     */
    @Field(name = "salt", insert = true)
    public transient String salt;

    /**
     * The date and time when the user has been authenticated for the last time.
     * It is inserted/updated by the internal services
     */
    @Field(name = "lastlogin", update = true)
    public Date lastLogin;

}
