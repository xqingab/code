package org.forten.sample.bo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Book;
import org.forten.sample.vo.BookVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookBo")
public class BookBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(Book book) {
		dao.save(book);
	}

	@Transactional
	public int doUpdate(String name, String publisher, double price, int id) {
		String hql = "UPDATE Book SET name=:n,publisher=:p,price=:pr WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("n", name);
		params.put("p", publisher);
		params.put("pr", price);
		params.put("id", id);

		return dao.executeUpdate(hql, params);
	}

	@Transactional
	public List<BookVo> queryBy(String name, String author, Double minPrice, Double maxPrice) {
		String hql = "SELECT new org.forten.sample.vo.BookVo(id,name,publisher,author,price,pubDate,createTime)"
				+ " FROM Book WHERE 1=1 ";
		Map<String, Object> params = new HashMap<>();
		if (name != null && name.trim().length() > 0) {
			hql = hql + "AND name LIKE :n ";
			params.put("n", "%" + name + "%");
		}
		if (author != null && author.trim().length() > 0) {
			hql = hql + "AND author LIKE :a ";
			params.put("a", "%" + author + "%");
		}
		if (minPrice != null && maxPrice != null) {
			hql = hql + "AND price BETWEEN :p1 AND :p2 ";
			params.put("p1", minPrice);
			params.put("p2", maxPrice);
		}

		return dao.findBy(hql, params);
	}
}
