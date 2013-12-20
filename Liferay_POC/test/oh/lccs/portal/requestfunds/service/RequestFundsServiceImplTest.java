package oh.lccs.portal.requestfunds.service;

import static org.junit.Assert.*;
import oh.lccs.portal.requestfunds.dto.SacwisDTO;
import oh.lccs.portal.requestfunds.service.RequestFundsService;
import oh.lccs.portal.requestfunds.service.RequestFundsServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class RequestFundsServiceImplTest {

	RequestFundsService service = null;
	
	@Before 
	public void setup(){
		service = new RequestFundsServiceImpl();
		
	}
	@Test
	public void searchForm() {
		SacwisDTO dto = new SacwisDTO(); 
		dto = service.searchForm(dto);
		
		assertNotNull(dto);
		assertEquals("1234", dto.getSacwisId());
		assertEquals("Sacwis Name", dto.getSacwisName());
		assertEquals("My Approver",dto.getSacwisApproverName());
	}

}
