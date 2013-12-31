package oh.lccs.portal.requestfunds.converter;

import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.form.RequestFundsForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;

/**
 * Class used to convert a {@code RequestFundsForm} instance to an
 * {@code RequestFundsDTO} instance. 
 * 
 */
@Component
public class RequestFundsFormConverter implements Converter<RequestFundsForm, RequestFundsDTO> {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFundsFormConverter.class);

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public RequestFundsDTO convert(RequestFundsForm requestFundsForm) {
        Preconditions.checkNotNull(requestFundsForm);
        //return new RequestFundsDTO(requestFundsForm.getSacwisId(),requestFundsForm.getSacwisName(),requestFundsForm.getSacwisApproverName());
		return null;
    }
   
}
