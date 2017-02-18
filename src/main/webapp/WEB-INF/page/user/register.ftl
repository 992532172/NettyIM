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
					<form id="registerForm" class="smart-form client-form" method="post" onsubmit="return false;">
						<header>
							<h1 class="txt-color-red login-header-big">注册</h1>
						</header>
						<fieldset>
							<section>
								<label class="input">帐号：<input type="text" id="userid" name="userid" value="${userid?if_exists}" placeholder="请输入用户名" autofocus="autofocus" />
								</label>
							</section>
							<section>
								<label class="input">密码：<input type="password" id="password" name="password" value="${password?if_exists}" placeholder="请输入密码">
								</label>
							</section>
							<section>
								<label class="input">昵称：<input type="text" id="nickname" name="nickname" value="${nickname?if_exists}" placeholder="输入昵称">
								</label>
							</section>
							<section>
								<label class="input">邮箱：<input type="text" id="emial" name="email" value="${email?if_exists}" placeholder="请输入邮箱">
								</label>
							</section>
						</fieldset>
						<footer>
							<button type="button" id="loginBtn" class="btn btn-primary" onClick="register()">提交</button>
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
	function register(){
		var formVal = $("#registerForm").serializeObject();
		$.ajax({
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            url: "${basePath}/register",
            data: JSON.stringify(formVal),
            error: function(data) {
                alert("服务异常");
            },
            success: function(data) {
                if (data == null) {
                	alert("服务异常");
                } else if (data.code == -1) {
                	alert(data.msg);
                } else {
                	alert("注册成功");
                	window.location.href = '${basePath}?id=' + data.msg
                }
            }
        });
	}
</script>
</body>
</html>