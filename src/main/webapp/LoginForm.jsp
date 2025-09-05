<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	For this assignment, I'm using tutorialspoint.com as my reference to properly create internationalization. - wantan
	link: https://www.tutorialspoint.com/jsp/jsp_internationalization.htm
-->

<!-- Taip sendiri - wantan -->
<%@ page import = "java.io.*,java.util.Locale" %>
<!--
	Note: I the tutorial they used, javax.servlet however that is for Tomcat 9 and below. 
	I am using Tomcat 10 for our newer Servlet conatainer.
-->
<%@ page import = "jakarta.servlet.*,jakarta.servlet.http.* "%>

<!--  -->
<%
	// Get the client's Locale
	Locale locale = request.getLocale();
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<!-- LOGIN FORM HTML -->
	<section>
		<div class="form-bg-card">
			<img src="#">
		</div>
	</section>
	<!-- Login card -->
	<section>
		<div class="login-form-card">
			<h1></h1>
			<form>			
			<label>Name: </label><input name="name" type="text" required>
			<label>Password: </label><input name="password" type="password" required>
			<button type="submit">submit</button>
			<button type="reset">reset</button>
			</form>
		</div>
	</section>
</body>
</html>