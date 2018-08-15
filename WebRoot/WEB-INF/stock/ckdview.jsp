<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>出库单展示页面</title>
    
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/page.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/datepicker/WdatePicker.js"></script>
  </head>
  <script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">
<!--
function goto1(url){
	document.forms[0].action= url ;
	document.forms[0].submit();
}

function goSearch()
{
	document.forms[0].action="order3001.htm";
	document.forms[0].submit();
}

function delCom(id){
	if(id == '1'){
		document.idFrmMain.gys.value = "";		
	}else{
		document.idFrmMain.sccj.value = "";
	}
}

function changesize(id){
	document.forms[0].action="order3001.htm";
	document.forms[0].submit();
}

function jump(id){
	document.forms[0].action="order3001.htm";
	document.forms[0].submit();	
}

function locatePage(id){
	document.forms[0].action="order3001.htm";
	document.forms[0].submit();		
}

function setValue()
{
	document.all.sccj.value="青岛雪中飞贸易有限公司";
}
-->
</SCRIPT>
  
 <BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0101" METHOD="POST"  ACTION="" ONSUBMIT="return false" >
<input type="hidden" id="slide_img">
<table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
<tr>
	<td class="headerbar61">出库单查询</td>
	<td class="headerbar61"><p align="right">		
		<input type=submit value=" 查 询 " onClick="JavaScript:goSearch();"></p></td>
</tr>
</table>


<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
<tr>
	<td></td>
</tr>
</table>

<table border=0 cellspacing=1 cellpadding=2 width="100%" bgcolor="gray">	
	<tr>
		<td class= "textbar81" width="15%">所出仓库</td>
		<td class="textbar01" width="35%">
			<select name="ckName" style="width:152px">
				<option value="">请选择</option>
				<s:iterator value="ckLists" var="ck">
					<option  value="${name }">${name }</option>
				</s:iterator>
			</select>
		</td>
	  <td class="textbar81" width="15%">单据编号</td>
		<td class="textbar01" width="35%">
			<s:textfield name="rkdNum" cssStyle="width:152px"/>
		</td>
	</tr>
	
	<tr>			  
		<td class="textbar81" width="15%">出库日期</td>
		<td class="textbar01" width="35%" colspan="3">
			<s:textfield onclick="WdatePicker()" name="date1" readonly="true" size="12"/>
			--
			<s:textfield onclick="WdatePicker()" name="date2" readonly="true" size="12"/>
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
  	<td class="headerbar61" width="100%" colspan="1">出库单明细</td>
		<td class="headerbar61"><p align="right">		
			<input type=submit value=" 新 增 " onClick="JavaScript:goto1('${pageContext.request.contextPath }/ckd/ckd_saveCkdBut.action');">  	
		</td>
</table>
<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="0"  bgcolor="gray">
	<tr>
  	<td  width="100%" colspan="1">
    	<table  border="0" cellspacing="1" cellpadding="2" width="100%">
				<tr>
					<td  width="5%"  class="headerbar82">序号</td>
					<td   width="15%"  class="headerbar82">单据编号</td>
					<td   width="20%" class="headerbar82">接收人</td>
					<td    width="15%" class="headerbar82">电话</td>					
					<td    width="25%" class="headerbar82">发往地址</td>
					<td  class="headerbar82">操作</td>			
				</tr>
				<s:iterator value="ckdLists" var="ckd">
				<tr>
					<td  class="gridbar11" align="center">${ckdId }</td>
					<td  class="gridbar11" align="center"><a href="order2002.htm">${ckdNum }</a></td>
					<td  class="gridbar11" align="center">${jsr } </td>
					<td  class="gridbar11" align="left">${dh }</td>
					<td  class="gridbar11" align="left">${dz }</td>
					<td  class="gridbar11" align="center">
						<a href = "#"><img src="${pageContext.request.contextPath }/image/del.gif" align="bottom" border="0" alt="作废" onClick="javascript:del('673467')" /></a>					</td>
				</tr>
				</s:iterator>
			</table>
	  </td>
	</tr>
</table>
 

<table width="100%" border="0" cellpadding="0" cellspacing="2">
	<tr>
  	<td colspan="2" align="right" height="20"  nowrap class="textbar3" > 
	&nbsp;&nbsp; 共4条 &nbsp;&nbsp; 第1/1页 &nbsp;&nbsp;
 		<a  href="#" style="cursor:hand">首页</a>&nbsp;&nbsp; 
 		<a  style="cursor:hand" href="#">上一页</a>&nbsp;&nbsp; 
 		<a  style="cursor:hand" href="#">下一页</a>&nbsp;&nbsp; 
 		<a  style="cursor:hand" href="#">尾页</a>&nbsp;&nbsp; 
 		&nbsp;&nbsp;
	  </td>
  </tr>
</table>
</FORM>
</BODY>
</html>

