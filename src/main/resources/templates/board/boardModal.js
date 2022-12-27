$(document).ready(function () {
    $('.category-select').on('click', function(){
       $('.modal').fadeIn();
        // $('.modal').fadeOut();

    });
    $('.modal').on('click', function(){
        $('.modal').fadeOut();
    })
    $('.category-budget').on('click', function(){
        console.log("ddddddd");
    });

})
