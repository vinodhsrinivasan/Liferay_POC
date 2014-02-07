package oh.lccs.portal.db.mapper.requestfunds;

import java.util.List;

import oh.lccs.portal.db.domain.requestfunds.CaseDetails;
import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;
import oh.lccs.portal.db.domain.requestfunds.RequestFunds;
import oh.lccs.portal.db.domain.requestfunds.RequestFundsParticipant;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Mybatis mapper for RequestFunds.
 * 
 * @author vinodh.srinivasan@compuware.com
 *
 */
public interface RequestFundsMapper {
	
	/*@Select("SELECT * FROM user_ WHERE userId = #{userId}")
	public User searchBasedOnSacwisId(@Param("userId") String userId);*/
	
	static final String SQL="select  SACWIS.GET_PERSON_NAME_FORMAT(p.person_id, 'LSFM') as personFullName, to_char(p.birth_date,'MM/DD/yyyy') as dob, p.person_id as sacwisId,RD.SHORT_DESC as type,"+
            " to_char(lce.CUSTODY_START_DATE,'MM/DD/YYYY') as custodyDate, ag.agency_name as custody, ag.agency_id as custodyAgencyId ,  ps.PLACEMENT_SETTING_ID as placement, e.IVE_ELIGIBLE_INDICATOR as iveReimbursable, cp.case_id as caseId "+
			" from sacwis.case_participant cp inner join sacwis.case_participant cRefPerson on cp.case_id = cRefPerson.case_id  and cRefPerson.reference_person_flag = 1 "+
			" inner join sacwis.person p on p.person_id = cp.person_id "+        
			" left outer join SACWIS.CASE_PARTICIPANT_RELN cpr "+ //only get relationships that are 'to' the case reference person 
			" on cpr.case_id = cp.case_id and cpr.dest_person_id = cp.person_id and cpr.SOURCE_PERSON_ID = cRefPerson.person_id "+
			" left outer join SACWIS.REF_DATA RD on RD.REF_DATA_CODE = cpr.RELATIONSHIP_CODE and RD.DOMAIN_CODE = 'Relationship' "+
			" left outer join SACWIS.LEGAL_CUSTODY_EPISODE lce  on lce.PERSON_ID = cp.PERSON_ID and nvl(lce.CREATED_IN_ERROR_FLAG,0) = 0 "+
			" left outer join SACWIS.LEGAL_CUSTODY_AGENCY_LINK lcal on lcal.LEGAL_CUSTODY_EPISODE_ID = lce.LEGAL_CUSTODY_EPISODE_ID "+
			" left outer join agency ag on ag.agency_id = lcal.agency_id "+
			" left outer join SACWIS.PLACEMENT_SETTING ps on ps.CHILD_ID = lce.PERSON_ID "+
            " and nvl(ps.END_REASON_CODE,'NULL') <> 'CREATEDINERROR' left outer join SACWIS.ELIGIBILITY e "+ 
            " on E.PERSON_ID = CP.PERSON_ID and e.TERMINATION_DATE is null and nvl(e.CREATED_IN_ERROR_FLAG, 0) = 0 "+
            " where cp.case_id = #{caseId} and cp.CURRENT_STATUS_CODE = 'ACTIVE'  and (lce.LEGAL_CUSTODY_EPISODE_id is null "+ 
            " or lce.CUSTODY_START_DATE = (select max(custody_start_date) from legal_custody_episode where person_id = cp.person_id "+ 
            " and nvl(CREATED_IN_ERROR_FLAG,0) = 0))  and (ps.placement_setting_id is null  or ps.begin_date = (select max(ps.begin_date) "+ 
            " from placement_setting ps where ps.child_id = cp.person_id  and nvl(ps.END_REASON_CODE,'**NULL**') <> 'CREATEDINERROR')) order by custody nulls first";
	
	static final String SAMPLE="select case_id as caseId from sacwis.case_participant where rownum=1";
	
	static final String CASE_SQL = "select GET_PERSON_FULL_NAME(SU.PERSON_ID) as caseWorker, "+
				"(CB.LAST_NAME||', '|| CB.FIRST_NAME ||DECODE(CB.MIDDLE_NAME,NULL, ' ',CB.MIDDLE_NAME ))AS caseName, su.person_id as caseWorkerId from WORK_ASSIGNMENT WA "
				+ "inner join workload_item wi on wi.workload_item_id = wa.workload_item_id "
				+ " inner join EMPLOYEE E on E.EMPLOYEE_ID = WA.EMPLOYEE_ID "
				+ " inner join SECURITY_USER SU on SU.EMPLOYEE_ID = E.EMPLOYEE_ID "
				+ " inner join CASE_BASE CB on CB.CASE_ID = WI.WORKLOAD_ITEM_ID "
				+ " where wi.work_item_id = #{caseId} and wi.work_item_type_code = 'CASE'  and su.end_date is null and rownum =1";
	
	static final String INSERT_REQUEST_FUNDS = " INSERT INTO REQUEST_FUNDS(CASE_ID, REQUESTED_DATE, 	CASE_WORKER_REQUESTING,	CASE_WORKER , 	CASE_NAME ,	WORKER_PHONE, DONATION , PREPLACEMENT , "
			+ " AFTERCARE_INDEPENDENCE, KINSHIP_CARE, OPERATING, FAMILY_REUNIFICATION, ALTERNATIVE_RESPONSE, PERSON_RESPFOR_PURCHASE, REQUEST_PURPOSE, "
			+ " OTHERCOMMRESCONTACTED, TOTALAMTREQUESTED, DATE_REQUIRED, FUND_MODE, FUND_DELIVERY_TYPE, PAYMENT_MADE_FOR, OTHER_INSTRUCTIONS, "
			+ "	FURNITURE_DELIVERY_ADDRESS, BUDGET_CENTER, LINEITEM, STATUS_CODE , APPROVER_NAME, APPROVER, CREATED_DATE, CREATED_BY, "
			+ "	MODIFIED_DATE, MODIFIED_BY) VALUES "
			+ "	(#{caseId}, #{requestedDate}, #{requestingCaseWorker}, #{caseWorker}, #{caseName}, #{workerPhoneNumber}, #{donation}, #{prePlacement}, #{afterCareIndependence}, #{kinshipCare}, "
			+ " #{operating}, #{familyReunification}, #{alternativeResponse}, #{personRespForPurchase}, #{requestPurpose}, #{otherCommResContacted}, #{totalAmtRequested}, #{dateRequired}, "
			+ " #{fundMode}, #{fundDeliveryType} ,#{paymentMadeFor}, #{otherInstructions}, #{furnitureDeliveryAddress}, #{budgetCenter}, #{lineItem} "
			+ "	, #{statusCode}	, #{approverName}, #{approver}, #{createdDate},#{createdBy},  #{modifiedDate}, #{modifiedby})";

	static final String INSERT_REQUEST_FUNDS_PARTICIPANT ="INSERT INTO  REQUEST_FUNDS_PARTICIPANT(	REQUEST_FUNDS_ID, PERSON_ID, PERSON_NAME, BIRTH_DATE, RELATIONSHIP_TYPE_CODE, "
			+ "	CUSTODY, CUSTODY_AGENCY_ID,	PLACEMENT_ID, CUSTODY_DATE,	IVE_REIMBURSABLE_FLAG, CREATED_DATE ,CREATED_BY , "
			+ "	MODIFIED_DATE ,	MODIFIED_BY) VALUES	(#{requestFundsId},#{personId},#{personFullName},#{dob},#{relationShipTypeCode},#{custody},#{custodyAgencyId},#{placement},#{custodyDate},#{caseId} "
			+ "	,#{iveReimbursable},#{createdDate},#{createdBy},#{modifiedDate},#{modifiedby})";


	static final String UPDATE_REQUEST_FUNDS= "UPDATE REQUEST_FUNDS SET CASE_ID =#{caseId} , REQUESTED_DATE=#{requestedDate}, "
			+ "	CASE_WORKER_REQUESTING=#{requestingCaseWorker},	CASE_WORKER=#{caseWorker} , 	CASE_NAME=#{caseName} ,	WORKER_PHONE=#{workerPhoneNumber}, "
			+ "	DONATION=#{donation} , PREPLACEMENT=#{prePlacement} , "
			+ "	AFTERCARE_INDEPENDENCE=#{afterCareIndependence}, KINSHIP_CARE=#{kinshipCare}, OPERATING=#{operating}, FAMILY_REUNIFICATION=#{familyReunification}, "
			+ "	ALTERNATIVE_RESPONSE=#{alternativeResponse}, PERSON_RESPFOR_PURCHASE=#{personRespForPurchase}, REQUEST_PURPOSE=#{requestPurpose}, "
			+ "	OTHERCOMMRESCONTACTED=#{otherCommResContacted}, TOTALAMTREQUESTED=#{totalAmtRequested}, DATE_REQUIRED=#{dateRequired}, "
			+ "	FUND_MODE=#{fundMode}, FUND_DELIVERY_TYPE=#{fundDeliveryType}, PAYMENT_MADE_FOR=#{paymentMadeFor}, OTHER_INSTRUCTIONS=#{otherInstructions}, "
			+ "	FURNITURE_DELIVERY_ADDRESS=#{furnitureDeliveryAddress}, BUDGET_CENTER=#{budgetCenter}, LINEITEM=#{lineItem}, STATUS_CODE=#{statusCode} ,"
			+ " APPROVER_NAME= #{approverName}, APPROVER=#{approver}, CREATED_DATE= #{createdDate}, CREATED_BY=#{createdBy}, "
			+ "	MODIFIED_DATE=#{modifiedDate}, MODIFIED_BY=#{modifiedby}";
	
	static final String RETRIEVE_REQUEST_FUNDS_REQUESTS = "select case_id as caseId, case_name as caseName, case_worker as caseWorker, created_date as createdDate from request_funds where approver = 0";
	
	@Select(SQL)
	public List<CaseParticipant> searchBasedOnSacwisId(@Param("caseId") String caseId);
	
	@Select(CASE_SQL)
	public List<CaseDetails> retrieveCaseDetails(@Param("caseId") String caseId);
	
	@Insert(INSERT_REQUEST_FUNDS)
	public int insertFundRequest(RequestFunds requestFund);

	@Insert(INSERT_REQUEST_FUNDS_PARTICIPANT)
	public int insertFundRequestParticipant(RequestFundsParticipant requestFundsParticipant);
	
	@Update(UPDATE_REQUEST_FUNDS)
	public int updateFundRequest(RequestFunds requestFund);
	
	@Select(RETRIEVE_REQUEST_FUNDS_REQUESTS)
	public List<RequestFunds> retrieveRequestFundsRequests(@Param("caseId") String caseId);
	
}
