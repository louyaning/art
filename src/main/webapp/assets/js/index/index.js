$(document).ready(function () {
	loadCourseWare();
});

//TODO
//上线前请更改pageSize。
var pageSize = 6;
function loadCourseWare(id,name,parentName,pageno,pagesize) {
	console.log("id==="+id+"==name===="+name+"==parentName===="+parentName+"==pageno===="+pageno+"==pagesize===="+pagesize);
	$("#courseParentName").text(parentName);
	$("#courseName").text(name);
	$("#courseWare").html("");
	if(id==null){
		id = -1;
	}
	if(pagesize == null){
		pagesize = pageSize;
	}
	if(pageno == null){
		pageno = 1;
	}
	var parameter = {
			pageSize:pagesize,
			pageNo:pageno,
			courseId:id
	}
	
	$.ajax({
        type: "post",
        url: "../loadCourseWare",
        data: parameter,
        dataType: "json",
        async: true,
        success: function (data) {
        	console.log(data);
        	//封装页码
        	$("#rowNumber").html("共 "+data.total+" 条记录");
        	
        	var html = "";
        	//首页
        	if(pageno == 1){
    			html +=  "<li class=\"am-disabled\"><a href=\"#\">&laquo;</a></li>"
    		}else{
    			html +=  "<li><a onclick=\"loadCourseWare("+id+",'"+name+"','"+parentName+"',"+(pageno-1)+","+pagesize+")\" href=\"javaScript:;\" >&laquo;</a></li>"
    		}
        	//中间页码
        	for(var i=1;i<=data.totalNumber;i++){
        		if(i==pageno){
        			html += "<li class=\"am-active\"><a href=\"javaScript:;\" onclick=\"loadCourseWare("+id+",'"+name+"','"+parentName+"',"+i+","+pagesize+")\">"+i+"</a></li>"
        		}else{
        			html += "<li><a href=\"javaScript:;\" onclick=\"loadCourseWare("+id+",'"+name+"','"+parentName+"',"+i+","+pagesize+")\">"+i+"</a></li>"
        		}
        		
        		
        	}
        	//尾页
        	console.log(pageno);
        	if(pageno == data.totalNumber || data.totalNumber == 0 ){
    			html +=  "<li class=\"am-disabled\"><a href=\"#\">&raquo;</a></li>"
    		}else{
    			html +=  "<li><a href=\"javaScript:;\" onclick=\"loadCourseWare("+id+",'"+name+"','"+parentName+"',"+(pageno+1)+","+pagesize+")\">&raquo;</a></li>"
    		}
        	
            $("#pageCount").html(html);
        	//封装插件
        	if(data.rows.length>0){
        		var data = data.rows;
        		var str = "";
        		
				for(var item in data){
					str += "<li><a  href='../downCourseWare?fileName="+data[item].wareName+"'><img class='am-img-thumbnail am-img-bdrs' src = '"+data[item].imgUrl+"'>"
					+"<div class=\"gallery-title\">"+"文件名字："+data[item].realName+"</div>"
					+"<div class=\"gallery-title\">"+"文件信息："+data[item].desc+"</div>"
					+"<div class=\"gallery-desc\">"+timeStamp2String(data[item].modifyDatetime)+"</div>"
    				+"</a>";
					
        		}
        		$("#courseWare").html(str);
				
        	}
        	
        	
         
        }
    });
	
	function timeStamp2String(time){
	    var datetime = new Date();
	    datetime.setTime(time);
	    var year = datetime.getFullYear();
	    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
	    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
	}
	 
}