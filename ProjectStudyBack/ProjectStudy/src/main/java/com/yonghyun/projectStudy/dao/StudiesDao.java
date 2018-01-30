package com.yonghyun.projectStudy.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonghyun.projectStudy.domain.Studies;

@Repository
public class StudiesDao {
	private final String NAMESPACE = "com.yonghyun.projectStudy.mapper.StudyMapper.";
	private static final Logger logger = LoggerFactory.getLogger(UsersDao.class);
	
	@Autowired
	SqlSessionTemplate sqlSession;
	public Studies addStudies(Studies study){
		// 프로젝트(스터디)를 추가시킨다.
		this.sqlSession.insert(NAMESPACE + "addStudies" + study);
		return study;
	}
	public List<Studies> getAllStudies(){
		return this.sqlSession.selectList(NAMESPACE + "getAllStudies");
	}
}
