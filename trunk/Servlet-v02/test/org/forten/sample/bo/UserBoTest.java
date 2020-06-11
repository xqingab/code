package org.forten.sample.bo;

import static org.junit.Assert.*;

import java.util.List;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;
import org.junit.Test;

public class UserBoTest {
	@Test
	public void testDoRegist() throws Exception {
		User user = new User("张辽", "123456", "zhl@kjl.com", "M", 40);
		int i = UserBo.doRegist(user);
		assertEquals(1, i);
	}

	@Test
	public void testQueryAll() throws Exception {
		List<User> list = UserBo.queryAll();
		// assertEquals(3, list.size());
		for (User user : list) {
			System.out.println(user);
		}
	}
}
