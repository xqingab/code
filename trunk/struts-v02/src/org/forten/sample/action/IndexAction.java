package org.forten.sample.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/")
public class IndexAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Action(value = "index", results = { @Result(name = "success", location = "/index.jsp") })
	public String index() {
		System.out.println("进入IndexAction的execute方法");
		return SUCCESS;
	}
}
