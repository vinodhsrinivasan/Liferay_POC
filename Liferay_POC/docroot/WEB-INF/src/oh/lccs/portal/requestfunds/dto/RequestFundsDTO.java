package oh.lccs.portal.requestfunds.dto;

import oh.lccs.portal.requestfunds.portlet.RequestFundsForm;

public class RequestFundsDTO {
	
	private String sacwisId;
	
	private String sacwisName;

	public String getSacwisId() {
		return sacwisId;
	}
	public void setSacwisId(String sacwisId) {
		this.sacwisId = sacwisId;
	}
	public String getSacwisName() {
		return sacwisName;
	}
	public void setSacwisName(String sacwisName) {
		this.sacwisName = sacwisName;
	}
	
	private String sacwisApproverName;

	public String getSacwisApproverName() {
		return sacwisApproverName;
	}
	public void setSacwisApproverName(String sacwisApproverName) {
		this.sacwisApproverName = sacwisApproverName;
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
