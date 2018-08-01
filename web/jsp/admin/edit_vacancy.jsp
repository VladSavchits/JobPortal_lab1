<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<div class="container">
	<center>
		<form action="controller" method="post">
		    <c:if test="${vacancy != null}">
		        <input type="hidden" name="command" value="update_vacancy"/>
		    </c:if>
		    <c:if test="${vacancy == null}">
		        <input type="hidden" name="command" value="create_vacancy"/>
		    </c:if>

		    <h2 class="form-heading">
		        <c:if test="${vacancy != null}">
		            Edit Vacancy
		        </c:if>
		        <c:if test="${vacancy == null}">
		            Add New Vacancy
		        </c:if>
		    </h2>

		    <table>
		        <tr>
		            <td>Vacancy ID:</td>
		            <td><input name="vacancy_id" type="text" class="form-control" value="<c:out value="${vacancy.vacancy_id}"/>"
		                       readonly="readonly"/></td>
		        <tr>
		        <tr>
		            <td>Vacancy Employer ID:</td>
		            <td><input name="employer_id" type="text" class="form-control" value="<c:out value="${vacancy.employer_id}"/>"/>
		            </td>
		        <tr>
		        <tr>
		            <td>Vacancy Name:</td>
		            <td><input name="vacancy_name" type="text" class="form-control" value="<c:out value="${vacancy.vacancy_name}"/>"/></td>
		        <tr>
		        <tr>
		            <td>Vacancy Requirement:</td>
		            <td><input name="vacancy_requirements" type="text" class="form-control" value="<c:out value="${vacancy.vacancy_requirements}"/>"/>
		            </td>
		        <tr>
		        <tr>
		            <td>Vacancy Payment:</td>
		            <td><input name="vacancy_payment" type="text" class="form-control"
		                       value="<c:out value="${vacancy.vacancy_payment}"/>"/></td>
		        <tr>
		    </table>

		    <c:if test="${vacancy != null}">
		        <input value="Edit" type="submit">
		    </c:if>
		    <c:if test="${vacancy == null}">
		        <input value="Add" type="submit">
		    </c:if>
		</form>
	</center>
</div>

<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>