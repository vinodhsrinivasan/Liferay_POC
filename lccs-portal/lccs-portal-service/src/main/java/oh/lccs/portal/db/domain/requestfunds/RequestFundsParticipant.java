/**
 * 
 */
package oh.lccs.portal.db.domain.requestfunds;


/**
 * @author BCMSZV0
 *
 */
public class RequestFundsParticipant {
	
	private String requestFundsId;
	
	private String personFullName;
	private String personId;
	private String dob;
	private String relationShipTypeCode;;
	
	private String custody;
	private String custodyAgencyId;
	private String placement;
	private String custodyDate;
	private String iveReimbursable;
	
	//Audit Info
	private String createdBy;
	private String createdDate;
	private String modifiedby;
	private String modifiedDate;
	
	public String getRequestFundsId() {
		return requestFundsId;
	}
	public void setRequestFundsId(String requestFundsId) {
		this.requestFundsId = requestFundsId;
	}
	public String getPersonFullName() {
		return personFullName;
	}
	public void setPersonFullName(String personFullName) {
		this.personFullName = personFullName;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRelationShipTypeCode() {
		return relationShipTypeCode;
	}
	public void setRelationShipTypeCode(String relationShipTypeCode) {
		this.relationShipTypeCode = relationShipTypeCode;
	}
//	public BigDecimal getCaseId() {
//		return caseId;
//	}
//	public void setCaseId(BigDecimal caseId) {
//		this.caseId = caseId;
//	}
	public String getCustody() {
		return custody;
	}
	public void setCustody(String custody) {
		this.custody = custody;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public String getCustodyDate() {
		return custodyDate;
	}
	public void setCustodyDate(String custodyDate) {
		this.custodyDate = custodyDate;
	}
	public String getIveReimbursable() {
		return iveReimbursable;
	}
	public void setIveReimbursable(String iveReimbursable) {
		this.iveReimbursable = iveReimbursable;
	}
	public String getCustodyAgencyId() {
		return custodyAgencyId;
	}
	public void setCustodyAgencyId(String custodyAgencyId) {
		this.custodyAgencyId = custodyAgencyId;
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
