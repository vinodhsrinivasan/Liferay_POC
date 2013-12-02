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
			<label for="sacwisId">Sacwis ID</label> 
			<form:input path="sacwisId" class="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="sacwisName">Sacwis Name</label> 
			<form:input path="sacwisName" class="form-control"/>
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		
	</form:form>
</div>

