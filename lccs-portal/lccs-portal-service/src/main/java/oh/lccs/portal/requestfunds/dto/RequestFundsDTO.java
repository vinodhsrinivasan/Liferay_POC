package oh.lccs.portal.requestfunds.dto;


public class RequestFundsDTO {
	
	private String sacwisId;
	private String sacwisName;
	private String sacwisApproverName;
	
	public RequestFundsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public RequestFundsDTO(String sacwisId, String sacwisName,
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
	public void setSacwisName(String sacwisName) {
		this.sacwisName = sacwisName;
	}
	

	public String getSacwisApproverName() {
		return sacwisApproverName;
	}
	public void setSacwisApproverName(String sacwisApproverName) {
		this.sacwisApproverName = sacwisApproverName;
	}
	
	
}
