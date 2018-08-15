<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>采购入库管理</title>
    
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
  
<SCRIPT LANGUAGE="javaScript">
<!--

function goSearch()
{
	document.forms[0].action="${pageContext.request.contextPath}/rkd/rkd_rkdLists.action";
	document.forms[0].submit();
}

function goto1(url)
{
	document.forms[0].action = url;
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
	document.forms[0].action="order2001.htm";
	document.forms[0].submit();
}

function jump(id){
	document.forms[0].action="order2001.htm";
	document.forms[0].submit();	
}

function locatePage(id){
	document.forms[0].action="order2001.htm";
	document.forms[0].submit();		
}

 
-->
</SCRIPT>
 <BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0101" METHOD="POST"  ACTION="" ONSUBMIT="return false" >
 
<table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
<tr>
	<td class="headerbar61">入库单查询</td>
	<td class="headerbar61"><p align="right">
		<input type=button value=" 查 询 " onClick="JavaScript:goSearch();">		
		</p>
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
		<td class= "textbar81" width="15%">所入仓库</td>
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
		<td class="textbar81" width="15%">入库日期</td>
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
  	<td class="headerbar61" width="100%" colspan="1">入库单</td>
  		<td class="headerbar61">
  		<p align="rigth">
  			<input type=submit value=" 新 增 " onClick="JavaScript:goto1('${pageContext.request.contextPath}/rkd/rkd_saveRkdBut.action');">
  		</p>
  	</td>
  	
  	
</table>

<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="0"  bgcolor="gray">
	<tr>
  	<td  width="100%" colspan="1">
    	<table  border="0" cellspacing="1" cellpadding="2" width="100%">
				<tr>
					<td  width="5%"  class="headerbar82">序号</td>
					<td   width="15%"  class="headerbar82">单据编号</td>
					<td   width="20%" class="headerbar82">所入仓库</td>
					<td    width="15%" class="headerbar82">入库日期</td>					
					<td    width="15%" class="headerbar82">经办人</td>
					<td    width="25%" class="headerbar82">来源</td>
					<td  class="headerbar82">操作</td>			
				</tr>
				<s:iterator value="rkdLists" var="rkd">
				<tr>
					<td  class="gridbar11" align="center">${rkdId }</td>
					<td  class="gridbar11" align="center"><a href="${pageContext.request.contextPath }/rkd/rkd_updateBut.action?rkdId=${rkdId }">${rkdNum }</a></td>
					<td  class="gridbar11" align="center">${ckName } </td>
					<td  class="gridbar11" align="left">${rkdDate }</td>
					<td  class="gridbar11" align="left">${rkdBly }</td>
					<td  class="gridbar11" align="center">${rkdLy }</td>
					<td  class="gridbar11" align="center">
						<a href = "${pageContext.request.contextPath }/rkd/rkd_delete.action?rkdId=${rkdId }"><img src="${pageContext.request.contextPath }/image/del.gif" align="bottom" border="0" alt="作废" /></a></td>
				</tr>
				</s:iterator>
			</table>
	  </td>
	</tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="2">
	<tr>
  	<td colspan="2" align="right" height="20"  nowrap class="textbar3" >
	&nbsp; 共4条 &nbsp;&nbsp; 第1/1页 &nbsp;&nbsp;
		<a  href="#" style="cursor:hand">首页</a>&nbsp;&nbsp; 
 		<a style="cursor:hand" href="#">上一页</a>&nbsp;&nbsp; 
 		<a style="cursor:hand" href="#">下一页</a>&nbsp;&nbsp; 
 		<a style="cursor:hand" href="#">尾页</a>&nbsp;&nbsp;  
		</td>
  </tr>
</table>
</FORM>
</BODY>
</html>

