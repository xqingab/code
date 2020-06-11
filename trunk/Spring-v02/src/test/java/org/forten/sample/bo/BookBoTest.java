package org.forten.sample.bo;

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
		Book book = new Book("Java教程", "电子工业", "张良", 83, new Date());

		bo.doSave(book);
	}

	@Test
	public void testQueryBy() throws Exception {
		Book book = bo.queryBy(1);
		System.out.println(book);
	}

	@Test
	public void testQueryLazyBookBy() throws Exception {
		Book book = bo.queryLazyBookBy(1);
		System.out.println(book);
	}

	@Test
	public void testQueryVoBy() throws Exception {
		BookVo vo = bo.queryVoBy(1);
		System.out.println(vo);
	}

	@Test
	public void testDoUpdate() throws Exception {
		bo.doUpdate("C++", 100, "人民邮电", 1);
	}

	@Test
	public void testDoDelete() throws Exception {
		bo.doDelete(7);
	}

	@Test
	public void testQueryByNameAndPublisher() throws Exception {
		List<BookVo> vl = bo.queryBy("J", "出版社");
		for (BookVo vo : vl) {
			System.out.println(vo);
		}
		System.out.println("===================");
		vl = bo.queryBy("", "");
		for (BookVo vo : vl) {
			System.out.println(vo);
		}
		System.out.println("===================");
		vl = bo.queryBy("", "人民");
		for (BookVo vo : vl) {
			System.out.println(vo);
		}
	}
}
