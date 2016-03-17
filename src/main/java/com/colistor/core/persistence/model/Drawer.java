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
import jodd.vtor.constraint.NotBlank;

@Entity(name = "drawer")
public class Drawer extends UserObject {

    @NotBlank(profiles = {"i,u"})
    @Field(name = "title", insert = true, update = true)
    public String title;

    @Field(name = "description", insert = true, update = true)
    public String description;

    @Field(name = "shares", insert = true, update = true)
    public java.util.List<Share> shares;

}
