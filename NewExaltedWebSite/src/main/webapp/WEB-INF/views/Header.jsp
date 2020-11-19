<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<style type="text/css">
  <%@include file="style.css" %>
</style>
</head>
<body>
	<p><B>Username:  ${sessionScope.username} &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Status:  ${sessionScope.status}</B>
	
	<div class = "menuButton">
		<B><A id="menuBar" HREF="${pageContext.request.contextPath}/userProfile"> Home </A></B>
	</div>
	
	<div class = "menuButton">
		<B><A id="menuBar" HREF="${pageContext.request.contextPath}/listCharacters"> List My Characters </A></B>
	</div>
	
	
	
	
	<sf:form action="${pageContext.request.contextPath}/logout" method="POST">
		<div class = "menuButton"> <input type="submit" name="commit" value="Log Out" /> </div>
	</sf:form>
	</p>
	

	
</body>
</html>