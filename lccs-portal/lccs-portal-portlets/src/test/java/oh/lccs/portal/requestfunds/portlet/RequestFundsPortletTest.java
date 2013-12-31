package oh.lccs.portal.requestfunds.portlet;

import static org.junit.Assert.assertEquals;
import oh.lccs.portal.requestfunds.converter.RequestFundsDTOConverter;
import oh.lccs.portal.requestfunds.converter.RequestFundsFormConverter;
import oh.lccs.portal.requestfunds.service.RequestFundsService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

public class RequestFundsPortletTest {
	
	RequestFundsPortlet object;
	/*@Mock private RequestFundsService requestFundsService;
	@Mock private RequestFundsFormConverter formConverter;
	@Mock private RequestFundsDTOConverter dtoConverter;*/
	@Mock private Model model;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		object = new RequestFundsPortlet();
		//sacwisService = mock(SacwisService.class);
		//ReflectionTestUtils.setField(object, "requestFundsService", requestFundsService);
		//ReflectionTestUtils.setField(object, "formConverter", formConverter);
		//ReflectionTestUtils.setField(object, "dtoConverter", dtoConverter);
	}

	@Test
	public void loadForm() {
		String result = object.loadSearchPage(model);
		assertEquals("requestFunds/search", result);
	}
	
	/*@Test
	public void searchForm(){
		RequestFundsForm form =new RequestFundsForm();
		RequestFundsDTO dto = new RequestFundsDTO();
		when(requestFundsService.searchForm(any(RequestFundsDTO.class) )).thenReturn(dto);
		object.searchForm(form,model);
	}*/

}
