package oh.lccs.portal.requestfunds.portlet;

import oh.lccs.portal.requestfunds.dto.SacwisDTO;
import oh.lccs.portal.requestfunds.portlet.SacwisApplicationPortlet;
import oh.lccs.portal.requestfunds.portlet.SacwisForm;
import oh.lccs.portal.requestfunds.service.RequestFundsService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SacwisApplicationPortletTest {
	
	SacwisApplicationPortlet object;
	@Mock private Model model;
	@Mock private RequestFundsService sacwisService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		object = new SacwisApplicationPortlet();
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
		SacwisForm form =new SacwisForm();
		SacwisDTO dto = new SacwisDTO();
		dto.formToDTO(form);
		when(sacwisService.searchForm(any(SacwisDTO.class) )).thenReturn(dto);
		object.searchForm(form, model);
	}

}
