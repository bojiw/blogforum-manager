<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>权限信息</title>
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
	  
	  select.m-wrap {
	    background-color: #ffffff;
	    background-image: none !important;
	    filter: none !important;
	    border: 1px solid #e5e5e5;
	    outline: none;
	    height: 25px !important;
	    line-height: 25px;
	    width: 77px;
	    padding: 2px 0;
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
						<h2><i class="icon-user"></i> 权限信息</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
							<div class="panel-body">
								<div class="table-responsive">	

									<div class="row" style="float: left;">
										<div class="col-sm-6">
											<div class="bk-margin-bottom-10">
												<button id="addToTable" class="btn btn-info">新增 <i class="fa fa-plus"></i></button>
											</div>
										</div>
									</div>
									
									<div style="float: left;margin-left:62%;margin-bottom: 20px;">
										<input type="text" style="float: left" class="form-control" id="searchkeyword" autocomplete="off" data-provide="typeahead" style="width: 210px;height: 30px;margin-left: 10px;margin-top: 3px"  placeholder="搜索关键字" / >
										<input type="hidden" id="searchid" style="float: left;">
									</div>
									<div style="float: left;margin-left:10px;margin-top:5px;margin-right:20px">
										<select id="textType" class="m-wrap" style="margin-left:20px">
											<option value="role">角色名</option>
											<option value="permision">权限名</option>
										</select>
									</div>
									<div style="margin-left:10px;margin-top:5px">
											<button id="search" class="btn btn-info">搜索 </button>
									</div>
									
									<table class="table table-striped table-bordered bootstrap-datatable datatable " style="margin-top:15px">
										<thead>
											<tr>
												<th style="width:5%">编号</th>
												<th style="width:15%">角色名</th>
												<th style="width:15%">拥有权限</th>
												<th style="width:25%">权限路径</th>
												<th style="width:20%">操作</th>
											</tr>
										</thead>   
										<tbody id="permisiontbody">								
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
					$.get("/rolepermision/queryList.action", {
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
							jQuery.each(data.data.list,function(i,item){
								html += getListHtml(i,item);
							});
							$("#permisiontbody").html(html);
							$(".pagination").html(data.data.html);
							$("#pageNo").val(data.data.pageNo);
							$("#pageSize").val(data.data.pageSize);
						}
					});
				}

				
				function getListHtml(i,item){
					var i = i + 1;
					var html = "";
					html += "<tr>";
					html += "<td>" + i + "</td>";
					html += "<td>" + item.roleName + "</td>";
					html += "<td>" + item.permisionName + "</td>";
					html += "<td>" + item.permisionController + "</td>";
					html += "<td><a style='margin-left:20px' class='btn btn-danger' href='javascript:void(0);' onclick=del('" + item.id + "')>";
					html += "<i class='fa fa-trash-o '></i></a></td></tr>";
					return html;					
					
				}
				
				
				//点击删除 
				function del(id){
					layer.confirm('确定删除吗', {
						  btn: ['确定','取消'] //按钮
						}, function(){
							$.post("/rolepermision/del.action",{
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
					    area: ['20%', '60%'],
					    shift:1,
					    content: "/rolepermision/add.jsp",
					    end: function() {   
					    	showlist(1,5);
					    }
					});	
				});
				
				//点击分页
				function page(pageNo,pageSize,info){
					//判断是否有输入关键字 有则搜索 没有则显示全部
					if($("#searchkeyword").val()){
						search(pageNo,pageSize);
					}else{
						showlist(pageNo,pageSize);
					}
					
				}
				
				
				
				//typeahead搜索管理员功能   https://www.cnblogs.com/shiyu404/p/6344591.html
				$('#searchkeyword').typeahead({
					source: function(query, process){
						var url;
						var type = $("#textType").val();
						if(type == "role"){
							url='/role/queryList.action';
						}else{
							url='/permision/queryList.action';
						}
						//ajax请求当前用户下所有的笔记
			            return $.ajax({
			                url: url,
			                type: 'get',
			                data: {pageNo: 0,pageSize:-1},
			                success: function (result) {
								if(result == "no permision"){
									layer.msg("没有权限");
									return;
								}
			    				if(result.status != "200") {
			    					layer.msg(data.msg);
			    				}else{
			                    	//对返回的结果进行处理 只需要id和name
			                        var resultList = result.data.list.map(function (item) {
			                            var aItem = {id: item.id, name: item.name};
			                            //转换成json
			                            return JSON.stringify(aItem);
			                        });
			                        return process(resultList);
			    				}

			                },
			            });
					},
					items : 15,
					//只对name进行匹配
				    matcher: function (obj) {
				        var item = JSON.parse(obj);
				        return ~item.name.toLowerCase().indexOf(this.query.toLowerCase())
				    },
					//只对name进行高亮显示
			        highlighter: function (obj) {
			            var item = JSON.parse(obj);
			            var query = this.query.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, '\\$&');
			            return item.name.replace(new RegExp('(' + query + ')', 'ig'), function ($1, match) {
			                return '<strong>' + match + '</strong>'
			            });
			        },
			        //选择要搜索的笔记 只设置input框的内容为name  并且设置当前选中的笔记本id和name  然后加载当前笔记本下的笔记
			        updater: function (obj) {
			            var item = JSON.parse(obj);
			            $("#searchid").attr("value",item.id);
			            return item.name;
			        }
				})
				
				//点击搜索
				
				$("#search").click(function(){
					//判断是否有关键字 如果有则搜索 没有则获取全部
					if($("#searchkeyword").val()){
						search(1,5);
					}else{
						showlist(1,5);
					}
					
				});
				function search(pageNo,pageSize){
					
					var id = $("#searchid").val();
					if(!id){
						layer.msg("未找到关键字对应id");
						return;
					}
					var type = $("#textType").val();
					$.post("/rolepermision/search.action",{
						id:id,
						type:type,
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
							jQuery.each(data.data.list,function(i,item){
								html += getListHtml(i,item);
							});
							$("#permisiontbody").html(html);
							$(".pagination").html(data.data.html);
							$("#pageNo").val(data.data.pageNo);
							$("#pageSize").val(data.data.pageSize);
						}
					});
					
				}
			
		</script>
	
		
</body>
</html>
