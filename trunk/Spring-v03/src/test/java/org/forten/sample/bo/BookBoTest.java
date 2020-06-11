package org.forten.sample.bo;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.entity.Book;
import org.forten.sample.vo.BookVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/**/app-*.xml" })
public class BookBoTest {
	@Resource(name = "bookBo")
	private BookBo bo;
	
	@Test
	public void testDoSave() throws Exception {
		Book book = new Book("TestBook", "电子工业", "李纪", 56, new Date());
		bo.doSave(book);
	}
	
	@Test
	public void testDoUpdateByHql() throws Exception {
		int i = bo.doUpdate("新书", "人民大学出版社", 3000, 1);
		assertEquals(1, i);
	}
	
	@Test
	public void testQueryBy() throws Exception {
		List<BookVo> voList = bo.queryBy("", "", null,null);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		
		System.out.println("=============================");
		
		voList = bo.queryBy("J", "", null,null);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		
		System.out.println("=============================");
		
		voList = bo.queryBy("", "张", null,null);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		
		System.out.println("=============================");
		
		voList = bo.queryBy("", "", 0.0,100.0);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		
		System.out.println("=============================");
	}
}
