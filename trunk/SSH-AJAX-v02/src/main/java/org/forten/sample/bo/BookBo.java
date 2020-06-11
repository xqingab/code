package org.forten.sample.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Book;
import org.forten.sample.qo.BookQo;
import org.forten.sample.qo.RoWithPage;
import org.forten.sample.vo.BookVo;
import org.forten.sample.vo.BookVoForUpdate;
import org.forten.sample.vo.FastEditNameVo;
import org.forten.sample.vo.MessageVo;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookBo")
public class BookBo {
	private static final Logger log = Logger.getLogger(BookBo.class);

	@Resource
	private HibernateDao dao;

	@Transactional(readOnly = true)
	public RoWithPage<BookVo> queryBy(BookQo qo) {
		// 用于查询数据的HQL
		String hql = "SELECT new org.forten.sample.vo.BookVo(id,name,author,type,pubDate,price,discount) "
				+ "FROM Book WHERE 1=1 ";
		// 用于统计数据总数的HQL
		String countHql = "SELECT count(id) FROM Book WHERE 1=1 ";
		Map<String, Object> params = new HashMap<>();

		String name = qo.getName();
		String author = qo.getAuthor();
		Integer type = qo.getType();
		Integer pageNo = qo.getPageNo();
		Integer pageSize = qo.getPageSize();

		if (StringUtil.hasText(name)) {
			hql = hql + "AND name LIKE :name ";
			countHql = countHql + "AND name LIKE :name ";
			params.put("name", "%" + name + "%");
		}
		if (StringUtil.hasText(author)) {
			hql = hql + "AND author LIKE :author ";
			countHql = countHql + "AND author LIKE :author ";
			params.put("author", "%" + author + "%");
		}
		if (type != null) {
			hql = hql + "AND type=:type ";
			countHql = countHql + "AND type=:type ";
			params.put("type", type);
		}

		// 进行数据统计
		long count = dao.findObjectBy(countHql, params);
		if (count == 0) {
			return new RoWithPage<>();
		}

		hql = hql + "ORDER BY " + qo.getOrderField() + " " + qo.getOrderType();

		// 计算分页信息
		PageInfo page = PageInfo.getInstance(pageNo, pageSize, count);

		List<BookVo> dataList = dao.findBy(hql, params, (int) page.getFirstResultNum(), page.getPageSize());

		return new RoWithPage<>(dataList, page);
	}

	@Transactional
	public MessageVo doSave(Book book) {
		try {
			dao.save(book);
			return new MessageVo("书籍保存成功！");
		} catch (Exception e) {
			log.error("保存书籍时出错！", e);
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			return new MessageVo("保存书籍失败！");
		}
	}

	@Transactional
	public MessageVo doDelete(Integer... ids) {
		try {
			String hql = "DELETE FROM Book WHERE id IN (:id)";
			Map<String, Object> params = new HashMap<>();
			params.put("id", ids);
			dao.executeUpdate(hql, params);
			return new MessageVo("书籍删除成功！");
		} catch (Exception e) {
			log.error("书籍删除时出错！", e);
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			return new MessageVo("书籍删除失败！");
		}
	}

	@Transactional
	public MessageVo doUpdate(BookVoForUpdate vo) {
		try {
			Book book = dao.findByLoad(Book.class, vo.getId());
			BeanPropertyUtil.copy(book, vo);
			dao.update(book);
			return new MessageVo("书籍修改成功！");
		} catch (Exception e) {
			log.error("书籍修改时出错！", e);
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			return new MessageVo("书籍修改失败！");
		}
	}

	@Transactional(readOnly = true)
	public Workbook exportData() {
		String hql = "SELECT new org.forten.sample.vo.BookVo(id,name,author,type,pubDate,price,discount) "
				+ "FROM Book ORDER BY id";
		List<BookVo> voList = dao.findBy(hql);

		// 准备导出Excel数据
		// Excel2003格式所对应的Workbook对象
		Workbook wb = new HSSFWorkbook();
		// Excel2007格式所对应的Workbook对象
		// wb = new XSSFWorkbook();

		// 在Workbook对象中创建一个sheet
		Sheet sheet = wb.createSheet("书籍信息");

		// 在sheet中创建表头行
		Row header = sheet.createRow(0);

		// 创建表头中各单元格中的数据
		header.createCell(0).setCellValue("序号");
		header.createCell(1).setCellValue("名称");
		header.createCell(2).setCellValue("作者");
		header.createCell(3).setCellValue("出版时间");
		header.createCell(4).setCellValue("类型");
		header.createCell(5).setCellValue("价格");
		header.createCell(6).setCellValue("折扣");
		header.createCell(7).setCellValue("折扣价");

		// 数据行的生成
		for (BookVo vo : voList) {
			Row dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(sheet.getLastRowNum());
			dataRow.createCell(1).setCellValue(vo.getName());
			dataRow.createCell(2).setCellValue(vo.getAuthor());
			dataRow.createCell(3).setCellValue(vo.getPubDateStr());
			dataRow.createCell(4).setCellValue(vo.getTypeStr());
			dataRow.createCell(5).setCellValue(vo.getPrice());
			dataRow.createCell(6).setCellValue(vo.getDiscount());
			dataRow.createCell(7).setCellValue(vo.getFinalPrice());
		}

		return wb;
	}

	@Transactional
	public boolean doFastEditName(FastEditNameVo vo) {
		String hql = "UPDATE Book SET name=:n WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("n", vo.getName());
		params.put("id", vo.getId());
		try {
			dao.executeUpdate(hql, params);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
