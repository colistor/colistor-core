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

package com.colistor.core.tools.exception;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.colistor.core.api.exception.WebException;
import com.colistor.core.persistence.exception.DAOException;
import com.colistor.core.persistence.exception.ExceptionLevel;
import com.colistor.core.services.exception.ServiceException;
import com.colistor.core.tools.Context;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class ErrorDBConnection.
 */
public class ErrorDBConnection {

    /**
     * The db connection.
     */
    private static ErrorDBConnection dbConnection;
    /**
     * The db.
     */
    private SQLiteConnection db;

    /**
     * Instantiates a new error db connection.
     */
    public ErrorDBConnection() {
        if (Context.USE_ERROR_DATABASE) {
            db = new SQLiteConnection(new File(Context.PATH_ERROR_DATABASE));
            try {
                db.open(true);
            } catch (SQLiteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets the.
     *
     * @return the error db connection
     */
    public static ErrorDBConnection get() {
        if (dbConnection == null) {
            dbConnection = new ErrorDBConnection();
        }
        return dbConnection;
    }

    /**
     * Insert error.
     *
     * @param error the error
     */
    public synchronized void insertError(DAOException error) {
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        insertError(error.getCodeCase(), "DAOException", new Date(),
                error.getCode(), sw.toString(), error.getLevel());
    }

    /**
     * Insert error.
     *
     * @param error the error
     */
    public synchronized void insertError(WebException error) {
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        insertError(error.getCodeCase(), "WEBException", new Date(),
                error.getCode(), sw.toString(), error.getLevel());
    }

    /**
     * Insert error.
     *
     * @param error the error
     */
    public synchronized void insertError(ServiceException error) {
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        insertError(error.getCodeCase(), "ServiceException", new Date(),
                error.getCode(), sw.toString(), error.getLevel());
    }

    /**
     * Insert error.
     *
     * @param error    the error
     * @param codeCase the code case
     * @param level    the level
     */
    public synchronized void insertError(SQLException error, int codeCase,
                                         ExceptionLevel level) {
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        insertError(codeCase, "SQLException", new Date(), error.getSQLState(),
                sw.toString(), level);
    }

    public synchronized void insertError(Exception error, int codeCase,
                                         ExceptionLevel level) {
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        insertError(codeCase, "Exception", new Date(), error.getMessage(),
                sw.toString(), level);
    }

    public synchronized void insertError(Exception error, ExceptionLevel level) {
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        insertError((int) (Math.random() * Integer.MAX_VALUE), "Exception",
                new Date(), error.getMessage(), sw.toString(), level);
    }

    /**
     * Insert error.
     *
     * @param type      the type
     * @param codeError the code error
     * @param e         the e
     * @param level     the level
     */
    public synchronized void insertError(String type, String codeError,
                                         Exception e, ExceptionLevel level) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        insertError((int) Math.random(), type, new Date(), codeError,
                sw.toString(), level);
    }

    /**
     * Insert error.
     *
     * @param codeCase  the code case
     * @param type      the type
     * @param timeEvent the time event
     * @param codeError the code error
     * @param message   the message
     * @param level     the level
     */
    public synchronized void insertError(int codeCase, String type,
                                         Date timeEvent, String codeError, String message,
                                         ExceptionLevel level) {
        if (Context.USE_ERROR_DATABASE) {
            SQLiteStatement st = null;
            try {
                st = db.prepare("INSERT INTO [exception] ([codecase], [type], [eventtime], [codeerror], [message], [level]) VALUES (?,?,?,?,?,?);");
                st.bind(1, codeCase);
                st.bind(2, type);
                st.bind(3, timeEvent.getTime());
                st.bind(4, codeError);
                st.bind(5, message);
                st.bind(6, level.getLevel());
                st.step();
            } catch (SQLiteException e) {
                e.printStackTrace();
            } finally {
                st.dispose();
            }
        } else {
            System.out.println("********************");
            System.out.println("CodeCase:" + codeCase);
            System.out.println("Type:" + type);
            System.out.println("Time:" + timeEvent);
            System.out.println("codeError:" + codeError);
            System.out.println("Level:" + level.getLevel());
            System.out.println("Message:" + message);
            System.out.println("********************");
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#finalize()
     */
    @Override
    protected void finalize() throws Throwable {
        db.dispose();
        super.finalize();
    }

}
