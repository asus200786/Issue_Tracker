package by.epam.epamlab.session.user_controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.epamlab.constants.ConstantsControllers;
import by.epam.epamlab.interfaces.IUserDAO;
import by.epam.epamlab.session.AbstractController;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 201404252031L;
 
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter(ConstantsControllers.EMAIL_ADDRESS);
		String password = request.getParameter(ConstantsControllers.PASSWORD);
		
		IUserDAO login = User.
		 
	}

}
