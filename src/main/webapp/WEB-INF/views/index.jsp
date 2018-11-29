<%--
  Created by IntelliJ IDEA.
  User: YaNing
  Date: 2018/11/12
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>

<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<script language="JavaScript">
    var ctx = '${ctx}';
</script>
<html class="no-js">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>首页显示</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="../assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../assets/css/admin.css">
 
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header>
   <%@ include file="/common/head.jsp"%>
  </header>
  <div>
  <%@ include file="/common/left.jsp"%>

  <!-- content start -->
  	<div class="admin-content">


	

	<div class="am-u-sm-centered">
		<ul class="am-nav-justify am-thumbnails am-nav  am-padding am-nav-pills am-text-center admin-content-list">
		   
		    <c:forEach items="${courses}" var="course">
			    <li class="am-dropdown" data-am-dropdown>
			        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
			           ${course.courseName } <span class="am-icon-caret-down"></span>
			        </a>
			        <ul class="am-dropdown-content am-nav-justify">
			            <c:forEach items="${course.courses}" var="course2">
			            	<li><a href="javaScript:;" onclick="loadCourseWare('${course2.id}','${course2.courseName}','${course.courseName }')">${course2.courseName }</a></li>
			            </c:forEach>
			        </ul>
			    </li>
		    </c:forEach>
		    
		 </ul>
	 </div>
	 
	 <div class="am-cf am-padding">
	      <div class="am-fl am-cf"><strong  id="courseParentName" class="am-text-primary am-text-lg">首页</strong> / <small id="courseName">Gallery</small></div>
	 </div>
	<!-- 	 <div class="am-cf am-padding">
      <div class="am-fl am-cf"><small id="courseName">Gallery</small></div>
    </div> -->

    <ul id="courseWare" class="am-avg-sm-2 am-avg-md-4 am-avg-lg-6 am-margin gallery-list">
      <li>
        <a href="#">
          <img class="am-img-thumbnail am-img-bdrs" src="http://cn.bing.com/az/hprichv/LondonTrainStation_GettyRR_139321755_ZH-CN742316019.jpg" alt=""/>
          <div class="gallery-title">远方 有一个地方 那里种有我们的梦想</div>
          <div class="gallery-desc">2375-09-26</div>
        </a>
      </li>
    </ul>

    <div class="am-margin am-cf">
      <hr/>
      <p class="am-fl">共 15 条记录</p>
      <ol class="am-pagination am-fr">
        <li class="am-disabled"><a href="#">&laquo;</a></li>
        <li class="am-active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
      </ol>
    </div>

  <!-- content end -->
		
    </div>
  </div>
  
 

   



<%@ include file="/common/foot.jsp"%>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../assets/js/jquery.min.js"></script>
 <script src="../assets/js/index/index.js"></script>
<script src="../assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="../assets/js/app.js"></script>
</body>
<%@ include file="/common/messages.jsp" %>
</html>
