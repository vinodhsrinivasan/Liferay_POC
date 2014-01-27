package oh.lccs.portal.requestfunds.portlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import oh.lccs.portal.LucasAnnotationConstants;
import oh.lccs.portal.portlet.springmvc.extension.ResourceRequestEntity;
import oh.lccs.portal.requestfunds.converter.RequestFundsDTOConverter;
import oh.lccs.portal.requestfunds.converter.RequestFundsFormConverter;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.form.RequestFundsForm;
import oh.lccs.portal.requestfunds.form.RequestFundsSearchForm;
import oh.lccs.portal.requestfunds.service.RequestFundsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@RequestMapping("VIEW")
@Controller
public class RequestFundsPortlet {

	
	private static final String CASE_DETAILS = "requestFunds/caseDetails";
	
	private static final String SEARCH_FORM = "requestFunds/search";
	
	private static final String FUND_REQUEST_CONFIRMATION = "requestFunds/confirmation";
	
	private static final String RECORD_NOT_FOUND = "requestFunds/recordNotFound";
	
	private static final String SYSTEM_ERROR = "requestFunds/system-error";
	
	/** Credit card application resource ID*/
    private static final String SEARCH_RESOURCE_ID = "searchCaseBasedOnSacwisNumber";
    private static final String FUND_REQUEST_RESOURCE_ID = "fundRequestSubmitURL";

    private static final DateFormat REQUEST_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    
	
	@Autowired
	@Qualifier(LucasAnnotationConstants.REQUEST_FUNDS_SERVICE)
	private RequestFundsService requestFundsService;
	
	@Autowired
	RequestFundsFormConverter fundsFormConverter;
	
	@Autowired
	RequestFundsDTOConverter fundsDTOConverter;
	
	@RenderMapping
	public String loadSearchPage(Model model) {
		
		setMockRequestAttributes(model);
		
		return SEARCH_FORM;
	}


	 @ResourceMapping(value = SEARCH_RESOURCE_ID)
	public String submitSearch(@ResourceRequestEntity @Valid RequestFundsSearchForm requestFundsSearchForm ,Model model) {
		 
		 try {
			 setMockRequestAttributes(model);
			 RequestFundsDTO dto = new RequestFundsDTO();
			 dto.setSacwisId(requestFundsSearchForm.getSacwisId());
			 
			 RequestFundsDTO searchResult = requestFundsService.searchForm(dto);
		
			 if(searchResult.getRequestingForPeople() == null || searchResult.getRequestingForPeople().size() == 0){
				 return RECORD_NOT_FOUND;
			 }
			 RequestFundsForm resultForm = new RequestFundsForm();
			 resultForm = fundsDTOConverter.convert(searchResult);
			 model.addAttribute("caseWorkerDetailsDTO",resultForm);
			
		} catch (Exception e) {
			return SYSTEM_ERROR;
		}
		 
		 return CASE_DETAILS;
	}
	 
	 @ResourceMapping(value = FUND_REQUEST_RESOURCE_ID)
	public String fundRequestSubmit(@ResourceRequestEntity @Valid RequestFundsForm requestFundsForm ,Model model) {
		 RequestFundsDTO dto = new RequestFundsDTO();
		 dto = fundsFormConverter.convert(requestFundsForm);
		 
		 boolean saveFlag = requestFundsService.saveData(dto);
		 if(!saveFlag){
			return SYSTEM_ERROR;
		 }
		return FUND_REQUEST_CONFIRMATION;
	}
	 
	 @ResourceMapping(value = FUND_REQUEST_RESOURCE_ID)
		public String fundRequestApprove(@ResourceRequestEntity @Valid RequestFundsForm requestFundsForm ,Model model) {
			 RequestFundsDTO dto = new RequestFundsDTO();
			 dto = fundsFormConverter.convert(requestFundsForm);
			 
			 boolean saveFlag = requestFundsService.updateData(dto);
			 if(!saveFlag){
				return SYSTEM_ERROR;
			 }
			return FUND_REQUEST_CONFIRMATION;
		} 

	 private void setMockRequestAttributes(Model model) {
		 model.addAttribute("requestingCaseWorker","Mark Waugh");
		 model.addAttribute("workerPhoneNumber","723-123-4567");
		 model.addAttribute("requestedDate",REQUEST_DATE_FORMAT.format( new Date()));
	 }
}
