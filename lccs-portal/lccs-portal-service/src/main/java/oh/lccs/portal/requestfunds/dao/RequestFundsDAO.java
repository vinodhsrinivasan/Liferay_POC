package oh.lccs.portal.requestfunds.dao;

import java.util.List;
import java.util.Map;

import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;

public interface RequestFundsDAO {

	List<Map<String, Object>> searchBasedOnSacwisId(String sacwisId);
	
	List<Map<String, Object>> retrieveCaseDetails(String sacwisId);
	
	void saveFundRequest(RequestFundsDTO dto);
}
