package com.chinasoft.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.User;
import com.chinasoft.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private String oddPwd;
	private String newPwd1;
	private String newPwd2;
	private String userLogin;
	private String userName;
	private String userPwd;
	private User user;
	private Integer id;

	@Resource(name = "userService")
	private UserService userService;

	public String login() throws Exception {

		int flag = userService.selFlagByLoginAndPwd(userLogin, userPwd);
		// 0登录,1被停用,2用户名密码错误
		if (flag == 0) {
			User user = this.userService.findUserByUserLogin(userLogin);
			ActionContext.getContext().getSession().put("user", user);
			return "loginSuccess";
		} else if (flag == 1) {
			this.addActionError("该用户已被停用!!!");
			return "loginDisable";
		} else {
			this.addActionError("用户名密码错误!!!");
			return "loginError";
		}
	}

	// 添加用户
	@Login
	public String saveUser() throws Exception {

		// 如果用户名或密码不为空，添加用户
		if (user.getUserLogin().trim().equals("") || user.getUserPwd().trim().equals("")) {
			this.addActionError("登录名或密码不能为空!!");
			return "saveError";
		} else {
			int flag = userService.saveUser(user);
			if (flag == 1) {
				return "saveSuccess";
			} else {
				this.addActionError("用户名已存在!!");
				return "saveError";
			}
		}

	}

	// 根据传过来的Id修改用户
	@Login
	public String updateUser() throws Exception {

		if(user.getUserPwd()==null || user.getUserPwd().trim().equals("")){
			this.addActionError("用户密码不能为空!!!");
			return "updateError";
		}
		if(user.getUserLogin()==null || user.getUserLogin().trim().equals("")){
			this.addActionError("用户登录名不能为空!!!!");
			return "updateError";
		}
		userService.updateUser(id, user);
		return "updateSuccess";

	}

	// 查找所有用户信息
	@Login
	public String findAllUser() throws Exception {

		List<User> users = userService.findAllUser();
		ActionContext.getContext().put("users", users);
		return "findAllUserSuccess";

	}

	// 根据id删除用户
	@Login
	public String delete() throws Exception {

		userService.deleteUserById(id);
		return "deleteSuccess";

	}

	// 通过页面传上来的ID获取一个用户用于回显数据
	@Login
	public String getUserById() throws Exception {

		// System.out.println(id);
		User user = userService.getUserById(id);
		ActionContext.getContext().getSession().put("user", user);
		return "getUserByIdSuccess";

	}

	// 根据用户姓名或用户登录号查找用户
	@Login
	public String sreach() throws Exception {

		if (userLogin == null && userLogin.equals("")) {
			if (userName == null && userName.equals("")) {
				this.addActionError("用户名或者登录名不能为空!!!");
				return "sreachError";
			}
		}

		List<User> users = this.userService.findUserByLoginOrName(userLogin,
				userName);
		ActionContext.getContext().put("users", users);
		return "sreachSuccess";

	}

	@Login
	public String updatePwd() throws Exception {

		//System.out.println(oddPwd);
		//System.out.println(newPwd1);
		//System.out.println(newPwd2);

		if(oddPwd==null || oddPwd.trim().equals("")){
			this.addActionError("旧密码不能为空!!");
			return "pwdError";
		}
		if(newPwd1==null || newPwd1.trim().equals("")){
			this.addActionError("新密码不能为空!!");
			return "pwdError";
		}
		if(newPwd2==null || newPwd2.trim().equals("")){
			this.addActionError("新密码不能为空!!");
			return "pwdError";
		}
		// 拿到session存的user对象
		User sessionUser = (User) ActionContext.getContext().getSession()
				.get("user");
		if (sessionUser == null) {
			this.addActionError("修改失败，请重新登录!!!");
			return "updatepwdError";
		} 
		else {
			// 对比session中的user是否与原始密码相等
			if (!sessionUser.getUserPwd().equals(oddPwd)) {
				this.addActionError("旧密码错误!!!");
				return "pwdError";
			} 
			else {
				if (newPwd1.equals(newPwd2)) {
					this.userService.updateUser(sessionUser, newPwd1);
					return "updatePwdSuccess";
				}
				else{
					this.addActionError("两次密码不一致！请重新填写!!");
					return "pwdError";
				}
			}
		}

	}
	
	// 退出登录
	@Login
	public String logout(){
		
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	// -----------------------------------getter and
	// setter-----------------------------

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOddPwd() {
		return oddPwd;
	}

	public void setOddPwd(String oddPwd) {
		this.oddPwd = oddPwd;
	}

	public String getNewPwd1() {
		return newPwd1;
	}

	public void setNewPwd1(String newPwd1) {
		this.newPwd1 = newPwd1;
	}

	public String getNewPwd2() {
		return newPwd2;
	}

	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}

}
