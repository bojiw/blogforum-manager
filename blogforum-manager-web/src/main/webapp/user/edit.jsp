<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>查看修改用户信息</title>
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
						<h4><i class="icon-user"></i> 查看修改用户信息</h2>
					</div>
                    <div class="ibox-content" style="width:75%;padding-left:20px">
                        <form class="form-horizontal m-t" id="commentForm">

                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">用户姓名:</label>

                                <div class="col-sm-10">
                                    <label id="username" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">所属角色:</label>

                                <div class="col-sm-10">
										<label id="role" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">邮箱:</label>

                                <div class="col-sm-10">
										<label id="email" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">手机号:</label>

                                <div class="col-sm-10">
										<label id="iphone" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">注册时间:</label>

                                <div class="col-sm-10">
										<label id="createDate" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">最近一次修改时间:</label>

                                <div class="col-sm-10">
										<label id="updateDate" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">最近一次修改用户:</label>

                                <div class="col-sm-10">
										<label id="updateUser" class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <hr style="margin-right:5%">
                            <div class="form-group" style="margin-left:10%">
                                <label style="float: left;" class="col-sm-2 control-label">状态</label>
                                <div class="col-sm-3">
									<select class="m-wrap" id="status">
									</select>
								</div>
                            </div>

                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3" style="padding-top:20px;margin-left:60%">
                                    <button class="btn btn-primary" id="edit" type="button">修改状态</button>
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
					
					var user = data.data.data;
					console.info(user.username);
					$("#username").html(user.username);
					$("#role").html(user.roleCN);
					$("#email").html(user.email);
					$("#iphone").html(user.iphone);
					$("#createDate").html(timeStamp2String(user.createDate));
					$("#updateDate").html(timeStamp2String(user.updateDate));
					$("#loginDate").html(timeStamp2String(user.loginDate));
					$("#updateUser").html(user.updateUser);
					$("#email").html(user.email);
					
					jQuery.each(user.userStatus,function(i,item){
						$("#status").append("<option value=" + item.statusCode + ">" + item.statusCn + "</option>");
					});
					$("#status").val(user.status);
				}
			})
			
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			$("#edit").click(function(){
				var status = $("#status").val();
				$.post("updateStatus.action",{
						id:id,
						status:status
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
