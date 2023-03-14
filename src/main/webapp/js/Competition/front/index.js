const eyes = $(".bi-eye");

$(document).ready(() => {
    eyes.hover(function () {
        $(this).toggleClass("bi-eye").toggleClass("bi-eye-fill");
    });
});