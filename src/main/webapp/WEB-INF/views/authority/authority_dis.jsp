<%--
  Created by IntelliJ IDEA.
  User: YaNing
  Date: 2018/11/12
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>
  
  <html>
  <head lang="en">
  <meta charset="UTF-8">
  <title>点石艺术后台管理系统</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>点石艺术后台管理系统首页</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="../assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>

 <header>
   <%@ include file="/common/head.jsp"%>
  </header>
  <div>
  <%@ include file="/common/left.jsp"%>
 
<!-- content start -->
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">老师权限分配</strong> / <small>TeacherAuthority information</small></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-4">
                <img class="am-img-circle am-img-thumbnail" src="http://amui.qiniudn.com/bw-2014-06-19.jpg?imageView/1/w/1000/h/1000/q/80" alt=""/>
              </div>
              <div class="am-u-md-8">
                <p>你可以使用<a href="#">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>
                <form class="am-form">
                  <div class="am-form-group">
                    <input type="password" id="user-pic">
                    <p class="am-form-help">请选择要上传的文件...</p>
                    <button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="user-info">
              <p>等级信息</p>
              <div class="am-progress am-progress-sm">
                <div class="am-progress-bar" style="width: 60%"></div>
              </div>
              <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
            </div>
            <div class="user-info">
              <p>信用信息</p>
              <div class="am-progress am-progress-sm">
                <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
              </div>
              <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
            </div>
          </div>
        </div>

      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form id="pageForm" class="am-form am-form-horizontal" action="${ctx}/authority/addAuthoritys" method="post" autocomplete="off">
        <input type="hidden" name="ids" id="ids">
        <input type="hidden" name="courseId" id="courseId">
        <input type="hidden" name="teacherId" id="teacherId">
        <input type="hidden" name="teacherName" id="teacherName">
		<input type="hidden" name="courseName" id="courseName"> 
		  <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">老师名称: </label>
             <!--   <select style=width:70%  class="form-control"  id="selectReapyCode"  validata-options="validType:'Require',msg:'不能为空'">
                                        <option value="" >请选择</option>  
              </select>  -->
               <div class="am-form-group am-margin-left am-fl">
              <select  id="selectTeacher" name="choicedTeacherId">
                <option value="">选择老师</option>
              </select>
            </div>
          </div>
		  
		  
		  <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">课程名: </label>
             <!--   <select style=width:70%  class="form-control"  id="selectReapyCode"  validata-options="validType:'Require',msg:'不能为空'">
                                        <option value="" >请选择</option>  
              </select>  -->
               <div class="am-form-group am-margin-left am-fl">
              <select  id="selectCourse" name="choicedCourseId">
                <option value="">选择课程</option>
              </select>
            </div>
          </div>
         
          <div class="am-form-group">
          <div class="am-u-sm-3 am-text-right">选择年龄:</div>
          <div class="am-form-group">
            <div class="am-btn-group" data-am-button id="ages">
              <%-- <label class="am-btn am-btn-default am-btn-xs">
                <input type="checkbox" name="age" value="${ag.id}">
							${ag.courseName}
              </label> --%>
            </div>
          </div>
         </div>
          
          
          
          

          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <button id="save" type="button" class="am-btn am-btn-primary">保存</button>
            </div> 
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- content end -->

</div>

<%@ include file="/common/foot.jsp"%>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->


<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/amazeui.min.js"></script>
<script src="../assets/js/jquery-2.1.4.min.js"></script>
<script src="../assets/js/app.js"></script>
<script type="text/javascript">

$("#save").click(function() {
	var str = "";  
    $("input[name='age']").each(function(){  
        if($(this).is(":checked"))  
        {  
            str += "," + $(this).val();  
        }  
    }); 
    var value= $('#selectCourse   option:selected').val();
    var coursename= $('#selectCourse   option:selected').text();
    var teacherid= $('#selectTeacher  option:selected').val();
    var teachername= $('#selectTeacher  option:selected').text();
    $("#ids").val(str);
    $("#courseId").val(value);
    $("#teacherId").val(teacherid);
    $("#teacherName").val(teachername);
    $("#courseName").val(coursename);
    $("#pageForm").submit();
    
})


$(document).ready(function(){
     $.ajax({
        contentType : "application/json;charset=utf-8",
        type : "POST",
        url : "${ctx}/course/selectCourse",
        dataType : "json",
        success : function(data) {
            $.each(data, function(i,courses) {
                $('#selectCourse').append(
                        $('<option>').text(courses.courseName).attr('value',courses.id));
            });
        }
    });
	
	
	 $.ajax({
        contentType : "application/json;charset=utf-8",
        type : "POST",
        url : "${ctx}/user/selectTeacher",
        dataType : "json",
        success : function(data) {
            $.each(data, function(i,teachers) {
                $('#selectTeacher').append(
                        $('<option>').text(teachers.username).attr('value',teachers.id));
            });
        }
    });
});


 $("#selectCourse").change(function(){
    	 var pid= $('#selectCourse  option:selected').val();
    	 $('#ages').empty();
         $.ajax({
            contentType : "application/json;charset=utf-8",
            type : "POST",
            url : "${ctx}/courseware/toloadAge/"+pid+"",
            dataType : "json",
            success : function(data) {
            	$.each(data, function(i,courses) {
                    $('#ages').append(
                    		 "<label class='am-btn am-btn-default am-btn-xs'>"+
                             "<input type='checkbox' class='useages' name='age' value="+courses.id+">"
            							+courses.courseName+
                             "</label>"
                    		 ); 
                });
        }
    });
 });

</script>
</body>
</html>
