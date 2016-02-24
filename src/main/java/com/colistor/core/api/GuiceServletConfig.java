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

import com.colistor.core.api.user.ModifyUser;
import com.colistor.core.api.user.RegisterUser;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * The Class GuiceServletConfig.
 */
public class GuiceServletConfig extends GuiceServletContextListener {

    /**
     * The Constant API_URL.
     */
    public static final String API = "/api";

    public static final String API_CABINET = "/api/cabinet";

    /**
     * The Constant API_MODEL_URL.
     */
    public static final String API_TABLE = "/api/table";

    /**
     * The Constant API_LOGIN_URL.
     */
    public static final String API_ACCOUNT = "/api/account";
    public static final String API_ACCOUNT_REGISTER = "/api/account/register";
    public static final String API_ACCOUNT_LOGIN = "/api/account/login";
    public static final String API_ACCOUNT_MODIFY = "/api/account/update";
    public static final String API_ACCOUNT_DELETE = "/api/account/delete";


    /*
     * (non-Javadoc)
     *
     * @see com.google.inject.servlet.GuiceServletContextListener#getInjector()
     */
    @Override
    protected Injector getInjector() {

        return Guice.createInjector(
                new ServletModule() {

                    @Override
                    protected void configureServlets() {
                        /* Account */
                        serve(API_ACCOUNT_REGISTER).with(RegisterUser.class);
                        serve(API_ACCOUNT_MODIFY).with(ModifyUser.class);


						/* API */
						/*
						 * serve(API_MODEL_URL).with(APIModelServlet.class);
						 * serve(API_LOGIN_URL).with(APILoginServlet.class);
						 * serveRegex( API_COLLECTION_URL,
						 * API_MY_COLLECTIONS_URL, API_SHARED_COLLECTIONS_URL,
						 * API_COLLECTION_VIEWMETA +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})").with(
						 * APICollectionServlet.class); serveRegex(
						 * API_COLLECTION_VIEW_URL +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})").with(
						 * APIViewCollectionByStateServlet.class); serveRegex(
						 * API_COLLECTION_VIEWITEM_URL +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})").with(
						 * APIViewInstanceObjectServlet.class); serveRegex(
						 * API_FORM_ADD_COLLECTION_URL +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})",
						 * API_FORM_MODIFY_COLLECTION_URL +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})").with(
						 * APICollectionFormServlet.class);
						 * serve(API_FORM_DELETE_COLLECTION_URL).with(
						 * APIDelCollectionFormServlet.class);
						 * serve(API_FORM_MODIFY_INSTANCEOBJECT_URL,
						 * API_FORM_ADD_INSTANCEOBJECT_URL).with(
						 * APIEditInstanceObjectFormServlet.class); serveRegex(
						 * API_MODEL_VIEW_URL +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})").with(
						 * APIViewModelCollectionServlet.class);
						 * serve(API_FORM_DELETE_INSTANCEOBJECT_URL).with(
						 * APIDelInstanceObjectFormServlet.class); serveRegex(
						 * API_COLLECTION_SHARE_URL +
						 * "/(([a-z]|[A-Z]|[0-9]){1,})").with(
						 * APIShareCollectionServlet.class);
						 * serve(API_FORM_ADD_RIGHT, API_FORM_MOD_RIGHT,
						 * API_FORM_DEL_RIGHT).with(
						 * APIEditShareCollectionFormServlet.class);
						 */

						/* Main */
                        //serve("/").with(MainServlet.class);
                    }
                });
    }

}
