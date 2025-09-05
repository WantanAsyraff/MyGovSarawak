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
<%@ page import = "java.util.*" %>

<!--
	This is a scriplet, indicated with a < %...% > syntax. This is how you embed
	Java code into your JSP. Executes when a request is processed. - wantan
-->
<% 
	Locale locale = new Locale("ms", "MY"); // Malaysian locale; Default (Ignore the warning, depreciated my bum!)
	ResourceBundle bundle = ResourceBundle.getBundle("messages", locale); 
	// This approach is personally better due to a few reasons. One of them
	// is being able to reference the .getStrings directly in html code;
	// Example: <h1>< %= bundle.getString("property-value") % ></h1>
	// Oh and btw <%=... % > is for value calls. FYI
	// So wowzars <(owo)> !! <- live reaction - wantan
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="./style.css"> <!-- Don't forget, ./ is to ref curr directory! -->
</head>
<body>
	<!-- LOGIN FORM HTML -->
	<section class="card-wrapper">
		<img src="imgs/sarawak.jpg" alt=<%= bundle.getString("alt.img") %>>
	</section>
	<!-- Login card -->
	<section class="card-wrapper">
		<div class="login-form-card">
		<h1><%= bundle.getString("welcome.message") %></h1>
			<div class="inner-form">
				<form action="POST">			
					<label><%= bundle.getString("username") %>: </label><input name="username" type="text" required>
					<br>
					<label><%= bundle.getString("password") %>: </label><input name="password" type="password" required>
					<br>
					<button type="submit"><%= bundle.getString("submit") %></button>
					<button type="reset"><%= bundle.getString("clear") %></button>
				</form>
			</div>
		</div>
	</section>
</body>
</html>