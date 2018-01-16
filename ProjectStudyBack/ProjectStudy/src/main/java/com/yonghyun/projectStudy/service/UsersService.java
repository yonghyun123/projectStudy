package com.yonghyun.projectStudy.service;

import com.yonghyun.projectStudy.domain.Users;

public interface UsersService {
	Users getUsers(String usersEmail);
	Users signupUsers(Users users);
	Users signinUsers(String usersEmail, String usersPassword);
}
