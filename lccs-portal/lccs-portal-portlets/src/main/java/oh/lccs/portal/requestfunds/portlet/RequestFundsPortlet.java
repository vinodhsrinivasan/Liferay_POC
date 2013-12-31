package oh.lccs.portal.requestfunds.portlet;

import javax.validation.Valid;

import oh.lccs.portal.requestfunds.form.RequestFundsSearchForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@RequestMapping("VIEW")
@Controller
public class RequestFundsPortlet {

	
	private static final String SEARCH_RESULT = "requestFunds/caseDetails";
	private static final String SEARCH_FORM = "requestFunds/search";
	
	/** Credit card application resource ID*/
    private static final String SEARCH_RESOURCE_ID = "searchCaseBasedOnSacwisNumber";
    
	
	//@Autowired
	//@Qualifier(LucasAnnotationConstants.REQUEST_FUNDS_SERVICE)
	//private RequestFundsService sacwisService;
	
	@RenderMapping
	public String loadSearchPage(Model model) {
		
		model.addAttribute("requestingCaseWorker","Requesting Case Worker");
		model.addAttribute("workerPhoneNumber","Worker Phone Number");
		model.addAttribute("requestedDate","Requested Date");
		return SEARCH_FORM;
	}

	 @ResourceMapping(value = SEARCH_RESOURCE_ID)
	public String loadSearchPage(@ModelAttribute @Valid RequestFundsSearchForm form ,Model model) {
		
		return SEARCH_RESULT;
	}

}
