package org.forten.scss.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.forten.scss.dto.UserDtoForShow;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
public class AuthenticateFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthenticateFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		UserDtoForShow userDto = (UserDtoForShow) session
				.getAttribute("userInfo");
		if (userDto == null || userDto == UserDtoForShow.NULL_USER_DTO_FOR_SHOW) {
			res.sendRedirect("/gotoLogin.do");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
