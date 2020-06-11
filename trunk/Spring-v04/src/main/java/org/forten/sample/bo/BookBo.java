package org.forten.sample.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Book;
import org.forten.sample.util.StringUtil;
import org.forten.sample.vo.BookVo;
import org.forten.sample.vo.BookVoForUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookBo")
public class BookBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(Book book) {
		dao.save(Objects.requireNonNull(book));
	}

	@Transactional
	public void doDelete(int id) {
		dao.delete(Book.class, id);
	}

	@Transactional(readOnly = true)
	public List<BookVo> queryBy(String name, String publisher, Double min, Double max) {
		String hql = "SELECT new "
				+ "org.forten.sample.vo.BookVo(id,name,author,publisher,price,discount,pubDate,createTime) "
				+ "FROM Book WHERE 1=1 ";
		Map<String, Object> params = new HashMap<>();

		if (!StringUtil.isEmpty(name)) {
			hql = hql + "AND name LIKE :name ";
			params.put("name", "%" + name + "%");
		}
		if (!StringUtil.isEmpty(publisher)) {
			hql = hql + "AND publisher LIKE :publisher ";
			params.put("publisher", "%" + publisher + "%");
		}
		if (min != null && max != null) {
			hql = hql + "AND price BETWEEN :min AND :max ";
			params.put("min", min);
			params.put("max", max);
		}

		return dao.findBy(hql, params);
	}

	@Transactional(readOnly = true)
	public BookVoForUpdate queryForUpdate(int id) {
		Book book = dao.findByLoad(Book.class, id);
		BookVoForUpdate vo = new BookVoForUpdate();
		vo.setAuthor(book.getAuthor());
		vo.setId(book.getId());
		vo.setName(book.getName());
		vo.setPrice(book.getPrice());
		vo.setPublisher(book.getPublisher());

		return vo;
	}
	
	@Transactional
	public void doUpdate(BookVoForUpdate vo){
		Book book = dao.findByLoad(Book.class, vo.getId());
		book.setAuthor(vo.getAuthor());
		book.setName(vo.getName());
		book.setPublisher(vo.getPublisher());
		book.setPrice(vo.getPrice());
		
		dao.update(book);
	}
}
