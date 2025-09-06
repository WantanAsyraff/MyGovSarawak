<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	For this assignment, I'm using tutorialspoint.com as my main reference alonside other online sources
	to properly create internationalization. - wantan
	
	REFERENCES
	Sir Azlan's notes on mycidos (Week 1 - Week5)
	link: https://www.tutorialspoint.com/jsp/jsp_internationalization.htm
	
	UPDATE (9/7/2025) - Apparently I just read this source:
	https://stackoverflow.com/questions/6555395/jsp-resourcebundle?
	And it mentioned using scriptlets is bad practise... However I am too far deep and
	it's 5:57 A.M.... I'll take this as a learning lesson - wantan
	
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
	ResourceBundle bundle = (ResourceBundle) request.getAttribute("bundle");
	// This approach is personally better due to a few reasons. One of them
	// Make sure you have forwarded the bundle in LoginServlet.java
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
	<%
		Boolean loginFailed = (Boolean) session.getAttribute("sessionSuccess");
		
		// Check if login is false
		if (loginFailed != null && !loginFailed) {
	%>
			<p style="color: red"><%= session.getAttribute("errorMsg") %></p>
	<%	
		}
	%>
	<section class="card-wrapper">
		<img src="imgs/sarawak.jpg" alt=<%= bundle.getString("alt.img") %>>
	</section>
	<!-- Login card -->
	<section class="card-wrapper">
		<div class="login-form-card">
		<h1><%= bundle.getString("welcome.message") %></h1>
			<div class="inner-form">
			<!-- Method POST Here -->
				<form action="LoginServlet" method="POST">
				<!-- Perform client side validation: using required keyword -->		
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