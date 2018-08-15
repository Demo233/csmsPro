<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>入库单添加页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/cjpm.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/page.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/cjcalendar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/addFunction.js"></script>

  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
  </head>
  <script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>

<script>
	/* alert(document.getElementById("tare1")); */
</script> 

<SCRIPT LANGUAGE="javaScript">
<!--

var trFlag = 0;
function tabMove0(objId, position){
  if (event.keyCode == 13) {
          document.getElementById(objId).childNodes[2].innerHTML='07长面包新款';
          document.getElementById(objId).childNodes[3].innerHTML='045';
          tabMove(objId, position);
  }	
}
function goto1(url)
{
	var $value = $("#select_1 option:selected").text();
	if("请选择" != $value){
		document.forms[0].action = url;
		document.forms[0].submit();
	}else{
		alert("请先保存入库单信息!!!");
	}
}

function del(id)
{
	if(confirm("您确定删除该条明细？")){
		alert("删除成功！");
	}
}
 
function save(){
	document.forms[0].action = "${pageContext.request.contextPath}/ckd/ckd_saveCkd.action";
	document.forms[0].submit();
}
function setValue(){
	document.forms[0].gys.value = "610";	
}
function delCom(id){
	if(id == "1"){
		document.forms[0].gys.value = "";	
	}else{
		document.forms[0].sccj.value = "";	
	}
}
function setValue1(){
	document.forms[0].sccj.value="";
}
-->
</SCRIPT>
  <BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<FORM NAME="mig0101" ID="idmig0101" METHOD="POST"  ACTION="" ONSUBMIT="return false" >

<table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
<tr>
	<td class="headerbar61">入库单详细</td>
	<td class="headerbar61"><p align="right">
		<input type="button" value="出 库" onClick="save();">
		<input type=button value=" 返 回 " onClick="JavaScript:history.back();">
    </p></td>
</tr>
</table>
<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
<tr>
	<td></td>
</tr>
</table>
<table border=0 cellspacing=1 cellpadding=2 width="100%" bgcolor="gray">
<tr>
    <td class="textbar81" width="15%">单据号</td>
		<td class="textbar01" width="35%">
      <input name="ckd.ckdNum" type="text" value="CK656296292" readonly size="20">
    </td>
    <td class="textbar81" width="15%">接收人</td>
		<td class="textbar01" width="35%">
			<input type="text" name="ckd.jsr"  value="张三"/>
			<!-- <input type="text" name="frmWRPT_OPT_DATE2_PJT70302" id="frmWRPT_OPT_DATE2_PJT70302" value="" size="12"> -->
			<%-- <img src="${pageContext.request.contextPath }/image/calendar.gif" width="18" height="17" onClick="CalendarWebControl.show(forms[0].frmWRPT_OPT_DATE2_PJT70302,'',forms[0].frmWRPT_OPT_DATE2_PJT70302);" title="显示日历" />		 --%>
    </td>
</tr>
<tr>
    <td class="textbar81" width="15%">电话</td>
		<td class="textbar01"  width="35%">
		
     <input type="text" name="ckd.dh"  value="1555555555555555"/>
    </td>
    <td class="textbar81" width="15%">地址</td>
		<td class="textbar01"  width="35%">
      <input type="text" name="ckd.dz" value="郑州" size="20">
    </td>      
</tr>
<tr>
    <td class="textbar81" width="15%">备注</td>
		<td class="textbar01"  width="85%" colspan="3">
      <textarea id="tare1" name="ckd.bz" cols="80" rows="4" >bz</textarea>
    </td>        
</tr>


</table>

<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
<tr>
	<td></td>
</tr>
</table>

<%-- <table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
                <tr>
                    <td class="headerbar61" colspan="1">入库单明细</td>
                    <td class="headerbar63" colspan="1">
                    	<p align="right">
						<input type=button value=" 新增明细 " onClick="goto1('${pageContext.request.contextPath}/rkd/rkd_clothingLists.action');"></p>
                    </td>
                </tr>
</table> --%>
<%-- 
<table id="tab0" border="0" cellspacing="1" cellpadding="2" width="100%" bgcolor="gray">

<tr>
	<td  width="5%" class="headerbar82">序号</td>
	<td  width="20%" class="headerbar82">货号</td>
	<td  width="20%" class="headerbar82">品名</td>
	<td  width="15%" class="headerbar82">色号</td>
	<td  width="15%" class="headerbar82">尺码</td>
	<td  width="15%" class="headerbar82">数量</td>		
	<td  class="headerbar82">操作</td>
</tr>

<tr>
	<td   class="gridbar11" align="center">${clothing.clotId }</td>
	<td   class="gridbar11" align="center">${clothing.clotNum }</td>
	<td   class="gridbar11">${clothing.clotBrand }</td>
	<td   class="gridbar11">${clothing.clotColor }</td>
	<td  class="gridbar11">${clothing.clotSize }</td>
	<td   class="gridbar11" align="center">${rkmx.count }</td>
	<td  class="gridbar11" align="center">
	<a href = "#"><img src="${pageContext.request.contextPath }/image/del.gif" align="bottom" border="0" alt="删除" onClick="javascript:del('673467')" /></a></td>	
</tr>

</table> --%>	 
</FORM>
</BODY>
</html>

