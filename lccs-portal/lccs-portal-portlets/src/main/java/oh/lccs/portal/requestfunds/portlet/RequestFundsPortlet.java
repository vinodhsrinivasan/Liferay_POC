package oh.lccs.portal.requestfunds.portlet;

import oh.lccs.portal.requestfunds.converter.RequestFundsDTOConverter;
import oh.lccs.portal.requestfunds.converter.RequestFundsFormConverter;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.form.RequestFundsForm;
import oh.lccs.portal.requestfunds.service.RequestFundsService;
import oh.lccs.portal.service.constants.LucasServiceConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@RequestMapping("VIEW")
@Controller
public class RequestFundsPortlet {

	
	private static final String SEARCH_RESULT = "requestFunds/searchResult";
	private static final String SEARCH_FORM = "requestFunds/searchForm";
	
	
	@Autowired
	private RequestFundsFormConverter formConverter;
	
	@Autowired
	private RequestFundsDTOConverter dtoConverter;
	
	@Autowired
	@Qualifier(LucasServiceConstants.REQUEST_FUNDS_SERVICE)
	private RequestFundsService requestFundsService;

	@RenderMapping
	public String loadForm() {
		 return SEARCH_FORM;
	}
	

	@RenderMapping(params="requestFundsApplication=searchForm")
	public String searchForm(RequestFundsForm form, Model model){
		
		RequestFundsDTO dto = formConverter.convert(form);
		dto = requestFundsService.searchForm(dto );
		RequestFundsForm searchResult=dtoConverter.convert(dto);
		
		model.addAttribute("SACWIS_SEARCH_RESULT",searchResult);
		return SEARCH_RESULT;
	}
	
	@ModelAttribute("requestFundsForm")
	public RequestFundsForm getCommandObject(){
		return new RequestFundsForm();
	}

}
