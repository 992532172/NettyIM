<div class="modal fade" id="selectBannerModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 840px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">添加Banner</h4>
			</div>
			<div class="modal-body" style="padding-bottom: 8px;">
				<form id="bannerUploadForm" class="form-horizontal" method="post" action="${basePath}/image/upload" enctype="multipart/form-data" target="uploadframe">
					<input type="hidden" name="relateType" />
					<input type="hidden" name="relateCode" />
					<fieldset>
						<div class="alert alert-block alert-info">
							<h4 class="alert-heading">上传本地图片</h4>
						</div>
						<div class="form-group">
							<div class="col-md-10">
								<input type="hidden" id="format" name="format" />
								<input class="form-control" type="file" id="file" name="file" />
							</div>
							<div class="col-md-2">
								<input type="submit" class="btn btn-success" value="上传图片" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12"><span class="label label-warning" style="font-weight: normal;padding: 6px 12px;"><i class="fa-fw fa fa-warning" style="margin-right: 4px;"></i>仅支持jpg图片格式，推荐尺寸：<span id="imgsize">1600 x 558</span>，大小不可超过2M。</span></div>
						</div>
						<div class="alert alert-block alert-info">
							<h4 class="alert-heading">选择已上传图片</h4>
						</div>
						<div class="form-group">
							<div class="superbox col-sm-12"></div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="selectActiveModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 880px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">选取促销活动</h4>
			</div>
			<div class="modal-body" style="padding-bottom: 8px;">
				<iframe width="840" height="440" frameborder="0"></iframe>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="selectHotelModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 880px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">选取酒店</h4>
			</div>
			<div class="modal-body" style="padding-bottom: 8px;">
				<iframe width="840" height="440" frameborder="0"></iframe>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="overseaAreaModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 640px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body" style="padding-bottom: 8px;">
				<form class="form-horizontal" method="post" action="${basePath}/hotel/area/save">
					<input type="hidden" name="id" />
					<fieldset>
						<div class="form-group">
							<label class="col-md-2 control-label" for="name" style="font-size: 16px;">区域名</label>
							<div class="col-md-10">
								<input class="form-control" type="text" name="name" />
							</div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" id="saveAreaBtn" class="btn btn-primary">保存</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="selectRoomModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 880px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">选取房型</h4>
			</div>
			<div class="modal-body" style="padding-bottom: 8px;">
				<iframe width="840" height="440" frameborder="0"></iframe>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="selectHotelImageModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 840px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">上传酒店图片</h4>
			</div>
			<div class="modal-body" style="padding-bottom: 8px;">
				<form id="hotelImageUploadForm" class="form-horizontal" method="post" action="${basePath}/image/hotel/upload" enctype="multipart/form-data" target="uploadframe">
					<fieldset>
						<div class="form-group">
							<div class="col-md-10">
								<input class="form-control" type="file" id="file" name="file" />
							</div>
							<div class="col-md-2">
								<input type="submit" class="btn btn-success" value="上传图片" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12"><span class="label label-warning" style="font-weight: normal;padding: 6px 12px;"><i class="fa-fw fa fa-warning" style="margin-right: 4px;"></i>仅支持jpg图片格式，大小不可超过2M。</span></div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<iframe id="uploadframe" name="uploadframe" style="display: none;"></iframe>