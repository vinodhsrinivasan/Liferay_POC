package oh.lccs.portal.portlet.springmvc.extension;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;

import oh.lccs.portal.portlet.support.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.handler.AbstractHandlerExceptionResolver;


/**
 * Spring exception resolver class for resolving a {@code ValidationException}
 * thrown while a handler controller method argument validation is applied.
 * 
 * The method argument must be annotated {@code @ResourceRequestEntity}.
 * 
 * @author compuware developer
 * 
 */
public class ValidationExceptionResolver extends AbstractHandlerExceptionResolver {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationExceptionResolver.class);

    /** View to render */
    private static final String MODEL_VIEW = "bean-validation-errors";
    /** constraints model parameter key */
    private static final String CONSTRAINTS_MODEL_PARAM_KEY = "constraints";

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.portlet.handler.AbstractHandlerExceptionResolver
     * #doResolveException(javax.portlet.PortletRequest,
     * javax.portlet.MimeResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    protected ModelAndView doResolveException(PortletRequest request, MimeResponse response, Object handler,
            Exception ex) {
        if (ex instanceof ValidationException) {
            try {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put(CONSTRAINTS_MODEL_PARAM_KEY, ((ValidationException) ex).getViolations());
                return new ModelAndView(MODEL_VIEW, model);
            } catch (Exception e) {
                LOGGER.error("Error while resolving the exception : ValidationException", e);
                return null;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.portlet.handler.AbstractHandlerExceptionResolver
     * #getOrder()
     */
    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
