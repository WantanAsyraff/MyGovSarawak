<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	For this assignment, I'm using tutorialspoint.com as my main reference alonside other online sources
	to properly create internationalization. - wantan
	link: https://www.tutorialspoint.com/jsp/jsp_internationalization.htm
-->

<!-- Taip sendiri - wantan -->
<!--
	This is a directive indicated with a < %@...% > syntax. Its purpose is to tell the JSP engine how to compile the
	page. It runs only once during page translation time.
-->
<%@ page import = "java.util.*;" %>



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