package oh.lccs.portal.db.mapper.requestfunds;

import java.util.List;
import java.util.Map;

import oh.lccs.portal.db.domain.requestfunds.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RequestFundsMapper {
	
	@Select("SELECT * FROM user_ WHERE userId = #{userId}")
	public User searchBasedOnSacwisId(@Param("userId") String userId);

}
