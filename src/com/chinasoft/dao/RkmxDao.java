package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkmx;

public interface RkmxDao extends BaseDao<Rkmx>{

	List<Rkmx> findAllRkmxLists(Integer rkdId) throws Exception;


}
