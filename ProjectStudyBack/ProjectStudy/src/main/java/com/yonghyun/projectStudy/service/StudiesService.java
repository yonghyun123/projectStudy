package com.yonghyun.projectStudy.service;

import java.util.List;

import com.yonghyun.projectStudy.domain.Studies;

public interface StudiesService {
	Studies addStudies(Studies study);
	List<Studies> getAllStudies();
}
