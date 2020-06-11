package org.foren.sample.bo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.User;
import org.forten.sample.vo.UserAvgLevelVo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

public class UserQueryTest {
	@Test
	public void testQueryAll() throws Exception {
		Session session = HibernateUtil.getSession();
		// String hql = "FROM org.forten.sample.entity.User";
		String hql = "FROM User ORDER BY registTime DESC";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		// for (User user : list) {
		// System.out.println(user);
		// }
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testQueryLikeUsePosition() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "FROM User WHERE name LIKE ?";
		// 在HQL中使用?作为参数的占位符，在绑定值的时候是从0开始的（与JDBC从1开始是不同的）
		Query query = session.createQuery(hql);
		query.setString(0, "%张%");
		List<User> list = query.list();
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testQueryLikeUseParamName() throws Exception {
		Session session = HibernateUtil.getSession();
		// 在HQL中以:开始的部分被称为命名参数，:后的部分是参数的名称
		// 命名参数是推荐的条件查询写法
		String hql = "FROM User WHERE name LIKE :n1";
		Query query = session.createQuery(hql);
		// 可以使用参数名称进行参数值的绑定
		query.setString("n1", "%张%");
		List<User> list = query.list();
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testBetween() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(1999, 11, 31);
		Date begin = cal.getTime();
		cal.set(2000, 11, 31);
		Date end = cal.getTime();

		Session session = HibernateUtil.getSession();
		String hql = "FROM User WHERE birthday BETWEEN :b AND :e";
		Query query = session.createQuery(hql);
		query.setParameter("b", begin);
		query.setParameter("e", end);

		List<User> list = query.list();
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testGE() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "FROM User WHERE level>=:level";
		Query query = session.createQuery(hql);
		query.setParameter("level", 2);

		List<User> list = query.list();
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testNotGE() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "FROM User WHERE NOT level>=:level";
		Query query = session.createQuery(hql);
		query.setParameter("level", 2);

		List<User> list = query.list();
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testIn() throws Exception {
		Session session = HibernateUtil.getSession();
		// 使用IN时要注意，IN后的括号中是一个参数，这个参数中包括多个值，所以，参数应该是数组或容器对象
		String hql = "FROM User WHERE level IN (:ls)";
		Query query = session.createQuery(hql);
		query.setParameterList("ls", new Integer[] { 1, 3, 5, 7, 9 });

		List<User> list = query.list();
		list.forEach(System.out::println);
		HibernateUtil.close(session);
	}

	@Test
	public void testAvgLevel() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT gender,avg(level) FROM User GROUP BY gender";
		Query query = session.createQuery(hql);

		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(objects[0] + ":" + objects[1]);
		}
		HibernateUtil.close(session);
	}

	@Test
	public void testAvgLevelUseVo() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT gender,avg(level) FROM User GROUP BY gender";
		Query query = session.createQuery(hql);

		List<Object[]> list = query.list();
		List<UserAvgLevelVo> voList = new ArrayList<>();
		for (Object[] objs : list) {
			UserAvgLevelVo vo = new UserAvgLevelVo((String) objs[0], (Double) objs[1]);
			voList.add(vo);
		}
		HibernateUtil.close(session);
		voList.forEach(System.out::println);
	}

	@Test
	public void testAvgLevelUseVo2() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT new org.forten.sample.vo.UserAvgLevelVo(gender,avg(level)) FROM User GROUP BY gender";
		Query query = session.createQuery(hql);

		List<UserAvgLevelVo> voList = query.list();
		HibernateUtil.close(session);
		voList.forEach(System.out::println);
	}

	@Test
	public void testCount() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT count(id) FROM User";
		Query query = session.createQuery(hql);

		Long count = (Long) query.uniqueResult();
		System.out.println(count);
		HibernateUtil.close(session);
	}
	
	@Test
	public void testDelete() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "DELETE FROM User WHERE id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", 5);
		
		query.executeUpdate();
		
		HibernateUtil.close(session);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE User SET level=:le";
		Query query = session.createQuery(hql);
		query.setParameter("le", 5);
		
		query.executeUpdate();
		
		HibernateUtil.close(session);
	}
}
