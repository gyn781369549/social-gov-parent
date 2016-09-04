$(document).ready(function(){
	$("#loginUser").text("你好，"+sessionStorage.getItem("_user_name"));
	//$("#userName").html(sessionStorage.getItem("_user_name"));
	createMenuByFuns1();
	//$("#saveBtn").bind("click",this,save);
	//$("#resetBtn").bind("click",reset);
	bindValidate();
});

//banner最后边的退出按钮
function exit(){
	var tips = "确认退出吗？";
	layer.confirm(tips, {
		btn : [ '确认', '取消' ]
	//按钮
	},function(){
		var key = sessionStorage.getItem("key");
		var timestamp = new Date().getTime();
		var token =$.md5(timestamp+key.toUpperCase());
		
		var userId = sessionStorage.getItem("_user_id");
		$.ajax({
			url : $.ServiceHttp()+'platform/login/exit',
			data : {
				"token": token,
				"timestamp": timestamp,
				"id": userId
			},
			type : 'post',
			cache : false,
			dataType : 'json',
			error : function(err) {
				console.log("error:"+ JSON.stringify(err));
			},
			success : function(data) {
				console.log("data:"+ JSON.stringify(data));
				if(data.success==false){//返回结果为密码不正确
					//$("#oldPwWarning").append("旧密码输入错误！");
					//closePop('closeBtn');
					layer.msg("退出失败");
					//closePop(e);
					//$("#saveBtn").bind("click",save);
					return;
				}
				else{
					if(sessionStorage.getItem("_user_name")!=null && sessionStorage.getItem("_user_name")!=""){
						sessionStorage.removeItem("_user_name");
					}
					if(sessionStorage.getItem("funs")!=null && sessionStorage.getItem("funs")!=""){
						sessionStorage.removeItem("funs");
					}
					if(sessionStorage.getItem("key")!=null && sessionStorage.getItem("key")!=""){
						sessionStorage.removeItem("key");
					}
					if(sessionStorage.getItem("ip")!=null && sessionStorage.getItem("ip")!=""){
						sessionStorage.removeItem("ip");
					}
					if(sessionStorage.getItem("time")!=null && sessionStorage.getItem("time")!=""){
						sessionStorage.removeItem("time");
					}
					window.location.href = "login.html";
				}
			}
		});
		
	},function(){
		layer.closeAll();
	});
}

//根据权限创建左边的菜单
function createMenuByFuns1(){
	//var userType = "1"//sessionStorage.getItem("_user_type");
	
	
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
		
		if(funMap.get("parent2")!=null){
			if(funMap.get("record/event_record.html")!=null){
				//menu += '<li><a href="sys/user/manage_yonghu_modPass.html" id="m1" class="m1 dq" target="iframepage">用户管理</a></li>';
				$("#eventFun").append('<a href="event/record/event_record.html" target="iframepage11">事件接录</a>');
			}
			if(funMap.get("handle/event_handle.html")!=null){
				//menu += '<li><a href="sys/role/manage_juese.html" class="m2" id="m2" target="iframepage">角色管理</a></li>';
				$("#eventFun").append('<a href="event/handle/event_handle.html" target="iframepage11">事件处理</a>');
			}
			if(funMap.get("appraisal/event_appraisal.html")!=null){
				//menu += '<li><a href="sys/authority/manage_quanxian.html" id="m3" class="m3" target="iframepage">权限管理</a></li>';
				$("#eventFun").append('<a href="event/appraisal/event_appraisal.html" target="iframepage11">事件评价</a>');
			}
			if(funMap.get("accounting/event_accounting.html")!=null){
				//menu += '<li><a href="sys/log/manage_rizhi.html" class="m4" id="m4" target="iframepage">日志管理</a></li>';
				$("#eventFun").append('<a href="event/accounting/event_accounting.html" target="iframepage11">工作台账</a>');
			}
			if(funMap.get("accepted/event_accepted.html")!=null){
				//menu += '<li><a href="sys/group/manage_bumen.html" class="m5" id="m5" target="iframepage">部门管理</a></li>';
				$("#eventFun").append('<a href="event/accepted/event_accepted.html" target="iframepage11">部门受理</a>');
			}
			
		}
		
	
		
	
	
}


function bindValidate(_id){
	tt.vf.req.add("oldPassword","newPassword","reNewPassword");
	new tt.LV().set(6, 16).add("newPassword","reNewPassword");
	var pwd = new tt.Field("密码", "newPassword"); 
	var owd = new tt.Field("原密码", "oldPassword"); 
	new tt.CV().add(new tt.Field('新密码',"newPassword")).set('v', '!=', owd).setI18('新密码与原密码相同，请重新填写新密码');
	new tt.CV().add(new tt.Field('确认密码',"reNewPassword")).set('v', '==', pwd).setI18('两次密码输入不一致！');
	new tt.RV().set(new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"),"6-16位字母数字混合（区分大小写）").add("newPassword","reNewPassword");
}
function save(e){
	//$("#saveBtn").unbind("click");
	var flag = tt.validate(); 
	if(!flag){
		//$("#saveBtn").bind("click",save);
		return;
	}
	var ip = sessionStorage.getItem("ip");
	var time = sessionStorage.getItem("time");
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	var oldPassword = $("#oldPassword").val();
	var newPassword = $("#newPassword").val();
	var reNewPassword = $("#reNewPassword").val();
	var loginName = sessionStorage.getItem("_user_name");
	$.ajax({
		url : $.ServiceHttp()+'platform/social/sys/socialSysUser/changepassword',
		data : {
			"opw" :	oldPassword,
			"npw" : newPassword,
			"ip":ip,
			"time":time,
			"token": token,
			"timestamp": timestamp,
			"socialSysUser.loginName": loginName
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			if(data.success==false){//返回结果为密码不正确
				//$("#oldPwWarning").append("旧密码输入错误！");
				//closePop('closeBtn');
				layer.msg("原密码输入错误");
				//closePop(e);
				//$("#saveBtn").bind("click",save);
				return;
			}
			else{
				//closePop('closeBtn');
				//layer.msg("密码修改成功");
				layer.msg('密码修改成功', {
					  time: 0 //不自动关闭
					  ,btn: ['确认']
					  ,yes: function(index){
						  closePop(e);
							deleteCookie("userName","/");
			            	deleteCookie("password","/");
							//$("#saveBtn").bind("click",save);
							window.location.href = "login.html";
					  }
					});
				//按钮
				
			}
		}
	});
}

function reset(){
	$("#oldPassword").val("");
	$("#newPassword").val("");
	$("#reNewPassword").val("");
}

function newPop(){
	//tt.vf.req.init("oldPassword","newPassword","reNewPassword");
	$(".talentTipMsg").each(function(){
		$(this).remove();
	});
	$(".talentErrMsg").each(function(){
		$(this).remove();
	});
	
	$("#oldPassword").val("");
	$("#newPassword").val("");
	$("#reNewPassword").val("");
	$("#newPassword").attr("class","formInput5 warningInput");
	$("#reNewPassword").attr("class","formInput5 warningInput");
	showPop('passPopBox');
}

function deleteCookie(name,path){  
    var name = escape(name);  
    var expires = new Date(0);  
    path = path == "" ? "" : ";path=" + path;  
    document.cookie = name + "="+ ";expires=" + expires.toUTCString() + path;  
}
 