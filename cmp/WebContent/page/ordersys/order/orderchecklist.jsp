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
			queryForm.action="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
			queryForm.submit();
		});
		var count = ${pageInfo.pages };
		$("#down").click(function(){			
			if($("#pageNo").val()>=count){
				alert("已到达末页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val())+1);
			pageForm.action="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
			pageForm.submit();
		});
		$("#up").click(function(){			
			if($("#pageNo").val()<=1){
				alert("已到达首页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val()-1));
			pageForm.action="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
			pageForm.submit();
		});
		$("#first").click(function(){			
			$("#pageNo").val(1);
			pageForm.action="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
			pageForm.submit();
		});
		$("#last").click(function(){			
			$("#pageNo").val(count);
			pageForm.action="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
			pageForm.submit();
		});
		$("#go").click(function(){			
			if($("#pageNo").val()>=count+1 || $("#pageNo").val()<=0){
				alert("输入的页数不正确");
				return;
			}
			pageForm.action="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
			pageForm.submit();
		});
	})
</script>
<!-- <script type="text/javascript">
$(function(){
		$("#pass").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/controller/orderdetail?flag=pass",
				type:"post",
				data:{orderCode:$("#orderCode").val()},
				success:function(data){
					 if(data=="1"){
						location.href="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
					}
				},
				dataType:"text"
				});
			});
        	});
</script>
<script type="text/javascript">
$(function(){
		$("#nopass").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/controller/orderdetail?flag=nopass",
				type:"post",
				data:{orderCode:$("#orderCode").val()},
				success:function(data){
					 if(data=="1"){
						location.href="${pageContext.request.contextPath}/controller/orderdetail?flag=query";
					}
				},
				dataType:"text"
				});
			});
        	});
</script> -->
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
					</select></td>

            <th align="right">
				<input type="button" class="btnShort" value="检索" id="findBtn"/>
			</th>
        </tr>
        <tr>

          </tr>
       	</form>
    </table>


 
	<br>
	<form action="" id="orderForm" name="orderName" method="post">
    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>订单编码</th>
            <th>订单保存时间</th>
            <th>订单状态</th>
            <th class="editColDefault">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list }" var="orderDetail" varStatus="count">
        <tr>
            <td align="center">${count.count+(pageInfo.pageNum-1)*5 }</td>
            <td align="center" name="orderCode" id="orderCode">${orderDetail.order.orderCode }</td>
            <td align="center" name="orderDate" id="orderDate"><f:formatDate value="${orderDetail.order.orderDate }" pattern="yyyy-MM-dd"/></td>
			<c:choose>	
				<c:when test="${orderDetail.order.orderFlag=='0' }">
					<td align="center"><font color="RED">已通过</font></td>
				</c:when>		
				<c:when test="${orderDetail.order.orderFlag=='1' }">
					<td align="center"><font color="BLUE">不通过</font></td>
				</c:when>		
				<c:when test="${orderDetail.order.orderFlag=='2' }">
					<td align="center"><font color="GREEN">新订单</font></td>
				</c:when>		
				<c:when test="${orderDetail.order.orderFlag=='3' }">
					<td aign="center"><font color="YELLOW">待审核</font></td>
					<td align="center">
            			<a href="${pageContext.request.contextPath}/controller/orderdetail?flag=pass&orderId=${orderDetail.order.orderId }" name="pass" id="pass${count.count+(pageInfo.pageNum-1)*5 }"><font color="BLUE" >通过</font></a>
            			<a href="${pageContext.request.contextPath}/controller/orderdetail?flag=nopass&orderId=${orderDetail.order.orderId }" name="nopass" id="nopass${count.count+(pageInfo.pageNum-1)*5 }"><font color="BLUE">不通过</font></a>
           			 </td>
				</c:when>		
			</c:choose>
            <td align="center">
            	
            </td>
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
