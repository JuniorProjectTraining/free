<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>注册界面</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<!-- 引入jquery框架 -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<!-- Bootstrap -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">

    <style type="text/css">
    	input{
    		width: 200px;
    	}
    
    </style>

</head>


<body>
	<div class="container">
		<h1 style="text-align: center;"> ----- 注册 -----</h1>
		<br>
		<br>
		
		<form class="form-horizontal" action="${pageContext.request.contextPath}/EmpServlet?cmd=register"
		method="post">
		
			<div class="form-group">
				<label for="nickname" class="col-sm-2 control-label">Nickname</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nickname"
						placeholder="nickname" name="nickname" onfocus="nMsg()" onblur="nCancelMsg()">
				</div>
				<span id = "nicknameSpan"></span>
			</div>
			
			<div class="form-group">
				<label for="password1" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password1"
						placeholder="Password" name="password" onfocus="p1Msg()" onblur="p1CancelMsg()">
				</div>
				<span id = "password1Span"></span>
			</div>
			
			<div class="form-group">
				<label for="password2" class="col-sm-2 control-label">Pwd Again</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password2"
						placeholder="Password" onfocus="p2Msg()" onblur="p2CancelMsg()">
				</div>
				<span id = "password2Span"></span>
			</div>
			
			<div class="form-group">
				<label for="gender" class="col-sm-2 control-label">Gender</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="gender"
						placeholder="gender" onfocus="gMsg()" onblur="gCancelMsg()">
				</div>
				<span id = "genderSpan"></span>
			</div>
				
			<div class="form-group">
				<label for="salary" class="col-sm-2 control-label">Salary</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="salary"
						placeholder="Salary" name="salary" onfocus="sMsg()" onblur="sCancelMsg()">
				</div>
				<span id = "salarySpan"></span>
			</div>
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Sign in</button>
					&emsp;&emsp;
					<button type="reset" class="btn btn-danger">reset</button>
				</div>
			</div>
		
		</form>
	</div>
	
	<!-- /container -->
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
				
</body>

<script type="text/javascript">
	
	/* 当光标放入到nickname的输入框中, 则提示输入信息 */
	function nMsg(){
		// alert("点击了nickname输入框");
		
		// 获取对应的span标签, 
		var nSpan = document.getElementById("nicknameSpan");
		
		// 在span标签中显示提示内容
		nSpan.innerHTML = "<font color='blue'>请输入8到16位的昵称</font>";
	}
	function nCancelMsg() {
		document.getElementById("nicknameSpan").innerHTML = null;
	}
	
	/* 当光标放入到password的输入框中, 则提示输入信息 */
	function p1Msg(){	
		var p1Span = document.getElementById("password1Span");
		p1Span.innerHTML = "<font color='blue'>请输入8到16位的密码</font>";
	}
	
	function p1CancelMsg() {
		document.getElementById("password1Span").innerHTML = null;
	}
	
	/* 当光标放入到pwd again的输入框中, 则提示输入信息 */
	function p2Msg(){	
		var p2Span = document.getElementById("password2Span");
		p2Span.innerHTML = "<font color='blue'>请重复输入相同的密码</font>";
	}
	function p2CancelMsg() {
		document.getElementById("password2Span").innerHTML = null;
	}
	
	/* 当光标放入到gender的输入框中, 则提示输入信息 */
	function gMsg(){	
		var gSpan = document.getElementById("genderSpan");
		gSpan.innerHTML = "<font color='blue'>请输入性别</font>";
	}
	function gCancelMsg() {
		document.getElementById("genderSpan").innerHTML = null;
	}
	
	/* 当光标放入到password的输入框中, 则提示输入信息 */
	function sMsg(){	
		var sSpan = document.getElementById("salarySpan");
		sSpan.innerHTML = "<font color='blue'>请输入工资</font>";
	}
	function sCancelMsg() {
		document.getElementById("salarySpan").innerHTML = null;
	}
	
</script>
</html>