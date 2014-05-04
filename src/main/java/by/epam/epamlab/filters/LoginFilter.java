package by.epam.epamlab.filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.epamlab.analyzer.sax.UserHandler;
import by.epam.epamlab.constants.Constants;
import by.epam.epamlab.constants.ConstantsControllers;
import by.epam.epamlab.model.beans.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	protected FilterConfig filterConfig;
	private Map<String, User> users;

	/**
	 * @see Filter#Filter()
	 */
	public LoginFilter() {
		super();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		users = new HashMap<String, User>();
		readConfig();
	}

	private void readConfig() {
		if (filterConfig != null) {
			BufferedReader input;
			try {
				String filename = filterConfig.getInitParameter("users");
				input = new BufferedReader(new FileReader(filename));

				XMLReader xmlReader = XMLReaderFactory.createXMLReader();
				UserHandler userHandler = new UserHandler();
				xmlReader.setContentHandler(userHandler);
				if (userHandler != null) {
					xmlReader.parse(new InputSource(getClass()
							.getResourceAsStream(Constants.INPUT_XML)));
					users = userHandler.getUsers();
				}
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		this.filterConfig = null;
		users = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String login = httpServletRequest
				.getParameter(ConstantsControllers.LOGIN);

		if (users.containsKey(login)) {
			httpServletResponse.sendError(httpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
