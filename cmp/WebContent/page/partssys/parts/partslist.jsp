<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		$("#queryBtn").click(function(){
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
		});
		$("#findBtn").click(function(){
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
		});
		var count = ${pageInfo.pages};
		$("#down").click(function(){			
			if($("#pageNo").val()>=count){
				alert("已到达末页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val())+1);
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
		});
		$("#up").click(function(){			
			if($("#pageNo").val()<=1){
				alert("已到达首页");
				return;
			}
			$("#pageNo").val(parseInt($("#pageNo").val()-1));
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
		});
		$("#first").click(function(){			
			$("#pageNo").val(1);
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
		});
		$("#last").click(function(){			
			$("#pageNo").val(count);
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
		});
		$("#go").click(function(){			
			if($("#pageNo").val()>=count+1 || $("#pageNo").val()<=0){
				alert("输入的页数不正确");
				return;
			}
			queryForm.action="${pageContext.request.contextPath}/controller/parts?flag=query";
			queryForm.submit();
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
            <th align="right">配件名称：</th>
            <td><input name="partsName" type="text" class="inputTextNormal" id="textfield2" /></td>

            <th align="right">
				<input type="button" class="btnShort" value="检索" id="findBtn"/>
			</th>
        </tr>
       
    </table>


    <!--//commonTableSearch-->
    
	<input type="button" class="btnNormal" value="新增配件" onclick="location.href='${pageContext.request.contextPath }/page/partssys/parts/partsadd.jsp'"/>	

	<br>

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>配件编码</th>
            <th>配件名称</th>
            <th>生产厂家</th>
            <th>生产日期</th>
            <th>备注</th>
            <th class="editColDefault">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list }" var="parts" varStatus="count">
        <tr>
            <td align="center">${count.count+(pageInfo.pageNum-1)*5 }</td>
            <td align="center">${parts.partsId }</td>
            <td align="center">${parts.partsName }</td>
            <td align="center">${parts.partsLoc }</td>
            <td align="center"><f:formatDate value="${parts.partsProDate }" pattern="yyyy-MM-dd"/> </td>
			<td align="center">${parts.partsRemark }</td>
            <td align="center">
            	
            	<a href="${pageContext.request.contextPath }/controller/parts?flag=edit&partsId=${parts.partsId}" class="btnIconEdit" title="更新" id="update"></a>
                <a href="${pageContext.request.contextPath }/controller/parts?flag=delete&partsId=${parts.partsId}" class="btnIconDel" title="删除" id="delete"></a>
            </td>
        </tr>
        </c:forEach>
        
  </table>
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
</div>
	</form>
<!--//content pages wrap-->
</body>
</html>