package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.domain.Rkd;

public interface RkdDao extends BaseDao<Rkd>{

	Rkd findRckByNum(String rkdNum);

	List<Rkd> findRkd(String ckName, String rkdNum, String date1, String date2);

}
