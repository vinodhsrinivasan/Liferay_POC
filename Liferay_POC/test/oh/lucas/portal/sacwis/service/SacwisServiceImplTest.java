package oh.lucas.portal.sacwis.service;

import static org.junit.Assert.*;
import oh.lucas.portal.sacwis.dto.SacwisDTO;

import org.junit.Before;
import org.junit.Test;

public class SacwisServiceImplTest {

	SacwisService service = null;
	
	@Before 
	public void setup(){
		service = new SacwisServiceImpl();
		
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
