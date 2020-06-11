package org.forten.sample.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.sample.dao.HibernateDao;
import org.forten.sample.entity.Room;
import org.forten.sample.vo.RoomVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roomBo")
public class RoomBo {
	@Resource
	private HibernateDao dao;

	@Transactional
	public void doSave(Room room) {
		dao.save(room);
	}

	@Transactional
	public int doUpdate(String title, String tel, int price, int id) {
		String hql = "UPDATE Room SET title=:t1,tel=:t2,price=:p WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("t1", title);
		params.put("t2", tel);
		params.put("p", price);
		params.put("id", id);

		return dao.executeUpdate(hql, params);
	}

	@Transactional(readOnly = true)
	public List<RoomVo> queryBy(String title, String tel, Integer minPrice, Integer maxPrice) {
		String hql = "FROM Room WHERE 1=1 ";
		Map<String, Object> params = new HashMap<>();
		if (title != null && title.trim().length() > 0) {
			hql = hql + "AND title LIKE :t1 ";
			params.put("t1", "%" + title + "%");
		}
		if (tel != null && tel.trim().length() > 0) {
			hql = hql + "AND tel LIKE :t2 ";
			params.put("t2", "%" + tel + "%");
		}
		if (minPrice != null && maxPrice != null) {
			hql = hql + "AND price BETWEEN :p1 AND :p2 ";
			params.put("p1", minPrice);
			params.put("p2", maxPrice);
		}

		List<Room> list = dao.findBy(hql, params);
		List<RoomVo> voList = new ArrayList<>(list.size());

		for (Room r : list) {
			RoomVo vo = new RoomVo();

			vo.setCreateTime(r.getCreateTime());
			vo.setId(r.getId());
			vo.setPrice(r.getPrice());
			vo.setTel(r.getTel());
			vo.setTitle(r.getTitle());

			voList.add(vo);
		}
		return voList;
	}
}
