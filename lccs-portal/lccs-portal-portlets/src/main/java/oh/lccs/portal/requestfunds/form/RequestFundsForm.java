package oh.lccs.portal.requestfunds.form;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RequestFundsForm {
	
	private String sacwisId;
	private String sacwisName;
	private String sacwisApproverName;
	
	public RequestFundsForm() {
		// TODO Auto-generated constructor stub
	}
	
	public RequestFundsForm(String sacwisId, String sacwisName,
			String sacwisApproverName) {
		super();
		this.sacwisId = sacwisId;
		this.sacwisName = sacwisName;
		this.sacwisApproverName = sacwisApproverName;
	}


	public String getSacwisId() {
		return sacwisId;
	}
	public void setSacwisId(String sacwisId) {
		this.sacwisId = sacwisId;
	}
	public String getSacwisName() {
		return sacwisName;
	}

	public String getSacwisApproverName() {
		return sacwisApproverName;
	}
	public void setSacwisApproverName(String sacwisApproverName) {
		this.sacwisApproverName = sacwisApproverName;
	}
	
	@Override
	public String toString() {
		return "SacwisForm [sacwisId=" + sacwisId + ", sacwisName="
				+ sacwisName + ", sacwisApproverName=" + sacwisApproverName
				+ "]";
	}
	public void setSacwisName(String sacwisName) {
		this.sacwisName = sacwisName;
	}
	
	//TODO: Need to move to spl converter
		public void formToDTO(RequestFundsForm form) {
			setSacwisId(form.getSacwisId());
			setSacwisName(form.getSacwisName());
		}
		
		//TODO: Need to move to spl converter
		public void dtoToForm(RequestFundsForm form){
			form.setSacwisId(getSacwisId());
			form.setSacwisName(getSacwisName());
			form.setSacwisApproverName(getSacwisApproverName());
		}
}
