package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.domain.Ck;

public interface CkDao extends BaseDao<Ck>{

	List<Ck> findAll(Ck ck) throws Exception;

	Ck getCkByName(String ckName) throws Exception;

}
