package oh.lccs.portal.requestfunds.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import oh.lccs.portal.db.MybatisQueryForList;
import oh.lccs.portal.db.domain.requestfunds.User;
import oh.lccs.portal.requestfunds.dao.RequestFundsDAO;
import oh.lccs.portal.service.constants.LucasServiceConstants;


@Service(value=LucasServiceConstants.REQUEST_FUNDS_DAO)
public class RequestFundsDAOImpl implements RequestFundsDAO {

	@Override
	public String searchBasedOnSacwisId(String sacwisId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId","10161");
		
		List<Map<String, Object>> userInfo = new MybatisQueryForList().perform("oh.lccs.portal.db.mapper.requestfunds.RequestFundsMapper.searchBasedOnSacwisId", parameters );
		if(userInfo!= null && !userInfo.isEmpty()){
			User user= (User) userInfo.get(0);
			if(user!= null){
			return user.getGreeting();
			}
		}
		
		return "";
	}
	
	
	

}
