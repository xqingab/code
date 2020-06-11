package org.forten.sample.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexAction {
	@RequestMapping("index")
	public String index(){
		return "index.jsp";
	}
}
