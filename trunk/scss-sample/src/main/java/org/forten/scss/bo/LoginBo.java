/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.scss.bo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.scss.dao.HibernateDao;
import org.forten.scss.dto.UserDtoForShow;
import org.forten.scss.entity.User;
import org.forten.utils.system.Assert;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Service("loginBo")
public class LoginBo {
	@Resource
	private HibernateDao hibernateDao;

	public UserDtoForShow authenticate(String userName, String password) {
		// 断言userName和password一定有内容，否则抛出异常
		Assert.hasText(userName);
		Assert.hasText(password);

		String hql = "FROM User u WHERE u.name=:userName AND u.password=:password";
		// 填充参数到参数Map中
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("userName", userName);
		params.put("password", password);
		// 查询实体对象
		User user = (User) hibernateDao.findUniqueResult(hql, params);
		UserDtoForShow dto = null;
		
		// 如果查询的实体对象为null说明认证失败，
		// 会返回一个id为-1,name和password为""的标识对象，
		// 此标识对象是用来说明认证失败的。
		if (user == null) {
			return UserDtoForShow.NULL_USER_DTO_FOR_SHOW;
		} else {
			dto = new UserDtoForShow(user.getId(), user.getName(),
					user.getType());
		}
		return dto;
	}
}
