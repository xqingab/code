package org.forten.sample.action;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.forten.sample.vo.MsgVo;
import org.forten.sample.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {
	@RequestMapping("listAll")
	public @ResponseBody List<UserVo> listAll() {
		List<UserVo> voList = Arrays.asList(new UserVo(1, "Tom", "283923", new Date()),
				new UserVo(2, "Mike", "28392321", new Date()), new UserVo(3, "Jack", "333333", new Date()));
		return voList;
	}

	@RequestMapping("getOne")
	public @ResponseBody UserVo getOne() {
		return new UserVo(10, "徐晃", "43893424", new Date());
	}
	
	@RequestMapping("error500")
	public @ResponseBody UserVo error500(){
		throw new RuntimeException("数据获取错误！");
	}
	@RequestMapping("timeout")
	public @ResponseBody UserVo timeout(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new UserVo(10, "徐晃", "43893424", new Date());
	}
	
	@RequestMapping("save")
	public @ResponseBody MsgVo save(@RequestBody UserVo vo){
		System.out.println(vo);
		return new MsgVo("用户保存成功");
	}
}
