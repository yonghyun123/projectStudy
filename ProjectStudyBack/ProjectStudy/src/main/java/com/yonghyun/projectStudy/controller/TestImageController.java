package com.yonghyun.projectStudy.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yonghyun.projectStudy.domain.Studies;
import com.yonghyun.projectStudy.service.StudiesService;

@Controller
@RequestMapping("test")
public class TestImageController {
	private static final Logger logger = LoggerFactory.getLogger(TestImageController.class);
	
	@Autowired
	StudiesService studiesService;
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "test/plain; charset=utf8")
	Studies imageTest(MultipartFile file) throws Exception{

        logger.info("파일이름 :"+file.getOriginalFilename());
        logger.info("파일크기 : "+file.getSize());
        logger.info("컨텐트 타입 : "+file.getContentType());
		
//		Studies study = new Studies();
//		String imageData = map.get("imageData").toString();	
		
//		study.setStudiesImage(imageData);
//		return studiesService.getStudiesImage(study);
		return null;
	}
}
