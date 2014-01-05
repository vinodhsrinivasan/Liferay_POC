package oh.lccs.portal.db;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

/**
 * This object returns List of data objects.
 * 
 * @author vinodh.srinivasan@compuware.com
 *
 */
public class MybatisQueryForList {

  
  public List<Map<String, Object>> perform(final String daoMethodName, final Map<String, Object> parameters)  {
	  SqlSession session = null;
	  List<Map<String, Object>> results = null;
	  try{
		session = ConnectionFactory.getSession();
		results = session.selectList(daoMethodName,parameters);
	  }finally{
		  ConnectionFactory.closeSession(session);
	  }
	  return results;
  }

}
