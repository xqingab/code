package org.forten.sample.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/hello")
public class HelloAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Action(value="helloWorld", results={@Result(name="success",location="/hello/hello-world.jsp")})
	public String helloWorld() {
		System.out.println("Hello World");
		return SUCCESS;
	}

	@Action(value="helloChina", results={@Result(name="success",location="/hello/hello-china.jsp")})
	public String helloChina() {
		System.out.println("Hello China");
		return SUCCESS;
	}
}
