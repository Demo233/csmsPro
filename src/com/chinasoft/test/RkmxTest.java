package com.chinasoft.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasoft.domain.Ck;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkd;
import com.chinasoft.domain.Rkmx;
import com.chinasoft.service.RkmxService;
import com.chinasoft.utils.CreateNumUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RkmxTest {

	@Resource(name="rkmxService")
	private RkmxService rkmxService;
	
	@Test
	public void demo1(){
		Rkmx rkmx = new Rkmx();
		Ck ck = new Ck();
		ck.setId(2);
		Rkd rkd = new Rkd();
		rkd.setRkdId(88);
		rkmx.setCk(ck);
		rkmx.setRkd(rkd);
		rkmx.setRkmxNum(CreateNumUtils.getRkmxNum());
		rkmx.setCount(500);
		this.rkmxService.save(rkmx);
	}
}
