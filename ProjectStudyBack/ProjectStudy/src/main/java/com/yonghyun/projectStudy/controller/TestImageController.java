package com.yonghyun.projectStudy.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	Studies imageTest(MultipartFile file, HttpServletRequest request) throws Exception{

        logger.info("파일이름 :"+file.getOriginalFilename());
        logger.info("파일크기 : "+file.getSize());
        logger.info("컨텐트 타입 : "+file.getContentType());
        
        String root_path = request.getSession().getServletContext().getRealPath("/");
        String attach_path = "resources/upload/";
        logger.info("실제경로 : "+root_path + attach_path);
        
        File f = new File(root_path + attach_path + file.getOriginalFilename());
        try{
        	file.transferTo(f);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
		return null;
	}
}
