package org.forten.sample.bo;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Project;
import org.forten.sample.vo.ProjectVo;
import org.forten.utils.system.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("projectBo")
public class ProjectBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(Project project) {
		ValidateUtil.validateThrow(project);
		dao.save(project);
	}

	@Transactional(readOnly = true)
	public List<ProjectVo> queryAll() {
		String hql = "SELECT new org.forten.sample.vo.ProjectVo(id,name) FROM Project ORDER BY id DESC";
		return dao.findBy(hql);
	}

	@Transactional
	public void doDelete(int id) {
		dao.delete(Project.class, id);
	}

	@Transactional(readOnly = true)
	public ProjectVo queryForUpdate(int id) {
		Project p = dao.findByLoad(Project.class, id);
		return new ProjectVo(p.getId(), p.getName());
	}

	@Transactional
	public void doUpdate(ProjectVo vo) {
		ValidateUtil.validateThrow(vo);
		Project p = dao.findByLoad(Project.class, vo.getId());
		p.setName(vo.getName());
		dao.update(p);
	}
}
