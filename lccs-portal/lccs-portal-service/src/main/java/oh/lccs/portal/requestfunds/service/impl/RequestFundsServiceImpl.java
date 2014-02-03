package oh.lccs.portal.requestfunds.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oh.lccs.portal.common.DateUtils;
import oh.lccs.portal.db.domain.requestfunds.CaseDetails;
import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;
import oh.lccs.portal.db.domain.requestfunds.RequestFunds;
import oh.lccs.portal.db.domain.requestfunds.RequestFundsParticipant;
import oh.lccs.portal.requestfunds.dao.RequestFundsDAO;
import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.service.RequestFundsService;
import oh.lccs.portal.service.constants.LucasServiceConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value=LucasServiceConstants.REQUEST_FUNDS_SERVICE)
public class RequestFundsServiceImpl implements RequestFundsService {
	
	private static final String EMPTY_STRING = " ";

	@Autowired
	@Qualifier(value=LucasServiceConstants.REQUEST_FUNDS_DAO)
	private RequestFundsDAO requestFundsDAO;
	
	@Override
	public RequestFundsDTO searchForm(RequestFundsDTO dto) {
		return mockData(dto);
	}
	
	private RequestFundsDTO mockData(RequestFundsDTO dto){
		RequestFundsDTO searchResult= new RequestFundsDTO();
		List<Map<String, Object>> caseParticipantsColl = requestFundsDAO.searchBasedOnSacwisId(dto.getSacwisId());
		List<Map<String, Object>> caseDetailsColl = requestFundsDAO.retrieveCaseDetails(dto.getSacwisId());
		if(caseDetailsColl != null && caseDetailsColl.size()> 0){
			CaseDetails caseDetail= (CaseDetails) caseDetailsColl.get(0);
			searchResult.setCaseName(caseDetail.getCaseName());
			searchResult.setCaseWorker(caseDetail.getCaseWorker());
		}
		searchResult.setSacwisId("1234");
		if(dto.getSacwisId() != null){
			searchResult.setSacwisId(dto.getSacwisId());	
		}
		searchResult.setRequestedDate("01/01/2013");
		searchResult.setRequestingCaseWorker("Test Requestor");
		searchResult.setWorkerPhoneNumber("(123) 456 - 7890");
		searchResult.setPersonRespForPurchase("Test Purchaser");
		searchResult.setRequestPurpose("To purchase office supplies");
		searchResult.setOtherCommResContacted("Contacted the manager");
		searchResult.setTotalAmtRequested("200.00");
		searchResult.setDateRequired("01/01/2014");
		searchResult.setFundMode("Voucher");
		searchResult.setFundDeliveryType("furniture");
		searchResult.setFurnitureDeliveryAddress("123 Test Columbus OH 12345");
		searchResult.setPaymentMadeFor("Test Manager");
		searchResult.setOtherInstructions("Please process the payment");
		searchResult.setBudgetCenter("JHJHJH-8989");
		searchResult.setLineItem("21212");
		
		searchResult.setDonation(LucasServiceConstants.CHECKBOX_OFF);
		searchResult.setPrePlacement(LucasServiceConstants.CHECKBOX_OFF);
		searchResult.setAfterCareIndependence(LucasServiceConstants.CHECKBOX_OFF);
		searchResult.setKinshipCare(LucasServiceConstants.CHECKBOX_OFF);
		searchResult.setOperating(LucasServiceConstants.CHECKBOX_OFF);
		searchResult.setFamilyReunification(LucasServiceConstants.CHECKBOX_OFF);
		searchResult.setAlternativeResponse(LucasServiceConstants.CHECKBOX_OFF);
		
		searchResult.setRequestType(new String[] {"Donation"});
		List<CaseParticipant> requestingPeople = new ArrayList<CaseParticipant>();

		
		if(caseParticipantsColl != null && caseParticipantsColl.size()> 0){
			Iterator<Map<String, Object>> itr = caseParticipantsColl.iterator();
			while(itr.hasNext()){
				CaseParticipant cp = (CaseParticipant) itr.next(); 
				cp.setRequestingPersonCheckbox(LucasServiceConstants.CHECKBOX_ON);
				requestingPeople.add(cp);
			}
			searchResult.setRequestingForPeople(requestingPeople);
		}
		
		return searchResult;
	}

	@Override
	public boolean saveData(RequestFundsDTO dto) {
		// TODO Auto-generated method stub
		
		RequestFunds requestFunds = new RequestFunds();
		saveFundRequest(dto, requestFunds);
		boolean saveFlag = false;
		saveFlag = requestFundsDAO.saveFundRequest(requestFunds);
		long selectedCaseParticipant = 0;
		CaseParticipant caseParticipant = null;
		RequestFundsParticipant participantUO = null;
		
//		if(saveFlag){
//			int size = dto.getSelectedCaseParticipants().length;
//			for (int i = 0; i < size; i++) {
//				selectedCaseParticipant = Long.parseLong(dto.getSelectedCaseParticipants()[i]);
//				if(dto.getRequestingForPeople() != null && dto.getRequestingForPeople().size() >0 ){
//					Iterator<CaseParticipant> caseParticipantItr = dto.getRequestingForPeople().iterator();
//					while(caseParticipantItr.hasNext()){
//						caseParticipant = caseParticipantItr.next();
//						if(caseParticipant.getSacwisId().equalsIgnoreCase(String.valueOf(selectedCaseParticipant))){
//							participantUO = new RequestFundsParticipant();
//							saveFundRequestParticipant(caseParticipant, participantUO);
//							saveFlag = requestFundsDAO.saveFundRequestParticipant(participantUO);
//						}
//					}
//				}
//				
//			}
//		}
		
				if(saveFlag){
				if(dto.getRequestingForPeople() != null && dto.getRequestingForPeople().size() >0 ){
					Iterator<CaseParticipant> caseParticipantItr = dto.getRequestingForPeople().iterator();
					while(caseParticipantItr.hasNext()){
						caseParticipant = caseParticipantItr.next();
							participantUO = new RequestFundsParticipant();
							saveFundRequestParticipant(caseParticipant, participantUO);
							saveFlag = requestFundsDAO.saveFundRequestParticipant(participantUO);
						}
					}
				}
				
		
		return saveFlag;
	}
	
	@Override
	public boolean updateData(RequestFundsDTO dto) {
		// TODO Auto-generated method stub
		
		RequestFunds requestFunds = new RequestFunds();
		saveFundRequest(dto, requestFunds);
		boolean saveFlag = false;
		saveFlag = requestFundsDAO.updateFundRequest(requestFunds);
		return saveFlag;
	}
	
	/**
	 * @param dto
	 * @param requestFunds
	 */
	private void saveFundRequest(RequestFundsDTO dto, RequestFunds requestFunds){
//		if(dto.getAfterCareIndependence() != null){
//			requestFunds.setAfterCareIndependence(dto.getAfterCareIndependence());
//		}else{
//			requestFunds.setAfterCareIndependence(null);
//		}
		
		if(dto.getSacwisId() != null){
			requestFunds.setCaseId(new BigDecimal(dto.getSacwisId()));
		}else{
			requestFunds.setCaseId(new BigDecimal(0));
		}
		
		if(dto.getRequestedDate() != null){
			requestFunds.setRequestedDate(DateUtils.getMMDDYYYYStringAsDate(dto.getRequestedDate()));
		}else{
			requestFunds.setRequestedDate(new Date());
		}
		
		if(dto.getRequestingCaseWorker() != null){
			requestFunds.setRequestingCaseWorker(new BigDecimal(dto.getRequestingCaseWorker()));
		}else{
			requestFunds.setRequestingCaseWorker(new BigDecimal(0));
		}
		
		if(dto.getCaseWorker() != null){
			requestFunds.setCaseWorker(dto.getCaseWorker());
		}else{
			requestFunds.setCaseWorker(EMPTY_STRING);
		}
		
		if(dto.getCaseName() != null){
			requestFunds.setCaseName(dto.getCaseName());
		}else{
			requestFunds.setCaseName(EMPTY_STRING);
		}
		
		if(dto.getWorkerPhoneNumber() != null){
			requestFunds.setWorkerPhoneNumber(dto.getWorkerPhoneNumber());
		}else{
			requestFunds.setWorkerPhoneNumber(EMPTY_STRING);
		}
		
		//Request Types
		if(dto.getDonation() != null){
			requestFunds.setDonation(dto.getDonation());
		}else{
			requestFunds.setDonation(EMPTY_STRING);
		}
		
		if(dto.getPrePlacement() != null){
			requestFunds.setPrePlacement(dto.getPrePlacement());
		}else{
			requestFunds.setPrePlacement(EMPTY_STRING);
		}
		
		if(dto.getAfterCareIndependence() != null){
			requestFunds.setAfterCareIndependence(dto.getAfterCareIndependence());
		}else{
			requestFunds.setAfterCareIndependence(EMPTY_STRING);
		}
		
		if(dto.getKinshipCare() != null){
			requestFunds.setKinshipCare(dto.getKinshipCare());
		}else{
			requestFunds.setKinshipCare(EMPTY_STRING);
		}
		
		if(dto.getOperating() != null){
			requestFunds.setOperating(dto.getOperating());
		}else{
			requestFunds.setOperating(EMPTY_STRING);
		}
		
		if(dto.getFamilyReunification() != null){
			requestFunds.setFamilyReunification(dto.getFamilyReunification());
		}else{
			requestFunds.setFamilyReunification(EMPTY_STRING);
		}
		
		if(dto.getAlternativeResponse() != null){
			requestFunds.setAlternativeResponse(dto.getAlternativeResponse());
		}else{
			requestFunds.setAlternativeResponse(EMPTY_STRING);
		}
		
		//Information filled in by Caseworker for approval
		
		if(dto.getPersonRespForPurchase() != null){
			requestFunds.setPersonRespForPurchase(new BigDecimal(dto.getPersonRespForPurchase()));
		}else{
			requestFunds.setPersonRespForPurchase(new BigDecimal(0));
		}
		
		if(dto.getRequestPurpose() != null){
			requestFunds.setRequestPurpose(dto.getRequestPurpose());
		}else{
			requestFunds.setRequestPurpose(EMPTY_STRING);
		}
		
		if(dto.getOtherCommResContacted() != null){
			requestFunds.setOtherCommResContacted(dto.getOtherCommResContacted());
		}else{
			requestFunds.setOtherCommResContacted(EMPTY_STRING);
		}
		
		if(dto.getTotalAmtRequested() != null){
			requestFunds.setTotalAmtRequested(dto.getTotalAmtRequested());
		}else{
			requestFunds.setTotalAmtRequested(EMPTY_STRING);
		}
		
		if(dto.getDateRequired() != null){
			requestFunds.setDateRequired(DateUtils.getMMDDYYYYStringAsDate(dto.getDateRequired()));
		}else{
			requestFunds.setDateRequired(new Date());
		}
		
		if(dto.getFundMode() != null){
			requestFunds.setFundMode(dto.getFundMode());
		}else{
			requestFunds.setFundMode(EMPTY_STRING);
		}
		
		if(dto.getFundDeliveryType() != null){
			requestFunds.setFundDeliveryType(dto.getFundDeliveryType());
		}else{
			requestFunds.setFundDeliveryType(EMPTY_STRING);
		}
		
		if(dto.getPaymentMadeFor() != null){
			requestFunds.setPaymentMadeFor(dto.getPaymentMadeFor());
		}else{
			requestFunds.setPaymentMadeFor(EMPTY_STRING);
		}
		
		if(dto.getOtherInstructions() != null){
			requestFunds.setOtherInstructions(dto.getOtherInstructions());
		}else{
			requestFunds.setOtherInstructions(EMPTY_STRING);
		}
		
		if(dto.getFurnitureDeliveryAddress() != null){
			requestFunds.setFurnitureDeliveryAddress(dto.getFurnitureDeliveryAddress());
		}else{
			requestFunds.setFurnitureDeliveryAddress(EMPTY_STRING);
		}
		
		if(dto.getBudgetCenter() != null){
			requestFunds.setBudgetCenter(dto.getBudgetCenter());
		}else{
			requestFunds.setBudgetCenter(EMPTY_STRING);
		}
		
		if(dto.getLineItem() != null){
			requestFunds.setLineItem(dto.getLineItem());
		}else{
			requestFunds.setLineItem(EMPTY_STRING);
		}
		
		if(dto.getLineItem() != null){
			requestFunds.setLineItem(dto.getLineItem());
		}else{
			requestFunds.setLineItem(EMPTY_STRING);
		}
		
		//Workflow Variables
		if(dto.getStatusCode() != null){
			requestFunds.setStatusCode(new BigDecimal(dto.getStatusCode()));
		}else{
			requestFunds.setStatusCode(new BigDecimal(0));
		}
		
		if(dto.getApproverName() != null){
			requestFunds.setApproverName(dto.getApproverName());
		}else{
			requestFunds.setApproverName(EMPTY_STRING);
		}
		
		if(dto.getApprover() != null){
			requestFunds.setApprover(new BigDecimal(dto.getApprover()));
		}else{
			requestFunds.setApprover(new BigDecimal(0));
		}
		
		//Audit Info
		if(dto.getCreatedBy() != null){
			requestFunds.setCreatedBy(new BigDecimal(dto.getCreatedBy()));
		}else{
			requestFunds.setCreatedBy(new BigDecimal(0));
		}
		
		if(dto.getCreatedDate() != null){
			requestFunds.setCreatedDate(DateUtils.getMMDDYYYYStringAsDate(dto.getCreatedDate()));
		}else{
			requestFunds.setCreatedDate(new Date());
		}
		
		if(dto.getModifiedby() != null){
			requestFunds.setModifiedby(new BigDecimal(dto.getModifiedby()));
		}else{
			requestFunds.setModifiedby(new BigDecimal(0));
		}
		
		if(dto.getModifiedDate() != null){
			requestFunds.setModifiedDate(DateUtils.getMMDDYYYYStringAsDate(dto.getModifiedDate()));
		}else{
			requestFunds.setModifiedDate(new Date());
		}
	}
	
	private void saveFundRequestParticipant(CaseParticipant caseParticipant, RequestFundsParticipant participantUO){
		if(caseParticipant.getSacwisId() != null){
			participantUO.setPersonId(new BigDecimal(caseParticipant.getSacwisId()));
		}else{
			participantUO.setPersonId(new BigDecimal(0));
		}
		
		participantUO.setRequestFundsId(new BigDecimal(5));
		
		if(caseParticipant.getPersonFullName() != null){
			participantUO.setPersonFullName(caseParticipant.getPersonFullName());
		}else{
			participantUO.setPersonFullName(EMPTY_STRING);
		}
		
		if(caseParticipant.getDob() != null){
			participantUO.setDob(DateUtils.getMMDDYYYYStringAsDate(caseParticipant.getDob()));
		}else{
			participantUO.setDob(new Date());
		}
		
		if(caseParticipant.getType() != null){
			participantUO.setRelationShipTypeCode(caseParticipant.getType());
		}else{
			participantUO.setRelationShipTypeCode(EMPTY_STRING);
		}
		
		if(caseParticipant.getCustody() != null){
			participantUO.setCustody(caseParticipant.getCustody());
		}else{
			participantUO.setCustody(EMPTY_STRING);
		}
		
		if(caseParticipant.getCustodyAgencyId() != null){
			participantUO.setCustodyAgencyId(new BigDecimal(caseParticipant.getCustodyAgencyId()));
		}else{
			participantUO.setCustodyAgencyId(new BigDecimal(0));
		}
		
		if(caseParticipant.getCustodyDate() != null){
			participantUO.setCustodyDate(DateUtils.getMMDDYYYYStringAsDate(caseParticipant.getCustodyDate()));
		}else{
			participantUO.setCustodyDate(new Date());
		}
		
		if(caseParticipant.getIveReimbursable() != null){
			participantUO.setIveReimbursable(caseParticipant.getIveReimbursable());
		}else{
			participantUO.setIveReimbursable(EMPTY_STRING);
		}
		
		//Audit Info
		if(caseParticipant.getCreatedBy() != null){
			participantUO.setCreatedBy(new BigDecimal(caseParticipant.getCreatedBy()));
		}else{
			participantUO.setCreatedBy(new BigDecimal(0));
		}
		
		if(caseParticipant.getCreatedDate() != null){
			participantUO.setCreatedDate(DateUtils.getMMDDYYYYStringAsDate(caseParticipant.getCreatedDate()));
		}else{
			participantUO.setCreatedDate(new Date());
		}
		
		if(caseParticipant.getModifiedby() != null){
			participantUO.setModifiedby(new BigDecimal(caseParticipant.getModifiedby()));
		}else{
			participantUO.setModifiedby(new BigDecimal(0));
		}
		
		if(caseParticipant.getModifiedDate() != null){
			participantUO.setModifiedDate(DateUtils.getMMDDYYYYStringAsDate(caseParticipant.getModifiedDate()));
		}else{
			participantUO.setModifiedDate(new Date());
		}
		
	}

	@Override
	public List<RequestFunds> retrieveRequestFundsRequests(RequestFundsDTO dto) {
		List<Map<String, Object>> requestFundsColl = requestFundsDAO.retrieveRequestFundsRequests(dto.getSacwisId());
		List<RequestFunds> requestFundsList = new ArrayList<RequestFunds>();
		// TODO Auto-generated method stub
		if(requestFundsColl != null && requestFundsColl.size()> 0){
			Iterator<Map<String, Object>> itr = requestFundsColl.iterator();
			while(itr.hasNext()){
				RequestFunds fundRequests = (RequestFunds) itr.next(); 
				requestFundsList.add(fundRequests);
			}
		}
		return requestFundsList;
	}	
	

}
