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

<form action="${ctx}/user/users" id="pageForm">
 <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
             <!--  <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button> -->
            </div>
              <div class="am-form-group am-margin-left am-fl">
             <!--  <select>
                <option value="option1">所有类别</option>
                
              </select> -->
            </div>
          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
            <input type="text" id="username" name="username" class="am-form-field" placeholder="请输入老师姓名">
                <span class="am-input-group-btn">
                  <button id="query" class="am-btn am-btn-default" type="button">搜索</button>
                </span>
          </div>
        </div>
      </div>
    </div>
</form>

 <div class="am-g">
      <div class="am-u-sm-12">
        <table class="am-table am-table-bd am-table-striped admin-content-table">
                                <thead>
                                 <tr>
                                    <th >课程编号</th>
                                    <th >课程名称</th>
                                    <th >图标</th>
                                    <th >权重</th>
                                   
                                   
                                    
                                    <th >操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${pageInfo.list}" var="ele" varStatus="status">
                        <tr>
                                       
                                        <td>
                                               ${ele.id}
                                        </td>
                                        <td>
                                               ${ele.courseName}
                                        </td>
                                        <td>
                                               ${ele.cover}
                                        </td>
                                        <td>
                                               ${ele.weight}
                                        </td>
                                       
                                        <td >
                                         <div class="am-btn-toolbar">
                                           <div class="am-btn-group am-btn-group-xs">
                                            <a style="color: #7A67EE" class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${ctx }/course/toUpdate?id=${ele.id}"><span class="am-icon-pencil-square-o"></span>编辑</a>
                                            <a style="color: #FF4500" class="am-btn am-btn-default am-btn-xs am-text-danger" href="${ctx}/course/delete?id=${ele.id}"><span class="am-icon-trash-o"></span> 删除</a> 
                                          </div>
                                          </div>
                                        </td>
                                        
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
			
			
			<%--  <!--分页文字信息  -->
			<div class="am-u-sm-6">
			当前 ${pageInfo.pageNum }页,总${pageInfo.pages }页,总 ${pageInfo.total } 条记录</div>  --%>
			<!-- 分页条信息 -->
			<div class="am-u-sm-6">
			
				<nav aria-label="Page navigation">
				<ul class="am-pagination am-fr admin-content-pagination">
				<li>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }页,总 ${pageInfo.total } 条记录</li>
					<li><a href="${ctx}/course/courses?pn=1">首页</a></li>
					<!-- 如果有上一页就显示上一页 -->
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a href="${ctx }/course/courses?pn=${pageInfo.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">«</span>
						</a></li>
					</c:if>
 
					<!-- 如果是当前页就高亮显示，如果不是就正常显示 -->
					<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != pageInfo.pageNum }">
							<!-- 如果不是当前页，发生请求，带上页码数 -->
							<li><a href="${ctx}/course/courses?pn=${page_Num }">${page_Num }</a></li>
						</c:if>
					</c:forEach>
					
					<!-- 如果有下一页就显示下一页 -->
					<c:if test="${pageInfo.hasNextPage }">
						<li><a href="${ctx }/course/courses?pn=${pageInfo.pageNum+1 }"
							aria-label="Next"> <span aria-hidden="true">»</span>
						</a></li>
					</c:if>
					
					<li><a href="${ctx}/course/courses?pn=${pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
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
<script src="../assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="../assets/js/app.js"></script>
<script type="text/javascript">
$(function () {
  $("#query").click(function () {
	  $("#pageForm").submit();
    });
});
</script>  
</body>
</html>
