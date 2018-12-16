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
  <title>点石艺术后台管理系统模板首页 </title>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料查看</strong> / <small>Teacher information</small></div>
    </div>

    <hr/>

     <div class="am-g">
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
      </div>
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form id="pageForm" class="am-form am-form-horizontal" action="${ctx}/user/update" method="post" autocomplete="off">
        <input type="hidden" name="id" value="${user.id}">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">姓名 </label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" name="username" placeholder="姓名 / Name" value="${user.username}">
             <!--  <small>账号</small> -->
            </div>
          </div>
         
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">密码 </label>
            <div class="am-u-sm-9">
              <input type="password" id="user-email" name="password"  placeholder="输入密码 " value="${user.password}">
            </div>
          </div>
          
           <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">手机号 </label>
            <div class="am-u-sm-9">
              <input type="text" id="user-email" name="mobile"  placeholder="输入手机号 " value="${user.mobile}">
            </div>
          </div>
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 </label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" name="email"  placeholder="输入电子邮件 " value="${user.email}">
              
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-phone" class="am-u-sm-3 am-form-label">信息</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-phone" name="info" placeholder="输入老师信息" value="${user.info}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-QQ" class="am-u-sm-3 am-form-label">类型</label>
            <div class="am-u-sm-9">
              <input name="type" type="text" id="user-QQ" placeholder="老师类型" value="${user.type}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-weibo" class="am-u-sm-3 am-form-label">权重</label>
            <div class="am-u-sm-9">
              <input name="weight" type="text" id="user-weibo" placeholder="权重" value="${user.weight}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">备注</label>
            <div class="am-u-sm-9">
              <textarea name="descMemo" class="" rows="5" id="user-intro" placeholder="备注" value="${user.descMemo}"></textarea>
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

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="../assets/js/app.js"></script>
<script type="text/javascript">

$("#save").click(function() {
    $("#pageForm").submit();
})
$("#pageForm").checkForm(); 

</script>
</body>
</html>
