
	/*  $(function(){
		
		$.ajax({
			url: 'serachAllDate.b',
			type: 'post',
			data: '',
			success: function(data){
				if(data.code == 1){
					
					for(var i=0;i<data.obj.length;i++){
						var html='';
						
						console.log(data.obj[i].times);
						
						var timeString = (''+data.obj[i].times).substring(0,4);
						
						html+='<option value="'+timeString+'">'+timeString+'</option>';
						
						$("select[name = 'year']").append(html);
					}
					
				}
			}
		})
		
		
		
	})
  */


	var totalPage;
	var currentPage = 1;
	
	function ProcedureListsearch(type){
		
		var name  = $("input[name = 'name']").val();
		var remarks = $("input[name = 'remarks']").val();
		var year = $("select[name = 'year']").val();
		var month = $("select[name = 'month']").val();
		var day = $("input[name = 'day']").val();
		
		
		
		var times = '';
		
		var flag='';
		
		let data = {};
		
		if(name != ''){
			data.pName = name;
		}
		
		if(remarks != ''){
			data.remarks = remarks;
		}
		
		if(year != '-1'){
			times += year;
			flag += 'y';
		}
		if(month != '-1'){
			times += month;
			flag += 'm';
		}
		
		var parttern = /^\d{0,2}$/
		
		let f = parttern.test(day);
		
		if(parseInt(day) > 31 || !f){
			alert('请输入正确的日期格式');
			return;
		}
		
		if(day != ''){
			times += day
			flag += 'd';
		}
		
		
		if(times != ''){
		
			if(indexOf(flag,'y')>=0){
				
				if(indexOf(flag,'m')>=0){
					
					data.times = times;
					
				}else{
					alert('请先选择月份');
					flag='';
					return ;
				}
				
			}else{
				alert('请先选择年份');
				flag='';
				
				return ;
			}
		}
		
		data.currentPage = currentPage;
		
		
		$.ajax({
			url: 'getProcedureList.b',
			type: 'post',
			data: data,
			success : function (data){
				
				$("#proceduresTable").empty();
				
				var html = '';
				html+='<tr>';
				html+='<th width="10%" style="text-align:left; padding-left:40px;">模板名称</th>';
				html+='<th width="15%">备注</th>';
				html+='<th width="20%">图片</th>';
				html+='<th width="20%">操作</th>';
				html+='</tr>';
				
				$("#proceduresTable").append(html);
				
				if(data.code == 1){
					
					
					
					totalPage = data.totalPage;
					currentPage = data.currentPage;
					
					
					for(var i=0;i<data.obj.length;i++){
						
						var obj = data.obj[i];
						
						if(obj.pName != 'AAA'){
						
							
							
							var html = '';
							
							var trName = new Date().getTime();
							
							var objYears = ('' + obj.times).substring(0,4);
							var objMonth = ('' + obj.times).substring(4,6);
							var objDay = ('' + obj.times).substring(6,8);
							
							var dateString = objYears+'/'+ objMonth + '/' +objDay;
							
							html+='<tr id="procedure_+'+trName+'">';
							html+='<td style="text-align:left; padding-left:40px;"> '+obj.pName+'</td>';
							html+='<td>'+obj.remarks+'</td>';
							html+='<td width="10%"><img src="'+obj.path+'" alt="" width="70" height="50" /></td>';
							html+='<td>';
							html+='<div class="button-group">';
							html+=' <a class="button border-main" href="procedureInfo.html?pid='+obj.pid+'"><span class="icon-edit"></span> 查看详情</a>';
							html+=" <a class=\"button border-red\" href=\"javascript:void(0)\" onclick=\"del('procedure_"+trName+"','"+obj.pid+"')\"><span class=\"icon-trash-o\"></span> 删除</a>";
							html+='</div>';
							html+='</td>';
							html+='</tr>';
						
							$("#proceduresTable").append(html);
						
						}
						
					}
					
						var html='';
						
						html+='<tr>';
						html+='<td colspan="8">';
						html+='<div class="pagelist">';
						html+=' <a onclick="firstPage()">首页</a>';
						html+=' <a onclick="prePage()">上一页</a>';
						html+='<span class="current">'+data.currentPage+'</span>';
						html+='<a onclick="nextPage()">下一页</a>';
						html+='<a onclick="lastPage()">尾页</a>';
						html+='<a >共'+data.totalPage+'页</a>';
						html+='</div>';
						html+='</td>';
						html+='</tr>';
						
						$("#proceduresTable").append(html);
					
				}else if(data.code == -1){
					if(type != 1){
						alert(data.msg);
					}
				}
			}
		})
		
}
	
	function firstPage(){
		currentPage = 1;
		ProcedureListsearch();
	}
	
	function prePage(){
		if((currentPage-1) <= 0){
			alert('当前已经是第一页');
			return;
		}
		currentPage --;
		ProcedureListsearch();
	}
	
	function nextPage(){
		if((currentPage+1) > totalPage ){
			alert('当前已经是最后一页');
			return;
		}
		currentPage ++;
		ProcedureListsearch();
	}
	
	function lastPage(){
		currentPage = totalPage;
		ProcedureListsearch();
	}
	
	function del(trid,pid){
		
		$.ajax({
			url:"deleteProcedureByPid.b/"+currentPage,
			data:'pid='+pid,
			type:'post',
			success: function(data){
				if(data.code > 0){
					
					alert(data.msg);
					
					currentPage = data.code;
					
					ProcedureListsearch(1);
					
				}else{
					alert(data.msg);
				}
			}
		})
		
		 $('#'+trid).css('display','none');
		
	}
	
	//查找某一字符在字符串中的位置，str为字符串，chr为字符，返回值为该字符在字符串中所处位置
	function indexOf(str,chr){
		
		var tmpArr = str.split('');
		
		for(var i=0;i<tmpArr.length;i++){
			if(tmpArr[i] == chr){
				return i;
			}
		}
		
		return -1;
	}