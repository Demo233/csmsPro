<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>入库明细视图</title>
    
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
  <script type="text/javascript">
  	function goto1(strURL)
	{
		document.forms[0].action=strURL;
		document.forms[0].submit();
	}
  </script>
  <body>
  <form action="" method="post">
    <table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
                <tr>
                    <td class="headerbar61" colspan="1">入库单明细</td>
                    <td class="headerbar63" colspan="1">
                    	<p align="right">
							<input type=button value=" 新增明细 " onClick="goto1('${pageContext.request.contextPath}/rkmx/rkmx_saveBut.action?rkdId=${param.rkdId }');"></p>
                    </td>
                </tr>
</table>

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

<s:iterator value="rkLists" var="rkmx">
	<tr>
		<td   class="gridbar11" align="center">${rkmxId }</td>
		<td   class="gridbar11" align="center">${rkmxNum }</td>
		<td   class="gridbar11">T恤衫</td>
		<td   class="gridbar11">大红色</td>
		<td  class="gridbar11">155</td>
		<td   class="gridbar11" align="center">${count }</td>
		<td  class="gridbar11" align="center">
							<a href = "#"><img src="${pageContext.request.contextPath }/image/del.gif" align="bottom" border="0" alt="删除"  /></a></td>	
	</tr>
</s:iterator>
</table>
</form>
  </body>
</html>
