<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show All Resumes</title>
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
			        <th>Resume ID</th>
			        <th>Jobseeker ID</th>
			        <th>Speciality ID</th>
			        <th>Skill ID</th>
			        <th>Resume Information</th>
			        <th>Edit</th>
			        <th>Delete</th>
			    </tr>
			    </thead>

			    <tbody>
			    <c:forEach items="${resumes}" var="resume">
			        <tr>
			            <td><c:out value="${resume.resume_id}"/></td>
			            <td><c:out value="${resume.jobseeker_id}"/></td>
			            <td><c:out value="${resume.specialty_id}"/></td>
			            <td><c:out value="${resume.skill_id}"/></td>
			            <td><c:out value="${resume.resume_information}"/></td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="to_update_resume">
			                    <input type="hidden" name="resume_id" value="${resume.resume_id}">
			                    <input value="Update" type="submit">
			                </form>
			            </td>

			            <td>
			                <form action="${pageContext.request.contextPath}/controller" method="POST">
			                    <input type="hidden" name="command" value="delete_resume">
			                    <input type="hidden" name="resume_id" value="${resume.resume_id}">
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
	    <input type="hidden" name="command" value="to_create_resume">
	    <input value="Add Resume" type="submit">
	</form>
</div>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>