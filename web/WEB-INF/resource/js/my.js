$(document).ready(function () {
    window.FakeLoader.init();
    if ($.cookie("token")) {
        
        return true;
    }
    $(".nav_wrapper").click(function () {
        var t = $(this).attr("href");
        navigateAjax(t);
        return false;
    });
    $("#frm-signin").on('submit', function () {
        var email = $("#email").val();
        var password = $("#password").val();
        var data = {
            email: email,
            password: password
        };
        $.ajax({
            url: "../../rest/auth/student/login",
            type: 'post',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (data) {
                if (!data.status) {
                    alert("Incorrect username / password");
                } else {

                    $.cookie("token", data.data);
                    navigateAjax("dashboard");
                }

            },
            error: function (data) {
                if(data.message){
                    alert(data.message);
                } else {
                    alert("Unknown Error");
                }
            }
        });


        return false;
    });
});

function navigateAjax(t) {
    window.FakeLoader.showOverlay();
    window.history.pushState('page2', 'Title', t);
    $.ajax({
        url: "ajax_" + t,
        cache: false,
        success: function (html) {
            $(".home").html(html);
            window.FakeLoader.hideOverlay();
        }
    });
}