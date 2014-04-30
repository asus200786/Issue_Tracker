package by.epam.epamlab.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormController
 */
@WebServlet("/LoginFormController")
public class LoginFormController extends HttpServlet {
	private static final long serialVersionUID = 201404262125L;

	private static final String TYPE_MIME_HTML = "text/html";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginFormController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Sets the type Mime of response in the "text/html"
		response.setContentType(TYPE_MIME_HTML);
		// Use PrintWriter for sending data to the client, which appealed to the
		// server
		PrintWriter out = response.getWriter();
		// Start forming HTML content
		out.println("<html><head>");
		out.println("<title>Login Issue_Tracker</title></head><body><header>");
		out.println("<div><h1>Join our Issue-Tracker</h1></div>");
		out.println("</header>");
		// method="post" as a servlet causes doPost servers for data entered
		// into the form
		out.println("<form method=\"post\" action = \""
				+ request.getContextPath() + "/LoginFormController\">");
		out.println("<div class=\"simplyLog\">");
		out.println("<div class=\"userData\">");
		out.println("Your login:");
		out.println("<input type=\"text\" name=\"Email Address\" size=\"25\"");
		out.println("</div><div class=\"userData\">");
		out.println("Your password:");
		out.println("<input type=\"text\" name=\"Password\" size=\"25\"");
		out.println("</div><div class=\"submit\">");
		out.println("<input type=\"submit\" value=\"Log In\"");
		out.println("</div></form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// display the parameter names and values
		Enumeration paramNames = request.getParameterNames();
		String paramName; // is stored here the name of the parameter

		boolean isEmptyEnum = false;

		if (!paramNames.hasMoreElements())
			isEmptyEnum = true;

		// Sets the type Mime of response in the "text/html"
		response.setContentType(TYPE_MIME_HTML);
		// Use PrintWriter for sending data to the client, which appealed to the
		// server
		PrintWriter out = response.getWriter();
		// Start forming HTML content
		out.println("<html><head>");
		out.println("<title>Submitted Parameters Issue_Tracker</title></head><body><header>");
		out.println("<div><h1>Join our Issue-Tracker</h1></div>");
		out.println("</header>");
		if (isEmptyEnum){
			out.println("<h2>Sorry, the request does not contain any parameters.</h2>");
		} else {
			out.println("<h2>Here are the submitted parameter values.</h2>");
		}
		
		while (paramNames.hasMoreElements()){
			paramName = (String) paramNames.nextElement();
			out.println("<strong>"+paramName + "</strong>:" + request.getParameter(paramName));
			out.println("<br/>");
		}
		
		out.println("</body></html>");
	}

}
