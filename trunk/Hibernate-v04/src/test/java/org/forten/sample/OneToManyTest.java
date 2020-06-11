package org.forten.sample;

import static org.junit.Assert.*;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.Country;
import org.forten.sample.entity.General;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class OneToManyTest {
	private Country wei;
	private Country shu;
	private Country wu;

	private General zl;
	private General xh;
	private General yj;

	private General gy;
	private General zf;
	private General zy;

	private General hg;
	private General df;
	private General xs;

	@Before
	public void init() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("DELETE FROM General").executeUpdate();
		session.createQuery("DELETE FROM Country").executeUpdate();
		tx.commit();
		HibernateUtil.close(session);

		zl = new General(1, "张辽");
		xh = new General(2, "徐晃");
		yj = new General(3, "于禁");
		gy = new General(4, "关羽");
		zf = new General(5, "张飞");
		zy = new General(6, "赵云");
		hg = new General(7, "黄盖");
		df = new General(8, "丁奉");
		xs = new General(9, "徐盛");

		wei = new Country(1, "魏国", zl, xh, yj);
		shu = new Country(2, "蜀国", gy, zf, zy);
		wu = new Country(3, "吴国", hg, df, xs);

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		session.save(wei);
		session.save(shu);
		session.save(wu);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testSave() throws Exception {

	}

	@Test
	public void testGeneralOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		shu.removeGenerals(gy);
		session.delete(gy);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println(shu.getGeneralSet().size());
		System.out.println("============================");
	}

	@Test
	public void testCountryOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(shu);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testOnlyCountryOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		shu.setGeneralSet(null);
		session.delete(shu);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testYjSurrender() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		wei.removeGenerals(yj);
		shu.addGenerals(yj);
		session.update(shu);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
		System.out.println(wei.getGeneralSet().size());
		System.out.println(shu.getGeneralSet().size());
	}
}
