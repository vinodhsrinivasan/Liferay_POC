package oh.lccs.portal.requestfunds.service;

import java.util.List;

import oh.lccs.portal.db.domain.requestfunds.RequestFunds;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;

public interface RequestFundsService {

	RequestFundsDTO searchForm(RequestFundsDTO dto);
	
	boolean saveData(RequestFundsDTO dto);
	
	boolean updateData(RequestFundsDTO dto);
	
	List<RequestFunds> retrieveRequestFundsRequests(RequestFundsDTO dto);

}
