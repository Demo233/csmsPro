package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.dao.CkDao;
import com.chinasoft.domain.Ck;
import com.chinasoft.service.CkService;

@Service("ckService")
@Transactional
public class CkServiceImpl implements CkService{

	@Resource(name="ckDao")
	private CkDao ckDao;
	
	public void save(Ck ck) throws Exception {
		
		this.ckDao.save(ck);
		
	}

	public List<Ck> findAllCk(Ck ck) throws Exception {
		if(ck.getNum() == null && ck.getName()==null){
			List<Ck> cks = this.ckDao.findAll();
			return cks;
		}else{
			List<Ck> cks = this.ckDao.findAll(ck);
			return cks;
		}
	}

	public void deleteCkById(Integer id) throws Exception {
		if(id!=null){
			this.ckDao.delete(id);
		}else{
			throw new RuntimeException("id不能为空");
		}
	}

	public Ck getCkById(Integer id) throws Exception {
		
		return this.ckDao.getById(id);
	}

	public void updateCk(Ck ck1, Integer id) throws Exception {
		
		// 校验...
		
		// 根据id查找仓库
		Ck ck = this.ckDao.getById(id);
		if(ck!=null){
			ck.setDh(ck1.getDh());
			ck.setKcl(ck1.getKcl());
			ck.setLxr(ck1.getLxr());
			ck.setName(ck1.getName());
			this.ckDao.update(ck);
		}
		
	}
	
	// 根据name查找仓库
	public Ck getCkByName(String ckName) throws Exception {
		
		if(ckName != null){
			return this.ckDao.getCkByName(ckName);
		}else{
			throw new RuntimeException("仓库名不能为空!!");
		}
	}

	// 查找所有仓库
	public List<Ck> findAllCk() throws Exception {
		
		return this.ckDao.findAll();
	}

}
