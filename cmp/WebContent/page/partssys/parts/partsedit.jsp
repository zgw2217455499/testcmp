<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script>
	$(function(){
		$("#saveBtn").click(function(){
			coursesCreat.action="${pageContext.request.contextPath}/controller/parts?flag=update";
			coursesCreat.submit();
		});
	})
</script>

</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
    <div class="commonTitle">
        <h2>&gt;&gt; 修改配件</h2>
  </div>
        <form id="coursesCreat" name="coursesCreat" action="" method="post"> 
        <input name="partsId" type="hidden" value="${parts.partsId }">    
		  <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
			  <tr>
				<td width="10%" align="right" class="title"><span class="required">*</span>配件名称：</td>
				<td width="15%" align="left"><input type="text" style="height:20px" value="${parts.partsName }" name="partsName"></td>
				<td width="10%" align="right" class="title"><span class="required">*</span>规格型号：</td>
				<td width="15%" align="left"><input type="text" style="height:20px" value="${parts.partsModel }" name="partsModel"></td>
			  </tr>
			  <tr>
				<td width="10%" align="right" class="title"><span class="required">*</span>生产厂家：</td>
				<td width="15%" align="left"><input type="text" style="height:20px" value="${parts.partsLoc }" name="partsLoc"></td>
				<td width="10%" align="right" class="title"><span class="required">*</span>生产日期：</td>
				<td width="15%" align="left"><input type="text" style="height:20px" name="partsProDate" value="<f:formatDate value="${parts.partsProDate}" pattern="yyyy-MM-dd"/>"></td>
</td>
			  </tr>			  
			  <tr>	
				<td width="10%" align="right" class="title"><span class="required">*</span>备注：</td>
				<td width="15%" align="left" colspan="3"><textarea style="width:720px;height:100px" name="partsRemark">${parts.partsRemark }</textarea></td>
			  </tr>
		 </table>
		</form>
	 </div>
    <div id="formPageButton">
    	<ul>
			<li><a href="#" title="保存" class="btnShort" id="saveBtn">保存</a></li>
        	<li><a href="javascript:window.history.go(-1)" title="返回" class="btnShort">返回</a></li>
        </ul>
    </div>
  
</div>

</body>
</html>
