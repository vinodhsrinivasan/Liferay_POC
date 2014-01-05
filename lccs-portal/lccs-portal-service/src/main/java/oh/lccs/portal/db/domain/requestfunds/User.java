package oh.lccs.portal.db.domain.requestfunds;

public class User {
	
	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "User [greeting=" + greeting + "]";
	}

}
