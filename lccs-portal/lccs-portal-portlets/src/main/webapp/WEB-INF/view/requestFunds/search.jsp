<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>

<portlet:resourceURL var="searchCaseBasedOnSacwisNumber" id="searchCaseBasedOnSacwisNumber" ></portlet:resourceURL>

<div class="bootstrap3" id="lccs-request-for-funds-body">
	<h2 class="lccs-request-for-funds">Request For Funds</h2>
	<div id="server-form-validation-errors"><!-- server form validation errors div --></div>
	<div id="form-validation-errors"><ul><!-- errors --></ul></div>
	
	<div id="lccs-request-for-funds-main-content">
	
		<div class="tab-content-container form-group" id="lccs-request-for-funds-case-worker">
			<table>
			<tr>
				<td>
					<label for="caseWorkerName">Caseworker Requesting:</label> 
					<c:out value="${requestingCaseWorker}"></c:out>
				</td>
				<td>
					<label for="caseWorkerPhone">Worker Phone:</label> 
					<c:out value="${workerPhoneNumber}"></c:out>
				</td>
				<td>
					<label for="requestDate">Date:</label> 
				 	<c:out value="${requestedDate}"></c:out>
				</td>
			</tr>
			</table>
		</div>	<!-- End: lccs-request-for-funds-case-worker -->
		<br/> <!-- Seperator -->
		
		<div id="lccs-request-for-funds-form-content" class="tab-content-container">
			<form action="#" class="form-inline" role="form" id="requestFundsSearchForm" onsubmit="return false;">
		
				<div class="form-group">
				<table>
				<tr>
					<td>
					<label for="sacwisId">Sacwis ID</label> 
						<input type="number" id="sacwisId" name="sacwisId" class="form-control" required data-msg-required="Sacwis ID is required."/>
					</td>
					<td>
						<button type="submit" class="btn btn-primary" id="requestFundsSearchFormSubmit">Search</button>
					</td>
				</tr>
				
				</table>
				</div>
				
			</form>
		</div><!-- End:lccs-request-for-funds-form-content -->
	</div><!--lccs-request-for-funds-main-content -->
	
</div> <!--End: lccs-request-for-funds-body  -->
<div id="lccs-request-for-funds-search-result-content">
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
<script type="text/javascript">
$(function() {
	requestFundsSearchObj.init('${searchCaseBasedOnSacwisNumber}');
});
</script>
