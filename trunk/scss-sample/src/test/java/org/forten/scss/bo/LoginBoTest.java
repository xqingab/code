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

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.forten.scss.dto.UserDtoForShow;
import org.junit.Test;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
public class LoginBoTest extends BaseTest {
	@Resource
	private LoginBo loginBo;

	@Test
	public void testAuthenticate() throws Exception {
		UserDtoForShow dto = loginBo.authenticate("李学燕", "123456");
		assertEquals(1, dto.getId());
		assertEquals("李学燕", dto.getName());
		assertEquals("S", dto.getType());
		
		dto = loginBo.authenticate("abc", "ddd");
		assertEquals(UserDtoForShow.NULL_USER_DTO_FOR_SHOW, dto);
	}
}
