package oh.lccs.portal.requestfunds.form;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RequestFundsSearchForm {

	//Search Screen Variables
	private String sacwisId;
	private String requestingCaseWorker;
	private String workerPhoneNumber;
	private String requestedDate;

	public String getSacwisId() {
		return sacwisId;
	}
	public void setSacwisId(String sacwisId) {
		this.sacwisId = sacwisId;
	}
	
	public String getRequestingCaseWorker() {
		return requestingCaseWorker;
	}
	public void setRequestingCaseWorker(String requestingCaseWorker) {
		this.requestingCaseWorker = requestingCaseWorker;
	}
	public String getWorkerPhoneNumber() {
		return workerPhoneNumber;
	}
	public void setWorkerPhoneNumber(String workerPhoneNumber) {
		this.workerPhoneNumber = workerPhoneNumber;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	
	@Override
	public String toString() {
		return "SacwisForm [sacwisId=" + sacwisId + ", requestingCaseWorker="
				+ requestingCaseWorker + ", workerPhoneNumber=" + workerPhoneNumber + "requestedDate=" + requestedDate 
				+ "]";
	}

}
