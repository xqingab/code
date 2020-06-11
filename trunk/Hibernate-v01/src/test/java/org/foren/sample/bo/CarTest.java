package org.foren.sample.bo;

import java.util.Date;

import org.forten.sample.dao.HibernateUtil;
import org.forten.sample.entity.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class CarTest {
	@Test
	public void testSave() throws Exception {
		Car car = new Car("QQ", "红", 30000, 60, new Date());
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(car);
		tx.commit();
		HibernateUtil.close(session);
	}
}
