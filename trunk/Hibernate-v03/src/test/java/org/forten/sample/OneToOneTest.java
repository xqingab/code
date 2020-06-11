package org.forten.sample;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.Husband;
import org.forten.sample.entity.Wife;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class OneToOneTest {
	private Husband husband;
	private Wife idealWife;
	private Wife realWife;

	@Before
	public void init() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("DELETE FROM Husband").executeUpdate();
		session.createQuery("DELETE FROM Wife").executeUpdate();
		tx.commit();
		HibernateUtil.close(session);

		idealWife = new Wife(1, "林黛玉", 17);
		realWife = new Wife(2, "薛宝钗", 19);
		// 无论是一对一、一对多、多对多哪种关系，只要是双向的，就建议双方都对关系进制维护，保证实体对象世界中的数据完整性
		// wife对象与husband对象进行关系建立
		husband = new Husband(1, "贾宝玉", 18, idealWife);
		// husband对象与wife对象进行关系建立
		idealWife.setHusband(husband);

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		session.save(husband);
		session.save(realWife);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testSave() throws Exception {
		System.out.println(husband.getWife());
		System.out.println(idealWife.getHusband());
	}
	
	@Test
	public void testHusbandOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(husband);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testOnlyHusbandOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		husband.getWife().setHusband(null);
		husband.setWife(null);
		session.delete(husband);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testWifeOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		idealWife.getHusband().setWife(null);
		idealWife.setHusband(null);
		session.update(husband);
		session.delete(idealWife);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testMarryWithRealWife() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		idealWife.setHusband(null);
		husband.setWife(realWife);
		realWife.setHusband(husband);
		
		session.update(husband);
		
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testFindJBYWifeName() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT w.name FROM Wife w WHERE w.husband.name=:n";
		Query query = session.createQuery(hql);
		query.setParameter("n", "贾宝玉");
		String wName= (String) query.uniqueResult();
		System.out.println(wName);

		HibernateUtil.close(session);
		System.out.println("============================");
	}
}
