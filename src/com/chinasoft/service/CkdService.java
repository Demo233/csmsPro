package com.chinasoft.service;

import java.util.List;

import com.chinasoft.domain.Ckd;

public interface CkdService {

	// 添加测试
	void save(Ckd ckd) throws Exception;

	List<Ckd> findAll() throws Exception;

	
}
