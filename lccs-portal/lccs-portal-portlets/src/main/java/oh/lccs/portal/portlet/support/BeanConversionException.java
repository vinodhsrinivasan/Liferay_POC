package oh.lccs.portal.portlet.support;

/**
 * Bean conversion exception that will be thrown if a form converter call pick up an error.
 * 
 * @author compuware developer
 * 
 */
public class BeanConversionException extends RuntimeException {

    /** serial version*/
    private static final long serialVersionUID = -7914144578302634602L;

    

    /**
     * Default constructor
     */
    public BeanConversionException() {
        super();
    }

    /**
     * Constructor with exception message as parameters
     * 
     * @param message
     *            exception message
     */
    public BeanConversionException(String message) {
        super(message);
    }
    
    /**
     * Constructor with exception cause as parameters
     * 
     * @param ex
     *            Exception
     */
    public BeanConversionException(Throwable cause) {
        super(cause);
    }
}
