package oh.lccs.portal.portlet.springmvc.extension;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Annotation indicating a method parameter should be bound to the body of the Portlet resource request. 
 *  The body of the request is passed through an {@link ResourceRequestEntityAnnotationResolver} to resolve the 
 *  method argument (the supported content type of the request is application/json). 
 *  Optionally, automatic validation can be applied by annotating the argument with {@code @Valid}.
 * 
 * @author compuware developer
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceRequestEntity {
       
}
