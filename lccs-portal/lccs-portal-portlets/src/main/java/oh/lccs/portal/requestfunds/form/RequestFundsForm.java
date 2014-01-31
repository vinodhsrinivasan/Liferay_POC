package oh.lccs.portal.requestfunds.form;

import java.util.List;

/*import oh.lccs.portal.requestfunds.dto.RequestTypeDTO;
import oh.lccs.portal.requestfunds.dto.RequestingPersonDTO;*/





import oh.lccs.portal.db.domain.requestfunds.CaseParticipant;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RequestFundsForm {

	//Header Variables
	private String sacwisId;
	private String requestedDate;
	private String requestingCaseWorker;
	private String caseWorker;
	private String caseName;
	private String workerPhoneNumber;
	
	//Request Types
	private String donation;
	private String prePlacement;
	private String afterCareIndependence;
	private String kinshipCare;
	private String operating;
	private String familyReunification;
	private String alternativeResponse;
	
	private String[] requestType;
	
	//Check Person for which request is being made section
//	private List<RequestTypeDTO> requestTypes;
	private List<CaseParticipant> requestingForPeople;
	private String[] selectedCaseParticipants;
	
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
	
	//Variables for the workflow
	private String statusCode;
	private String approverName;
	private String approver;
	
	//Audit Info
	private String createdBy;
	private String createdDate;
	private String modifiedby;
	private String modifiedDate;
	
	

	/**
	 * 
	 */
	public RequestFundsForm() {
//		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sacwisId
	 * @param requestedDate
	 * @param requestingCaseWorker
	 * @param caseWorker
	 * @param caseName
	 * @param workerPhoneNumber
	 * @param donation
	 * @param prePlacement
	 * @param afterCareIndependence
	 * @param kinshipCare
	 * @param operating
	 * @param familyReunification
	 * @param alternativeResponse
	 * @param requestType
	 * @param requestingForPeople
	 * @param selectedCaseParticipants
	 * @param personRespForPurchase
	 * @param requestPurpose
	 * @param otherCommResContacted
	 * @param totalAmtRequested
	 * @param dateRequired
	 * @param fundMode
	 * @param fundDeliveryType
	 * @param paymentMadeFor
	 * @param otherInstructions
	 * @param furnitureDeliveryAddress
	 * @param budgetCenter
	 * @param lineItem
	 * @param statusCode
	 * @param approverName
	 * @param approver
	 * @param createdBy
	 * @param createdDate
	 * @param modifiedby
	 * @param modifiedDate
	 */
	public RequestFundsForm(String sacwisId, String requestedDate,
			String requestingCaseWorker, String caseWorker, String caseName,
			String workerPhoneNumber, String donation, String prePlacement,
			String afterCareIndependence, String kinshipCare, String operating,
			String familyReunification, String alternativeResponse,
			String[] requestType, List<CaseParticipant> requestingForPeople,
			String[] selectedCaseParticipants, String personRespForPurchase,
			String requestPurpose, String otherCommResContacted,
			String totalAmtRequested, String dateRequired, String fundMode,
			String fundDeliveryType, String paymentMadeFor,
			String otherInstructions, String furnitureDeliveryAddress,
			String budgetCenter, String lineItem, String statusCode,
			String approverName, String approver, String createdBy,
			String createdDate, String modifiedby, String modifiedDate) {
		super();
		this.sacwisId = sacwisId;
		this.requestedDate = requestedDate;
		this.requestingCaseWorker = requestingCaseWorker;
		this.caseWorker = caseWorker;
		this.caseName = caseName;
		this.workerPhoneNumber = workerPhoneNumber;
		this.donation = donation;
		this.prePlacement = prePlacement;
		this.afterCareIndependence = afterCareIndependence;
		this.kinshipCare = kinshipCare;
		this.operating = operating;
		this.familyReunification = familyReunification;
		this.alternativeResponse = alternativeResponse;
		this.requestType = requestType;
		this.requestingForPeople = requestingForPeople;
		this.selectedCaseParticipants = selectedCaseParticipants;
		this.personRespForPurchase = personRespForPurchase;
		this.requestPurpose = requestPurpose;
		this.otherCommResContacted = otherCommResContacted;
		this.totalAmtRequested = totalAmtRequested;
		this.dateRequired = dateRequired;
		this.fundMode = fundMode;
		this.fundDeliveryType = fundDeliveryType;
		this.paymentMadeFor = paymentMadeFor;
		this.otherInstructions = otherInstructions;
		this.furnitureDeliveryAddress = furnitureDeliveryAddress;
		this.budgetCenter = budgetCenter;
		this.lineItem = lineItem;
		this.statusCode = statusCode;
		this.approverName = approverName;
		this.approver = approver;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedby = modifiedby;
		this.modifiedDate = modifiedDate;
	}

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
	/*public List<RequestTypeDTO> getRequestTypes() {
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
	}*/
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
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getDonation() {
		return donation;
	}
	public void setDonation(String donation) {
		this.donation = donation;
	}
	public String getPrePlacement() {
		return prePlacement;
	}
	public void setPrePlacement(String prePlacement) {
		this.prePlacement = prePlacement;
	}
	public String getAfterCareIndependence() {
		return afterCareIndependence;
	}
	public void setAfterCareIndependence(String afterCareIndependence) {
		this.afterCareIndependence = afterCareIndependence;
	}
	public String getKinshipCare() {
		return kinshipCare;
	}
	public void setKinshipCare(String kinshipCare) {
		this.kinshipCare = kinshipCare;
	}
	public String getOperating() {
		return operating;
	}
	public void setOperating(String operating) {
		this.operating = operating;
	}
	public String getFamilyReunification() {
		return familyReunification;
	}
	public void setFamilyReunification(String familyReunification) {
		this.familyReunification = familyReunification;
	}
	public String getAlternativeResponse() {
		return alternativeResponse;
	}
	public void setAlternativeResponse(String alternativeResponse) {
		this.alternativeResponse = alternativeResponse;
	}
	public String[] getRequestType() {
		return requestType;
	}
	public void setRequestType(String[] requestType) {
		this.requestType = requestType;
	}
	public List<CaseParticipant> getRequestingForPeople() {
		return requestingForPeople;
	}
	public void setRequestingForPeople(List<CaseParticipant> requestingForPeople) {
		this.requestingForPeople = requestingForPeople;
	}
	public String[] getSelectedCaseParticipants() {
		return selectedCaseParticipants;
	}
	public void setSelectedCaseParticipants(String[] selectedCaseParticipants) {
		this.selectedCaseParticipants = selectedCaseParticipants;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


}
