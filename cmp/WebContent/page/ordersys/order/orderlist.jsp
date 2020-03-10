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
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js" type="text/javascript"></script>
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
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=query";
			pageForm.submit();
		});
		$("#up").click(function(){			
			if($("#pageNo").val()<=1){
				alert("已到达首页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val()-1));
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=query";
			pageForm.submit();
		});
		$("#first").click(function(){			
			$("#pageNo").val(1);
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=query";
			pageForm.submit();
		});
		$("#last").click(function(){			
			$("#pageNo").val(count);
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=query";
			pageForm.submit();
		});
		$("#go").click(function(){			
			if($("#pageNo").val()>=count+1 || $("#pageNo").val()<=0){
				alert("输入的页数不正确");
				return;
			}
			pageForm.action="${pageContext.request.contextPath}/controller/order?flag=query";
			pageForm.submit();
		});
	})
</script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 订单管理</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="queryForm" name="queryForm" action="" method="post">
        <tr>
            <th align="right">订单编码：</th>
            <td><input name="orderCode" type="text" class="inputTextNormal" id="textfield1" /></td>
            <th align="right">订单保存时间：</th>
            <td><input name="orderDate" type="text" class="inputTextNormal" id="textfield2" /></td>
            <td align="right">订单状态：</td>
            <td>
            	<select id="orderstatus" name="orderFlag">
						<option value="" selected>请选择</option>
						<option value="0">已通过</option>
						<option value="1">不通过</option>
						<option value="2">新订单</option>
						<option value="3">待审核</option>
				</select>
			</td>

            <th align="right">
				<input type="button" class="btnShort" value="检索" id="findBtn"/>
			</th>
        </tr>
        <tr>

          </tr>
       	</form>
    </table>


    <!--//commonTableSearch-->
    
	<input type="button" class="btnNormal" value="创建订单" onclick="location.href='${pageContext.request.contextPath }/page/ordersys/order/orderadd.jsp'"/>	

	<br>

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>订单编码</th>
            <th>订单保存时间</th>
            <th>订单状态</th>
            <th class="editColDefault">操作</th>
        </tr>
        	<c:forEach items="${pageInfo.list }" var="order" varStatus="count">
        <tr>
            <td align="center">${count.count+(pageInfo.pageNum-1)*5 }</td>
            <td align="center">${order.orderCode }</td>
            <td align="center"><f:formatDate value="${order.orderDate }" pattern="yyyy-MM-dd"/> </td>
            <c:choose>	
				<c:when test="${order.orderFlag=='0' }">
					<td align="center"><font color="RED">已通过</font></td>
					<td align="center">
            			<a href="system-order-view.html" class="btnIconView" title="查看详情"></a>
            		</td>
				</c:when>		
				<c:when test="${order.orderFlag=='1' }">
					<td align="center"><font color="BLUE">不通过</font></td>
					<td align="center">
            			<a href="system-order-view.html" class="btnIconView" title="查看详情"></a>
            		</td>
				</c:when>		
				<c:when test="${order.orderFlag=='2' }">
					<td align="center"><font color="GREEN">新订单</font></td>
					 <td align="center">
            			<a href="system-order-view.html" class="btnIconView" title="查看详情"></a>
                		<a href="#" class="btnIconDel" title="删除"></a>
            		</td>
				</c:when>		
				<c:when test="${order.orderFlag=='3' }">
					<td align="center"><font color="YeLLOW">待审核</font></td>
					 <td align="center">
            			<a href="system-order-view.html" class="btnIconView" title="查看详情"></a>
            			<a href="system-order-create-edit.html" class="btnIconEdit" title="更新"></a>
               		    <a href="#" class="btnIconDel" title="删除"></a>
           			 </td>
				</c:when>		
			</c:choose>
			
        </tr>
            </c:forEach>
       
  </table>
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
