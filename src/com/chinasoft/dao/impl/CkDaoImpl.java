package com.chinasoft.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.chinasoft.dao.CkDao;
import com.chinasoft.domain.Ck;

@Repository("ckDao")
public class CkDaoImpl extends BaseDaoImpl<Ck> implements CkDao{

	public List<Ck> findAll(Ck ck) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("from Ck c where 1=1 ");
		if(ck != null){
			if(ck.getNum() != null&&!ck.getNum().equals("")){
				sb.append(" and c.num='"+ck.getNum()+"' ");
			}
			if(ck.getName() != null&&!ck.getName().equals("")){
				sb.append(" and c.name='"+ck.getName()+"' ");
			}
		}
		
		Query query = this.getCurrentSession().createQuery(sb.toString());
		return query.list();
	}

	public Ck getCkByName(String ckName) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("from Ck c ");
		sb.append(" where c.name=? ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		query.setParameter(0, ckName);
		return (Ck) query.uniqueResult();
	}

}
