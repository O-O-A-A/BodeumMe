$(document).ready(function () {
    for(let i=0;i<10;i++) {
        $(".ul01").append(`
        <li class="li01">
            <a href="#">
                <span class="tab01">
                    <span class="img01"><img src="../../images/common/icon_profile_basic.svg " class="horizontal"></span>
                    <span class="text01">영아</span>
                </span>
                <span class="tab02">
                    <span class="sphere"> 육아+가사<span class="edit_date">6분전</span></span>
                    <span class="subject">육아와 가사에 도움 주실 성실하신 분 기다립니다!</span>
                    <span class="area">서울 성동구 금호동4가</span>
                    <span class="pay"><img src="../../images/common/icon_search_sphere.svg" class="icon_won">월급 2,400,000 <span class="bar0101">&nbsp;</span> <span class="working_time">09:00 ~ 18:00</span></span>
                </span>
                <div class="bar01"></div>
                <span class="tab03">
                    <span class="text01">정기근무</span>
                </span>
            </a>
            <span class="follow01" id="follow35812" data-val="" data-code=""><span class="heart01">&nbsp;</span></span>
</li>
    `)
    }
})