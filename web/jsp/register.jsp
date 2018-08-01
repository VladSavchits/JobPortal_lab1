<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>

<jsp:include page="common/_header.jsp"></jsp:include>
<jsp:include page="common/_menu.jsp"></jsp:include>


<div class="container">
    <center>
    <form action="${pageContext.request.contextPath}/controller" method="post">
        <input type="hidden" name="command" value="register"/>
        <table>
            <tr><td>Login:</td><td><input class="form-control" name="login" type="text"></td></tr>
            <tr><td>Password:</td><td><input class="form-control" name="password" type="password"></td></tr>
            <tr><td>Email:</td><td><input class="form-control" name="email" type="text"></td></tr>
            <tr><td>Lastname:</td><td><input class="form-control" name="lastname" type="text"></td></tr>
            <tr><td>Name:</td><td><input name="name" class="form-control" type="text"></td></tr>
	    <br>
            <tr><td><input value="Join!" type="submit"></td></tr>
        </table>
    </form>
    </center>
</div>

<jsp:include page="common/_footer.jsp"></jsp:include>
</body>
</html>