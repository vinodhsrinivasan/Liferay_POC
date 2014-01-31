<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<style type="text/css">
 	.tab-content-container {
		margin: 0px;
		position: relative;
		background-color: #f4f4f4;
		border: 1px solid #1c5a83;
		clear: both;
		/*color: #1c5a83;*/
		font-family: Verdana, Arial, sans-serif;
		font-size: 0.85em;
		}
		.row {
			line-height: 3em;
		}
		.labelCol, .fieldCol {
			float: left;
			padding: 3px 5px;
			padding-left: 2%;
		}
		
		.required:after {
			content: " *";
			color: red;
		}
		
		label {
		cursor: default;
		}
		
		label.labelStyle{
			/* Style for all form labels used in the main content area, for non-required fields */
			font-size: 100%;
			font-weight: normal;
			color:  #336699;
			}
			
		div.spacerDiv{
		/* This spacer div is used in combination with a transparent 1x1.gif, for filling horizontal spaces. */
		/* Alternative to relative or absolute positioning of elements, but compatible with older browers that don't support positioning. */ 
		margin: 0px;
		padding: 0px;
		width: 1px;
		height: 5px;
		background-color: transparent;
		}	
		
		fieldset {
		/* Default "catch all" style definition if a programmer "forgets" to attach style to element. */
		font-family: Verdana, Arial,  sans-serif;
		font-size: small;
		font-weight: normal;
		border: 1px solid #999999;
		padding: 4px;
		margin: 5px;
		}

		fieldset.fsStyle {
		/* Style of Fieldset.  Define in the FIELDSET element. */
		font-family: Verdana, Arial,  sans-serif;
		font-size: small;
		font-weight: normal;
		border: 1px solid #999999;
		padding: 4px;
		margin: 5px;
		}
		
    </style>

<portlet:resourceURL var="fundRequestSubmitURL" id="fundRequestSubmitURL" ></portlet:resourceURL>

<div class="bootstrap3" id="lccs-request-for-funds-body">	
<div id="lccs-request-for-funds-main-content">
<fieldset class="fsStyle">
    <legend class="legendStyle">Caseworker Details</legend>		

		<div class="tab-content-container form-group" id="lccs-request-for-funds-case-worker">
			<div class="row">
				 <div class="labelCol">
					<label class="labelStyle" for="sacwisId">Sacwis ID:</label>
				 </div>
				 <div class="fieldCol">	
					<c:out value="${caseWorkerDetailsDTO.sacwisId}"></c:out>
				</div>
				<div class="labelCol">
					&nbsp;
				</div>
				<div class="labelCol">
					<label class="labelStyle" for="requestDate">Date:</label> 
				</div>
				<div class="fieldCol">	
				 	<c:out value="${requestedDate}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="labelCol">
					<label class="labelStyle" for="requestingCaseWorker">Caseworker Requesting:</label>
				</div>
				<div class="fieldCol">	
					<c:out value="${caseWorkerDetailsDTO.requestingCaseWorker}"></c:out>
				</div>
				
				<div class="labelCol">
					<label class="labelStyle" for="caseworker">Primary Worker:</label> 
				</div>
				<div class="fieldCol">		
					<c:out value="${caseWorkerDetailsDTO.caseWorker}"></c:out>
				</div>
				<div class="labelCol">
					<label class="labelStyle" for="workerPhoneNumber">Worker Phone:</label>
				</div>
				<div class="fieldCol">		 
					<c:out value="${caseWorkerDetailsDTO.workerPhoneNumber}"></c:out>
				</div>
			</div>
		</div>
	</fieldset>		<!-- End: lccs-request-for-funds-case-worker -->
<br/> <!-- Seperator -->


	
<form name="requestFundsCaseDetailsForm" id="requestFundsCaseDetailsForm" class="form-inline"  onsubmit="return false;" method="post" action="#">
 <fieldset class="fsStyle">
    <legend class="legendStyle">Check Person for which this request is being made</legend>		
		<div class="tab-content-container">
				<div class="row">
			 		<div class="labelCol">
						<label class="labelStyle"> Type of Request*: (select atleast one option) </label>
					</div>
				</div>
				<div class="row">
					 <div class="col-md-3">
						<input type="checkbox"  name="donation"  value = "Donation" id="Donation" />
						Donation
					 </div>
					<div class="col-md-3">
						<input type="checkbox"  name="prePlacement"  value = "PrePlacement" id="PrePlacement" />
						Preplacement Prevention
					</div>
					<div class="col-md-3">
					<input type="checkbox" name="${caseWorkerDetailsDTO.afterCareIndependence}"  value = "afterCareIndependence" id="afterCareIndependence" />
						Aftercare Independence
					</div>
					<div class="col-md-3">
					<input type="checkbox"  name="kinshipCare"  value = "kinshipCare" id="kinshipCare" />
						Kinship Care
					</div>
				</div>
				<div class="row">
					 <div class="col-md-3">
					 <input type="checkbox"  name="operating"  value = "operating" id="operating" />
						Operating
					 </div>
					<div class="col-md-3">
					<input type="checkbox"  name="familyReunification"  value = "familyReunification" id="familyReunification" />
						Family Reunification
					</div>
					<div class="col-md-3">
					<input type="checkbox"  name="alternativeResponse"  value = "alternativeResponse" id="alternativeResponse" />
						Alternative Response
					</div>
					<div class="col-md-3">
						&nbsp;
					</div>
				</div>
		
			<div class="row">
				<div class="labelCol">
					<label class="labelStyle"> Requesting for*: (select atleast one option) </label>
				</div>
			</div>	
			<c:forEach var="caseParticipant" items="${caseWorkerDetailsDTO.requestingForPeople}">
			<c:if test="${not empty caseParticipant.custody || not empty caseParticipant.custody || not empty caseParticipant.custody || not empty caseParticipant.custody}">
				<div class="row">
					
					<div class="fieldCol">
						Custody With:&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.custody}"></c:out>
					</div>
					<div class="fieldCol">
						Child Placement: &nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.placement}"></c:out>
					</div>
					<div class="fieldCol">
						Custody Date&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.custodyDate}"></c:out>
					</div>
					<div class="fieldCol">
						IV-E Reimbursable&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.iveReimbursable}"></c:out>
					</div>
				</div>
			</c:if>
				<div class="row">
					<div class="col-md-3">
						<input type="checkbox"  name="${caseParticipant.requestingPersonCheckbox}"  value = "requestingPersonCheckbox" id="Donation" />
						<c:out value="${caseParticipant.personFullName}"></c:out>
					</div>
					<div class="col-md-3">
						Sacwis ID: &nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.sacwisId}"></c:out>
					</div>
					<div class="col-md-3">
						DOB&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.dob}"></c:out>
					</div>	
					<div class="col-md-3">
					Type&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.type}"></c:out>
					</div>
				</div>
		</c:forEach>
		</div>
		</fieldset>
		<div class="spacerDiv"><img src="images/1x1.gif" alt=""></div>
		<div class="spacerDiv"><img src="images/1x1.gif" alt=""></div>
		
		 <fieldset class="fsStyle">
        <legend class="legendStyle">Information filled in by Caseworker for approval</legend>	
        <div class="tab-content-container">
       	 <div class="row">
			 <div class="col-md-3">
		    	<label class="labelStyle" for="personRespForPurchase"><b>Person(s) responsible for making purchase*:</b></label> 
		     </div>
			 <div class="col-md-9">	
			  <input type="text" id="personRespForPurchase" name="personRespForPurchase" class="form-control" required data-msg-required=">Person(s) responsible for making purchase is required."/>	
			</div>
		  </div>
		 <div class="row">		
		    <div class="col-md-3">
		    	<label class="labelStyle" for="requestPurpose"><b>Purpose of Request*:</b></label> 
		    </div>
		    <div class="col-md-9">	
		    	<textarea rows = "5" cols="30"  name="requestPurpose" required data-msg-required="Purpose of Request is required.">
		    		${caseWorkerDetailsDTO.requestPurpose}
		    	</textarea>
			</div>
		  </div>
		 <div class="row">		
		   <div class="col-md-3">
		    	<label class="labelStyle" for="otherCommResContacted">Other Community Resources Contacted:</label> 
		   </div>
		   <div class="col-md-9">	
		  	 <input type="text" id="otherCommResContacted" name="otherCommResContacted" class="form-control" />
		   </div>
		 </div>
		  <div class="row">		
		    <div class="col-md-3">
		    	<label class="labelStyle" for="totalAmtRequested"><b>Total Amount Requested:</b></label> 
		    </div>
		    <div class="col-md-3">	
				<input type="text" id="totalAmtRequested" name="totalAmtRequested" class="form-control" />
			</div>
			<div class="col-md-3">
		    	<label class="labelStyle" for="dateRequired"><b>Date Required*:</b></label> 
		    </div>
		    <div class="col-md-3">
				<input value="${caseWorkerDetailsDTO.dateRequired}" class="span2" data-date-format="mm/dd/yy" size="40" maxlength="10" required data-msg-required="Date Required is required." />
			</div>
		  </div>
		  <div class="row">
			  <div class="col-md-3">
			 	<label class="labelStyle" for="fundMode">Fund Mode: </label>
				<select id="fundMode"  name="fundMode" class="form-control"  required  data-msg-required="Select the Fund Mode.">
					<option value="">-- Please Select --</option>
					<option value="VOUCHER">Voucher</option>
					<option value="CHECK">Check</option>
				</select>
			  </div>
		   	  <div class="col-md-3">
			 	&nbsp;
			  </div>
			  <div class="col-md-3">
			 	<label class="labelStyle" for="fundDeliveryType">Fund Delivery Type: </label>
				<select id="fundDeliveryType" name="fundDeliveryType" class="form-control"  required  data-msg-required="Select the Fund Delivery Type.">
					<option value="">-- Please Select --</option>
					<option value="TOBEPICKEDUP">To be picked up</option>
					<option value="CALLUPONFUNDSAVAIL">Call when funds are</option>
					<option value="FURNITURE">For Furniture/Applicances</option>
				</select>
			  </div>
			   <div class="col-md-3">
			 	&nbsp;
			  </div>
		  </div>
		  <div class="row">
		  	  <div class="col-md-3">
		  	  	<label class="labelStyle" for="paymentMadeFor"><b>Made Payable To:*</b></label>
		  	  </div>
		  	  <div class="col-md-3">
		  	  	<textarea  name="paymentMadeFor" rows = "5" cols="30" required data-msg-required="Made Payable To is required.">${caseWorkerDetailsDTO.paymentMadeFor}</textarea>
		  	  </div>
		  	  <div class="col-md-3">
		  	  	<label class="labelStyle" for="furnitureDeliveryAddress">Furniture/Appliances Delivery to:</label>
		  	  </div>
		  	  <div class="col-md-3">
			  	  <c:if test="${caseWorkerDetailsDTO.fundDeliveryType eq 'furniture'}">
			  	  	<textarea  name="furnitureDeliveryAddress" rows = "5" cols="30">
			  	  		${caseWorkerDetailsDTO.furnitureDeliveryAddress}
			  	  	</textarea>
			  	  </c:if>	
		  	  </div>
		  </div>
		  <div class="row">
		  	  <div class="col-md-3">
		  	  	<label class="labelStyle" for="otherInstructions">Other Instructions:</label>
		  	  </div>
		  	 <div class="col-md-3">
		  	  	<textarea  name="otherInstructions"  rows = "5" cols="30">${caseWorkerDetailsDTO.otherInstructions}</textarea>
		  	  </div>
		  	 <div class="col-md-6"> 
		  	 	<div class="row">
				  	 <div class="col-md-6">
				  	  	<label class="labelStyle" for="budgetCenter">Charge to budget Center: #</label>
				  	  </div>
				  	  <div class="col-md-6">
				  	 	 <input type="text" id="budgetCenter" name="budgetCenter" class="form-control" />
				  	  </div>
			  	 </div> 
			  	 <div class="row">
				  	  <div class="col-md-6">
				  	  	<label class="labelStyle" for="lineItem">Line Item#</label>
				  	  </div>
				  	  <div class="col-md-6">
				  	   	<input type="text" id="lineItem" name="lineItem" class="form-control" />
				  	  </div>
			  	</div>
			  </div>	 
		 </div>
		
		  </div>
		</fieldset>
		
		<div class="spacerDiv"><img src="images/1x1.gif" alt=""></div>
		<div class="spacerDiv"><img src="images/1x1.gif" alt=""></div>
		<div class="form-group">
		<table>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary" id="fundRequestSubmitURL">Submit the request for approval</button>
				</td>
			</tr>
		</table>
		</div>
		
	</form>
</div>
</div>

<script type="text/javascript">
$(function() {
	requestFundsCaseDetailsObj.init('${fundRequestSubmitURL}');
});
</script>

