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

package com.colistor.core.api;

import com.colistor.core.api.exception.WebControllerI;
import com.colistor.core.api.exception.WebException;
import com.colistor.core.persistence.exception.ExceptionLevel;
import com.colistor.core.persistence.model.User;
import com.colistor.core.tools.CookieManager;
import com.colistor.core.tools.WebParam;
import com.colistor.core.tools.exception.ErrorDBConnection;
import com.colistor.core.tools.international.International;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class WebHttpServlet.
 */
public class APIHttpServlet extends HttpServlet {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The international.
     */
    @Inject
    private Provider<International> international;

    /**
     * The controllers.
     */
    private Map<String, WebControllerI> controllers;

    /**
     * Instantiates a new web http servlet.
     */
    public APIHttpServlet() {
        controllers = new HashMap<String, WebControllerI>();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = null;
        if (session != null
                && session.getAttribute(WebParam.SESSION_USER) != null) {
            user = (User) session.getAttribute(WebParam.SESSION_USER);
        }
        try {
            doGet(request, response, session, user);
        } catch (WebException e) {
            manageException(e, response);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = null;
        if (session != null
                && session.getAttribute(WebParam.SESSION_USER) != null) {
            user = (User) session.getAttribute(WebParam.SESSION_USER);
        }
        try {
            doPost(request, response, session, user);
        } catch (WebException e) {
            manageException(e, response);
        }
    }

    /**
     * Adds the controller.
     *
     * @param controllers the controllers
     */
    protected void addController(WebControllerI... controllers) {
        for (WebControllerI controller : controllers) {
            this.controllers.put(controller.getName(), controller);
        }
    }

    /**
     * Control.
     *
     * @param request the request
     * @param names   the names
     * @return true, if successful
     * @throws WebException the web exception
     */
    protected boolean control(HttpServletRequest request, String... names)
            throws WebException {
        for (String name : names) {
            controllers.get(name).controlRequest(request);
        }
        return true;
    }

    /**
     * Control notnull.
     *
     * @param obj the obj
     * @return true, if successful
     * @throws WebException the web exception
     */
    protected boolean controlNotnull(Object obj) throws WebException {
        if (obj != null) {
            return true;
        }
        throw new WebException(WebException.REQUESTED_ELEMENT_NOT_FOUND);
    }

    /**
     * Control notnull.
     *
     * @param objs the objs
     * @return true, if successful
     * @throws WebException the web exception
     */
    protected boolean controlNotnull(Object... objs) throws WebException {
        for (Object obj : objs) {
            if (obj == null) {
                throw new WebException(WebException.REQUESTED_ELEMENT_NOT_FOUND);
            }
        }
        return true;
    }

    /**
     * Gets the last part ofurl.
     *
     * @param request the request
     * @return the last part ofurl
     */
    protected String getLastPartOFURL(HttpServletRequest request) {
        String uri = request.getRequestURL().toString();
        return uri.substring(uri.lastIndexOf("/") + 1);
    }

    /**
     * Manage exception.
     *
     * @param exception the exception
     * @param resp      the resp
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void manageException(WebException exception,
                                 HttpServletResponse resp) throws IOException {
        if (exception.getRedirection() != null) {
            resp.sendRedirect(exception.getRedirection());
        } else {
            if (!exception.getLevel().getLevel()
                    .equals(ExceptionLevel.VERY_LOW.getLevel())) {
                ErrorDBConnection.get().insertError(exception);
                ErrorPanel panel = errorPanel.get();
                panel.setError(international.get()
                        .getError(exception.getCode()));
                resp.getWriter().print(panel.getCode());
            }
        }
    }

    /**
     * Do get.
     *
     * @param request  the req
     * @param response the resp
     * @param session  the session
     * @param user     the user
     * @throws WebException     the web exception
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response,
                         HttpSession session, User user) throws WebException,
            ServletException, IOException {
        throw new WebException(WebException.FUNCTION_NOT_IMPLEMENTED);
    }

    /**
     * Do post.
     *
     * @param request  the req
     * @param response the resp
     * @param session  the session
     * @param user     the user
     * @throws WebException     the web exception
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response,
                          HttpSession session, User user) throws WebException,
            ServletException, IOException {
        throw new WebException(WebException.FUNCTION_NOT_IMPLEMENTED);
    }


    protected void autoLogin(HttpServletRequest request, HttpSession session,
                             HttpServletResponse response) throws IOException {
        if (session != null
                && session.getAttribute(WebParam.SESSION_USER) == null) {
            Cookie cookie = CookieManager.findCookie(request.getCookies(),
                    WebParam.COOKIE_LONG_SESSION);
            if (cookie != null && cookie.getValue() != null
                    && !cookie.getValue().equals("")) {
                session.setAttribute(WebParam.SESSION_NEXT_PAGE, request
                        .getRequestURL().toString());
                response.sendRedirect(WebParam.SERVER_URL
                        + GuiceServletConfig.LOGIN_URL);
            }
        }
    }

}
