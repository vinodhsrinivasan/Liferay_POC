package oh.lucas.portal.sacwis.portlet;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class SacwisForm {
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
	
	private String sacwisApproverName;

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
}
