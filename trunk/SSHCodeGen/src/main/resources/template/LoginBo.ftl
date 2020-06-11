package ${basePackage}.bo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import ${basePackage}.dao.HibernateDao;
import ${basePackage}.entity.TestUser;
import ${basePackage}.vo.UserVoForLogin;
import org.forten.utils.system.BeanPropertyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginBo")
public class LoginBo {
	@Resource
	private HibernateDao hibernateDao;

	@Transactional(readOnly = true)
	public UserVoForLogin login(String name, String pwd) {
		String hql = "FROM TestUser WHERE name=:n AND password=:p";
		Map<String, Object> params = new HashMap<>();
		params.put("n", name);
		params.put("p", pwd);

		TestUser user = hibernateDao.findObjectBy(hql, params);
		if (user == null) {
			return null;
		}
		UserVoForLogin vo = new UserVoForLogin();
		BeanPropertyUtil.copy(vo, user);

		return vo;
	}
}
