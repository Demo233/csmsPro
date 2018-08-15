package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.dao.ClothingDao;
import com.chinasoft.domain.Clothing;
import com.chinasoft.service.ClothingService;

@Service("clothingService")
@Transactional
public class ClotingServiceImpl implements ClothingService {

	@Resource(name = "clothingDao")
	private ClothingDao clothingDao;

	public void saveClothing(Clothing clothing) throws Exception {
		if (clothing == null) {
			throw new RuntimeException("货物不能为空!!!");
		} else {
			Clothing c = new Clothing();
			c.setClotBrand(clothing.getClotBrand());
			if (!clothing.getClotColor().equals("0")) {
				c.setClotColor(clothing.getClotColor());
			}
			if (!clothing.getClotSize().equals("0")) {
				c.setClotSize(clothing.getClotSize());
			}
			c.setClotLl(clothing.getClotLl());
			c.setClotMl(clothing.getClotMl());
			c.setClotNum(clothing.getClotNum());
			c.setClotPrimPrice(clothing.getClotPrimPrice());
			c.setClotSellPrice(clothing.getClotSellPrice());
			clothingDao.save(c);
		}
	}

	public List<Clothing> findAllClothing() throws Exception {
		List<Clothing> clothings = this.clothingDao.findAll();
		return clothings;
	}

	public void deleteClothingByClotId(Integer clotId) throws Exception {

		if (clotId != null && !clotId.equals("")) {
			this.clothingDao.delete(clotId);
		} else {
			throw new RuntimeException("clotId不能为空!!!");
		}
	}

	public List<Clothing> findClothingByClothing(Clothing clothing)
			throws Exception {
		return null;
	}

	public List<Clothing> findClothingList(Clothing clothing) throws Exception {
		
		return this.clothingDao.findClothingByClothing(clothing);
	}

	// 根据Id查找一个衣服
	public Clothing getUserById(Integer clotId) throws Exception {
		
		return this.clothingDao.getById(clotId);
	}


	public void update(Clothing clothing, Integer clotId) throws Exception {
		if(clothing != null){
			Clothing clot = this.clothingDao.getById(clotId);
			clot.setClotBrand(clothing.getClotBrand());
			clot.setClotColor(clothing.getClotColor());
			clot.setClotLl(clothing.getClotLl());
			clot.setClotMl(clothing.getClotMl());
			clot.setClotPrimPrice(clothing.getClotPrimPrice());
			clot.setClotSellPrice(clothing.getClotSellPrice());
			this.clothingDao.update(clot);
		}else{
			throw new RuntimeException("服装不能为空!!!");
		}	
	}

	public List<Clothing> findColorList() throws Exception {
		List<Clothing> lists = this.clothingDao.findColorList();
		return lists;
	}
	
	public List<Clothing> findSizeList() throws Exception {
		List<Clothing> lists = this.clothingDao.findSizeList();
		return lists;
	}

	public Clothing getClothingByHh(String rkmxHh) throws Exception {
		
		if(rkmxHh!=null && !rkmxHh.equals("")){
			return this.clothingDao.getClothingByclotNum(rkmxHh);
		}else{
			throw new RuntimeException("货号不能为空,请填写入库明细单!!!");
		}
		
	}


	// 根据Clothing查Clothing
	/*public List<Clothing> findClothingByClothing(Clothing clothing)
			throws Exception {

		if(clothing != null){
			
			List<Clothing> clothings = this.clothingDao.findClothingByClothing(clothing);
		}
		return clothings;
		*/
	/*	String clotNum = clothing.getClotNum();
		String clotBrand = clothing.getClotBrand();
		String clotColor = clothing.getClotColor();
		Integer clotSize = clothing.getClotSize();*/
		
		/*if(clotNum != null && !clotNum.equals("0")){
			if(clotBrand != null && !clotBrand.equals("0")){
				if(clotColor != null && !clotColor.equals("0")){
					if(clotSize != null && clotSize != 0){
					}
				}
			}
		}*/
		/*List<Clothing> clothings = this.clothingDao.findAll();
		return clothings;*/
		
		/*
		if (clothing.getClotNum() != null || clothing.getClotBrand() != null
				|| clothing.getClotColor() != null
				|| clothing.getClotSize() != null) {
			clothings = this.clothingDao.findClothingByClothing(clothing);
			return clothings;
		} else {
			clothings = this.clothingDao.findAll();
			return clothings;
		}*/
/*	}*/
}
