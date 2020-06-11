package ${basePackage}.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import ${basePackage}.bo.LoginBo;
import ${basePackage}.vo.UserVoForLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@Resource
	private LoginBo loginBo;

	@RequestMapping("gotoLogin")
	public String gotoLogin() {
		return "login/login";
	}

	@RequestMapping("login")
	public String login(@RequestParam String name, @RequestParam String pwd,
			HttpSession session) {
		UserVoForLogin vo = loginBo.login(name, pwd);
		if (vo == null) {
			return "redirect:gotoLogin.do";
		}
		session.setAttribute("userVo", vo);
		if (vo.getRoleName().equals("A")) {
			return "redirect:../XXX/xxx.do";
		} else {
			return "redirect:../ZZZ/zzz.do";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("userVo");
		return "redirect:gotoLogin.do";
	}
}
