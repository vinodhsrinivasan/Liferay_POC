/**
 * 
 */
package oh.lccs.portal.requestfunds.dto;

import oh.lccs.portal.requestfunds.portlet.RequestFundsSearchForm;

/**
 * @author BCMSZV0
 *
 */
public class RequestFundsSearchDTO {
	
	//Search Screen Parameters
		private String requestingCaseWorker;
		private String workerPhoneNumber;
		private String requestedDate;
		private String sacwisId;
		
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
		public String getSacwisId() {
			return sacwisId;
		}
		public void setSacwisId(String sacwisId) {
			this.sacwisId = sacwisId;
		}
		//TODO: Need to move to spl converter
		public void formToDTO(RequestFundsSearchForm form) {
			setSacwisId(form.getSacwisId());
		}

}
