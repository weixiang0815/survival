const codeURL = "http://localhost:8080/Survival/front/api/getTerms/signup";
const signupURL = "http://localhost:8080/Survival/front/api/competition/signup/new"
const checkURL = "http://localhost:8080/Survival/front/api/competition/signup/check/";
const codeOfConduct = $("#codeOfConduct");
const thinkaboutit = $("#thinkaboutit");
const submitBtn = $("#submitBtn");
const signupResult = $("#signupResult");
const checkResult = $("#checkResult");
const inputs = [
    $("#playerId"),
    $("#competitionId"),
    $("input[name='status']")
];

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
            codeOfConduct.html(res);
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
    if (inputs[1].val()){
        $.ajax({
            url: checkURL + inputs[0].val() + "/" + inputs[1].val(),
            method: "get",
            success: function (res) {
                console.log(res);
                submitBtn.attr("disabled", res);
                if (res) {
                    checkResult.text("您已報名過此活動，請改選其它活動喔！");
                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    ;}
    thinkaboutit.on({
        mouseenter: () => {
            thinkaboutit.text("顯示所有活動");
        },
        mouseleave: () => {
            thinkaboutit.text("再讓我想一下");
        },
        click: e => {
            e.preventDefault();
            window.location = "http://localhost:8080/Survival/front/competition/show";
        }
    });
    inputs[1].on({
        change: () => {
            $.ajax({
                url: checkURL + inputs[0].val() + "/" + inputs[1].val(),
                method: "get",
                success: function (res) {
                    console.log(res);
                    submitBtn.attr("disabled", res);
                    if (res) {
                        checkResult.text("您已報名過此活動，請改選其它活動喔！");
                    }
                },
                error: function (err) {
                    console.log(err);
                }
            })
        }
    });
});