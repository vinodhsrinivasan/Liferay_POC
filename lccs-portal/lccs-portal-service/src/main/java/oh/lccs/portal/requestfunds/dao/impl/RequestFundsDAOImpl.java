package oh.lccs.portal.requestfunds.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oh.lccs.portal.db.MybatisQueryForList;
import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;
import oh.lccs.portal.requestfunds.dao.RequestFundsDAO;
import oh.lccs.portal.service.constants.LucasServiceConstants;

import org.springframework.stereotype.Service;

/**
 * Represents the DATA layer for the RequestFunds.
 * 
 * @author vinodh.srinivasan@compuware.com
 *
 */
@Service(value=LucasServiceConstants.REQUEST_FUNDS_DAO)
public class RequestFundsDAOImpl implements RequestFundsDAO {

	private static final String FUNDS_REQUEST_MAPPER = "oh.lccs.portal.db.mapper.requestfunds.RequestFundsMapper.searchBasedOnSacwisId";

	@Override
	public String searchBasedOnSacwisId(String sacwisId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId",sacwisId);
		
		List<Map<String, Object>> userInfo = new MybatisQueryForList().perform(FUNDS_REQUEST_MAPPER, parameters );
		System.out.println(userInfo);
		if(userInfo!= null && !userInfo.isEmpty()){
			CaseParticipant caseParticipant= (CaseParticipant) userInfo.get(0);
			if(caseParticipant!= null){
			return caseParticipant.getCaseId().toString();
			}
		}
		
		return "";
	}
	
	
	

}
