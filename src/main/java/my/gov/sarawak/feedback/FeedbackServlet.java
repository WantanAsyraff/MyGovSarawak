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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
