/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.scss.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.scss.entity.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Repository("hibernateDao")
public class HibernateDao {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public <T> List<T> findEntity(String hql, Map<String, Object> params) {
		Session session = getSession();
		// 能过HQL语句建立Query对象
		Query query = session.createQuery(hql);
		// 向query对象中填充参数
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		// 调用查询
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseEntity> T findById(Class<T> clazz, Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public <T> T findUniqueResult(String hql, Map<String, Object> params) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		return (T) query.uniqueResult();
	}

	/**
	 * 保存一个实体，这个实体必须是BaseEntity的子类对象
	 * 
	 * @param entity
	 */
	public <T extends BaseEntity> void save(T entity) {
		getSession().save(entity);
	}

	public <T extends BaseEntity> void update(T entity) {
		getSession().update(entity);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
