<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Character Creation</title>
<style type="text/css">
  <%@include file="style.css" %>
</style>
</head>
<body>

	<h2>Fill out your new Profile stats below</h2>
	
	<sf:form action="createCharacter" method="POST" modelAttribute="CharacterSheet">
		<sf:label path="CharacterName">Profile Name</sf:label>
		<sf:input path="CharacterName" size="50" value="CharacterName" />
		<br><br>
		<sf:label path="username">username</sf:label>
		<sf:input path="username" size="30" value="${userCurrentName}" />
		<br><br>
		<sf:label path="strength">strength</sf:label>
		<sf:input path="strength" size="3" value="0" />
		<br><br>
		<sf:label path="dexterity">dexterity</sf:label>
		<sf:input path="dexterity" size="3" value="0" />
		<br><br>
		<sf:label path="stamina">stamina</sf:label>
		<sf:input path="stamina" size="3" value="0" />
		<br><br>
		<sf:label path="charisma">charisma</sf:label>
		<sf:input path="charisma" size="3" value="0" />
		<br><br>
		<sf:label path="manipulation">manipulation</sf:label>
		<sf:input path="manipulation" size="3" value="0" />
		<br><br>
		<sf:label path="appearance">appearance</sf:label>
		<sf:input path="appearance" size="3" value="0" />
		<br><br>
		<sf:label path="perception">perception</sf:label>
		<sf:input path="perception" size="3" value="0" />
		<br><br>
		<sf:label path="intelligence">intelligence</sf:label>
		<sf:input path="intelligence" size="3" value="0" />
		<br><br>
		<sf:label path="wits">wits</sf:label>
		<sf:input path="wits" size="3" value="0" />
		<br><br>
		
		<sf:label path="XP">Budget</sf:label>
		<sf:input path="XP" size="4" value="0" />
		<br><br>
		<sf:label path="XP_Spent">Money spent</sf:label>
		<sf:input path="XP_Spent" size="4" value="0" />
		<br><br>

		<input type="submit" name="commit" value="createCharacter" />
		<br><br>
	</sf:form>
	
	<B>${requestScope.message}</B><br>

		<div class = "menuButton">
			<a href="userProfile">Back To User Profile</a>
		</div>
<!-- 
		<div class = "menuButton">
			<a href="Step_One_of_Character_Creation">Step One of Character Creation</a>
		</div>
-->	
</body>
</html>