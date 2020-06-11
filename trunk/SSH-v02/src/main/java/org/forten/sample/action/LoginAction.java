package org.forten.sample.action;

import javax.annotation.Resource;

import org.forten.sample.bo.LoginBo;
import org.forten.sample.vo.LoginedVo;
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
		LoginedVo vo = bo.login(name, password);
		ModelAndView mav = new ModelAndView();
		if (vo == null) {
			mav.setViewName("login.jsp");
			mav.addObject("msg", "登录失败");
		} else {
			mav.addObject("loginedVo", vo);
			if (vo.isAdminRole()) {
				mav.setViewName("redirect:salary/admin/list.do");
			} else {
				mav.setViewName("redirect:salary/list.do");
			}
		}
		return mav;
	}

	@RequestMapping("logout")
	public ModelAndView logout(SessionStatus session) {
		session.setComplete();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login.jsp");
		mav.addObject("msg", "您已退出系统");
		return mav;
	}
}
