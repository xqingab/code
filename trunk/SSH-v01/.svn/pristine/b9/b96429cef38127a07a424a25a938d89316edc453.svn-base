package org.forten.sample.action;

import javax.annotation.Resource;

import org.forten.sample.bo.LoginBo;
import org.forten.sample.vo.LoginedUserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes({ "loginedVo" })
public class LoginAction {
	@Resource
	private LoginBo bo;

	@RequestMapping("login")
	public ModelAndView login(String name, String password) {
		LoginedUserVo vo = bo.login(name, password);
		ModelAndView mav = new ModelAndView();
		if (vo == null) {
			mav.setViewName("redirect:notebook/list.do");
		} else {
			mav.addObject("loginedVo", vo);
			if (vo.getRoleName().equals("A")) {
				mav.setViewName("redirect:notebook/admin/list.do");
			}else{
				mav.setViewName("redirect:notebook/list.do");
			}
		}
		return mav;
	}

	@RequestMapping("logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:notebook/list.do";
	}
}
