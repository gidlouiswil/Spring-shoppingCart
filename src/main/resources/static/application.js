$(function(){


    setInterval(ajaxFunction, 1000);
});

function ajaxFunction() {
    $.ajax({
        url : '/ajax',
        success : function(data) {
            $('#result').html(data);
        }
    });
}