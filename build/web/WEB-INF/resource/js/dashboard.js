$(document).ready(function () {
    if(!$.cookie('token')){
        window.location.href = 'login';
        return false;
    }
    $(".nav_wrapper").click(function () {
        var t = $(this).attr("href");
        navigateAjax(t);
        return false;
    });
    $("#table_id").DataTable({
        "paging":   false,
        "ordering": false,
        "info":     false,
        "searching":     false
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