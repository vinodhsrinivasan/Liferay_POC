package oh.lucas.portal.sacwis.dto;

import oh.lucas.portal.sacwis.portlet.SacwisForm;

public class SacwisDTO {
	
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
	public void formToDTO(SacwisForm form) {
		setSacwisId(form.getSacwisId());
		setSacwisName(form.getSacwisName());
	}
	
	//TODO: Need to move to spl converter
	public void dtoToForm(SacwisForm form){
		form.setSacwisId(getSacwisId());
		form.setSacwisName(getSacwisName());
		form.setSacwisApproverName(getSacwisApproverName());
	}
}
