package org.forten.sample;

import static org.junit.Assert.*;

import java.util.List;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.General;
import org.forten.sample.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class ManyToManyTest {
	private Role admin;
	private Role manager;
	private Role general;

	private General cc;

	private General zl;
	private General xh;
	private General xc;

	private General cy;
	private General gj;

	@Before
	public void init() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("DELETE FROM General").executeUpdate();
		session.createQuery("DELETE FROM Role").executeUpdate();
		tx.commit();
		HibernateUtil.close(session);

		admin = new Role(1, "主公");
		manager = new Role(2, "谋士");
		general = new Role(3, "武将");

		cc = new General(1, "曹操");
		zl = new General(2, "张辽");
		xh = new General(3, "徐晃");
		xc = new General(4, "许褚");
		cy = new General(5, "程昱");
		gj = new General(6, "郭嘉");

		cc.getRoleSet().add(manager);
		cc.getRoleSet().add(admin);
		cc.getRoleSet().add(general);

		zl.getRoleSet().add(general);
		xh.getRoleSet().add(general);
		xc.getRoleSet().add(general);

		cy.getRoleSet().add(manager);
		gj.getRoleSet().add(manager);

		admin.getGeneralSet().add(cc);
		general.getGeneralSet().add(zl);
		general.getGeneralSet().add(xh);
		general.getGeneralSet().add(xc);
		manager.getGeneralSet().add(cy);
		manager.getGeneralSet().add(gj);

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		// session.save(cc);
		// session.save(zl);
		// session.save(xh);
		// session.save(xc);
		// session.save(cy);
		// session.save(gj);
		session.save(admin);
		session.save(manager);
		session.save(general);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testSave() throws Exception {

	}

	@Test
	public void testCaoCaoOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		cc = session.load(General.class, 1);
		for (Role r : cc.getRoleSet()) {
			r.getGeneralSet().remove(cc);
		}
		cc.setRoleSet(null);

		session.delete(cc);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testManagerOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		manager = session.load(Role.class, 2);
		for (General g : manager.getGeneralSet()) {
			g.getRoleSet().remove(manager);
		}
		manager.setGeneralSet(null);
		session.delete(manager);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testGjRetire() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		gj = session.load(General.class, 6);
		for (Role r : gj.getRoleSet()) {
			r.getGeneralSet().remove(gj);
		}
		gj.setRoleSet(null);
		session.update(gj);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}

	@Test
	public void testZlManager() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		zl = session.load(General.class, 2);
		manager = session.load(Role.class, 2);
		zl.getRoleSet().add(manager);
		manager.getGeneralSet().add(zl);
		session.update(zl);

		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
}
