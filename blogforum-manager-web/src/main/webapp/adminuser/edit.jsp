<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>修改管理用户信息</title>
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
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/styles.css" rel="stylesheet">

</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h4><i class="icon-user"></i> 修改管理用户信息</h2>
					</div>
                    <div class="ibox-content" style="width:75%;padding-left:20px">
                        <form class="form-horizontal m-t" id="commentForm">

                            <div class="form-group" style="margin-left:10%">
                                <label class="col-sm-2 control-label">密码修改</label>

                                <div class="col-sm-10">
                                    <input type="password" id="password" placeholder="如果需要修改密码请输入新密码" class="form-control">
                                </div>
                            </div>
                            <div class="form-group" style="margin-left:10%">
                                <label class="col-sm-2 control-label">所属角色</label>

                                <div class="col-sm-10">
										<input type="text" style="float: left" class="form-control" id="rolename" autocomplete="off" data-provide="typeahead" style="width: 210px;height: 30px;margin-left: 10px;margin-top: 3px"  placeholder="搜索角色名" / >
										<input type="hidden" id="roleid" style="float: left;">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3" style="padding-top:20px;margin-left:60%">
                                    <button class="btn btn-primary" id="edit" type="button">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
				</div>
			</div><!--/row-->
			<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
			<script src="http://cdn.staticfile.org/layer/2.3/layer.js"></script>
	    	<script src="https://cdn.bootcss.com/bootstrap-3-typeahead/3.1.0/bootstrap3-typeahead.min.js"></script>
			
			<script>
			var id = getUrlParam("id");
			$.get("get.action",{
				id:id
			},function(data){
				if(data == "no permision"){
					layer.msg("没有权限");
					return;
				}
				if(data.status != "200"){
					layer.msg(data.msg);
				}else{
					$("#rolename").val(data.data.role.name);
					$("#roleid").val(data.data.role.id)
				}
			})
			
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			$("#edit").click(function(){
				var password = $("#password").val();
				var roleid = $("#roleid").val();
				$.post("edit.action",{
						id:id,
						password:password,
						roleId:roleid
					},function(data){
						if(data == "no permision"){
							layer.msg("没有权限");
							return;
						}
						if(data.status != "200"){
							layer.msg(data.msg);
						}else{
							parent.layer.close(index);
						}
					});
			});
			
			
			//获取url上的参数
	        function getUrlParam(name) {
	            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	            if (r != null) return unescape(r[2]); return null; //返回参数值
	        }
			
			
			//typeahead搜索角色名
			$('#rolename').typeahead({
				source: function(query, process){
					//ajax请求当前用户下所有的笔记
		            return $.ajax({
		                url: "/role/queryList.action",
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
		            $("#roleid").attr("value",item.id);
		            return item.name;
		        }
			})
			
			
			</script>

</body>
</html>
