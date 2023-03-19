const msgBlock = document.getElementById('msg-block'); //放innerHTML

$(document).ready(function () {
  $(".msg-btn").click(function () {
    // event.preventDefault(); // 阻止表單提交

    let textValue = $("#myTextarea").val();

    let dtoObject = {
      "edit-Text": textValue,
      "post-id": postId,
      "player-id": playerId
    }

    let url = 'http://localhost:8080/Survival/front/msgBlock/axios/post'

    axios.post(url, dtoObject)
      .then(res => {
        console.log(res.data);
        htmlMaker(res.data);
      })
      .catch(err => {
        console.log(err);
      });
    // 在這裡添加其他處理程式碼
  });
  $(".msg-nonlogin-btn").on("click", function () {
    // event.preventDefault(); // 阻止表單提交
    axios({
      url: 'http://localhost:8080/Survival/front/msgBlockNL/axios/firstPage',
      method: 'get',
      params: {
        "post_id": postId
      }
    })
      .then(res => {
        console.log(res)
        htmlMaker(res.data)
      })
      .catch(err => {
        console.log('err:' + err)
      })
    // 在這裡添加其他處理程式碼
  });
});

function htmlMaker(data) {
  //構築樣板
  let msg_data = '';
  data.content.forEach(el => {
    console.log(`${el.msg_added}`)
    //留言
    msg_data += `<div class="col-3 player-block" >`
    msg_data += `<img src="http://localhost:8080/Survival/player/photo/${el.player_id}" />`
    msg_data += `<p>作者: ${el.player_name}</p>`
    msg_data += `<p>暱稱: ${el.player_nickname}</p>`
    msg_data += `<p>位居縣市: ${el.player_county}</p>`
    msg_data += '</div>'
    msg_data += '<div class="col-9 card" style="background-color: black; border: #FF0000 2px solid;">'
    msg_data += `<div class="card-header"><span>發文時間:${el.msg_added}</span></div>`
    msg_data += `<div class="card-body">`
    msg_data += `<p>${el.msg_essay}</p>`
    msg_data += `</div>`
    msg_data += `</div>`
  })

  console.log('data.totalPages', data.totalPages)

  let totalPages = data.totalPages;
  msg_data += `<div>`

  //增加按鈕列
  for (let i = 1; i <= totalPages; i++) {
    msg_data += '<button class="pageBtn" data-page="' + i + '">' + i + '</button>'
  }
  msg_data += `</div>`
  msgBlock.innerHTML = msg_data

  let buttonsArray = document.getElementsByClassName('pageBtn');

  for (i = 0; i < buttonsArray.length; i++) {
    console.log(buttonsArray[i]);
    $(buttonsArray[i]).on("click", function (e) {
      console.log("Button clicked!");
      let pageNumber = this.getAttribute('data-page');
      loadThatPage(pageNumber, postId)
    });
    // buttonsArray[i].addEventListener('click', function (e) {
    //   console.log("Button clicked!");
    //   let pageNumber = this.getAttribute('data-page');
    //   loadThatPage(pageNumber, postId)
    // })
  }
}

///////////////////pageBtn 按下後送出/////////////////////
function loadThatPage(pageNumber, id) {
  console.log(pageNumber)
  console.log(id)
  axios({
    url: 'http://localhost:8080/Survival/front/msgBlockNL/axios/get',
    method: 'get',
    params: {
      p: pageNumber,
      "post_id": id
    }
  })
    .then(res => {
      console.log(res)
      htmlMaker(res.data)
    })
    .catch(err => {
      console.log('err:' + err)
    })
}