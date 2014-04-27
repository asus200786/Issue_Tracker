package by.epam.epamlab.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticateController
 */
@WebServlet("/AuthenticateController")
public class AuthenticateController extends AbstractController {
	private static final long serialVersionUID = 201404252016L;
       
    /**
     * @see AbstractController#AbstractController()
     */
    public AuthenticateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html);charset=UTF-8");
	PrintWriter out = response.getWriter();
	try{
		request.authenticate(response);
		out.println("Authenticate Successful");
	} finally {
		out.close();
	}
		
	}

}
