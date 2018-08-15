package com.chinasoft.service;

import java.util.List;

import com.chinasoft.domain.Ck;

public interface CkService {

	// 添加
	void save(Ck ck) throws Exception;

	// 查找所有仓库
	List<Ck> findAllCk(Ck ck) throws Exception;

	void deleteCkById(Integer id) throws Exception;

	Ck getCkById(Integer id) throws Exception;

	void updateCk(Ck ck, Integer id) throws Exception;

	// 根据name查找仓库
	Ck getCkByName(String ckName) throws Exception;
	
	// 查找所有仓库
	List<Ck> findAllCk() throws Exception;
	
}
