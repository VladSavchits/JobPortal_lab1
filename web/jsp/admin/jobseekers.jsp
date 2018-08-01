<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show All Jobseekers</title>
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
			        <th>Jobseeker ID</th>
			        <th>Jobseeker User ID</th>
			        <th>Jobseeker Lastname</th>
			        <th>Jobseeker Name</th>
			        <th>Jobseeker Status</th>
			        <th>Edit</th>
			        <th>Delete</th>
			    </tr>
			    </thead>

			    <tbody>
			    <c:forEach items="${jobseekers}" var="jobseeker">
			        <tr>
			            <td><c:out value="${jobseeker.jobseeker_id}"/></td>
			            <td><c:out value="${jobseeker.user_id}"/></td>
			            <td><c:out value="${jobseeker.jobseeker_lastname}"/></td>
			            <td><c:out value="${jobseeker.jobseeker_name}"/></td>
			            <td><c:out value="${jobseeker.jobseeker_status}"/></td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="to_update_jobseeker">
			                    <input type="hidden" name="jobseeker_id" value="${jobseeker.jobseeker_id}">
			                    <input value="Update" type="submit">
			                </form>
			            </td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="delete_jobseeker">
			                    <input type="hidden" name="jobseeker_id" value="${jobseeker.jobseeker_id}">
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
		<input type="hidden" name="command" value="to_create_jobseeker">
		<input value="Add Jobseeker" type="submit">
	</form>
</div>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>