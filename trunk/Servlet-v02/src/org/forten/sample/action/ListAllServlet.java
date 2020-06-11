package org.forten.sample.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

/**
 * Servlet implementation class ListAllServlet
 */
@WebServlet("/user/list.do")
public class ListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAllServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		try {
			// 调用后台的业务逻辑，进行数据的获取
			List<User> list = UserBo.queryAll();
			// 把数据放置到请求对象中，以list为名字，数据容器对象为值
			request.setAttribute("list", list);
			// 得到一个向list.jsp页面转发的转发器对象
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			// 执行转发动作
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			out.print("数据查询失败，请联系管理员。");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
