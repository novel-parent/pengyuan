$(function(){
	
	
	//加载工厂列表
	
	$.ajax({
		url:'getFactoryList.b',
		type:'post',
		data:'',
		success: function(data){
			var html='';
			html+='<option value="-1">请选择楼层</option>';
			
			$("#fid").append(html);
			
			
			$("#factory").append(html);
			
			
			for(var i=0;i<data.length;i++){
				var html='';
				
				html+='<option value="'+data[i].fid+'">'+data[i].factoryName+'</option>';
				
				$("#fid").append(html);
				
				
				$("#factory").append(html);
			}
		}
	})
})
	
			//加载编辑用户信息列表
			function edit(obj){
				$.ajax({
					url:'getUserInfo.b',
					type:'post',
					data: 'uid='+obj,
					success: function(data){
						
						$("input[name = 'uid']").val(obj);
						$("#name").val(data.userName);
						$("#tel").val(data.tel);
						$("#fid").val(data.factory.fid);
						$("#flag").val(data.flag);
						$("#myModal").modal('show');
					}
				})
			}



//token
$.ajax({
	url:'getToken.b',
	data:'',
	type:'post',
	success: function(data){
		$("input[name^='token']").val(data);
	}
})

//获取token信息
function getToken(){
	$.ajax({
		url:'getToken.b',
		data:'',
		type:'post',
		success: function(data){
			$("input[name^='token']").val(data);
		}
	})
}

function checkName(obj){
	
	if($("#name").val() ==  ''){
		alert("请输入姓名");			
	}
	
}

function checkTel(obj){
	
	var partten11 = /^\d{11}$/;
	var partten7 = /^\d{7}$/;
	
	var len = obj.length;
	
	if(len <=  7){
		
		if(!partten7.test(obj)){
			alert("此电话号码不为7位数字，请检查");
			return;
		}
		
	}else if(len <= 11){
		if(!partten11.test(obj)){
			alert("此电话号码不为11位数字，请检查");
			return;
		}
	}
	
}

//当前页
var currentPage = 1;
//总页数·
var totalPage = 0;

//查询员工
function searchUser(type){
	var name = $('input[name="name"]').val();
	var tel = $('input[name="tel"]').val();
	var fid = $('#factory').val();
	var flag = $('#userStatus').val();
	
	
		var data = {};
		
		if(name != null && name != ''){
			data.userName=name;
		}
		
		if(tel != '' && tel != null){
			data.tel=tel;
		}
		
		if(fid != '' && fid != null){
			data.fid=fid;
		}
		
		if(flag != null && flag != ''){
			data.flag = flag;
		}
		
		
		//当前页数
		data.pageNum=currentPage;
		
		
		$.ajax({
			url:'searchUser.b',
			type:'post',
			data:data,
			success: function(data){
				if(data.code == -1){
					if(type != 1){
						alert(data.msg);
					}
				}else if(data.code == 1){
					
					//清空之前的元素
					$("#usertable").empty();
					$("#pageLine").empty();
					
					//获取当前页
					currentPage=data.currentPage;
					//获取总页数
					totalPage=data.totalPage;
					
					var head='';
					head+='<tr>';
					head+='<th width="10%" >姓名</th>';
					head+='<th width="20%" >电话</th>';
					head+='<th width="15%" >所属工厂</th>';
					head+='<th width="20%" >在职状态</th>';
					head+='<th width="20%" >操作</th>';
					head+='</tr>';
					
					$("#usertable").append(head);
					
						
					for(var i=0;i<data.obj.length;i++){
						
						var listId = new Date().getTime();
						
						var user = data.obj[i];
						
						console.log(user);
						
						var flag='在职';
						
						if(user.flag == 0 ){
							flag='离职';
						}
						
						if(user.factory == null){
							continue;
						}

						var html='';
						html+='<tr id=user_'+listId+'>';
						html+='<td>'+user.userName+'</td>';
						html+='<td>'+user.tel+'</td>';
						html+='<td >'+user.factory.factoryName+'</td>';
						html+='<td >'+flag+'</td>';
						html+='<td >';
						html+='<div class="button-group">';
						html+='<a class="button border-main" name="edi" onclick="edit('+user.uid+')"> <span class="icon-edit"></span> 修改</a>';
						html+=' <a class="button border-red" href="javascript:void(0)" onclick="del('+user.uid+','+listId+')">';
						html+='<span class="icon-trash-o"></span> 删除</a>';
						html+='</div>';
						html+='</td>';
						html+='</tr>';
						
						$("#usertable").append(html);
						
					}	
					
					
					
					var tool='';
					tool+='<li><a onclick="firstPage()">首页</a></li>';
					tool+='<li><a onclick="prePage()">上一页</a></li>';
					tool+='<li><a>'+data.currentPage+'</a></li>'
					tool+='<li><a onclick="nextPage()">下一页</a></li>';
					tool+='<li><a onclick="lastPage()">尾页</a></li>';
					tool+='<li><a >共'+data.totalPage+'页</a></li>'
					
					$("#pageLine").append(tool);
					
				}
			}
		})
		
	
}
	//上一页
	function prePage(){
		if((currentPage-1)<=0){
			alert('当前已经是第一页');
			return;
		}else{
			currentPage--;
			searchUser();
		}
	}
	
	//下一页
	function nextPage(){
		if((currentPage+1)>totalPage){
			alert('当前已经是最后一页');
			return;
		}else{
			currentPage++;
			searchUser();
		}
	}

	//	首页
	function firstPage(){
		if((currentPage-1)<=0){
			alert("当前已是第一页");
			return;
		}else{
			currentPage=1;
			searchUser();
		}
	}
	//	尾页
	function lastPage(){
		if((currentPage+1)>totalPage){
			alert("当前已经是最后一页");
			return;
		}else{
			currentPage=totalPage;
			searchUser();
		}
	}

//删除用户
	function del(uid,trId) {
		
		if (confirm("您确定要删除该员工吗?")) {
			
			var name = $('input[name="name"]').val();
			var tel = $('input[name="tel"]').val();
			var fid = $('#factory').val();
			var flag = $('#userStatus').val();
			
			$.ajax({
				url:'deleteUser.b/'+currentPage,
				type:'post',
				data:'uid='+uid,
				success: function(data){
					//code返回的是删除前的页码
					if(data.code > 0){
						
						currentPage = data.code;
						
						//使用删除前的页码再进行搜索
						searchUser();
						
						alert(data.msg);
					}else if(data.code == -1){
						alert(data.msg);
					}
				}
			})
		}
	}
	
	
	
	//更新或新增用户信息
	$("#savebtn").on('click',function(){
		
		var data;
		//判断电话是否为11位数字
		var partten11 = /^\d{11}$/;
		//判断电话是否为7位数字
		var partten7 = /^\d{7}$/;
		
		var len = $("#tel").val().length;
		
		//判断姓名是否为空
		if($("#name").val() == ''){
			alert("姓名不能为空");
			return;
		}
		
		//判断电话号码格式是否正确
		if(len <=  7){
			
			if(!partten7.test($("#tel").val())){
				if(!confirm("此电话号码格式不正确！确认提交吗？")){
					return;
				}
			}
			
		}else if(len <= 11){
			if(!partten11.test($("#tel").val())){
				if(!confirm("此电话号码格式不正确！确认提交吗？")){
					return;
				}
			}
		}
		
		
		//判断是否选择了工厂
		if($("#fid").val() == -1){
			alert('该员工还没有选择所属工厂！');
			return;
		}
		
		
		
		
		if($("input[name = 'uid']").val() == 0){
			data = {
					userName:$("#name").val().trim(),
					tel:$("#tel").val().trim(),
					fid:$("#fid").val().trim(),
					flag:$("#flag").val().trim(),
					token:$("input[name^='token']").val().trim()
				}
		}else{
			data = {
					uid:$("input[name = 'uid']").val().trim(),
					userName:$("#name").val().trim(),
					tel:$("#tel").val().trim(),
					fid:$("#fid").val().trim(),
					flag:$("#flag").val().trim()
				}
		}
		
		
			$.ajax({
				url:'updateUser.b/'+currentPage,
				type:'post',
				data:data,
				success: function(data){
					if(data.code > 0){
						
						currentPage = data.code;
						
						searchUser(1);
						
						alert(data.msg);
						
					}else if(data == -1){
						alert('请求失败');
						getToken();
					}
				}
			})
	})
	
	//点击新增用户按钮加载模态框的数据
	function addUserBtn(){
		
		$("input[name = 'uid']").val("0");
		$("#name").val('');
		$("#tel").val('');
		$("#fid").val('-1');
		$("#flag").val('1');
		
		$("#myModal").modal('show');
	}
	
