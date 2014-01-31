package oh.lccs.portal.requestfunds.form;

import java.util.List;

import oh.lccs.portal.db.domain.requestfunds.RequestFunds;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RequestFundsSearchForm {

	//Search Screen Variables
	private String sacwisId;
	private String requestingCaseWorker;
	private String workerPhoneNumber;
	private String requestedDate;
	
	private List<RequestFunds> requestFundsRequests;

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
	public List<RequestFunds> getRequestFundsRequests() {
		return requestFundsRequests;
	}
	public void setRequestFundsRequests(List<RequestFunds> requestFundsRequests) {
		this.requestFundsRequests = requestFundsRequests;
	}
	@Override
	public String toString() {
		return "RequestFundsSearchForm [sacwisId=" + sacwisId
				+ ", requestingCaseWorker=" + requestingCaseWorker
				+ ", workerPhoneNumber=" + workerPhoneNumber
				+ ", requestedDate=" + requestedDate + "]";
	}

	

}
