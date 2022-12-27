$(document).ready(function () {
    $('.category-select > .category-label').on('click', function(){
        if($(this).data("modal") === "true"){
            $('.modal').fadeOut();
            $(this).data("modal","false");
        }
        else{
            $('.modal').fadeIn();
            $(this).data("modal","true");
            console.log($(this).data("modal"))
        }
        // $('.modal').fadeOut();

    });
    $('.modal').on('click', function(){

    })
    $('.category-budget').on('click', function(){
        console.log("ddddddd");
    });

})
