<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>物资采购与产品整合管理系统</title>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script>
	$(function(){
		$("#findBtn").click(function(){
			queryForm.action="${pageContext.request.contextPath}/controller/partsrepertory?flag=query";
			queryForm.submit();
		});
		var count = ${pageInfo.pages};
		$("#down").click(function(){			
			if($("#pageNo").val()>=count){
				alert("已到达末页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val())+1);
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepertory?flag=query";
			pageForm.submit();
		});
		$("#up").click(function(){			
			if($("#pageNo").val()<=1){
				alert("已到达首页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val()-1));
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepertory?flag=query";
			pageForm.submit();
		});
		$("#first").click(function(){			
			$("#pageNo").val(1);
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepertory?flag=query";
			pageForm.submit();
		});
		$("#last").click(function(){			
			$("#pageNo").val(count);
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepertory?flag=query";
			pageForm.submit();
		});
		$("#go").click(function(){			
			if($("#pageNo").val()>=count+1 || $("#pageNo").val()<=0){
				alert("输入的页数不正确");
				return;
			}
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepertory?flag=query";
			pageForm.submit();
		});
	})
</script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 配件管理</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="queryForm" name="queryForm" action="" method="post">
        <tr>
            <th align="right">配件编码：</th>
            <td><input name="partsId" type="text" class="inputTextNormal" id="textfield2" /></td>
             <th align="right">配件名称：</th>
            <td><input name="partsName" type="text" class="inputTextNormal" id="textfield2" /></td>
            <th align="right">
				<input type="button" class="btnShort" value="检索"  id="findBtn"/>
			</th>
        </tr>
       	</form>
    </table>


    <!--//commonTableSearch-->
    
	<input type="button" class="btnNormal" value="配件出入库" onclick="location.href='${pageContext.request.contextPath }/controller/partsrepertory?flag=query3'"/>	

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>配件编码</th>
            <th>配件名称</th>
            <th>库存数量</th>
        </tr>
        <c:forEach items="${pageInfo.list }" var="partsRepertory" varStatus="count">
        <tr>
            <td align="center">${count.count+(pageInfo.pageNum-1)*5 }</td>
            <td align="center">${partsRepertory.partsId.partsId }</td>
            <td align="center">${partsRepertory.partsId.partsName }</td>
			<td align="center">${partsRepertory.partsRepCount }</td>
        </tr>
        </c:forEach>
        
        
  </table>
    <!--//commonTable-->
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