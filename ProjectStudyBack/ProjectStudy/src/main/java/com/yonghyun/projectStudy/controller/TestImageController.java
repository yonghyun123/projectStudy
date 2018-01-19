package com.yonghyun.projectStudy.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonghyun.projectStudy.domain.Studies;
import com.yonghyun.projectStudy.service.StudiesService;

@Controller
@RequestMapping("test")
public class TestImageController {
	private static final Logger logger = LoggerFactory.getLogger(TestImageController.class);
	
	@Autowired
	StudiesService studiesService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody Studies imageTest(@RequestBody Map<String, Object> map){
		logger.info("TestContoller==>"+map.get("imageData"));
		Studies study = new Studies();
		String imageData = map.get("imageData").toString();	
		study.setStudiesImage(imageData);
		return studiesService.getStudiesImage(study);
		
	}
}
