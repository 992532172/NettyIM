<#include "/common/common.ftl" />
<!DOCTYPE html>
<html lang="zh-cn">
<@head.head title="${title}" basePath="${basePath}">
</@head.head>
<body id="login" class="animated fadeInDown">
<#include "/common/header.ftl" />
<div id="main" role="main">
	<div id="content" class="container">
       	<div class="row">
       		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4"></div>
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				<div class="well no-padding">
					<form id="loginForm" class="smart-form client-form" method="post" onsubmit="return false;">
						<header>
							<h1 class="txt-color-red login-header-big">登录</h1>
						</header>
						<fieldset>
							<section>
								<!-- <label class="label">用户名</label> -->
								<label class="input"><i class="icon-append fa fa-user"></i>
									<input type="text" id="userid" name="userid" placeholder="请输入用户名" value="${userid?if_exists}" autofocus="autofocus" />
									<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i>请输入用户名</b>
								</label>
							</section>
							<section>
								<!-- <label class="label">密码</label> -->
								<label class="input"><i class="icon-append fa fa-lock"></i>
									<input type="password" id="password" name="password" placeholder="请输入密码" value="${password?if_exists}">
									<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i>请输入密码</b>
								</label>
							</section>
						</fieldset>
						<footer>
							<label class="txt-color-red" style="margin-top: 16px;"><span class="invalid" id="validTip" style="display: none;"></span></label>
							<button type="button" id="loginBtn" class="btn btn-primary" onClick="login()">登录</button>
							<button type="button" id="loginBtn" class="btn btn-primary" onClick="register()">注册</button>
						</footer>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<@foot.foot basePath="${basePath}"></@foot.foot>
<script type="text/javascript">		
	$.fn.serializeObject = function() {
					var o = {};
					var a = this.serializeArray();
					$.each(a, function() {
						if (o[this.name]) {//如果这个name已经存在
							if (!o[this.name].push) {//这个name还不是数组
								o[this.name] = [ o[this.name] ];//把这个name嵌套成数组  {'weeks':'2'}==>{'weeks':['2']}
							}
							o[this.name].push(this.value || '');//把值放到数组中
						} else {
							o[this.name] = this.value || '';//先赋值
							if (this.name == "weeks") {//第一次出现weeks
								o[this.name] = [ o[this.name] ];//嵌套成数组
							} 
						}
					});
					return o;
				};

	// 校验参数，异步提交表单
	function login(){
		var formVal = $("#loginForm").serializeObject();
		$.ajax({
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            url: "${basePath}/login",
            data: JSON.stringify(formVal),
            error: function(data) {
                alert("服务异常");
            },
            success: function(data) {
                if (data == null) {
                	alert("服务异常");
                } else if (data.code == -1) {
                	alert("帐号或密码错误");
                } else {
                	window.location.href = '${basePath}/index?id=' + data.msg
                }
            }
        });
	}
	
	function register(){
		window.location.href = '${basePath}/register'
	}
</script>
</body>
</html>