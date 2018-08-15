<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>品牌修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/cjpm.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/cjcalendar.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath }/js/page.js"></script>
	
  </head>
  <script language="javascript">
	var CalendarWebControl = new atCalendarControl();
	</script>
	<SCRIPT LANGUAGE="javaScript">
	<!--
	function delCom(id){
		if(id == '1'){
			document.idFrmMain.gys.value = "";		
		}else{
			document.idFrmMain.sccj.value = "";
		}
	}
	
	function save()
	{
		//window.location.href = "${pageContext.request.contextPath}";
		document.forms[0].submit();
	}
	
	function back()
	{
		history.back();
	}

	</SCRIPT>
 <BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif"> 
<s:form name="idFormMain" id="idFormMain" method="post" action="clothing_updateClothing?clotId=%{#clot.clotId}" namespace="/clothing" onsubmit="return false">
  <table border="0" width="100%"> 
    <tr> 
      <td width="100%" colspan="0" rowspan="0" align="center" valign="center"> <table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray"> 
          <tr> 
            <td class="headerbar61" width="50%">货号详细</td> 
            <td class="headerbar63" width="50%"> 
            	<input type="button" name="save70302002" onClick="javascript:save();" value="保存"> 
              <input type="button" name="save70302002" onClick="javascript:back()" value="返回 ">&nbsp; 
		 </td> 
          </tr> 
        </table>
       </td> 
    </tr> 
    <tr> 
      <td width="100%" colspan="0" rowspan="0" align="center" valign="center"> <table border="0" width="100%" id="table1" cellspacing="1"  cellpadding="2"  bgcolor="gray"> 
          <tr> 
           <td class="textbar81" width="15%">货号 </td> 
            <td class="textbar01" width="35%">
            	<input type="text"  name="clothing.clotNum" size="15" readonly="readonly" value="<s:property value='#clot.clotNum'/>" style="width:210px" >
            </td>  
			 <td class="textbar81" width="15%">品名 <span style="color:#708090;">*</span></td>
            <td class="textbar01" width="35%"> 
            	<input type="text"  name="clothing.clotBrand" size="15" value="<s:property value='#clot.clotBrand'/>" style="width:210px" >
          </tr>
          <tr>
            <td width="15%" class="textbar81">色号 <span style="color:#708090;">*</span></td>
            <td class="textbar01" width="35%">
           <select name="clothing.clotColor" style="width:210px">
				<option value="" >请选择</option>
				<s:iterator value="ysLists">
					<option ${clot.clotColor==clotColor?'selected="selected"':'' } value="${clotColor }">${clotColor }</option>
				</s:iterator>
			</select>
            <td width="15%" class="textbar81">尺码 <span style="color:#708090;">*</span></td> 
            <td class="textbar01" width="35%"> 
            <select name="clotSize" style="width:210px">
				<option value="" >请选择</option>
				<s:iterator value="sizeLists">
					<option ${clot.clotSize==clotSize?'selected="selected"':'' } value="${clotSize }">${clotSize }</option>
				</s:iterator>
			</select>	
          </tr> 
		   <tr> 
            <td width="15%" class="textbar81">面料</td> 
            <td class="textbar01" width="35%">
            <input type="text"  name="clothing.clotMl" size="15" value="<s:property value='#clot.clotMl'/>" style="width:210px" > 
            <td class="textbar81" width="15%">里料</td> 
            <td class="textbar01" width="35%"> 
            	<input type="text"  name="clothing.clotLl" size="15" value="<s:property value='#clot.clotLl'/>" style="width:210px" > 
            </td> 
          </tr> 
          <tr> 
            <td width="15%" class="textbar81">出厂价 <span style="color:#708090;">*</span></td> 
            <td class="textbar01" width="35%"> 
                <input type="text"  name="clothing.clotPrimPrice" size="15"  value="<s:property value='#clot.clotPrimPrice'/>" style="width:210px" > <span style="color:#DCDCDC;">00.00</span>
            </td> 
            <td class="textbar81" width="15%">零售 <span style="color:#708090;">*</span></td> 
            <td class="textbar01" width="35%">
            <input type="text"  name="clothing.clotSellPrice" size="15" value="<s:property value='#clot.clotSellPrice'/>" style="width:210px" > <span style="color:#DCDCDC;">00.00</span>
            </td> 
          </tr> 
        </table> 
        <table border=0 cellspacing=0 cellpadding=0 width="100%" height=5> 
          <tr> 
            <td></td> 
          </tr> 
        </table></td> 
    </tr> 
  </table> 
</s:form>
</BODY>
</html>