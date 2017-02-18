<div class="dt-row dt-bottom-row">
	<div class="row">
		<div class="col-sm-12">
			<div class="dataTables_paginate paging_bootstrap_full">
				<ul class="pagination">
					<#if page.currentPage lte 1>
						<li class="first disabled"><a href="javascript:toPage('1');">首页</a></li>
						<li class="prev disabled"><a href="javascript:toPage('${page.prePage}');">上一页</a></li>
					<#else>
						<li class="first"><a href="javascript:toPage('1');">首页</a></li>
						<li class="prev"><a href="javascript:toPage('${page.prePage}');">上一页</a></li>
					</#if>
					
					<#if page.currentPage gte page.totalPage>
						<li class="next disabled"><a href="javascript:toPage('${page.nextPage}');">下一页</a></li>
						<li class="last disabled"><a href="javascript:toPage('${page.totalPage}');">末页</a></li>
					<#else>
						<li class="next"><a href="javascript:toPage('${page.nextPage}');">下一页</a></li>
						<li class="last"><a href="javascript:toPage('${page.totalPage}');">末页</a></li>
					</#if>
				</ul>
					<div class="dataTables_info" style="float: right;">
						<span class="smart-form">
							当前第${page.currentPage}页        共有${page.totalCount}条
						</span>
					</div>
			</div>
		</div>
	</div>
</div>