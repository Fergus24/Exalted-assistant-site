<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
  <%@include file="style.css" %>
</style>
</head>
<body>
	
	<h2>Login</h2>

	<sf:form action="submitLogin" method="POST" modelAttribute="user">
		<sf:label path="username">Username</sf:label>
		<sf:input path="username" size="30" value="username" />
		<br><br>
		<sf:label path="password">Password</sf:label>
		<sf:input path="password" size="30" value="password" />
		<br>
		<br>
		<div class = "menuButton">
		<input type="submit" name="commit" value="Login" />
		</div>
		<br>
	</sf:form>
	
	<B>${requestScope.message}</B><br>
	
	<br>
	
	<div class = "menuButton">
		<a href="signupform">Don't have an account?</a>
	</div>

	
</body>
</html>