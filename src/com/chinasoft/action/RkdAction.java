package com.chinasoft.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.Ck;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkd;
import com.chinasoft.service.CkService;
import com.chinasoft.service.ClothingService;
import com.chinasoft.service.RkdService;
import com.chinasoft.utils.CreateNumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("rkdAction")
@Scope("prototype")
public class RkdAction extends ActionSupport{
	
	@Resource(name="ckService")
	private CkService ckService;
	
	@Resource(name="clothingService")
	private ClothingService clothingService;
	
	@Resource(name="rkdService")
	private RkdService rkdService;
	
	private String ckId;
	private String rkdId;
	private String ckName;
	private String rkdNum;
	private String date1;
	private String date2;
	public Rkd rkd = new Rkd();
	
	@Login
	public String saveRkdBut() throws Exception{
		
		// 自动编号进行回显跳转到orderadd.jsp
		String Num = CreateNumUtils.getRkcNum();
		ActionContext.getContext().put("Num", Num);
		
		// 查找所有仓库信息
		List<Ck> ckLists = this.rkdService.findCkLists();
		ActionContext.getContext().put("ckLists", ckLists);
		
		
		return "rkdButSuccess";
	}
	
	
	// 查找所有的lists
	@Login
	public String rkdLists() throws Exception{
		try{
			
			List<Rkd> rkdLists = this.rkdService.findAllRkdList();
			ActionContext.getContext().put("rkdLists", rkdLists);
			
			// 查找仓库lists
			List<Ck> ckLists = this.ckService.findAllCk();
			ActionContext.getContext().put("ckLists", ckLists);
			
			rkdLists = this.rkdService.findRkd(ckName,rkdNum,date1,date2);
			ActionContext.getContext().put("rkdLists", rkdLists);
			
			return "listsSuccess";
		}catch (Exception e) {
			e.printStackTrace();
			return "listsError";
		}
	}
	
	// 添加入库单
	@Login
	public String saveRkd() throws Exception{
		
		//System.out.println(rkd);
		if(rkd.getCkName()==null || rkd.getCkName().trim().equals("")){
			this.addActionError("仓库名称不能为空!!!");
			return "saveRkdError";
		}
		if(rkd.getRkdBly()==null || rkd.getRkdBly().trim().equals("")){
			this.addActionError("办理人不能为空!!!");
			return "saveRkdError";
		}
		if(rkd.getRkdLy()==null || rkd.getRkdLy().trim().equals("")){
			this.addActionError("来源不能为空!!!");
			return "saveRkdError";
		}
		
		this.rkdService.save(rkd);
		return "saveRkdSuccess";
		
	}
	
	// 根据页面传来的rkdId查找数据回显到页面
	@Login
	public String updateBut() throws Exception{
		
		// 根据rkdId查找rkd
		Rkd rkd = this.rkdService.getRkdById(rkdId);
		ServletActionContext.getContext().getValueStack().push(rkd);
		
		List<Ck> ckLists = this.ckService.findAllCk();
		
		ActionContext.getContext().put("ckLists", ckLists);
		
		return "updateButSuccess";
	}
	

	// -----------------------setter and getter -------------------------
	public String getCkName() {
		return ckName;
	}

	public void setCkName(String ckName) {
		this.ckName = ckName;
	}

	public String getCkId() {
		return ckId;
	}

	public void setCkId(String ckId) {
		this.ckId = ckId;
	}

	public String getRkdId() {
		return rkdId;
	}

	public void setRkdId(String rkdId) {
		this.rkdId = rkdId;
	}


	public String getRkdNum() {
		return rkdNum;
	}

	public void setRkdNum(String rkdNum) {
		this.rkdNum = rkdNum;
	}


	public String getDate1() {
		return date1;
	}


	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}


	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
}
