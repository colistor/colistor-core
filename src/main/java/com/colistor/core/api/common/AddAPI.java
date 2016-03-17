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
package com.colistor.core.api.common;

import com.colistor.core.api.APIHttpServlet;
import com.colistor.core.api.exception.WebException;
import com.colistor.core.persistence.model.User;
import com.colistor.core.services.CommonSI;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Singleton
public class AddAPI<T> extends APIHttpServlet {

    @Inject
    private Provider<CommonSI<T>> service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session, User user) throws WebException, ServletException, IOException {

    }
}
