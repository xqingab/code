package org.forten.sample.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = UserBo.login(name, password);
			if(user==null){
				request.setAttribute("msg", "登录失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("loginedUser", user);
				response.sendRedirect("book/list.do");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
	}

}
