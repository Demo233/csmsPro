package com.chinasoft.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.Ckd;
import com.chinasoft.service.CkdService;
import com.chinasoft.utils.CreateNumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ckdAction")
@Scope("prototype")
public class CkdAction extends ActionSupport {

	@Resource(name="ckdService")
	private CkdService ckdService;
	
	private Ckd ckd;
	
	@Login
	public String saveCkdBut() throws Exception{
		
		// 生成随机单号
		String bh = CreateNumUtils.getCkmxNum();
		ActionContext.getContext().put("bh", bh);
		return "butSuccess";
	}
	
	// 保存出库单
	@Login
	public String saveCkd() throws Exception{
		//System.out.println(ckd);
		if(ckd!=null){
			this.ckdService.save(ckd);
			return "saveSuccess";
		}else{
			this.addActionError("请填写正确信息!!!");
			return "saveError";
		}
	}
	
	//查询所有的出库单
	@Login
	public String ckdLists() throws Exception{
		
		List<Ckd> ckdLists = this.ckdService.findAll();
		ActionContext.getContext().put("ckdLists", ckdLists);
		return "listSuccess";
		
	}
	
	//------------------------------------------getter and setter ------------------------------
	public Ckd getCkd() {
		return ckd;
	}
	public void setCkd(Ckd ckd) {
		this.ckd = ckd;
	}
	
}
