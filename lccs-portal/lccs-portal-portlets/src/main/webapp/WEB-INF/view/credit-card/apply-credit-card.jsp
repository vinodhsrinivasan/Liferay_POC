<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:resourceURL var="accResourceURL" id="applyCreditCard" ></portlet:resourceURL>
<div id="apply-credit-card-page-content">
	<h2 class="apply-now-title">Apply now in 3 easy steps.</h2>
	<div id="server-form-validation-errors"><!-- server form validation errors div --></div>
	<div id="form-validation-errors"><ul><!-- errors --></ul></div>
	<!-- Tab Navigator -->
	<div id="personal-info-tab" class="col-xs-4 active-tab">
		<div id="personal-info-tab-top" class="top-active-tab tab-label">
			<h4 class="visible-md visible-lg">Step 1: About You</h4>
			<h4 class="visible-xs visible-sm">Step 1</h4>
		</div>
	</div>
	<div id="financial-info-tab" class="col-xs-4 inactive-tab">
		<div id="financial-info-tab-top" class="top-inactive-tab tab-label">
			<h4 class="visible-md visible-lg">Step 2:Financial Info</h4>
			<h4 class="visible-xs visible-sm">Step 2</h4>
		</div>
	</div>
	<div id="consent-terms-tab" class="col-xs-4 inactive-tab">
		<div id="consent-terms-tab-top" class="top-inactive-tab tab-label">
			<h4 class="visible-md visible-lg">Step 3:Consent to Terms</h4>
			<h4 class="visible-xs visible-sm">Step 3</h4>
		</div>
	</div>
			
	<div class="tab-content-container">
		<i class="icon-lock lock-img-style"></i>
		<span class="secure-app-label">This application is secure.</span>
		<form action="#" class="form-inline" role="form" id="applyCardForm">
	
			<input type="hidden" name="cardType" value="${cardType}"/>
			<input type="hidden" name="cardName" value="${cardName}"/>
			<!-- Tab1 -- Personal info start-->
			<div id="personal-info" class="tab-content-section">
				<h4>Please tell us about yourself.</h4>
				<h6>All fields are required except where indicated.</h6>
				<!-- fields -->
				<div class="form-group">
					<label for="firstName">Legal First Name</label>
					<div>
						<input name="firstName" class="form-control" maxlength="14" required data-msg-required="First Name is required."/>
					</div>
				</div>
				<div class="form-group">
					<label for="middleInitial">Middle Initial <sub class="info-text">(optional)</sub></label>
					<div>
						<input name="middleInitial" class="form-control width-auto" size="10" />
					</div>
				</div>
				<div class="form-group">
					<label for="lastName">Last Name</label>
					<input name="lastName" class="form-control" maxlength="20" required data-msg-required="Last Name is required." />
				</div>
				<br />
				<br />
				<div class="form-group">
					<label for="firstName">Date of Birth</label>
				</div>
				<br />
				<div class="form-group">
					<select id="month" name="month" class="form-control" required data-msg-required="Date of Birth Month is required.">
						<option value="">Month</option>
					</select>
				</div>
				<div class="form-group">/</div>
				<!-- Date of birth - Day -->
				<div class="form-group">
					<select id="day" name="day" class="form-control" required data-msg-required="Date of Birth Day is required.">
						<option value="">Day</option>
					</select>
				</div>
				<div class="form-group">/</div>
				<div class="form-group">
					<select id="year" name="year" class="form-control" required data-msg-required="Date of Birth Year is required.">
						<option value="">Year</option>
					</select>
				</div>
				<div class="form-group">
					<span class="info-text">You must be at least 18 years of age to apply</span>
				</div>
				<br />
				<br />
				<div class="form-group">
					<label for="streetAddress">Residential Street Address</label> <input
						type="text" name="streetAddress" class="form-control" maxlength="23" required data-msg-required="Residential Street Address is required." />
				</div>
				<div class="form-group">
					<label for="aptNumber">Apartment Number <sub class="info-text">(optional)</sub></label>
					<div>
						<input type="text" name="aptNumber" class="form-control width-auto" maxlength="23" size="10" />
					</div>
				</div>
				<br />
				<br />
				<div class="form-group">
					<label for="city">City</label>
					<input type="text" name="city" class="form-control"  maxlength="15" required data-msg-required="Residential City is required." />
				</div>
	
				<!-- State -->
				<div class="form-group">
					<label for="resState">State</label>
					<select id="resState" name="resState" class="form-control"  required data-msg-required="Residential State is required.">
						<option value="">State</option>
					</select>
				</div>
				<!--  ZIP Code -->
				<div class="form-group">
					<label for="zipCode">ZIP Code</label>
					<div>
						<input type="text" name="zipCode" class="form-control width-auto" maxlength="9" size="10" required data-msg-required="Residential Address Zip Code is required."/>
					</div>
				</div>
	
				<!-- Address - More than 1 year -->
				<br>
				<br>
				<div class="form-group">
					<label>Have you lived at this address longer than 1 year?</label>
				</div>
				<br />
				<div class="form-group">
					<label class="radio-inline">
						<input type="radio"	name="addressMoreOneYear" value="Yes" /><label>Yes</label>
					</label> 
					<label class="radio-inline">
						<input type="radio"	name="addressMoreOneYear" value="No" checked /><label>No</label>
					</label>
				</div>
				<!--  Previous Street Address -->
				<br>
				<br>
				<div id="previous-residential-address">
					<div class="form-group">
						<label for="previousAddress">Previous Residential Address</label> <input
							type="text" name="previousAddress" class="form-control" maxlength="23" required data-msg-required="Previous Residential Address is required." />
					</div>
		
					<!-- Previous Apartment Number -->
					<div class="form-group">
						<label for="previousAptNumber">Apartment Number <sub class="info-text">(optional)</sub></label>
						<div>
							<input type="text" name="previousAptNumber" class="form-control width-auto" maxlength="23" size="10" />
						</div>
					</div>
		
					<!-- Previous City -->
					<br />
					<br>
					<div class="form-group">
						<label for="previousCity">City</label>
						<input type="text" name="previousCity" class="form-control" maxlength="15" required data-msg-required="Previous Residential City is required." />
					</div>
					<!-- Previous State -->
					<div class="form-group">
						<label for="previousState">State</label>
						<select id="previousState" name="previousState" class="form-control" required data-msg-required="Previous Residential State is required." />
							<option value="">State</option>
						</select>
					</div>
					<div class="form-group">
						<label for="previousZipCode">ZIP Code</label>
						<div>
							<input type="text" name="previousZipCode" class="form-control width-auto" maxlength="9" size="10" required data-msg-required="Previous Residential Address Zip Code is required." />
						</div>
					</div>
				</div>
				<!-- Mailing Address -->
				<br />
				<br />
				<div class="form-group">
					<label>Mailing Address</label>
				</div>
				<br />
				<div class="form-group">
					<label class="radio-inline">
						<input type="radio"	name="sameMailingAddress" value="Yes" /><label>Same as residential address</label>
					</label>
					<label class="radio-inline">
					<input type="radio"	name="sameMailingAddress" value="No" checked /><label>Different	than residential address</label>
					</label>
				</div>
				<!--  Previous Street Address -->
				<br>
				<div id="mailing-address">
					<div class="form-group">
						<label for="mailingAddress">Mailing Address</label>
						<input type="text" name="mailingAddress" class="form-control" maxlength="23" required data-msg-required="Mailing Address is required."/>
					</div>
		
					<!-- Previous Apartment Number -->
					<div class="form-group">
						<label for="mailingAptNumber">Apartment Number <sub	class="info-text">(optional)</sub></label>
						<div>
							<input type="text" name="mailingAptNumber" class="form-control width-auto" maxlength="23" size="10" />
						</div>
					</div>
					<br>
					<br>
					<div class="form-group">
						<label for="mailingCity">City</label>
						<input type="text" name="mailingCity" class="form-control" maxlength="15" required data-msg-required="Mailing City is required." />
					</div>
					<div class="form-group">
						<label for="mailingState">State</label>
						<select id="mailingState" name="mailingState" class="form-control" required data-msg-required="Mailing State is required.">
							<option value="">State</option>
						</select>
					</div>
					<div class="form-group">
						<label for="mailingZipCode">ZIP Code</label>
						<div>
							<input type="text" name="mailingZipCode" class="form-control width-auto" maxlength="9" size="10" required data-msg-required="Mailing Address Zip Code is required." />
						</div>
					</div>
				</div>
				<!-- Phone Number -->
				<br>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<label>Phone Number</label>
					</div>
					<div class="col-xs-6">
						<label>Work Number <sub class="info-text">(optional)</sub></label>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-6">
						<input type="text" name="phone1" class="form-control width-auto" size="5" maxlength="3" required data-msg-required="Home Phone Number first field is required." />
						<input type="text" name="phone2" maxlength="3" class="form-control width-auto" size="5" maxlength="3"  required data-msg-required="Home Phone Number second field is required."/> 
						<input type="text" name="phone3" class="form-control width-auto" size="5" maxlength="4" required data-msg-required="Home Phone Number third field is required." />
					</div>
					<div class="col-xs-6">
						<input type="text" name="workPhone1" class="form-control width-auto" size="5" maxlength="3"/>
						<input type="text" name="workPhone2" class="form-control width-auto" size="5" maxlength="3" />
						<input type="text" name="workPhone3" class="form-control width-auto" size="5" maxlength="4" />
					</div>
				</div>
				<!-- Email Address -->
				<br />
				<div class="form-group">
					<label for="emailAddress">Email Address</label>
					<input type="text" id="emailAddress" name="emailAddress" class="form-control" maxlength="30" required data-msg-required="Email Address is required." data-rule-email="true" data-msg-email="Please enter a valid email address."/>
				</div>
	
				<!-- Confirm Email Address -->
				<div class="form-group">
					<label for="confirmEmailAddress">Confirm Email Address</label>
					<input type="text" id="confirmEmailAddress" name="confirmEmailAddress" class="form-control" maxlength="30" required data-msg-required="Confirm Email Address is required."/>
				</div>
				<br />
				<br />
				<button type="button" class="btn btn-primary btn-sm" onclick="continueToSecondStep()">Continue to Step 2</button>
			</div>
			<!-- Tab1 -- Personal info end -->
			<!-- Tab2 -- financial info start-->
			<div id="financial-info" class="tab-content-section tab-pane-hidden">
				<h4>Please tell us about yourself.</h4>
				<h6>All fields are required except where indicated.</h6>
				<!-- fields -->
				<div class="form-group">
					<label>Social Security Number</label>
				</div>
				<br />
				<div class="form-group">
					<input type="text" name="ssn1" class="form-control width-auto" size="5" maxlength="3" required data-msg-required="Social Security Number first field is required." />
					<input type="text" name="ssn2" class="form-control width-auto" size="3" maxlength="2"  required data-msg-required="Social Security Number second field is required."  />
					<input type="text" name="ssn3" class="form-control width-auto" size="7" maxlength="4" 	required data-msg-required="Social Security Number third field is required."  />
				</div>
				<br>
				<br>
				<div class="form-group">
					<label for="driverNumber">Drivers License Number</label>
					<input type="text" name="driverNumber" class="form-control" maxlength="20" required data-msg-required="Drivers License Number is required."/>
				</div>
				<div class="form-group">
					<label for="issuingState">Issuing State</label>
					<select	id="issuingState" name="issuingState" class="form-control" required data-msg-required="Drivers License Issuing State is required.">
						<option value="">State</option>
					</select>
				</div>
				<br>
				<br>
				<div class="form-group">
					<label for="annualIncome">ANNUAL Gross Income from ALL sources</label>
				</div>
				<br />
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon">$</span>
						<input type="text" class="form-control" name="annualIncome" maxlength="10" required data-msg-required="ANNUAL Gross Income from ALL sources is required.">
						<span class="input-group-addon">.00</span>
					</div>
				</div>
				<br />
				<div class="circle">?</div>
				<div class="what-this">What's this?</div>
				<br />
				<div class="row">
					<div class="col-xs-4">
						<div class="form-group">
							<label>Residence Status</label><br />
							<label class="radio-inline">
								<input type="radio" name="residenceStatus" value="own" class="residenceStatus" />
								<label>Own</label>
							</label>
							<label class="radio-inline">
								<input type="radio" name="residenceStatus" value="rent_other" checked class="residenceStatus" />
								<label>Rent/Other</label>
							</label>
						</div>
					</div>
					<div class="col-xs-8">
						<div class="form-group" id="monthlyPaymentBloc">
							<label for="monthlyPayment">Please indicate your MONTHLY payment</label>
							<br /> 
							<div class="input-group">
								<span class="input-group-addon">$</span>
								<input type="text" class="form-control" name="monthlyPayment" maxlength="10" required data-msg-required="MONTHLY payment is required.">
								<span class="input-group-addon">.00</span>
							</div>
						</div>
					</div>
				</div>
				<br />
				<br />
				<button type="button" class="btn btn-primary btn-sm" onclick="continueToThirdStep()">Continue to Step 2</button>
			</div>
			<!-- Tab2 -- financial info end-->
			<!-- Tab3 -- consent to terms start-->
			<div id="consent-terms" class="tab-content-section tab-pane-hidden">
				<h4>Consent to Terms and Submit Your Application</h4>
				<p>
				Please carefully review the information below which includes rates, fees, rewards, and other important information before submitting your application.
				</p>
				<div id="apply-info-web-content">
					<%@include file="credit-card-agreement.jsp"%>
				</div>
				<div style="float:right; margin:10px;">
					<i class="icon-print link-color"></i>&nbsp;<strong><em class="link-color">Print Agreement</em></strong>
				</div>
				<br/>
				<div class="checkbox">
					<label style="display:block;"> 
					<input type="checkbox" name="terms" required data-msg-required="Please consent to the terms and conditions.">
						I have read and agree to the terms, conditions, authorizations,
						disclosures,<em class="link-color">Credit Card Agreement</em>,and <em class="link-color">Privacy Notice</em class="link-color"> associated with this credit application.
					</label>
				</div>
				<div class="checkbox">
					<label style="display:inline-block;"> <input type="checkbox" name="consent" required data-msg-required="Please consent the Electronic Communications.">
						I have read the <em class="link-color">Consent to Electronic Communications</em> and by
						submitting this application I am consenting to receiving the Credit Card Agreement and Privacy Notice electronically.
					</label>
				</div>
				<br />
				<br />
				<button type="button" class="btn btn-primary btn-lg" onclick="submitApplication('${accResourceURL}')" style="margin-right:40px;">Submit Application</button><strong><em class="link-color">Cancel</em></strong>
			</div>
			<!-- Tab3 -- consent to terms start-->
		</form>
		<br />
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" data-backdrop="static" data-keyboard="true" tabindex="-1" role="modal"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<h1>Thank you for your application.</h1>
				<p>You will know shortly if you have been approved.</p>
				<div class="processing-img"><img src="<%=request.getContextPath()%>/images/processing_indicator.gif"/></div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->