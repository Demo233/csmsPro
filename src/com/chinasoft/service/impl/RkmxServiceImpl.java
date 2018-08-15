package com.chinasoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.dao.CkDao;
import com.chinasoft.dao.ClothingDao;
import com.chinasoft.dao.RkdDao;
import com.chinasoft.dao.RkmxDao;
import com.chinasoft.domain.Ck;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkd;
import com.chinasoft.domain.Rkmx;
import com.chinasoft.service.RkmxService;

@Service("rkmxService")
@Transactional
public class RkmxServiceImpl implements RkmxService {

	@Resource(name="rkdDao")
	private RkdDao rkdDao;
	
	@Resource(name="ckDao")
	private CkDao ckDao;
	
	@Resource(name="rkmxDao")
	private RkmxDao rkmxDao;
	
	@Resource(name="clothingDao")
	private ClothingDao clothingDao;

	public void save(Rkmx rkmx) {
		if (rkmx != null) {
			this.rkmxDao.save(rkmx);
		}else{
			throw new RuntimeException("入库明细单不能为空!!");
		}
	}

	// ajax查找意见衣服
	public Clothing getClothingByclotNum(String num) throws Exception {
		
		return this.clothingDao.getClothingByclotNum(num);
	}
	// 保存一个入库单信息
	public void save(String rid, Integer count, String rkmxNum)
			throws Exception {
		
		// 拿到ckId
		Integer rkdId = Integer.valueOf(rid);
		Rkd rkd = this.rkdDao.getById(rkdId);
		String ckName = rkd.getCkName();
		Ck ck = this.ckDao.getCkByName(ckName);
		Integer sysKcl = ck.getSyskcl();
		
		//看cout是否小于所存仓库的syskcl字段
		if(count < sysKcl){
			sysKcl = sysKcl - count;
			ck.setSyskcl(sysKcl);
			
			Rkmx rkmx = new Rkmx();
			
			rkmx.setRkd(rkd);
			rkmx.setCount(count);
			rkmx.setCk(ck);
			rkmx.setRkmxNum(rkmxNum);
			this.rkmxDao.save(rkmx);
			
		}else{
			throw new RuntimeException("仓库不足请重试!!!");
		}
		
	}

	public List<Rkmx> findAllRkmx(String rid) throws Exception {
		if(rid != null){
			Integer rkdId = Integer.valueOf(rid);
			return this.rkmxDao.findAllRkmxLists(rkdId);
		}else{
			return this.rkmxDao.findAll();
		}
		
	}
	
/*
	public void save(Integer count, Clothing clothing, String rid)
			throws Exception {
		String color = clothing.getClotColor();
		Integer size = clothing.getClotSize();
		String hh = clothing.getClotNum();
		if(color == null && color.equals("")){
			throw new RuntimeException("颜色不能为空!!");
		}
		if(size == null){
			throw new RuntimeException("大小不能为空!!");
		}
		if(hh == null && hh.equals("")){
			throw new RuntimeException("货号不能为空!!");
		}
		if(rid == null && rid.equals("")){
			throw new RuntimeException("入库单ID不能为空!!");
		}
		
		// 根据rkdId查找rkd单中的ckName(ck_name)字段
		Integer rkdId = Integer.valueOf(rid);
		Rkd rkd = this.rkdDao.getById(rkdId);
		if(rkd==null){
			throw new RuntimeException("请先填写入库单再添加明细!!!");
		}
		String ckName = rkd.getCkName();
		
		//根据CkName查找到对应仓库
		Ck ck = this.ckDao.getCkByName(ckName);
		
		Integer ckl =  ck.getKcl();
		if(ckl < count){
			throw new RuntimeException("该仓库库存量不足，请重新填写!!!");
		}else{
			// 存储入库明细单
			ckl = ckl - count;
			ck.setSyskcl(ckl);
			
			Rkmx rkmx = new Rkmx();
			rkmx.setCk(ck);
			rkmx.setColor(color);
			rkmx.setCount(count);
			rkmx.setHh(hh);
			rkmx.setRkd(rkd);
			rkmx.setSize(size);
			
			List<Rkmx> rkmxLists = new ArrayList<Rkmx>();
			rkmxLists.add(rkmx);
			return rkmxLists;
			this.rkmxDao.save(rkmx);
		}
		
	}*/


/*
	public Rkmx getRkmxById(String mxId) throws Exception {
		
		if(mxId == null || mxId.equals("")){
			throw new RuntimeException("请添加明细！！！");
		}
		Integer rkmxId = Integer.valueOf(mxId);
		return this.rkmxDao.getById(rkmxId);
	}

	// 查找所有入库明细
	public List<Rkmx> findAllRkmxLists() throws Exception {
		
		return this.rkmxDao.findAll();
	}*/

}
