const eyes = $(".bi-eye");

$(document).ready(() => {
    console.log(eyes);
    eyes.hover(function () {
        $(this).toggleClass("bi-eye").toggleClass("bi-eye-fill");
    });
});