package oh.lccs.portal.requestfunds.service;

import java.util.ArrayList;
import java.util.List;

import oh.lccs.portal.requestfunds.dto.RequestFundsDTO;
import oh.lccs.portal.requestfunds.dto.RequestTypeDTO;
import oh.lccs.portal.requestfunds.dto.RequestingPersonDTO;
import oh.lccs.portal.service.constants.LucasServiceConstants;

import org.springframework.stereotype.Service;

@Service(value=LucasServiceConstants.REQUEST_FUNDS_SERVICE)
public class RequestFundsServiceImpl implements RequestFundsService {

	@Override
	public RequestFundsDTO searchForm(RequestFundsDTO dto) {
		return mockData();
	}
	
	private RequestFundsDTO mockData(){
		
		RequestFundsDTO searchResult= new RequestFundsDTO();
		searchResult.setSacwisId("1234");
		searchResult.setRequestedDate("01/01/2013");
		searchResult.setRequestingCaseWorker("Test Requestor");
		searchResult.setCaseWorker("Test Case Worker");
		searchResult.setWorkerPhoneNumber("(123) 456 - 7890");
		
		List<RequestTypeDTO> requestTypes = new ArrayList<RequestTypeDTO>();
		
		RequestTypeDTO reqdto1 = new RequestTypeDTO();
		reqdto1.setRequestType("Donation");
		reqdto1.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto1);
		
		RequestTypeDTO reqdto2 = new RequestTypeDTO();
		reqdto2.setRequestType("Preplacement Prevention");
		reqdto2.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto2);
		
		RequestTypeDTO reqdto3 = new RequestTypeDTO();
		reqdto3.setRequestType("Aftercare Independence");
		reqdto3.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto3);
		
		RequestTypeDTO reqdto4 = new RequestTypeDTO();
		reqdto4.setRequestType("Kinship Care");
		reqdto4.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto4);
		
		RequestTypeDTO reqdto5 = new RequestTypeDTO();
		reqdto5.setRequestType("Operating");
		reqdto5.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto5);
		
		RequestTypeDTO reqdto6 = new RequestTypeDTO();
		reqdto6.setRequestType("Family Reunification");
		reqdto6.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto6);
		
//		RequestTypeDTO reqdto7 = new RequestTypeDTO();
//		reqdto7.setRequestType("TANF/Child Welfare");
//		reqdto7.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
//		requestTypes.add(reqdto7);
		
		RequestTypeDTO reqdto8 = new RequestTypeDTO();
		reqdto8.setRequestType("Alternative Response");
		reqdto8.setRequestTypeCheckBox(LucasServiceConstants.CHECKBOX_OFF);
		requestTypes.add(reqdto8);

		searchResult.setRequestTypes(requestTypes);
		
		List<RequestingPersonDTO> requestingPeople = new ArrayList<RequestingPersonDTO>();
		RequestingPersonDTO dto1 = new RequestingPersonDTO();
		dto1.setPersonFullName("Test User 1");
		dto1.setDob("01/01/2014");
		dto1.setSacwisId("1234");
		dto1.setType("Natural Parent");
		dto1.setRequestingPersonCheckbox(LucasServiceConstants.CHECKBOX_ON);
		requestingPeople.add(dto1);
		
		RequestingPersonDTO dto2 = new RequestingPersonDTO();
		dto2.setPersonFullName("Test User 2");
		dto2.setDob("01/01/2014");
		dto2.setSacwisId("5678");
		dto2.setType("Child");
		dto1.setRequestingPersonCheckbox(LucasServiceConstants.CHECKBOX_ON);
		requestingPeople.add(dto2);
		
		searchResult.setRequestingForPeople(requestingPeople);
		
		searchResult.setPersonRespForPurchase("Test Purchaser");
		searchResult.setRequestPurpose("To purchase office supplies");
		searchResult.setOtherCommResContacted("Contacted the manager");
		searchResult.setTotalAmtRequested("200.00");
		searchResult.setDateRequired("01/01/2014");
		searchResult.setFundMode("Voucher");
		searchResult.setFundDeliveryType("PICKEDUP");
		searchResult.setPaymentMadeFor("Test Manager");
		searchResult.setOtherInstructions("Please process the payment");
		searchResult.setBudgetCenter("JHJHJH-8989");
		searchResult.setLineItem("21212");
		
		return searchResult;
	}

}
