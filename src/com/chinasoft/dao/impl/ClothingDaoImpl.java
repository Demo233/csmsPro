package com.chinasoft.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.dom4j.io.STAXEventReader;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chinasoft.dao.ClothingDao;
import com.chinasoft.domain.Clothing;

@Repository("clothingDao")
public class ClothingDaoImpl extends BaseDaoImpl<Clothing> implements ClothingDao{

	// 根据Clothing 查询Clothing
	public List<Clothing> findClothingByClothing(Clothing clothing) throws Exception {
		/*String clotNum = clothing.getClotNum();
		String clotBrand = clothing.getClotBrand();
		String clotColor = clothing.getClotColor(); //0
		Integer clotSize = clothing.getClotSize();  //0
		
*/		
		StringBuffer sb = new StringBuffer();
		sb.append("from Clothing c where 1=1 ");
		if(clothing != null){
			if(clothing.getClotNum() != null&&!clothing.getClotNum().trim().equals("")){
				sb.append(" and c.clotNum='"+clothing.getClotNum()+"'");
			}
			if(clothing.getClotBrand() != null && !clothing.getClotBrand().trim().equals("") ){
				sb.append(" and c.clotBrand='"+clothing.getClotBrand()+"' ");
			}
			if(clothing.getClotColor() != null && !clothing.getClotColor().trim().equals("")){
				sb.append(" and c.clotColor='"+clothing.getClotColor()+"' ");
			}
			if(clothing.getClotSize() != null && clothing.getClotSize() != 0){
				sb.append(" and c.clotSize='"+clothing.getClotSize()+"' ");
			}
		}
		
		Query query = this.getCurrentSession().createQuery(sb.toString());
		return query.list();
	}

	public List<Clothing> findColorList() throws Exception {
		//String sql = "select * from tb_clothing group by clot_color";
		
		StringBuffer sb = new StringBuffer();
		sb.append("from Clothing c ");
		sb.append(" group by c.clotColor ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		return query.list();
	}
	
	public List<Clothing> findSizeList() throws Exception {
		//String sql = "select * from tb_clothing group by clot_color";
		
		StringBuffer sb = new StringBuffer();
		sb.append("from Clothing c ");
		sb.append(" group by c.clotSize ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		return query.list();
	}

	public Clothing getClothingByclotNum(String num) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("from Clothing c ");
		sb.append(" where c.clotNum=? ");
		Query query = this.getCurrentSession().createQuery(sb.toString());
		query.setParameter(0, num);
		return (Clothing) query.uniqueResult();
	}


}
