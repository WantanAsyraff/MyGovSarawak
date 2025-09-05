<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	For this assignment, I'm using tutorialspoint.com as my main reference alonside other online sources
	to properly create internationalization. - wantan
	link: https://www.tutorialspoint.com/jsp/jsp_internationalization.htm
-->

<!-- Taip sendiri - wantan -->
<!--
	This is a directive indicated with a < %@...% > syntax. Its purpose is to tell the JSP engine how to compile the
	page. It runs only once during page translation time. - wantan
-->
<%@ page import = "java.util.*;" %>

<!--
	This is a scriplet, indicated with a < %...% > syntax. This is how you embed
	Java code into your JSP. Executes when a request is processed.
-->

<% 
	Locale locale = new Locale("ms", "MY"); // Malaysian locale; Default (Igonore the warning, depreciated my bum!)
	ResourceBundle bundle = ResourceBundle.getBundle("ms-MY", locale); 
	// This approach is personally better due to a few reasons. One of them
	// is being able to reference the .getStrings directly in html code;
	// Example: <h1>< %= bundle.getString('property-value') % ></h1>
	// So wowzars <(owo)> !! <- live reaction - wantan
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