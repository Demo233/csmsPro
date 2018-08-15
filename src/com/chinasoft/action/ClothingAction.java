package com.chinasoft.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.Clothing;
import com.chinasoft.domain.User;
import com.chinasoft.service.ClothingService;
import com.chinasoft.utils.CreateNumUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("clothingAction")
@Scope("prototype")
public class ClothingAction extends ActionSupport {

	private String clotSize;
	
	public String getClotSize() {
		return clotSize;
	}

	public void setClotSize(String clotSize) {
		this.clotSize = clotSize;
	}

	@Resource(name = "clothingService")
	private ClothingService clothingService;

	// 用于保存clothing
	public Clothing clothing = new Clothing(); 

	private Integer clotId;

	@Login
	public String save() throws Exception {
		try{
			this.clothingService.saveClothing(clothing);
			return "saveSuccess";
		}catch (Exception e) {
			this.addActionError("数据异常请重试!!");
			return "saveError";
		}

	}

	@Login
	public String delete() throws Exception {

		if (clotId != null) {
			this.clothingService.deleteClothingByClotId(clotId);
		}
		return "deleteSuccess";
	}

	/*
	 * public String findClothing() throws Exception{
	 * 
	 * List<Clothing> clothings =
	 * this.clothingService.findClothingByClothing(clothing);
	 * if(clothings.size()!=0){
	 * //ServletActionContext.getRequest().setAttribute("clothings", clothings);
	 * ActionContext.getContext().put("clots", clothings); }else{
	 * this.addActionError("没有该记录!!!"); return "findError"; } return
	 * "findSuccess"; }
	 */

	@Login
	public String clothingAddBut() {

		String clotNum = CreateNumUtils.generate();
		ActionContext.getContext().put("clotNum", clotNum);

		return "clothingAddButSuccess";
	}

	@Login
	public String clothingList() throws Exception {

		// 带条件查询所有list
		List<Clothing> lists = this.clothingService.findClothingList(clothing);
		ActionContext.getContext().put("lists", lists);

		// 不带条件查询所有list
		List<Clothing> hHLists = this.clothingService.findClothingList(null);
		ActionContext.getContext().put("hHLists", hHLists);
		return "list";

	}
	
	@Login
	public String updateBut() throws Exception{
	
		// 根据id查找一件衣服回显
		Clothing clot = this.clothingService.getUserById(clotId);
		ActionContext.getContext().put("clot", clot);
		
		// 查找所有的色号
		List<Clothing> ysLists = this.clothingService.findColorList();
		ActionContext.getContext().put("ysLists", ysLists);
		
		// 查找所有的大小号
		List<Clothing> sizeLists = this.clothingService.findSizeList();
		ActionContext.getContext().put("sizeLists", sizeLists);
		return "updateBut";
	}
	
	@Login
	public String updateClothing() throws Exception{
		
		if(clothing != null){
			if(clotSize!=null && !clotSize.equals("")){
				Integer clotSize1 = Integer.valueOf(clotSize);
				clothing.setClotSize(clotSize1);
			}
			if(!clothing.getClotColor().equals("0") && clothing.getClotSize() != null){
				
				this.clothingService.update(clothing,clotId);
				return "update";
			}else{
				this.addActionError("色号或尺码不能为空");
				return "updateError";
			}
		}else{
			this.addActionError("请重试!!!");
			return "updateError";
		}
	}

	// ------------------getter and setter ---------------------
	
	public Integer getClotId() {
		return clotId;
	}

	public void setClotId(Integer clotId) {
		this.clotId = clotId;
	}
}
