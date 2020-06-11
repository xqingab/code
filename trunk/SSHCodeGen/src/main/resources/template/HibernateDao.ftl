package ${basePackage}.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("hibernateDao")
public class HibernateDao {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * @return
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public <T> void save(T entity) {
		getSession().save(entity);
	}

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public <T> void update(T entity) {
		getSession().update(entity);
	}

	/**
	 * 保存或更新
	 * 
	 * @param entity
	 */
	public <T> void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	/**
	 * 按实体对象删除
	 * 
	 * @param entity
	 */
	public <T> void delete(T entity) {
		getSession().delete(entity);
	}

	/**
	 * 合并
	 * 
	 * @param entity
	 */
	public <T> void merge(T entity) {
		getSession().merge(entity);
	}

	/**
	 * 按实体类型和ID删除
	 * 
	 * @param entityClass
	 * @param id
	 */
	public <T> void delete(Class<T> entityClass, Serializable id) {
		String hql = "DELETE FROM " + entityClass.getSimpleName()
				+ " WHERE id=:id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	/**
	 * 按实体类型和ID查询一个对象。使用场景：被查询的对象不一定存在
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T findByIdUseGet(Class<T> entityClass, Serializable id) {
		return (T) getSession().get(entityClass, id);
	}

	/**
	 * 按实体类型和ID查询一个对象。使用场景：被查询的对象一定存在，若不存在则应该抛出异常的时候。
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T findByIdUseLoad(Class<T> entityClass, Serializable id) {
		return (T) getSession().load(entityClass, id);
	}

	/**
	 * 带条件不带分页的查询，返回是多个对象的容器
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findBy(String hql, Map<String, Object> params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (Entry<String, Object> e : params.entrySet()) {
			if (e.getValue() instanceof Collection<?>) {
				query.setParameterList(e.getKey(), (Collection<?>) e.getValue());
			} else if (e.getValue().getClass().isArray()) {
				query.setParameterList(e.getKey(), (Object[]) e.getValue());
			} else {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		return query.list();
	}

	/**
	 * 带条件也带分页的查询，返回是多个对象的容器
	 * 
	 * @param hql
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findBy(String hql, Map<String, Object> params,
			int firstResult, int maxResults) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (Entry<String, Object> e : params.entrySet()) {
			if (e.getValue() instanceof Collection<?>) {
				query.setParameterList(e.getKey(), (Collection<?>) e.getValue());
			} else if (e.getValue().getClass().isArray()) {
				query.setParameterList(e.getKey(), (Object[]) e.getValue());
			} else {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

	/**
	 * 带条件不带分页的查询，返回是一个对象或值
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T findObjectBy(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		for (Entry<String, Object> e : params.entrySet()) {
			if (e.getValue() instanceof Collection<?>) {
				query.setParameterList(e.getKey(), (Collection<?>) e.getValue());
			} else if (e.getValue().getClass().isArray()) {
				query.setParameterList(e.getKey(), (Object[]) e.getValue());
			} else {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * 不带条件不带分页的查询，返回是一个对象的容器
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql) {
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 不带条件带分页的查询，返回是一个对象的容器
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql, int firstResult, int maxResults) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

	/**
	 * 不带条件不带分页的查询，返回是一个对象或值
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T findObject(String hql) {
		Query query = getSession().createQuery(hql);
		return (T) query.uniqueResult();
	}

	/**
	 * 用HQL和参数Map进行数据的写操作
	 * 
	 * @param hql
	 * @param params
	 */
	public void writeWithHql(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		for (Entry<String, Object> e : params.entrySet()) {
			if (e.getValue() instanceof Collection<?>) {
				query.setParameterList(e.getKey(), (Collection<?>) e.getValue());
			} else if (e.getValue().getClass().isArray()) {
				query.setParameterList(e.getKey(), (Object[]) e.getValue());
			} else {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		query.executeUpdate();
	}
}
