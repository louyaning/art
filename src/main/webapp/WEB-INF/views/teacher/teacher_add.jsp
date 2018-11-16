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
  <title>后台管理系统</title>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">老师资料</strong> / <small>Teacher information</small></div>
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
                    <input type="file" id="user-pic">
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
      
      
        <form id="pageForm" class="am-form am-form-horizontal" action="${ctx}/user/add" method="post" autocomplete="off">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">姓名 </label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" name="username" placeholder="姓名 / Name">
             <!--  <small>账号</small> -->
            </div>
          </div>
         
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">密码 </label>
            <div class="am-u-sm-9">
              <input type="password" id="user-email" name="password"  placeholder="输入密码 ">
            </div>
          </div>
          
           <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">手机号 </label>
            <div class="am-u-sm-9">
              <input type="text" id="user-email" name="mobile"  placeholder="输入手机号 ">
            </div>
          </div>
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 </label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" name="email"  placeholder="输入电子邮件 ">
              
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-phone" class="am-u-sm-3 am-form-label">信息</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-phone" name="info" placeholder="输入老师信息">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-QQ" class="am-u-sm-3 am-form-label">类型</label>
            <div class="am-u-sm-9">
              <input name="type" type="text" id="user-QQ" placeholder="老师类型">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-weibo" class="am-u-sm-3 am-form-label">权重</label>
            <div class="am-u-sm-9">
              <input name="weight" type="text" id="user-weibo" placeholder="权重">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">备注</label>
            <div class="am-u-sm-9">
              <textarea name="descMemo" class="" rows="5" id="user-intro" placeholder="备注"></textarea>
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
