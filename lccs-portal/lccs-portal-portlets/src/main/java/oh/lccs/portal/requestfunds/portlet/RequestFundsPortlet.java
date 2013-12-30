package oh.lccs.portal.requestfunds.portlet;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("VIEW")
@Controller
public class RequestFundsPortlet {

	
	private static final String SEARCH_RESULT = "requestFunds/searchResult";
	private static final String SEARCH_FORM = " requestFunds  /searchForm";
	
	
	@Autowired
	private RequestFundsFormConverter formConverter;
	
	@Autowired
	private RequestFundsDTOConverter dtoConverter;
	
	@Autowired
	@Qualifier(LucasServiceConstants.REQUEST_FUNDS_SERVICE)
	private RequestFundsService requestFundsService;

	@RenderMapping
	public ModelAndView loadForm() {
		 final Map<String, Object> model = new HashMap<String, Object>();
		 return new ModelAndView(SEARCH_FORM,model);
	}
	

	@RenderMapping(params="sacwisApplication=searchForm")
	public ModelAndView searchForm(RequestFundsForm form){
		final Map<String, Object> model = new HashMap<String, Object>();
		RequestFundsDTO dto = formConverter.convert(form);
		dto = requestFundsService.searchForm(dto );
		RequestFundsForm searchResult=dtoConverter.convert(dto);
		
		model.put("SACWIS_SEARCH_RESULT",searchResult);
		return new ModelAndView(SEARCH_RESULT);
	}
	
	@ModelAttribute("sacwisForm")
	public RequestFundsForm getCommandObject(){
		return new RequestFundsForm();
	}

}
