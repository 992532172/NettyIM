<header id="header">
	<div id="logo-group">
		<h1 class="txt-color-red login-header-big" style="margin-left: 2px;">${title}</h1>
	</div>
	<#if slogin?exists>
	<div class="pull-right">
		<#if slogin == "1">
		<div id="logout" class="btn-header transparent pull-right">
			<span><a href="${basePath}/logout" title="退出"><i class="fa fa-sign-out"></i></a></span>
		</div>
		<ul class="header-dropdown-list hidden-xs" style="margin-right: 12px;">
			<li>
				<a href="javascript:void(0)" class="dropdown-toggle"><span id="suser_name">${userid}-${username}</span></a>
			</li>
		</ul>
		</#if>
	</div>
	</#if>
</header>