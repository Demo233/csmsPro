package com.chinasoft.action;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.Rkd;
import com.chinasoft.domain.Rkmx;
import com.chinasoft.service.ClothingService;
import com.chinasoft.service.RkdService;
import com.chinasoft.service.RkmxService;
import com.chinasoft.utils.CreateNumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("rkmxAction")
@Scope("prototype")
public class RkmxAction extends ActionSupport{

	@Resource(name="rkmxService")
	private RkmxService rkmxService;
	
	@Resource(name="clothingService")
	private ClothingService clothingServie;
	
	private String num;
	private Set<String> clotSet; //提供getter方法
	private Clothing clothing;	//衣服
	private Integer count;	//数量
	private String rkdId; //拿到${param.rkdId}
	
	//private String ckName;
	//private String ckId;
	//private String rkdId;
	
	public Rkmx rkmx = new Rkmx();
	
	// 当点击添加按钮
	@Login
	public String saveBut() throws Exception{
		
		List<Clothing> clotLists = this.clothingServie.findAllClothing();
		ActionContext.getContext().put("clotLists", clotLists);
		
		return "saveButSuccess";
	}
	
	@Login
	public String save() throws Exception{
		
		String rkmxNum = CreateNumUtils.getRkmxNum();
		// 如果他没有选择衣服保存，就跳到error.jsp
		if(rkdId != null && !rkdId.trim().equals("")){
			if(count != null && count != 0){
				this.rkmxService.save(rkdId,count,rkmxNum);
			}
		}
		return "saveSuccess";
	}
	
	@Login
	public String rkmxLists() throws Exception{
		try {
			
			List<Rkmx> rkmxLists = this.rkmxService.findAllRkmx(rkdId);
			
			ActionContext.getContext().put("rkLists", rkmxLists);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listSuccess";
	}
	

	
	// 根据衣服编号查找衣服
	@Login
	public String getClothingByAjax() throws Exception{
		
		//System.out.println(num);
		Clothing clot = this.rkmxService.getClothingByclotNum(num);
		clotSet = new LinkedHashSet<String>();
		if(clot!=null){
			String clotColor = clot.getClotColor();
			Integer clotSize = clot.getClotSize();
			String clotBrand = clot.getClotBrand();
			clotSet.add(clotColor);
			clotSet.add(clotSize.toString());
			clotSet.add(clotBrand);
		}
		return "getClothingByAjaxSuccess";
	}

	
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Set<String> getClotSet() {
		return clotSet;
	}

	public String getRkdId() {
		return rkdId;
	}

	public void setRkdId(String rkdId) {
		this.rkdId = rkdId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	/*	
	public String save() throws Exception{
		
		//System.out.println(rkmx);
		if(rkmx.getHh() == null || rkmx.getHh().trim().equals("")){
			this.addActionError("货号不能为空!!");
			return "saveError";
		}
		
		if(rkmx.getColor() == null || rkmx.getColor().trim().equals("")){
			this.addActionError("颜色不能为空!!");
			return "saveError";
		}
		if(rkmx.getCount() == null){
			this.addActionError("数量不能为空!!");
			return "saveError";
		}
		if(rkmx.getSize() == null || rkmx.getSize().equals("")){
			this.addActionError("尺码不能为空!!");
			return "saveError";
		}
		
		this.rkmxService.save(rkmx);
		return "save";
	}
	*/
	
	/*public String saveToLists() throws Exception{
		
		//System.out.println(count);
		//System.out.println(clothing);
		//System.out.println(rkdId);
		
		this.rkmxService.save(count,clothing,rkdId);
		
		//ActionContext.getContext().put("rkmxLists", rkmxLists);
		
		return "saveSuccess";
	}
	
	public String rkmxLists() throws Exception{
		try{
			// 查找所有入库明细
			List<Rkmx> rkmxLists = this.rkmxService.findAllRkmxLists();
			ActionContext.getContext().put("rkmxLists", rkmxLists);
			
			// 查找所有衣服信息
			
			
			// 需要显示的内容
			// 2.入库单明细的信息
			Rkmx rkmx = this.rkmxService.getRkmxById(rkmxId);
			Integer count = rkmx.getCount();
			ActionContext.getContext().put("count", count);
			// 1.入库单的信息
			Rkd rkd = rkmx.getRkd();
			ActionContext.getContext().put("rkd", rkd);
			
			// 3.Clothing
			String rkmxHh = rkmx.getHh();
			Clothing clothing = this.clothingService.getClothingByHh(rkmxHh);
			ActionContext.getContext().put("clothing", clothing);
			
			//Integer ckId = (Integer) ActionContext.getContext().getSession().get("ckId");
			//Clothing clothing = this.rkmxService.findAllRkmxLists(ckId);
			//ActionContext.getContext().put("rkmxLists", rkmxLists);
			return "listSuccess";
		}catch (Exception e) {
			e.printStackTrace();
			return "listError";
		}
	}*/
	
	
	

}
