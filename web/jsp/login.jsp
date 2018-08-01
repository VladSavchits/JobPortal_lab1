<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="common/_header.jsp"></jsp:include>
<jsp:include page="common/_menu.jsp"></jsp:include>

<div class="container">
	<form method="post" action="${pageContext.request.contextPath}/controller">
	    <input type="hidden" name="command" value="login"/>
		<div class="form-group">
			<input type='text' name='login' class="form-control" placeholder="Enter Login">
	    </div>
		<div class="form-group">
			<input type='password' name='password' class="form-control" placeholder="Enter Password">
	    </div>

	    <input value="Login" type="submit"></td>
	    <p style="color: red;">${errorString}</p>
	</form>

	<h4 class="text-center"><a href="/registration">New user? Let's create an account!</a></h4>
	<form method="post" action="${pageContext.request.contextPath}/controller">
	    <input type="hidden" name="command" value="to_register">
	</form>
</div>

<jsp:include page="common/_footer.jsp"></jsp:include>
</body>
</html>