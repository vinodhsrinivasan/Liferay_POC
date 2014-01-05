package oh.lccs.portal.requestfunds.dao.impl;

import oh.lccs.portal.requestfunds.dao.RequestFundsDAO;

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

}
