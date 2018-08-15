package com.chinasoft.service;

import java.util.List;

import com.chinasoft.domain.Ck;
import com.chinasoft.domain.Rkd;

public interface RkdService {

	// 添加入库单
	void save(Rkd rkd) throws Exception;

	List<Ck> findCkLists() throws Exception;

	Rkd getRkdById(String rkdId) throws Exception;

	List<Rkd> findAllRkdList() throws Exception;

	List<Rkd> findRkd(String ckName, String rkdNum, String date1, String date2) throws Exception;

	
}
