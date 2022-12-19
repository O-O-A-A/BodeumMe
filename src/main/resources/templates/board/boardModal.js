$(document).ready(function() {
    $("#area_text").click(function() {
        $(".layer01").html('');
        $(".layer01").hide();
        $(".bg_modal").show();
        $("#search_layer").show();
    });

    $("#sphere_text").click(function() {
        $(".layer01").html('');
        $(".layer01").hide();
        $(".bg_modal").show();
        $("#search_layer").show();
    });

    $(".bg_modal").click(function() {
        $(".layer01").html('');
        $(".layer01").hide();
        $(".bg_modal").hide();
    });
});

function detail_search() {
    $(".layer01").html('');
    $(".layer01").hide();
    $(".bg_modal").show();
    $("#search_layer").show();
}
//2021-02-26 기본 검색 스크립트


//지역 검색 스크립트
function already_address() {
    var w_area1 = $("#psido").val();
    var w_area2 = $("#pgugun").val();
    var w_area3 = $("#pdong").val();

    if (w_area1) {
        $(".sido_area").each(function (index, item) {
            if($(this).text() == w_area1) {
                $(this).addClass("on");
            }
        });
        if(w_area2) {
            if(w_area3 == "") w_area3 = "전체";
        } else {
            w_area2 = "전체";
        }
        sido_select(w_area1, w_area2, w_area3);

    }
}

function locate_position() {
    var chk_sido = $(".sido > .on").position().top - 84;
    var chk_gugun = $(".gugun > .on").position().top - 84;
    var chk_dong = $(".dong > .on").position().top - 84;

    $(".sido").scrollTop(chk_sido);
    $(".gugun").scrollTop(chk_gugun);
    $(".dong").scrollTop(chk_dong);
}

$(document).on("click",".sido_area",function(){
    $(".sido_area").removeClass("on");
    $(this).addClass("on");

    // 선택한 값 가져오기
    var w_area1 = $(this).text();
    $("#psido").val(w_area1);
    sido_select(w_area1);
});

$(document).on("click",".gugun_area",function(){
    $(".gugun_area").removeClass("on");
    $(this).addClass("on");

    // 선택한 값 가져오기
    var w_area1 = $("#psido").val();
    var w_area2 = $(this).text();
    //시군구 선택 시 전체인경우 바로 닫고 목록 출력
    $("#area_text > .exam01").hide();
    $("#area_text > .text0101").remove();
    $("#area_text").append("<span class='text0101'>"+w_area1+" "+w_area2+"</span>");

    if(w_area2 == "전체") {
        $("#pgugun").val("");
    } else {
        $("#pgugun").val(w_area2);
    }

    search_area();

});

$(document).on("click",".dong_area",function(){
    $(".dong_area").removeClass("on");
    $(this).addClass("on");

    // 선택한 값 가져오기
    var w_area1 = $("#psido").val();
    var w_area2 = $("#pgugun").val();
    var w_area3 = $(this).text();

    if(w_area3 == "전체") {
        $("#pdong").val("");
    } else {
        $("#pdong").val(w_area3);
    }

    $("#area_text > .exam01").hide();
    $("#area_text > .text0101").remove();
    $("#area_text").append("<span class='text0101'>"+w_area1+" "+w_area2+" "+w_area3+"</span>");
    search_area();
});

function search_area() {
    $(".bg_modal").hide();
    $(".layer01").hide();

    loadlist(true);
}

function sido_select(sido, gugun, dong) {
    $.ajax({
        type:"POST",
        url:"/lib/ajax/join_sitter.process.sub.php",
        data:"sub_mode=search_gugun&w_area1=" + sido,
        dataType:"json",
        success:function(data){
            var txt = "";
            $.each(data, function(k, v) {
                if(gugun == v) {
                    txt += "<div class='gugun_area on' id='gugun_area_"+k+"'>"+v+"</div>";
                } else {
                    txt += "<div class='gugun_area' id='gugun_area_"+k+"'>"+v+"</div>";
                }
            });
            $(".gugun").html("");
            $(".gugun").append(txt);

            $(".dong").html(""); //2019-07-31 동초기화

            if(gugun && gugun != "전체") {
                gugun_select(sido, gugun, dong);
            }

        }
    });
}

function gugun_select(sido, gugun, dong) {

    $.ajax({
        type:"POST",
        url:"#",
        data:"sub_mode=search_dong&w_area1=" + sido + "&w_area2=" + gugun,
        dataType:"json",
        success:function(data){
            var txt = "";
            $.each(data, function(k, v) {
                if(dong == v) {
                    txt += "<div class='dong_area on' id='dong_area_"+k+"'>"+v+"</div>";
                } else {
                    txt += "<div class='dong_area' id='dong_area_"+k+"'>"+v+"</div>";
                }
            });
            $(".dong").html("");
            $(".dong").append(txt);

            //dong까지 처리되는 경우 기존 데이터 불러올 때 사용
            if(dong) {
                locate_position();
            }
        }
    });
}
//2021-02-26 지역검색 스크립트

//분야검색 스크립트
function already_sphere() {
    $(".r_sphere1.on").each(function (index, val) {
    });
}

$(document).on("click",".r_sphere1",function(){
    if($(this).hasClass("on") == true) {
        $(this).removeClass("on");
    } else {
        if($(".r_sphere1.on").length > 4) {
            alert('최대 5개까지만 선택 가능합니다.');
        } else {
            $(this).addClass("on");
        }
    }
    sphere_select();
});

$(document).on("click","#btn_search_sphere",function(){
    search_sphere();
});

function sphere_select() {
    $(".psphere").val('');
    if($(".r_sphere1.on").length == 0) {
    } else {
        var r_cnt = 1;
        var r_sphere = "";
        var sphere_txt = "";
        $(".r_sphere1.on").each(function (index, val) {
            r_sphere = $(this).data("val");
            $("#psphere"+r_cnt).val(r_sphere);

            if(sphere_txt) sphere_txt += ", ";
            sphere_txt += r_sphere;
            r_cnt++;
        });


        $("#sphere_text > .exam01").hide();
        $("#sphere_text > .text0101").remove();
        $("#sphere_text").append("<span class='text0101'>"+sphere_txt+"</span>");
    }
}

function search_sphere() {
    $(".bg_modal").hide();
    $(".layer01").hide();

    loadlist(true);
}
//2021-02-26 분야검색 스크립트


//상세검색 스크립트
function already_detail() {
    $(".r_week.on").each(function (index, val) {
    });
}

$(document).on("click",".r_week",function(){
    if($(this).hasClass("on") == true) {
        $(this).removeClass("on");
    } else {
        $(this).addClass("on");
    }
    detail_select_week();
});

$(document).on("click",".r_time",function(){
    if($(this).hasClass("on") == true) {
        $(this).removeClass("on");
    } else {
        $(this).addClass("on");
    }
    detail_select_time();
});

$(document).on("click",".r_vaccine",function(){
    $(".r_vaccine").removeClass("on");
    $(this).addClass("on");
    detail_select_vaccine();
});

$(document).on("click","#btn_search_detail",function(){
    search_detail();
});

function detail_select_week() {
    var week_txt = "";
    $("#pweek").val('');
    if($(".r_week.on").length == 0) {
    } else {
        $(".r_week.on").each(function (index, val) {
            if(week_txt) week_txt += ",";
            week_txt += $(this).data("val");
        });
        $("#pweek").val(week_txt);
    }
}

function detail_select_time() {
    var time_txt = "";
    $("#pworking_time").val('');
    if($(".r_time.on").length == 0) {
    } else {
        $(".r_time.on").each(function (index, val) {
            if(time_txt) time_txt += ",";
            time_txt += $(this).data("val");
        });
        $("#pworking_time").val(time_txt);
    }
}

function detail_select_vaccine() {
    var vaccine_txt = "";
    $("#pvaccine").val('');
    vaccine_txt = $(".r_vaccine.on").data("val");
    $("#pvaccine").val(vaccine_txt);
}

function search_detail() {
    $(".bg_modal").hide();
    $(".layer01").hide();

    loadlist(true);
}