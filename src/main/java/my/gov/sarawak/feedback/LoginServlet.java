package my.gov.sarawak.feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
