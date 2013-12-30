<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:renderURL var="searchApplicationUrl">
	<portlet:param name="sacwisApplication" value="searchForm" />
</portlet:renderURL>

<div class="bootstrap3">
	<form:form name="SacwisForm" class="form-inline" role="form" commandName="sacwisForm" method="post" action="${searchApplicationUrl}">

		<div class="form-group">
		<table>
		<tr>
			<td>
				<label for="sacwisName">Caseworker Requesting:</label> 
				<c:out value="${requestingCaseWorker}"></c:out>
			</td>
			<td>
				<label for="sacwisName">Worker Phone:</label> 
				<c:out value="${workerPhoneNumber}"></c:out>
			</td>
			<td>
				<label for="sacwisName">Date:</label> 
			 	<c:out value="${requestedDate}"></c:out>
			</td>
		</tr>
		</table>
		</div>

		<div class="form-group">
		<table>
		<tr>
			<td>
			<label for="sacwisId">Sacwis ID</label> 
				<form:input path="sacwisId" class="form-control"/>
			</td>
			<td>
				<button type="submit" class="btn btn-primary">Submit</button>
			</td>
		</tr>
		
		</table>
		</div>
		
		
		
		
		
	</form:form>
</div>

