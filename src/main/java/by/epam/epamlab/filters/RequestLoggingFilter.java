package by.epam.epamlab.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class RequestLoggingFilter
 */
public class RequestLoggingFilter implements Filter {
	protected ServletContext servletContext;

	// Called once when this filter is instantiated.
	// If mapped to j_security_check, called
	// very first time j_security_check is invoked.
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

	}

	/**
	 * Default constructor.
	 */
	public RequestLoggingFilter() {
	}

	// Called for every request that is mapped to this filter.
	// If mapped to j_security_check,
	// called for every j_security_check action
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// perform pre-login action here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		// calls the next filter in chain.
		// j_security_check if this filter is
		// mapped to j_security_check.
	}

}
