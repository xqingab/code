package org.forten.sample.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Notebook;
import org.forten.sample.qo.NotebookQo;
import org.forten.sample.ro.NotebookRoWithPage;
import org.forten.sample.vo.NotebookVoForAdmin;
import org.forten.sample.vo.NotebookVoForUpdate;
import org.forten.sample.vo.NotebookVoForUser;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("notebookBo")
public class NotebookBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(Notebook nb) {
		dao.save(nb);
	}

	@Transactional(readOnly = true)
	public List<NotebookVoForUser> queryForUser() {
		String hql = "SELECT new " + "org.forten.sample.vo.NotebookVoForUser(username,content,createTime) "
				+ "FROM Notebook ORDER BY createTime DESC";
		return dao.findBy(hql);
	}

	@Transactional(readOnly = true)
	public NotebookRoWithPage queryForAdmin(NotebookQo qo) {
		String username = qo.getUsername(); 
		String content = qo.getContent();
		int pageNo = qo.getPageNo();
		int pageSize = qo.getPageSize();
		// 查询数据的HQL
		String hql = "SELECT new " + "org.forten.sample.vo.NotebookVoForAdmin(id,username,content,createTime) "
				+ "FROM Notebook WHERE 1=1 ";
		// 统计符合条件的数据总数的HQL
		String countHql = "SELECT count(id) FROM Notebook WHERE 1=1 ";
		// 查询数据和统计数量的HQL虽然是两条语句，但为了分页数据的准确性，需要为这两条语句设置相同的WHERE子句（查询条件的表达式）
		Map<String, Object> params = new HashMap<>(2);
		if (StringUtil.hasText(username)) {
			hql = hql + "AND username LIKE :un ";
			countHql = countHql + "AND username LIKE :un ";
			params.put("un", "%" + username + "%");
		}
		if (StringUtil.hasText(content)) {
			hql = hql + "AND content LIKE :content ";
			countHql = countHql + "AND content LIKE :content ";
			params.put("content", "%" + content + "%");
		}
		hql = hql + "ORDER BY createTime DESC";

		// 进行符合条件数据量的统计，得到符合条件数据总数
		long count = dao.findObjectBy(countHql, params);
		// 如果符合条件数据量等于零，不进行数据的查询，直接返回一个没有元素的List
		if (count == 0) {
			return new NotebookRoWithPage(new ArrayList<>(0), null);
		}

		// 如果符合条件的数据量大于零，先进行分页信息的计算
		PageInfo page = PageInfo.getInstance(pageNo, pageSize, count);

		// 进行分页数据的查询
		List<NotebookVoForAdmin> list = dao.findBy(hql, params, (int) page.getFirstResultNum(), page.getPageSize());
		return new NotebookRoWithPage(list, page);
	}

	@Transactional
	public void doDelete(int id) {
		dao.delete(Notebook.class, id);
	}

	@Transactional(readOnly = true)
	public NotebookVoForUpdate queryForUpdate(int id) {
		String hql = "SELECT new " + "org.forten.sample.vo.NotebookVoForUpdate(id,username,content) "
				+ "FROM Notebook WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return dao.findObjectBy(hql, params);
	}

	@Transactional
	public void doUpdate(NotebookVoForUpdate vo) {
		Notebook nb = dao.findByLoad(Notebook.class, vo.getId());
		BeanPropertyUtil.copy(nb, vo);
		dao.update(nb);
	}
}
