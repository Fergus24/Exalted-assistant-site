<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up page</title>
<style type="text/css">
  <%@include file="style.css" %>
</style>
</head>

<body>

	<h2>Please fill in your details below</h2>
	
	<sf:form action="submitRegister" method="POST" modelAttribute="user">
		<sf:label path="username">Username</sf:label>
		<sf:input path="username" size="30" value="user" />
		<br><br>
		<sf:label path="password">Password</sf:label>
		<sf:input path="password" size="30" value="password" />
		<br>
		<br>
		<sf:label path="email">Email</sf:label>
		<sf:input path="email" size="30" value="email" />
		<br>
		<br>
		<input type="submit" name="commit" value="Register" />
		<br><br>
	</sf:form>
	
	<B>${requestScope.message}</B><br>
	<A HREF='${pageContext.request.contextPath}/login'>Already A Member?</A>
	<br>


</body>
</html>