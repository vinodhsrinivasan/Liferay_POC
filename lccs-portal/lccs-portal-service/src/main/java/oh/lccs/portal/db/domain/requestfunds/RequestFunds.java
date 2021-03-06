package oh.lccs.portal.db.domain.requestfunds;

import java.math.BigDecimal;
import java.util.Date;

public class RequestFunds {
	
	private String name;
	
	private BigDecimal caseId;
	
	private Date requestedDate;
	private BigDecimal requestingCaseWorker;
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
	private BigDecimal personRespForPurchase;
	private String requestPurpose;
	private String otherCommResContacted;
	private String totalAmtRequested;
	private Date dateRequired;
	private String fundMode;
	private String fundDeliveryType;
	private String paymentMadeFor;
	private String otherInstructions;
	private String furnitureDeliveryAddress;
	private String budgetCenter;
	private String lineItem;
	
	//Variables for the workflow
	private BigDecimal statusCode;
	private String approverName;
	private BigDecimal approver;
	
	//Audit Info
	private BigDecimal createdBy;
	private Date createdDate;
	private BigDecimal modifiedby;
	private Date modifiedDate;
	
	

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

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public BigDecimal getRequestingCaseWorker() {
		return requestingCaseWorker;
	}

	public void setRequestingCaseWorker(BigDecimal requestingCaseWorker) {
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

	public BigDecimal getPersonRespForPurchase() {
		return personRespForPurchase;
	}

	public void setPersonRespForPurchase(BigDecimal personRespForPurchase) {
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

	public Date getDateRequired() {
		return dateRequired;
	}

	public void setDateRequired(Date dateRequired) {
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

	public BigDecimal getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(BigDecimal statusCode) {
		this.statusCode = statusCode;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public BigDecimal getApprover() {
		return approver;
	}

	public void setApprover(BigDecimal approver) {
		this.approver = approver;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(BigDecimal modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
