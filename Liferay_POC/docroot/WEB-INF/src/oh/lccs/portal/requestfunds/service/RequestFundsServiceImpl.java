package oh.lccs.portal.requestfunds.service;

import oh.lccs.portal.LucasAnnotationConstants;
import oh.lccs.portal.requestfunds.dto.SacwisDTO;

import org.springframework.stereotype.Service;

@Service(value=LucasAnnotationConstants.REQUEST_FUNDS_SERVICE)
public class RequestFundsServiceImpl implements RequestFundsService {

	@Override
	public SacwisDTO searchForm(SacwisDTO dto) {
		return mockData();
	}
	
	private SacwisDTO mockData(){
		
		SacwisDTO searchResult= new SacwisDTO();
		searchResult.setSacwisId("1234");
		searchResult.setSacwisName("Sacwis Name");
		searchResult.setSacwisApproverName( "My Approver");
		return searchResult;
		
	}

}
