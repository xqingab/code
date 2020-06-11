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
 * Servlet implementation class GotoUpdateServlet
 */
@WebServlet("/user/gotoUpdate.do")
public class GotoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GotoUpdateServlet() {
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

		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			out.println("你正在执行删除操作，请提供正确的id");
			return;
		}

		User user = null;
		try {
			user = UserBo.queryBy(id);
			if (user != null) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			} else {
				out.println("要修改的用户id不存在");
				return;
			}
		} catch (ClassNotFoundException | SQLException e) {
			out.println("系统异常");
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
