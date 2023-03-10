const codeURL = "http://localhost:8080/Survival/front/api/getTerms/signup";
const modalBody = $(".modal-body");
document.addEventListener("DOMContentLoaded", function () {
    let modal = new bootstrap.Modal(document.getElementById('exampleModal'), {
        backdrop: 'static',
        keyboard: false
    });
    modal.show();
    document.getElementById('modal-yes').addEventListener('click', function () {
        modal.hide();
        document.body.classList.remove('modal-open');
        document.querySelector('.modal-backdrop').remove();
    });
    $.ajax({
        url: codeURL,
        method: "get",
        success: function (res) {
            res += `<input type="checkbox" name="agreed" id="agreed" /><label for="agreed">我同意並願意遵守以上條款</label>`;
            modalBody.html(res);
            let agreed = document.getElementById("agreed");
            $("#agreed").on({
                change: function () {
                    $("#modal-yes").attr("disabled", agreed.checked ? false : true);
                }
            });
        },
        error: function (err) {
            console.log(err);
        }
    });
});