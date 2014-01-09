<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:resourceURL var="fundRequestSubmitURL" id="fundRequestSubmitURL" ></portlet:resourceURL>

<div class="tab-content-container form-group" id="lccs-request-for-funds-case-worker">
			<table>
			<tr>
				<td>
					<label for="SACWIS ID">SACWIS ID:</label> 
					<c:out value="${requestSACWISID}"></c:out>
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
					<label for="caseWorkerName">Caseworker Requesting:</label> 
					<c:out value="${requestingCaseWorker}"></c:out>
				</td>
				<td>
					<label for="caseWorker">Caseworker:</label> 
				 	<c:out value="${caseWorkerDetailsDTO.caseWorker}"></c:out>
				</td>
				<td>
					<label for="caseWorkerPhone">Worker Phone:</label> 
					<c:out value="${workerPhoneNumber}"></c:out>
				</td>
			</tr>
			</table>
		</div>	<!-- End: lccs-request-for-funds-case-worker -->
<br/> <!-- Seperator -->

<div class="lccs-request-for-funds-form-content" class="tab-content-container">
	
	<form name="requestFundsCaseDetailsForm" id="requestFundsCaseDetailsForm" class="form-inline" role="form" commandName="sacwisForm" method="post" action="#">

		<div class="form-group">
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
				<label for="requestedDate">Date:</label> 
				<c:out value="${caseWorkerDetailsDTO.requestedDate}"></c:out>
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
		</div>

		
		
		<div class="form-group">
		<table>
		  <tr>
		  	<td>
		    	<label for="personRespForPurchase"><b>Person(s) responsible for making purchase*:</b></label> 
		    </td>
		    <td colspan="3">	
				<input name="personRespForPurchase" required data-msg-required=">Person(s) responsible for making purchase is required."/>
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="requestPurpose"><b>Purpose of Request*:</b></label> 
		    </td>
		    <td colspan="3">	
		    	<textarea rows = "5" cols="30" name="requestPurpose" required data-msg-required="Purpose of Request is required."></textarea>
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="otherCommResContacted">Other Community Resources Contacted:</label> 
		    </td>
		    <td colspan="3">	
				<input name="${caseWorkerDetailsDTO.otherCommResContacted}" />
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="totalAmtRequested"><b>Total Amount Requested:</b></label> 
		    </td>
		    <td>	
				<input name="${caseWorkerDetailsDTO.totalAmtRequested}" />
			</td>
			<td>
		    	<label for="dateRequired"><b>Date Required*:</b></label> 
		    </td>
		    <td>	
				<input name="${caseWorkerDetailsDTO.dateRequired}" />
			</td>
		  </tr>
		  
	     
		  <tr>
		  	  <td>
		  	  	<label for="paymentMadeFor"><b>Made Payable To:*</b></label>
		  	  </td>
		  	  <td>
		  	  	<textarea  name="${caseWorkerDetailsDTO.paymentMadeFor}" rows = "5" cols="30"></textarea>
		  	  </td>
		  	  <td>
		  	  	<label for="furnitureDeliveryAddress">Furniture/Appliances Delivery to</label>
		  	  </td>
		  	  <td>
		  	  	<textarea  name="${caseWorkerDetailsDTO.furnitureDeliveryAddress}" rows = "5" cols="30"></textarea>
		  	  </td>
		  </tr>
		  <tr>
		  	  <td rowspan="2" colspan="2">
		  	  	<label for="otherInstructions">Other Instructions:</label>
		  	  
		  	  	<textarea  name="${caseWorkerDetailsDTO.otherInstructions}"  rows = "5" cols="30"></textarea>
		  	  </td>
		  	  
		  	  <td>
		  	  	<label for="budgetCenter">Charge to budget Center#</label>
		  	  </td>
		  	  <td>
		  	  	<input name="${caseWorkerDetailsDTO.budgetCenter}"/>
		  	  </td>
		  </tr>
		  <tr>
		  	  <td>
		  	  	<label for="lineItem">Line Item#</label>
		  	  </td>
		  	  <td>
		  	  	<input name="${caseWorkerDetailsDTO.lineItem}"/>
		  	  </td>
		  </tr>
		  
		  
		
		</table>
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
</div>

