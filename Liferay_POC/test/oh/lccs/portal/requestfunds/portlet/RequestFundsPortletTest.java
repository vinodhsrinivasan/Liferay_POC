package oh.lccs.portal.requestfunds.portlet;

import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.portlet.RequestFundsPortlet;
import oh.lccs.portal.requestfunds.portlet.RequestFundsForm;
import oh.lccs.portal.requestfunds.service.RequestFundsService;

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
	@Mock private Model model;
	@Mock private RequestFundsService sacwisService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		object = new RequestFundsPortlet();
		//sacwisService = mock(SacwisService.class);
		ReflectionTestUtils.setField(object, "sacwisService", sacwisService);
	}

	@Test
	public void loadForm() {
		String result = object.loadForm();
		assertEquals("sacwis/searchForm", result);
	}
	
	@Test
	public void searchForm(){
		RequestFundsForm form =new RequestFundsForm();
		RequestFundsDTO dto = new RequestFundsDTO();
		dto.formToDTO(form);
		when(sacwisService.searchForm(any(RequestFundsDTO.class) )).thenReturn(dto);
		object.searchForm(form, model);
	}

}
