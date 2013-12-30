package oh.lccs.portal.requestfunds.portlet;

import java.util.Map;

import oh.lccs.portal.requestfunds.converter.RequestFundsDTOConverter;
import oh.lccs.portal.requestfunds.converter.RequestFundsFormConverter;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.form.RequestFundsForm;
import oh.lccs.portal.requestfunds.portlet.RequestFundsPortlet;
import oh.lccs.portal.requestfunds.service.RequestFundsService;

import org.springframework.web.servlet.ModelAndView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RequestFundsPortletTest {
	
	RequestFundsPortlet object;
	@Mock private RequestFundsService requestFundsService;
	@Mock private RequestFundsFormConverter formConverter;
	@Mock private RequestFundsDTOConverter dtoConverter;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		object = new RequestFundsPortlet();
		//sacwisService = mock(SacwisService.class);
		ReflectionTestUtils.setField(object, "requestFundsService", requestFundsService);
		ReflectionTestUtils.setField(object, "formConverter", formConverter);
		ReflectionTestUtils.setField(object, "dtoConverter", dtoConverter);
	}

	@Test
	public void loadForm() {
		ModelAndView result = object.loadForm();
		assertEquals("sacwis/searchForm", result.getViewName());
	}
	
	@Test
	public void searchForm(){
		RequestFundsForm form =new RequestFundsForm();
		RequestFundsDTO dto = new RequestFundsDTO();
		when(requestFundsService.searchForm(any(RequestFundsDTO.class) )).thenReturn(dto);
		object.searchForm(form);
	}

}
