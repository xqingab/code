package org.forten.sample.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.forten.sample.bo.BookBo;
import org.forten.sample.entity.Book;

/**
 * Servlet implementation class UpdateAction
 */
@WebServlet("/book/update.do")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setCharacterEncoding("UTF-8");

		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);

		try (PrintWriter out = response.getWriter()) {
			Book book = BookBo.queryBy(id);
			if (book == null) {
				out.print("要被修改的数据id不存在");
			} else {
				request.setAttribute("book", book);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		// response.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String pubName = request.getParameter("pubName");
		String priceStr = request.getParameter("price");
		String pubDateStr = request.getParameter("pubDate");
		String idStr = request.getParameter("id");

		double price = Double.parseDouble(priceStr);
		int id = Integer.parseInt(idStr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate = null;
		try {
			pubDate = sdf.parse(pubDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Book book = new Book(id, name, author, pubName, price, pubDate, null);

		try {
			BookBo.doUpdate(book);
			response.sendRedirect("list.do");
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().println("修改图书信息失败");
			e.printStackTrace();
		}
	}

}
