$(document).ready(function () {
    $('.category-select').on('click', function(){do_modal(this)});
    $('.category-budget ').on('click', function(){do_modal(this)} );
})

$('input[tpye=checkbox]:checked').each()


function do_modal(target) {
    console.log(target)
    if ($(target).data("modal") === "not-expand") {
        $(target).append(what_modal[target.className])
        $(target).data("modal", "expand");
    } else {
        $('.modal').remove();
        $(target).data("modal", "not-expand");
    }
}
const modal1 =
    `
    <form action="" method="get">
        <div class="modal"
            style="position: absolute; border: 3px solid #000; width: 200px; height: 429px; background-color: #0a4faa; z-index: 9999">
           <div>
               <ul>
                   <li class="li"><label for="babysitter">베이비시터</label><input type="checkbox" id="babysitter" name="babysitter" class="babysitter"> </li>
                   <li class="li"><label for="housework">육아+가사</label><input type="checkbox" id="housework" name="housework" class="housework"></li>
                   <li class="li"><label for="school-helper">등하원도우미</label><input type="checkbox" id="school-helper" name="school-helper" class="school-helper"></li>
                   <li class="li"><label for="learning">학습시터</label><input type="checkbox" id="learning" name="learning" class="learning"></li>
                   <li class="li"><label for="play">놀이시터</label><input type="checkbox" id="play" name="play" class="play"></li>
                   <li class="li"><label for="resident">입주베이비시터</label><input type="checkbox" id="resident" name="resident" class="resident"></li>
                   <li class="li"><label for="postpartum">산후도우미</label><input type="checkbox" id="postpartum" name="postpartum" class="postpartum"></li>
                   <li class="li"><label for="housekeeper">가사도우미</label><input type="checkbox" id="housekeeper" name="housekeeper" class="housekeeper"></li>
                   <li class="li"><label for="cleaning">청소도우미</label><input type="checkbox" id="cleaning" name="cleaning" class="cleaning"></li>
                   <li class="li"><label for="resident-housekeeper">입주가사도우미</label><input type="checkbox" id="resident-housekeeper" name="resident-housekeeper" class="resident-housekeeper"></li>
                   <li class="li"><label for="food">음식도우미</label><input type="checkbox" id="food" name="food" class="food"></li>
               </ul>
           </div>
            <button id="btn-send-search-info" value="check">확인</button>
        </div>
    </form>
    `
const modal2 =
    `
<form action="" method="get">
      <div class="modal"
           style="position: absolute; border: 3px solid #000; width: 200px; height: 429px; background-color: #0a4faa; z-index: 9999">
          <div>
              <ul>
                  <li class="li"><label for="pay-10000">10000</label><input type="checkbox" id="pay-10000" name="pay-10000" class="pay-10000"></li>
                  <li class="li"><label for="pay-11000">11000</label><input type="checkbox" id="pay-11000" name="pay-11000" class="pay-11000"></li>
                  <li class="li"><label for="pay-12000">12000</label><input type="checkbox" id="pay-12000" name="pay-12000" class="pay-12000"></li>
                  <li class="li"><label for="pay-13000">13000</label><input type="checkbox" id="pay-13000" name="pay-13000" class="pay-13000"></li>
                  <li class="li"><label for="pay-14000">14000</label><input type="checkbox" id="pay-14000" name="pay-14000" class="pay-14000"></li>
                  <li class="li"><label for="pay-150000">15000</label><input type="checkbox" id="pay-150000" name="pay-150000" class="pay-150000"></li>
                  <li class="li"><label for="pay-over-15000">15000~</label><input type="checkbox" id="pay-over-15000" name="pay-over-15000" class="pay-over-15000"></li>
              </ul>
          </div>
          <button id="btn-send-search-info2" value="check">확인</button>
      </div>
      </form>
    `
const what_modal = {'category-select' : modal1, 'category-budget' : modal2 };
