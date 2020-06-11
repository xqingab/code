/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.scss.bo;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.forten.scss.dto.CourseDtoForSelectionInfo;
import org.forten.scss.dto.CourseDtoForShow;
import org.junit.Test;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
public class CourseBoTest extends BaseTest {
	@Resource
	private CourseBo courseBo;

	@Test
	public void testQueryAll() throws Exception {
		List<CourseDtoForShow> list = courseBo.queryAll();
		assertEquals(7, list.size());
		assertEquals(7, list.get(0).getId());
	}

	@Test
	public void testQueryNotSelectedCourse() throws Exception {
		List<CourseDtoForShow> list = courseBo.queryNotSelectedCourse(1);
		assertEquals(1, list.size());
		assertEquals(7, list.get(0).getId());
	}
	
	@Test
	public void testQuerySelectionInfo() throws Exception {
		List<CourseDtoForSelectionInfo> list = courseBo.querySelectionInfo();
		for (CourseDtoForSelectionInfo dto : list) {
			System.out.println(dto);
		}
		assertEquals(6, list.size());
	}
}
