<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Built Characters</title>

<style type="text/css">
  <%@include file="style.css" %>
</style>

</head>
<body>

<%@include file="Header.jsp"%>

	<br><br><br>


	<sf:form action="Character_Sheet">
		<select name = "Character">
			<div class = "menuButton">
				
				<c:forEach items="${userCharacterNames}" var="item">
	    		
		    			<option> ${item} </option>

				</c:forEach>
				
				<input type="submit" name="commit" value="Load" />
				
			</div>
		</select>
	</sf:form>


<!--	<sf:form action="Character_Sheet">
		<c:forEach items="${userCharacterNames}" var="item">
		
    		<div class = "menuButton">
	    		<a href="Character_Sheet">${item}</a>
    		</div>
			
			<br><br>
			
		</c:forEach>

	</sf:form>
-->

		
<!--		<c:forEach items="${userCharacterNames}" var="item">
    		<div class = "menuButton">
	    		<a href="Character_Sheet">${item}</a>
    		</div>
    		<br><br>
		</c:forEach>
-->

</body>
</html>