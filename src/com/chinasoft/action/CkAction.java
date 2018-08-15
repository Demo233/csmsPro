package com.chinasoft.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.Ck;
import com.chinasoft.service.CkService;
import com.chinasoft.utils.CreateNumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ckAction")
@Scope("prototype")
public class CkAction extends ActionSupport {

	@Resource(name = "ckService")
	private CkService ckService;
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Ck ck = new Ck();

	@Login
	public String ckAddBut() {

		// System.out.println("111");
		String num = CreateNumUtils.getCkNum();
		ActionContext.getContext().put("num", num);

		return "addSuccess";
	}

	@Login
	public String save() throws Exception {
		// 校验字段是否为空，如果为空则返回值原页面

		if (ck != null) {
			if(ck.getName().equals("")){
				this.addActionError("仓库名称不能为空!!");
				return "saveError";
			}
			if(ck.getNum().equals("")){
				this.addActionError("仓库编号不能为空!!");
				return "saveError";
			}
			if(ck.getLxr().equals("")){
				this.addActionError("仓库联系人不能为空!!");
				return "saveError";
			}
			if(ck.getDh().equals("")){
				this.addActionError("电话不能为空!!");
				return "saveError";
			}
			if(ck.getKcl() == null){
				this.addActionError("仓储量不能为空!!");
				return "saveError";
			}
			this.ckService.save(ck);
			return "saveSuccess";
		} else {
			this.addActionError("请填写正确信息!");
			return "saveError";
		}
	}

	@Login
	public String ckList() throws Exception {
		// 查找所有的仓库
		List<Ck> cks = this.ckService.findAllCk(ck);
		ActionContext.getContext().put("cks", cks);
		return "listSuccess";
	}
	
	// 删除仓库
	@Login
	public String delete() throws Exception{
		
		//System.out.println(id);
		if(id != null){
			this.ckService.deleteCkById(id);
			return "delete";
		}else{
			this.addActionError("请重试!!!");
			return "deleteError";
		}
	}
	
	@Login
	public String updateBut() throws Exception{
		
		// 根据id查询仓库信息
		Ck ck = this.ckService.getCkById(id);
		ActionContext.getContext().put("ck", ck);
		return "updateBut";
	}
	
	@Login
	public String updateCk() throws Exception{
		
		// 更新仓库信息
		if(id!=null){
			this.ckService.updateCk(ck,id);
			return "update";
		}else{
			this.addActionError("仓库id不能为空");
			return "updateError";
		}
		
	}
}
