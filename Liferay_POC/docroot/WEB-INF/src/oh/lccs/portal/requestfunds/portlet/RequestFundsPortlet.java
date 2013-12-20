package oh.lccs.portal.requestfunds.portlet;

import oh.lccs.portal.LucasAnnotationConstants;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.service.RequestFundsService;

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

	
	private static final String SEARCH_RESULT = "sacwis/searchResult";
	private static final String SEARCH_FORM = "sacwis/searchForm";
	
	@Autowired
	@Qualifier(LucasAnnotationConstants.REQUEST_FUNDS_SERVICE)
	private RequestFundsService sacwisService;

	@RenderMapping
	public String loadForm() {
		return SEARCH_FORM;
	}

	@RenderMapping(params="sacwisApplication=searchForm")
	public String searchForm(RequestFundsForm form, Model model){
		
		RequestFundsDTO dto = new RequestFundsDTO();
		dto.formToDTO(form);
		dto = sacwisService.searchForm(dto );
		RequestFundsForm searchResult= new RequestFundsForm();
		dto.dtoToForm(searchResult);
		
		model.addAttribute("SACWIS_SEARCH_RESULT",searchResult);
		
		return SEARCH_RESULT;
	}
	
	@ModelAttribute("sacwisForm")
	public RequestFundsForm getCommandObject(){
		return new RequestFundsForm();
	}

}
