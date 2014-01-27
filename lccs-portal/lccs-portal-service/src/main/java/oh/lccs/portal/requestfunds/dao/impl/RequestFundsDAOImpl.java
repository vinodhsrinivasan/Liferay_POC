package oh.lccs.portal.requestfunds.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oh.lccs.portal.db.MybatisQueryForInsert;
import oh.lccs.portal.db.MybatisQueryForList;
import oh.lccs.portal.db.MybatisQueryForUpdate;
import oh.lccs.portal.db.domain.requestfunds.CaseDetails;
import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;
import oh.lccs.portal.db.domain.requestfunds.RequestFunds;
import oh.lccs.portal.db.domain.requestfunds.RequestFundsParticipant;
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
	private static final String CASE_INFORMATION_MAPPER = "oh.lccs.portal.db.mapper.requestfunds.RequestFundsMapper.retrieveCaseDetails";
	private static final String FUNDS_REQUEST_INSERT_MAPPER = "oh.lccs.portal.db.mapper.requestfunds.RequestFundsMapper.insertFundRequest";
	private static final String FUNDS_REQUEST_PARTICIPANT_INSERT_MAPPER = "oh.lccs.portal.db.mapper.requestfunds.RequestFundsMapper.insertFundRequestParticipant";
	private static final String FUNDS_REQUEST_UPDATE_MAPPER = "oh.lccs.portal.db.mapper.requestfunds.RequestFundsMapper.updateFundRequest";


	@Override
	public List<Map<String, Object>> searchBasedOnSacwisId(String sacwisId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("caseId",sacwisId);
		
		List<Map<String, Object>> userInfo = new MybatisQueryForList().perform(FUNDS_REQUEST_MAPPER, parameters );
		System.out.println(userInfo);
		if(userInfo!= null && !userInfo.isEmpty()){
			CaseParticipant caseParticipant= (CaseParticipant) userInfo.get(0);
			if(caseParticipant!= null){
				return userInfo;
			}
		}
		
		return null;
	}

	@Override
	public List<Map<String, Object>> retrieveCaseDetails(String sacwisId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("caseId",sacwisId);
		
		List<Map<String, Object>> userInfo = new MybatisQueryForList().perform(CASE_INFORMATION_MAPPER, parameters );
		System.out.println(userInfo);
		if(userInfo!= null && !userInfo.isEmpty()){
			CaseDetails caseDetails= (CaseDetails) userInfo.get(0);
			if(caseDetails!= null){
				return userInfo;
			}
		}
		return null;
	}
	
	@Override
	public boolean saveFundRequest(RequestFunds requestFunds) {
		int rowsInserted = 0;
		rowsInserted = new MybatisQueryForInsert().perform(FUNDS_REQUEST_INSERT_MAPPER, requestFunds);
		if(rowsInserted > 0){
			return true;
		}
		return false;
		
	}
	
	@Override
	public boolean saveFundRequestParticipant(RequestFundsParticipant requestFundsParticipant) {
		int rowsInserted = 0;
		rowsInserted = new MybatisQueryForInsert().perform(FUNDS_REQUEST_PARTICIPANT_INSERT_MAPPER, requestFundsParticipant);
		
		if(rowsInserted > 0){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean updateFundRequest(RequestFunds requestFunds) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		rowsUpdated = new MybatisQueryForUpdate().perform(FUNDS_REQUEST_UPDATE_MAPPER, requestFunds);
		if(rowsUpdated > 0){
			return true;
		}
		return false;
	}
	
	
	

}
