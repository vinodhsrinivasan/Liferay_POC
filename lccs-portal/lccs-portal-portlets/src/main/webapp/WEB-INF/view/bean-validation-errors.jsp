<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="server-bean-validation-errors-content">
	<ul>
		<c:forEach var="constraint" items="${constraints}">
			<li><label class="error"><spring:message code="${constraint.messageTemplate}" /></label></li>
		</c:forEach>
	</ul>
</div>