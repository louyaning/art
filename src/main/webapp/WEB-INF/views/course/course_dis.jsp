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
  <title>Amaze后台管理系统模板HTML首页 - cssmoban</title>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">课程分配</strong> / <small>Teacher information</small></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
       
        </div>


      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form id="pageForm" class="am-form am-form-horizontal" action="${ctx}/course/addKids" method="post" autocomplete="off">
        <input type="hidden" name="ids" id="ids">
        <input type="hidden" name="courseId" id="courseId">
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
          <div class="am-u-sm-3 am-text-right">适用年龄:</div>
          <div class="am-form-group">
            <div class="am-btn-group" data-am-button id="ages">
            
            <c:forEach items="${ages}" var="ag" varStatus="index">
              <label class="am-btn am-btn-default am-btn-xs">
                <input type="checkbox" name="age" value="${ag.age}">
							${ag.age}
              </label>
             </c:forEach>
            </div>
          </div>
        </div>
          
           <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">权重: </label>
            <div class="am-u-sm-9">
              <input type="text" id="user-email" name="weight"  placeholder="权重(只能输入整数)" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
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
    var value= $('#selectCourse  option:selected').val();
    $("#ids").val(str);
    $("#courseId").val(value);
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
});

</script>
</body>
</html>
