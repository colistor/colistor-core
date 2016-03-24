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
package com.colistor.core.services;

import com.colistor.core.persistence.model.*;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

public class GuiceService extends AbstractModule {

    @Override
    protected void configure() {

        //User
        bind(UserSI.class).to(UserS.class).in(Singleton.class);

        //Drawer
        bind(new TypeLiteral<CommonSI<Drawer>>() {
        }).to(new TypeLiteral<CommonS<Drawer>>() {
        }).in(Singleton.class);

        //Comment
        bind(new TypeLiteral<CommonSI<Comment>>() {
        }).to(new TypeLiteral<CommonS<Comment>>() {
        }).in(Singleton.class);

        //Appointment
        bind(new TypeLiteral<CommonSI<Appointment>>() {
        }).to(new TypeLiteral<CommonS<Appointment>>() {
        }).in(Singleton.class);

        //ListTemplate
        bind(new TypeLiteral<CommonSI<ListTemplate>>() {
        }).to(new TypeLiteral<CommonS<ListTemplate>>() {
        }).in(Singleton.class);

        //ItemTemplate
        bind(new TypeLiteral<CommonSI<ItemTemplate>>() {
        }).to(new TypeLiteral<CommonS<ItemTemplate>>() {
        }).in(Singleton.class);

        //List
        bind(new TypeLiteral<CommonSI<List>>() {
        }).to(new TypeLiteral<CommonS<List>>() {
        }).in(Singleton.class);

        //Item
        bind(new TypeLiteral<CommonSI<Item>>() {
        }).to(new TypeLiteral<CommonS<Item>>() {
        }).in(Singleton.class);
    }
}
