package com.colistor.core.services.exception;

import persistence.exception.ExceptionLevel;
import service.controller.RaisedException;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * Manage exception for the services.
 *
 * @author Joël Favre
 */
public class ServiceException extends Exception {

    /**
     * The Constant PERSON_CONTROLLER.
     */
    public static final String PERSON_CONTROLLER = "srv_peco";

    /**
     * The Constant PERSON_SERVICE.
     */
    public static final String PERSON_SERVICE = "srv_pese";

    /**
     * The Constant CONTRACT_CONTROLLER.
     */
    public static final String CONTRACT_CONTROLLER = "srv_ctco";

    /**
     * The Constant CONTRACT_SERVICE.
     */
    public static final String CONTRACT_SERVICE = "srv_ctse";

    /**
     * The Constant COLLECTION_CONTROLLER.
     */
    public static final String COLLECTION_CONTROLLER = "srv_coco";

    /**
     * The Constant COLLECTION_SERVICE.
     */
    public static final String COLLECTION_SERVICE = "srv_cose";

    /**
     * The Constant COLLECTION_RULER.
     */
    public static final String COLLECTION_RULER = "srv_coru";

    /**
     * The Constant MODELCOLLECTION_CONTROLLER.
     */
    public static final String MODELCOLLECTION_CONTROLLER = "srv_mococo";

    /**
     * The Constant MODELCOLLECTION_SERVICE.
     */
    public static final String MODELCOLLECTION_SERVICE = "srv_mocose";

    /**
     * The Constant INSTANCEOBJECT_CONTROLLER.
     */
    public static final String INSTANCEOBJECT_CONTROLLER = "srv_ioco";

    /**
     * The Constant INSTANCEOBJECT_SERVICE.
     */
    public static final String INSTANCEOBJECT_SERVICE = "srv_iose";

    /**
     * The Constant INSTANCEOBJECT_RULER.
     */
    public static final String INSTANCEOBJECT_RULER = "srv_ioru";

    /**
     * The Constant OBJECT_CONTROLLER.
     */
    public static final String OBJECT_CONTROLLER = "srv_obco";

    /**
     * The Constant OBJECT_SERVICE.
     */
    public static final String OBJECT_SERVICE = "srv_obse";

    /**
     * The Constant OPENID_CONTROLLER.
     */
    public static final String OPENID_CONTROLLER = "srv_opco";

    /**
     * The Constant OPENID_SERVICE.
     */
    public static final String OPENID_SERVICE = "srv_opse";

    /**
     * The Constant ATTRIBUT_CONTROLLER.
     */
    public static final String ATTRIBUT_CONTROLLER = "srv_atco";

    /**
     * The Constant ATTRIBUT_SERVICE.
     */
    public static final String ATTRIBUT_SERVICE = "srv_atse";

    /**
     * The Constant SHARECOLLECTION_CONTROLLER.
     */
    public static final String SHARECOLLECTION_CONTROLLER = "srv_scco";

    /**
     * The Constant SHARECOLLECTION_SERVICE.
     */
    public static final String SHARECOLLECTION_SERVICE = "srv_scse";

    public static final String MODELSTATE_SERVICE = "srv_mdst";
    public static final String MODELSTATE_RULER = "srv_mdstru";

    public static final String INSTANCEOBJECTCOLLECTION_SERVICE = "srv_iocs";

    public static final String INSTANCEOBJECTCOLLECTION_RULER = "srv_iocru";

    public static final String INSTANCEOBJECTCOLLECTION_CONTROLLER = "srv_iocco";

    /**
     * The Constant INTERNAL_ERROR.
     */
    public static final String INTERNAL_ERROR = "srv_internal_error";

    /** The Constant DUPLICATA_EXCEPTION. */
    //public static final String DUPLICATA_EXCEPTION = DAOException.INTEGRITY_CONSTRAINT;

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2376926930061204999L;

    /**
     * The code.
     */
    private String code;

    /**
     * The level.
     */
    private ExceptionLevel level;

    /**
     * The exceptions.
     */
    private List<RaisedException> exceptions;

    /**
     * The code case.
     */
    private int codeCase;

    /**
     * Instantiate an error with just an identifier.
     *
     * @param code unique identifier for the exception
     */
    public ServiceException(String code) {
        this(code, ExceptionLevel.MEDIUM);
    }

    /**
     * Instantiates a new service exception.
     *
     * @param code     the code
     * @param codeCase the code case
     */
    public ServiceException(String code, int codeCase) {
        this(code, ExceptionLevel.MEDIUM, codeCase);
    }

    /**
     * Instantiate an error with an identifier and a level.
     *
     * @param code  Unique identifier for the exception
     * @param level The level of the exception
     */
    public ServiceException(String code, ExceptionLevel level) {
        this.code = code;
        this.level = level;
        this.codeCase = (int) (Math.random() * Integer.MAX_VALUE);
    }

    /**
     * Instantiates a new service exception.
     *
     * @param code     the code
     * @param level    the level
     * @param codeCase the code case
     */
    public ServiceException(String code, ExceptionLevel level, int codeCase) {
        this.code = code;
        this.level = level;
        this.codeCase = codeCase;
    }

    /**
     * Instantiates a new service exception.
     *
     * @param code       Unique identifier for the exception
     * @param level      The level of the exception
     * @param exceptions Sub-exceptions to throw multiple exceptions in one to the
     *                   client, allowing it to be inform of multiple exceptions like
     *                   many unfilled fields in a form
     */
    public ServiceException(String code, ExceptionLevel level,
                            RaisedException... exceptions) {
        this.code = code;
        this.level = level;
        this.exceptions = new ArrayList<RaisedException>();
        this.codeCase = (int) (Math.random() * Integer.MAX_VALUE);
        for (RaisedException e : exceptions) {
            this.exceptions.add(e);
        }
    }

    /**
     * Instantiates a new service exception.
     *
     * @param code       the code
     * @param level      the level
     * @param codeCase   the code case
     * @param exceptions the exceptions
     */
    public ServiceException(String code, ExceptionLevel level, int codeCase,
                            RaisedException... exceptions) {
        this.code = code;
        this.level = level;
        this.exceptions = new ArrayList<RaisedException>();
        this.codeCase = codeCase;
        for (RaisedException e : exceptions) {
            this.exceptions.add(e);
        }
    }

    /**
     * Get the unique identifier of the exception.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Get the level of the exception.
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

    /**
     * Sets the code case.
     *
     * @param codeCase the new code case
     */
    public void setCodeCase(int codeCase) {
        this.codeCase = codeCase;
    }

    /**
     * Get the sub-exceptions. The client will be able to inform the user of
     * many unfilled fields in a form for example
     *
     * @return the exceptions
     */
    public RaisedException[] getExceptions() {
        return exceptions.toArray(new RaisedException[exceptions.size()]);
    }
}
