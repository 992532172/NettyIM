<#macro status value="">
<#if value == 'I'>
    <span class="label label-danger"><@spring.message "common.inactive"/></span>
<#else>
    <span class="label label-info"><@spring.message "common.active"/></span>
</#if>
</#macro>


<#macro btn_group_cudl>
     <div class="btn-group" id="actionBtn">
        <button type="button" action="create" class="btn btn-primary"><@spring.message "action.create"/></button>
        <button type="button" action="update" data-toggle="popover" data-content="<@spring.message "action.tooltip"/>" data-placement="top" class="btn btn-warning"><@spring.message "action.update"/></button>
        <button type="button" action="delete" data-toggle="popover" data-content="<@spring.message "action.tooltip"/>" data-placement="top" class="btn btn-danger"><@spring.message "action.delete"/></button>
        <button type="button" action="log"  data-toggle="popover" data-content="<@spring.message "action.tooltip"/>" data-placement="top" class="btn btn-success"><@spring.message "action.log"/></button>
      </div>
</#macro>
