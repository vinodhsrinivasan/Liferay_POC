<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style type="text/css">
        body {
            background-color: #ebebeb;
            color: #1c5a83;
            font-family: Verdana, Arial, sans-serif;
        }
        
        /*section {
            font-size: 0.85em;
        }*/
        
        fieldset {
        	font-family: Verdana, Arial,  sans-serif;
			font-size: small;
			font-weight: normal;
			border: 1px solid #999999;
			padding: 4px;
			margin: 5px;            
        }
        
        legend {
			/* Default style of Legend of Fieldset.  Acts as a catch-all style if programmer "forgets" to attach style to element. */
			font-size: 50%;
			color: #888888;
			background-color: transparent;
			font-weight: normal;
			}
        
        a {
            color: #dc7b0b;
        }
        
        .labelCol, .fieldCol {
            float: left;
            padding: 3px 5px;
        }
        
        .row {
            float: left;
            clear: both;
            line-height: 3em;
        }
        
        select, input[type="text"] {
            border: 2px solid #1c5a83;
            font-size: 0.85em;
            border-radius: 5px;
            margin: 0 auto;
            padding: 3px 5px;
            line-height: 1.5em;
        }
        
        /* Astertik for required fields */
        .required:after {
          content:" *";
          color: red;
        }
        
        /* Dropdown box style */
        .select-wrapper{
            float: left;
            display: inline-block;
            border: 2px solid #1c5a83;
            border-radius:5px;
            background: url("dropdownImg.png") no-repeat right 0 transparent;
            cursor: pointer;
            padding-left:8px;
            font-size: 0.85em;
            margin-top:8px;
	}
	.select-wrapper, .select-wrapper select{
            width: 200px;
            height: 26px;
            line-height: 2em;
	}
	
        .select-wrapper select{
            margin: 0;
            position: absolute;
            z-index: 2;            
            cursor: pointer;
            outline: none;
            opacity: 0;
            /* CSS hacks for older browsers */
            _noFocusLine: expression(this.hideFocus=true); 
            -ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
            filter: alpha(opacity=0);
            -khtml-opacity: 0;
            -moz-opacity: 0;
	}
        
        
        /*radio box style */
        input[type=radio].css-checkbox {
            display:none;
        }

	input[type=radio].css-checkbox + label.css-label {
            padding-left:25px;
            height:20px; 
            display:inline-block;
            line-height:20px;
            background-repeat:no-repeat;
            background-position: 0 0;
            vertical-align:middle;
            cursor:pointer;
        }

	input[type=radio].css-checkbox:checked + label.css-label {
            background-position: 0 -20px;
        }
						
        label.css-label {
            background-image:url(radioBoxSprite.png);
            -webkit-touch-callout: none;
            -webkit-user-select: none;
            -khtml-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        
        
        /*checkbox style */
        input[type=checkbox].css-checkbox1 {
            display:none;
        }

	input[type=checkbox].css-checkbox1 + label.css-label1 {
            padding-left:23px;
            height:18px; 
            display:inline-block;
            line-height:18px;
            background-repeat:no-repeat;
            background-position: 0 0;
            vertical-align:middle;
            cursor:pointer;
        }

	input[type=checkbox].css-checkbox1:checked + label.css-label1 {
            background-position: 0 -18px;
        }
						
        label.css-label1 {
            background-image:url(checkboxSprite.png);
            -webkit-touch-callout: none;
            -webkit-user-select: none;
            -khtml-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        
        
        /* action button style */
        .activeBtn, button {
            border: none !important;
            border-radius: 5px;
            padding: 0 9px;
            margin:0;
            line-height: 2em;
            color: #ffffff;
            background: #8bcfff; /* Old browsers */
            background: -moz-linear-gradient(top, #8bcfff 0%, #285777 100%); /* FF3.6+ */
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#8bcfff), color-stop(100%,#285777)); /* Chrome,Safari4+ */
            background: -webkit-linear-gradient(top, #8bcfff 0%,#285777 100%); /* Chrome10+,Safari5.1+ */
            background: -o-linear-gradient(top, #8bcfff 0%,#285777 100%); /* Opera 11.10+ */
            background: -ms-linear-gradient(top, #8bcfff 0%,#285777 100%); /* IE10+ */
            background: linear-gradient(to bottom, #8bcfff 0%,#285777 100%); /* W3C */
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#8bcfff', endColorstr='#285777',GradientType=0 ); /* IE6-8 */
        }
        
        .activeBtn:hover, button:hover {
            cursor: pointer;
            background: #397aa8; /* Old browsers */
            background: -moz-linear-gradient(top, #397aa8 0%, #0d283d 100%); /* FF3.6+ */
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#397aa8), color-stop(100%,#0d283d)); /* Chrome,Safari4+ */
            background: -webkit-linear-gradient(top, #397aa8 0%,#0d283d 100%); /* Chrome10+,Safari5.1+ */
            background: -o-linear-gradient(top, #397aa8 0%,#0d283d 100%); /* Opera 11.10+ */
            background: -ms-linear-gradient(top, #397aa8 0%,#0d283d 100%); /* IE10+ */
            background: linear-gradient(to bottom, #397aa8 0%,#0d283d 100%); /* W3C */
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#397aa8', endColorstr='#0d283d',GradientType=0 ); /* IE6-8 */
        }
        
        .inactiveBtn {
            background-color: #c8c8c8;
            border: none !important;
            border-radius: 5px;
            padding: 0 9px;
            margin:0;
            line-height: 2em;
            color: #ffffff;
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
    </style>

<portlet:resourceURL var="fundRequestSubmitURL" id="fundRequestSubmitURL" ></portlet:resourceURL>

<div class="tab-content-container form-group" id="lccs-request-for-funds-case-worker">

<fieldset>
     <legend>Caseworker Details</legend>		
		<table>
			<tr>
				<td>
					<label for="sacwisId">Sacwis ID</label>
					<c:out value="${caseWorkerDetailsDTO.sacwisId}"></c:out>
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					<label for="requestDate">Date:</label> 
				 	<c:out value="${requestedDate}"></c:out>
				</td>
			</tr>
			<tr>
				<td>
					<label for="requestingCaseWorker">Caseworker Requesting:</label>
					<c:out value="${caseWorkerDetailsDTO.requestingCaseWorker}"></c:out>
				</td>
				
				<td>
					<label for="caseworker">Caseworker:</label> 
					<c:out value="${caseWorkerDetailsDTO.caseWorker}"></c:out>
				</td>
				<td>
					<label for="workerPhoneNumber">Worker Phone:</label> 
					<c:out value="${caseWorkerDetailsDTO.workerPhoneNumber}"></c:out>
					
				</td>
			</tr>
		</table>
</fieldset>
		</div>	<!-- End: lccs-request-for-funds-case-worker -->
<br/> <!-- Seperator -->


	
	<form name="requestFundsCaseDetailsForm" id="requestFundsCaseDetailsForm" class="form-inline" role="form" commandName="sacwisForm" method="post" action="#">
<div id="lccs-request-for-funds-form-content" class="tab-content-container"> 			
<fieldset>
    <legend>Check Person for which this request is being made</legend>		
		<table>
			<tr>
				<td colspan="4">
					<label> Type of Request*: (select atleast one option) </label>
				</td>
			</tr>	
			
			<tr>
				<td>
					<input type="checkbox"  name="${caseWorkerDetailsDTO.requestType}"  value = "Donation" id="Donation" />
					Donation
				</td>
				<td>
					<input type="checkbox" value="${caseWorkerDetailsDTO.prePlacement}" id="prePlacement" />
					Preplacement Prevention
				</td>
				<td>
					<input type="checkbox" name="${caseWorkerDetailsDTO.requestType}"  value = "afterCareIndependence" id="afterCareIndependence" />
					Aftercare Independence
				</td>
				<td>
					<input type="checkbox" value="${caseWorkerDetailsDTO.kinshipCare}" id="kinshipCare" />
					Kinship Care
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" value="${caseWorkerDetailsDTO.operating}" id="operating" />
					Operating
				</td>
				<td>
					<input type="checkbox" value="${caseWorkerDetailsDTO.familyReunification}" id="familyReunification" />
					Family Reunification
				</td>
				<td>
					<input type="checkbox"  value="${caseWorkerDetailsDTO.alternativeResponse}" id="alternativeResponse" />
					Alternative Response
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan="4">
					<label> Requesting for*: (select atleast one option) </label>
				</td>
			</tr>	
			<c:forEach var="caseParticipant" items="${caseWorkerDetailsDTO.requestingForPeople}">
			<c:if test="${not empty caseParticipant.custody || not empty caseParticipant.custody || not empty caseParticipant.custody || not empty caseParticipant.custody}">
				<tr>
					
					<td>
						Custody With:&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.custody}"></c:out>
					</td>
					<td>
						Child Placement: &nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.placement}"></c:out>
					</td>
					<td>
						Custody Date&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.custodyDate}"></c:out>
					</td>
					<td>
						IV-E Reimbursable&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.iveReimbursable}"></c:out>
					</td>
				</tr>
			</c:if>
				<tr>
					<td>
						<input type="checkbox"  name="${caseParticipant.requestingPersonCheckbox}"  value = "requestingPersonCheckbox" id="Donation" />
						<c:out value="${caseParticipant.personFullName}"></c:out>
					</td>
					<td>
						Client/Sacwis ID: &nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.sacwisId}"></c:out>
					</td>
					<td>
						DOB&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.dob}"></c:out>
					</td>
					<td>Type&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${caseParticipant.type}"></c:out>
					</td>
				</tr>
		</c:forEach>
		</table>
		</fieldset>
		</div>
		<div class="spacerDiv"><img src="images/1x1.gif" alt=""></div>
		<div class="spacerDiv"><img src="images/1x1.gif" alt=""></div>
		<div id="lccs-request-for-funds-form-content" class="tab-content-container">
		<div class="form-group">
		<fieldset>
        <legend>Information filled in by Caseworker for approval</legend>		
		<table>
		  <tr>
		  	<td>
		    	<label for="personRespForPurchase"><b>Person(s) responsible for making purchase*:</b></label> 
		    </td>
		    <td colspan="3">	
				<input type="text" value="${caseWorkerDetailsDTO.personRespForPurchase}" name="${caseWorkerDetailsDTO.personRespForPurchase}" required data-msg-required=">Person(s) responsible for making purchase is required."/>
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="requestPurpose"><b>Purpose of Request*:</b></label> 
		    </td>
		    <td colspan="3">	
		    	<textarea rows = "5" cols="30"  name="${caseWorkerDetailsDTO.requestPurpose}" required data-msg-required="Purpose of Request is required.">
		    		${caseWorkerDetailsDTO.requestPurpose}
		    	</textarea>
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="otherCommResContacted">Other Community Resources Contacted:</label> 
		    </td>
		    <td colspan="3">	
				<input value="${caseWorkerDetailsDTO.otherCommResContacted}" />
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="totalAmtRequested"><b>Total Amount Requested:</b></label> 
		    </td>
		    <td>	
				<input value="${caseWorkerDetailsDTO.totalAmtRequested}" />
			</td>
			<td>
		    	<label for="dateRequired"><b>Date Required*:</b></label> 
		    </td>
		    <td>	
				<input value="${caseWorkerDetailsDTO.dateRequired}" required data-msg-required="Date Required is required." />
			</td>
		  </tr>
		  <tr>
			  <td>
			 	<label for="fundMode">Fund Mode: </label>
				<select id="fundMode"  name="caseWorkerDetailsDTO.fundMode" class="form-control"  required  data-msg-required="Select the Fund Mode.">
					<option value="">-- Please Select --</option>
					<option value="Voucher">Voucher</option>
					<option value="check">Check</option>
				</select>
			  </td>
		   	  <td>
			 	&nbsp;
			  </td>
			  <td>
			 	<label for="fundDeliveryType">Fund Delivery Type: </label>
				<select id="fundDeliveryType" name="fundDeliveryType" class="form-control"  required  data-msg-required="Select the Fund Delivery Type.">
					<option value="">-- Please Select --</option>
					<option value="toBePickedUp">To be picked up</option>
					<option value="callUponFundsAvail">Call when funds are</option>
					<option value="furniture">For Furniture/Applicances</option>
				</select>
			  </td>
			   <td>
			 	&nbsp;
			  </td>
		  </tr>
		  <tr>
		  	  <td>
		  	  	<label for="paymentMadeFor"><b>Made Payable To:*</b></label>
		  	  </td>
		  	  <td>
		  	  	<textarea  name="${caseWorkerDetailsDTO.paymentMadeFor}" rows = "5" cols="30" required data-msg-required="Made Payable To is required.">${caseWorkerDetailsDTO.paymentMadeFor}</textarea>
		  	  </td>
		  	  <td>
		  	  	<label for="furnitureDeliveryAddress">Furniture/Appliances Delivery to</label>
		  	  </td>
		  	  <td>
			  	  <c:if test="${caseWorkerDetailsDTO.fundDeliveryType eq 'furniture'}">
			  	  	<textarea  name="furnitureDeliveryAddress" rows = "5" cols="30">
			  	  		${caseWorkerDetailsDTO.furnitureDeliveryAddress}
			  	  	</textarea>
			  	  </c:if>	
		  	  </td>
		  </tr>
		  <tr>
		  	  <td rowspan="2">
		  	  	<label for="otherInstructions">Other Instructions:</label>
		  	  </td>
		  	  <td rowspan="2">
		  	  	<textarea  name="${caseWorkerDetailsDTO.otherInstructions}"  rows = "5" cols="30">${caseWorkerDetailsDTO.otherInstructions}</textarea>
		  	  </td>
		  	  
		  	  <td>
		  	  	<label for="budgetCenter">Charge to budget Center#</label>
		  	  </td>
		  	  <td>
		  	  	<input value="${caseWorkerDetailsDTO.budgetCenter}"/>
		  	  </td>
		  </tr>
		  <tr>
		  	  <td>
		  	  	<label for="lineItem">Line Item#</label>
		  	  </td>
		  	  <td>
		  	  	<input value="${caseWorkerDetailsDTO.lineItem}"/>
		  	  </td>
		  </tr>
		</table>
		</fieldset>
		</div>
		</div>
		
		<div class="form-group">
		<table>
		<tr>
			<td>
				<button type="submit" class="btn btn-primary" onclick="requestFundsCaseDetailsObj.click('${fundRequestSubmitURL}')">Submit the request for approval</button>
			</td>
		</tr>
		
		</table>
		</div>
		
	</form>


