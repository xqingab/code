package org.forten.sample.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Salary;
import org.forten.sample.qo.SalaryQoForAdmin;
import org.forten.sample.qo.SalaryQoForUser;
import org.forten.sample.ro.SalaryRoForUser;
import org.forten.sample.vo.SalaryVo;
import org.forten.sample.vo.SumVo;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("salaryBo")
public class SalaryBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(Salary salary) {
		dao.save(salary);
	}

	@Transactional(readOnly = true)
	public List<SalaryVo> queryForAdmin(SalaryQoForAdmin qo) {
		String hql = "SELECT new org.forten.sample.vo.SalaryVo(id,name,month,jbgz,gwjt,yjj,ylbx,zfgjj) "
				+ "FROM Salary WHERE 1=1 ";
		Map<String, Object> params = new HashMap<>();
		if (StringUtil.hasText(qo.getName())) {
			hql = hql + "AND name LIKE :n ";
			params.put("n", "%" + qo.getName() + "%");
		}
		if (StringUtil.hasText(qo.getMonth())) {
			hql = hql + "AND month LIKE :m ";
			params.put("m", "%" + qo.getMonth() + "%");
		}

		return dao.findBy(hql, params);
	}

	@Transactional(readOnly = true)
	public SalaryRoForUser queryForUser(SalaryQoForUser qo) {
		String name = Objects.requireNonNull(qo.getName(), "登录用户名为空");

		String hql = "SELECT new org.forten.sample.vo.SalaryVo(id,name,month,jbgz,gwjt,yjj,ylbx,zfgjj) "
				+ "FROM Salary WHERE name=:n ";
		String sumHql = "SELECT new org.forten.sample.vo.SumVo(sum(jbgz),sum(gwjt),sum(yjj),sum(ylbx),sum(zfgjj)) FROM Salary WHERE name=:n ";
		Map<String, Object> params = new HashMap<>();
		params.put("n", name);

		if (StringUtil.hasText(qo.getMonth())) {
			hql = hql + "AND month LIKE :m ";
			sumHql = sumHql + "AND month LIKE :m ";
			params.put("m", "%" + qo.getMonth() + "%");
		}
		if (qo.getFinalSalary() != null) {
			hql = hql + "AND (jbgz+gwjt+yjj-ylbx-zfgjj)>:f";
			sumHql = sumHql + "AND (jbgz+gwjt+yjj-ylbx-zfgjj)>:f";
			params.put("f", qo.getFinalSalary());
		}

		List<SalaryVo> data = dao.findBy(hql, params);
		SumVo sumVo = null;
		if (data.size() > 0) {
			sumVo = dao.findObjectBy(sumHql, params);
		} else {
			sumVo = new SumVo(0, 0, 0, 0, 0);
		}

		return new SalaryRoForUser(data, sumVo);
	}

	@Transactional(readOnly = true)
	public SalaryVo queryBy(long id) {
		Salary salary = dao.findByLoad(Salary.class, id);
		SalaryVo vo = new SalaryVo();
		BeanPropertyUtil.copy(vo, salary);
		return vo;
	}

	@Transactional
	public void doUpdate(SalaryVo vo) {
		Salary salary = dao.findByLoad(Salary.class, vo.getId());
		BeanPropertyUtil.copy(salary, vo);
		dao.update(salary);
	}

	@Transactional
	public void doDelete(long id) {
		dao.delete(Salary.class, id);
	}
}
