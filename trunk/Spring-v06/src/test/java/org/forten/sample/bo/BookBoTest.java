package org.forten.sample.bo;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.forten.sample.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/spring/**/app-*.xml"})
public class BookBoTest {
	@Resource
	private BookBo bo;
	
	@Test
	public void testDoSave() throws Exception {
		Book book = new Book(1, "Java基础教程");
		bo.doSave(book);
	}
	
	@Test
	public void testQuery() throws Exception {
		Book book = bo.queryBy(1);
		System.out.println(book);
	}
	
	@Test
	public void testDoDelete() throws Exception {
		bo.doDelete(1);
		Book book = bo.queryBy(1);
		System.out.println(book);
	}
}
