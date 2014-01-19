package oh.lccs.portal.requestfunds.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oh.lccs.portal.db.domain.requestfunds.CaseDetails;
import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;
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

}
