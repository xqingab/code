package org.forten.sample.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.forten.sample.dao.HibernateDao;
import org.forten.sample.dao.JDBCDao;
import org.forten.sample.entity.Money;
import org.forten.sample.entity.enums.MoneyState;
import org.forten.sample.vo.MoneyVoForShow;
import org.forten.sample.vo.MoneyVoForUpdate;
import org.forten.utils.common.EnumUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("moneyBo")
public class MoneyBo {

	private static final Log log = LogFactory.getLog(MoneyBo.class);
	@Resource
	private HibernateDao dao;
	@Resource
	private JDBCDao jdbcDao;

	@Transactional
	public void doSave(Money money) {
		dao.save(money);
	}

	@Transactional(readOnly = true)
	public List<MoneyVoForShow> queryForUser(int userId) {
		String sql = "SELECT m.id,p.name,m.reason,m.amount,m.bank,m.account," + "( " + "CASE "
				+ "WHEN m.state=0 THEN '提交' " + "WHEN m.state=1 THEN '审核通过' " + "WHEN m.state=2 THEN '报销完成' " + "END "
				+ ") state " + "FROM test_project p JOIN test_money m " + "ON (p.id=m.project_id) "
				+ "WHERE m.user_id=:uId";

		Map<String, Object> params = new HashMap<>();
		params.put("uId", userId);

		return jdbcDao.findBy(sql, params, (rs, rownum) -> {
			MoneyVoForShow vo = new MoneyVoForShow();
			vo.setId(rs.getInt(1));
			vo.setProjectName(rs.getString(2));
			vo.setReason(rs.getString(3));
			vo.setAmount(rs.getInt(4));
			vo.setBank(rs.getString(5));
			vo.setAccount(rs.getString(6));
			// int stateIndex = rs.getInt(7);
			// MoneyState state = EnumUtil.getEnumByNum(MoneyState.class,
			// stateIndex);
			vo.setStateDesc(rs.getString(7));
			return vo;
		});
	}

	@Transactional(readOnly = true)
	public List<MoneyVoForShow> queryForAdmin(Integer projectId) {
		String sql = "SELECT m.id,p.name,m.reason,m.amount,m.bank,m.account," + "( " + "CASE "
				+ "WHEN m.state=0 THEN '提交' " + "WHEN m.state=1 THEN '审核通过' " + "WHEN m.state=2 THEN '报销完成' " + "END "
				+ ") state,m.state " + "FROM test_project p JOIN test_money m " + "ON (p.id=m.project_id) ";

		Map<String, Object> params = new HashMap<>();
		if (projectId != null) {
			sql = sql + "WHERE m.project_id=:pId";
			params.put("pId", projectId);
		}

		return jdbcDao.findBy(sql, params, (rs, rownum) -> {
			MoneyVoForShow vo = new MoneyVoForShow();
			vo.setId(rs.getInt(1));
			vo.setProjectName(rs.getString(2));
			vo.setReason(rs.getString(3));
			vo.setAmount(rs.getInt(4));
			vo.setBank(rs.getString(5));
			vo.setAccount(rs.getString(6));
			vo.setStateDesc(rs.getString(7));
			int stateIndex = rs.getInt(8);
			MoneyState state = EnumUtil.getEnumByNum(MoneyState.class, stateIndex);
			vo.setState(state);
			return vo;
		});
	}

	@Transactional(readOnly = true)
	public MoneyVoForUpdate queryForUpdate(int id) {
		Money money = dao.findByLoad(Money.class, id);
		MoneyVoForUpdate vo = new MoneyVoForUpdate();
		BeanPropertyUtil.copy(vo, money);
		return vo;
	}

	// @Transactional(readOnly = true)
	// public List<MoneyVoForShow> queryForUser(int userId) {
	// // 查询所有user_id的值是userId的汇款实体对象
	// String hql = "FROM Money WHERE userId=:uId";
	// Map<String, Object> params = new HashMap<>();
	// params.put("uId", userId);
	//
	// List<Money> list = dao.findBy(hql, params);
	// // 把实体对象转换成为Vo对象
	// List<MoneyVoForShow> voList = new ArrayList<>(list.size());
	// for (Money money : list) {
	// MoneyVoForShow vo = new MoneyVoForShow();
	// BeanPropertyUtil.copy(vo, money);
	// // 通过汇款实体对象的projectId来查询与之相对应的项目实体对象
	// Project project = dao.findByLoad(Project.class, money.getProjectId());
	// // 把项目名放置到汇款Vo对象的相应实例变量上
	// vo.setProjectName(project.getName());
	//
	// voList.add(vo);
	// }
	//
	// return voList;
	//
	// }

	// @Transactional
	// public void doChangeState(int id){
	// // TODO 以下逻辑会触发两条SQL语句的执行
	// // 考虑使用SQL语句中的CASE语法改写以下逻辑
	// Money m = dao.findByLoad(Money.class, id);
	// if(m.getState().equals(MoneyState.SUBMIT)){
	// m.setState(MoneyState.PASS);
	// }else if(m.getState().equals(MoneyState.PASS)){
	// m.setState(MoneyState.FINISH);
	// }
	// dao.update(m);
	// }

	@Transactional
	public void doChangeState(int id) {
		String sql = "UPDATE test_money SET state=(CASE " + "WHEN state=0 THEN 1 " + "WHEN state=1 THEN 2 "
				+ "END) WHERE id=:id";
		Map<String, Object> params = new HashMap<>(1);
		params.put("id", id);

		System.out.println("SQL:[" + sql + "]");
		if (log.isDebugEnabled()) {
			log.debug("SQL:" + sql);
		}
		jdbcDao.update(sql, params);
	}
}
