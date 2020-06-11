package org.forten.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintMsgServlet
 */
// 以下注解的功能是把当前Servlet类映射到/pring.do这个URL下
// 也可以使用传统的web.xml中的声明与映射，但同一个Servlet不可以既在类上映射，又通过web.xml中进行映射
//@WebServlet("/print.do")
public class PrintMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintMsgServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 把响应对象的字符集合设置为UTF-8
		response.setCharacterEncoding("UTF-8");

		// 从请求对象中获取名字为xm的参数值
		String name = request.getParameter("xm");
		// 拼接消息
		String msg = name + " 你好！";

		// 得到响应对象中的输出流
		PrintWriter out = response.getWriter();
		// 通过输出流把消息回显到用户的浏览器上
		out.print("<h1>" + msg + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 把请求和响应对象的字符集合都设置为UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String name = request.getParameter("xm");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String[] ah = request.getParameterValues("ah");

		String msg = "<h1>" + name + "你好!</h1><h2>请确认你的QQ号是" + qq + "，电话号码是" + tel + "</h2>" + "<h2>你的爱好代码有：";
		
		for (String a : ah) {
			msg = msg+a+"&nbsp;&nbsp;";
		}
		msg = msg+"</h2>";

		PrintWriter out = response.getWriter();
		out.println(msg);
	}

}
