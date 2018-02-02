package com.yonghyun.projectStudy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonghyun.projectStudy.domain.Studies;
import com.yonghyun.projectStudy.service.StudiesService;
import com.yonghyun.projectStudy.utils.UploadFileDisplay;

@Controller
@RequestMapping("/study")
public class StudiesController {
	static final private Logger logger = LoggerFactory.getLogger(StudiesController.class);
	@Autowired
	StudiesService studiesService;
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value = "")
	public @ResponseBody List<Studies> getAllStudies(){
		return studiesService.getAllStudies();
	}
//	@RequestMapping(value = "")
//	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
//	    UploadFileDisplay display=UploadFileDisplay.getInstance();
//	    String harName = "/2018/01/30/s_0879d9e1-a050-449b-a9c1-3b5960dc36da_1.jpg";
//	    logger.info("StudiesController ==>"+harName);
//	    logger.info("StudiesController ==>"+uploadPath);
//	    return display.disPlay(harName, uploadPath);
//	}
}
