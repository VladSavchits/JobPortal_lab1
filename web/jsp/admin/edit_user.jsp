<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<div class="container">
	<center>
		<form action="controller" method="post">
		    <c:if test="${user != null}">
		        <input type="hidden" name="command" value="update_user"/>
		    </c:if>
		    <c:if test="${user == null}">
		        <input type="hidden" name="command" value="create_user"/>
		    </c:if>

		    <h2 class="form-heading">
		        <c:if test="${user != null}">
		            Edit User
		        </c:if>
		        <c:if test="${user == null}">
		            Add New User
		        </c:if>
		    </h2>

		    <table>
		        <tr>
		            <td>User ID:</td>
		            <td><input name="user_id" type="text" class="form-control" value="<c:out value="${user.user_id}"/>"
		                       readonly="readonly"/></td>
		        <tr>
		        <tr>
		            <td>User Login:</td>
		            <td><input name="user_login" type="text" class="form-control" value="<c:out value="${user.user_login}"/>"/>
		            </td>
		        <tr>
		        <tr>
		            <td>User Password:</td>
		            <td><input name="user_password" type="password" class="form-control"
		                       value="<c:out value="${user.user_password}"/>"/></td>
		        <tr>
		        <tr>
		            <td>User Email:</td>
		            <td><input name="user_email" type="text" class="form-control" value="<c:out value="${user.user_email}"/>"/>
		            </td>
		        <tr>
		        <tr>
		            <td>User Status:</td>
		            <td><input name="user_status" type="text" class="form-control"
		                       value="<c:out value="${user.user_status}"/>"/></td>
		        <tr>
		    </table>

		    <c:if test="${user != null}">
		        <input value="Edit" type="submit">
		    </c:if>
		    <c:if test="${user == null}">
		        <input value="Add" type="submit">
		    </c:if>
		</form>
	</center>
</div>

<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>