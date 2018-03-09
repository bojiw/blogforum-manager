<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>包裹邮件信息</title>
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
		
</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h4><i class="icon-user"></i> 包裹邮件信息</h2>
					</div>
                    <div class="ibox-content" style="width:75%;padding-left:20px">
                        <form class="form-horizontal m-t" id="commentForm">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名:</label>
                                <div class="col-sm-10">
                                  <label name="name" style='text-align:left' class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">手机:</label>
                                  <div class="col-sm-10">
                                   <label name="mobile" style='text-align:left' class="col-sm-2 control-label"></label>
                                  </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">快递单号:</label>
                                  <div class="col-sm-10">
                                   <label name="number" style='text-align:left' class="col-sm-2 control-label"></label>
                                  </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">状态:</label>
                                  <div class="col-sm-10">
                                   <label name="status" style='text-align:left' class="col-sm-2 control-label"></label>
                                  </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">地址:</label>

                                <div class="col-sm-10">
                                    <label name="address" style='text-align:left' class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">到件时间:</label>

                                <div class="col-sm-10">
                                    <label name="reachDate" style='text-align:left' class="col-sm-2 control-label"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">可逾期天数:</label>
                                <div class="col-sm-10">
                                  <label name="expectedDays" style='text-align:left' class="col-sm-2 control-label"></label>
	                        </div>
		            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注:</label>

                                <div class="col-sm-10">
                                  <textarea rows="3" cols="50" readonly  name="remark" style='text-align:left'></textarea>
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
		<script type="text/javascript">
			  var aQuery = window.location.href.split("?");
			  if(aQuery.length > 1)
			  {
			    var aBuf = aQuery[1].split("&");
			    var string = aBuf[0].split("=");
			    var getInfo = decodeURI(string[1]);
			    var datas = getInfo.split(",");
			    $("[name = 'name']").html(datas[1]);
			    $("[name = 'mobile']").html(datas[2]);
			    $("[name = 'address']").html(datas[3]);
			    $("[name = 'reachDate']").html(timeStamp2String(datas[4]));
			    $("[name = 'expectedDays']").html(datas[5]);
			    $("[name = 'number']").html(datas[7]);
			    $("[name = 'status']").html(datas[8]);
			    if(datas[6] != null){
			    	 $("[name = 'remark']").html(datas[6]);
			    }
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
