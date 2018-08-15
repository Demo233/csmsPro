package com.chinasoft.service;

import java.util.List;

import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkmx;

public interface RkmxService {

	// 添加入库明细单 测试用的
	void save(Rkmx rkmx);
	
	// ajax查找一件衣服
	Clothing getClothingByclotNum(String num) throws Exception;
	
	// 保存一个入库明细单
	void save(String rkdId, Integer count, String rkmxNum) throws Exception;

	// 根据传过来的参数查找所有入库明细
	List<Rkmx> findAllRkmx(String rkdId) throws Exception;
	
	/*
	// 保存入库明细
	//List<Rkmx> save(Integer count, Clothing clothing, String rkdId) throws Exception;
	void save(Integer count, Clothing clothing, String rkdId) throws Exception;

	List<Rkmx> findAllRkmxLists() throws Exception;

	Rkmx getRkmxById(String rkmxId) throws Exception;*/


	
}
