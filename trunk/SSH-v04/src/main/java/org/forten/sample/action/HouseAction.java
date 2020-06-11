package org.forten.sample.action;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.forten.sample.bo.HouseBo;
import org.forten.sample.entity.House;
import org.forten.sample.qo.HouseQo;
import org.forten.sample.ro.HouseRo;
import org.forten.sample.vo.HouseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/house")
public class HouseAction {
	@Resource
	private HouseBo bo;

	@RequestMapping("list")
	public ModelAndView listForUser(HouseQo qo) {
		HouseRo ro = bo.queryForUser(qo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("ro", ro);
		mav.addObject("qo", qo);

		return mav;
	}

	@RequestMapping("admin/list")
	public ModelAndView listForAdmin(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		HouseRo ro = bo.queryForAdmin(pageNo, pageSize);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("ro", ro);

		return mav;
	}

	@RequestMapping("admin/save")
	public String save(House house, MultipartFile img, HttpServletRequest request) {
		try {
			// 得到此项目在服务器上部署的绝对路径，并拼接上upload目录（要保存上传文件的目录）
			String path = request.getServletContext().getRealPath("/upload");
			// 得到要保存上传文件的目录的File对象
			File uploadPath = new File(path);
			// 如果要保存上传文件的目录不存在，则创建它
			if (!uploadPath.exists()) {
				uploadPath.mkdir();
			}

			// 得到被上传文件的原始文件名
			String filename = img.getOriginalFilename();
			// 从原始文件名中截取文件的扩展名
			String exName = filename.substring(filename.lastIndexOf("."));
			// 通过房源实体对象的id和上传文件的扩展名，来生成一个新的文件名，用于在服务器上保存图片，而不与其它用户上传的文件重名
			String newFilename = house.getId() + exName;
			// 得到上传文件的相对URL地址
			String imgUrl = "/upload/" + newFilename;
			// 把上传文件的相对URL地址设置给house实体对象
			house.setImgUrl(imgUrl);

			// 从MultipartFile对象中得到上传文件的二进制内容（字节数组）
			byte[] content = img.getBytes();
			// 通过Apache commons-io的工具方法把上传的文件内容写入到服务器的指定位置上
			FileUtils.writeByteArrayToFile(new File(path + "/" + newFilename), content);

			// 进行实体对象的保存
			bo.doSave(house);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

	@RequestMapping("admin/gotoUpdate")
	public ModelAndView gotoUpdate(Long id) {
		ModelAndView mav = new ModelAndView();
		HouseVo vo = bo.queryForUpdate(id);
		mav.setViewName("update.jsp");
		mav.addObject("vo", vo);
		return mav;
	}

	@RequestMapping("admin/update")
	public String update(HouseVo vo, MultipartFile img, HttpServletRequest request) {
		// 如果从页面中传来了新的文件，执行以下if块中的逻辑
		if (img.getSize() > 0) {
			// 删除实体对象原有的图片文件
			// 得到项目的根路径
			String rootPath = request.getServletContext().getRealPath("/");
			// 得到老文件的存储路径和文件名
			String imgFilePath = rootPath + vo.getImgUrl();
			File oldFile = new File(imgFilePath);
			// 执行删除
			oldFile.deleteOnExit();

			// 进行新文件的上传
			try {
				// 得到项目中存储图片文件的绝对路径
				String path = rootPath + "/upload";
				// 得到新文件的原始文件名
				String filename = img.getOriginalFilename();
				// 截取扩展名
				String exName = filename.substring(filename.lastIndexOf("."));
				// 通过实体对象的id和上传文件的扩展名生成一个新的文件名，用于在服务器上保存图片
				String newFilename = vo.getId() + exName;
				// 得到上传文件的相对URL路径
				String imgUrl = "/upload/" + newFilename;
				// 把上传文件的相对URL设置给实体对象
				vo.setImgUrl(imgUrl);

				// 使用生成的文件名，把文件写入到服务器的磁盘上
				FileUtils.writeByteArrayToFile(new File(path + "/" + newFilename), img.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		bo.doUpdate(vo);

		return "redirect:list.do";
	}

	@RequestMapping("admin/delete")
	public String delete(long id, HttpServletRequest request) {
		String imgUrl = bo.doDelete(id);
		String rootUrl = request.getServletContext().getRealPath("/");
		String filepath = rootUrl + imgUrl;
		File file = new File(filepath);
		file.delete();

		return "redirect:list.do";
	}

}
