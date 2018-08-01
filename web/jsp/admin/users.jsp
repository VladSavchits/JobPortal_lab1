<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show All Users</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <table class="table table-bordered table-striped">
			    <thead>
			    <tr>
			        <th>User ID</th>
			        <th>User Login</th>
			        <th>User Password</th>
			        <th>User Email</th>
			        <th>User Status</th>
			        <th>Edit</th>
			        <th>Delete</th>
			    </tr>
			    </thead>

			    <tbody>
			    <c:forEach items="${users}" var="jobseeker">
			        <tr>
			            <td><c:out value="${jobseeker.user_id}"/></td>
			            <td><c:out value="${jobseeker.user_login}"/></td>
			            <td><c:out value="${jobseeker.user_password}"/></td>
			            <td><c:out value="${jobseeker.user_email}"/></td>
			            <td><c:out value="${jobseeker.user_status}"/></td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="to_update_user">
			                    <input type="hidden" name="user_id" value="${jobseeker.user_id}">
			                    <input value="Update" type="submit">
			                </form>
			            </td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="delete_user">
			                    <input type="hidden" name="user_id" value="${jobseeker.user_id}">
			                    <input value="Delete" type="submit">
			                </form>
			            </td>
			        </tr>
			    </c:forEach>
			    </tbody>
            </table>
        </div>
    </div>
    <br>

	<form action="${pageContext.request.contextPath}/controller" method="POST">
	    <input type="hidden" name="command" value="to_create_user">
	    <input value="Add User" type="submit">
	</form>
</div>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>