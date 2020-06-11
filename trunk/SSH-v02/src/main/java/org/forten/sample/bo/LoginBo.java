package org.forten.sample.bo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.sample.dao.JDBCDao;
import org.forten.sample.vo.LoginedVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginBo")
public class LoginBo {
	@Resource
	private JDBCDao dao;

	@Transactional(readOnly = true)
	public LoginedVo login(String name, String password) {
		String sql = "SELECT id,name,role_name FROM test_user WHERE name=:n AND password=:p";
		Map<String, Object> params = new HashMap<>();
		params.put("n", name);
		params.put("p", password);

		return dao.findSingleObjectBy(sql, params, (rs, rn) -> {
			LoginedVo vo = new LoginedVo();
			vo.setId(rs.getInt("id"));
			vo.setName(rs.getString("name"));
			vo.setRoleName(rs.getString("role_name"));
			return vo;
		});
	}
}
