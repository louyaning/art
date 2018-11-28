<%-- Error Messages --%>
<%@ page language="java" pageEncoding="UTF-8" %>

<button id="alerts"
  type="button"
  class="am-btn am-btn-primary"
  data-am-modal="{target: '#my-alert'}">
  
</button>

<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示信息</div>
    <div class="am-modal-bd">
     ${Msg}
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>
<script>
$('#my-alert').modal();
</script>


