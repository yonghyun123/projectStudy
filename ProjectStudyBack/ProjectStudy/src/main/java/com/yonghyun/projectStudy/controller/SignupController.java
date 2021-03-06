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

import com.yonghyun.projectStudy.domain.Users;
import com.yonghyun.projectStudy.service.UsersService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody Users login(@RequestBody Map<String, Object> map) {
		logger.info("Signup Controller IN==>" + map.get("usersName"));
		logger.info("Signup Controller IN==>" + map.get("usersEmail"));
		logger.info("Signup Controller IN==>" + map.get("usersPassword"));
		
		
		String usersName = map.get("usersName").toString();
		String usersEmail = map.get("usersEmail").toString();
		String usersPassword = map.get("usersPassword").toString();
		
		Users users = new Users();
		users.setUsersName(usersName);
		users.setUsersEmail(usersEmail);
		users.setUsersPassword(usersPassword);
		
		return this.usersService.signupUsers(users);
	}
	
}
