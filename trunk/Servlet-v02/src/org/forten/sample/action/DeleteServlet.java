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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/user/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		String idStr = request.getParameter("id");
		PrintWriter out = response.getWriter();

		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			out.println("你正在执行删除操作，请提供正确的id");
			return;
		}

		try {
			int i = UserBo.doDelete(id);
			if(i==0){
				out.println("你要删除的用户已不存在，没必要删除");
			}else{
				response.sendRedirect("list.do");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			out.println("删除失败");
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
