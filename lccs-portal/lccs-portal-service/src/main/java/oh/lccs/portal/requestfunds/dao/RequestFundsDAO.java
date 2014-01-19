package oh.lccs.portal.requestfunds.dao;

import java.util.List;
import java.util.Map;

public interface RequestFundsDAO {

	List<Map<String, Object>> searchBasedOnSacwisId(String sacwisId);
	
	List<Map<String, Object>> retrieveCaseDetails(String sacwisId);
}
