package org.forten.sample.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.forten.sample.bo.BookBo;
import org.forten.sample.entity.Book;
import org.forten.sample.qo.BookQo;
import org.forten.sample.qo.RoWithPage;
import org.forten.sample.vo.BookVo;
import org.forten.sample.vo.BookVoForUpdate;
import org.forten.sample.vo.FastEditNameVo;
import org.forten.sample.vo.MessageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookAction {
	@Resource
	private BookBo bo;
	
	@RequestMapping("list")
	public @ResponseBody RoWithPage<BookVo> list(@RequestBody BookQo qo){
		RoWithPage<BookVo> ro =bo.queryBy(qo);
		return ro;
	}
	
	@RequestMapping("save")
	public @ResponseBody MessageVo save(@RequestBody Book book){
		return bo.doSave(book);
	}
	
	@RequestMapping("delete")
	public @ResponseBody MessageVo delete(@RequestBody Integer... ids){
		return bo.doDelete(ids);
	}
	
	@RequestMapping("update")
	public @ResponseBody MessageVo update(@RequestBody BookVoForUpdate vo){
		return bo.doUpdate(vo);
	}
	
	@RequestMapping("editName")
	public @ResponseBody Boolean editName(@RequestBody FastEditNameVo vo){
		return bo.doFastEditName(vo);
	}
	
	@RequestMapping("export")
	public void export(HttpServletResponse response){
		try(OutputStream out = response.getOutputStream();Workbook wb = bo.exportData();){
			response.setContentType("application/x-msexcel");
			response.setHeader("Content-Disposition", "attachment;filename=book.xls");
			wb.write(out);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
