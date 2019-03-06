//初始化热门标签
function initHotLabel(urls,ulDiv) {
    $.ajax({
        url:urls,
        async:true,
        type:'POST',
        data:{
            page:0,
            //每页5条数据
            size:5
        },
        success:function (data) {
            if (data.status === "0"){
                var labelList = data.object;
                for (var i=0;i<labelList.length;i++){
                    var htmls =
                        "<li class='list-group-item' style='background-color: #f5f5f5'>" +
                        "   <span class='badge'>"+labelList[i].labelHot+"</span>" +labelList[i].labelTitle+
                        "</li>";
                    $("#"+ulDiv).append(htmls);
                }
            }
        }
    });
}


//初始化评论框
//commentDiv:评论框div     postIdDiv:业务主键div
function initComment(commentDiv, postIdDiv) {
//清空评论区的内容
    $("#"+commentDiv).empty();
    var postId = $("#"+postIdDiv).val();
    var urls = '/comment/commentController/query?postId='+postId;
    $.ajax({
        url: urls,
        async: true,
        type: 'POST',
        success:function (data) {
            if (data.status === "0"){
                var commentList = data.object;
                for (var index in commentList){
                    var childList = commentList[index].commentList;
                    var htmls = '';
                    if (childList.length === 0){
                        htmls = htmls +
                            '<div class="col-md-2 column">' +
                            '         <a href="#" class="pull-left" style="margin-top: 15px">' +
                            '           <img alt="140x140" style="width: 70px; height: 70px;margin-right: 8px;" src="'+commentList[index].userHeadImg+'" class="img-circle" />' +
                            '         </a>' +
                            '</div>' +
                            '<div class="col-md-10 column" style="padding: 5px">' +
                            '  <span style="color: #337ab7">'+commentList[index].userName+'</span>' +
                            '    <div style="min-height: 60px;font-size: large;margin: 5px 0 5px 0">' +
                            '             '+commentList[index].content+'<br/>' +
                            '    </div>' +
                            '    <input id="commentId" type="hidden" value="'+commentList[index].id+'" />' +
                            '    <input id="commentUserId" type="hidden" value="'+commentList[index].userId+'" />' +
                            '  <div style="font-size: 5px;font-family: \'微软雅黑 Light\'">' +
                            '    <label style="margin-right: 40px">'+commentList[index].createTime+'</label>' +
                            '    <a id="reply" href="javascript:void(0);" onclick="reply(this,1)">回复</a>' +
                            '    <a id="cancel" href="javascript:void(0);" onclick="cancel(this,1)" style="display: none;margin-left: 10px">取消</a>' +
                            '  </div>' +
                            '</div>' +
                            '<hr/>';
                    }else{
                        htmls = htmls +
                            '<div class="col-md-2 column">' +
                            '         <a href="#" class="pull-left" style="margin-top: 15px">' +
                            '           <img alt="140x140" style="width: 70px; height: 70px;margin-right: 8px;" src="'+commentList[index].userHeadImg+'" class="img-circle" />' +
                            '         </a>' +
                            '</div>' +
                            '<div class="col-md-10 column" style="padding: 5px">' +
                            '  <span style="color: #337ab7">'+commentList[index].userName+'</span>' +
                            '    <div style="min-height: 60px;font-size: large;margin: 5px 0 5px 0">' +
                            '             '+commentList[index].content+'<br/>' +
                            '    </div>' +
                            '    <input id="commentId" type="hidden" value="'+commentList[index].id+'" />' +
                            '    <input id="commentUserId" type="hidden" value="'+commentList[index].userId+'" />' +
                            '  <div style="font-size: 5px;font-family: \'微软雅黑 Light\'">' +
                            '    <label style="margin-right: 40px">'+commentList[index].createTime+'</label>' +
                            '    <a id="reply" href="javascript:void(0);" onclick="reply(this,1)">回复</a>' +
                            '    <a id="cancel" href="javascript:void(0);" onclick="cancel(this,1)" style="display: none;margin-left: 10px">取消</a>' +
                            '  </div>';
                        for (var i in childList){
                            htmls = htmls +
                                '  <div class="col-md-2 column">' +
                                '    <a href="#" class="pull-left" style="margin-top: 15px">' +
                                '       <img alt="140x140" style="width: 50px; height: 50px;margin-right: 8px;" src="'+childList[i].userHeadImg+'" class="img-circle" />' +
                                '    </a>' +
                                '  </div>' +
                                '  <div class="col-md-10 column" style="padding: 5px">' +
                                '    <div style="min-height: 60px;margin: 10px 0 5px 0">';
                            if(childList[i].replyUserName === ""){
                                htmls = htmls+
                                    '<span style="color: #337ab7">'+childList[i].commentUserName+'</span>:';
                            }else {
                                htmls = htmls+
                                    '<span style="color: #337ab7">'+childList[i].commentUserName+'</span>' +
                                    '<span style="font-size: 5px;font-weight: bold">&nbsp;&nbsp;回复&nbsp;&nbsp;</span>' +
                                    '<span style="color: #337ab7">'+childList[i].replyUserName+'</span>:';
                            }
                            htmls = htmls+
                                '             '+childList[i].content+'<br/>' +
                                '    </div>' +
                                '    <input id="commentId" type="hidden" value="'+childList[i].id+'" />' +
                                '    <input id="commentUserId" type="hidden" value="'+childList[i].userId+'" />' +
                                '    <div style="font-size: 5px;font-family: \'微软雅黑 Light\'">' +
                                '       <label style="margin-right: 40px">'+childList[i].createTime+'</label>' +
                                '       <a id="reply" href="javascript:void(0);" onclick="reply(this,2)">回复</a>' +
                                '       <a id="cancel" href="javascript:void(0);" onclick="cancel(this,2)" style="display: none;margin-left: 10px">取消</a>' +
                                '    </div>' +
                                '  </div>' +
                                '<hr/>' ;
                        }
                        htmls = htmls +
                            '</div>' +
                            '<hr/>';
                    }
                    $("#"+commentDiv).prepend(htmls);
                }

            }
        }
    });
}



//回复按钮点击弹出回复框
//obj:当前元素   status:1(一级回复) 2(二级回复)
function reply(obj,status) {
    var headImgSrc = $("#headImg").val();
    $(obj).parent().find("#cancel").css("display","");
    if (status === 1){
        var htmls = '' +
            '<div id="comment2" style="padding: 10px">' +
            '   <a href="#" class="pull-left" style="margin-top: 15px">' +
            '     <img alt="140x140" style="width: 70px; height: 70px;margin-right: 8px;" src="'+headImgSrc+'" class="img-circle" />' +
            '   </a>' +
            '   <textarea placeholder="请输入" class="layui-textarea" style="display: inline;resize: none;width: 72%;font-size: large"></textarea>' +
            '   <button onclick="comment(this,1)" class="pull-right btn btn-info" style="height: 100px;width: 13%">发表<br/>评论</button>' +
            '</div>';
        $(obj).parent().after(htmls);
        $(obj).removeAttr("onclick");
    }else if(status === 2){
        var htmls = '' +
            '<div id="comment2" style="padding: 10px">' +
            '   <a href="#" class="pull-left" style="margin-top: 15px">' +
            '     <img alt="140x140" style="width: 70px; height: 70px;margin-right: 8px;" src="'+headImgSrc+'" class="img-circle" />' +
            '   </a>' +
            '   <textarea placeholder="请输入" class="layui-textarea" style="display: inline;resize: none;width: 72%;font-size: large"></textarea>' +
            '   <button onclick="comment(this,2)" class="pull-right btn btn-info" style="height: 100px;width: 13%">发表<br/>评论</button>' +
            '</div>';
        $(obj).parent().parent().after(htmls);
        $(obj).removeAttr("onclick");
    }
}

//取消回复
//obj:当前元素      status:1(一级回复) 2(二级回复)
function cancel(obj, status) {
    $(obj).parent().find("#reply").attr("onclick","reply(this,"+status+")");
    if (status === 1){
        // $(obj).parent().parent().find("#comment2").remove();
        $(obj).parent().next().remove();
        $(obj).css("display","none");
    }else if(status === 2){
        // $(obj).parent().parent().parent().find("#comment2").remove();
        $(obj).parent().parent().next().remove();
        $(obj).css("display","none");

    }
}

//评论
//comment:评论内容
//commentDiv:评论框div     postIdDiv:业务主键div
function doComment(comment,commentDiv, postIdDiv) {
    var urls = '/comment/commentController/add';
    $.ajax({
        url:urls,
        async:true,
        type:'POST',
        data:{
            comment: JSON.stringify(comment)
        },
        success:function (data) {
            if (data.status === "0"){
                layer.alert("评论成功!",{
                    title:"提示",
                    icon:1,
                    btn:[ '确认' ],
                    yes : function() {
                        $("#contentParent").val("");
                        layer.closeAll();
                        initComment(commentDiv, postIdDiv);
                    }
                });
            }
        }
    });
}
