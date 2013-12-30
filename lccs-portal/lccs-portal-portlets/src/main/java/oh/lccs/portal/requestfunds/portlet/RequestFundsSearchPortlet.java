package oh.lccs.portal.requestfunds.portlet;

import oh.lccs.portal.LucasAnnotationConstants;
import oh.lccs.portal.requestfunds.dto.RequestFundsSearchDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@RequestMapping("VIEW")
@Controller
public class RequestFundsSearchPortlet {

	
	private static final String SEARCH_RESULT = "sacwis/searchResult";
	private static final String SEARCH_FORM = "sacwis/searchForm";
	
	@Autowired
	@Qualifier(LucasAnnotationConstants.REQUEST_FUNDS_SERVICE)

	@RenderMapping
	public String loadForm() {
		return SEARCH_FORM;
	}

	@RenderMapping(params="sacwisApplication=searchForm")
	public String searchForm(RequestFundsSearchForm form, Model model){
		
		RequestFundsSearchDTO dto = new RequestFundsSearchDTO();
		dto.formToDTO(form);
		
		return SEARCH_RESULT;
	}
	
	@ModelAttribute("sacwisForm")
	public RequestFundsForm getCommandObject(){
		return new RequestFundsForm();
	}

}
