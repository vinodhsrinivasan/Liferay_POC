package oh.lccs.portal.db.domain.requestfunds;

import java.math.BigDecimal;

/**
 * This object represents RequestFunds Case details
 * 
 * 
 * @author vinodh.srinivasan@compuware.com
 *
 */
public class CaseDetails {
	
	private BigDecimal caseId;
	
	public BigDecimal getCaseId() {
		return caseId;
	}

	public void setCaseId(BigDecimal caseId) {
		this.caseId = caseId;
	}

	private String greeting;
	
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "CaseDetails [caseId=" + caseId + ", greeting=" + greeting + "]";
	}


}
