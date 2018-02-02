package com.yonghyun.projectStudy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonghyun.projectStudy.dao.StudiesDao;
import com.yonghyun.projectStudy.domain.Studies;

@Service
@Transactional
public class StudiesServiceImpl implements StudiesService{
	@Autowired StudiesDao studiesDao;
	static final private Logger logger = LoggerFactory.getLogger(StudiesService.class);
	
	@Override
	public Studies addStudies(Studies study) {
		
		logger.info("StudiesService ==>" + study.getUsersEmail());
		logger.info("StudiesService ==>" + study.getImgName());
		// TODO Auto-generated method stub
		return studiesDao.addStudies(study);
	}

	@Override
	public List<Studies> getAllStudies() {
		// TODO Auto-generated method stub
		return studiesDao.getAllStudies();
	}
}
