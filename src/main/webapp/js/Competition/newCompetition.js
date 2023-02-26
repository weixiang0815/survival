const creatorId = $("#creatorId");
const creatorType = $("#creatorType");
const retrieveFromURL = "http://localhost:8080/Survival/competition/api/create/newForm/getlatest";
const updateFormURL = "http://localhost:8080/Survival/competition/api/create/update";
const form = $("#competition");
const formInputs = [
    $("#mandarinName"),
    $("#englishName"),
    $("#startDate"),
    $("#startTimespan"),
    $("#endDate"),
    $("#endTimespan"),
    $("[name='status']"),
    $("[name='singleOrCrew']"),
    $("#placeId"),
    $("#capacity"),
    $("#budget"),
    $("#fee"),
]
const resetBtn = $("button[type='reset']");
const singleCheck = document.getElementById("single");
const crewCheck = document.getElementById("crew");
const publishCheck = document.getElementById("publish");
const notPublishCheck = document.getElementById("notPublish");
const content = watchdog.editor;
let newFormId;
let firstPartId;
let secondPartId;
let thirdPartId;
$(document).ready(function() {
    $("#startDate").datepicker({
        dateFormat : "yy-mm-dd",
        onSelect : function(date) {
            $("#endDate").datepicker("option", "minDate", date);
            updateFormData();
        }
    });
    $("#endDate").datepicker({
        dateFormat : "yy-mm-dd",
        onSelect : function(date) {
            $("#startDate").datepicker("option", "maxDate", date);
            updateFormData();
        }
    });
    console.log(formInputs);
    let obj = {"creatorId": creatorId.text(), "creatorType": creatorType.text()};
    let objString = JSON.stringify(obj);
    axios.post(retrieveFromURL, objString, {
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        console.log(res.data);
        insertValues(res.data);
    }).catch(err => {
        console.log(err);
    });
    formInputs.forEach(el => {
        el.on({
            change: function () {
                //	要將 reset 按鈕與更新資料庫功能同步
                updateFormData();
            },
        });
    });
    content.model.document.on('change', function () {
        updateFormData();
    });
    resetBtn.on('click', function () {
        for (let i = 0; i < formInputs.length; i++) {
            switch (i) {
                case 3:
                    formInputs[i].val(1);
                    break;
                case 5:
                    formInputs[i].val(1);
                    break;
                case 6:
                    publishCheck.checked = false;
                    notPublishCheck.checked = false;
                    break;
                case 7:
                    singleCheck.checked = false;
                    crewCheck.checked = false;
                    break;
                default:
                    formInputs[i].val('');
                    break;
            }
        }
        content.setData('');
        updateFormData();
    });
});

// 一進畫面就填入上次的紀錄
function insertValues(values){
    newFormId = values["id"];
    let firstPart = values.firstPart;
    firstPartId = firstPart.id;
    for (let i = 0; i < 6; i++) {
        let id = formInputs[i].attr("id");
        let el = firstPart[id];
        if (i == 3 || i == 5) {
            formInputs[i].val(el == null ? 1 : el);
        } else {
            formInputs[i].val(el == null ? '' : el);
        }
    }
    let secondPart = values.secondPart;
    secondPartId = secondPart.id;
    for (let i = 8; i < 12; i++) {
        let id = formInputs[i].attr("id");
        let el = secondPart[id];
        if (i == 8) {
            formInputs[i].val(el == null ? 1 : el);
        } else {
            formInputs[i].val(el);
        }
    }
    if (secondPart.status == "已發布") {
        publishCheck.checked = true;
    } else if (secondPart.status == "未發布") {
        notPublishCheck.checked = true;
    }
    if (secondPart.singleOrCrew == "S") {
        singleCheck.checked = true;
    } else if (secondPart.singleOrCrew == "C") {
        crewCheck.checked = true;
    }
    let thirdPart = values.thirdPart;
    thirdPartId = thirdPart.id;
    if (thirdPart.content != null) {
        content.setData(thirdPart.content);
    }
}

// 即時更新資料庫
function updateFormData() {
    let formData = {};
    formData["id"] = newFormId;
    let firstPart = {};
    firstPart["id"] = firstPartId;
    let secondPart = {};
    secondPart["id"] = secondPartId;
    let thirdPart = {};
    thirdPart["id"] = thirdPartId;
    for (let i = 0; i < 6; i++) {
        let name = formInputs[i].attr("name");
        firstPart[formInputs[i].attr("name")] = formInputs[i].val();
    }
    formData["firstPart"] = firstPart;
    for (let i = 6; i < 12; i++) {
        let name = formInputs[i].attr("name");
        if (name == "status" || name == "singleOrCrew") {
            let checkedValue = formInputs[i].filter(":checked").val();
            secondPart[formInputs[i].attr("name")] = checkedValue ? checkedValue : "";
        } else {
            secondPart[formInputs[i].attr("name")] = formInputs[i].val();
        }
    }
    formData["secondPart"] = secondPart;
    thirdPart["content"] = content.getData();
    formData["thirdPart"] = thirdPart;
    console.log(formData);
    let jsonObj = JSON.stringify(formData);
    axios.put(updateFormURL, jsonObj, {
        headers: {"Content-Type": "application/json"}
    }).then(res => {
        console.log("上次儲存：" + res.data);
    }).catch(err => {
        console.log(err);
    })
}