package org.forten.sample;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Objects;

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
	public void init(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("DELETE FROM General").executeUpdate();
		session.createQuery("DELETE FROM Country").executeUpdate();
		tx.commit();
		HibernateUtil.close(session);
		
		wei = new Country(1, "魏国");
		shu = new Country(2, "蜀国");
		wu = new Country(3, "吴国");
		
		zl = new General(1, "张辽",wei);
		xh = new General(2, "徐晃",wei);
		yj = new General(3, "于禁",wei);
		gy = new General(4, "关羽",shu);
		zf = new General(5, "张飞",shu);
		zy = new General(6, "赵云",shu);
		hg = new General(7, "黄盖",wu);
		df = new General(8, "丁奉",wu);
		xs = new General(9, "徐盛",wu);
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		session.save(zl);
		session.save(xh);
		session.save(yj);
		session.save(gy);
		session.save(zf);
		session.save(zy);
		session.save(hg);
		session.save(df);
		session.save(xs);
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
		gy.setCountry(null);
		session.delete(gy);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
	
	@Test
	public void testCountryOver() throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		// 判断某个武将是否属于某个国家
		// 如果是则进行关系解除
		// 这样做代码量比较大，原因是由于单向关系映射所造成的
		if(gy.getCountry().equals(shu)){
			gy.setCountry(null);
		}
		if(zf.getCountry().equals(shu)){
			zf.setCountry(null);
		}
		if(zy.getCountry().equals(shu)){
			zy.setCountry(null);
		}
		if(zl.getCountry().equals(shu)){
			zl.setCountry(null);
		}
		session.saveOrUpdate(gy);
		session.saveOrUpdate(zf);
		session.saveOrUpdate(zy);
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
		yj.setCountry(shu);
		session.update(yj);
		tx.commit();
		HibernateUtil.close(session);
		System.out.println("============================");
	}
}
