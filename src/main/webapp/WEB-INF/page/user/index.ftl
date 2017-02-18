<#include "/common/common.ftl" />
<!DOCTYPE html>
<html lang="zh-cn">
<@head.head title="${title}" basePath="${basePath}">
</@head.head>
<body>
<#include "/common/header.ftl" />
<#include "/common/menu.ftl" />
<div id="main" role="main">
	<div id="ribbon">
		<ol class="breadcrumb">
			<li>首页</li>
		</ol>
	</div>
	<div id="content">
		<div class="jumbotron" style="text-align: center; padding-top: 120px;">
			<h1>${nickname}登录成功</h1>
		</div>
	</div>
</div>
<@foot.foot basePath="${basePath}"></@foot.foot>
</body>
</html>