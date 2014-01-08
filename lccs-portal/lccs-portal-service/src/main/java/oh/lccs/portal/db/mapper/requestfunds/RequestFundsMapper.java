package oh.lccs.portal.db.mapper.requestfunds;

import java.util.List;

import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Mybatis mapper for RequestFunds.
 * 
 * @author vinodh.srinivasan@compuware.com
 *
 */
public interface RequestFundsMapper {
	
	/*@Select("SELECT * FROM user_ WHERE userId = #{userId}")
	public User searchBasedOnSacwisId(@Param("userId") String userId);*/
	
	static final String SQL="select  SACWIS.GET_PERSON_NAME_FORMAT(p.person_id, 'LSFM') as personFullName, p.birth_date as dob, p.person_id as sacwisId,cpr.RELATIONSHIP_CODE as type,"+
            " lce.CUSTODY_START_DATE as custodyDate, lcal.AGENCY_ID as custody ,  ps.PLACEMENT_SETTING_ID as placement, e.IVE_ELIGIBLE_INDICATOR as iveReimbursable, cp.case_id as caseId "+
			" from sacwis.case_participant cp inner join sacwis.case_participant cRefPerson on cp.case_id = cRefPerson.case_id  and cRefPerson.reference_person_flag = 1 "+
			" inner join sacwis.person p on p.person_id = cp.person_id "+        
			" left outer join SACWIS.CASE_PARTICIPANT_RELN cpr "+ //only get relationships that are 'to' the case reference person 
			" on cpr.case_id = cp.case_id and cpr.dest_person_id = cp.person_id and cpr.SOURCE_PERSON_ID = cRefPerson.person_id "+
			" left outer join SACWIS.LEGAL_CUSTODY_EPISODE lce  on lce.PERSON_ID = cp.PERSON_ID and nvl(lce.CREATED_IN_ERROR_FLAG,0) = 0 "+
			" left outer join SACWIS.LEGAL_CUSTODY_AGENCY_LINK lcal on lcal.LEGAL_CUSTODY_EPISODE_ID = lce.LEGAL_CUSTODY_EPISODE_ID "+
			" left outer join SACWIS.PLACEMENT_SETTING ps on ps.CHILD_ID = lce.PERSON_ID "+
            " and nvl(ps.END_REASON_CODE,'NULL') <> 'CREATEDINERROR' left outer join SACWIS.ELIGIBILITY e "+ 
            " on E.PERSON_ID = CP.PERSON_ID and e.TERMINATION_DATE is null and nvl(e.CREATED_IN_ERROR_FLAG, 0) = 0 "+
            " where cp.case_id = 18600 and cp.CURRENT_STATUS_CODE = 'ACTIVE'  and (lce.LEGAL_CUSTODY_EPISODE_id is null "+ 
            " or lce.CUSTODY_START_DATE = (select max(custody_start_date) from legal_custody_episode where person_id = cp.person_id "+ 
            " and nvl(CREATED_IN_ERROR_FLAG,0) = 0))  and (ps.placement_setting_id is null  or ps.begin_date = (select max(ps.begin_date) "+ 
            " from placement_setting ps where ps.child_id = cp.person_id  and nvl(ps.END_REASON_CODE,'**NULL**') <> 'CREATEDINERROR')) order by PERSON_ID";
	
	static final String SAMPLE="select case_id as caseId from sacwis.case_participant where rownum=1";
	
	@Select(SQL)
	public List<CaseParticipant> searchBasedOnSacwisId(@Param("userId") String userId);

}
