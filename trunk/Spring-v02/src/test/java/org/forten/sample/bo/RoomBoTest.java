package org.forten.sample.bo;

import static org.junit.Assert.*;

import java.awt.print.Printable;
import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.entity.Room;
import org.forten.sample.vo.RoomVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/**/app-*.xml" })
public class RoomBoTest {
	@Resource(name = "roomBo")
	private RoomBo bo;

	@Test
	public void testDoSave() throws Exception {
		Room room = new Room("三环两居", 5000, "18492278329");

		bo.doSave(room);
	}

	@Test
	public void testQueryBy() throws Exception {
		Room room = bo.queryBy(1);
		System.out.println(room);
	}

	@Test
	public void testQueryLazyRoomBy() throws Exception {
		Room room = bo.queryLazyRoomBy(1);
		System.out.println(room);
	}

	@Test
	public void testQueryVoBy() throws Exception {
		RoomVo vo = bo.queryVoBy(1);
		System.out.println(vo);
	}
	
	@Test
	public void testDoUpdate() throws Exception {
		bo.doUpdate("test1", 10000, "11112221111", 1);
	}
	
	@Test
	public void testDoDelete() throws Exception {
		bo.doDelete(2);
	}
	
	@Test
	public void testQueryByTitleAndTel() throws Exception {
		List<RoomVo> vl = bo.queryBy("两", "1");
		for (RoomVo vo : vl) {
			System.out.println(vo);
		}
		System.out.println("===================");
		vl=bo.queryBy("", "");
		for (RoomVo vo : vl) {
			System.out.println(vo);
		}
		System.out.println("===================");
		vl=bo.queryBy("1", "");
		for (RoomVo vo : vl) {
			System.out.println(vo);
		}
	}
}
