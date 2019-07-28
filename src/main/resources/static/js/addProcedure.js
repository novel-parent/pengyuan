$(function(){
		//获取名字为AAA的模板信息，并加载到页面上
		
		var ProcedureName='AAA';
		
		$.ajax({
			url:'getProcedureInfo.b',
			type:'post',
			data:'baseModel='+ProcedureName,
			success: function(data){
				if(data.code == -1){
					alert(data.msg);
				}else if(data.code == 1){
					
					var dataString = data.obj.main;
					
					var dataArr = parseJsonString(dataString);
					
					console.log(dataString);
					
					var trName=new Date().getTime();
					
					//遍历工序模板信息
					for(let i=0;i<dataArr.length;i++){
						
						trName = trName +1;
						
						var html = '';
						let name = dataArr[i].split(",")[0].split(":")[1];
						let price = dataArr[i].split(",")[1].split(":")[1];
						let num1 = dataArr[i].split(",")[2].split(":")[1];
						let uname1 = dataArr[i].split(",")[3].split(":")[1];
						let account1 = dataArr[i].split(",")[4].split(":")[1];
						
						html+="<tr id='title_"+trName+"'>";
						html+="<td>"+name+"</td>";
						html+="<td>"+price+"</td>";
						html+="<td>"+num1+"</td>";
						html+="<td>"+uname1+"</td>";
						html+="<td>"+account1+"</td>";
						
						html+="<td>";
						html+="<div class='button-group'>";
						html+="<a class='button border-main' href='javascript:void(0)' onclick='addProcedure("+trName+")'><span class='icon-edit'></span>添加</a>";
						html+="<a class='button border-main' href='javascript:void(0)' onclick='edit("+trName+")'> <span class='icon-edit'></span> 修改</a>";
						html+="<a class='button border-red' href='javascript:void(0)' onclick='del("+trName+")'> <span class='icon-trash-o'></span>删除</a>";
						html+="</div>";
						html+="</td>";
						html+="</tr>";
						
						
						$("#procedureInfo").append(html);
					}
					
					var html = '';
					html+='<tr id="titleSave">';
					html+='<td colspan="15">';
					html+='<div class="pagelist">';
					html+='<div onclick="file.click()">';
					html+='<img src="images/timg.jfif" name="fileimg" style="width: 120px; height: 120px; left: 60px;" class="img-responsive" " alt="Cinque Terre" width="304" height="236">';
					html+='<div style="float: left;">';
					html+='<span>上传图片</span>';
					html+='</div>';
					html+='<input type="file" onchange="changeImg(this)" style="display: none" id="file">';
					html+='</div>';
					html+='<div class="button-group">';
					html+='<a class="button border-main" href="javascript:void(0)" onclick="saveProcedureInfo()" style="background-color: blue; color: white; width: 120px; text-decoration: none;"> 保存 </a>';
					html+='</div>';
					html+='</div>';
					html+='</td>';
					html+='</tr>';
					
					$("#procedureInfo").append(html);
					 
				}
				
			}
		})
		
	})
	
	
	 getToken();

	
	//获取票据
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
	
	
	
	//解析Json数组
	function parseJsonString(dataString){
		
		let m = indexOf(dataString,'[');
		let n = indexOf(dataString,']');
		
		var dataStr=dataString.substring(m+1,n);
		
		var tmpArr=dataStr.split('}');
		
		var dataArr = new Array();
		
		for(let j=0;j<tmpArr.length-1;j++){
			
			let tmpStr = tmpArr[j].split('{');
			
			dataArr[j-1] = tmpStr[1];
			
		}
		
		return dataArr;
	}
	
	//获取某一字符在字符串里面的位置
	function indexOf(str,value){
		var tmp = str.split('');
		for(var i=0;i<tmp.length;i++){
			if(tmp[i] == value){
				return i;
			}
		}
	}
	
	

	function checkName(obj){
		var procedureName = obj.value;
		
		$.ajax({
			url:'checkProcedureName.b',
			data:'name='+procedureName,
			type:'post',
			success: function(data){
				if(data.code < 0){
					if(confirm('与先前的商品名称重名,确认使用此名字吗？')){
						
					}else{
						$("input[name = 'name']").val('');
					}
				}
			}
		})
	}
	
	//删除工序信息
	function del(obj){
		
		if(confirm('确定删除该工序吗？')){
			$('#title_'+obj).remove();
			
			alert('删除成功');
		} 
		
	}
	

	//保存模板信息，上传到数据库
	function saveProcedureInfo() {
		
		var name=$("input[name='name']").val();
		var remark=$("input[name='remark']").val();
		var fd=new FormData();
		
	
		
		if(name == ''){
			alert('请输入模板名称');
			return;
		}
		
		if(remark == ''){
			alert('请输入备注');
			return;
		}
		
		
		var trList = $("tr[id ^= 'title']");

		var arr = "[{name:工序名,price:单价,num1:数量,uname1:姓名,account1:合计}";

		for (var i = 1; i < trList.size() - 1; i++) {

			var tdList = trList.eq(i).children();

			arr += ",{name:" + tdList.eq(0).html() + ",price:"
					+ tdList.eq(1).html() +",num1:"+tdList.eq(2).html()+",uname1:"+tdList.eq(3).html()+",account1:"+tdList.eq(4).html() +"}"
					

		}
		

		arr += "]";
		
		
		if($("#file")[0].files[0] == null){
			if(!confirm('你还没有选择图片确认要保存该模板吗？')){
				return ;
			}
		}
		
		
		fd.append('pName',name);
		fd.append('remarks',remark);
		fd.append('main',arr);
		fd.append('file',$("#file")[0].files[0]);
		fd.append('token',$("input[name = 'token']").val());
		
		$.ajax({
			url : 'SaveProcedureString.b',
			type : 'post',
			data : fd,
			processData: false,
			contentType: false,
			success : function(data) {
				if(data.code == 1){
					alert(data.msg);
					window.location.reload();
				}
			}
		})
		
	}
	
	
	//新增工序之前的相关操作
	function addProcedure(obj) {
		
		$("#myModal").modal('show');
		$("input[name = 'trid']").val('title_'+obj);
		
	}

	//新增工序的保存方法
	function save() {
		
		let trName = new Date().getTime();
		
		let name = $("input[name = 'procedureName']").val();
		
		let price = $("input[name = 'procedurePrice']").val();
		
		let objName = $("input[name = 'trid']").val();
		
		if(name  == ''){
			alert('工序名不能为空');
			return;
		}
		
		if(price == ''){
			alert('价格不能为空');
			return;
		}
		
		var reg = new RegExp("^[0-9]+$");
		
		if(!reg.test(price)){
			alert('单价不为数字');
			return;
		}
		
		
		let trObj = $("#"+objName);
		
		let html = '';
		
		html+="<tr id='title_"+trName+"'>";
		html+="<td>"+name+"</td>";
		html+="<td>"+price+"</td>";
		html+="<td></td>";
		html+="<td></td>";
		html+="<td></td>";

		html+="<td>";
		html+="<div class='button-group'>";
		html+="<a class='button border-main' href='javascript:void(0)' onclick='addProcedure("+trName+")'><span class='icon-edit'></span>添加</a>";
		html+="<a class='button border-main' href='javascript:void(0)' onclick='edit("+trName+")'> <span class='icon-edit'></span> 修改</a>";
		html+="<a class='button border-red' href='javascript:void(0)' onclick='del("+trName+")'> <span class='icon-trash-o'></span>删除</a>";
		html+="</div>";
		html+="</td>";
		html+="</tr>";
		
		trObj.after(html);
		
		alert('添加成功');
		
		$("input[name = 'trid']").val('');
		
	}
	
	//编辑工序信息之前的相关操作
	function edit(obj){
		
		var objId = '#title_'+obj;
		
		var trList = $(objId).children();
		
		$("input[name = 'edittrid']").val(objId);
		
		$("input[name = 'afterEditProcedureName']").val(trList.eq(0).html());
		
		$("input[name = 'afterEditProcedurePrice']").val(trList.eq(1).html());
		
		$("#editModal").modal('show');
	}
	
	//保存工序信息
	function saveEdit(){
		
		var objId = $("input[name = 'edittrid']").val();
		
		var name = $("input[name = 'afterEditProcedureName']").val();
		var price = $("input[name = 'afterEditProcedurePrice']").val();
		
		
		var trList = $(objId).children();
		
		trList.eq(0).html(name);
		trList.eq(1).html(price);
		
		alert('修改成功');
		
		$("#editModal").modal('hide');
		
	}
	
	
	//隐藏模态框
	function cancel() {
		$("#myModal").modal('hide');
	}
	
	//	将用户上传的图片显示在页面上
	function changeImg(obj) {

		var url = getObjectURL(obj);

		$("img[name='fileimg']").attr('src', url);
	}

	//获取文件真实路径
	function getObjectURL(file) {
		var url = null;
		var fileObj = file.files[0];
		if (window.createObjcectURL != undefined) {
			url = window.createOjcectURL(fileObj);
		} else if (window.URL != undefined) {
			url = window.URL.createObjectURL(fileObj);
		} else if (window.webkitURL != undefined) {
			url = window.webkitURL.createObjectURL(fileObj);
		}
		return url;
	}