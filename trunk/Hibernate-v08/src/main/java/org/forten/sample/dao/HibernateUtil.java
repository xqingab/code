package org.forten.sample.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory FACTORY = buildSessionFactory();

	// 通过对配置文件的读取得到SessionFactory的一个实例
	private static SessionFactory buildSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return null;
	}

	// 返回SessionFactory的实例
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}

	// 通过SessionFactory实例打开一个session，并返回
	public static Session getSession() {
		return FACTORY.openSession();
	}

	// 关闭Session
	public static void close(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
