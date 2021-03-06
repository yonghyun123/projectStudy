package com.yonghyun.projectStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonghyun.projectStudy.domain.Users;
import com.yonghyun.projectStudy.service.UsersService;

@Controller
@RequestMapping("/")
public class UsersController {
	// Logger
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value = "/")
	public @ResponseBody Users getEmployee(@PathVariable String usersEmail){
		return this.usersService.getUsers(usersEmail);
	}
}
