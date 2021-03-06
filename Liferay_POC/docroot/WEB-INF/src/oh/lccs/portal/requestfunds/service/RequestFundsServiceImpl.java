package oh.lccs.portal.requestfunds.service;

import oh.lccs.portal.LucasAnnotationConstants;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;

import org.springframework.stereotype.Service;

@Service(value=LucasAnnotationConstants.REQUEST_FUNDS_SERVICE)
public class RequestFundsServiceImpl implements RequestFundsService {

	@Override
	public RequestFundsDTO searchForm(RequestFundsDTO dto) {
		return mockData();
	}
	
	private RequestFundsDTO mockData(){
		
		RequestFundsDTO searchResult= new RequestFundsDTO();
		searchResult.setSacwisId("1234");
		searchResult.setSacwisName("Sacwis Name");
		searchResult.setSacwisApproverName( "My Approver");
		return searchResult;
		
	}

}
