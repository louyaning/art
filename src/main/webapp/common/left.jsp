<%--
  Created by IntelliJ IDEA.
  User: YaNing
  Date: 2018/11/12
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="${ctx}/web/index?teacherId=${sessionScope.user.id}"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 人员管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="${ctx}/user/toadd" class="am-cf"><span class="am-icon-check"></span> 新增老师<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
           <c:if test="${'超级管理员' eq sessionScope.user.type}">
          <li><a href="${ctx}/user/users"><span class="am-icon-puzzle-piece"></span> 老师以及管理员列表</a></li>
           </c:if>
          <c:if test="${'管理员' eq sessionScope.user.type}">
          <li><a href="${ctx}/user/teachers"><span class="am-icon-puzzle-piece"></span> 老师列表</a></li>
          </c:if>
          <li><a href="${ctx}/log/logs"><span class="am-icon-calendar"></span> 登录日志</a></li>
        </ul>
      </li>
      <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-th"></span>课程管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
          <li><a href="${ctx}/course/toadd" class="am-cf"><span class="am-icon-check"></span> 新增课程<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="${ctx}/course/courses"><span class="am-icon-th"></span> 课程列表</a></li>
          <li><a href="${ctx}/course/toDistribution"><span class="am-icon-puzzle-piece"></span> 课程分配</a></li>
        </ul>
      </li>
       <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-pencil-square-o"></span>课件管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
          <li><a href="${ctx}/courseware/toadd" class="am-cf"><span class="am-icon-check"></span> 新增课件<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="${ctx}/courseware/coursewares"><span class="am-icon-puzzle-piece"></span>课件查看</a></li>
         
        </ul>
      </li>
      
      <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-calendar"></span>权限管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="${ctx}/authority/toAuthority" class="am-cf"><span class="am-icon-check"></span> 新增权限<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="${ctx}/authority/authoritys"><span class="am-icon-puzzle-piece"></span>权限查看</a></li>
        </ul>
      </li> 
      
      <li class="admin-parent">
       <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-bug"></span>年龄管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav4">
          <li><a href="${ctx}/age/toadd" class="am-cf"><span class="am-icon-check"></span> 新增年龄<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
        </ul>
      </li> 
      <li><a href="${ctx}/user/remove"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p id="contentNotice">${notice}</p>
        <textarea rows="4" cols="20" style="display: none" id="getNotice">这是一个编辑框</textarea>
        <button id="editNoticeBtn" onclick="editNotice()" type="button">编辑</button>
         <button id="saveNoticeBtn"  onclick="saveNotice()"style="display: none" type="button">保存</button>
      </div>
    </div>
    <script type="text/javascript">
    //修改编辑框	
    function editNotice() {
    		$("#contentNotice").hide();
    		var txt = $("#contentNotice").text();
			$("#saveNoticeBtn").show();
			$("#getNotice").text(txt);
			$("#getNotice").show();
			
		}
    	//保存编辑框
    	function saveNotice() {
    		var txt = $("#getNotice").val();
    		$.ajax({
    	        type: "post",
    	        url: "../saveNotcie",
    	        data:{content:txt},
    	        dataType: "json",
    	        async: true,
    	        success: function (data) {
    	        	console.log(data);
    	        	if(data.msg == "SUCCESS"){
    	        		alert("修改成功");
    	        		$("#contentNotice").text(txt);
        	        	$("#saveNoticeBtn").hide();
        	        	$("#contentNotice").show();
        	        	$("#getNotice").text();
        	        	$("#getNotice").hide();
    	        	}
    	        	
    	        	}
    	     
    	    });
    		
		}
    </script>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span>点石艺术</p>
        <p>欢迎${sessionScope.user.username}!</p>
      </div>
    </div>
  </div>


