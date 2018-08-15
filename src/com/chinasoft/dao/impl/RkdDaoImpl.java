package com.chinasoft.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.chinasoft.dao.RkdDao;
import com.chinasoft.domain.Rkd;

@Repository("rkdDao")
public class RkdDaoImpl extends BaseDaoImpl<Rkd> implements RkdDao{

	public Rkd findRckByNum(String rkdNum) {
		StringBuffer sb = new StringBuffer();
		sb.append("from Rkd r ");
		sb.append("where r.rkdNum=? ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		query.setParameter(0, rkdNum);
		
		return (Rkd) query.uniqueResult();
	}

	public List<Rkd> findRkd(String ckName, String rkdNum, String date1, String date2) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("from Rkd r where 1=1 ");
		if(ckName != null && !ckName.trim().equals("")){
			sb.append(" and r.ckName='"+ckName+"' ");
		}
		if(rkdNum != null && !rkdNum.trim().equals("")){
			sb.append(" and r.rkdNum='"+rkdNum+"' ");
		}
		if(date1 != null && !date1.trim().equals("")){
			if(date2 != null && !date2.trim().equals("")){
				sb.append(" and r.rkdDate>='"+date1+"' and r.rkdDate<='"+date2+"' ");
			}
		}
		Query query = this.getCurrentSession().createQuery(sb.toString());
		
		/*StringBuffer sb = new StringBuffer();
		sb.append("select * from tb_rkd where 1=1 ");
		if(ckName != null && !ckName.trim().equals("")){
			sb.append(" and ck_name='"+ckName+"' ");
		}
		if(rkdNum != null && !rkdNum.trim().equals("")){
			sb.append(" and rkd_num='"+rkdNum+"' ");
		}
		if(date1 != null && !date1.trim().equals("")){
			if(date2 != null && !date2.trim().equals("")){
				sb.append(" and rkd_date>='"+date1+"' and rkd_date='"+date2+"' ");
			}
		}
		Query query = this.getCurrentSession().createSQLQuery(sb.toString());*/
		return query.list();
	}
}
