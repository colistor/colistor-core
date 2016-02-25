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

import jodd.vtor.constraint.MinLength;
import jodd.vtor.constraint.NotBlank;

import java.util.Date;

/**
 * A user refers to the basic values of an account, the owner of some lists, templates, items, ...
 * and an authenticated final user
 */
public class User {

    /**
     * Constants for mapping with the database.
     */
    public static final String TABLE = "user";
    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String EMAIL = "email";
    public static final String FULL_NAME = "fullname";
    public static final String LANGUAGE = "language";
    public static final String PASSWORD = "password";
    public static final String SALT = "salt";
    public static final String CREATE_DATE = "createdate";
    public static final String UPDATE_DATE = "updatedate";
    public static final String LAST_LOGIN = "lastlogin";

    /**
     * The id of the user also known as userId.
     * Is only used inside colistor-core.
     * The id is generated by the database
     * <p>
     * is_u = internal services on update
     * is_d = internal services on delete
     */
    @NotBlank(profiles = {"is_u,is_d"})
    private String id;

    /**
     * The code of the user also known as userCode.
     * May be exposed to the final user
     * The code is generated by the dao.
     * <p>
     * s_u = services on update
     * s_d = services on delete
     */
    @NotBlank(profiles = {"s_u,s_d"})
    private String code;

    /**
     * i = in services and internal services on insert
     * u = in services and internal services on update
     */
    @NotBlank(profiles = {"i,u"})
    private String email;

    /**
     * i = in services and internal services on insert
     * u = in services and internal services on update
     */
    @MinLength(value = 2, profiles = {"i,u"})
    private String fullName;

    /**
     * The language
     */
    private String language;

    /**
     * i = in services and internal services on insert
     * u = in services and internal services on update
     * <p>
     * The password cannot be reached outside the dao.
     * It can only be used to set a new password
     */
    @MinLength(value = 8, profiles = {"i,u"})
    private String password;

    /**
     * Is used by the internal services and dao to secure the password
     * The salt cannot be reached outside the dao
     */
    private String salt;

    /**
     * The date and time when the user has been created.
     * It is inserted by the dao
     */
    private Date createDate;

    /**
     * The date and time when the user's values have been modified.
     * It is inserted/updated by the dao
     */
    private Date updateDate;

    /**
     * The date and time when the user has been authenticated for the last time.
     * It is inserted/updated by the internal services
     */
    private Date lastLogin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
