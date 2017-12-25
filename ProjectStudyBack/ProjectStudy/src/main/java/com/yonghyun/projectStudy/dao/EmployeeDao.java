package com.yonghyun.projectStudy.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonghyun.projectStudy.domain.Employee;

@Repository
public class EmployeeDao {
	private final String NAMESPACE = "com.yonghyun.projectStudy.mapper.EmployeeMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Employee getEmployee(int id){
		return this.sqlSession.selectOne(NAMESPACE + "getEmployee", id);
	}
}
