<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:resourceURL var="accResourceURL" id="registerUserCard" ></portlet:resourceURL>
<div id="card-user-registration-page-content">
	<div id="registerUserCardForm-validation-errors"><!-- form validation errors div --></div>
	<!-- Tab Navigator -->
	<div id="registration-personal-info-tab" class="col-xs-4 active-tab">
		<div id="registration-personal-info-tab-top" class="top-active-tab tab-label">
			<strong>Step 1: Your Information</strong>
		</div>
	</div>
	<div id="registration-consent-terms-tab" class="col-xs-4 inactive-tab">
		<div id="registration-consent-terms-tab-top" class="top-inactive-tab tab-label">
			<strong>Step 2: Consent</strong>
		</div>
	</div>
	
	<div class="tab-content-container">
		<span class="glyphicon glyphicon-lock lock-img-style"></span> <span
			class="secure-app-label">This process is secure.</span>
		<form action="#" class="form-inline" role="form" id="registerUserCardForm">
	
			<!-- Tab1 -- Personal info start-->
			<div id="registration-personal-info" class="tab-content-section">
				<h4>Please enter your information to register your card and create an account.</h4>
				<h6></h6>
				<!-- fields -->
				<!-- Credit card number -->
				<div class="form-group">
					<label for="ccn1">Credit Card Number</label><br/>
					<input name="ccn1" class="form-control width-auto creditCardAlign" required size="3" maxlength="3"/>
					<input name="ccn2" class="form-control width-auto creditCardAlign" required size="3" maxlength="3"/>
					<input name="ccn3" class="form-control width-auto creditCardAlign" required size="3" maxlength="3"/>
				</div>
				<br/>
				<br/>
				<!-- Social Security Number  -->
				<div class="form-group">
					<label>Social Security Number</label>
				</div>
				<br />
				<div class="form-group">
					<input type="text" name="ssn1" class="form-control width-auto" size="3" maxlength="3" required data-msg-required="Social Security Number first field is required." />
					<input type="text" name="ssn2" class="form-control width-auto" size="2" maxlength="2" required data-msg-required="Social Security Number second field is required."  />
					<input type="text" name="ssn3" class="form-control width-auto" size="4" maxlength="4" required data-msg-required="Social Security Number third fieldis required."  />
				</div>
				<br>
				<br>

				<!-- User name -->
				<div class="form-group">
					<label for="userName">User Name</label> <input
						type="text" name="userName" class="form-control" required/>
				</div>
				<br />
				<br />

				<!-- Password -->
				<div class="form-group">
					<label for="password">Password</label>
					<input type="text" id="password" name="password" class="form-control" size="20" maxlength="20" required/>
				</div>
				<br />
				<br />

				<!-- Password reenter -->
				<div class="form-group">
					<label for="confirmPassword">Re-enter Password</label> 
					<input type="text" id="confirmPassword" name="confirmPassword" hidden class="form-control"  size="20" maxlength="20" required/>
				</div>
				<br />
				<br />

				<!-- Email address -->
				<div class="form-group">
					<label for="emailAddress">Email Address</label> 					
					<input type="text" id="emailAddress" name="emailAddress" class="form-control" maxlength="30" required data-msg-required="Email Address is required." data-rule-email="true" data-msg-email="Please enter a valid email address"/>
				</div>
				&nbsp;
				<!-- Confirm Email Address -->
				<div class="form-group">
					<label for="confirmEmailAddress">Confirm Email Address</label> 
					<input type="text" id="confirmEmailAddress" name="confirmEmailAddress" class="form-control" maxlength="30" required data-msg-required="Confirm Email Address is required."/>
				</div>
				<br/>
				<br/>
				<!-- Security question -->
				<div class="form-group">
					<label for="securityQuestion">Security Question</label>
					<select id="securityQuestion" name="securityQuestion" class="form-control"  required  data-msg-required="Security Question is required.">
						<option value="Name of my secondary school">Name of my secondary school</option>
						<option value="Name of my Pet">Name of my Pet</option>
					</select>
				</div>				
				<br />
				<br />
				<!-- Security Answer-->
				<div class="form-group">
					<label for="securityAnswer">Security Answer</label> <input
						type="text" name="securityAnswer" class="form-control"  size="30" required />
				</div>
				<br />
				<br />
				<button type="button" class="btn btn-primary btn-lg"
					onclick="continueToRegistrationSecondStep()">Continue to Step 2</button>
			</div>
			<!-- Tab1 -- Personal info end -->
			<!-- Tab2 -- consent to terms start-->
			<div id="registration-consent-terms" class="tab-content-section tab-pane-hidden">
				<h4>Consent to Terms and Submit Your Application</h4>
				<p>Content from liferay</p><br />
				<div class="form-group">
					<label class="radio-inline">
						<input type="radio"	name="consent" value="Yes" /><label>Yes</label>
					</label> 
					<label class="radio-inline">
						<input type="radio"	name="consent" value="No" checked /><label>No</label>
					</label>
				</div>	
<!-- 				
				<div class="checkbox">
					<label> <input type="radio"	name="consent" value="Yes" /> I have
						read and agree to the terms, conditions, authorizations,
						disclosures,<em>Credit Card Agreement</em>,and <em>Privacy
							Notice</em> associated with this credit application.
					</label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" name="consent"> I have
						read the <em>Consent to Electronic Communications</em> and by
						submitting this application I am consenting to receiving the Credit
						Card Agreement and Privacy Notice electronically.
					</label>
				</div>
 -->				
				<br />
				<br />
				<button type="button" class="btn btn-primary btn-lg"
					onclick="submitRegistration('${accResourceURL}')">Submit Application</button>
			</div>
			<!-- Tab2 -- consent to terms end-->
		</form>
		<br />
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="registrationModal" data-backdrop="static" data-keyboard="true" tabindex="-1" role="modal"
	aria-labelledby="registrationModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<h1>Thank you for your registration.</h1>
				<p>You will know shortly if you have been approved.</p>
				<div class="processing-img"><img src="<%=request.getContextPath()%>/images/processing_indicator.gif"/></div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script type="text/javascript">
$(document).ready(function() {
	detachRegistrationTabs();

	//added rules to form
	$("#registerUserCardForm")
				.validate(
						{
							errorContainer: $('#form-validation-errors'),
							errorLabelContainer: $('ul', '#form-validation-errors'),
							wrapper: 'li',
							rules : {
								confirmPassword : {
									equalTo : "#password"
								},
								confirmEmailAddress : {
									equalTo : "#emailAddress"
								},
								ccn1: {
									minlength:3,
									maxlength:3,
									digits:true	
								},
								ccn2: {
									minlength:3,
									maxlength:3,
									digits:true	
								},
								ccn3: {
									minlength:3,
									maxlength:3,
									digits:true	
								}
								,
								ssn1: {
									minlength:3,
									maxlength:3
								},
								ssn2: {
									minlength:2,
									maxlength:2
								},
								ssn3: {
									minlength:4,
									maxlength:4
								},
								securityQuestion:{
								},
								securityAnswer:{
								}
							},
							messages : {
								confirmPassword : "Please check Re-enter Password.",
								confirmEmailAddress : "Please check Confirm Email Address.",
 								ccn1 :{
									minlength: "Credit Card Number first field must be 3 digits",
									maxlength: "Credit Card Number first field must be 3 digits",
									digits:"Credit Card Number must first field be 3 digits"
								},
								ccn2 :{
									minlength: "Credit Card Number second field must be 3 digits",
									maxlength: "Credit Card Number second field must be 3 digits",
									digits:"Credit Card Number second field must be 3 digits"
								},
								ccn3 :{
									minlength: "Credit Card Number third field must be 3 digits",
									maxlength: "Credit Card Number third field must be 3 digits",
									digits:"Credit Card Number third field must be 3 digits"
								},
								ssn1 :{
									minlength: "Social Security Number first field must be 3 characters",
									maxlength: "Social Security Number first field must be 3 characters"
								},
								ssn2 :{
									minlength: "Social Security Number second field must be 2 characters",
									maxlength: "Social Security Numbersecond field  must be 2 characters"
								},
								ssn3 :{
									minlength: "Social Security Number third field must be 4 characters",
									maxlength: "Social Security Number third field must be 4 characters"
								},
								securityQuestion:{
								},
								securityAnswer:{
								}
							}
						});
});
</script>
