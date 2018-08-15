package com.chinasoft.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasoft.action.ClothingAction;
import com.chinasoft.dao.ClothingDao;
import com.chinasoft.domain.Clothing;
import com.chinasoft.service.ClothingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ClothingTest {

	@Resource(name="clothingService")
	private ClothingService clothingService;
	
	@Resource(name="clothingAction")
	private ClothingAction clothingAction;
	
	
	@Test
	// 添加一个衣服
	public void saveClothing(){
		
		Clothing c = new Clothing();
		c.setClotNum("1111");
		c.setClotBrand("xxx");
		c.setClotColor("red");
		c.setClotSize(170);
		c.setClotMl("布");
		c.setClotPrimPrice(100d);
		c.setClotSellPrice(200d);
		try {
			clothingService.saveClothing(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void demo(){
		System.out.println(clothingAction);
	}
	
	@Test
	// 测试findClothingByClothing
	public void findClothingByClothingTest(){
		 Clothing clothing = new Clothing();
		 clothing.setClotBrand("b");
		 clothing.setClotColor("大红色");
		 try {
			List<Clothing> clothings = this.clothingService.findClothingByClothing(clothing);
			System.out.println(clothings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void demo1() throws Exception{
		List<Clothing> lists = this.clothingService.findColorList();
		System.out.println(lists);
	}
	
	
}
