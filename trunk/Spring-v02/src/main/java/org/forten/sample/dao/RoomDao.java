package org.forten.sample.dao;

import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.entity.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

// 声明此类的一个Bean
// 在Dao层，应该使用@Repository注解对Bean进行声明
// 此Bean的id是roomDao
@Repository("roomDao")
public class RoomDao {
	// 注入此Bean所依赖的其它Bean
	// 如果被注入的Bean的id与实例变量名一致，或在IoC容器中只有一个被注入类型的Bean
	// 则可以省略(name="xxx")
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void save(Room room) {
		Session session = getSession();
		session.save(room);
	}

	public Room findByGet(int id) {
		Session session = getSession();
		Room room = session.get(Room.class, id);
		return room;
	}

	public Room findByLoad(int id) {
		Session session = getSession();
		Room room = session.load(Room.class, id);
		return room;
	}

	public void update(Room room) {
		Session session = getSession();
		session.update(room);
	}

	public void update(String title, String tel, int price, int id) {
		String hql = "UPDATE Room SET title=:title,price=:price,tel=:tel WHERE id=:id";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter("title", title);
		query.setParameter("price", price);
		query.setParameter("tel", tel);
		query.setParameter("id", id);

		query.executeUpdate();
	}

//	public void delete(int id) {
//		Session session = getSession();
//		Room room = session.load(Room.class, id);
//		session.delete(room);
//	}
	
	public void delete(int id){
		String hql = "DELETE FROM Room WHERE id=:id";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		query.executeUpdate();
	}
	
	public List<Room> findBy(String title,String tel){
		Session session = getSession();
		String hql = "FROM Room WHERE 1=1 ";
		if(title!=null&&title.trim().length()>0){
			hql = hql +"AND title LIKE :title ";
		}
		if(tel!=null&&tel.trim().length()>0){
			hql = hql +"AND tel LIKE :tel ";
		}
		
		Query query = session.createQuery(hql);
		if(title!=null&&title.trim().length()>0){
			query.setParameter("title", "%"+title+"%");
		}
		if(tel!=null&&tel.trim().length()>0){
			query.setParameter("tel", "%"+tel+"%");
		}
		List<Room> list = query.list();
		
		return list;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
