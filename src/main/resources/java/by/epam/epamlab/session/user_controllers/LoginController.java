package by.epam.epamlab.session.user_controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.epamlab.constants.Constants;
import by.epam.epamlab.constants.ConstantsControllers;
import by.epam.epamlab.exceptions.ExceptionDAO;
import by.epam.epamlab.factories.UserFactory;
import by.epam.epamlab.interfaces.IUserDAO;
import by.epam.epamlab.model.beans.User;
import by.epam.epamlab.session.AbstractController;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 201404252031L;

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(ConstantsControllers.EMAIL_ADDRESS);
		String password = request.getParameter(ConstantsControllers.PASSWORD);
		String inputResult = getInputResult(login, password);
		// With incorrect input data the user is returned to the home page
		if (inputResult != null) {
			jump(ConstantsControllers.WELCOME_PAGE_URL, inputResult, request,
					response);
			return;
		}

		try {
			IUserDAO userDAO = UserFactory.getClassFromFactory();
			User user = userDAO.getUser(login, password);
			if (user != null) {
				request.getSession().setAttribute(ConstantsControllers.USER,
						user);
				response.sendRedirect(response
						.encodeRedirectURL(getServletContext().getContextPath()
								+ ConstantsControllers.WELCOME_PAGE_URL));
				return;
			} else {
				request.setAttribute(ConstantsControllers.MESSAGE,
						ConstantsControllers.ERROR_AUTHORIZATION);
				jump(ConstantsControllers.WELCOME_PAGE_URL, request, response);
			}

		} catch (ExceptionDAO e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}

	}

	private String getInputResult(String login, String password) {
		if (login == null || password == null) {
			return ConstantsControllers.ERROR_NULL;
		}
		if (login.trim().equals(Constants.EMPTY_STRING)
				|| password.trim().equals(Constants.EMPTY_STRING)) {
			return ConstantsControllers.ERROR_NULL;
		}
		return null;
	}

}
