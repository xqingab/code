package org.forten.sample.dao;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDao {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void save(Book book) {
		Session session = getSession();
		session.save(book);
	}

	public Book findByGet(int id) {
		Session session = getSession();
		Book book = session.get(Book.class, id);
		return book;
	}

	public Book findByLoad(int id) {
		Session session = getSession();
		Book book = session.load(Book.class, id);
		return book;
	}

	public void update(Book book) {
		Session session = getSession();
		session.update(book);
	}

	public void update(String name, String publisher, double price, int id) {
		String hql = "UPDATE Book SET name=:name,price=:price,publisher=:publisher WHERE id=:id";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("price", price);
		query.setParameter("publisher", publisher);
		query.setParameter("id", id);

		query.executeUpdate();
	}

	// public void delete(int id) {
	// Session session = getSession();
	// Book book = session.load(Book.class, id);
	// session.delete(book);
	// }

	public void delete(int id) {
		String hql = "DELETE FROM Book WHERE id=:id";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		query.executeUpdate();
	}

	public List<Book> findBy(String name, String publisher) {
		Session session = getSession();
		String hql = "FROM Book WHERE 1=1 ";
		if (name != null && name.trim().length() > 0) {
			hql = hql + "AND name LIKE :name ";
		}
		if (publisher != null && publisher.trim().length() > 0) {
			hql = hql + "AND publisher LIKE :publisher ";
		}

		Query query = session.createQuery(hql);
		if (name != null && name.trim().length() > 0) {
			query.setParameter("name", "%" + name + "%");
		}
		if (publisher != null && publisher.trim().length() > 0) {
			query.setParameter("publisher", "%" + publisher + "%");
		}
		List<Book> list = query.list();

		return list;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
