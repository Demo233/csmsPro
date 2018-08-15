
function pageClick(name){
	n = document.all("pageNo").value;
	if(name=="first"){
		document.all("pageNo").value = 1;
	}
	if(name=="upper"){
		document.all("pageNo").value = n - 1;
	}
	if(name=="next"){
		document.all("pageNo").value = n-0+1;
	}
	if(name=="last"){
		document.all("pageNo").value = document.all("pageCount").value;
	}
	
	if(document.all("action")!=null)
		document.all("action").value = "self";
	else
		document.all("method").value = "init";
	document.forms[0].submit();
}

function ppup(src,pageTitle,pageHeight,pageWidth){
			var pageTop = window.event.clientY+document.body.scrollTop + 240;
			var pageLeft = window.event.clientX+document.body.scrollLeft -300;

			var pageStye = "dialogHeight: "+ pageHeight + "px; "
							+"dialogWidth: "+ pageWidth + "px; "
							+"dialogTop: "+pageTop+"px; "
							+"dialog Left: "+pageLeft+"px; "
							+" center: no; help: no;status:no;title:no";

			y=window.showModalDialog(
			src,
			pageTitle,
			pageStye
			);
}

//�����Ի���
function openDialog(WINurl,WINwidth,WINheight,xyPosition){
	var center = xyPosition==0?'yes':'no';
	if(xyPosition==0){//��Ļ����   
		showx = (window.screen.availWidth  - WINwidth)/2;
		showy = (window.screen.availHeight - WINheight)/2;
  }else{//�¼�����
		showx = event.screenX - event.offsetX - 4 - WINwidth ; // + deltaX;
		showy = event.screenY - event.offsetY + 18; // + deltaY;
	}
	newWINwidth = WINwidth + 4 + 18;
	var features =
		'dialogWidth:'  + newWINwidth  + 'px;' +
		'dialogHeight:' + WINheight + 'px;' +
		'dialogLeft:'   + showx     + 'px;' +
		'dialogTop:'    + showy     + 'px;' +
		'help:off;resizable:yes;status:no;center:'+center+';';
	var vDialog = window.showModalDialog(WINurl, null, features);
	return vDialog;
}

function goto(sur)
{
	document.forms[0].action=sur;
	document.forms[0].submit();
}

function menuGoto(sur,targetName)
{
	document.forms[0].action=sur;
	document.forms[0].target = targetName;
	document.forms[0].submit();
}

function del(id)
{
	if(confirm("��ȷ��ɾ�������ݣ�")){
		alert("ɾ��ɹ���");
	}
}

function cancel(id)
{
	if(confirm("��ȷ�����ϸ�����ݣ�")){
		alert("���ϳɹ���");
	}
}
function save()
{
	alert("����ɹ���");
}
function back()
{
	history.back();
}

//����Ƿ���һ���Ϸ�������
function checknum(obj)
{
	if (isNaN(obj.value))
	{
		alert("���������֣�");
		obj.value="";
		obj.focus();
		return;
	}
}

//���
function checkPass(num)
{
	if(num==0)
	{
		if(confirm("��ȷ����ͨ���Ҫ���ƻ���")){
			alert("��ͨ���Ҫ���ƻ���");
		}
	}
	else if(num==1)
	{
		if(confirm("��ȷ��ͨ���Ҫ���ƻ���")){
			alert("ͨ���Ҫ���ƻ���");
		}
	}
}

function check(id)
{
	if(confirm("��ȷ���Ѿ��Ķ��˸�֪ͨ��")){
			alert("����Ϊ�Ѿ��Ķ�״̬��");
	}
}

