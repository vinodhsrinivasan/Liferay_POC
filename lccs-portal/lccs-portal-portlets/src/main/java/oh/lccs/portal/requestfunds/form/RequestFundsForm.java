package oh.lccs.portal.requestfunds.portlet;

import java.util.List;

import oh.lccs.portal.requestfunds.dto.RequestTypeDTO;
import oh.lccs.portal.requestfunds.dto.RequestingPersonDTO;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RequestFundsForm {

	//Header Variables
	private String sacwisId;
	private String requestedDate;
	private String requestingCaseWorker;
	private String caseWorker;
	private String workerPhoneNumber;
	
	//Check Person for which request is being made section
	private List<RequestTypeDTO> requestTypes;
	private List<RequestingPersonDTO> requestingForPeople;
	
	//Information filed in by Caseworker for approval
	private String personRespForPurchase;
	private String requestPurpose;
	private String otherCommResContacted;
	private String totalAmtRequested;
	private String dateRequired;
	private String fundMode;
	private String fundDeliveryType;
	private String paymentMadeFor;
	private String otherInstructions;
	private String furnitureDeliveryAddress;
	private String budgetCenter;
	private String lineItem;

	public String getSacwisId() {
		return sacwisId;
	}
	public void setSacwisId(String sacwisId) {
		this.sacwisId = sacwisId;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public String getRequestingCaseWorker() {
		return requestingCaseWorker;
	}
	public void setRequestingCaseWorker(String requestingCaseWorker) {
		this.requestingCaseWorker = requestingCaseWorker;
	}
	public String getCaseWorker() {
		return caseWorker;
	}
	public void setCaseWorker(String caseWorker) {
		this.caseWorker = caseWorker;
	}
	public String getWorkerPhoneNumber() {
		return workerPhoneNumber;
	}
	public void setWorkerPhoneNumber(String workerPhoneNumber) {
		this.workerPhoneNumber = workerPhoneNumber;
	}
	public List<RequestTypeDTO> getRequestTypes() {
		return requestTypes;
	}
	public void setRequestTypes(List<RequestTypeDTO> requestTypes) {
		this.requestTypes = requestTypes;
	}
	public List<RequestingPersonDTO> getRequestingForPeople() {
		return requestingForPeople;
	}
	public void setRequestingForPeople(List<RequestingPersonDTO> requestingForPeople) {
		this.requestingForPeople = requestingForPeople;
	}
	public String getPersonRespForPurchase() {
		return personRespForPurchase;
	}
	public void setPersonRespForPurchase(String personRespForPurchase) {
		this.personRespForPurchase = personRespForPurchase;
	}
	public String getRequestPurpose() {
		return requestPurpose;
	}
	public void setRequestPurpose(String requestPurpose) {
		this.requestPurpose = requestPurpose;
	}
	public String getOtherCommResContacted() {
		return otherCommResContacted;
	}
	public void setOtherCommResContacted(String otherCommResContacted) {
		this.otherCommResContacted = otherCommResContacted;
	}
	public String getTotalAmtRequested() {
		return totalAmtRequested;
	}
	public void setTotalAmtRequested(String totalAmtRequested) {
		this.totalAmtRequested = totalAmtRequested;
	}
	public String getDateRequired() {
		return dateRequired;
	}
	public void setDateRequired(String dateRequired) {
		this.dateRequired = dateRequired;
	}
	public String getFundMode() {
		return fundMode;
	}
	public void setFundMode(String fundMode) {
		this.fundMode = fundMode;
	}
	public String getFundDeliveryType() {
		return fundDeliveryType;
	}
	public void setFundDeliveryType(String fundDeliveryType) {
		this.fundDeliveryType = fundDeliveryType;
	}
	public String getPaymentMadeFor() {
		return paymentMadeFor;
	}
	public void setPaymentMadeFor(String paymentMadeFor) {
		this.paymentMadeFor = paymentMadeFor;
	}
	public String getOtherInstructions() {
		return otherInstructions;
	}
	public void setOtherInstructions(String otherInstructions) {
		this.otherInstructions = otherInstructions;
	}
	public String getFurnitureDeliveryAddress() {
		return furnitureDeliveryAddress;
	}
	public void setFurnitureDeliveryAddress(String furnitureDeliveryAddress) {
		this.furnitureDeliveryAddress = furnitureDeliveryAddress;
	}
	public String getBudgetCenter() {
		return budgetCenter;
	}
	public void setBudgetCenter(String budgetCenter) {
		this.budgetCenter = budgetCenter;
	}
	public String getLineItem() {
		return lineItem;
	}
	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}


}
