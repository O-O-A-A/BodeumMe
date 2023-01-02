$(document).ready(function () {
    $('.category-select,.category-budget').on('click', function () {
        do_modal(this)
    });
})


function check() {
    $('input[type=checkbox]').on("click", function () {
        let count = $('input:checked[type="checkbox"]').length;
        if (count > 5) {
            $(this).prop("checked", false);
            alert("5개 까지만 선택할 수 있습니다.");
        }
    })
}


function go(e) {
    e.preventDefault();
    if ($('input[type=checkbox]:checked').length) {
        input_category = [];
        $('input[type=checkbox]:checked').each(function (index, iVal) {
                input_category.push(iVal.value);
            }
        )
    }
    if ($('input[type=radio]:checked').length) {
        input_budget = $('input[type=radio]:checked')[0]?.value;
    }
    if (input_category.length === 0 && input_budget === 999999999) {
        alert("1개 이상 체크해 주세요");
        return;
    }
    $($('.modal').siblings()[0]).data("modal", "not-expand");
    $('.modal').remove();
    location.href = `/post/sort?category=${input_category.join(',')}&budget=${input_budget}`
}


function do_modal(target) {
    if ($(target).data("modal") === "not-expand") {
        $($('.modal')?.siblings()[0])?.data("modal", "not-expand");
        $('.modal')?.remove();
        $(target.parentNode).append(what_modal[target.className])
        $(target).data("modal", "expand");
    } else {
        $('.modal').remove();
        $(target).data("modal", "not-expand");
    }
}

const select =
    `
        <li class="li"><label for="babysitter">베이비시터</label><input type="checkbox" id="babysitter" name="select" class="babysitter" value="베이비시터"> </li>
        <li class="li"><label for="housework">육아+가사</label><input type="checkbox" id="housework" name="select" class="housework" value="육아+가사"></li>
        <li class="li"><label for="school-helper">등하원도우미</label><input type="checkbox" id="school-helper" name="select" class="school-helper" value="등하원도우미"></li>
        <li class="li"><label for="learning">학습시터</label><input type="checkbox" id="learning" name="select" class="learning" value="학습시터"></li>
        <li class="li"><label for="play">놀이시터</label><input type="checkbox" id="play" name="select" class="play" value="놀이시터"></li>
        <li class="li"><label for="resident">입주베이비시터</label><input type="checkbox" id="resident" name="select" class="resident" value="입주베이비시터"></li>
        <li class="li"><label for="postpartum">산후도우미</label><input type="checkbox" id="postpartum" name="select" class="postpartum" value="산후도우미"></li>
        <li class="li"><label for="housekeeper">가사도우미</label><input type="checkbox" id="housekeeper" name="select" class="housekeeper" value="가사도우미"></li>
        <li class="li"><label for="cleaning">청소도우미</label><input type="checkbox" id="cleaning" name="select" class="cleaning" value="청소도우미"></li>
        <li class="li"><label for="resident-housekeeper">입주가사도우미</label><input type="checkbox" id="resident-housekeeper" name="select" class="resident-housekeeper" value="입주가사도우미"></li>
        <li class="li"><label for="food">음식도우미</label><input type="checkbox" id="food" name="select" class="food" value="음식도우미"></li>
    `
const budget =
    `
        <li class="li"><label for="pay-999999999">전체</label><input type="radio" id="pay-999999999" name="pay" class="pay-999999999" value="999999999" checked></li>
        <li class="li"><label for="pay-10000">10000 이하</label><input type="radio" id="pay-10000" name="pay" class="pay-10000" value="10000"></li>
        <li class="li"><label for="pay-11000">11000 이하</label><input type="radio" id="pay-11000" name="pay" class="pay-11000" value="11000"></li>
        <li class="li"><label for="pay-12000">12000 이하</label><input type="radio" id="pay-12000" name="pay" class="pay-12000" value="12000"></li>
        <li class="li"><label for="pay-13000">13000 이하</label><input type="radio" id="pay-13000" name="pay" class="pay-13000" value="13000"></li>
        <li class="li"><label for="pay-14000">14000 이하</label><input type="radio" id="pay-14000" name="pay" class="pay-14000" value="14000"></li>
        <li class="li"><label for="pay-150000">15000 이하</label><input type="radio" id="pay-150000" name="pay" class="pay-150000" value="15000"></li>
    `

const modal = what =>
    `
    <div class="modal"
            style="position: absolute; border: 3px solid #000; width: 200px; height: 429px; background-color: #0a4faa; z-index: 9999">
       <form method="get" onchange="check()">
           <div>
               <ul>
                   ${what}
               </ul>
           </div>
            <button id="btn-send-search-info" value="check" onclick="go(event)">확인</button>
       </form>
    </div>
    `

const what_modal = {'category-select': modal(select), 'category-budget': modal(budget)};
