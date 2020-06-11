package org.forten.sample.action;

import java.io.IOException;
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
 * Servlet implementation class SaveAction
 */
@WebServlet("/book/save.do")
public class SaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAction() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String pubName = request.getParameter("pubName");
		String priceStr = request.getParameter("price");
		String pubDateStr = request.getParameter("pubDate");
		
		double price = Double.parseDouble(priceStr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate = null;
		try {
			pubDate = sdf.parse(pubDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Book book = new Book(name, author, pubName, price, pubDate);
		
		try {
			BookBo.doSave(book);
			response.sendRedirect("list.do");
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().println("保存图书信息失败");
			e.printStackTrace();
		}
		
	}

}
