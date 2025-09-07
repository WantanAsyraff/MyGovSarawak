<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Directive call -->
<%@ page import= "java.util.*" %>

<!-- Scriptlet call -->

<% 
	if (request.getAttribute("bundle") == null) {
    	response.sendRedirect("FeedbackServlet");
    	return;
		}

	ResourceBundle bundle = (ResourceBundle) request.getAttribute("bundle");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Feedback Form</title>
<link rel="stylesheet" href="./style.css"> <!-- Don't forget, ./ is to ref curr directory! -->
</head>
<body>
	<!-- FEEDBACK FORM HTML -->
	<section class="card-wrapper">
    <div class="feedback-form-card"> <!-- fixed typo -->
        <h1><%= bundle.getString("feedback.form.title") %></h1>
        <form class="inner-feedback-form" action="FeedbackServlet" method="POST">
            <label><%= bundle.getString("full.name") %>:</label>
            <input name="fullname" required>

            <label><%= bundle.getString("email") %>:</label>
            <input name="email" required>

            <label><%= bundle.getString("feedback.type") %>:</label>
            <select name="feedback-type">
                <option value="opt-1"><%= bundle.getString("complain") %></option>
                <option value="opt-2"><%= bundle.getString("suggestion") %></option>
                <option value="opt-3"><%= bundle.getString("inquiry") %></option>
            </select>

            <label><%= bundle.getString("inquiry") %>:</label>
            <textarea name="text" required></textarea>

            <button type="submit"><%= bundle.getString("submit") %></button>
            <button type="reset"><%= bundle.getString("clear") %></button>
        </form>
    </div>
</section>

</body>
</html>