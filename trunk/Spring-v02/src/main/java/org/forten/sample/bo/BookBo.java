package org.forten.sample.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.forten.sample.dao.BookDao;
import org.forten.sample.entity.Book;
import org.forten.sample.vo.BookVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Bo层Bean的声明应该使用@Service注解
@Service("bookBo")
public class BookBo {
	@Resource(name = "bookDao")
	private BookDao bookDao;

	// 被注解为@Transactional的方法是会被IoC容器中的事务管理器进行事务控制的
	// 如果@Transactional被注解在类上，则类中的所有方法都会被事务管理器管理
	// @Transactional(readOnly=true)可以把事务声明为只读
	// 只读事务的性能要比非只读事务的性能高，所以在只做查询操作的方法上应该设置此属性为true
	// 注意：@Transactional是org.springframework.transaction.annotation包下的注解
	// 而不是javax.transaction包下的
	@Transactional
	public void doSave(Book book) {
		bookDao.save(book);
	}

	@Transactional(readOnly = true)
	public Book queryBy(int id) {
		return bookDao.findByGet(id);
	}

	// 此方法在返回Book实体的代理对象后，Session就会被关闭
	// 所以在客户代码中如果使用返回的Book代理对象中的数据，会得到延迟初始化异常
	// 此方法不推荐使用，应该使用类似于queryVoBy方法中的做法
	// 把实体代理对象中的数据复制给一个Vo对象，并返回这个Vo对象
	// Vo是一个普通的Java对象，不与数据表映射，也不会有实体对象的各种状态，不会被Session管理
	// Vo是DTO（数据传输对象）的一种，如果用作数据的显示，则称为视图对象（View Object)
	// 如果用作数据的传递，则称为值对象（Value Object）
	@Transactional(readOnly = true)
	public Book queryLazyBookBy(int id) {
		return bookDao.findByLoad(id);
	}

	@Transactional(readOnly = true)
	public BookVo queryVoBy(int id) {
		Book book = bookDao.findByLoad(id);
		BookVo vo = new BookVo();

		vo.setCreateTime(book.getCreateTime());
		vo.setId(book.getId());
		vo.setPrice(book.getPrice());
		vo.setAuthor(book.getAuthor());
		vo.setCreateTime(book.getCreateTime());
		vo.setName(book.getName());
		vo.setPublisher(book.getPublisher());
		vo.setPubDate(book.getPubDate());

		return vo;
	}

	@Transactional
	public void doUpdate(String title, int price, String tel, int id) {
		// Book book = bookDao.findByLoad(id);
		// book.setPrice(price);
		// book.setTel(tel);
		// book.setTitle(title);
		// 以下语句可以省略，因为此时book是持久化状态的实体对象
		// bookDao.update(book);
		bookDao.update(title, tel, price, id);
	}

	@Transactional
	public void doDelete(int id) {
		bookDao.delete(id);
	}

	@Transactional(readOnly = true)
	public List<BookVo> queryBy(String title, String tel) {
		List<Book> list = bookDao.findBy(title, tel);
		List<BookVo> voList = new ArrayList<>(list.size());
		for (Book book : list) {
			BookVo vo = new BookVo();

			vo.setCreateTime(book.getCreateTime());
			vo.setId(book.getId());
			vo.setPrice(book.getPrice());
			vo.setAuthor(book.getAuthor());
			vo.setCreateTime(book.getCreateTime());
			vo.setName(book.getName());
			vo.setPublisher(book.getPublisher());
			vo.setPubDate(book.getPubDate());

			voList.add(vo);
		}

		return voList;
	}
}
