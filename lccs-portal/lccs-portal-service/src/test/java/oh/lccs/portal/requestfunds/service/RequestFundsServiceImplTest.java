package oh.lccs.portal.requestfunds.service;

import static org.junit.Assert.*;
import oh.lccs.portal.requestfunds.dao.RequestFundsDAO;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.service.RequestFundsService;
import oh.lccs.portal.requestfunds.service.impl.RequestFundsServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class RequestFundsServiceImplTest {

	RequestFundsService service = null;
	@Mock private RequestFundsDAO requestFundsDAO;
	
	@Before 
	public void setup(){
		MockitoAnnotations.initMocks(this);
		service = new RequestFundsServiceImpl();
		ReflectionTestUtils.setField(service, "requestFundsDAO", requestFundsDAO);
		
	}
	@Test
	public void searchForm() {
		RequestFundsDTO dto = new RequestFundsDTO(); 
		dto = service.searchForm(dto);
		
		assertNotNull(dto);
		assertEquals("1234", dto.getSacwisId());
		/*assertEquals("Sacwis Name", dto.getSacwisName());
		assertEquals("My Approver",dto.getSacwisApproverName());*/
	}

}
