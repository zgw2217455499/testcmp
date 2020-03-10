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
			queryForm.action="${pageContext.request.contextPath}/controller/partsrepbill?flag=query";
			queryForm.submit();
		});
		var count = ${pageInfo.pages};
		$("#down").click(function(){			
			if($("#pageNo").val()>=count){
				alert("已到达末页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val())+1);
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepbill?flag=query";
			pageForm.submit();
		});
		$("#up").click(function(){			
			if($("#pageNo").val()<=1){
				alert("已到达首页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val()-1));
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepbill?flag=query";
			pageForm.submit();
		});
		$("#first").click(function(){			
			$("#pageNo").val(1);
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepbill?flag=query";
			pageForm.submit();
		});
		$("#last").click(function(){			
			$("#pageNo").val(count);
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepbill?flag=query";
			pageForm.submit();
		});
		$("#go").click(function(){			
			if($("#pageNo").val()>=count+1 || $("#pageNo").val()<=0){
				alert("输入的页数不正确");
				return;
			}
			pageForm.action="${pageContext.request.contextPath}/controller/partsrepbill?flag=query";
			pageForm.submit();
		});
	})
</script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 配件库存流水账查询</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
     <form id="queryForm" name="queryForm" action="" method="post">
        <tr>
            <th align="right">配件名称：</th>
            <td><input type="text" class="inputTextNormal" id="textfield2" name="partsName" /></td>
            <th align="right" >出/入库：</th>
            <td>
            	<select style="width:150px;" name="billFlag">
						<option value="">请选择</option>
						<option value="I">入库</option>
						<option value="O">出库</option>			
				</select>
			</td>
            <th align="right">出入库类型：</th>
            <td>
            	<select style="width:150px;" name="billType">
						<option value="">请选择</option>
					<c:forEach items="${codeList }" var="code">
						<option value="${code.code }">${code.name }</option>
					</c:forEach>	
				</select>
            </td>
            <th align="right">出入库日期：</th>
            <td>
            	<input  type="text" class="inputTextNormal" id="textfield2" name="billTime"/>
            </td>
            <th align="right">
				<input type="button" class="btnShort" value="检索"  id="findBtn"/>
			</th>
        </tr>
  	</form>
    </table>
	<br>

    <!--//commonTableSearch-->

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>出/入库</th>
            <th>出入库类别</th>
            <th>配件名称</th>
            <th>数量</th>
            <th>时间</th>
            <th>操作人</th>
        </tr>
        <c:forEach items="${pageInfo.list }" var="partsRepBill" varStatus="count">
        <tr>
            <td align="center">${count.count+(pageInfo.pageNum-1)*5 }</td>
            <td align="center">${partsRepBill.billFlag.name }</td>
            <td align="center">${partsRepBill.billType.name }</td>
			<td align="center">${partsRepBill.partsId.partsName }</td>
			<td align="center">${partsRepBill.billCount }</td>
			<td align="center"><f:formatDate value="${partsRepBill.billTime }" pattern="yyyy-MM-dd"/></td>
			<td align="center">${partsRepBill.billUser.name }</td>
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