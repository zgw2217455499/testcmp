<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>ASCM 系统</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
		$("#imageField").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath }/controller/login?flag=login",
				type:"get",
				data:{loginName:$("#loginName").val(),loginPwd:$("#loginPwd").val()},
				success:function(data){
					if(data=="0"){
						alert("登录失败");
					}else if(data=="1"){
						location.href="${pageContext.request.contextPath }/index.jsp";
					}
				},
				dataType:"text"
				});
			});
        	});
</script>
<style type="text/css">
<!--
a:link {
	color: #0000ff;
	xxxxtext-decoration: none;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px;
}
a:active {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px;
	color: #0000ff;
	xxxxxtext-decoration: none;
}
a:visited {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px;
	color: #0000ff;
	xxxxxtext-decoration: none;
}
a:hover {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px;
	color: #001155;
	xxxxxtext-decoration: none;
}
-->
</style></head>

<body leftmargin="0" topmargin="10" bgcolor="#FFFFFF" marginheight="0" marginwidth="0">
<!-- ImageReady Slices (未标题-2.psd) -->
<form id="loginForm" name="loginForm"  method="post" action="">
<table id="__01" align="center" border="0" cellpadding="0" cellspacing="0" height="513" width="794">
	<tbody><tr>
		<td>
			<img src="${pageContext.request.contextPath }/images/index_01.gif" alt="" height="371" width="43"></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/index_02.gif" alt="" height="371" width="163"></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/index_03.gif" alt="" height="371" width="163"></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/index_04.gif" alt="" height="371" width="163"></td>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/index_05.gif" alt="" height="371" width="262"></td>
	</tr>
	<tr>
		<td rowspan="4">
			<img src="${pageContext.request.contextPath }/images/index_06.gif" alt="" height="82" width="43"></td>
		<td rowspan="4">
			<img src="${pageContext.request.contextPath }/images/index_07.gif" alt="" height="82" width="163"></td>
		<td rowspan="4">
			<img src="${pageContext.request.contextPath }/images/index_08.gif" alt="" height="82" width="163"></td>
		<td rowspan="4">
			<img src="${pageContext.request.contextPath }/images/index_09.gif" alt="" height="82" width="163"></td>
		<td rowspan="4">
			<img src="${pageContext.request.contextPath }/images/index_10.gif" alt="" height="82" width="121"></td>
		<td colspan="2">
			<img src="${pageContext.request.contextPath }/images/index_11.gif" alt="" height="20" width="141"></td>
	</tr>
	<tr>
	  <td height="18"><input name="loginName" id="loginName" class="input" size="10" maxlength="20" type="text"></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/index_13.gif" alt="" height="24" width="35"></td>
	</tr>
	<tr>
		<td height="24" width="106">
		  <input name="loginPwd" id="loginPwd" class="input" size="10" maxlength="50" type="password">
		</td>
		<td>
			<img src="${pageContext.request.contextPath }/images/index_15.gif" alt="" height="24" width="35"></td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="${pageContext.request.contextPath }/images/index_16.gif" alt="" height="14" width="141"></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="${pageContext.request.contextPath }/images/index_17.gif" alt="" height="60" width="43"></td>
		<td rowspan="2" background="images/index_18.gif">
			<a href="http://cgb2.fawcar.com.cn/" target="_blank"></a></td>
		<td rowspan="2">
			<img src="${pageContext.request.contextPath }/images/index_19.gif" alt="" height="60" width="163"></td>
		<td rowspan="2">
			<img src="${pageContext.request.contextPath }/images/index_20.gif" alt="" height="60" width="163"></td>
	    <td colspan="3" align="left" background="images/index_21.gif" height="29" valign="top"><table border="0" cellpadding="0" cellspacing="0">
          <tbody><tr>
            <td height="20" width="97">&nbsp;</td>
            <td width="69"><input name="imageField" id="imageField" src="${pageContext.request.contextPath }/images/tu.gif"  type="button" value="登录"></td>
            <td class="a" width="70">忘记密码</td>
          </tr>
        </tbody></table></td>
	</tr>
	
	<tr>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/index_22.gif" alt="" height="31" width="262"></td>
	</tr>
</tbody></table>
<p>
  <!-- End ImageReady Slices -->
</p>
<p>&nbsp; </p>
</form>



</body></html>