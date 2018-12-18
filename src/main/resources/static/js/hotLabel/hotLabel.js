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