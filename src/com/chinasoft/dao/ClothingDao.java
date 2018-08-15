package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.domain.Clothing;

public interface ClothingDao extends BaseDao<Clothing>{

	// 根据Clogthing查找Clothing
	List<Clothing> findClothingByClothing(Clothing clothing) throws Exception;

	List<Clothing> findColorList() throws Exception;
	
	List<Clothing> findSizeList() throws Exception;

	Clothing getClothingByclotNum(String num);

}
