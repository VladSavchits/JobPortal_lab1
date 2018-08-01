<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Jobseeker Info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<div class="container">
	<center>
		<form action="controller" method="post">
		    <c:if test="${jobseeker != null}">
		        <input type="hidden" name="command" value="update_jobseeker"/>
		    </c:if>
		    <c:if test="${jobseeker == null}">
		        <input type="hidden" name="command" value="create_jobseeker"/>
		    </c:if>

		    <h2 class="form-heading">
		        <c:if test="${jobseeker != null}">
		            Edit Jobseeker
		        </c:if>
		        <c:if test="${jobseeker == null}">
		            Add New Jobseeker
		        </c:if>
		    </h2>

		    <table>
		        <tr>
		            <td>Jobseeker ID:</td>
		            <td><input name="jobseeker_id" type="text" class="form-control"
		                       value="<c:out value="${jobseeker.jobseeker_id}"/>" readonly="readonly"/></td>
		        <tr>
		        <tr>
		            <td>Jobseeker User ID:</td>
		            <td><input name="user_id" type="text" class="form-control" value="<c:out value="${jobseeker.user_id}"/>"/>
		            </td>
		        <tr>
		        <tr>
		            <td>Jobseeker Lastname:</td>
		            <td><input name="jobseeker_lastname" type="text" class="form-control"
		                       value="<c:out value="${jobseeker.jobseeker_lastname}"/>"/></td>
		        <tr>
		        <tr>
		            <td>Jobseeker Lastname:</td>
		            <td><input name="jobseeker_name" type="text" class="form-control"
		                       value="<c:out value="${jobseeker.jobseeker_name}"/>"/></td>
		        <tr>
		        <tr>
		            <td>Jobseeker Status:</td>
		            <td><input name="jobseeker_status" type="text" class="form-control"
		                       value="<c:out value="${jobseeker.jobseeker_status}"/>"/></td>
		        <tr>
		    </table>

		    <c:if test="${jobseeker != null}">
		        <input value="Edit" type="submit">
		    </c:if>
		    <c:if test="${jobseeker == null}">
		        <input value="Add" type="submit">
		    </c:if>
		</form>
	</center>
</div>

<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>