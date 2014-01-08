/**
 * 
 */
package oh.lccs.portal.db.domain.requestfunds;

import java.math.BigDecimal;

/**
 * @author BCMSZV0
 *
 */
public class CaseParticipant {
	
	private String personFullName;
	private String sacwisId;
	private BigDecimal caseId;
	private String dob;
	private String type;
	private String requestingPersonCheckbox;
	
	private String custody;
	private String placement;
	private String custodyDate;
	private String iveReimbursable;
	
	public String getPersonFullName() {
		return personFullName;
	}
	public void setPersonFullName(String personFullName) {
		this.personFullName = personFullName;
	}
	public String getSacwisId() {
		return sacwisId;
	}
	public void setSacwisId(String sacwisId) {
		this.sacwisId = sacwisId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRequestingPersonCheckbox() {
		return requestingPersonCheckbox;
	}
	public void setRequestingPersonCheckbox(String requestingPersonCheckbox) {
		this.requestingPersonCheckbox = requestingPersonCheckbox;
	}
	public BigDecimal getCaseId() {
		return caseId;
	}
	public void setCaseId(BigDecimal caseId) {
		this.caseId = caseId;
	}
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
	


}
