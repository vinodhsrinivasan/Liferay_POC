package oh.lccs.portal.requestfunds.dao;

import java.util.List;
import java.util.Map;

import oh.lccs.portal.db.domain.requestfunds.RequestFunds;
import oh.lccs.portal.db.domain.requestfunds.RequestFundsParticipant;

public interface RequestFundsDAO {

	List<Map<String, Object>> searchBasedOnSacwisId(String sacwisId);
	
	List<Map<String, Object>> retrieveCaseDetails(String sacwisId);
	
	boolean saveFundRequest(RequestFunds requestFunds);
	
	boolean saveFundRequestParticipant(RequestFundsParticipant requestFundsParticipant);
	
	boolean updateFundRequest(RequestFunds requestFunds);
}
