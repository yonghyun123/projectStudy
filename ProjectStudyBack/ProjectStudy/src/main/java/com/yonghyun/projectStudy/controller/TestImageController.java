package com.yonghyun.projectStudy.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yonghyun.projectStudy.domain.Studies;
import com.yonghyun.projectStudy.service.StudiesService;
import com.yonghyun.projectStudy.utils.UploadFileUtils;

@Controller
@RequestMapping("test")
public class TestImageController {
	private static final Logger logger = LoggerFactory.getLogger(TestImageController.class);

	@Autowired
	StudiesService studiesService;
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	Studies imageTest(MultipartFile file, MultipartHttpServletRequest request) throws Exception{
        logger.info("파일이름 :"+file.getOriginalFilename());
        logger.info("email:" + request.getParameter("email"));
        
        String root_path = request.getSession().getServletContext().getRealPath("/");
        logger.info("실제경로 : "+root_path);
        logger.info("servlet-context에 등록된 경로: "+uploadPath);
        
        UploadFileUtils.setWIDTH_SIZE(200);
        String uploadFiles = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
        logger.info("after file save -"+uploadFiles);
        
        Studies study = new Studies();
        study.setUsersEmail(request.getParameter("email"));
        study.setImgName(uploadFiles);
        
		return studiesService.addStudies(study);
	}
}
