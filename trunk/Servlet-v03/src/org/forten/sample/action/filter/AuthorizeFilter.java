package org.forten.sample.action.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.forten.sample.entity.User;

/**
 * Servlet Filter implementation class AuthorizeFilter
 */
//@WebFilter(urlPatterns={"/book/save.do","/book/save.html","/book/delete.do","/book/update.jsp","/book/update.do"})
public class AuthorizeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizeFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("auth2");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginedUser");
		
		if(user.getRoleName()==0){
			chain.doFilter(req, res);
		}else{
			res.sendRedirect("/book/list.do");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
