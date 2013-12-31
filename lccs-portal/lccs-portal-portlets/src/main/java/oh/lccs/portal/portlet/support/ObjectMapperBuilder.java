package oh.lccs.portal.portlet.support;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.base.Strings;

/**
 * Class builder that help to build an JSON object mapper based on Jackson library.
 * 
 * @author compuware developer
 * 
 */
public final class ObjectMapperBuilder {

    /** builder static instance*/
    private static ObjectMapperBuilder instance = new ObjectMapperBuilder();
    
    /**
     * returns the static builder instance.
     * 
     * @return {@code ObjectMapperBuilder}
     */
    public static ObjectMapperBuilder instance(){
        return instance;
    }
    
    /**
     * Method called to build an Object Mapper.
     * 
     * @return {@code ObjectMapper}
     */
    public ObjectMapper build() {
        ObjectMapper m = new ObjectMapper();
        m.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        m.registerModule(this.createModule());
        return m;
    }
    
    /**
     * Method that create a simple module with a local {@code } EmptyToNullStringDeserializer instance.
     * @return {@code Module}
     */
    private Module createModule() {
        SimpleModule m = new SimpleModule("simple", Version.unknownVersion());
        m.addDeserializer(String.class, new EmptyToNullStringDeserializer());
        return m;
    }
    
    /**
     * Inner class used as {@code StdScalarDeserializer} and It help us to convert the empty string to null
     * while deserializing a JSON content to an object instance
     *
     */
    private static class EmptyToNullStringDeserializer extends StdScalarDeserializer<String> {
        
        /** serial version*/
        private static final long serialVersionUID = 1L;
        /** {@code StringDeserializer} delegate*/
        private final StringDeserializer delegate;

        /** Default constructor*/
        protected EmptyToNullStringDeserializer() {
            super(String.class);
            this.delegate = new StringDeserializer();
        }

        /* (non-Javadoc)
         * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            String s = this.delegate.deserialize(jp, ctxt);
            if (Strings.isNullOrEmpty(s)) {
                s = null;
            }
            return s;
        }
        
    }
    
    /** private default constructor used to instance the builder as a singleton*/
    private ObjectMapperBuilder(){}
}