package com.chinasoft.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasoft.domain.Rkd;
import com.chinasoft.service.RkdService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RkdTest {

	@Resource(name="rkdService")
	private RkdService rkdService;

	@Test
	public void demo1() throws Exception{
		Rkd rkd = new Rkd();
		rkd.setCkName("一号仓库");
		rkd.setRkdBly("张三");
		rkd.setRkdDate(new Date());
		rkd.setRkdLy("中软");
		rkd.setRkdNote("test");
		rkd.setRkdNum("RCD0001");
		this.rkdService.save(rkd);
	}
}
