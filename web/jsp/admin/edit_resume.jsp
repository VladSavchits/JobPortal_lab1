<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Resume Info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<div class="container">
	<center>
			<form action="controller" method="post">
			    <c:if test="${resume != null}">
			        <input type="hidden" name="command" value="update_resume"/>
			    </c:if>
			    <c:if test="${resume == null}">
			        <input type="hidden" name="command" value="create_resume"/>
			    </c:if>

			    <h2 class="form-heading">
			        <c:if test="${resume != null}">
			            Edit Resume
			        </c:if>
			        <c:if test="${resume == null}">
			            Add New Resume
			        </c:if>
			    </h2>

			    <table>
			        <tr>
			            <td>Resume ID:</td>
			            <td><input name="resume_id" type="text" class="form-control" value="<c:out value="${resume.resume_id}"/>"
			                       readonly="readonly"/></td>
			        <tr>
			        <tr>
			            <td>Jobseeker ID:</td>
			            <td><input name="jobseeker_id" type="text" class="form-control"
			                       value="<c:out value="${resume.jobseeker_id}"/>"/></td>
			        <tr>
			        <tr>
			            <td>Specialty ID:</td>
			            <td><input name="specialty_id" type="password" class="form-control"
			                       value="<c:out value="${resume.specialty_id}"/>"/></td>
			        <tr>
			        <tr>
			            <td>Skill ID:</td>
			            <td><input name="skill_id" type="text" class="form-control" value="<c:out value="${resume.skill_id}"/>"/>
			            </td>
			        <tr>
			        <tr>
			            <td>Resume Information:</td>
			            <td><input name="resume_information" type="text" class="form-control"
			                       value="<c:out value="${resume.resume_information}"/>"/></td>
			        <tr>
			    </table>

			    <c:if test="${resume != null}">
			        <input value="Edit" type="submit">
			    </c:if>
			    <c:if test="${resume == null}">
			        <input value="Add" type="submit">
			    </c:if>
			</form>
	</center>
</div>

<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>