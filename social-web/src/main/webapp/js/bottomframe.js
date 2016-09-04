$(document).ready(function(){
	createMenuByFuns(2);
	//bindValidate();
});

function createMenuByFuns(num){
	//var userType = "1"//sessionStorage.getItem("_user_type");
	var menu = "";
	if(num == 2){
		//if(userType=="1"){
		var funJson = sessionStorage.getItem("funs");
		var funs = JSON.parse(funJson);
		var funMap = new HashMap();
		if(funs!=null && funs!=""){
			//console.log(JSON.stringify(funs));
			for(var i=0;i<funs.length;i++){		
				//alert(funs[i].url);
				funMap.put(funs[i].url,funs[i].id);
			}
		}
		
		if(funMap.get("parent1")!=null){
			if(funMap.get("user/manage_yonghu_modPass.html")!=null){
				menu += '<li><a href="sys/user/manage_yonghu_modPass.html" id="m1" class="m1 dq" target="iframepage">用户管理</a></li>';
			}
			if(funMap.get("role/manage_juese.html")!=null){
				menu += '<li><a href="sys/role/manage_juese.html" class="m2" id="m2" target="iframepage">角色管理</a></li>';
			}
			if(funMap.get("authority/manage_quanxian.html")!=null){
				menu += '<li><a href="sys/authority/manage_quanxian.html" id="m3" class="m3" target="iframepage">权限管理</a></li>';
			}
			if(funMap.get("log/manage_rizhi.html")!=null){
				menu += '<li><a href="sys/log/manage_rizhi.html" class="m4" id="m4" target="iframepage">日志管理</a></li>';
			}
			if(funMap.get("group/manage_bumen.html")!=null){
				menu += '<li><a href="sys/group/manage_bumen.html" class="m5" id="m5" target="iframepage">部门管理</a></li>';
			}
			if(funMap.get("area/manage_xingzhengquhua.html")!=null){
				menu += '<li><a href="sys/area/manage_xingzhengquhua.html" class="m6" id="m6" target="iframepage">行政区划管理</a></li>';
			}
			/*if(funMap.get("net/manage_net.html")!=null){
				menu += '<li><a href="sys/net/manage_net.html" class="m7" id="m7" target="iframepage">网格管理</a></li>';
			}
			if(funMap.get("caseworker/manage_caseworker.html")!=null){
				menu += '<li><a href="sys/caseworker/manage_caseworker.html" class="m8" id="m8" target="iframepage">社工管理</a></li>';
			}*/
			if(funMap.get("eventtype/manage_event_type.html")!=null){
				menu += '<li><a href="sys/eventtype/manage_event_type.html" class="m9" id="m9" target="iframepage">事件类型管理</a></li>';
			}
			if(funMap.get("eventtypic/manage_event_typic.html")!=null){
				menu += '<li><a href="sys/eventtypic/manage_event_typic.html" class="m10" id="m10" target="iframepage">热点事件管理</a></li>';
			}
			if(funMap.get("control/manage_control.html")!=null){
				menu += '<li><a href="sys/control/manage_control.html" class="m11" id="m11" target="iframepage">事件监控管理</a></li>';
			}
		}
		
	
		$("#xitong").addClass("navTopDq");
		$("#shijian").removeClass("navTopDq");
	}
	else if(num==1){
		$("#shijian").addClass("navTopDq");
		$("#xitong").removeClass("navTopDq");
	}
	$('#menulist').html(menu);
	menuBind(); 
	
}

function menuBind(){
	$("#menulist li").each(function(){
		$(this).click(function(){
			$(this).children().addClass("dq");
			$(this).siblings().children().removeClass("dq");
		});
	});
	/*$("#menulist li").find(".current").click(function(){
		alert("ss");
        $(this).addClass("current");
        $(this).find("a").addClass("dq");
        $(this).siblings().removeClass("current");
        $(this).siblings().find("a").removeClass("current");
    });*/
}
