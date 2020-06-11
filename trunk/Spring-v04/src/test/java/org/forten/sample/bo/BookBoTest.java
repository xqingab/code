package org.forten.sample.bo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.entity.Book;
import org.forten.sample.vo.BookVo;
import org.forten.sample.vo.BookVoForUpdate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/**/app-*.xml" })
public class BookBoTest {
	@Resource
	private BookBo bo;

	@Test
	public void testDoSave() throws Exception {
		Book book = new Book("Thinkpad使用手册", "联想", "联想出版社", 10, 9.0, new Date());
		bo.doSave(book);
	}

	@Test(expected = NullPointerException.class)
	public void testDoSaveNullBook() throws Exception {
		bo.doSave(null);
		Assert.fail("NullPointerException未出现");
	}

	@Test
	public void testDoDelete() throws Exception {
		bo.doDelete(9);
	}

	@Test
	public void testQueryBy() throws Exception {
		List<BookVo> voList = bo.queryBy(null, "  ", null, null);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		System.out.println("============================");
		voList = bo.queryBy("a", "  ", null, null);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		System.out.println("============================");
		voList = bo.queryBy(null, "人", null, null);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		System.out.println("============================");
		voList = bo.queryBy(null, "  ", 100.0, 1000.0);
		for (BookVo bookVo : voList) {
			System.out.println(bookVo);
		}
		System.out.println("============================");
	}

	@Test
	public void testQueryForUpdate() throws Exception {
		BookVoForUpdate vo = bo.queryForUpdate(1);
		System.out.println(vo);
	}
	
	@Test
	public void testDoUpdate() throws Exception {
		BookVoForUpdate vo = new BookVoForUpdate(1, "辞海", "老舍", "人民文学", 150);
		
		bo.doUpdate(vo);
	}
}
