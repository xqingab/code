package org.forten.sample.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class UploadAction {
	@RequestMapping("upload")
	public void upload(MultipartFile photo, String name, HttpServletRequest req) throws IOException {
		String filename = photo.getOriginalFilename();
		String uploadPathStr = req.getServletContext().getRealPath("/upload");
		File uploadPath = new File(uploadPathStr);
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		FileCopyUtils.copy(photo.getBytes(), new File(uploadPath + "/" + filename));
		System.out.println(name);
	}
}
