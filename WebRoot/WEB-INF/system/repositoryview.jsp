<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>日志查询</title>
    
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

  </head>
  
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
function del(id)
{
	if(confirm("您确定删除该条记录？")){
		window.location.href = "${pageContext.request.contextPath}/ck/ck_delete.action?id=" + id;
	}
}
function doAdd(){
	document.forms[0].action="${pageContext.request.contextPath}/ck/ck_ckAddBut.action";
	document.forms[0].submit();
}
function find(){
	document.forms[0].action="${pageContext.request.contextPath}/ck/ck_ckList.action";
	document.forms[0].submit();
}
-->
</SCRIPT>
  
  <BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0101" METHOD="POST"  ACTION="" ONSUBMIT="return false" >


<table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
<tr>
	<td class="headerbar61">仓库查询</td>
    <td class="headerbar63" width="50%" colspan="1"><p align="right">
    	<p align="right"><input type=button value="查询" onClick="javascript:find();"></p>
  </tr>
</tr>
</table>

<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
<tr>
	<td></td>
</tr>
</table>

<table border=0 cellspacing=1 cellpadding=2 width="100%" bgcolor="gray">
<tr>

    <td class="textbar81" width="15%">仓库编号11</td>
		<td class="textbar01" width="35%">			
		<input type="text" name="ck.num" style="width:210px ">	  </td>    
	<td class="textbar81" width="15%">仓库名称</td>
		<td class="textbar01" width="35%">			
		<input type="text" name="ck.name" style="width:210px ">	  </td>    
</tr>   
   
</table>

<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
<tr>
	<td></td>
</tr>
</table>

<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
	<tr>
  	<td class="headerbar61" width="50%" colspan="1">仓库明细</td>
    <td class="headerbar63" width="50%" colspan="1"><p align="right">
    	<input type="button" value="新增" onClick="JavaScript:doAdd();"></p></td>
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
					<td  width="10%" class="headerbar82">仓库编号111</td>
					<td  width="20%" class="headerbar82">仓库名称</td>
					<td  width="10%" class="headerbar82">仓储量</td>
					<td  width="5%" class="headerbar82">操作</td>
				</tr>

				<s:iterator value="cks" var="ck">
				<tr>
					<td  width="5%" class="gridbar11">${id }</td>
					<td  width="10%" class="gridbar11"> <a href="${pageContext.request.contextPath }/ck/ck_updateBut.action?id=${id}"  >${num }</a></td>
					<td  width="20%" class="gridbar11"> ${name }</td>
					<td  width="10%" class="gridbar11"> ${kcl }</td>
					<td  width="5%" class="gridbar11">
						 <img src="${pageContext.request.contextPath }/image/del.gif" align="bottom" border="0" alt="删除" onclick="javascript:del('${id}')"  style="cursor:hand"/></td>

					</td>
				</tr>
				</s:iterator>
			</table>
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
