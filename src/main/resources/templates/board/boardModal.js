$(document).ready(function () {
    $('.category-select .category-label').on({
        click : function () {
            console.log(this);
            do_modal(this.parent());
        }
    });
    $('#btn-send-search-info').on('click', function () {
        $('.modal').fadeOut();
        $(this).data("modal", "false");
    })
    $('.category-budget>.category-label').on('click', function () {
        if ($(this).data("modal") === "true") {
            $('.modal2').fadeOut();
            $(this).data("modal", "false");
        } else {
            $('.modal2').fadeIn();
            $(this).data("modal", "true");
        }
    });
    $('#btn-send-search-info2').on('click', function () {
        $('.modal2').fadeOut();
        $(this).data("modal", "false");
    })
})


function do_modal(target){
    console.log(target);
    if ($(target).data("modal") === "true") {
        $('.modal').fadeOut();
        $(target).data("modal", "false");
    } else {
        $('.modal').fadeIn();
        $(target).data("modal", "true");
    }
}


const modal = `
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
`