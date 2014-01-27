package oh.lccs.portal.requestfunds.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		searchResult.setAfterCareIndependence(LucasServiceConstants.CHECKBOX_ON);
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
		
		if(saveFlag){
			int size = dto.getSelectedCaseParticipants().length;
			for (int i = 0; i < size; i++) {
				selectedCaseParticipant = Long.parseLong(dto.getSelectedCaseParticipants()[i]);
				if(dto.getRequestingForPeople() != null && dto.getRequestingForPeople().size() >0 ){
					Iterator<CaseParticipant> caseParticipantItr = dto.getRequestingForPeople().iterator();
					while(caseParticipantItr.hasNext()){
						caseParticipant = caseParticipantItr.next();
						if(caseParticipant.getSacwisId().equalsIgnoreCase(String.valueOf(selectedCaseParticipant))){
							participantUO = new RequestFundsParticipant();
							saveFundRequestParticipant(caseParticipant, participantUO);
							saveFlag = requestFundsDAO.saveFundRequestParticipant(participantUO);
						}
					}
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
		if(dto.getAfterCareIndependence() != null){
			requestFunds.setAfterCareIndependence(dto.getAfterCareIndependence());
		}else{
			requestFunds.setAfterCareIndependence(null);
		}
		
		if(dto.getSacwisId() != null){
			requestFunds.setCaseId(new BigDecimal(dto.getSacwisId()));
		}
		
		if(dto.getRequestedDate() != null){
			requestFunds.setRequestedDate(dto.getRequestedDate());
		}else{
			requestFunds.setRequestedDate(null);
		}
		
		if(dto.getRequestingCaseWorker() != null){
			requestFunds.setRequestingCaseWorker(dto.getRequestingCaseWorker());
		}else{
			requestFunds.setRequestingCaseWorker(null);
		}
		
		if(dto.getCaseWorker() != null){
			requestFunds.setCaseWorker(dto.getCaseWorker());
		}else{
			requestFunds.setCaseWorker(null);
		}
		
		if(dto.getCaseName() != null){
			requestFunds.setCaseName(dto.getCaseName());
		}else{
			requestFunds.setCaseName(null);
		}
		
		if(dto.getWorkerPhoneNumber() != null){
			requestFunds.setWorkerPhoneNumber(dto.getWorkerPhoneNumber());
		}else{
			requestFunds.setWorkerPhoneNumber(null);
		}
		
		//Request Types
		if(dto.getDonation() != null){
			requestFunds.setDonation(dto.getDonation());
		}else{
			requestFunds.setDonation(null);
		}
		
		if(dto.getPrePlacement() != null){
			requestFunds.setPrePlacement(dto.getPrePlacement());
		}else{
			requestFunds.setPrePlacement(null);
		}
		
		if(dto.getAfterCareIndependence() != null){
			requestFunds.setAfterCareIndependence(dto.getAfterCareIndependence());
		}else{
			requestFunds.setAfterCareIndependence(null);
		}
		
		if(dto.getKinshipCare() != null){
			requestFunds.setKinshipCare(dto.getKinshipCare());
		}else{
			requestFunds.setKinshipCare(null);
		}
		
		if(dto.getOperating() != null){
			requestFunds.setOperating(dto.getOperating());
		}else{
			requestFunds.setOperating(null);
		}
		
		if(dto.getFamilyReunification() != null){
			requestFunds.setFamilyReunification(dto.getFamilyReunification());
		}else{
			requestFunds.setFamilyReunification(null);
		}
		
		if(dto.getAlternativeResponse() != null){
			requestFunds.setAlternativeResponse(dto.getAlternativeResponse());
		}else{
			requestFunds.setAlternativeResponse(null);
		}
		
		//Information filled in by Caseworker for approval
		
		if(dto.getPersonRespForPurchase() != null){
			requestFunds.setPersonRespForPurchase(dto.getPersonRespForPurchase());
		}else{
			requestFunds.setPersonRespForPurchase(null);
		}
		
		if(dto.getRequestPurpose() != null){
			requestFunds.setRequestPurpose(dto.getRequestPurpose());
		}else{
			requestFunds.setRequestPurpose(null);
		}
		
		if(dto.getOtherCommResContacted() != null){
			requestFunds.setOtherCommResContacted(dto.getOtherCommResContacted());
		}else{
			requestFunds.setOtherCommResContacted(null);
		}
		
		if(dto.getTotalAmtRequested() != null){
			requestFunds.setTotalAmtRequested(dto.getTotalAmtRequested());
		}else{
			requestFunds.setTotalAmtRequested(null);
		}
		
		if(dto.getDateRequired() != null){
			requestFunds.setDateRequired(dto.getDateRequired());
		}else{
			requestFunds.setDateRequired(null);
		}
		
		if(dto.getFundMode() != null){
			requestFunds.setFundMode(dto.getFundMode());
		}else{
			requestFunds.setFundMode(null);
		}
		
		if(dto.getFundDeliveryType() != null){
			requestFunds.setFundDeliveryType(dto.getFundDeliveryType());
		}else{
			requestFunds.setFundDeliveryType(null);
		}
		
		if(dto.getPaymentMadeFor() != null){
			requestFunds.setPaymentMadeFor(dto.getPaymentMadeFor());
		}else{
			requestFunds.setPaymentMadeFor(null);
		}
		
		if(dto.getOtherInstructions() != null){
			requestFunds.setOtherInstructions(dto.getOtherInstructions());
		}else{
			requestFunds.setOtherInstructions(null);
		}
		
		if(dto.getFurnitureDeliveryAddress() != null){
			requestFunds.setFurnitureDeliveryAddress(dto.getFurnitureDeliveryAddress());
		}else{
			requestFunds.setFurnitureDeliveryAddress(null);
		}
		
		if(dto.getBudgetCenter() != null){
			requestFunds.setBudgetCenter(dto.getBudgetCenter());
		}else{
			requestFunds.setBudgetCenter(null);
		}
		
		if(dto.getLineItem() != null){
			requestFunds.setLineItem(dto.getLineItem());
		}else{
			requestFunds.setLineItem(null);
		}
		
		if(dto.getLineItem() != null){
			requestFunds.setLineItem(dto.getLineItem());
		}else{
			requestFunds.setLineItem(null);
		}
		
		//Workflow Variables
		if(dto.getStatusCode() != null){
			requestFunds.setStatusCode(dto.getStatusCode());
		}else{
			requestFunds.setStatusCode(null);
		}
		
		if(dto.getApproverName() != null){
			requestFunds.setApproverName(dto.getApproverName());
		}else{
			requestFunds.setApproverName(null);
		}
		
		if(dto.getApprover() != null){
			requestFunds.setApprover(dto.getApprover());
		}else{
			requestFunds.setApprover(null);
		}
		
		//Audit Info
		if(dto.getCreatedBy() != null){
			requestFunds.setCreatedBy(dto.getCreatedBy());
		}else{
			requestFunds.setCreatedBy(null);
		}
		
		if(dto.getCreatedDate() != null){
			requestFunds.setCreatedDate(dto.getCreatedDate());
		}else{
			requestFunds.setCreatedDate(null);
		}
		
		if(dto.getModifiedby() != null){
			requestFunds.setModifiedby(dto.getModifiedby());
		}else{
			requestFunds.setModifiedby(null);
		}
		
		if(dto.getModifiedDate() != null){
			requestFunds.setModifiedDate(dto.getModifiedDate());
		}else{
			requestFunds.setModifiedDate(null);
		}
	}
	
	private void saveFundRequestParticipant(CaseParticipant caseParticipant, RequestFundsParticipant participantUO){
		if(caseParticipant.getSacwisId() != null){
			participantUO.setPersonId(caseParticipant.getSacwisId());
		}else{
			participantUO.setPersonId(null);
		}
		
		if(caseParticipant.getPersonFullName() != null){
			participantUO.setPersonFullName(caseParticipant.getPersonFullName());
		}else{
			participantUO.setPersonFullName(null);
		}
		
		if(caseParticipant.getDob() != null){
			participantUO.setDob(caseParticipant.getDob());
		}else{
			participantUO.setDob(null);
		}
		
		if(caseParticipant.getType() != null){
			participantUO.setRelationShipTypeCode(caseParticipant.getType());
		}else{
			participantUO.setRelationShipTypeCode(null);
		}
		
		if(caseParticipant.getCustody() != null){
			participantUO.setCustody(caseParticipant.getCustody());
		}else{
			participantUO.setCustody(null);
		}
		
		if(caseParticipant.getCustodyAgencyId() != null){
			participantUO.setCustodyAgencyId(caseParticipant.getCustodyAgencyId());
		}else{
			participantUO.setCustodyAgencyId(null);
		}
		
		if(caseParticipant.getCustodyDate() != null){
			participantUO.setCustodyDate(caseParticipant.getCustodyDate());
		}else{
			participantUO.setCustodyDate(null);
		}
		
		if(caseParticipant.getIveReimbursable() != null){
			participantUO.setIveReimbursable(caseParticipant.getIveReimbursable());
		}else{
			participantUO.setIveReimbursable(null);
		}
		
		//Audit Info
		if(caseParticipant.getCreatedBy() != null){
			participantUO.setCreatedBy(caseParticipant.getCreatedBy());
		}else{
			participantUO.setCreatedBy(null);
		}
		
		if(caseParticipant.getCreatedDate() != null){
			participantUO.setCreatedDate(caseParticipant.getCreatedDate());
		}else{
			participantUO.setCreatedDate(null);
		}
		
		if(caseParticipant.getModifiedby() != null){
			participantUO.setModifiedby(caseParticipant.getModifiedby());
		}else{
			participantUO.setModifiedby(null);
		}
		
		if(caseParticipant.getModifiedDate() != null){
			participantUO.setModifiedDate(caseParticipant.getModifiedDate());
		}else{
			participantUO.setModifiedDate(null);
		}
		
	}	

}
