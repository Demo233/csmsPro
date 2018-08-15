<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加入库单</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/cjpm.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/page.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
  </head>
  
  <SCRIPT LANGUAGE="javaScript">
	<!--
	
	function save()
	{
		document.forms[0].submit();
	}
	
	function back()
	{
		history.back();
	}
	 
	 
	-->
	</SCRIPT>
	
	<script type="text/javascript">
		function test(){
			var $value = $("#clothingNum option:selected").text();
			if("请选择" != $value){
				$.ajax({
				  type: "POST",
				  url: "${pageContext.request.contextPath}/rkmx/rkmx_getClothingByAjax.action?time=" + new Date().toLocaleString(),
				  data: {
				  	"num" : $value
				  },
				  success: function(backDate,textStatus,ajax){
				  	var array = backDate.clotSet;
				  	for(var i=0;i<array.length;i++){
				  		var color = array[0];
				  		var size = array[1];
				  		var brand = array[2];
				  	}
				  	$("#clo_1").val(color);
				  	$("#size_1").val(size);
				  	$("#brand_1").val(brand);
				  }
				});
			}else{
				$("#clo_1").val("");
				$("#size_1").val("");
				$("#brand_1").val("");
			}
		}
	</script>
  
  <BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0102" METHOD="POST"  ACTION="${pageContext.request.contextPath}/rkmx/rkmx_save.action?rkdId=${param.rkdId}" ONSUBMIT="return false"> 
<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
	<tr>
  	<td class="headerbar61" width="15%" colspan="1">入库单详细</td>
    <td class="headerbar63" width="85%" colspan="1">
      <input type="button" name="save70302002" onClick="javascript:save()" value=" 保 存 ">&nbsp;
      <input type="button" name="back70302003" onClick="javascript:back()" value=" 返 回">
    </td>
  </tr>
</table>

<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
	<tr>
		<td></td>
	</tr>
</table>

<table border="0" width="100%" id="table1" cellspacing="1"  cellpadding="2"  bgcolor="gray">
	<tr>
  	<td class="textbar81" width="15%" colspan="1">货号</td>
   <td class="textbar01" width="85%" colspan="1">
    	<select id="clothingNum" name="clotNum" style="width:210px " onChange="test();"> 
          <option value="" selected="selected">请选择</option> 
	           <s:iterator value="clotLists" var="clot">
	           	  <option value="${clot.clotNum }">${clot.clotNum }</option> 
	           </s:iterator>
         </select>
         </td>
  </tr>
  <tr>
  	<td class="textbar81" width="15%" colspan="1">品牌</td>
    <td class="textbar01" width="85%" colspan="1">
    	<input id="brand_1" name="clothing.clotBrand" style="width:210px" readonly="readonly">
    </td>
  </tr>  
	<tr>
  	<td class="textbar81" width="15%" colspan="1">色号</td>
    <td class="textbar01" width="85%" colspan="1">
    	<input id="clo_1" name="clothing.clotColor" style="width:210px" readonly="readonly">
    </td>
  </tr>          
  <tr>
  	<td class="textbar81" width="15%" colspan="1">尺码</td>
    <td class="textbar01" width="85%" colspan="1">
    	<input id="size_1" name="clothing.clotSize" style="width:210px " readonly="readonly">
    </td>
  </tr>          
	<tr>
  	<td class="textbar81" width="15%" colspan="1">数量${sessionScope.ckId }</td>
    <td class="textbar01" width="85%" colspan="1"><input  name="count" style="width:210px;"></td>
  </tr>      
	
</table>
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
<s:iterator value="clotLists" var="clot">
<tr>
	<td   class="gridbar11" align="center">${clot.clotId }</td>
	<td   class="gridbar11" align="center">${clot.clotNum }</td>
	<td   class="gridbar11">${clot.clotBrand }</td>
	<td   class="gridbar11">${clot.clotColor }</td>
	<td  class="gridbar11">${clot.clotSize }</td>
	<td   class="gridbar11" align="center">
		<input size="25%"; type="text" />
	</td>
	<td  class="gridbar11" align="center">
		<input type="checkbox" onclick="test(this);"/>
	</td>	
</tr>
</s:iterator>
</table> --%>
</FORM>
</BODY>
</html>




