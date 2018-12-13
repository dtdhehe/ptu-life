function regist () {
    $.ajax({
        url:'/ptu/regist',
        type:'POST',
        dateType:'json',
        success:function (date) {
            alert("date:"+date);
        }
    })
}