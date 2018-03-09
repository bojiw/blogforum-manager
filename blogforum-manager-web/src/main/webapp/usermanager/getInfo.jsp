<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>查询或修改邮件</title>
	<meta name="keywords" content="" />
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- The styles -->
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- ionicons -->
	<link href="../css/ionicons.min.css" rel="stylesheet">
	<link href="../css/styles.css" rel="stylesheet">
</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h4><i class="icon-user"></i> 查询或修改邮件</h2>
					</div>
							<label>开始时间</label>
							<div class="iDate date" >
								<input name="startdate" type="text">
								 <button type="button" class="addOn"></button>
							</div>
							<label >结束时间</label>
							<div class="iDate date" >
								<input name="enddate" type="text">
								 <button type="button" class="addOn"></button>
							</div>
					

						
						<div class="btn-group marginTB-xs">
					  		<button name="code" value="codename" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
					    		根据名字搜索 <span class="caret"></span>
					  		</button>
					  		<ul class="dropdown-menu" role="menu">
							    <li><a onclick="select('name')">根据名字搜索</a></li>
							    <li><a onclick="select('mobile')">根据手机号搜索</a></li>
					  		</ul>
						</div>
						<div class="btn-group marginTB-xs" >
							<ul class="nav-notification">	
									<div class="search-input-wrapper">
										<div class="search-input" >
											<input type="text" name="condition" class="form-control input-sm inline-block">
											<a id="query" class="input-icon text-normal"><i class="ion-ios7-search-strong"></i></a>
										</div>
									</div>
							</ul>
						</div>
						
							<div class="panel-body">
								<div class="table-responsive">	
									<table class="table table-striped table-bordered bootstrap-datatable datatable ">
										<thead>
											<tr>
												<th>编号</th>
												<th>姓名</th>
												<th>手机号</th>
												<th>状态</th>
												<th>创建时间</th>
												<th>修改时间</th>
												<th>操作</th>
											</tr>
										</thead>   
									<tbody id = "tbody">								
									</tbody>
								</table>
							</div>
						</div>

				</div>
			</div><!--/row-->
	<!-- 时间选择器 -->
	<script src="js/moment.js"></script>
	<script src="js/bootstrap-datetimepicker.js"></script>		
	<script type="text/javascript">
	    if($(".iDate.date").length>0){
	        $(".iDate.date").datetimepicker({
	            locale:"zh-cn",
	            format:"YYYY-MM-DD",
	            dayViewHeaderFormat:"YYYY年 MMMM"
	        });
	    }
	    $("[name = 'startdate']").val("");
	    $("[name = 'enddate']").val("");
		getAll();
		
		$("#query").click(function(){
			getAll();
		});
		
		function update(upData){
			var data = encodeURI(upData);
			layer.open({
			    type: 2,
			    title:'修改',
			    area: ['90%', '85%'],
			    shift:1,
			    content: "${pageContext.request.contextPath}/updateInfo.jsp?data=" + data,
			    end: function() {   
			    	getAll();
			    }
			});	
		}

			
		function show(upData){
			var data = encodeURI(upData);
			layer.open({
			    type: 2,
			    title:'显示',
			    area: ['90%', '85%'],
			    shift:1,
			    content: "${pageContext.request.contextPath}/showInfo.jsp?data=" + data,
			    end: function() {   
			    }
			});	
		}
		
		function del(id){
			layer.confirm('确定要删除该信息吗', {
				  btn: ['确定','取消'] //按钮
				}, function(){
					$.post("/logistics/info/delete.action",{id:id},function(data){
						if(data.status != "200") {
							layer.msg(data.msg);
						} else {
							layer.msg("删除包裹邮件成功");
				            getAll();
						}
					});
				}, function(){
				  
				});
		}  
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
		function getAll(){
			if($("[name = 'startdate']").val() > $("[name = 'enddate']").val()){
				alert("时间段选择不正确,请重新选择");
				return;
			}
            $('td').each(function() {
                $(this).remove();
            })
			var code = $("[name = 'code']").val();
			var condition = $("[name = 'condition']").val();
			var startdate = $("[name = 'startdate']").val();
			var enddate = $("[name = 'enddate']").val();
			$.get("/logistics/info/getAll.action",{
				code:code,
				condition:condition,
				startdate:startdate,
				enddate:enddate
			},
				function(data) {
					if(data.status != "200") {
						layer.msg(data.msg);
					} else {
						var datas = data.data;
						var remark = "";
						var line = "";
						for(i=0;i<datas.length;i++){
							line=line + "<tr>";
							line=line + "<td>" + (i+1) + "<input type='hidden' value='" + datas[i].id + "'/>" + "</td>";
							line=line + "<td>" + datas[i].name + "</td>";
							line=line + "<td>" + datas[i].mobile + "</td>";
							/*
							line=line + "<td>" + datas[i].address + "</td>";
							line=line + "<td>" + datas[i].reachDate + "</td>";
							line=line + "<td>" + datas[i].expectedDays + "</td>";
							*/
							var s = (datas[i].status == "1") ? "未取件" : "已取件";
							line=line + "<td>" + s + "</td>";
							line=line + "<td>" + timeStamp2String(datas[i].createTime) + "</td>";
							line=line + "<td>" + timeStamp2String(datas[i].updateTime) + "</td>";
							/*
							if(datas[i].remark != null ){
								remark = datas[i].remark;
								line=line + "<td>" + datas[i].remark + "</td>";
							}else{
								line=line + "<td></td>";
							}
							*/
							var upData =datas[i].id + "," + datas[i].name + "," + datas[i].mobile + "," + datas[i].address + "," + datas[i].reachDate + "," + datas[i].expectedDays + "," + datas[i].remark + "," + datas[i].number + "," + s ;
							line=line + "<td><a class='btn btn-info' href='javascript:void(0);' onclick=show('" + upData + "')><i class='fa fa-list'></i></a>";
							line=line + "<a class='btn btn-info' href='javascript:void(0);' onclick=update('" + upData + "')><i class='fa fa-edit'></i></a>";
							line=line + "<a class='btn btn-danger' href='javascript:void(0);' onclick=del('" + datas[i].id + "')><i class='fa fa-trash-o'></i></a></td>";
							line=line + "<tr>";
						}
						$("#tbody").append(line);
					}
				});
		}
		function select(code){  
			if(code == "name"){
				$("[name = 'code']").val("codename");
				$("[name = 'code']").html("根据名字搜索 <span class='caret'>");
			}else{
				$("[name = 'code']").val("codemobile");
				$("[name = 'code']").html("根据手机号搜索 <span class='caret'>");
			}
		}
	</script>
		
</body>
</html>
