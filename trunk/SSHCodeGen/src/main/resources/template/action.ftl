package ${package};

import java.util.List;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import ${basePackage}.bo.${className}Bo;
import ${basePackage}.entity.${className};
import ${basePackage}.vo.${className}Vo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;


@Controller
@RequestMapping("/${pathMapping}")
public class ${className}Action {
	@Resource(name = "${beanId}")
	private ${className}Bo bo;
	
	@RequestMapping("gotoSave")
	public String gotoSave() {
		return "${pathMapping}/save";
	}

	@RequestMapping("save")
	public String save(${className} e) {
		bo.doSave(e);
		return "redirect:listAll.do";
	}
	
	@RequestMapping("gotoUpdate")
	public ModelAndView gotoUpdate(@RequestParam long id) {
		ModelAndView mav = new ModelAndView();
		${className}Vo vo = bo.queryById(id);
		mav.setViewName("${pathMapping}/update");
		mav.addObject("vo", vo);
		return mav;
	}

	@RequestMapping("update")
	public String update(${className}Vo vo) {
		bo.doUpdate(vo);
		return "redirect:listAll.do";
	}
	
	@RequestMapping("delete")
	public String update(long id) {
		bo.doDelete(id);
		return "redirect:listAll.do";
	}
	
	@RequestMapping("listAll")
	public ModelAndView listForUser() {
		ModelAndView mav = new ModelAndView();
		List<${className}Vo> voList = bo.queryAll();
		mav.setViewName("${pathMapping}/list-all");
		mav.addObject("voList", voList);
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}