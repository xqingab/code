package org.forten.sample.action;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.bo.NotebookBo;
import org.forten.sample.entity.Notebook;
import org.forten.sample.qo.NotebookQo;
import org.forten.sample.ro.NotebookRoWithPage;
import org.forten.sample.vo.NotebookVoForUpdate;
import org.forten.sample.vo.NotebookVoForUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notebook")
public class NotebookAction {
	@Resource
	private NotebookBo bo;

	@RequestMapping("save")
	public String save(Notebook nb) {
		bo.doSave(nb);
		return "redirect:list.do";
	}

	@RequestMapping("list")
	public ModelAndView list() {
		// 执行后台BO中的某个业务逻辑
		List<NotebookVoForUser> voList = bo.queryForUser();

		// 封装ModelAndView
		ModelAndView mav = new ModelAndView();
		// 通知前端控制器，要跳转到的视图逻辑名称是什么
		mav.setViewName("list.jsp");
		// 把视图中所需要的数据模型放置到mav对象中
		mav.addObject("voList", voList);

		return mav;
	}

	@RequestMapping("admin/list")
	public ModelAndView listForAdmin(NotebookQo qo) {
		// 执行后台BO中的某个业务逻辑
		NotebookRoWithPage ro = bo.queryForAdmin(qo);

		// 封装ModelAndView
		ModelAndView mav = new ModelAndView();
		// 通知前端控制器，要跳转到的视图逻辑名称是什么
		mav.setViewName("list.jsp");
		// 把视图中所需要的数据模型放置到mav对象中
		mav.addObject("ro", ro);
		mav.addObject("qo", qo);

		return mav;
	}

	@RequestMapping("admin/delete")
	public String delete(int id) {
		bo.doDelete(id);
		return "redirect:list.do";
	}

	@RequestMapping("admin/gotoUpdate")
	public ModelAndView gotoUpdate(int id) {
		NotebookVoForUpdate vo = bo.queryForUpdate(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update.jsp");
		mav.addObject("vo", vo);
		return mav;
	}

	@RequestMapping("admin/update")
	public String update(NotebookVoForUpdate vo) {
		bo.doUpdate(vo);
		return "redirect:list.do";
	}
}
