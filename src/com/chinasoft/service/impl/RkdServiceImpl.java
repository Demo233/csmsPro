package com.chinasoft.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.dao.CkDao;
import com.chinasoft.dao.RkdDao;
import com.chinasoft.domain.Ck;
import com.chinasoft.domain.Rkd;
import com.chinasoft.service.RkdService;

@Service("rkdService")
@Transactional
public class RkdServiceImpl implements RkdService{

	@Resource(name="rkdDao")
	private RkdDao rkdDao;
	
	@Resource(name="ckDao")
	private CkDao ckDao;
	
	public void save(Rkd rkd1) throws Exception{
		
		String rkdNum = rkd1.getRkdNum();
		// 保存之前先查询
		Rkd rkd = this.rkdDao.findRckByNum(rkdNum);
		
		if(rkd == null){
			rkd1.setRkdDate(new Date());
			this.rkdDao.save(rkd1);
		}else{
			throw new RuntimeException("该信息已存在!!!");
		}
		
	}

	public List<Ck> findCkLists() throws Exception {
		
		return this.ckDao.findAll();
	}

	public Rkd getRkdById(String rid) throws Exception {
		
		if(rid == null || rid.equals("")){
			throw new RuntimeException("入库单id不能为空!!!!!");
		}
		Integer rkdId = Integer.valueOf(rid);
		return this.rkdDao.getById(rkdId);
	}

	public List<Rkd> findAllRkdList() throws Exception {
		return this.rkdDao.findAll();
	}

	public List<Rkd> findRkd(String ckName, String rkdNum, String date1, String date2)
			throws Exception {
		
		return this.rkdDao.findRkd(ckName,  rkdNum, date1,  date2);
	}

}
