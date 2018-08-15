<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改入库单界面</title>
    
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

  </head>
  
  <script language="javascript">
	var CalendarWebControl = new atCalendarControl();
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
function goto1(strURL)
{
	document.forms[0].action=strURL;
	document.forms[0].submit();
}

function del(id)
{
	if(confirm("您确定删除该条明细？")){
		alert("删除成功！");
	}
}
 
function save(){
	alert('保存成功');
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
	<td class="headerbar61">入库单修改</td>
	<td class="headerbar61"><p align="right">
		<input type=button value=" 查看明细" onClick="goto1('${pageContext.request.contextPath}/rkmx/rkmx_rkmxLists.action?rkdId=${param.rkdId }');">
		<input type="button" value="确认">
		<input type=button value=" 保 存 " onClick="JavaScript:history.save();">
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
      <input name="rkd.rkdNum" type="text" value="${rkdNum }" readonly size="20">
    </td>
    <td class="textbar81" width="15%">联系人</td>
		<td class="textbar01" width="35%">
		<input type="text" name="rkd.rkdBly"  value="${rkdBly }"/>
    </td>
</tr>
<tr>
    <td class="textbar81" width="15%">所入仓库</td>
		<td class="textbar01"  width="35%">
     		<select id="select_1" name="rkd.ckName" style="width:152px">
				<option value="">请选择</option>
					<s:iterator value="ckLists" var="ck">
						<option ${ck.name==ckName?'selected="selected"':'' } value="${ck.name }">${ck.name }</option>
					</s:iterator>
			</select>
    </td>    
    <td class="textbar81" width="15%">来源</td>
		<td class="textbar01"  width="35%">
     <input type="text" name="rkd.rkdLy" value="${rkdLy}" size="20">
    </td>      
</tr>
<tr>
    <td class="textbar81" width="15%">备注</td>
		<td class="textbar01"  width="85%" colspan="3">
       <textarea id="tare1" name="rkd.rkdNote" cols="80" rows="4" >${rkdNote }</textarea>
    </td>        
</tr>


</table>

<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
<tr>
	<td></td>
</tr>
</table>



	 
</FORM>
</BODY>
</html>

