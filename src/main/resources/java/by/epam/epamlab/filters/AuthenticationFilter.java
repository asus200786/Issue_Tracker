package by.epam.epamlab.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthentificationFilter
 */
public abstract class AuthenticationFilter implements Filter {
	protected ServletContext servletContext;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.servletContext = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (!isAuthentication()) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;// break filter chain, requested JSP/servlet will not be
					// executed
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * logic to accept or reject access to the page, check log in status
	 * 
	 * @return true when authentication is deemed valid
	 */
	protected abstract boolean isAuthentication();

}
