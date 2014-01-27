package oh.lccs.portal.db;

import org.apache.ibatis.session.SqlSession;

/**
 * This object returns List of data objects.
 * 
 * @author vinodh.srinivasan@compuware.com
 *
 */
public class MybatisQueryForUpdate {

  
  public int perform(final String daoMethodName, final Object object)  {
	  SqlSession session = null;
	  int results = 0;
	  try{
		session = LCCSConnectionFactory.getSession();
		try {
			results = session.update(daoMethodName,object);
			session.commit();
		} catch (Exception e) {
			//TODO: fix the log
			e.printStackTrace();
			session.rollback();
		}
	  }finally{
		  LCCSConnectionFactory.closeSession(session);
	  }
	  return results;
  }

}
