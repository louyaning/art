$(document).ready(function () {
	loadCourseWare();
});

function loadCourseWare(id,name,parentName) {
	$("#courseParentName").text(parentName);
	$("#courseName").text(name);
	$("#courseWare").html("");
	if(id==null){
		id = -1;
	}
	
	$.ajax({
        type: 'post',
        url: "../loadCourseWare",
        data: {courseId:id},
        dataType: 'json',
        async: true,
        success: function (data) {
        
        	if(data.length>0){
        		
        		var str = "";
        		
				for(var item in data){
					str += "<li><a  href='../downCourseWare?fileName="+data[item].wareName+"'><img class='am-img-thumbnail am-img-bdrs' src = '" +data[item].imgUrl
					+"'>"
					+"<div class='gallery-title'>"+'文件名字：'+data[item].realName+"</div>"
					+"<div class='gallery-title'>"+'文件信息：'+data[item].desc+"</div>"
					+"<div class='gallery-desc'>"+timeStamp2String(data[item].modifyDatetime)+"</div>"
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