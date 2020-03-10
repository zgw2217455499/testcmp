<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>物资采购与产品整合管理系统</title>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script>
	$(function(){
		$("#findBtn").click(function(){
			queryForm.action="${pageContext.request.contextPath}/controller/order?flag=query";
			queryForm.submit();
		});
		var count = ${pageInfo.pages};
		$("#down").click(function(){			
			if($("#pageNo").val()>=count){
				alert("已到达末页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val())+1);
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=getmater";
			pageForm.submit();
		});
		$("#up").click(function(){			
			if($("#pageNo").val()<=1){
				alert("已到达首页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val()-1));
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=getmater";
			pageForm.submit();
		});
		$("#first").click(function(){			
			$("#pageNo").val(1);
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=getmater";
			pageForm.submit();
		});
		$("#last").click(function(){			
			$("#pageNo").val(count);
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=getmater";
			pageForm.submit();
		});
		$("#go").click(function(){			
			if($("#pageNo").val()>=count+1 || $("#pageNo").val()<=0){
				alert("输入的页数不正确");
				return;
			}
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=getmater";
			pageForm.submit();
		});
	})
</script>
</head>
<script type="text/javascript">

var obj = window.dialogArguments;

function loadForm()
{
	document.forms[1].CZType.value = obj[0];
}


function checkAll(){
	var form = document.forms[1];
	var checkObj = form.ids;
	var ids = form.id;
	for(var i=0;i<ids.length;i++){
		ids[i].checked = checkObj.checked;
	}
}

function catchValues(){
	var form = document.forms[1];
	var ids = form.id;
	var flag = false;
	var ary = [];
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			flag = true;
			ary.push(ids[i].value);
		}
	}

	if(!flag){
		alert("请选择原料！");
		return ;
	}
	window.returnValue = ary;
	window.close();
}

</script>
<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 订单管理&nbsp;&gt;&gt;&nbsp;配件选择列表</h2>
	</div>
	<form id="form-search" name="form-search" action="" method="post">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
	        <tr>
	            <th align="right">配件名称：</th>
	            <td ><input name="textfield" type="text" class="inputTextNormal" id="textfield" /></td>
				<td width="150" align="" >
					<button>检索</button>
				</td>
				<td></td>
	        </tr>
    	</table>
    </form>
    <!--//commonTableSearch-->
    <div class="btnBar">
    	<ul class="clearfix">
        	<li><a href="javascript:catchValues();" title="确定" class="btnLong">确定</a></li>
        	<li><a href="javascript:window.close();" title="关闭" class="btnLong">关闭</a></li>
        </ul>
    </div>
    <form action="" name="listForm" method="post">
	    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
	        <tr>
	            <th>
	            	<input type="checkbox" name="ids" onclick="checkAll();">
	            </th>
	            <th>配件名称</th>
	            <th>配件库存</th>
	        </tr>
				<c:forEach items="${pageInfo.list }" var="partsRepertory">
		        <tr>
		            <td align="center" style="width:5%">
		            	<input type="checkbox"  name="id" value="${partsRepertory.partsId.partsId },${partsRepertory.partsId.partsName },${partsRepertory.partsRepCount }">
		            </td>
		            <td align="center" >${partsRepertory.partsId.partsName }</td>
		            <td align="center">${partsRepertory.partsRepCount }</td>
		        </tr>
		        </c:forEach>
	  </table>
  </form>
    <form id="pageForm" name="pageForm" action="" method="post">
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	<li><a href="#" id="first">首页</a></li>
            <li ><a href="#" id="up">上页</a></li>
            <li><a href="#" id="down">下页</a></li>
            <li class="current"><input type="text" id="pageNo" name="pageNo" value="${pageInfo.pageNum }" style="text-align:right" size="1"></li>
            <li><a href="#" id="go">跳转</a></li>
            <li><a href="#" id="last">尾页</a></li>
            <li class="pageinfo">第${pageInfo.pageNum }页</li>
            <li class="pageinfo">共${pageInfo.pages }页</li>
        </ul>
    </div>
</form>
</div>
<!--//content pages wrap-->
</body>
</html>
