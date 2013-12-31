package oh.lccs.portal.portlet.support;

import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * Bean validation exception that will be thrown if a bean field violate a JSR 303 validation constraint.
 * 
 * @author compuware developer
 * 
 */
public class ValidationException extends RuntimeException {

    /** serial version*/
    private static final long serialVersionUID = -2885719457446605314L;
    
    /** constraint violation set*/
    private final Set<ConstraintViolation<Object>> violations;

    /**
     * Constructor with a list of constraint violations as parameter.
     * 
     * @param violations constraint violation set
     */
    public ValidationException(Set<ConstraintViolation<Object>> violations) {
        super();
        this.violations = violations;
    }

    /**
     * returns constraint violation set
     * 
     * @return {@code Set<ConstraintViolation<Object>>}
     */
    public Set<ConstraintViolation<Object>> getViolations() {
        return violations;
    }
    
    

}
