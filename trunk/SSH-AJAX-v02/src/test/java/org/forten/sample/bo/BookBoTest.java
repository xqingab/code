package org.forten.sample.bo;

import java.util.Date;

import javax.annotation.Resource;

import org.forten.sample.entity.Book;
import org.forten.sample.vo.MessageVo;
import org.junit.Assert;
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
		Book book = new Book("new name", "someone", 3, new Date(), 50, 9.0);
		MessageVo vo = bo.doSave(book);
		Assert.assertEquals("书籍保存成功！", vo.getMessage());
	}
}
