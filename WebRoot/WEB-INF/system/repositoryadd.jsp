<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
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
function delCom(id){
	if(id == '1'){
		document.idFrmMain.gys.value = "";		
	}else{
		document.idFrmMain.sccj.value = "";
	}
}

function save()
{
	document.forms[0].submit();
}

function back()
{
	history.back();
}

</SCRIPT>
<BODY BACKGROUND="${pageContext.request.contextPath }/image/bg.gif">
<s:form name="idFormMain" id="idFormMain" method="post" action="ck_save" namespace="/ck" onsubmit="return false">
<table border="0" width="100%">
    <tr>
    	<td width="100%" colspan="0" rowspan="0" align="center" >
      	<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
        	<tr>
          	<td class="headerbar61" width="50%" colspan="1">仓库详细</td>
            <td class="headerbar63" width="50%" colspan="1">
            	<input type="button" name="save70302002" onClick="javascript:save();" value="保存"> 
              <input type="button" name="save70302002" onclick="javascript:back()" value="返回">&nbsp;  
            </td>
          </tr>
        </table>
      </td>
    </tr>

    <tr>
    	<td width="100%" colspan="0" rowspan="0" align="center" >
      	<table border="0" width="100%" id="table1" cellspacing="1"  cellpadding="2"  bgcolor="gray">
        	<tr>
          	<td class="textbar81" width="15%" colspan="1">仓库编号</td>
            <td class="textbar01" width="85%" colspan="1">
            	<s:textfield size="18" name="ck.num" value="%{#num}" readonly="true"/>
            </td>
          </tr>

         <tr>        	          
		<td class="textbar81" width="15%">仓库名称</td>
		<td class="textbar01" width="85%">
			<s:textfield name="ck.name" size="18"/>					
		</td>         		
         </tr>   


         <tr>        	          
		<td class="textbar81" width="15%">联系人</td>
		<td class="textbar01" width="85%">
			<s:textfield name="ck.lxr" size="18"/>					
		</td>         		
         </tr>  

	            <tr>        	          
		<td class="textbar81" width="15%">联系电话</td>
		<td class="textbar01" width="85%">
			<s:textfield name="ck.dh" size="18"/>					
		</td>         		
         </tr>  
         
             <tr>        	          
		<td class="textbar81" width="15%">仓储量</td>
		<td class="textbar01" width="85%">
			<s:textfield name="ck.kcl" size="18"/>					
		</td>         		
         </tr>       	   	
        </table>
				<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
					<tr>
						<td></td>
					</tr>
				</table>
      </td>
    </tr>
</table>
</s:form>
</BODY>
</html>



