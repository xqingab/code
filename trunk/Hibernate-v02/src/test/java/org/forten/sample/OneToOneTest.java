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
		husband = new Husband(1, "贾宝玉", 18, idealWife);

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
		// 如果不想因为主控方的被删除而级联删除掉被控方数据，则应该在执行删除前把双方的关系解除
		// 解除husband和wife两个实体对象之间的关系
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
		husband.setWife(null);
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
		husband.setWife(realWife);
		session.update(husband);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testFindLDYHusband() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT h.name FROM Husband h WHERE h.wife.name=:wn";
		Query query = session.createQuery(hql);
		query.setParameter("wn", "林黛玉");
		String hName= (String) query.uniqueResult();
		System.out.println(hName);

		HibernateUtil.close(session);
		System.out.println("============================");
	}
}
