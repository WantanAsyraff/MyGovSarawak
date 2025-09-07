package my.gov.sarawak.feedback;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     SELF NOTES: - wantan
     # The Servlet Validation Lifecycle (W4-2 Notes)
     	- Incoming HTTP requests are handled by doPost()/doGet() methods in your servlet.
     	
     	- Use request.getParameter("paramName") to retrieve submitted form data
     	
     	- Apply appropriate valiadation rules to each extracted parameter. Store validation
     	errors if any are found.
     	
     	- If validation fails, prepare an error response (e.g., a list of errors)
		  and send it back to the client. This often involves forwarding to a
		  JSP with error messages or sending a JSON error object.
		  
		- If all input is valid, proceed with business logic, such as saving
		  data to a database, updating records, or performing other
		  operations.
		  
	 # THERE ARE TWO PRIMARY REQUEST METHODS
		  
		  - GET -> Used for retrieving data
		  - POST -> Used for submitting data
		  
		  ## GET Requests
		  
		  ### When to use?
		  - Retrieving information
		  - Navigating to specific pages/resources
		  - When requests are idempotent
		  
		  ## POST Requests
		  
		  ### When to use?
		  - Submitting forms
		  - Files uploads to server
		  - When requests are non-idempotent
		  - Sending sensitive or large amounts of data
		  
		  Important: Neither GET nor POST are inherently secure for sensitive data without HTTPS (SSL/TLS encryption).
		  HTTPS encrypts the entire communication, protecting data for both methods
		  
		  
    */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @SuppressWarnings("deprecation") // For the sake of this assignment, since apparently
    // Locale is depreciated now.
    private void set_locale_bundle(HttpServletRequest request) {
    	// Step 1: Decide locale (Default is MY)
    	// Messages.properties Naming Convention — BaseName_language_COUNTRY.properties
    	// BaseName: Common identifier
    	// COUNTRY: Two-letter uppercase code
    	// Language: Two-letter lowercase code
    	
    	Locale locale = new Locale("ms", "MY"); // Malaysian locale; Default (Ignore the warning, depreciated my bum!)
    			
    	// Step 2: Load bundle
    	ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale); 
    			
    	// Step 3: Attach to request
    	request.setAttribute("bundle", bundle);
    }
    
    private void login_validation(String usernameString, String passString, HttpSession sess) {
		// We pass parameters from the .jsp + a new Http session into here to validate
    	// the login 
    	String adminString = "admin";
    	String adminPassString = "123";
    	
    	if (usernameString.equals(adminString) && passString.equals(adminPassString)) {
    		// setAttribute can be anything we want to store during this session.
    		// Be sure that you only keep things you would want to keep temporarily.
    		sess.setAttribute("username", "admin");
    		sess.setAttribute("role", "admin");
    		sess.setAttribute("sessionSuccess", true);
    		sess.setAttribute("time", new Date());
    		
    		// We can retrieve an attribute back using this code
    		// String username = (String) session.getAttribute("username");
    	}
    	else {
    		// If failed login, we fail session.
    		sess.setAttribute("sessionSuccess", false);
    		sess.setAttribute("errorMsg", "Invalid Login! Please try again.");
    		sess.invalidate();
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Headers & Content
		response.setHeader("Accept-Language", "ms-MY");
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		// Always set your locale bundle
		set_locale_bundle(request);
		
		// Forward to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Headers & Contents
		
		
		// If no session exists, one gets created automatically.
		HttpSession session = request.getSession(true);
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Always set your locale bundle
      	set_locale_bundle(request);
		
        // Request the values we want from our .jsp and create a new session. 
        // Then send them to our validation function
		login_validation(username, password, session);
		
		// Typecasting to ensure tell the compilar that we want "sessionSuccess" to be
		// read as a boolean; Defined by adding the (Boolean) syntax.
		// Typecasting works since we know that sessionSuccess could hold a true/false value
		// (As defined in the login_validation() function). So, we can add a (Type) to tell
		// The compiler how exactly it should read the attribute.
		// NOTE: it's session.getAttrib, not request.getAttrib; It will not work if you do so
		Boolean  sessSuccess = (Boolean) session.getAttribute("sessionSuccess");
		
		// Make sure session success is not null and is true.
		if (sessSuccess != null && sessSuccess) {
			// If correct, we can forward the user into the feedback form
			response.sendRedirect("FeedbackForm.jsp");
		} else {
			
			// If incorrect, we send the user back to login form. with an error message.
			response.sendRedirect("FeedbackServlet");
		}
		
		// doGet(request, response);
	}

}
