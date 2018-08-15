package com.chinasoft.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.chinasoft.dao.RkmxDao;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkmx;
import com.chinasoft.domain.User;

@Repository("rkmxDao")
public class RkmxDaoImpl extends BaseDaoImpl<Rkmx> implements RkmxDao{

	public List<Rkmx> findAllRkmxLists(Integer rkdId) throws Exception {
		
		// 级联查询 明天做
		StringBuffer sb = new StringBuffer();
		sb.append("select * from tb_rkmx ");
		sb.append(" where rkd_id = '"+rkdId+"' ");
		
		Query query = this.getCurrentSession().createSQLQuery(sb.toString());
		
		return query.list();
	}


}
