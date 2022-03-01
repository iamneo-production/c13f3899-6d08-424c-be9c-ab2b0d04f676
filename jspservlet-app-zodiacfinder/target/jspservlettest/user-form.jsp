<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
		  <form  action="insert">  
			<input type="text" name="userName" id="userName" placeholder="enter your name" /> 
            <input type="text" name="userBirthDate" id="userBirthDate"   placeholder="enter your DOB(dd/mm/yyyy)" />  
            <input type="text" name="userBirthTime" id="userBirthTime"   placeholder="Enter the timings hh:mm" />  
            <input type="text" name="userDistrict" id="userDistrict"   placeholder="enter your district you born" />  
			<input type="submit" value="Save"/>  
			</form> 

	</body>
</html>