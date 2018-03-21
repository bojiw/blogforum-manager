$(function(){
	
	//loading-------------------------------------------------

    //设置用户总数
	$.get("user/getCount.action", {
		},function(data){
		if(data.status != "200"){
			layer.msg(data.msg);
		}else{
			var allCount = data.data;
			$("#allUserCount").html(allCount.allUserCount.count);
			$("#allUserCountmemo").html(allCount.allUserCount.memo);
			$("#activeUserCount").html(allCount.activeUserCount.count);
			$("#activeUserCountmemo").html(allCount.activeUserCount.memo);
			$("#lastMonthUserCount").html(allCount.lastMonthUserCount.count);
			$("#lastMonthUserCountmemo").html(allCount.lastMonthUserCount.memo);
			$("#lastSevenUserCount").html(allCount.lastSevenUserCount.count);
			$("#lastSevenUserCountmemo").html(allCount.lastSevenUserCount.memo);
		}
	});
    
	//设置笔记总数
	$.get("note/getCount.action", {
	},function(data){
	if(data.status != "200"){
		layer.msg(data.msg);
	}else{
		var allCount = data.data;
		$("#allNoteCount").html(allCount.allNoteCount.count);
		$("#allNoteCountmemo").html(allCount.allNoteCount.memo);
		$("#noDelNoteCount").html(allCount.noDelNoteCount.count);
		$("#noDelNoteCountmemo").html(allCount.noDelNoteCount.memo);
		$("#lastMonthNoteCount").html(allCount.lastMonthNoteCount.count);
		$("#lastMonthNoteCountmemo").html(allCount.lastMonthNoteCount.memo);
		$("#lastSevenNoteCount").html(allCount.lastSevenNoteCount.count);
		$("#lastSevenNoteCountmemo").html(allCount.lastSevenNoteCount.memo);
	}
});
	
	
	//click-------------------------------------------------------
    //菜单点击
    J_iframe
    $(".J_menuItem").on('click',function(){
        var url = $(this).attr('href');
        $("#J_iframe").load(url);
        return false;
    });
    
    
});