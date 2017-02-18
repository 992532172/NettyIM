<#macro foot basePath="">
<!--================================================== -->
<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
<script data-pace-options='{ "restartOnRequestAfter": true }' src="${basePath}/js/plugin/pace/pace.min.js"></script>
      <script src="${basePath}/js/libs/jquery-2.0.2.min.js"></script>
      <script src="${basePath}/js/libs/jquery-ui-1.10.3.min.js"></script>

<!-- BOOTSTRAP JS -->
<script src="${basePath}/js/bootstrap/bootstrap.min.js"></script>

<!-- CUSTOM NOTIFICATION -->
<script src="${basePath}/js/notification/SmartNotification.min.js"></script>

<!-- JARVIS WIDGETS -->
<script src="${basePath}/js/smartwidgets/jarvis.widget.min.js"></script>

<!-- EASY PIE CHARTS -->
<script src="${basePath}/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

<!-- SPARKLINES -->
<script src="${basePath}/js/plugin/sparkline/jquery.sparkline.min.js"></script>

<!-- JQUERY VALIDATE -->
<script src="${basePath}/js/plugin/jquery-validate/jquery.validate.min.js"></script>

<!-- JQUERY MASKED INPUT -->
<script src="${basePath}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

<!-- JQUERY SELECT2 INPUT -->
<script src="${basePath}/js/plugin/select2/select2.min.js"></script>

<!-- JQUERY UI + Bootstrap Slider -->
<script src="${basePath}/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

<!-- browser msie issue fix -->
<script src="${basePath}/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

<!-- FastClick: For mobile devices -->
<script src="${basePath}/js/plugin/fastclick/fastclick.js"></script>

<script src="${basePath}/js/plugin/bootstrap-datepicker.js"></script>
<script src="${basePath}/js/plugin/summernote/summernote.js"></script>

<!--[if IE 7]>

<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

<![endif]-->

<!-- Demo purpose only -->
<!--
<script src="${basePath}/js/demo.js"></script>
      -->

<!-- MAIN APP JS FILE -->
<script src="${basePath}/js/app.js"></script>

<!-- PAGE RELATED PLUGIN(S) -->

<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
<script src="${basePath}/js/plugin/flot/jquery.flot.cust.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.resize.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.tooltip.js"></script>

<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
<script src="${basePath}/js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${basePath}/js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.cust.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.resize.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.fillbetween.min.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.orderBar.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.pie.js"></script>
<script src="${basePath}/js/plugin/flot/jquery.flot.tooltip.js"></script>

<!-- PAGE RELATED PLUGIN(S) -->
<script src="${basePath}/js/plugin/datatables/jquery.dataTables-cust.min.js"></script>
<script src="${basePath}/js/plugin/datatables/ColReorder.min.js"></script>
<script src="${basePath}/js/plugin/datatables/FixedColumns.min.js"></script>
<script src="${basePath}/js/plugin/datatables/ColVis.min.js"></script>
<script src="${basePath}/js/plugin/datatables/ZeroClipboard.js"></script>
<script src="${basePath}/js/plugin/datatables/media/js/TableTools.min.js"></script>
<script src="${basePath}/js/plugin/datatables/DT_bootstrap.js"></script>

<!-- Full Calendar -->
<script src="${basePath}/js/plugin/fullcalendar/jquery.fullcalendar.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	pageSetUp();
	
	/** 分页 **/
	$('#pageSelect').on('change', function() {
		var pageNo = $(this).find('option:selected').text();
		toPage(pageNo);
	});
});
//$.root_.addClass("container");
//$.root_.removeClassPrefix('smart-style').addClass("smart-style-3");
</script>
<#nested>
</#macro>