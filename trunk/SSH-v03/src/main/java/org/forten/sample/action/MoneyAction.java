package org.forten.sample.action;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.bo.MoneyBo;
import org.forten.sample.bo.ProjectBo;
import org.forten.sample.entity.Money;
import org.forten.sample.vo.MoneyVoForShow;
import org.forten.sample.vo.MoneyVoForUpdate;
import org.forten.sample.vo.ProjectVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/money")
public class MoneyAction {
	@Resource
	private MoneyBo bo;
	@Resource
	private ProjectBo pBo;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("list.jsp");
		// 查询保存汇款数据表单所需要的所有项目数据
		List<ProjectVo> projectVoList = pBo.queryAll();
		mav.addObject("projectVoList", projectVoList);

		List<MoneyVoForShow> voList = bo.queryForUser(2);// TODO
															// 此处的userId应该从Session中获取
		mav.addObject("voList", voList);

		return mav;
	}
	@RequestMapping("admin/list")
	public ModelAndView listForAdmin(Integer projectId) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("list.jsp");
		// 查询保存汇款数据表单所需要的所有项目数据
		List<ProjectVo> projectVoList = pBo.queryAll();
		mav.addObject("projectVoList", projectVoList);
		
		List<MoneyVoForShow> voList = bo.queryForAdmin(projectId);
		mav.addObject("voList", voList);
		
		return mav;
	}

	@RequestMapping("save")
	public String save(Money money) {
		int userId = 2;// TODO 用户的ID应该从Session中获取
		money.setUserId(userId);

		bo.doSave(money);
		return "redirect:list.do";
	}

	@RequestMapping("gotoUpdate")
	public ModelAndView gotoUpdate(int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update.jsp");
		MoneyVoForUpdate vo = bo.queryForUpdate(id);
		mav.addObject("vo", vo);
		List<ProjectVo> projectVoList = pBo.queryAll();
		mav.addObject("projectVoList", projectVoList);
		return mav;
	}
	
	@RequestMapping("admin/changeState")
	public String changeState(int id){
		bo.doChangeState(id);
		return "redirect:list.do";
	}
}
