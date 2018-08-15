package com.chinasoft.service;

import java.util.List;

import com.chinasoft.domain.User;


public interface UserService {

	// 添加用户
	int saveUser(User user) throws Exception;

	// 根据用户名和密码查找用户
	int selFlagByLoginAndPwd(String userLogin, String userPwd) throws Exception;

	List<User> findAllUser() throws Exception;

	User findUserByUserLogin(String userLogin) throws Exception;

	// 根据用户id查找用户
	User getUserById(Integer id) throws Exception;

	// 保存用户
	void saveUser(String userLogin,String userName,String userPwd,String note) throws Exception;

	// 更新用户
	void updateUser(Integer id, User user) throws Exception;

	// 根据id删除用户
	void deleteUserById(Integer id) throws Exception;

	// 根据用户名或姓名查找用户
	List<User> findUserByLoginOrName(String userLogin, String userName) throws Exception;

	
	// 更新用户密码
	void updateUser(User sessionUser, String newPwd1) throws Exception;
	
	
}
