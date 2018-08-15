package com.chinasoft.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasoft.dao.BaseDao;
import com.chinasoft.dao.impl.BaseDaoImpl;
import com.chinasoft.domain.Ckd;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.User;
import com.chinasoft.service.CkdService;
import com.chinasoft.service.UserService;
import com.chinasoft.utils.CreateNumUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHTest1 {

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="ckdService")
	private CkdService ckdService;
	
	@Test
	// 添加用户测试
	public void saveUserTest(){
		
		User user = new User();
		user.setUserLogin("tom");
		user.setUserName("tom");
		user.setUserPwd("123");
		user.setNote("test");
		user.setFlag(0);
		try {
			int i = userService.saveUser(user);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	// 测试查找一名用户
	public void findUser() throws Exception{
		String userLogin = "tom";
		String userPwd = "123";
		int i = userService.selFlagByLoginAndPwd(userLogin, userPwd);
		System.out.println(i);
	}
	
	// 查找所有用户
	@Test
	public void findAllUser() throws Exception{
		List<User> users = userService.findAllUser();
		System.out.println(users);
	}
	
	
	@Test
	// 测试getUserById
	public void getUserById(){
		try {
			User user = userService.getUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	// 测试更新
	public void updateUser(){
		
		String userName = "admin";
		String userLogin = "admin";
		String userPwd = "333";
		String note = "ssssssssss";
		try {
			//userService.updateUser(userLogin, userName, userPwd, note);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	// 测试saveUser
	public void saveUser(){
		User user = new User();
		user.setUserLogin("tom");
		user.setUserName("tom");
		user.setUserPwd("123");
		user.setNote("ssssssss");
		user.setFlag(0);
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	// 删除一个用户
	public void deleteUserById(){
		try {
			this.userService.deleteUserById(8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	// 测试findUserByLoginOrName
	public void findUserByLoginOrName(){
		String userLogin = "";
		String userName = "asdfasdsdf";
		try {
			User user = (User) this.userService.findUserByLoginOrName(userLogin, userName);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	// 出货单添加测试
	public void save() throws Exception{
		Ckd ckd = new Ckd();
		ckd.setCkdNum(CreateNumUtils.getCkmxNum());
		ckd.setDh("1555555555");
		ckd.setDz("郑州");
		ckd.setJsr("张三");
		ckd.setBz("test");
		this.ckdService.save(ckd);
	}
	
}
