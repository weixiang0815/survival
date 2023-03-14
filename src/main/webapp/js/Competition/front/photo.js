const inputs = [
    $("#name"),
    $("input[name='place']"),
    $("input[name='date']"),
    $("input[name='singleOrCrew']"),
    $("input[name='fee']"),
    $("input[name='capacity']"),
];
const scriptRegex = /(<script\b[^>]*>)([\s\S]*?)(<\/script>)/gi;
const sqlRegex = /(select|insert|update|delete|union|into|load_file)/gi;
const collections = $("#collections");

$("document").ready(function () {
    inputs.forEach(input => {
        input.on({
            change: multiConditionSearch
        });
    })
});

function multiConditionSearch() {
    let obj = {};
    let name_input = inputs[0].val();
    if (!scriptRegex.test(name_input) && !sqlRegex.test(name_input)) {
        console.log(name_input)
        obj["mandarinName"] = name_input;
        obj["englishName"] = name_input;
    } else {
        alert("讀到惡意程式");
        if (scriptRegex.test(name_input)) {
            alert("讀到 XSS 惡意程式");
        }
        if (sqlRegex.test(name_input)) {
            alert("讀到 SQL Injection 惡意程式");
        }
    }
    for (let i = 1; i < 5; i++) {
        let checked = inputs[i].filter(":checked");
        let arr = new Array();
        let key = inputs[i].attr("name");
        $.each(checked, function (index, el) {
            console.log(el.value);
            arr.push(el.value);
        });
        obj[key] = arr;
    }
    console.log(obj);
    console.log(JSON.stringify(obj));
    $.ajax({
        url: "http://localhost:8080/Survival/front/api/competition/photo/multi-condition",
        method: "post",
        data: JSON.stringify(obj),
        contentType: "application/json;charset:UTF-8",
        success: function (res) {
            console.log(res);
            htmlMaker(res);
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function htmlMaker(list) {
    let str = ``;
    $.each(list, function (index, dto) {
        str += `<div class="col-3">`;
        str += `<div class="row text-center">`;
        str += `<a title="點擊查看活動詳情" href="http://localhost:8080/Survival/front/competition/detail/${dto.compId}"><h4>${dto.compName}</h4></a>`;
        str += `</div>`;
        str += `<div class="row pt-3 pb-3 collection d-flex align-items-stretch">`;
        $.each(dto.picSet, function (index, pic) {
            str += `<div class="col-4">`;
            str += `<a href="http://localhost:8080/Survival/front/api/competition/photo/${pic.id}">`;
            str += `<img class="img-fluid" alt="Image ${pic.id}" src="http://localhost:8080/Survival/front/api/competition/photo/${pic.id}">`;
            str += `</a>`;
            str += `</div>`;
        });
        str += `</div></div>`;
        collections.html(str);
    });
}
