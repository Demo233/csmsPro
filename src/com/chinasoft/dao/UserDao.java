package com.chinasoft.dao;

import java.io.Serializable;
import java.util.List;

import com.chinasoft.domain.User;

public interface UserDao extends BaseDao<User>{
	
	User getByUserLogin(String userLogin);

	// 根据用户名和密码查找一个状态值
	User selFlagByLoginAndPwd(String userLogin, String userPwd);

	// 更新或保存
	void saveOrUpdate(User user);

	// 根据登录名查找用户
	User findUserByUserLogin(String userLogin);

	// 根据用户名或姓名查找用户
	List<User> findUserByLoginOrName(String userLogin, String userName) throws Exception;
	
}
