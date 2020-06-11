package org.forten.sample.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.forten.sample.bo.SalaryBo;
import org.forten.sample.entity.Salary;
import org.forten.sample.qo.SalaryQoForAdmin;
import org.forten.sample.qo.SalaryQoForUser;
import org.forten.sample.ro.SalaryRoForUser;
import org.forten.sample.vo.LoginedVo;
import org.forten.sample.vo.SalaryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/salary")
public class SalaryAction {
	@Resource
	private SalaryBo bo;

	@RequestMapping("admin/save")
	public String save(Salary salary) {
		bo.doSave(salary);
		return "redirect:list.do";
	}

	@RequestMapping("admin/list")
	public ModelAndView list(SalaryQoForAdmin qo) {
		ModelAndView mav = new ModelAndView();
		List<SalaryVo> voList = bo.queryForAdmin(qo);
		mav.setViewName("list.jsp");
		mav.addObject("data", voList);
		mav.addObject("qo", qo);

		return mav;
	}

	@RequestMapping("admin/gotoUpdate")
	public ModelAndView gotoUpdate(long id) {
		SalaryVo vo = bo.queryBy(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update.jsp");
		mav.addObject("vo", vo);
		return mav;
	}

	@RequestMapping("admin/update")
	public String update(SalaryVo vo) {
		bo.doUpdate(vo);
		return "redirect:list.do";
	}

	@RequestMapping("admin/delete")
	public String delete(long id) {
		bo.doDelete(id);
		return "redirect:list.do";
	}

	@RequestMapping("list")
	public ModelAndView listForUser(SalaryQoForUser qo,HttpSession session) {
		LoginedVo vo = (LoginedVo) session.getAttribute("loginedVo");
		
		qo.setName(vo.getName());
		
		SalaryRoForUser ro = bo.queryForUser(qo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("ro", ro);
		mav.addObject("qo", qo);
		return mav;
	}
}
