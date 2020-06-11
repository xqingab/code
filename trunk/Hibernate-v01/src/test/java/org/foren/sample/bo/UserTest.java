package org.foren.sample.bo;

import static org.junit.Assert.*;

import java.util.Date;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.User;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class UserTest {
	@Test
	public void testSave() throws Exception {
		// 实例化一个实体对象，此时这个对象是自由状态（瞬时状态）
		User user = new User("张辽", "M", "山东", new Date());

		// 通过SessionFactory打开一个Session，此Session对象是Java与数据库之间的会话
		Session session = HibernateUtil.getSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 通过session对象的save方法调用，把自由状态的user对象切换为持久化状态
		session.save(user);
		// 提交事务
		tx.commit();
		// 释放资源
		HibernateUtil.close(session);
	}

	// Session接口中的load和get方法都是通过实体对象的id来得到某个具体的实例对象
	// 区别：
	// 1：get方法在没有查询到id值所对应的数据时会返回null
	// load方法在没度查询到id值所对应的数据时会抛出ObjectNotFoundException
	// 2：get方法返回实体对象本身，在执行此方法后就会触发SQL语句的执行
	// load方法返回的是实体对象的一个代理对象，这个代理对象在被第一次使用之前，每个实例变量的值都是默认值，
	// 当第一次使用对象的属性时，才会触发SQL语句的执行（延迟加载）
	// 3：get方法先从一级缓存中查询数据，如果没有，到二级缓存中进行查询，如果也不存在，到数据库中查询，还没有，返回null
	// load方法先从一级缓存中查询数据，如果没有，则生成一个实体对象代理对象，等待第一次对数据的读取，到二级缓存中进行查询
	// 如果不存在，到数据库进行查询，还不存在，抛出ObjectNotFoundException

	// load和get方法的使用场景：当试探性按id查询时，使用get；当确定一条数据一定存在时，使用load
	@Test
	public void testGetById() throws Exception {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, 1);
		System.out.println(user);
		HibernateUtil.close(session);
	}

	@Test
	public void testGetByIdWhenIdNotExist() throws Exception {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, 10);
		System.out.println(user);
		HibernateUtil.close(session);
	}

	@Test
	public void testLoadById() throws Exception {
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class, 1);
		System.out.println(user);
		HibernateUtil.close(session);
	}

	@Test
	public void testLoadByIdWhenIdNotExist() throws Exception {
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class, 10);
		System.out.println(user);
		HibernateUtil.close(session);
	}

	@Test
	public void testGetByIdAfterSessionClosed() throws Exception {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, 1);
		HibernateUtil.close(session);
		System.out.println(user);
	}

	@Test(expected = LazyInitializationException.class)
	public void testLoadByIdAfterSessionClosed() throws Exception {
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class, 1);
		HibernateUtil.close(session);
		System.out.println(user);
		fail("期待抛出LazyInitializationException，而你却没做到");
	}

	@Test
	public void testUpdate() throws Exception {
		Session session = HibernateUtil.getSession();

		User user = session.load(User.class, 1);
		user.setGender("男");
		user.setHometown("法国");

		Transaction tx = session.beginTransaction();
		// 为什么不调用update也可以更新数据？
		// 因为user目前的状态是持久化的，所以不用显式的调用update方法就可以把数据的改变关联到DB上
		// session.update(user);
		tx.commit();
		HibernateUtil.close(session);
	}
	@Test
	public void testUpdate2() throws Exception {
		Session session = HibernateUtil.getSession();
		
		User user = session.get(User.class, 1);
		HibernateUtil.close(session);
		
		user.setGender("男");
		user.setHometown("法国");
		
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		HibernateUtil.close(session);
	}
	
	@Test
	public void testDelete() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = session.load(User.class, 1);
		session.delete(user);
		tx.commit();
		HibernateUtil.close(session);
	}
}
