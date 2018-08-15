package com.chinasoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.dao.UserDao;
import com.chinasoft.domain.User;
import com.chinasoft.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	public int saveUser(User user) throws Exception {
		User u = userDao.getByUserLogin(user.getUserLogin());
		if (u != null) {
			return -1;
		} else {
			user.setFlag(0);
			userDao.save(user);
			return 1;
		}
	}

	// 根据用户名和密码查找用户
	public int selFlagByLoginAndPwd(String userLogin, String userPwd)
			throws Exception {
		User user = userDao.selFlagByLoginAndPwd(userLogin, userPwd);
		if (user != null) {
			return user.getFlag();
		}
		return 2;
	}

	public List<User> findAllUser() throws Exception {

		List<User> users = userDao.findAll();
		return users;

	}

	public User findUserByUserLogin(String userLogin) throws Exception {
		User user = userDao.findUserByUserLogin(userLogin);
		return user;
	}

	public User getUserById(Integer id) throws Exception {
		if (id == null) {
			throw new RuntimeException("id不能为空");
		}
		User user = userDao.getById(id);
		return user;
	}

	public void saveUser(String userLogin, String userName, String userPwd,
			String note) throws Exception {

		User user = new User();
		user.setUserLogin(userLogin);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setNote(note);
		user.setFlag(0);
		userDao.save(user);

	}

	// 更新用户
	public void updateUser(Integer id, User user) throws Exception {

		User u = userDao.getById(id);
		u.setUserName(user.getUserName());
		u.setUserPwd(user.getUserPwd());
		u.setNote(user.getNote());
		userDao.update(u);

	}

	// 根据id删除用户
	public void deleteUserById(Integer id) throws Exception {
		if (id == null) {
			throw new RuntimeException("id不能为空");
		} else {
			userDao.delete(id);
		}
	}

	// 根据用户名或姓名查找用户
	public List<User> findUserByLoginOrName(String userLogin, String userName)
			throws Exception {
		
		if(userLogin == null || userName == null){
			throw new RuntimeException("用户名或登录名不能为空!!!");
		}else{
			List<User> users = this.userDao.findUserByLoginOrName(userLogin,userName);
			return users;
		}
	}

	// 更新用户名密码
	public void updateUser(User sessionUser, String newPwd1) throws Exception {
		
		if(sessionUser != null){
			sessionUser.setUserPwd(newPwd1);
			this.userDao.update(sessionUser);
		}else{
			throw new RuntimeException("请重新登录!!!");
		}
	}

}
