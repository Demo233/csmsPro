package com.chinasoft.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.chinasoft.dao.UserDao;
import com.chinasoft.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User getByUserLogin(String userLogin) {
		StringBuffer sb = new StringBuffer();
		sb.append("from User ");
		sb.append(" where userLogin=? ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		query.setParameter(0, userLogin);
		return (User) query.uniqueResult();
	}

	// 根据用户名和密码查找用户
	public User selFlagByLoginAndPwd(String userLogin, String userPwd) {
		StringBuffer sb = new StringBuffer();
		sb.append("from User ");
		sb.append(" where userLogin=? ");
		sb.append(" and userPwd=? ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		query.setParameter(0, userLogin);
		query.setParameter(1, userPwd);
		return (User) query.uniqueResult();
	}

	public void saveOrUpdate(User user) {
		this.getCurrentSession().saveOrUpdate(user);
	}

	public User findUserByUserLogin(String userLogin) {
		StringBuffer sb = new StringBuffer();
		sb.append("from User ");
		sb.append(" where userLogin=? ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		query.setParameter(0, userLogin);
		return (User) query.uniqueResult();
	}

	public List<User> findUserByLoginOrName(String userLogin, String userName)
			throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("from User");
		sb.append(" where 1=1 ");
		if(userLogin != null && !userLogin.equals("")){
			sb.append(" and userLogin='"+userLogin+"' ");
		}
		if(userName != null && !userName.equals("")){
			sb.append(" and userName='"+userName+"' ");
		}
		Query query = this.getCurrentSession().createQuery(sb.toString());
		
		return  query.list();
	}
}
