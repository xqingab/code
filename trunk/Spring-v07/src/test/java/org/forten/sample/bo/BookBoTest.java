package org.forten.sample.bo;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

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
		bo.doSave();
	}
	
	@Test
	public void testQuery() throws Exception {
		List<Integer> list = bo.query();
		System.out.println(list);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testName() throws Exception {
		bo.doException();
	}
}