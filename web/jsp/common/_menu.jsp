<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">JobPortal</a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li>
                <p style="color: red;">Login: ${user.user_login}</p>
            </li>
         </ul>

        <div id="navbar">
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=view_users">Users</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=view_jobseekers">JobSeekers</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=view_employers">Employers</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=view_vacancies">Vacancies</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=view_resumes">Resumes</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=to_register">Registration</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=to_login">Login</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=logout">LogOut</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
            	<li><a href="controller?command=CREATE_DOCUMENT&docname=user_document&id=2">PDF</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=CREATE_DOCUMENT&docname=VACANCIES&id=2">CSV</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-static-top">
                <li><a href="controller?command=CREATE_DOCUMENT&docname=free_jobseekers_xls">XLS</a></li>
            </ul>
        </div>
	</div>
</nav>