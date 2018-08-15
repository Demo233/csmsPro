<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  	<title>日志查询</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/cjpm.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/page.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/cjcalendar.js"></script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cachecontextPa-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 </head>
 <%--  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script> --%>
<script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">
<!--
function goto1(strURL)
{
	document.forms[0].action=strURL;
	document.forms[0].submit();
}
function del(clotId)
{
	if(confirm("您确定删除该条记录？")){
		//alert(clotId);
		/* idFrmMain.action = "${pageContext.request.contextPath}/clothing/clothing_delete.action?clotId=" + clotId;
		idFrmMain.method = "GET";
		idFrmMain.submit(); */
		window.location.href="${pageContext.request.contextPath}/clothing/clothing_delete.action?clotId=" + clotId ;
	}
}

function doAdd(){
/* 	document.forms[0].action="${pageContext.request.contextPath}/system/f_clothingadd.action";
 */	document.forms[0].action="${pageContext.request.contextPath}/clothing/clothing_clothingAddBut.action";
	document.forms[0].submit();
}

function find(){
	//alert("find");
	//document.forms[0].action = "${pageContext.request.contextPath }/clothing/clothing_findClothing.action";
	document.forms[0].submit();
	/* $.ajax({
	   type: "POST",
	   url: "${pageContext.request.contextPath }/clothing/clothing_findClothing.action",
	   success: function(msg){
	     alert( "Data Saved: " + msg );
	   }
	}); */
}

function update(strURL)
{
	document.forms[0].action=strURL;
	document.forms[0].submit();
}

-->
</SCRIPT>


  
<BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0101" METHOD="POST"  ACTION="${pageContext.request.contextPath }/clothing/clothing_clothingList.action" ONSUBMIT="return false" >

<table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
	<tr>
		<td class="headerbar61">货号查询</td>
	    <td class="headerbar63" width="50%" colspan="1">
	    <p align="right"><input type=button value="查询" onClick="javascript:find();"></p>
	    </td>
    </tr>
	
</table>

<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
<tr>
	<td></td>
</tr>
</table>

<table border=0 cellspacing=1 cellpadding=2 width="100%" bgcolor="gray">
<tr>

    <td class="textbar81" width="15%">货号</td>
		<td class="textbar01" width="35%">
			<select name="clothing.clotNum" cssStyle="width:210px">
				<option value="" >请选择</option>
				<s:iterator value="hHLists" var="hh">
					<option ${clothing.clotNum==hh.clotNum?'selected="selected"':'' } value="${hh.clotNum  }">${hh.clotNum }</option>
				</s:iterator>
			</select>		
	<td class="textbar81" width="15%">品名</td>
		<td class="textbar01" width="35%">		
		<s:textfield name="clothing.clotBrand" cssStyle="width:210px"/>	
		</td>    
</tr>   
   <tr> 
            <td width="15%" class="textbar81">色号</td> 
            <td class="textbar01" width="35%"> 
            <s:select name="clothing.clotColor" cssStyle="210px" list="#{'':'请选择','大红色':'大红色','浅红色':'浅红色','紫红色':'紫红色','纯白色':'纯白色','米白色':'米白色','深蓝色':'深蓝色','淡蓝色':'淡蓝色','黑色':'黑色','棕色':'棕色' }"/>
            <td width="15%" class="textbar81">尺码</td> 
            <td class="textbar01" width="35%"> 
           	 <s:select name="clothing.clotSize" cssStyle="210px" list="#{'0':'请选择','150':'150','155':'155','160':'160','165':'165','170':'170','175':'175','180':'180','185':'185','190':'190','195':'195' }"></s:select>
            </td>            
          </tr>  
</table>

<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
<tr>
	<td></td>
</tr>
</table>

<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
	<tr>
  	<td class="headerbar61" width="50%" colspan="1">货号明细</td>
    <td class="headerbar63" width="50%" colspan="1"><p align="right">
    	<input type="submit" value="新增" onClick="JavaScript:doAdd();"></p></td>
  </tr>
</table>
  <table border=0 cellspacing=0 cellpadding=2 width="100%" height="5"> 
    <tr> 
      <td></td> 
    </tr> 
  </table> 
<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="0"  bgcolor="gray">
	<tr>
  	<td  width="100%" colspan="1">
  		<table  border="0" cellspacing="1" cellpadding="2" width="100%">
				<tr>
					<td  width="5%" class="headerbar82">序号</td>
					<td  width="10%" class="headerbar82">货号</td>
					<td  width="10%" class="headerbar82">色号</td>
					<td  width="10%" class="headerbar82">尺码</td>
					<td  width="15%" class="headerbar82">品名</td>
                    <td  width="10%" class="headerbar82">出厂价</td>
					<td  width="10%" class="headerbar82">零售价</td>
					<td   class="headerbar82">操作</td>
				</tr>

				<s:iterator value="lists" var="clothing">
					<tr>
						<td class="gridbar01" align="center">
							<s:property value="clotId"/>
						</td>
						<td  class="gridbar01" align="center" width="20%"  > <a href="${pageContext.request.contextPath }/clothing/clothing_updateBut.action?clotId=${clotId}" >
							<s:property value="clotNum"/>
						</a></td>
						<td  class="gridbar01" align="center">
							<s:property value="clotColor"/> 
						</td>
						<td  class="gridbar01" align="center"> 
								<s:property value="clotSize"/>
						</td>
						<td  class="gridbar01" align="center"> 
								<s:property value="clotBrand"/>
						</td>
	                    <td   class="gridbar01" align="center"> 
	                    		<s:property value="clotPrimPrice"/>
	                    </td>
						<td   class="gridbar01" align="center"> 
								<s:property value="clotSellPrice"/>
						</td>
						<td  class="gridbar01" align="center">
							<img src="${pageContext.request.contextPath }/image/del.gif" align="bottom" border="0" alt="删除" onClick="javascript:del('${clotId}')"  style="cursor:pointer"/></td>
					</tr>
				</s:iterator>
		</table>
				<s:actionerror theme="simple"/>
		
	  </td>
	</tr>
</table>

<table width="100%" border="0" cellpadding="1" cellspacing="2" >
        	<tr>
          	<td colspan="2" align="right" height="20"  nowrap class="textbar3" >
							&nbsp; 共4条 &nbsp; 第1/1页 &nbsp;      				<a  href="#" style="cursor:hand">首页</a>&nbsp; 
      				<a   style="cursor:hand" href="#">上一页</a>&nbsp;
      				<a  style="cursor:hand" href="#">下一页</a>&nbsp; 
      				<a   style="cursor:hand" href="#">尾页</a>&nbsp; 
							&nbsp;
						</td>
          </tr>
        </table>

			</td>
		</tr>
</table>
</FORM>
</BODY>
</html>
