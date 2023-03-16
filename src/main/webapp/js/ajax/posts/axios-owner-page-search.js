const classify = $("input[name='classify']")
const nameInput = $("input[name='name']")
const date = $("input[name='date']")

const tbody = document.getElementById("myTbody");
const scriptRegex = /(<script\b[^>]*>)([\s\S]*?)(<\/script>)/gi;
const sqlRegex = /(select|insert|update|delete|union|into|load_file)/gi;
const url = "http://localhost:8080/Survival/front/posts/myPosts/getTenPosts"
$(document).ready(() => {
    $("#submitBtn").click(function () {
        let dto = {};

        let classifyArr = new Array();
        let classifyChecked = classify.filter(":checked");
        for (let i = 0; i < classifyChecked.length; i++) {
            classifyArr.push(classifyChecked[i].value);
        }
        dto[classify.attr("name")] = classifyArr;

        dto[nameInput.attr("name")] = nameInput.val();

        let dateArr = new Array();
        let dateChecked = date.filter(":checked");
        for (let i = 0; i < dateChecked.length; i++) {
            dateArr.push(dateChecked[i].value);
        }
        dto[date.attr("name")] = dateArr;

        dto["playerId"] = playerId;
        console.log(dto);

        axios.post(url, dto)
        .then(res => {
            console.log(res);
            console.log(res.data);
            htmlMaker(res.data);
        }).catch(err => {
            console.log(err);
        });
    })

});

function htmlMaker(posts) {

}