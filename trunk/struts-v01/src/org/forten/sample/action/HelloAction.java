package org.forten.sample.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String helloWorld() {
		System.out.println("Hello World");
		return SUCCESS;
	}

	public String helloChina() {
		System.out.println("Hello China");
		return SUCCESS;
	}
}
