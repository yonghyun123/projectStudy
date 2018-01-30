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
		// 이미 같은 email을 사용하는 user가 있으면 
		if(checkEmail != null){
			return checkEmail;
		}
		// 아니면 db에 회원가입 폼을 입력시킨다.
		else{
			this.sqlSession.insert(NAMESPACE + "signupUsers", user);
			return null;
		}
	}
	
	public Users signinUsers(String usersEmail, String usersPassword){
		Users user = new Users();
		user.setUsersEmail(usersEmail);
		user.setUsersPassword(usersPassword);
		return this.sqlSession.selectOne(NAMESPACE + "signinUsers", user);
	}
}
