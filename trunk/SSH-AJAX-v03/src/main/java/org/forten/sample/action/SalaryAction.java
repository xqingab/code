package org.forten.sample.action;

import org.forten.sample.ro.SalaryRo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SalaryAction {
	@RequestMapping("getChart")
	public @ResponseBody SalaryRo getChart() {
		return new SalaryRo();
	}
}
