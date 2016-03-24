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

import com.colistor.core.persistence.model.*;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

public class GuiceInternalServices extends AbstractModule {

    @Override
    protected void configure() {

        //User
        bind(new TypeLiteral<CommonISI<User>>() {
        }).to(new TypeLiteral<CommonIS<User>>() {
        }).in(Singleton.class);

        //Drawer
        bind(new TypeLiteral<CommonISI<Drawer>>() {
        }).to(new TypeLiteral<CommonIS<Drawer>>() {
        }).in(Singleton.class);

        //Comment
        bind(new TypeLiteral<CommonISI<Comment>>() {
        }).to(new TypeLiteral<CommonIS<Comment>>() {
        }).in(Singleton.class);

        //Appointment
        bind(new TypeLiteral<CommonISI<Appointment>>() {
        }).to(new TypeLiteral<CommonIS<Appointment>>() {
        }).in(Singleton.class);

        //ListTemplate
        bind(new TypeLiteral<CommonISI<ListTemplate>>() {
        }).to(new TypeLiteral<CommonIS<ListTemplate>>() {
        }).in(Singleton.class);

        //ItemTemplate
        bind(new TypeLiteral<CommonISI<ItemTemplate>>() {
        }).to(new TypeLiteral<CommonIS<ItemTemplate>>() {
        }).in(Singleton.class);

        //List
        bind(new TypeLiteral<CommonISI<List>>() {
        }).to(new TypeLiteral<CommonIS<List>>() {
        }).in(Singleton.class);

        //Item
        bind(new TypeLiteral<CommonISI<Item>>() {
        }).to(new TypeLiteral<CommonIS<Item>>() {
        }).in(Singleton.class);
    }
}
