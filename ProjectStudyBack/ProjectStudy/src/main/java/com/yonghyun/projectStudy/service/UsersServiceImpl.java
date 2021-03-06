package com.yonghyun.projectStudy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonghyun.projectStudy.dao.UsersDao;
import com.yonghyun.projectStudy.domain.Users;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDao usersDao;
	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Override
	public Users getUsers(String usersEmail) {
		// TODO Auto-generated method stub
		return usersDao.getUsers(usersEmail);
	}

	public Users signupUsers(Users users){
		logger.info("UsersServcice ===> in"+users.getUsersEmail());
		logger.info("UsersServcice ===> in"+users.getUsersName());
		logger.info("UsersServcice ===> in"+users.getUsersPassword());
		return usersDao.signupUsers(users);
	}

	@Override
	public Users signinUsers(String usersEmail, String usersPassword) {
		logger.info("UsersServcice ===> in"+usersEmail);
		logger.info("UsersServcice ===> in"+usersPassword);
		return usersDao.signinUsers(usersEmail, usersPassword);
	}

	
}
