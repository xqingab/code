package org.forten.sample.action;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.bo.ProjectBo;
import org.forten.sample.entity.Project;
import org.forten.sample.vo.ProjectVo;
import org.forten.utils.system.ValidateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("project")
public class ProjectAction {
	@Resource
	private ProjectBo bo;

	@RequestMapping("save")
	public ModelAndView save(Project project) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		try {
			bo.doSave(project);
		} catch (ValidateException e) {
			mav.addObject("errMsg", e.getMessages());
		}
		return mav;
	}

	@RequestMapping("list")
	public ModelAndView list() {
		List<ProjectVo> voList = bo.queryAll();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("voList", voList);
		return mav;
	}

	@RequestMapping("delete")
	public String delete(int id) {
		bo.doDelete(id);
		return "redirect:list.do";
	}

	@RequestMapping("gotoUpdate")
	public ModelAndView gotoUpdate(int id) {
		ProjectVo vo = bo.queryForUpdate(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update.jsp");
		mav.addObject("vo", vo);
		return mav;
	}

	@RequestMapping("update")
	public ModelAndView update(ProjectVo vo) {
		ModelAndView mav = new ModelAndView();
		try {
			bo.doUpdate(vo);
			mav.setViewName("redirect:list.do");
		} catch (ValidateException e) {
			mav.setViewName("forward:gotoUpdate.do?id="+vo.getId());
			mav.addObject("errMsg", e.getMessages());
		}
		return mav;
	}
}
