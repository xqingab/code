package org.forten.sample.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.forten.sample.bo.BookBo;

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/book/delete.do")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);

		PrintWriter out = response.getWriter();

		try {
			try {
				BookBo.doDelete(id);

				response.sendRedirect("list.do");
			} catch (ClassNotFoundException | SQLException e) {
				out.print("<h2>系统异常</h2>");
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			out.print("<h2>" + e.getMessage() + "</h2>");
			e.printStackTrace();
		}
	}
}
