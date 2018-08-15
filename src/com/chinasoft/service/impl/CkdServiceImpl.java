package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.dao.CkdDao;
import com.chinasoft.domain.Ckd;
import com.chinasoft.service.CkdService;

@Service("ckdService")
@Transactional
public class CkdServiceImpl implements CkdService{

	@Resource(name="ckdDao")
	private CkdDao ckdDao;
	
	public void save(Ckd ckd) throws Exception{
		this.ckdDao.save(ckd);
	}

	public List<Ckd> findAll() throws Exception {
		
		return this.ckdDao.findAll();
	}

}
