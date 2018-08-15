package com.chinasoft.service;

import java.util.List;

import com.chinasoft.domain.Clothing;

public interface ClothingService {

	// 添加一个衣服
	void saveClothing(Clothing clothing) throws Exception;

	List<Clothing> findAllClothing() throws Exception;

	void deleteClothingByClotId(Integer clotId) throws Exception;

	List<Clothing> findClothingByClothing(Clothing clothing) throws Exception;

	List<Clothing> findClothingList(Clothing clothing) throws Exception;

	Clothing getUserById(Integer clotId) throws Exception;

	// 更新衣服
	void update(Clothing clothing,Integer clotId) throws Exception;

	List<Clothing> findColorList() throws Exception;
	
	List<Clothing> findSizeList() throws Exception;

	Clothing getClothingByHh(String rkmxHh) throws Exception;



	
}
