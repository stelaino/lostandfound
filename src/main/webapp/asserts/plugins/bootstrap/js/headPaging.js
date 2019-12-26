$(function () {
    //自定义函数
    function page1(data){
        $("#content .content").remove();
        $("#select").html(data.province);
        $("#shiWuZhaoLingProvince").html(data.province);
        var list = data.lostList;
        for(var i = 0;i<list.length;i++){
            var img = "asserts/images/lbt1.jpg";
            if (list[i].pic1 != null) {
                img = list[i].pic1;
            } else {
                console.log(list[i].pic1);
                console.log(list[i].pic2);
                if (list[i].pic2 != null) {
                    img = list[i].pic2;
                }
            }
            var div = $("<div style=\"cursor:pointer;height: 400px;width: 300px;float: left;margin-top: 15px;margin-left: 11px;background-color: #fcf8e3;\"class=\"content\">\n" +
                "         <input type=\"hidden\" value=\""+list[i].lMsgId+"\" class=\"hidden\">\n" +
                "        <div style=\"width: 250px;height: 40px;overflow: hidden;line-height: 30px;margin-top: 15px;margin-left: 20px;\">\n" +
                "            <div style=\"height: 10px;width: 250px;\">"+list[i].title+"</div>\n" +
                "            <hr style=\"height:1px;border:none;border-top:1px groove skyblue;\" />\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 200px;margin-left: 20px;\">\n" +
                "            <img src=\""+img+"\" style=\"height: 200px;width: 250px;\">\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 30px;margin-left: 20px;line-height: 30px;\">\n" +
                "            <span><strong>"+list[i].lCity+"-失物启事</strong></span>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 70px;margin-left: 20px;line-height: 23px;overflow: hidden\">\n" +
                "            <span>"+list[i].body+"</span>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 25px;margin-left: 20px;line-height: 20px;\">\n" +
                "            <div style=\"float: right;color: orangered;\">"+list[i].createTime+"</div>\n" +
                "        </div>\n" +
                "    </div>");

            $("#content").append(div);
        };
        $("#content").append($("<div style=\"clear:both;\"></div>"));
        //设置隐藏当前页
        $("#hiddenPage").val(data.currentPage);
        //设置隐藏总页数
        $("#pageCount").val(data.pageCount);
    }

    //起始页（首次进入或者刷新）
    $.ajax({
        //请求地址（用id为select的省份内容作为参数传递）
        url:"http://localhost:8080/lostandfound/provinceController/getList1",
        //提交方式
        type:"POST",
        //规定请求参数的数据类型为json格式，数据不能为对象
        contentType:"application/json;charset=UTF-8",
        data:JSON.stringify({"currentPage":1,"province":$("#select").html()}),
        //响应的数据类型
        dataType:"JSON",
        success:function (data) {
            console.log("起始页");
            page1(data);
            if(data.pageCount == 1){
                $("#last").css("display","none");
                $("#next").css("display","none");
            }else{
                $("#last").css("display","block");
                $("#next").css("display","block");
            };
            //首页进入时隐藏上一页
            $("#last").css("display","none");
        }
    });

    //点击已经选择的省份
    $("#selectProvince").click(function () {
        $.ajax({
            //请求地址
            url:"http://localhost:8080/lostandfound/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                $("#currentPage").val(1);
            }
        })
    });

    //选择省份
    $("#selectPro li font").click(function () {
        $("#select").html($(this).html());
        $.ajax({
            //请求地址
            url:"http://localhost:8080/lostandfound/provinceController/getList2",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$(this).html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                if(data.pageCount == 1){
                    $("#last").css("display","none");
                    $("#next").css("display","none");
                }else{
                    $("#last").css("display","block");
                    $("#next").css("display","block");
                };
                //首页进入时隐藏上一页
                $("#last").css("display","none");
                $("#currentPage").val(1);
            }
        })
    });

    //点击首页
    $("#first").click(function () {
        //跳转框设置值
        $("#currentPage").val(1);
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"http://localhost:8080/lostandfound/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                $("#last").css("display","none");
                if(data.pageCount>1){
                    $("#next").css("display","block");
                }
                $("#hiddenPage").val(data.currentPage);
            }
        })
    });

    //点击下一页
    $("#next").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#hiddenPage").val()*1+1);
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"http://localhost:8080/lostandfound/provinceController/getList1",
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
                $("#last").css("display","block");
                $("#hiddenPage").val(data.currentPage);
                $("#currentPage").val(data.currentPage);
            }
        })
    });

    //点击上一页
    $("#last").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#hiddenPage").val()*1-1);
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"http://localhost:8080/lostandfound/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":$("#hiddenPage").val()*1-1,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                //点击上一页后的当前页等于1
                if(data.currentPage == 1){
                    $("#last").css("display","none");
                }
                $("#next").css("display","block");
                $("#hiddenPage").val(data.currentPage);
                $("#currentPage").val(data.currentPage);
            }
        })
    });

    //点击尾页
    $("#end").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#pageCount").val());
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"http://localhost:8080/lostandfound/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":$("#pageCount").val(),"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                if(data.pageCount == 1){
                    $("#next").css("display","none");
                    $("#last").css("display","none");
                }else{
                    $("#next").css("display","none");
                    $("#last").css("display","block");
                }
                $("#hiddenPage").val(data.currentPage);
            }
        })
    });

    //点击跳转
    $("#jump").click(function () {
        var currentPage;
        if($("#currentPage").val()<=1){
            currentPage = 1;
        }else if($("#currentPage").val()>=$("#pageCount").val()){
            currentPage = $("#pageCount").val();
        }else if(typeof($("#currentPage").val()) == 'string' ){
            currentPage = 1;
        }else{
            currentPage = $("#currentPage").val();
        }
        $.ajax({
            //请求地址（用id为select的省份内容作为参数传递）
            url:"http://localhost:8080/lostandfound/provinceController/getList1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":currentPage,"province":$("#select").html()}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                if(data.currentPage == data.pageCount){
                    $("#next").css("display","none");
                    $("#last").css("display","block");
                }
                if(data.currentPage == 1){
                    $("#last").css("display","none");
                }
                $("#hiddenPage").val(data.currentPage);
                $("#currentPage").val(data.currentPage);
            }
        })
    });

    //搜索框
    $("#searchContext").click(function () {
        //内容
        var context = $("#information").val();
        //省份
        var province = $("#select").html();
        $.ajax({
            url:"http://localhost:8080/lostandfound/searchController/search1",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"currentPage":1,"province":$("#select").html(),"context":context}),
            //响应的数据类型
            dataType:"JSON",
            success:function (data) {
                page1(data);
                $("#currentPage").val(1);
                var findText = $("#content").html().split(context);
                $("#content").html(findText.join("<font style='color: orangered;font-weight: 700;'>"+ context+"</font>"));
            }
        });
    });

    //点击帖子
    $(document).on("click",".content",function () {
        var lMsgId = $(this).find("input").val();
        console.log(lMsgId);
        $.ajax({
            url:"http://localhost:8080/lostandfound/searchController/search13",
            //提交方式
            type:"POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"lMsgId":lMsgId}),
            //响应的数据类型
            dataType:"JSON",
            success:function () {
                location.href = "lost.html";
            }
        })
    });
//打印格言
    $("#tips").html(getDictumin())

    //判断是否登录
    $.ajax("http://localhost:8080/lostandfound/user/getUser",{
        type:"POST",
        dataType: "JSON",
        success:function (msg) {
            if (msg != null) {
                $("#uName").html(msg.uName);
                $("#ucen1").css("display", "block");
                $("#ucen2").css("display","block");
                $("#lout").css("display", "block");
                $("#lgin").css("display","none")
            }
        }
    })

    //注销账号
    $("#logout").click(function () {
        $.ajax("http://localhost:8080/lostandfound/user/logout",{
            type: "POST",
            dataType: "JSON",
            success:function (msg) {
                console.log(msg);
                if (msg == true) {
                    location.href = "login.html";
                } else {
                    alert("用户还未登录，无需注销");
                }
            }
        });
    });
});