<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>添加包裹邮件信息</title>
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
	<link href="css/styles.css" rel="stylesheet">

</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h4><i class="icon-user"></i> 新增包裹邮件信息</h2>
					</div>
                    <div class="ibox-content" style="width:75%;padding-left:20px">
                        <form class="form-horizontal m-t" id="commentForm">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>

                                <div class="col-sm-10">
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
                                <label class="col-sm-2 control-label">快递单号</label>

                                <div class="col-sm-10">
                                    <input type="text" name="number" placeholder="输入邮件上的快递单号" class="form-control">
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
                                    <button class="btn btn-primary" id="add" type="button">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
				</div>
			</div><!--/row-->
			
					<!-- 时间选择器 -->
		<script src="js/moment.js"></script>
		<script src="js/bootstrap-datetimepicker.js"></script>
		
		<script src="js/addinfo.js"></script>


</body>
</html>
