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
const oneclickBtn = $("button.oneclick");
const singleCheck = document.getElementById("single");
const crewCheck = document.getElementById("crew");
const publishCheck = document.getElementById("publish");
const notPublishCheck = document.getElementById("notPublish");
const content = watchdog.editor;
const lastEdited = $("#lastEdited");
let newFormId;
let firstPartId;
let secondPartId;
let thirdPartId;

$(document).ready(function () {
    $("#startDate").datepicker({
        dateFormat: "yy-mm-dd",
        onSelect: function (date) {
            $("#endDate").datepicker("option", "minDate", date);
            updateFormData();
        }
    });
    $("#endDate").datepicker({
        dateFormat: "yy-mm-dd",
        onSelect: function (date) {
            $("#startDate").datepicker("option", "maxDate", date);
            updateFormData();
        }
    });
    console.log(formInputs);
    let obj = { "creatorId": creatorId.text(), "creatorType": creatorType.text() };
    let objString = JSON.stringify(obj);
    axios.post(retrieveFromURL, objString, {
        headers: { 'Content-Type': 'application/json' }
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
    oneclickBtn.on('click', function (e) {
        e.preventDefault();
        $("#mandarinName").val('奪寶冒險：尋找失落的寶藏');
        $("#englishName").val('Hunt Adventure: Lost Treasure');
        $("#startDate").val('2023-03-22');
        $("#startTimespan").val(1);
        $("#endDate").val('2023-03-31');
        $("#endTimespan").val(1);
        $("[name='status']").filter("#publish").attr('checked', true);
        $("[name='singleOrCrew']").filter('#single').attr('checked', true);
        $("#placeId").val(6);
        $("#capacity").val(100)
        $("#budget").val(50000);
        $("#fee").val(6000);

        let str = `<h1>你是否曾經夢想過成為一名尋寶者，踏上冒險之旅，尋找傳說中失落已久的寶藏呢？</h1>
        
        <p>現在，這個夢想可以實現了！我們公司即將舉辦一場「奪寶冒險：尋找失落的寶藏」活動，帶您穿越叢林、荒漠、山洞等各種挑戰，展開一場驚險刺激的尋寶之旅！</p>

        <p>這次的尋寶活動不僅考驗您的勇氣、智慧與反應能力，同時也讓您體驗到探險家的冒險精神。在活動中，您需要使用探測器、地圖、指南針等工具，找尋尋寶的線索和寶藏所在地。在尋寶的過程中，您將克服各種障礙，如沼澤、陡峭的山嶺、岩洞和神秘的密室等等。當您終於找到寶藏所在地時，還需要解開陷阱和謎題，才能成功奪取寶藏！</p>
        
        <p>不僅如此，我們還特別設計了多個關卡，如射箭、攀岩、水上競技等，讓您在尋寶的過程中挑戰自我，激發潛力。此外，我們還為所有參加者準備了豐富的獎勵，包括寶藏、金幣、寶石等，讓您感受到探險家的成就感和豐厚的報酬。</p>
        
        <p>「奪寶冒險：尋找失落的寶藏」活動，是您展現勇氣、智慧和探險精神的絕佳機會。快來報名參加吧，開啟一場刺激的尋寶之旅！</p>`;

        content.setData(str);
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
                    publishCheck.checked = true;
                    notPublishCheck.checked = false;
                    break;
                case 7:
                    singleCheck.checked = true;
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
function insertValues(values) {
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
        headers: { "Content-Type": "application/json" }
    }).then(res => {
        let lastEditedTime = "上次儲存：" + res.data;
        lastEdited.text(lastEditedTime);
    }).catch(err => {
        console.log(err);
    })
}