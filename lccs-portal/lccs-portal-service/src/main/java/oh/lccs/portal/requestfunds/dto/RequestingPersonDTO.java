/**
 * 
 */
package oh.lccs.portal.requestfunds.dto;

/**
 * @author BCMSZV0
 *
 */
public class RequestingPersonDTO {
	
	private String personFullName;
	private String sacwisId;
	private String dob;
	private String type;
	private String requestingPersonCheckbox;
	
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
	


}
