package org.forten.sample;

import java.util.ArrayList;
import java.util.List;

import org.forten.sample.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {
	@RequestMapping("save")
	public @ResponseBody Boolean save(@RequestBody User user) {
		System.out.println(user);
		return true;
	}

	@RequestMapping("list")
	public @ResponseBody List<User> list() {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "Tom", 28, "289439489"));
		list.add(new User(2, "Mike", 23, "943939489"));
		list.add(new User(3, "吕蒙", 32, "493049"));
		list.add(new User(4, "张大军", 58, "1378883489"));
		list.add(new User(5, "刘备备", 16, "68923229"));

		return list;
	}
}
