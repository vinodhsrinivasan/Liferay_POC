package oh.lccs.portal.portlet.springmvc.extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

import javax.portlet.ResourceRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import oh.lccs.portal.portlet.support.ObjectMapperBuilder;
import oh.lccs.portal.portlet.support.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.portlet.context.PortletWebRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Spring web argument resolver class for resolving custom arguments for a
 * specific handler method parameter if the argument is annotating with
 * {@code ResourceRequestEntity}.
 * 
 * The bean validation can be applied by annotating the argument with
 * {@code @Valid}.
 * 
 * @author compuware developer
 * 
 */
public class ResourceRequestEntityAnnotationResolver implements WebArgumentResolver {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceRequestEntityAnnotationResolver.class);

    /** JSON Mapper based on Jackson Lib */
    private final ObjectMapper mapper;

    /** JSR 303 validator */
    private final Validator validator;

    /**
     * Default constructor
     */
    public ResourceRequestEntityAnnotationResolver() {
        mapper = ObjectMapperBuilder.instance().build();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.bind.support.WebArgumentResolver#resolveArgument
     * (org.springframework.core.MethodParameter,
     * org.springframework.web.context.request.NativeWebRequest)
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {
        final ResourceRequestEntity requestFormEntityAnnotation = methodParameter
                .getParameterAnnotation(ResourceRequestEntity.class);

        if (requestFormEntityAnnotation != null && !isUnresolvedRequestType(webRequest)) {
            try {
                PortletWebRequest portalWebrequest = (PortletWebRequest) webRequest;
                ResourceRequest resourceRequest = (ResourceRequest) portalWebrequest.getRequest();
                Object entity = extractValue(resourceRequest.getReader(), methodParameter.getParameterType());
                // entity is resolved
                Valid validAnnotation = methodParameter.getParameterAnnotation(Valid.class);
                if (entity != WebArgumentResolver.UNRESOLVED && validAnnotation != null) {
                    Set<ConstraintViolation<Object>> violations = this.validator.validate(entity);
                    if (!violations.isEmpty()) {
                        throw new ValidationException(violations);
                    }
                }

                return entity;
            } catch (IOException e) {
                LOGGER.error("Resolve argument Error:  ", e);
            }
        }
        return WebArgumentResolver.UNRESOLVED;
    }

    /**
     * Method indicating if the provided {@code NativeWebRequest} is unresolved
     * or not. The resolved {@code NativeWebRequest} must contains a Resource
     * request.
     * 
     * @param webRequest
     *            {@code NativeWebRequest}
     * @return boolean
     */
    private boolean isUnresolvedRequestType(NativeWebRequest webRequest) {
        if (!(webRequest instanceof PortletWebRequest)) {
            return true;
        }
        PortletWebRequest portalWebRequest = (PortletWebRequest) webRequest;
        if (!(portalWebRequest.getRequest() instanceof ResourceRequest)) {
            LOGGER.info("The provided webRequest is not a ResourceRequest instance");
            return true;
        }
        return false;

    }

    /**
     * Method called to unmarshall the provided {@code BufferedReader} to an
     * instance of the provided generic type.
     * 
     * @param requestBody
     *            {@code BufferedReader}
     * @param type
     *            class type
     * @return <T> the provided generic type
     */
    private <T> Object extractValue(BufferedReader requestBody, Class<T> type) {
        try {
            return this.mapper.readValue(requestBody, type);
        } catch (JsonParseException e) {
            LOGGER.error("Request entity content is not acceptable (not a JSON format).", e);
        } catch (JsonMappingException e) {
            LOGGER.error(String.format("Request entity can't be unmarshalled to an instance of '%s' - %s.", type
                    .getClass().getName(), e.getPath()), e);
        } catch (IOException e) {
            LOGGER.error("Error while reading Request entity.", e);
        }
        return WebArgumentResolver.UNRESOLVED;
    }
}
