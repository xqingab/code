package org.forten.sample.bo;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.entity.Room;
import org.forten.sample.vo.RoomVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/**/app-*.xml" })
public class RoomBoTest {
	@Resource
	private RoomBo bo;

	@Test
	public void testDoSave() throws Exception {
		Room room = new Room("丰台区的平房", 1500, "28292199");
		bo.doSave(room);
	}

	@Test
	public void testUpdateByHql() throws Exception {
		int i = bo.doUpdate("北京", "12345456", 50, 1);
		assertEquals(1, i);
	}
	
	@Test
	public void testQueryBy() throws Exception {
		List<RoomVo> voList = bo.queryBy("", "", null,null);
		for (RoomVo roomVo : voList) {
			System.out.println(roomVo);
		}
		
		System.out.println("==============================");
		
		voList = bo.queryBy("", "", 0,2000);
		for (RoomVo roomVo : voList) {
			System.out.println(roomVo);
		}
		
		System.out.println("==============================");
		
		voList = bo.queryBy("三", "", null,null);
		for (RoomVo roomVo : voList) {
			System.out.println(roomVo);
		}
		
		System.out.println("==============================");
		voList = bo.queryBy("", "7", null,null);
		for (RoomVo roomVo : voList) {
			System.out.println(roomVo);
		}
		
		System.out.println("==============================");
	}
}
