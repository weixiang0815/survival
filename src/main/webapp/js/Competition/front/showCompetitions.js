const inputs = [
    $("#name"),
    $("input[name='place']"),
    $("input[name='date']"),
    $("input[name='singleOrCrew']"),
    $("input[name='fee']"),
    $("input[name='capacity']"),
];
const tbody = document.getElementById("tbody");
const scriptRegex = /(<script\b[^>]*>)([\s\S]*?)(<\/script>)/gi;
const sqlRegex = /(select|insert|update|delete|union|into|load_file)/gi;

$(document).ready(() => {
    formatDate();
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
        console.log("讀到惡意程式");
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
        url: "http://localhost:8080/Survival/front/api/competition/multiCondition",
        method: "post",
        data: JSON.stringify(obj),
        contentType: "application/json;charset:UTF-8",
        success: function (res) {
            console.log(res);
            htmlMaker(res);
            formatDate();
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function htmlMaker(comps) {
    let str = ``;
    if (comps == null || comps.length == 0) {
        str += `<tr><td colspan="8">查無資料</td></tr>`;
    } else {
        comps.forEach(comp => {
            str += `<tr>`;
            str += `<td><a href="http://localhost:8080/Survival/front/competition/detail/${comp.id}">${comp.mandarinName}</a></td>`;
            str += `<td><a href="http://localhost:8080/Survival/front/competition/detail/${comp.id}">${comp.englishName}</a></td>`;
            str += `<td>${comp.place.place_name}</td>`;
            str += `<td class="compDate">${comp.startDate}</td>`;
            str += `<td class="compDate">${comp.endDate}</td>`;
            if (comp.singleOrCrew == "S") {
                str += `<td>單人戰</td>`;
            } else if (comp.singleOrCrew == "C") {
                str += `<td>團體戰</td>`;
            } else {
                str += `<td>未定</td>`;
            }
            str += `<td>$&nbsp;${comp.fee}</td>`;
            str += `<td>${comp.capacity}&nbsp;人</td>`;
            str += `</tr>`;
        });
    }
    tbody.innerHTML = str;
}

function formatDate() {
    let dates = document.querySelectorAll(".compDate");
    dates.forEach(date => {
        let date_str = date.innerHTML;
        let date_parts = date_str.split("-");
        let year = parseInt(date_parts[0]);
        let month = parseInt(date_parts[1]);
        let day = parseInt(date_parts[2]);
        let date_formatted = `${year}年${month}月${day}日`;
        date.innerHTML = date_formatted;
    })
}