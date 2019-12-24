$(function () {
    //自定义函数
    function page1(data){
        $("#content .content").remove();
        $("#select").html(data.province);
        $("#shiWuZhaoLingProvince").html(data.province)
        var list = data.lostList;
        console.log(list.length);
        for(var i = 0;i<list.length;i++){
            var div = $("    <div style=\"height: 400px;width: 300px;float: left;margin-top: 15px;margin-left: 11px;background-color: #fcf8e3;\"class=\"content\">\n" +
                "        <div style=\"width: 250px;height: 40px;overflow: hidden;line-height: 30px;margin-top: 15px;margin-left: 20px;\">\n" +
                "            <div style=\"border-bottom: 1px solid black;\">"+list[i].title+"</div>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 200px;margin-left: 20px;\">\n" +
                "            <img src=\"asserts/images/lbt1.jpg\" style=\"height: 200px;width: 250px;\">\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 30px;margin-left: 20px;line-height: 30px;\">\n" +
                "            <span><strong>"+list[i].lCity+"-失物启事</strong></span>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 70px;margin-left: 20px;line-height: 23px;overflow: hidden\">\n" +
                "            <span>"+list[i].describe+"</span>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 25px;margin-left: 20px;line-height: 20px;\">\n" +
                "            <div style=\"float: right;color: orangered;\">"+list[i].createTime+"</div>\n" +
                "        </div>\n" +
                "    </div>");
            $("#content").append(div);
        }
        $("#content").append($("<div style=\"clear:both;\"></div>"));
        //设置隐藏当前页
        $("#hiddenPage").val(data.currentPage);
        //设置隐藏总页数
        $("#pageCount").val(data.pageCount);
    }

    //起始页（首次进入或者刷新）
    $.ajax({
        //请求地址（用id为select的省份内容作为参数传递）
        url:"/lostandfound_war_exploded/provinceController/getList1",
        //提交方式
        type:"POST",
        //规定请求参数的数据类型为json格式，数据不能为对象
        contentType:"application/json;charset=UTF-8",
        data:JSON.stringify({"currentPage":1,"province":$("#select").html()}),
        //响应的数据类型
        dataType:"JSON",
        success:function (data) {
            page1(data);
            if(data.pageCount == 1){
                $("#last").css("display","none");
                $("#next").css("display","none");
            }
        }
    });

    //点击已经选择的省份
    $("#selectProvince").click(function () {
        $.ajax({
            //请求地址
            url:"/lostandfound_war_exploded/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
            }
        })
    });

    //选择省份
    $("li font").click(function () {
        $("#select").html($(this).html());
        $.ajax({
            //请求地址
            url:"/lostandfound_war_exploded/provinceController/getList2",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$(this).html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
            }
        })
    });

    //点击首页
    $("#first").click(function () {
        $("#currentPage").val(1);
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"/lostandfound_war_exploded/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
            }
        })
    });

    //点击下一页
    $("#next").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#hiddenPage").val()*1+1);
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"/lostandfound_war_exploded/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":$("#hiddenPage").val()*1+1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                //点击下一页后的当前页等于总页数
                if(data.currentPage == data.pageCount){
                    $("#next").css("display","none");
                }
                $("#hiddenPage").val(data.currentPage);
            }
        })
    });

    //点击上一页
    $("#last").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#hiddenPage").val()*1-1);
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"/lostandfound_war_exploded/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":$("#hiddenPage").val()*1+1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                //点击上一页后的当前页等于1
                if(data.currentPage == 1){
                    $("#last").css("display","none");
                }
                $("#hiddenPage").val(data.currentPage);
            }
        })
    });

    //点击尾页
    $("#end").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#pageCount").val());
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"/lostandfound_war_exploded/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":$("#hiddenPage").val()*1+1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                if(data.currentPage == 1){
                    $("#last").css("display","none");
                }
                $("#hiddenPage").val(data.currentPage);
            }
        })
    });
});