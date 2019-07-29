	$(function(){
		//获取名字为AAA的模板信息，并加载到页面上
		
		var searchStr = window.location.search;
		
		var rowData = searchStr.split('?')[1];
		
		var rowpid = rowData.split('&')[0];
		
		var pid = rowpid.split('=')[1];
		
		
		$.ajax({
			url:'addDataForProcedure.b',
			type:'post',
			data:'pid='+pid,
			success: function(data){
				if(data.code == -1){
					alert(data.msg);
				}else if(data.code == 1){
					
					var dataString = data.obj.main;
					
					var dataArr = parseJsonString(dataString);
					
					$("input[name = 'name']").val(data.obj.pName);
					
					$("input[name = 'remark']").val(data.obj.remarks);
					
					var trName=new Date().getTime();
					
					//遍历工序模板信息
					for(let i=0;i<dataArr.length;i++){
						
						var html = '';
						let name = dataArr[i].split(",")[0].split(":")[1];
						let price = dataArr[i].split(",")[1].split(":")[1];
						let num1 = dataArr[i].split(",")[2].split(":")[1];
						let uname1 = dataArr[i].split(",")[3].split(":")[1];
						let account1 = dataArr[i].split(",")[4].split(":")[1];
						
						
						trName = trName + 1;
						
						html+="<tr id='title_"+trName+"'>";
						html+="<td>"+name+"</td>";
						html+="<td>"+price+"</td>";
						html+="<td>"+num1+"</td>";
						html+="<td>"+uname1+"</td>";
						html+="<td>"+account1+"</td>";
						html+="<td>";
						html+="<div class='button-group'>";
						html+="<a class='button border-main' href='javascript:void(0)' onclick='addProcedure("+trName+")'><span class='icon-edit'></span>填写数据</a>";
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
					html+='<img src="'+data.obj.path+'" name="fileimg" style="width: 120px; height: 120px; left: 60px;" class="img-responsive" " alt="该商品未添加图片" width="304" height="236">';
					html+='<div style="float: left;">';
					html+='</div>';
					html+='<input type="hidden" name="pid" value="'+data.obj.pid+'">';
					html+='<input type="hidden" name="lastTrId" value="title_'+trName+'">';
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
	
	
	
	
	
	
	
	
	
	//下一工序
	function nextProcedure(){
		var trid = $("input[name = 'trid']").val();
		
		var lastTrid = $("input[name='lastTrId']").val();
		
		if(trid == lastTrid){
			alert('当前已经是最后一个工序');
			return;
		}
		
		var username = $("#username").val();
		var account = $("#account").val();
		var number = $("#number").val();
		
		
		if(username == '' || account == '' || number == ''){
			
			alert('请先填写当前工序信息');
			return;
		}
		
		
		if(username != '' && account != '' && number != ''){
			
			//保存上一工序的信息
			saveAddModalValue(trid);
			
		}
		
		
		
		
		trid = 'title_'+getNextTrId(trid);
		
		
		//获取下一个 工序 <tr>的id
	
		loadDataIntoModal(trid);
		
	}
	
	//根据当前tr的id获取下一个tr的id
	function getNextTrId(trid){
		
		var trnum= trid.substring(6,trid.length);

		trnum = parseInt(trnum);
		
		trnum = trnum + 1;
		
		return trnum;
	}
	
	// 保存（id=myModal）模态框的值
	function saveAddModalValue(trid){
		var number = $("#number").val().trim();
		var username = $("#username").val().trim();
		var account = $("#account").val().trim();
		var pid = $("input[name = 'pid']").val().trim();
		var price = $("#proceduresPrice").val().trim();
		var procedureNode = $("#proceduresName").val();
		var token = $("input[name = 'token']").val();
		
		var reg = new RegExp("^[0-9]*$");
		
		
		if(number == ''){
			alert('数量不能为空');
			return;
		}else if(!reg.test(number)){
			alert('请输入数字');
			return;
		}
		
		if(username == ''){
			alert('姓名不能为空');
			return;
		}
		
		
		var dataBaseUid = $("input[name = 'uid']").val();
		
		
		if(dataBaseUid == '-1'){
			alert('该员工不存在');
			return;
		}
		
		price = (Number(price) * 1000).toFixed(0);
		
		var data = {};
		
		data.number = number;
		data.uid = dataBaseUid;
		data.price = price;
		data.pid = pid;
		data.procedureNode = procedureNode;
		data.token = token;
		
		//上传数据至数据库
		$.ajax({
			url:'putIntoWage.b',
			type:'post',
			data: data,
			success: function(data){
				
				if(data.code == 1){
					var html = '';
					
					var trName = new Date().getTime();
					
					price = (Number(price) / 1000).toFixed(3);
						
					html+="<tr id='title_"+trName+"'>";
					html+="<td ><input type='hidden' name='hidename' value='"+procedureNode+"'</td>";
					html+="<td ><input type='hidden' name='hideprice' value='"+price+"'</td>";
					html+="<td>"+number+"</td>";
					html+="<td>"+username+"</td>";
					html+="<td>"+account+"</td>";
					html+="<td>";
					html+="<div class='button-group'>";
					html+="<a class='button border-main' href='javascript:void(0)' onclick='editProcedure("+trName+","+data.obj.wid+")'><span class='icon-edit'></span>修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</a>";
					html+="<a class='button border-red' href='javascript:void(0)' onclick='del("+trName+","+data.obj.wid+")'> <span class='icon-trash-o'></span>删除</a>";
					html+="</div>";
					html+="</td>";
					html+="</tr>";
					
					$("#"+trid).after(html);
					
					var trnum= trid.substring(6,trid.length);

					trnum = parseInt(trnum);
					
					trnum += 1;
					
					trid = 'title_'+trnum;
					
					
					loadDataIntoModal(trid);
					
					$("input[name = 'trid']").val(trid);
					
					//改变模态框的标题
					changeModalTitle('add',procedureNode);
				}
				if(data.code == -1){
					alert(data.msg);
				}
				getToken();
			}
		
		})
		
	}
	
	
	
	//保存编辑过后的工序信息
	function saveEditProcedure(){
		
		var trid = $("input[name = 'e_trid']").val();
		var wid = $("input[name = 'wid']").val();
		var account = $("#e_account").val();
		
		
		var username = $("#e_username").val();
		var number = $("#e_number").val();
		var uid = $("input[name = 'uid_e']").val();
		var price = $("#e_proceduresPrice").val();
		
		price = Number(price)*1000;
		
		var data = {};
		
		data.number = number;
		data.wid = wid;
		data.uid = uid;
		data.price = price;
		
		$.ajax({
			url:'saveEditProcedure.b',
			type:'post',
			data:data,
			success: function(data){
				if(data.code == 1){
					
					var tdList = $(trid).children();
					
					tdList.eq(2).html(number);
					tdList.eq(3).html(username);
					tdList.eq(4).html(account);
					
					alert('保存成功');
				}
			}
		})
		
	}
	
	//改变模态框的标题
	function changeModalTitle(prefix,content){
		
		var selector = prefix+'ModalTitle';
		
		$('b[name = '+selector+']').html(content);
		
	}
	
	//计算金额
	function getAmmount(num,priceId,accountId){
		//单价
		var price = $("#"+priceId).val();
		
		var reg = new RegExp("^[0-9]*$");
		
		num = parseInt(num);
		
		
		//price转换位为数字类型
		price = Number(price);
		
		//price转换位为数字类型
		num = Number(num);
		
		let account = price*num;
		
		account = account;
		
		//保留小数点后三位小数，即 '离'
		account= Number(account).toFixed(3);
		
		
		
		$("#"+accountId).val(account);
		
		}
	
		//通过userName获取uid
		function getUidByUname(uname,type){
			uname = uname.trim();
			
			$.ajax({
				url:'getUidByUname.b',
				data: 'uname='+uname,
				type: 'post',
				success: function(data){
					if(data.code == 1){
						
						if(type == 'edit'){
							 $("input[name = 'uid_e']").val(data.obj.uid);
						}else{
							 $("input[name = 'uid']").val(data.obj.uid);
						}
						
					}
					if(data.code == -1){
						
						if(type == 'edit'){
							 $("input[name = 'uid_e']").val(data.code);
						}else{
							 $("input[name = 'uid']").val(data.code);
						}
						
					}
				}
			})
		}
	
		//下一员工
		function nextStaff(){
			
			var trid = $("input[name = 'trid']").val();
			
			var number = $("#number").val();
			var username = $("#username").val();
			var account = $("#account").val();
			var pid = $("input[name = 'pid']").val();
			var price = $("#proceduresPrice").val();
			var procedureNode = $("#proceduresName").val();
			var token = $("input[name = 'token']").val();
			
			var reg = new RegExp("^[0-9]*$");
			
			number = parseInt(number);
			
			if(number == ''){
				alert('数量不能为空');
				return;
			}else if(!reg.test(number)){
				alert('请输入数字');
				return;
			}
			
			if(username == ''){
				alert('姓名不能为空');
				return;
			}
			
			
			var dataBaseUid = $("input[name = 'uid']").val();
			
			
			if(dataBaseUid == '-1'){
				alert('该员工不存在');
				return;
			}
			
			price = (Number(price) * 1000).toFixed(0);
			
			var data = {};
			
			
			
			data.number = number;
			data.uid = dataBaseUid;
			data.price = price;
			data.pid = pid;
			data.procedureNode =procedureNode;
			data.token = token;
			data.username = username;
			
			//上传数据至数据库
			
		
		$.ajax({
			url:'putIntoWage.b',
			type:'post',
			data: data,
			success: function(data){
				
				if(data.code == 1){
					var html = '';
					
					var trName = new Date().getTime();
					
					price = Number(price/1000).toFixed(3);
					
					html+="<tr id='title_"+trName+"'>";
					html+="<td ><input type='hidden' name='hidename' value='"+procedureNode+"'</td>";
					html+="<td ><input type='hidden' name='hideprice' value='"+price+"'</td>";
					html+="<td>"+number+"</td>";
					html+="<td>"+username+"</td>";
					html+="<td>"+$("#account").val()+"</td>";
					html+="<td>";
					html+="<div class='button-group'>";
					html+="<a class='button border-main' href='javascript:void(0)' onclick='editProcedure("+trName+","+data.obj.wid+")'><span class='icon-edit'></span>修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</a>";
					html+="<a class='button border-red' href='javascript:void(0)' onclick='del("+trName+","+data.obj.wid+")'> <span class='icon-trash-o'></span>删除</a>";
					html+="</div>";
					html+="</td>";
					html+="</tr>";
					
					$("#"+trid).after(html);
					
					$("#number").val('');
					$("#username").val('');
					$("#account").val('');
					$("input[name = 'pid']").val();
					$("#proceduresPrice").val(price);
					$("#proceduresName").val(procedureNode);
					
					
					
					//改变模态框的标题
					changeModalTitle('add',"添加 : "+procedureNode);
				}
				if(data.code == -1){
					alert(data.msg);
				}
				getToken();
			}
		
		})
		}
		
		
		//编辑员工信息前的模态框赋值操作
		function editProcedure(trName,wid){
			var trid = '#title_'+trName;
			
			$("input[name = 'e_trid']").val(trid);
			
			var tdList = $(trid).children();
			
			var name = tdList.eq(0).children().eq(0).val();
			
			var price = tdList.eq(1).children().eq(0).val();
			
			var number = tdList.eq(2).html();
			
			var uname = tdList.eq(3).html();
			
			var account = tdList.eq(4).html();
			
			price = Number(price).toFixed(3);
			
			$("input[name = 'wid']").val(wid);
			
			$("#e_number").val(number);
			
			$("#e_proceduresName").val(name);
			
			$("#e_proceduresPrice").val(price);
			
			$("#e_username").val(uname);
			
			getUidByUname(uname,'edit');
			
			$("#e_account").val(account);
			
			changeModalTitle('edit',"修改 : "+name);
			
			$('#editModal').modal('show');
			
		}
	
		
		//删除工序信息
		function del(obj,wid){
			
			if(confirm('确定删除该工序吗？')){
				
				$.ajax({
					url:'deleteFromWageNode.b',
					data:'wid='+wid,
					type:'post',
					success:function(data){
						if(data.code == 1){
							
							$('#title_'+obj).remove();
							
							alert('删除成功');
						}
						
						if(data.code == -1){
							alert('请求失败');
						}
					}
				})
				
				
			}
			
			//数据库删除该数据
			
		}
		
		var jsonStr = '[{name:工序名,price:单价,num1:数量,name1:姓名,account:总计}';
		
		function initJsonStr(){
			jsonStr = '[{name:工序名,price:单价,num1:数量,name1:姓名,account:总计}';
		}

		//保存模板信息，上传到数据库
		function saveProcedureInfo() {
			//获取整个模板的信息，然后插入到数据库
			
			var trList = $("tr[id ^= 'title']");
			
			for(var i = 0 ;i < trList.length ; i++){
				var tr = trList.eq(i);
				
				var tdList = tr.children();
				
				let procedureName = tdList.eq(0).html();
				let price = tdList.eq(1).html();
				let number = tdList.eq(2).html();
				let uname = tdList.eq(3).html();
				let account = tdList.eq(4).html();
				
				jsonStr += ",{name:"+procedureName+",price:"+price+"number:"+number+",uname:"
					
					//未完待续
				
			}
				
				alert('已获取员工工资信息');
			
			
		}
		
		
		//新增工序之前的相关操作 tr的id为  'title_'+id
		function addProcedure(obj) {
			
			
			$("input[name = 'trid']").val('title_'+obj);
			
			var trid = 'title_'+obj;
			
			loadDataIntoModal(trid);
			
			
			$("#myModal").modal('show');
		}
		
		
		//加载模态框数据  trid为 操作的 <tr>的id
		function loadDataIntoModal(trid){
			
			var tdList = $("#"+trid).children();
			
			let name = tdList.eq(0).html();
			
			let price = tdList.eq(1).html();
			
			let number = tdList.eq(2).html();
			
			let uname = tdList.eq(3).html();
			
			let account = tdList.eq(4).html();
			
			changeModalTitle('add',name);
			
			$("#proceduresName").val(name);
			
			$("#proceduresPrice").val(price);
			
			$("#number").val(number);
			
			$("#account").val(account);
			

			$("#username").val(uname);
			
		}
	
		//隐藏编辑模态框
		function cancel() {
			$("#editModal").modal('hide');
		}
		