$(document).ready(function(){
	list();
	listTree();
	 
	$("#queryBtn").bind("click",query);
	$("#addXingZhengQuHua").bind("click",save);
	$("#clearAll").bind("click",clearall);
	
	//queryNet(0,"netId");
	bindValidate();
	
	var page_h = $(window).height();
	changeTreeH (page_h);
});
$(window).bind('scroll resize', function(e){
	var page_h = $(window).height();
	changeTreeH (page_h);
	});

	function changeTreeH (page_h) {
		var treeH = page_h - 230;
		var treeMainH = page_h - 156;
	   $(".treeMain").css("min-height",treeMainH+"px");
		var treePageH=$(".treeMain").height()-61;
	   $(".treeCon").css("min-height",treeH+"px");
	   $(".treeCon").css("height",treePageH+"px");
		}	

function bindValidate(_id){
	tt.vf.req.add("areaName");
	new tt.RV().set(new RegExp("[\u4e00-\u9fa5]"),"请输入中文").add("areaName");
}

function clearall(){
	$(".talentTipMsg").each(function(){
		$(this).remove();
	});
	$(".talentErrMsg").each(function(){
		$(this).remove();
	});
	$("#xingzhengPopBox").find(":input[type='text']").each(function(){
		if($(this).attr("readonly")!="readonly"){
			$(this).val("");
			$(this).removeClass("talentErrInput");
			$(this).removeClass("talentSucInput");
		}
	});
	$("#xingZhengQuHua").val("");
	//$("#shangYiJi").val("");
}
//用于在页面列表加载之后的按钮绑定处理
function listBind(){
	$("span[name=modifyBtn]").each(function(){
		  $(this).bind("click",$(this).attr("val"),modify);
	});
	$("span[name=delBtn]").each(function(){
		  $(this).bind("click",$(this).attr("val"),del);
	});
}

//修改
function modify(e){
	clearall();
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	//alert(e.data);
	$.ajax({
		url :  $.ServiceHttp()+'platform/social/sys/socialArea/view',
		data : {
			"id": e.data,
			"token": token,
			"timestamp": timestamp
			},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			$("#areaId").val(data.retObj.id);
			$("#quHuaId").val(data.retObj.code); 
			$("#xingZhengQuHua").val(data.retObj.name); 
			/*$("#parentId option").each(function(){
				if($(this).val()==data.retObj.id){
					$(this).remove();
				}
				if($(this).val()==data.retObj.parentId){
					$(this).attr("selected",true);
				}
			});*/
			$("#parentName").val(data.retObj.parentName);
			$("#parentId").val(data.retObj.parentId);
			$("#infer").val("1");
		}
	});
	$("#title").text("修改");
	showPop('xingzhengPopBox');
}

//删除数据
function del(e){
	var loginName = sessionStorage.getItem("_user_name");
	var time = sessionStorage.getItem("time");
	var ip = sessionStorage.getItem("ip");
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	var tips = "确认删除吗？";
	layer.confirm(tips, {
		btn : [ '确认', '取消' ]
	//按钮
	}, function() {
		$.ajax({
			url :  $.ServiceHttp()+'platform/social/sys/socialArea/delete',
			data : {
				"socialArea.id": e.data,
				"curent":loginName,
				"ip":ip,
				"time":time,
				"token": token,
				"timestamp": timestamp
			},
			type : 'post',
			cache : false,
			dataType : 'json',
			error : function(err) {
				console.log("error:"+ JSON.stringify(err));
			},
			success : function(data) {
				if(data!=null && data!="" && data.success == true){
					layer.msg("删除成功！",{
						  //icon: 1,
						  time: 1000 
						}, function(){
							location.href = "manage_xingzhengquhua.html";
					});
				}else{
					layer.msg("删除失败！");
				}
			}
		}, function() {
			layer.closeAll(); 
		});
	});
	
	
	
}


 
//默认列表
function list(){
	var pageNo = 1;
	var pageSize = 10;
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	var data = {
			"pageNo": pageNo,							
			"pageSize": pageSize,
			"token": token,
			"timestamp": timestamp
			//"socialSysUser.delFlag":"0"
			};
	$.ajax({
		url :  $.ServiceHttp()+'platform/social/sys/socialArea/list',
		data : data,
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			var template = Duster.buildArr($("#dust_list"));
			$("#parentId").append("<option value='0'></option>");
			if(data!=null && data!="" &&  data.success == true){
				data.retObj.list.forEach(function(element, index) {
					$("#parentId").append("<option value="+element.id+">"+element.name+"</option>");
				});
			}
			$("#data_list").html(template(data.retObj.list));
			$("#page").html(data.retObj.html);
			//$("#hideid0").hide();
			listBind();
		}
	});
}


//function buQuanShuJu(list,ob){
//	if(list.length()<5){
//		var tempLength=5-list.length();
//		for(var i=0;i<tempLength;i++){
//			list.push(ob);
//		}
//	}
//	return list;
//}

function zTreeOnClick(event, treeId, treeNode) {  
	list(treeNode.tId);
};
//点击节点触发
function list2(event, treeId, treeNode){
	var pageNo = $("#pageNo").val();
	var pageSize = $("#pageSize").val();
	$("#hidetreename").val(treeNode.name);
	$("#hidetreeid").val(treeNode.id);
	$("#hidetreelevel").val(treeNode.level);
	//alert(treeNode.level);
	//var bianma = $("#bianma").val();
	var pid = treeNode.id;
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	//alert(pid);
	$.ajax({
		url :  $.ServiceHttp()+'platform/social/sys/socialArea/list',
		data : {
			"pageNo":pageNo,
			"pageSize": pageSize,
			"socialArea.id": pid,
			"token": token,
			"timestamp": timestamp
			},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			var template = Duster.buildArr($("#dust_list"));
			$("#data_list").html(template(data.retObj.list));
			$("#page").html(data.retObj.html);
			$("#savepid").val(pid);
			//$("#hideid0").hide();
			listBind();
		}
	});
	//alert(treeNode.tId + ", " + treeNode.name+","+treeNode.id);
}
 
function listTree(){
	var setting = {
		view: {
			showLine: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback:{
			onClick : list2
		}
	};
	
	var zNodes = [];
			
	var code;
	
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	$.ajax({
		url : $.ServiceHttp()+'platform/social/sys/socialArea/list',
		data : {
			"pageNo": 1,
			"pageSize": 200,
			"token": token,
			"timestamp": timestamp
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			//alert(JSON.stringify(data));
			if(data!=null && data!="" &&  data.success == true){
				//遍历所有权限
				for ( var i = 0; i < data.retObj.list.length; i++) {
					//zNodes[i].id=data.retObj.list[i].id;
					//zNodes[i].pId=data.retObj.list[i].parentId;
					//zNodes[i].name=""+data.retObj.list[i].name+"";
					var item = {id:data.retObj.list[i].id,pId:data.retObj.list[i].parentId,name:""+data.retObj.list[i].name+""};
					zNodes.push(item);
					
				}
			}
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}
	});
}
 
 

//查询列表
function query(){
	var pageNo = $("#pageNo").val();
	var pageSize = $("#pageSize").val();
	var bianma = $("#bianma").val();
	var pid = $("#savepid").val();
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	$.ajax({
		url :  $.ServiceHttp()+'platform/social/sys/socialArea/list',
		data : {
			"pageNo":pageNo,
			"pageSize": pageSize,
			"socialArea.code": bianma,
			"socialArea.id": pid,
			"token": token,
			"timestamp": timestamp
			},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			var template = Duster.buildArr($("#dust_list"));
			$("#data_list").html(template(data.retObj.list));
			$("#page").html(data.retObj.html);
			//$("#hideid0").hide();
			listBind();
		}
	});
	
}
 

//新增行政区划
function save(){
	var loginName = sessionStorage.getItem("_user_name");
	var time = sessionStorage.getItem("time");
	var ip = sessionStorage.getItem("ip");
	var status = true;
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	var pid = $("#parentId").val();
	var data = {
			"socialArea.id":$("#areaId").val(),
			"socialArea.code": $("#quHuaId").val(),
			"socialArea.name": $("#xingZhengQuHua").val(),
			"socialArea.parentId": pid,
			//"socialArea.isNewRecord" :status,
			"status":status,
			"curent":loginName,
			"ip":ip,
			"time":time,
			"token": token,
			"timestamp": timestamp
		};
	if($("#infer").val()!=""&&$("#infer").val()!=null){
		status = false;
		var data = {
				"socialArea.id":$("#areaId").val(),
				"socialArea.code": $("#quHuaId").val(),
				"socialArea.name": $("#xingZhengQuHua").val(),
				"socialArea.parentId": $("#parentId").val(),
				//"socialArea.isNewRecord" :status,
				"status":status,
				"curent":loginName,
				"ip":ip,
				"time":time,
				"token": token,
				"timestamp": timestamp
			};
	}
	$("#saveBtn").unbind("click");
	var flag = tt.validate(); 
	if(!flag){
		$("#saveBtn").bind("click",save);
		return;
	}
	
	$.ajax({
		url : $.ServiceHttp()+'platform/social/sys/socialArea/save',
		data : data,
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			$("#saveBtn").bind("click",save);
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			if(data!=null && data!="" &&  data.success == true){
				layer.msg('保存成功', {
					  //icon: 1,
					  time: 1000 
					},function(){
					location.href = "manage_xingzhengquhua.html";
				});
			}else if(data!=null && data!="" &&  data.success == false){
				layer.msg(data.msg, {
					  //icon: 2,
					  time: 2000 
					});
			}else {
				layer.msg('保存异常，请稍后重试。');
			}
			$("#saveBtn").bind("click",save);
		}
	});
	
}

//分页
function page(n,s){
	$("#pageNo").val(n);
	$("#pageSize").val(s);
	query();
}

function newPop(){
	clearall();
	if($("#hidetreename").val()==""||$("#hidetreename").val()==null){
		layer.msg('请选择具体节点');
		return;
	}
	var id= $("#hidetreelevel").val();
	$("#parentName").val($("#hidetreename").val());
	$("#parentId").val($("#hidetreeid").val());
	if(id==3){
		layer.msg('该节点下无法增加');
		return;
	}
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	//alert(e.data);
	$.ajax({
		url :  $.ServiceHttp()+'platform/social/sys/socialArea/auto',
		data : {
			"token": token,
			"timestamp": timestamp
			},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			$("#quHuaId").val(data.retObj.code);
			$("#areaId").val(data.retObj.id);
			
		}
	});
	$("#title").text("新增");
	showPop('xingzhengPopBox');
}

function ccc(obj){
	if($("#areaId").val()==""||$("#areaId").val()==null){
		var key = sessionStorage.getItem("key");
		var timestamp = new Date().getTime();
		var token =$.md5(timestamp+key.toUpperCase());
		var data = {
			"socialArea.code": $("#quHuaId").val(),
			"token": token,
			"timestamp": timestamp
		};
		$("#saveBtn").unbind("click");
		$.ajax({
			url : $.ServiceHttp()+'platform/social/sys/socialArea/delete',
			data : data,
			type : 'post',
			cache : false,
			dataType : 'json',
			error : function(err) {
				$("#saveBtn").bind("click",save);
				console.log("error:"+ JSON.stringify(err));
			},
			success : function(data) {
				console.log("data:"+ JSON.stringify(data));
				
				$("#saveBtn").bind("click",save);
			}
		});
	}
	closePop(obj);
	//location.href = "manage_xingzhengquhua.html";
}
 