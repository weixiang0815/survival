const classify = $("input[name='classify']")
const nameInput = $("input[name='name']")
const date = $("input[name='date']")

const tbody = document.getElementById("myTbody");
const scriptRegex = /(<script\b[^>]*>)([\s\S]*?)(<\/script>)/gi;
const sqlRegex = /(select|insert|update|delete|union|into|load_file)/gi;
const url = "http://localhost:8080/Survival/front/posts/myPosts/getTenPosts"
$(document).ready(() => {
    doing();
    $("#submitBtn").click(doing)

});

function doing(){
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
}

function htmlMaker(postsData) {
    let htmlText = ''

    htmlText+=''
    postsData.content.forEach(el => {
        console.log(`${el}`)
        //留言
        
        htmlText += `<tr>`
        htmlText += `<td>[${el.classify}] <a href="http://localhost:8080/Survival/front/posts/content?id=${el.id}">${el.name}</a></td>`
        htmlText += `<td><button  class=" btn btn-primary btn-edit" data-value="${el.id}">編輯</button> `
        htmlText += `<button  class="btn btn-danger btn-delete " data-value="${el.id}">刪除</button></td>`
        htmlText += `</tr>`
       
      })
    $('#myTbody').html(htmlText)

    $('.btn-edit').click(function() {
        var value = $(this).data('value');
        var intValue = parseInt(value);
        window.location.href = `http://localhost:8080/Survival/front/posts/editPage?id=${intValue}`;
        
    });
    
    $('.btn-delete').click(function() {
        var value = $(this).data('value');
        var intValue = parseInt(value);
        window.location.href = `http://localhost:8080/Survival/front/posts/delete?id=${intValue}`;
        
    });

}