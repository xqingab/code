package ${package};

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.forten.utils.system.BeanPropertyUtil;

import ${basePackage}.dao.HibernateDao;
import ${basePackage}.entity.${className};
import ${basePackage}.vo.${className}Vo;

@Service("${beanId}")
public class ${className}Bo {
	@Resource(name = "hibernateDao")
	private HibernateDao hibernateDao;
	
	@Transactional
	public void doSave(${className} e) {
		hibernateDao.save(e);
	}
	
	@Transactional(readOnly = true)
	public List<${className}Vo> queryAll() {
		List<${className}Vo> voList = new ArrayList<>();
		List<${className}> list = hibernateDao
				.find("FROM ${className}");
		for (${className} e : list) {
			${className}Vo vo = new ${className}Vo();
			BeanPropertyUtil.copy(vo, e);
			voList.add(vo);
		}
		return voList;
	}
	
	@Transactional
	public void doDelete(long id){
		hibernateDao.delete(${className}.class, id);
	}
	
	@Transactional(readOnly = true)
	public ${className}Vo queryById(long id) {
		${className} e = hibernateDao.findByIdUseGet(${className}.class, id);
		${className}Vo vo = new ${className}Vo();
		BeanPropertyUtil.copy(vo, e);
		return vo;
	}
	
	@Transactional
	public void doUpdate(${className}Vo vo) {
		${className} e = hibernateDao.findByIdUseLoad(${className}.class, vo.getId());
		BeanPropertyUtil.copy(e, vo);
		hibernateDao.update(e);
	}
}