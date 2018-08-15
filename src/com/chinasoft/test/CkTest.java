package com.chinasoft.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasoft.dao.CkDao;
import com.chinasoft.domain.Ck;
import com.chinasoft.service.CkService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CkTest {

	@Resource(name="ckService")
	private CkService ckService;
	
	@Test
	// Ck 添加
	public void demo1(){
		Ck ck = new Ck();
		ck.setKcl(600);
		ck.setLxr("张三");
		ck.setName("一号仓库");
		ck.setNum("CK0010");
		ck.setDh("122222222222");
		try {
			ckService.save(ck);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void demo2() throws Exception{
		Ck ck = new Ck();
		ck.setNum("CK20160701145333");
		ck.setName("一号仓库");
		List<Ck> cks = this.ckService.findAllCk(ck);
		System.out.println(cks);
	}
}
