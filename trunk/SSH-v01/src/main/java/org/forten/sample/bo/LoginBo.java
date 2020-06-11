package org.forten.sample.bo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.sample.dao.JDBCDao;
import org.forten.sample.vo.LoginedUserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginBo")
public class LoginBo {
	@Resource
	private JDBCDao dao;

	@Transactional(readOnly = true)
	public LoginedUserVo login(String name, String password) {
		String sql = "SELECT id,name,role_name " + "FROM test_user WHERE name=:n AND password=:p";
		Map<String, Object> params = new HashMap<>(2);
		params.put("n", name);
		params.put("p", password);

		// return dao.findSingleObjectBy(sql, params, new
		// RowMapper<LoginedUserVo>() {
		//
		// @Override
		// public LoginedUserVo mapRow(ResultSet rs, int rowNum) throws
		// SQLException {
		// LoginedUserVo vo = new LoginedUserVo();
		// vo.setId(rs.getInt("id"));
		// vo.setName(rs.getString("name"));
		// vo.setRoleName(rs.getString("role_name"));
		// return vo;
		// }
		// });
		return dao.findSingleObjectBy(sql, params, (rs, rowNum) -> {
			LoginedUserVo vo = new LoginedUserVo();
			vo.setId(rs.getInt("id"));
			vo.setName(rs.getString("name"));
			vo.setRoleName(rs.getString("role_name"));
			return vo;
		});

	}
}
