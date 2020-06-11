package org.forten.sample.bo;

import java.util.Arrays;
import java.util.List;

import org.forten.sample.aspect.PrintLog;
import org.springframework.stereotype.Service;

@Service("bookBo")
public class BookBo {
	@PrintLog
	public void doSave() {
		System.out.println("正在保存数据...");
	}

	@PrintLog
	public List<Integer> query() {
		System.out.println("正在查询数据...");
		return Arrays.asList(1, 2, 3);
	}
	
	@PrintLog
	public void doException(){
		System.err.println(1/0);
	}
}
