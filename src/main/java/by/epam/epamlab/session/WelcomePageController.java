package by.epam.epamlab.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.epamlab.constants.ConstantsControllers;
import by.epam.epamlab.model.beans.User;
import by.epam.epamlab.utilities.ServletUtilities;

/**
 * Servlet implementation class LoginFormController
 */
@WebServlet("/WelcomePageController")
public class WelcomePageController extends AbstractController {
	private static final long serialVersionUID = 201404262125L;

	// private static final String TYPE_MIME_HTML = "text/html";

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ConstantsControllers.USER);
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities
				.headerWithTitle(ConstantsControllers.WELCOME_PAGE_TITLE));
		out.println(ServletUtilities.userMenuFragment(user));
		out.println(ServletUtilities.issuesListFragment(user));
		out.println(ServletUtilities.footer());
	}

	// /**
	// * @see HttpServlet#HttpServlet()
	// */
	// public WelcomePageController() {
	// super();
	// }
	//
	// /**
	// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// * response)
	// */
	// @Override
	// protected void doGet(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// // Sets the type Mime of response in the "text/html"
	// response.setContentType(TYPE_MIME_HTML);
	// // Use PrintWriter for sending data to the client, which appealed to the
	// // server
	// PrintWriter out = response.getWriter();
	// // Start forming HTML content
	// out.println("<html><head>");
	// out.println("<title>Login Issue_Tracker</title></head><body><header>");
	// out.println("<div><h1>Join our Issue-Tracker</h1></div>");
	// out.println("</header>");
	// // method="post" as a servlet causes doPost servers for data entered
	// // into the form
	// out.println("<form name=\"login\" method=\"post\" action = \""
	// + request.getContextPath() +
	// ConstantsControllers.WELCOME_PAGE_URL+"\">");
	// out.println("<div class=\"simplyLog\">");
	// out.println("<div class=\"userData\">");
	// out.println("Your login:");
	// out.println("<input type=\"text\" name=\"Login: \" size=\"25\" required placeholder=\"Your login\"");
	// out.println("</div><div class=\"userData\">");
	// out.println("Your password:");
	// out.println("<input type=\"text\" name=\"Password: \" size=\"25\" required placeholder=\"Your password\"");
	// out.println("</div><div class=\"submit\">");
	// out.println("<input type=\"submit\" value=\"Log In\"");
	// out.println("</div></form>");
	// out.println("</body></html>");
	// }
	//
	// /**
	// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	// * response)
	// */
	// @Override
	// protected void doPost(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// // display the parameter names and values
	// Enumeration paramNames = request.getParameterNames();
	// String paramName; // is stored here the name of the parameter
	//
	// boolean isEmptyEnum = false;
	//
	// if (!paramNames.hasMoreElements())
	// isEmptyEnum = true;
	//
	// // Sets the type Mime of response in the "text/html"
	// response.setContentType(TYPE_MIME_HTML);
	// // Use PrintWriter for sending data to the client, which appealed to the
	// // server
	// PrintWriter out = response.getWriter();
	// // Start forming HTML content
	// out.println("<html><head>");
	// out.println("<title>Submitted Parameters Issue_Tracker</title></head><body><header>");
	// out.println("<div><h1>Join our Issue-Tracker</h1></div>");
	// out.println("</header>");
	// if (isEmptyEnum){
	// out.println("<h2>Sorry, the request does not contain any parameters.</h2>");
	// } else {
	// out.println("<h2>Here are the submitted parameter values.</h2>");
	// }
	// //
	// // while (paramNames.hasMoreElements()){
	// // paramName = (String) paramNames.nextElement();
	// // out.println("<strong>"+paramName + "</strong>:" +
	// request.getParameter(paramName));
	// // out.println("<br/>");
	// // }
	//
	// out.println("</body></html>");
	// }

}
