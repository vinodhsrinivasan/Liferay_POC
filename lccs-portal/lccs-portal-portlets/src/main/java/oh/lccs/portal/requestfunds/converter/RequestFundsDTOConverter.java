package oh.lccs.portal.requestfunds.converter;

import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.form.RequestFundsForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;

/**
 * Class used to convert a {@code RequestFundsDTO} instance to an
 * {@code RequestFundsForm} instance. 
 * 
 */
@Component
public class RequestFundsDTOConverter implements Converter<RequestFundsDTO, RequestFundsForm> {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFundsDTOConverter.class);

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public RequestFundsForm convert(RequestFundsDTO dto) {
        Preconditions.checkNotNull(dto);
        return new RequestFundsForm(dto.getSacwisId(),dto.getRequestedDate(),
        		dto.getRequestingCaseWorker(),dto.getCaseWorker(), dto.getCaseName(),
        		dto.getWorkerPhoneNumber(), dto.getDonation(), dto.getPrePlacement(),
        		dto.getAfterCareIndependence(), dto.getKinshipCare(), dto.getOperating(),
        		dto.getFamilyReunification(), dto.getAlternativeResponse(),
        		dto.getRequestType(), dto.getRequestingForPeople(),
        		dto.getSelectedCaseParticipants(), dto.getPersonRespForPurchase(), dto.getRequestPurpose(),
        		dto.getOtherCommResContacted(), dto.getTotalAmtRequested(),
        		dto.getDateRequired(), dto.getFundMode(), dto.getFundDeliveryType(),
        		dto.getPaymentMadeFor(), dto.getOtherInstructions(), 
        		dto.getFurnitureDeliveryAddress(), dto.getBudgetCenter(), 
        		dto.getLineItem(), dto.getStatusCode(), dto.getApproverName(), dto.getApprover(), 
        		dto.getCreatedBy(),	dto.getCreatedDate(), dto.getModifiedby(), dto.getModifiedDate()); 
    }
   
}
