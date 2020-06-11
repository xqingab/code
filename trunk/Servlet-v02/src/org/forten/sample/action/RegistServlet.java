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
 * Servlet implementation class RegistServlet
 */
@WebServlet("/user/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求与响应的字符集为UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 从请求中获取用户在表单中输入的数据
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String ageStr = request.getParameter("age");
		// 对原始的字符串数据进行类型转换
		int age = Integer.parseInt(ageStr);

		// 把数据封装成用户类型的对象
		User user = new User(name, password, email, gender, age);

		// 得到响应输出流
		PrintWriter out = response.getWriter();
		
		try {
			// 调用后台的数据持久化业务逻辑
			int i = UserBo.doRegist(user);
			response.sendRedirect("list.do");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// 如果出现异常则在浏览器上显示失败消息
			out.println("注册失败");
		}
	}

}
