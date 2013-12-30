<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:renderURL var="searchApplicationUrl">
	<portlet:param name="sacwisApplication" value="saveForm" />
</portlet:renderURL>

<div class="bootstrap3">
	<form:form name="SacwisForm" class="form-inline" role="form" commandName="sacwisForm" method="post" action="${searchApplicationUrl}">

		<div class="form-group">
		<table>
		<tr>
			<td>
				<label for="sacwisId">Sacwis ID</label>
				<c:out value="${SACWIS_SEARCH_RESULT.sacwisId}"></c:out>
			</td>
			<td>
				&nbsp;
			</td>
			<td>
				<label for="requestedDate">Date:</label> 
				<c:out value="${SACWIS_SEARCH_RESULT.requestedDate}"></c:out>
			</td>
		</tr>
		<tr>
			<td>
				<label for="requestingCaseWorker">Caseworker Requesting:</label>
				<c:out value="${SACWIS_SEARCH_RESULT.requestingCaseWorker}"></c:out>
			</td>
			
			<td>
				<label for="caseworker">Caseworker:</label> 
				<c:out value="${SACWIS_SEARCH_RESULT.caseWorker}"></c:out>
			</td>
			<td>
				<label for="workerPhoneNumber">Worker Phone:</label> 
				<c:out value="${SACWIS_SEARCH_RESULT.workerPhoneNumber}"></c:out>
			</td>
		</tr>
		</table>
		</div>

		<div class="form-group">
		<table>
		  <tr>
		  <% int rowCount=0; %>
		    
		     <c:forEach var="requestType" items="${SACWIS_SEARCH_RESULT.requestTypes}">
		     <c:choose>
		        <c:when test="${rowCount ne 4}">
		        <td>
		       		 <form:checkbox path="requestTypes" value="requestType.requestTypeCheckBox" />
		        	 <c:out value="${requestType.requestType}"></c:out>
		        </td>
		        </c:when>
		       <c:otherwise>
		       </tr><tr>
		       <td>
		       		 <form:checkbox path="requestTypes" value="requestType.requestTypeCheckBox" />
		        	 <c:out value="${requestType.requestType}"></c:out>
		        </td>
		       </c:otherwise> 
		     </c:choose>
		     <% rowCount++; %>
		     </c:forEach>
		     
		  </tr>
		  <tr>
		  	<td>
		  		Requesting for *: (select atleast one option)
		  	</td>
		  </tr>		  
		   <c:forEach var="requestingForPeople" items="${SACWIS_SEARCH_RESULT.requestingForPeople}">
			  <tr>
				  <td>
				   	<form:checkbox path="requestingForPeople" value="requestingForPeople.requestingPersonCheckbox" />
				  </td>
				  <td>
				   	<form:checkbox path="requestingForPeople" value="requestingForPeople.personFullName" />
				  </td>
				  <td>
				   	Client/Sacwis ID:<form:checkbox path="requestingForPeople" value="requestingForPeople.sacwisId" />
				  </td>
				  <td>
				   	DOB: <form:checkbox path="requestingForPeople" value="requestingForPeople.dob" />
				  </td>
				  <td>
				   	Type:  <form:checkbox path="requestingForPeople" value="requestingForPeople.type" />
				  </td>
			  </tr>
		  </c:forEach>
		  
		
		</table>
		</div>
		
		<div class="form-group">
		<table>
		  <tr>
		  	<td>
		    	<label for="personRespForPurchase"><b>Person(s) responsible for making purchase*:</b></label> 
		    </td>
		    <td colspan="3">	
				<form:input path="${SACWIS_SEARCH_RESULT.personRespForPurchase}" />
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="requestPurpose"><b>Purpose of Request*:</b></label> 
		    </td>
		    <td colspan="3">	
				<form:textarea  path="${SACWIS_SEARCH_RESULT.requestPurpose}" rows = "5" cols="30"/>
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="otherCommResContacted">Other Community Resources Contacted:</label> 
		    </td>
		    <td colspan="3">	
				<form:input path="${SACWIS_SEARCH_RESULT.otherCommResContacted}" />
			</td>
		  </tr>
		  <tr>		
		    <td>
		    	<label for="totalAmtRequested"><b>Total Amount Requested:</b></label> 
		    </td>
		    <td>	
				<form:input path="${SACWIS_SEARCH_RESULT.totalAmtRequested}" />
			</td>
			<td>
		    	<label for="dateRequired"><b>Date Required*:</b></label> 
		    </td>
		    <td>	
				<form:input path="${SACWIS_SEARCH_RESULT.dateRequired}" />
			</td>
		  </tr>
		  
	      <tr>		
		    <td>
		    	<label for="fundMode"><b>Fund type:</b></label> 
		    </td>
		    <td>	
				<form:select path="${SACWIS_SEARCH_RESULT.fundMode}">
					<form:option value="VOUCHER">Voucher</form:option>
					<form:option value="CHECK">Check</form:option>
				</form:select>
			</td>
			<td>
		    	<label for="fundDeliveryType"><b>Fund Pickup:</b></label> 
		    </td>
		    <td>	
				<form:select path="${SACWIS_SEARCH_RESULT.fundDeliveryType}">
					<form:option value="PICKUP">To be picked up</form:option>
					<form:option value="FUNDSREADY">Call when funds are ready</form:option>
					<form:option value="FURNITURE">(For furniture/appliances)</form:option>
				</form:select>
			</td>
		  </tr>
		  <tr>
		  	  <td>
		  	  	<label for="paymentMadeFor"><b>Made Payable To:*</b></label>
		  	  </td>
		  	  <td>
		  	  	<form:textarea  path="${SACWIS_SEARCH_RESULT.paymentMadeFor}" rows = "5" cols="30"/>
		  	  </td>
		  	  <td>
		  	  	<label for="furnitureDeliveryAddress">Furniture/Appliances Delivery to</label>
		  	  </td>
		  	  <td>
		  	  	<form:textarea  path="${SACWIS_SEARCH_RESULT.furnitureDeliveryAddress}" rows = "5" cols="30"/>
		  	  </td>
		  </tr>
		  <tr>
		  	  <td rowspan="2" colspan="2">
		  	  	<label for="otherInstructions">Other Instructions:</label>
		  	  
		  	  	<form:textarea  path="${SACWIS_SEARCH_RESULT.otherInstructions}"  rows = "5" cols="30"/>
		  	  </td>
		  	  
		  	  <td>
		  	  	<label for="budgetCenter">Charge to budget Center#</label>
		  	  </td>
		  	  <td>
		  	  	<form:input path="${SACWIS_SEARCH_RESULT.budgetCenter}"/>
		  	  </td>
		  </tr>
		  <tr>
		  	  <td>
		  	  	<label for="lineItem">Line Item#</label>
		  	  </td>
		  	  <td>
		  	  	<form:input path="${SACWIS_SEARCH_RESULT.lineItem}"/>
		  	  </td>
		  </tr>
		  
		  
		
		</table>
		</div>
		
		<div class="form-group">
		<table>
		<tr>
			<td>
				<button type="submit" class="btn btn-primary">Submit the request for approval</button>
			</td>
		</tr>
		
		</table>
		</div>
		
		
		
	</form:form>
</div>

