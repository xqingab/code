package org.forten.sample.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.dao.RoomDao;
import org.forten.sample.entity.Room;
import org.forten.sample.vo.RoomVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Bo层Bean的声明应该使用@Service注解
@Service("roomBo")
public class RoomBo {
	@Resource(name = "roomDao")
	private RoomDao roomDao;

	// 被注解为@Transactional的方法是会被IoC容器中的事务管理器进行事务控制的
	// 如果@Transactional被注解在类上，则类中的所有方法都会被事务管理器管理
	// @Transactional(readOnly=true)可以把事务声明为只读
	// 只读事务的性能要比非只读事务的性能高，所以在只做查询操作的方法上应该设置此属性为true
	// 注意：@Transactional是org.springframework.transaction.annotation包下的注解
	// 而不是javax.transaction包下的
	@Transactional
	public void doSave(Room room) {
		roomDao.save(room);
	}

	@Transactional(readOnly = true)
	public Room queryBy(int id) {
		return roomDao.findByGet(id);
	}

	// 此方法在返回Room实体的代理对象后，Session就会被关闭
	// 所以在客户代码中如果使用返回的Room代理对象中的数据，会得到延迟初始化异常
	// 此方法不推荐使用，应该使用类似于queryVoBy方法中的做法
	// 把实体代理对象中的数据复制给一个Vo对象，并返回这个Vo对象
	// Vo是一个普通的Java对象，不与数据表映射，也不会有实体对象的各种状态，不会被Session管理
	// Vo是DTO（数据传输对象）的一种，如果用作数据的显示，则称为视图对象（View Object)
	// 如果用作数据的传递，则称为值对象（Value Object）
	@Transactional(readOnly = true)
	public Room queryLazyRoomBy(int id) {
		return roomDao.findByLoad(id);
	}

	@Transactional(readOnly = true)
	public RoomVo queryVoBy(int id) {
		Room room = roomDao.findByLoad(id);
		RoomVo vo = new RoomVo();

		vo.setCreateTime(room.getCreateTime());
		vo.setId(room.getId());
		vo.setPrice(room.getPrice());
		vo.setTel(room.getTel());
		vo.setTitle(room.getTitle());

		return vo;
	}

	@Transactional
	public void doUpdate(String title, int price, String tel, int id) {
		// Room room = roomDao.findByLoad(id);
		// room.setPrice(price);
		// room.setTel(tel);
		// room.setTitle(title);
		// 以下语句可以省略，因为此时room是持久化状态的实体对象
		// roomDao.update(room);
		roomDao.update(title, tel, price, id);
	}

	@Transactional
	public void doDelete(int id) {
		roomDao.delete(id);
	}

	@Transactional(readOnly = true)
	public List<RoomVo> queryBy(String title, String tel) {
		List<Room> list = roomDao.findBy(title, tel);
		List<RoomVo> voList = new ArrayList<>(list.size());
		for (Room room : list) {
			RoomVo vo = new RoomVo();

			vo.setCreateTime(room.getCreateTime());
			vo.setId(room.getId());
			vo.setPrice(room.getPrice());
			vo.setTel(room.getTel());
			vo.setTitle(room.getTitle());
			
			voList.add(vo);
		}
		
		return voList;
	} 
}
