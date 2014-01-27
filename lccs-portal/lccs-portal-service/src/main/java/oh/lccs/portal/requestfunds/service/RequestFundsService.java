package oh.lccs.portal.requestfunds.service;

import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;

public interface RequestFundsService {

	RequestFundsDTO searchForm(RequestFundsDTO dto);
	
	boolean saveData(RequestFundsDTO dto);
	
	boolean updateData(RequestFundsDTO dto);

}
