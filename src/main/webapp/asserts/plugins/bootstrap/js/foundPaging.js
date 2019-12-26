$(function () {
    //自定义函数
    function page1(data) {
        $("#content .content").remove();
        $("#select").html(data.province);
        $("#shiWuProvince").html(data.province);
        var list = data.pickupList;
        for (var i = 0; i < list.length; i++) {
            var div = $("<div style=\"cursor:pointer;height: 400px;width: 300px;float: left;margin-top: 15px;margin-left: 11px;background-color: #fcf8e3;\"class=\"content\">\n" +
                "         <input type=\"hidden\" value=\"" + list[i].pMsgId + "\">\n" +
                "        <div style=\"width: 250px;height: 40px;overflow: hidden;line-height: 30px;margin-top: 15px;margin-left: 20px;\">\n" +
                "            <div style=\"height: 10px;width: 250px;\">" + list[i].title + "</div>\n" +
                "            <hr style=\"height:1px;border:none;border-top:1px groove skyblue;\" />\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 200px;margin-left: 20px;\">\n" +
                "            <img src=\"asserts/images/lbt1.jpg\" style=\"height: 200px;width: 250px;\">\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 30px;margin-left: 20px;line-height: 30px;\">\n" +
                "            <span><strong>" + list[i].pCity + "-招领启事</strong></span>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 70px;margin-left: 20px;line-height: 23px;overflow: hidden\">\n" +
                "            <span>" + list[i].body + "</span>\n" +
                "        </div>\n" +
                "        <div style=\"width: 250px;height: 25px;margin-left: 20px;line-height: 20px;\">\n" +
                "            <div style=\"float: right;color: orangered;\">" + list[i].createTime + "</div>\n" +
                "        </div>\n" +
                "    </div>");
            $("#content").append(div);
        }
        ;
        $("#content").append($("<div style=\"clear:both;\"></div>"));
        if (data.province == "全国") {
            $("#city").remove();
            var div = $("<div style=\"width: 750px;margin-top: 10px;float: left;\" id=\"city\">\n" +
                "                <ul style=\"list-style-type: none;padding: 25px;margin-top: -20px;\" id=\"selectCity\">\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">全国</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">北京</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">上海</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">天津</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">重庆</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">河北</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">河南</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">湖北</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">湖南</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">江苏</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">江西</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">辽宁</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">吉林</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">黑龙江</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">陕西</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">山东</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">山西</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">四川</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">青海</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">安徽</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">海南</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">广东</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">贵州</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">浙江</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">福建</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">甘肃</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">云南</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">宁夏</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">广西</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">新疆</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">西藏</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">内蒙古</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">香港</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">澳门</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">台湾</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">其他</font></li>\n" +
                "                </ul>\n" +
                "            </div>");
            $("#filter").append(div);
        }
        ;
        if (data.province == "广东") {
            $("#city").remove();
            var div = $("<div style=\"width: 750px;margin-top: 10px;float: left;\" id=\"city\">\n" +
                "                <ul style=\"list-style-type: none;padding: 25px;margin-top: -20px;\" id=\"selectCity\">\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">广州</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">东莞</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">深圳</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">佛山</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">汕头</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">汕尾</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">揭阳</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">茂名</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">江门</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">惠州</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">清远</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">肇庆</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">湛江</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">四会</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">阳江</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">中山</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">珠海</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">潮州</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">梅州</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">河源</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">吴川</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">南山</font></li>\n" +
                "                    <li style=\"float:left;width:70px;height:23px;line-height:23px\"><font color=\"black\" style=\"cursor: pointer\">南州</font></li>\n" +
                "                </ul>\n" +
                "            </div>");
            $("#filter").append(div);
        }
        ;
        $("#content").append($("<div style=\"clear:both;\"></div>"));
        //设置隐藏当前页
        $("#hiddenPage").val(data.currentPage);
        //设置隐藏总页数
        $("#pageCount").val(data.pageCount);

        //点击选择市
        $("#selectCity li font").click(function () {
            //如果省份是全国
            if ($("#select").html() == "全国") {
                //省份
                var province = $(this).html();
                $("#select").html($(this).html());
                $.ajax({
                    //请求地址
                    url: "http://localhost:8080/lostandfound/provinceController/getList3",
                    //提交方式
                    type: "POST",
                    //规定请求参数的数据类型为json格式，数据不能为对象
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({"currentPage": 1, "province": province}),
                    //响应的数据类型
                    dataType: "JSON",
                    success: function (data) {
                        page1(data);
                        $("select option:eq(0)").attr("selected", "selected");
                        $("#word").val("");
                        $("#currentPage").val(1);
                    }
                });
            } else {
                //获取省份
                var province = $("#select").html();
                //获取市
                var city = $(this).html();
                $.ajax({
                    //请求地址
                    url: "http://localhost:8080/lostandfound/provinceController/getPickupList2",
                    //提交方式
                    type: "POST",
                    //规定请求参数的数据类型为json格式，数据不能为对象
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({"currentPage": 1, "province": province, "city": city}),
                    //响应的数据类型
                    dataType: "JSON",
                    success: function (data) {
                        page1(data);
                        $("#shiWuProvince").html(data.city);
                        $("select option:eq(0)").attr("selected", "selected");
                        $("#word").val("");
                        $("#currentPage").val(1);
                    }
                })
            }
        });
    }

    //起始页
    $.ajax({
        //请求地址
        url: "http://localhost:8080/lostandfound/provinceController/getPickupList1",
        //提交方式
        type: "POST",
        //规定请求参数的数据类型为json格式，数据不能为对象
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify({"currentPage": 1, "province": $("#select").html()}),
        //响应的数据类型
        dataType: "JSON",
        success: function (data) {
            page1(data);
            if (data.pageCount == 1) {
                $("#last").css("display", "none");
                $("#next").css("display", "none");
            } else {
                $("#last").css("display", "block");
                $("#next").css("display", "block");
            }
            ;
            //首页进入时隐藏上一页
            $("#last").css("display", "none");
        }
    });

    //选择省份
    $("#selectPro li font").click(function () {
        $("#select").html($(this).html());
        $.ajax({
            //请求地址
            url: "http://localhost:8080/lostandfound/provinceController/getList3",
            //提交方式
            type: "POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({"currentPage": 1, "province": $(this).html()}),
            //响应的数据类型
            dataType: "JSON",
            success: function (data) {
                page1(data);
                $("select option:eq(0)").attr("selected", "selected");
                $("#word").val("");
                $("#currentPage").val(1);
                $("#hiddenCity").css("display","none");
            }
        });
    });

    //点击首页
    $("#first").click(function () {
        //跳转框设置值
        $("#currentPage").val(1);
        //表示没选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getList4",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": 1, "province": province}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    $("#last").css("display", "none");

                    if (data.pageCount > 1) {
                        console.log(data.pageCount);
                        $("#next").css("display", "block");
                    }
                    $("#hiddenPage").val(data.currentPage);
                }
            });
        } else {
            //获取市
            var city = $("#shiWuProvince").html();
            //获取省份
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getPickupList3",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": 1, "province": province, "city": city}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    $("#last").css("display", "none");
                    if (data.pageCount > 1) {
                        $("#next").css("display", "block");
                    }
                    $("#hiddenPage").val(data.currentPage);
                }
            })
        }
    });

    //点击下一页
    $("#next").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#hiddenPage").val() * 1 + 1);
        //表示没选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getList4",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": $("#hiddenPage").val() * 1 + 1, "province": province}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    //点击下一页后的当前页等于总页数
                    if (data.currentPage == data.pageCount) {
                        $("#next").css("display", "none");
                    }
                    $("#last").css("display", "block");
                    $("#hiddenPage").val(data.currentPage);
                    $("#currentPage").val(data.currentPage);
                }
            });
        } else {
            //获取市
            var city = $("#shiWuProvince").html();
            //获取省份
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getPickupList3",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({
                    "currentPage": $("#hiddenPage").val() * 1 + 1,
                    "province": province,
                    "city": city
                }),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    //点击下一页后的当前页等于总页数
                    if (data.currentPage == data.pageCount) {
                        $("#next").css("display", "none");
                    }
                    $("#last").css("display", "block");
                    $("#hiddenPage").val(data.currentPage);
                    $("#currentPage").val(data.currentPage);
                }
            })
        }
    });

    //点击生上一页
    $("#last").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#hiddenPage").val() * 1 - 1);
        //表示没选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getList4",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": $("#hiddenPage").val() * 1 - 1, "province": province}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    //点击上一页后的当前页等于1
                    if (data.currentPage == 1) {
                        $("#last").css("display", "none");
                    }
                    $("#next").css("display", "block");
                    $("#hiddenPage").val(data.currentPage);
                    $("#currentPage").val(data.currentPage);
                }
            });
        } else {
            //获取市
            var city = $("#shiWuProvince").html();
            //获取省份
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getPickupList3",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({
                    "currentPage": $("#hiddenPage").val() * 1 - 1,
                    "province": province,
                    "city": city
                }),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    //点击上一页后的当前页等于1
                    if (data.currentPage == 1) {
                        $("#last").css("display", "none");
                    }
                    $("#next").css("display", "block");
                    $("#hiddenPage").val(data.currentPage);
                    $("#currentPage").val(data.currentPage);
                }
            })
        }
    });

    //点击尾页
    $("#end").click(function () {
        //跳转框设置值
        $("#currentPage").val($("#pageCount").val());
        //表示没选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getList4",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": $("#pageCount").val(), "province": province}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    if (data.pageCount == 1) {
                        $("#next").css("display", "none");
                        $("#last").css("display", "none");
                    } else {
                        $("#next").css("display", "none");
                        $("#last").css("display", "block");
                    }
                    $("#hiddenPage").val(data.currentPage);
                }
            });
        } else {
            //获取市
            var city = $("#shiWuProvince").html();
            //获取省份
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getPickupList3",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": $("#pageCount").val(), "province": province, "city": city}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    if (data.pageCount == 1) {
                        $("#next").css("display", "none");
                        $("#last").css("display", "none");
                    } else {
                        $("#next").css("display", "none");
                        $("#last").css("display", "block");
                    }
                    $("#hiddenPage").val(data.currentPage);
                }
            })
        }
    });

    //跳转
    $("#jump").click(function () {
        var currentPage;
        if ($("#currentPage").val() <= 1) {
            currentPage = 1;
        } else if ($("#currentPage").val() >= $("#pageCount").val()) {
            currentPage = $("#pageCount").val();
        } else if (typeof ($("#currentPage").val()) == 'string') {
            currentPage = 1;
        } else {
            currentPage = $("#currentPage").val();
        }
        //表示没选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getList4",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": currentPage, "province": province}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    if (data.currentPage == data.pageCount) {
                        $("#next").css("display", "none");
                        $("#last").css("display", "block");
                    }
                    if (data.currentPage == 1) {
                        $("#last").css("display", "none");
                    }
                    $("#hiddenPage").val(data.currentPage);
                    $("#currentPage").val(data.currentPage);
                }
            });
        } else {
            //获取市
            var city = $("#shiWuProvince").html();
            //获取省份
            var province = $("#select").html();
            $.ajax({
                //请求地址
                url: "http://localhost:8080/lostandfound/provinceController/getPickupList3",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": currentPage, "province": province, "city": city}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    if (data.currentPage == data.pageCount) {
                        $("#next").css("display", "none");
                        $("#last").css("display", "block");
                    }
                    if (data.currentPage == 1) {
                        $("#last").css("display", "none");
                    }
                    $("#hiddenPage").val(data.currentPage);
                    $("#currentPage").val(data.currentPage);
                }
            })
        }
        ;
    });


    //搜索框
    $("#searchContext").click(function () {
        //内容
        var context = $("#information").val();
        //省份
        var province = $("#select").html();
        $.ajax({
            url: "http://localhost:8080/lostandfound/searchController/search2",
            //提交方式
            type: "POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({"currentPage": 1, "province": $("#select").html(), "context": context}),
            //响应的数据类型
            dataType: "JSON",
            success: function (data) {
                page1(data);
                $("#currentPage").val(1);
                var findText = $("#content").html().split(context);
                $("#content").html(findText.join("<font style='color: orangered;font-weight: 700;'>" + context + "</font>"));
            }
        });
    });

    //快速筛选栏选择物品类型
    $("#selectType").change(function () {
        debugger;
        //获取类型
        var type = $(this).val();
        if (type == "请选择") {
            return;
        }
        //表示没有选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            //获取省份
            var province = $("#select").html();
            $.ajax({
                url: "http://localhost:8080/lostandfound/searchController/search4",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": 1, "province": province, "type": type}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    $("#currentPage").val(1);
                }
            });
        } else {
            //获取市
            var city = $("#shiWuProvince").html();
            $.ajax({
                url: "http://localhost:8080/lostandfound/searchController/search6",
                //提交方式
                type: "POST",
                //规定请求参数的数据类型为json格式，数据不能为对象
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({"currentPage": 1, "city": city, "type": type}),
                //响应的数据类型
                dataType: "JSON",
                success: function (data) {
                    page1(data);
                    $("#shiWuProvince").html(data.city);
                    $("#currentPage").val(1);
                }
            });
        }
    });

    //快速筛选框进行关键字搜索
    $("#searchWord").click(function () {
        //关键字
        var context = $("#word").val();
        //获取类型
        var type = $("#selectType").val();
        //表示没有选择市
        if ($("#select").html() == $("#shiWuProvince").html()) {
            //获取省份
            var province = $("#select").html();
            //没有选择类型
            if (type == "请选择") {
                $.ajax({
                    url: "http://localhost:8080/lostandfound/searchController/search2",
                    //提交方式
                    type: "POST",
                    //规定请求参数的数据类型为json格式，数据不能为对象
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({"currentPage": 1, "province": province, "context": context}),
                    //响应的数据类型
                    dataType: "JSON",
                    success: function (data) {
                        page1(data);
                        $("#currentPage").val(1);
                        var findText = $("#content").html().split(context);
                        $("#content").html(findText.join("<font style='color: orangered;font-weight: 700;'>" + context + "</font>"));
                    }
                });
                //没有选择市但是选择了类型（传递省，类型，关键字和当前页）
            } else {
                $.ajax({
                    url: "http://localhost:8080/lostandfound/searchController/search8",
                    //提交方式
                    type: "POST",
                    //规定请求参数的数据类型为json格式，数据不能为对象
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({"currentPage": 1, "province": province, "context": context, "type": type}),
                    //响应的数据类型
                    dataType: "JSON",
                    success: function (data) {
                        page1(data);
                        $("#currentPage").val(1);
                        var findText = $("#content").html().split(context);
                        $("#content").html(findText.join("<font style='color: orangered;font-weight: 700;'>" + context + "</font>"));
                    }
                })
            }
            //选择了市
        } else {
            //获取市
            var city = $("#shiWuProvince").html()
            //没有选择类型（市，关键字，当前页）
            if (type == "请选择") {
                $.ajax({
                    url: "http://localhost:8080/lostandfound/searchController/search10",
                    //提交方式
                    type: "POST",
                    //规定请求参数的数据类型为json格式，数据不能为对象
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({"currentPage": 1, "city": city, "context": context}),
                    //响应的数据类型
                    dataType: "JSON",
                    success: function (data) {
                        page1(data);
                        $("#shiWuProvince").html(data.city);
                        $("#currentPage").val(1);
                        var findText = $("#content").html().split(context);
                        $("#content").html(findText.join("<font style='color: orangered;font-weight: 700;'>" + context + "</font>"));
                    }
                })
                //选择了市也选择了类型（传市，类型，关键字，当前页）
            } else {
                $.ajax({
                    url: "http://localhost:8080/lostandfound/searchController/search12",
                    //提交方式
                    type: "POST",
                    //规定请求参数的数据类型为json格式，数据不能为对象
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({"currentPage": 1, "city": city, "context": context, "type": type}),
                    //响应的数据类型
                    dataType: "JSON",
                    success: function (data) {
                        page1(data);
                        $("#shiWuProvince").html(data.city);
                        $("#currentPage").val(1);
                        var findText = $("#content").html().split(context);
                        $("#content").html(findText.join("<font style='color: orangered;font-weight: 700;'>" + context + "</font>"));
                    }
                })
            }
        }
    });

    //点击帖子
    $(document).on("click", ".content", function () {
        var pMsgId = $(this).find("input").val();
        console.log(pMsgId);
        $.ajax({
            url: "http://localhost:8080/lostandfound/searchController/search14",
            //提交方式
            type: "POST",
            //规定请求参数的数据类型为json格式，数据不能为对象
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({"pMsgId": pMsgId}),
            //响应的数据类型
            dataType: "JSON",
            success: function () {
                location.href = "pickup.html";
            }
        })
    });

//打印格言
    $("#tips").html(getDictumin())

    //判断是否登录
    $.ajax("http://localhost:8080/lostandfound/user/getUser", {
        type: "POST",
        dataType: "JSON",
        success: function (msg) {
            if (msg != null) {
                $("#uName").html(msg.uName);
                $("#ucen1").css("display", "block");
                $("#ucen2").css("display", "block");
                $("#lout").css("display", "block");
                $("#lgin").css("display", "none")
            }
        }
    })

    //注销账号
    $("#logout").click(function () {
        $.ajax("http://localhost:8080/lostandfound/user/logout", {
            type: "POST",
            dataType: "JSON",
            success: function (msg) {
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