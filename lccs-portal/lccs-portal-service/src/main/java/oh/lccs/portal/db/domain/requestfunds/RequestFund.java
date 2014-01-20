package oh.lccs.portal.db.domain.requestfunds;

import java.math.BigDecimal;

public class RequestFund {
	
	private String name;
	
	private BigDecimal caseId;
	
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
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCaseId() {
		return caseId;
	}

	public void setCaseId(BigDecimal caseId) {
		this.caseId = caseId;
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

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getWorkerPhoneNumber() {
		return workerPhoneNumber;
	}

	public void setWorkerPhoneNumber(String workerPhoneNumber) {
		this.workerPhoneNumber = workerPhoneNumber;
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
