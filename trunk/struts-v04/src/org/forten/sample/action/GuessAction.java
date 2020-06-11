package org.forten.sample.action;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@Results({ @Result(name = "input", location = "/index.jsp") })
public class GuessAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private static int answer = 0;
	private String message;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	private int initAnswer() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}

	@Action(value="reinit")
	public String reinitAnswer() {
		String ip = request.getRemoteAddr();
		if (ip.equals("166.111.202.234")) {
			answer = initAnswer();
			System.out.println(String.format("用户初始化数字为%d", answer));
		}else{
			message = "你没有初始化答案的权限";
		}
		return INPUT;
	}

	@Action(value = "gotoGuess")
	public String gotoGuess() {
		if (answer == 0) {
			answer = initAnswer();
			System.out.println(String.format("用户初始化数字为%d", answer));
		}
		return INPUT;
	}

	@Action(value = "guess")
	public String guess() {
		int num = -1;
		String numStr = request.getParameter("num");
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			message = "输入的数字格式非法，请输入1到100之间的数字";
			return INPUT;
		}
		System.out.println(String.format("[%s]输入的数字是%d", request.getRemoteAddr(), num));
		if (num < 1 || num > 100) {
			message = "请输入1到100之间的数字";
			return INPUT;
		}
		if (num < answer) {
			message = String.format("输入的数字是[%d]小于答案", num);
		} else if (num > answer) {
			message = String.format("输入的数字是[%d]大于答案", num);
		} else {
			message = String.format("输入的数字是[%d]，正确", num);
		}
		return INPUT;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
