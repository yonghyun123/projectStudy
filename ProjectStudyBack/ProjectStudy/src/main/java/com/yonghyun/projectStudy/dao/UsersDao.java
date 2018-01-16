package com.yonghyun.projectStudy.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonghyun.projectStudy.domain.Users;

@Repository
public class UsersDao {
	private final String NAMESPACE = "com.yonghyun.projectStudy.mapper.UsersMapper.";
	private static final Logger logger = LoggerFactory.getLogger(UsersDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Users getUsers(String usersEmail){
		return this.sqlSession.selectOne(NAMESPACE + "getUsers", usersEmail);
	}
	
	public Users signupUsers(Users user){
		Users checkEmail = new Users();
		checkEmail = getUsers(user.getUsersEmail());
		if(checkEmail != null){
			return checkEmail;
		}
		else{
			this.sqlSession.insert(NAMESPACE + "signupUsers", user);
			return null;
		}
		
	}
}
