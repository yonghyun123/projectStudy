package com.yonghyun.projectStudy.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonghyun.projectStudy.domain.Users;
import com.yonghyun.projectStudy.service.UsersService;

@Controller
@RequestMapping("/signin")
public class SigninController {
	private static final Logger logger = LoggerFactory.getLogger(SigninController.class);
	@Autowired
	UsersService usersService;
	@RequestMapping("/")
	public @ResponseBody Users signin(@RequestBody Map<String, Object>map){
		logger.info("Signin Controller In ==>" + map.get("usersEmail"));
		logger.info("Signin Controller In ==>" + map.get("usersPassword"));
		
		String usersEmail = map.get("usersEmail").toString();
		String usersPassword = map.get("usersPassword").toString();
		
		return usersService.signinUsers(usersEmail, usersPassword);
	}
}
