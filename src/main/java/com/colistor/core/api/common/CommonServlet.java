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
import com.colistor.core.persistence.dbaccess.AccessAnnotation;
import com.colistor.core.persistence.model.User;
import com.colistor.core.services.CommonSI;
import com.colistor.core.services.exception.ServiceException;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommonServlet<T> extends APIHttpServlet {

    public static final String URL_ADD = "add";
    public static final String URL_MODIFY = "modify";
    public static final String URL_DELETE = "delete";

    @Inject
    private Provider<CommonSI<T>> service;

    private T instance;

    @Inject
    public CommonServlet(T instance) {
        this.instance = instance;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, HttpSession session, User user) throws WebException, ServletException, IOException, ServiceException {
        String uri = request.getRequestURL().toString();
        if (uri.contains("/" + URL_DELETE + "/")) {
            String code = uri.substring(uri.lastIndexOf("/") + 1);
            T t = service.get().delete(user.code, code);
        } else if (uri.equals(getRelativePath())) {
            //service.get().
        } else {
            String code = uri.substring(uri.lastIndexOf("/") + 1);
            T t = service.get().findByCode(user.code, code);
            Gson gson = new Gson();
            response.getWriter().print(gson.toJson(t));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session, User user) throws WebException, ServletException, IOException, ServiceException {
        String uri = request.getRequestURL().toString();
        if (uri.contains("/" + URL_ADD + "/")) {
            T tReq = new Gson().fromJson(request.getReader(), (Class<T>) instance.getClass());
            T tResp = service.get().add(user.code, tReq);
            response.getWriter().print(new Gson().toJson(tResp));
        } else if (uri.contains("/" + URL_MODIFY + "/")) {
            T tReq = new Gson().fromJson(request.getReader(), (Class<T>) instance.getClass());
            T tResp = null;
            try {
                tResp = service.get().modify(user.code, AccessAnnotation.getCode(tReq), tReq);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            response.getWriter().print(new Gson().toJson(tResp));
        }
    }
}
