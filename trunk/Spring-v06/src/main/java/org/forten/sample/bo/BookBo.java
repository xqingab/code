package org.forten.sample.bo;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Book;
import org.springframework.stereotype.Service;

@Service("bookBo")
public class BookBo {
	@Resource
	private HibernateDao dao;

	public void doSave(Book book) {
		dao.save(book);
	}

	public Book queryBy(int id) {
		return dao.findByGet(Book.class, id);
	}
	
	public void doDelete(int id){
		dao.delete(Book.class, id);
	}
}
