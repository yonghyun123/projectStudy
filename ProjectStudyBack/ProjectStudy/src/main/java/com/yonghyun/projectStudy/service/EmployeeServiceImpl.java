package com.yonghyun.projectStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonghyun.projectStudy.dao.EmployeeDao;
import com.yonghyun.projectStudy.domain.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(id);
	}
	
}
