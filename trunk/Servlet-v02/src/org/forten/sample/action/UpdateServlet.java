package org.forten.sample.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/user/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 从请求中获取用户在表单中输入的数据
		String name = request.getParameter("username");
		String idStr = request.getParameter("id");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String ageStr = request.getParameter("age");
		// 对原始的字符串数据进行类型转换
		int age = Integer.parseInt(ageStr);
		int id = Integer.parseInt(idStr);

		User user = new User(id, name, "aaa", email, gender, age);
		
		PrintWriter out = response.getWriter();
		
		try {
			UserBo.doUpdate(user);
			// 重定向
			response.sendRedirect("list.do");
		} catch (ClassNotFoundException | SQLException e) {
			out.println("系统异常");
			e.printStackTrace();
		}
	}

}
