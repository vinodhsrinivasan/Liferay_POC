package oh.lccs.portal.requestfunds.dao.impl;

import oh.lccs.portal.requestfunds.dao.RequestFundsDAO;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;

import org.junit.Before;
import org.junit.Test;

public class RequestFundsDAOImplTest {
	
	RequestFundsDAO subject;
	
	@Before
	public void setup(){
		subject= new RequestFundsDAOImpl();
	}

	@Test
	public void searchBasedOnSacwisId() {
		String sacwisId = "1234";
		try {
			subject.searchBasedOnSacwisId(sacwisId );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void saveFundRequest(){
		RequestFundsDTO dto = new RequestFundsDTO();
		dto.setCaseWorker("Hello");
		try {
			subject.saveFundRequest(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
