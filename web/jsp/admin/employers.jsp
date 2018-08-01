<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show All Employers</title>
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
			        <th>Employer ID</th>
			        <th>User ID</th>
			        <th>Employer Name</th>
			        <th>Employer Information</th>
			        <th>Edit</th>
			        <th>Delete</th>
			    </tr>
			    </thead>

			    <tbody>
			    <c:forEach items="${employers}" var="employer">
			        <tr>
			            <td><c:out value="${employer.employer_id}"/></td>
			            <td><c:out value="${employer.user_id}"/></td>
			            <td><c:out value="${employer.employer_name}"/></td>
			            <td><c:out value="${employer.employer_information}"/></td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="to_update_employer">
			                    <input type="hidden" name="employer_id" value="${employer.employer_id}">
			                    <input value="Update" type="submit">
			                </form>
			            </td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="delete_employer">
			                    <input type="hidden" name="employer_id" value="${employer.employer_id}">
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
	    <input type="hidden" name="command" value="to_create_employer">
	    <input value="Add Resume" type="submit">
	</form>
</div>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>