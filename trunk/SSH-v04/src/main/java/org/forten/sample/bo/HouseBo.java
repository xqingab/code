package org.forten.sample.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.House;
import org.forten.sample.qo.HouseQo;
import org.forten.sample.ro.HouseRo;
import org.forten.sample.vo.HouseVo;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("houseBo")
public class HouseBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(House house) {
		dao.save(house);
	}

	@Transactional(readOnly = true)
	public HouseRo queryForUser(HouseQo qo) {
		String hql = "SELECT new org.forten.sample.vo.HouseVo(id,title,address,price,tel,type,imgUrl) FROM House WHERE 1=1 ";
		String countHql = "SELECT count(id) FROM House WHERE 1=1 ";
		Map<String, Object> params = new HashMap<>();

		if (StringUtil.hasText(qo.getTitle())) {
			hql = hql + "AND title LIKE :title ";
			countHql = countHql + "AND title LIKE :title ";
			params.put("title", "%" + qo.getTitle() + "%");
		}
		if (StringUtil.hasText(qo.getAddress())) {
			hql = hql + "AND address LIKE :address ";
			countHql = countHql + "AND address LIKE :address ";
			params.put("address", "%" + qo.getAddress() + "%");
		}
		if (StringUtil.hasText(qo.getType())) {
			hql = hql + "AND type LIKE :type ";
			countHql = countHql + "AND type LIKE :type ";
			params.put("type", "%" + qo.getType() + "%");
		}
		if (qo.getMinPrice() != null && qo.getMaxPrice() != null) {
			hql = hql + "AND price BETWEEN :minPrice AND :maxPrice ";
			countHql = countHql + "AND price BETWEEN :minPrice AND :maxPrice ";
			params.put("minPrice", qo.getMinPrice());
			params.put("maxPrice", qo.getMaxPrice());
		}
		hql = hql + "ORDER BY id DESC";

		long count = dao.findObjectBy(countHql, params);
		if (count == 0) {
			return new HouseRo(null, null);
		}

		PageInfo page = PageInfo.getInstance(qo.getPageNo(), qo.getPageSize(), count);

		List<HouseVo> voList = dao.findBy(hql, params, (int) page.getFirstResultNum(), page.getPageSize());

		return new HouseRo(voList, page);
	}

	@Transactional(readOnly = true)
	public HouseRo queryForAdmin(Integer pageNo, Integer pageSize) {
		String hql = "SELECT new org.forten.sample.vo.HouseVo(id,title,address,price,tel,type,imgUrl) FROM House ORDER BY id DESC";
		String countHql = "SELECT count(id) FROM House";

		long count = dao.findObjectBy(countHql);

		if (count == 0) {
			return new HouseRo(null, null);
		}

		PageInfo page = PageInfo.getInstance(pageNo, pageSize, count);
		List<HouseVo> voList = dao.findBy(hql, (int) page.getFirstResultNum(), page.getPageSize());
		return new HouseRo(voList, page);
	}

	@Transactional(readOnly = true)
	public HouseVo queryForUpdate(long id) {
		House house = dao.findByLoad(House.class, id);
		HouseVo vo = new HouseVo();
		BeanPropertyUtil.copy(vo, house);
		return vo;
	}

	@Transactional
	public void doUpdate(HouseVo vo) {
		House house = dao.findByLoad(House.class, vo.getId());
		BeanPropertyUtil.copy(house, vo);
		dao.update(house);
	}

	@Transactional
	public String doDelete(long id) {
		String hql = "SELECT imgUrl FROM House WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		String imgUrl = dao.findObjectBy(hql, params);

		hql = "DELETE FROM House WHERE id=:id";
		dao.executeUpdate(hql, params);
		return imgUrl;
	}
}
