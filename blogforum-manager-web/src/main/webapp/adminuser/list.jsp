<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>管理员用户信息</title>
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
	   table td {
	   	vertical-align: middle !important;
	   }
	</style>


	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">
		
</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 管理员用户信息</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
							<div class="panel-body">
								<div class="table-responsive" >	
									<div class="row">
										<div class="col-sm-6">
											<div class="bk-margin-bottom-10">
												<button id="addToTable" class="btn btn-info">新增 <i class="fa fa-plus"></i></button>
											</div>
										</div>
									</div>
										<table class="table table-striped table-bordered bootstrap-datatable datatable "  style="margin-top:15px">
									<thead>
										<tr>
											<th style="width:5%">编号</th>
											<th style="width:15%">用户名</th>
											<th style="width:15%">角色名</th>
											<th style="width:15%">创建时间</th>
											<th style="width:15%">创建用户</th>
											<th style="width:20%">操作</th>
										</tr>
									</thead>   
									<tbody id="roletbody">								
									</tbody>
								</table>
								<input type="hidden" id = "pageNo"/>
								<input type="hidden" id = "pageSize"/>
								<div id="page" style="margin-left:60%">
									<ul class="pagination">
									</ul>
								</div>
							</div>
						</div>
				</div><!--/span-->
			
			</div><!--/row-->

		<script>
				
				showlist(1,5);
				
				
				//获取list数据
				function showlist(pageNo,pageSize){
					$.get("/adminuser/queryList.action", {
						pageSize:pageSize,
						pageNo:pageNo
						
					},function(data){
						if(data == "no permision"){
							layer.msg("没有权限");
							return;
						}
						if(data.status != "200"){
							layer.msg(data.msg);
						}else{
							var html = "";
							jQuery.each(data.data.data.list,function(i,item){
								html += getListHtml(i,item);
							});
							console.info(html);
							$("#roletbody").html(html);
							$(".pagination").html(data.data.html);
							$("#pageNo").val(data.data.data.pageNo);
							$("#pageSize").val(data.data.data.pageSize);
						}
					});
				}

				
				function getListHtml(i,item){
					var i = i + 1;
					var html = "";
					html += "<tr>";
					html += "<td>" + i + "</td>";
					html += "<td>" + item.username + "</td>";
					html += "<td>" + item.role.name + "</td>"
					html += "<td>" + timeStamp2String(item.createDate) + "</td>";
					if(item.createUser){
						html += "<td>" + item.createUser + "</td>";
					}else{
						html += "<td></td>";
					}
					
					html += "<td><a style='margin-left:20px' class='btn btn-info' href='javascript:void(0);' onclick=edit('"+ item.id + "') >";
					html += "<i class='fa fa-edit '></i> </a>";
					html += "<a style='margin-left:20px' class='btn btn-danger' href='javascript:void(0);' onclick=del('" + item.id + "')>";
					html += "<i class='fa fa-trash-o '></i></a></td></tr>";
					return html;					
					
				}
				
				//点击编辑
				function edit(id){
					layer.open({
					    type: 2,
					    title:'修改',
					    area: ['20%', '43%'],
					    shift:1,
					    content: "/adminuser/edit.jsp?id=" + id ,
					    end: function() {   
					    	showlist($("#pageNo").val(),$("#pageSize").val());
					    }
					});	
				}
				
				//点击删除 
				function del(id){
					layer.confirm('确定删除吗', {
						  btn: ['确定','取消'] //按钮
						}, function(){
							$.post("adminuser/del.action",{
								id:id
							},function(data){
								if(data == "no permision"){
									layer.msg("没有权限");
									return;
								}
								if(data.status != "200"){
									layer.msg(data.msg);
								}else{
									layer.msg("删除成功");
									showlist(1,5);
								}
							});
						}, function(){
							
						});
				}
				
				//点击新增
				$("#addToTable").click(function(){
					layer.open({
					    type: 2,
					    title:'新增',
					    area: ['20%', '50%'],
					    shift:1,
					    content: "/adminuser/add.jsp",
					    end: function() {   
					    	showlist(1,5);
					    }
					});	
				});
				
				//点击分页
				function page(pageNo,pageSize,info){
					showlist(pageNo,pageSize);
				}
				
				
				function timeStamp2String(time){  
				    var datetime = new Date();  
				    datetime.setTime(time);  
				    var year = datetime.getFullYear();  
				    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;  
				    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();  
				    return year + "-" + month + "-" + date;  
				}  
			
		</script>
	
		
</body>
</html>
