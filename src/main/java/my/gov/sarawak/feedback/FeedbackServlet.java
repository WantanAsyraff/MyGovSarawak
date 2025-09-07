package my.gov.sarawak.feedback;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		//Headers & content
		response.setHeader("Accept-Language", "ms-MY");
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		// Create a session, if there's none, don't create a new one.
		// We wanna check if there's an existing one that's already been made
		// During the login session.
		HttpSession session = request.getSession(false);
		Boolean sessSuccess = (Boolean) session.getAttribute("sessionSuccess");
		set_locale_bundle(request);
		
		// Check session
		if (session == null || session.getAttribute("sessionSuccess") == null|| !sessSuccess) {
			response.sendRedirect("LoginForm.jsp?error=1");
			return; // Stop execution
		}
		
		
		// Forward to feedback.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("FeedbackForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private Boolean validate_form(String fullnameForm, String emailForm, String feedbackType,String descForm ,HttpServletRequest request){
		Boolean isValid = true;
		
		if (fullnameForm == null || fullnameForm.trim().isEmpty()) {
			request.setAttribute("fullnameError", "Full name is required");
			isValid = false;
		}
		if (emailForm == null ||  !emailForm.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			request.setAttribute("emailError", "Valid email required");
			isValid = false;
		}
		
		if (descForm == null || descForm.trim().length() < 10) {
			request.setAttribute("descFormError", "Description must be atleast 10 chars");
			isValid = false;
		}
		return isValid;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Headers & content
		response.setHeader("Accept-Language", "ms-MY");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String fullnameForm = request.getParameter("fullname");
		String emailForm = request.getParameter("email");
		String feedbackType = request.getParameter("feedback-type");
		String descForm = request.getParameter("text");
		
		Boolean form = validate_form(fullnameForm, emailForm, feedbackType, descForm, request);
		
		if (form) {
			// Success: Show a popup and redirect back into the form
			response.getWriter().println("<script>");
			response.getWriter().println("alert('Feedback Submitted successfully!');");
			response.getWriter().println("</script>");
		} else {
			// Failed: Reforward back the user to form with errors
			
			set_locale_bundle(request); // Make sure bundle is available
		    RequestDispatcher dispatcher = request.getRequestDispatcher("FeedbackForm.jsp");
		    dispatcher.forward(request, response); // Throws error into console btw
		}
		
	}

}
