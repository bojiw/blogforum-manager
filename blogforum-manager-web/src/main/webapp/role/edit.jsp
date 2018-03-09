<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>修改权限</title>
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
						<h4><i class="icon-user"></i> 修改角色</h2>
					</div>
                    <div class="ibox-content" style="width:75%;padding-left:20px">
                        <form class="form-horizontal m-t" id="commentForm">
                            <div class="form-group" style="margin-left:10%">
                                <label class="col-sm-2 control-label">角色名</label>

                                <div class="col-sm-10">
                                    <input type="text" id="name" placeholder="输入角色名" class="form-control">
                                </div>
                            </div>

                            <div class="form-group" style="margin-left:10%">
                                <label class="col-sm-2 control-label">备注</label>

                                <div class="col-sm-10">
                                    <input type="text" id="remarks" placeholder="输入备注" class="form-control">
                                </div>
                            </div>
                            <div class="form-group" style="margin-left:10%">
                                <label class="col-sm-2 control-label">状态</label>
                                <div class="col-sm-3">
									<select class="m-wrap" id="delFlag">
									  <option value="N">正常</option>
									  <option value="Y">删除</option>
									</select>
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
					$("#name").val(data.data.name);
					$("#delFlag").val(data.data.delFlag);
					$("#remarks").val(data.data.remarks);
				}
			})
			
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			$("#edit").click(function(){
				var name = $("#name").val();
				var delFlag = $("#delFlag").val();
				var remarks = $("#remarks").val();
				$.post("edit.action",{
						id:id,
						name:name,
						delFlag:delFlag,
						remarks:remarks
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
			
			</script>

</body>
</html>
