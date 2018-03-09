<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>修改包裹邮件信息</title>
	<meta name="keywords" content="" />
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
	<link href="css/styles.css" rel="stylesheet">
</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h4><i class="icon-user"></i> 修改包裹邮件信息</h2>
					</div>
                    <div class="ibox-content" style="width:75%;padding-left:20px">
                        <form class="form-horizontal m-t" id="commentForm">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-10">
                                	<input type="hidden" name="id"/>
                                    <input type="text" name="name" placeholder="输入邮件上收件人姓名" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">手机</label>

                                <div class="col-sm-10">
                                    <input type="text" name="mobile" placeholder="输入邮件上的收件人手机号码" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">快递单号:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="number" placeholder="输入邮件上的快递单号" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">状态:</label>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input  type="radio" value="1" id="optionsRadios10" name="status">未取件</label>
		                           </div>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input type="radio" value="2" id="optionsRadios11" name="status">已取件</label>
		                           </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">地址</label>

                                <div class="col-sm-10">
                                    <input type="text" name="address" placeholder="输入具体地址" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">到件时间</label>
                                <div class="col-sm-10">
									<div class="iDate date">
										<input name="date" type="text">
										 <button type="button" class="addOn"></button>
									</div>
								</div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">可逾期天数</label>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input  type="radio" checked="" value="1天" id="optionsRadios1" name="expectedDays">1天</label>
		                           </div>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input type="radio" value="3天" id="optionsRadios2" name="expectedDays">3天</label>
		                           </div>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input type="radio" value="5天" id="optionsRadios3" name="expectedDays">5天</label>
		                           </div>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input type="radio" value="7天" id="optionsRadios4" name="expectedDays">7天</label>
		                           </div>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input type="radio" value="15天" id="optionsRadios5" name="expectedDays">15天</label>
		                           </div>
		                           <div class="radio" style="display:inline;padding-left:20px">
		                               <label>
		                                   <input type="radio" value="30天" id="optionsRadios6" name="expectedDays">30天</label>
		                           </div>
	                        </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>

                                <div class="col-sm-10">
                                    <textarea rows="3" cols="50" name="remark" placeholder="备注" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3" style="padding-top:20px">
                                    <button class="btn btn-primary" id="update" type="button">提交修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
				</div>
			</div><!--/row-->
		<!-- Jquery -->
		<script src="js/jquery-1.11.1.min.js"></script>
		        <!-- layer -->
        <script src="js/layer/layer.js"></script>
		<!-- Bootstrap -->
	    <script src="bootstrap/js/bootstrap.min.js"></script>
	    					<!-- 时间选择器 -->
		<script src="js/moment.js"></script>
		<script src="js/bootstrap-datetimepicker.js"></script>
		<script type="text/javascript">
			  var aQuery = window.location.href.split("?");
			    if($(".iDate.date").length>0){
			        $(".iDate.date").datetimepicker({
			            locale:"zh-cn",
			            format:"YYYY-MM-DD",
			            dayViewHeaderFormat:"YYYY年 MMMM"
			        });
			    }
			  if(aQuery.length > 1)
			  {
			    var aBuf = aQuery[1].split("&");
			    var string = aBuf[0].split("=");
			    var getInfo = decodeURI(string[1]);
			    var datas = getInfo.split(",");
			    $("[name = 'id']").val(datas[0]);
			    $("[name = 'name']").val(datas[1]);
			    $("[name = 'mobile']").val(datas[2]);
			    $("[name = 'address']").val(datas[3]);
			    $("[name = 'date']").val(timeStamp2String(datas[4]));
			    $("[name = 'number']").val(datas[7]);
			    if(datas[8] == "未取件"){
			    	$("#optionsRadios10").attr('checked','true');
			    }else{
			    	$("#optionsRadios11").attr('checked','true');
			    }
			    if(datas[6] != null){
			    	 $("[name = 'remark']").html(datas[6]);
			    }
			    if(datas[5] == "3天"){
			    	$("#optionsRadios2").attr('checked','true');
			    }
			    if(datas[5] == "5天"){
			    	$("#optionsRadios3").attr('checked','true');
			    }
			    if(datas[5] == "7天"){
			    	$("#optionsRadios4").attr('checked','true');
			    }
			    if(datas[5] == "15天"){
			    	$("#optionsRadios5").attr('checked','true');
			    }
			    if(datas[5] == "30天"){
			    	$("#optionsRadios6").attr('checked','true');
			    }
			  }
				$("#update").click(function(){
					var name = $.trim($("[name = 'name']").val());
					if(name == ""){
						layer.tips('姓名未填写!','[name = "name"]',{tips:[2,"#3595CC"]});
						$("[name = 'username']").focus();
						return false;
					}
					var mobile = $.trim($("[name = 'mobile']").val());
					if(mobile == ""){
						layer.tips('手机号未填写!','[name = "mobile"]',{tips:[2,"#3595CC"]});
						$("[name = 'mobile']").focus();
						return false;
					}
					var isMobile=/^(?:13\d|15\d)\d{5}(\d{3}|\*{3})$/;   
					var isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
					if(!isMobile.test(mobile) && !isPhone.test(mobile)){
						layer.tips('手机号填写不正确!','[name = "mobile"]',{tips:[2,"#3595CC"]});
						$("[name = 'mobile']").focus();
						return false;
					}
					var number = $.trim($("[name = 'number']").val());
					if(number == ""){
						layer.tips('快递单号未填写!','[name = "number"]',{tips:[2,"#3595CC"]});
						$("[name = 'number']").focus();
						return false;
					}
					var myReg = /^[a-zA-Z0-9_]{0,}$/;
					if(!myReg.test(number)){
						layer.tips('快递单号填写不正确!','[name = "number"]',{tips:[2,"#3595CC"]});
						$("[name = 'number']").focus();
						return false;
					}
					
					var address = $.trim($("[name = 'address']").val());
					if(address == ""){
						layer.tips('地址未填写!','[name = "address"]',{tips:[2,"#3595CC"]});
						$("[name = 'address']").focus();
						return false;
					}
					var date = $.trim($("[name = 'date']").val());

					var expectedDays = $("[name = 'expectedDays']:checked ").val();
					var remark = $("[name = 'remark']").val();
					var id = $("[name = 'id']").val();
					var status = $("[name = 'status']:checked ").val();
					$.post("/logistics/info/update.action",{
						id:id,
						name:name,
						mobile:mobile,
						address:address,
						number:number,
						date:date,
						expectedDays:expectedDays,
						remark:remark,
						status:status
						},
						function(data) {
						if(data.status != "200") {
							layer.msg(data.msg);
							$("[name='name']").focus();
						} else {
							layer.msg("修改包裹邮件成功");
							$("[name = 'id']").val("");
							$("[name = 'name']").val("");
							$("[name = 'mobile']").val("");
							$("[name = 'number']").val("");
							$("[name = 'address']").val("");
							$("[name = 'date']").val("");
							$("[name = 'remark']").val("");

						}
					});

				});
				
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
