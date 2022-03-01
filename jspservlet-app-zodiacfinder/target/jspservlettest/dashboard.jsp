<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Document</title>
		<style> 
			input[type=text] {
			  width: 50%;
			  padding: 12px 5px;
			  margin: 8px 0;
			  box-sizing: border-box;
			  border: 3px solid #ccc;
			  -webkit-transition: 0.5s;
			  transition: 0.5s;
			  outline: none;
			}
			
			input[type=text]:focus {
			  border: 3px solid #555;

			}
		.button {
  			background-color: #4CAF50; /* Green */
  			border: none;
  			color: white;
 			padding: 16px 32px;
  			text-align: center;
  			text-decoration: none;
  			display: inline-block;
  			font-size: 16px;
  			margin: 4px 2px;
			align-self: center;
  			transition-duration: 0.4s;
  			cursor: pointer;
			
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
  margin-left: 42.5%;
  
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}
			</style>
	</head>
	<body>
		<h2 style = "background-color: #48D1CC;
		color: white;
		font-size: xx-large;"> Zodiac Sign Finder </h2>
		
	


	<% User user = (User) request.getAttribute("user"); %>


	UserName: <%= user.getUserName() %>
	
	<% out.print("User Name:" + user.getUserName());%>
	<br>
	BirthDate: <%= user.getUserBirthDate() %>
	<br>
	BirthTime: <%= user.getUserBirthTime() %>
	<br>
	DistrictName: <%= user.getUserDistrict() %>
		<br>

		<h3>Your Zodiac Sign is : CAPRICORN</h3>
		<br>

		 <form  action="edit">  
			<input type="hidden" name="id" id="userId"  value="<%= user.getUserId() %>"   />   
			<input style="background-color: #48D1CC; width: 80px;border-radius: 10%;border-color: azure;color:azure;" type="submit" value="Edit"/>  
		</form> 
		<br>
		
		<form  action="deleteUser">  
			<input type="hidden" name="id" id="userId"  value="<%=user.getUserId() %>"   />   
			<input style="background-color: #48D1CC; width: 80px;border-radius: 10%;border-color: azure;color:azure;" type="submit" value="Delete"/>  
		</form> 
		<br>
		<form  action="test">  
			<input style="background-color: #48D1CC; width: 80px;border-radius: 10%;border-color: azure;color:azure;" type="submit" value="Back"/>  
		</form> 
			




	</body>
</html>