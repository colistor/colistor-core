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

package com.colistor.core.persistence.exception;

import com.colistor.core.tools.exception.ErrorDBConnection;

import java.sql.SQLException;

// TODO: Auto-generated Javadoc

/**
 * Manage exception for DAO. The DAOObjects cannot throw SQLException because
 * it's a nonsense for the upper layers, they don't care of witch technology is
 * used. So this DAOException is the correct abstraction for the persistence
 * package.
 *
 * @author Joël Favre
 */
public class DAOException extends Exception {

    /**
     * The Constant ERROR_WHILE_RETRIEVING_OBJECT.
     */
    public static final String ERROR_WHILE_RETRIEVING_OBJECT = "errorWhileRetrievingObject";

    /**
     * The Constant ERROR_WHILE_INSERTING_OBJECT.
     */
    public static final String ERROR_WHILE_INSERTING_OBJECT = "errorWhileInsertingObject";

    /**
     * The Constant ERROR_WHILE_MODIFYING_OBJECT.
     */
    public static final String ERROR_WHILE_MODIFYING_OBJECT = "errorWhileModfyingObject";

    /**
     * The Constant ERROR_WHILE_ERASING_OBJECT.
     */
    public static final String ERROR_WHILE_ERASING_OBJECT = "errorWhileErasingObject";

    /**
     * The Constant ERROR_NO_IMPLEMENTATION.
     */
    public static final String ERROR_NO_IMPLEMENTATION = "noImplementation";

    /**
     * The Constant INTEGRITY_CONSTRAINT.
     */
    public static final String INTEGRITY_CONSTRAINT = "dao_integrityconstraint";

    /**
     * The Constant INTERNAL_ERROR.
     */
    public static final String INTERNAL_ERROR = "internalerror";

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 7368299789196887608L;

    /**
     * The code.
     */
    private String code;

    /**
     * The level.
     */
    private ExceptionLevel level;

    /**
     * The code case.
     */
    private int codeCase;

    /**
     * Create a DAOException with only a code corresponding to the exception,
     * the ExceptionLevel is ExceptionLevel.MEDIUM
     *
     * @param code The code should be one of the constant of this class
     */
    public DAOException(String code) {
        this(code, ExceptionLevel.MEDIUM,
                (int) (Math.random() * Integer.MAX_VALUE));
    }

    /**
     * Create a DAOException with a code corresponding to the exception and a
     * level.
     *
     * @param code  the code
     * @param level the level
     */
    public DAOException(String code, ExceptionLevel level) {
        this(code, level, (int) (Math.random() * Integer.MAX_VALUE));
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param code     the code
     * @param level    the level
     * @param codeCase the code case
     */
    public DAOException(String code, ExceptionLevel level, int codeCase) {
        this.code = code;
        this.level = level;
        this.codeCase = codeCase;
    }

    /**
     * Do the job to do in each catch statement after trying to retrieve.
     *
     * @param e The exception
     * @return the DAO exception
     */
    public static DAOException declareRetrieveException(SQLException e) {
        DAOException daoExc = new DAOException(ERROR_WHILE_RETRIEVING_OBJECT,
                ExceptionLevel.HIGH);
        ErrorDBConnection.get().insertError(e, daoExc.getCodeCase(),
                daoExc.getLevel());
        return daoExc;
    }

    /**
     * Do the job to do in each catch statement after trying to insert.
     *
     * @param e The exception
     * @return the DAO exception
     */
    public static DAOException declareInsertException(SQLException e) {
        DAOException daoExc = null;
        daoExc = new DAOException(ERROR_WHILE_INSERTING_OBJECT,
                ExceptionLevel.LOW);
        ErrorDBConnection.get().insertError(e, daoExc.getCodeCase(),
                daoExc.getLevel());
        return daoExc;
    }

    /**
     * Do the job to do in each catch statement after trying to modify.
     *
     * @param e The exception
     * @return the DAO exception
     */
    public static DAOException declareModifyException(SQLException e) {
        DAOException daoExc = null;
        daoExc = new DAOException(ERROR_WHILE_MODIFYING_OBJECT);
        ErrorDBConnection.get().insertError(e, daoExc.getCodeCase(),
                daoExc.getLevel());
        return daoExc;
    }

    /**
     * Do the job to do in each catch statement after trying to erase.
     *
     * @param e The exception
     * @return the DAO exception
     */
    public static DAOException declareEraseException(SQLException e) {
        DAOException daoExc = null;
        daoExc = new DAOException(ERROR_WHILE_ERASING_OBJECT);
        ErrorDBConnection.get().insertError(e, daoExc.getCodeCase(),
                daoExc.getLevel());
        return daoExc;
    }

    /**
     * Declare no implementation.
     *
     * @return the DAO exception
     */
    public static DAOException declareNoImplementation() {
        DAOException daoExc = new DAOException(ERROR_NO_IMPLEMENTATION,
                ExceptionLevel.HIGH);
        ErrorDBConnection.get().insertError(daoExc);
        return daoExc;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public ExceptionLevel getLevel() {
        return level;
    }

    /**
     * Gets the code case.
     *
     * @return the code case
     */
    public int getCodeCase() {
        return codeCase;
    }
}
