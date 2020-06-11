package org.forten.sample;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.Country;
import org.forten.sample.entity.General;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.action.internal.CollectionUpdateAction;
import org.junit.Before;
import org.junit.Test;

public class ManyToOneTest {
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

		wei = new Country(1, "魏国");
		shu = new Country(2, "蜀国");
		wu = new Country(3, "吴国");

		zl = new General(1, "张辽");
		xh = new General(2, "徐晃");
		yj = new General(3, "于禁");
		gy = new General(4, "关羽");
		zf = new General(5, "张飞");
		zy = new General(6, "赵云");
		hg = new General(7, "黄盖");
		df = new General(8, "丁奉");
		xs = new General(9, "徐盛");

		wei.addGenerals(zl, xh, yj);
		shu.addGenerals(gy, zf, zy);
		wu.addGenerals(hg, df, xs);

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		session.save(zl);

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

		// gy.removeFrom(shu);
		shu.removeGenerals(gy);
		session.delete(gy);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testCountryOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Set<General> gSet = shu.getGeneralSet();
		for (General g : gSet) {
			g.setCountry(null);
			session.update(g);
		}
		shu.setGeneralSet(null);
		session.delete(shu);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
		System.out.println(gy);
		System.out.println(zf);
		System.out.println(zy);
	}

	@Test
	public void testYjSurrender() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		yj.removeFrom(wei);
		yj.addTo(shu);

		session.update(yj);
		
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
}
