


$(document).ready(function() {
  $(".msg-btn").click(function() {
    // event.preventDefault(); // 阻止表單提交

    let textValue = $("#myTextarea").val();

    let dtoObject = {
      "edit-Text":textValue,
      "post-id":1,
      "player-id":1
    }

    let url = 'http://localhost:8080/Survival/front/msgs/axios/post'


    axios.post(url, dtoObject)
      .then(res=> {
        console.log(res.data);
        // htmlMaker(res.data);
      })
      .catch(err=> {
        console.log(err);
      });
    

    // 在這裡添加其他處理程式碼
  });
});


function htmlMaker(data){
   //
   const msgBlock = document.getElementById('msg-block'); //放innerHTML
   //構築樣板
   msg_data = '';
   data.content.forEach( el =>{
    //作者欄
    msg_data += '<div class="col-3">'
    msg_data += `<img src="${contextRoot}/player/photo/${el.player.id}" />`
    msg_data += `<p>作者: ${el.player.name}</p>`
    msg_data += `<p>暱稱: ${el.player.nickname}</p>`
    msg_data += `<p>位居縣市: ${el.player.county}</p>`
    msg_data += '</div>'
    //留言
    msg_data += '<div class="col-9 card" style="background-color: black; border: #FF0000 2px solid;">'
    msg_data += `<div class="card-header"><span>發文時間:${el.added}</span></div>`
    msg_data += `<div class="card-body">`
    msg_data += `<p>${el.essay}</p>`
    msg_data += `</div>`

   })
   
   console.log('data.totalPages', data.totalPages)

   let totalPages =  data.totalPages;

   //增加按鈕列
   for(let i =1; i <= totalPages; i++){
     msg_data += '<button class="pageBtn" data-page="'+ i +'">' + i + '</button>'
   }

   msgBlock.innerHTML = msg_data 

   let buttonsArray = document.getElementsByClassName('pageBtn');
   let id = document.getElementById('myPosts').value;//這行我需要改成如何抓取POST-ID
   for( i=0; i<=buttonsArray.length; i++){
    buttonsArray[i].addEventListener('click', function(e){
      let pageNumber = this.getAttribute('data-page');
      loadThatPage(pageNumber,id)
    })
   }

}
///////////////////pageBtn 按下後送出/////////////////////
function loadThatPage(pageNumber,postId){
  axios({
    url:'http://localhost:8080/Survival/front/msgs/axios/get',
    method:'get',
    params:{
      p:pageNumber,
      "post-id":postId
    }
  })
  .then(res=>{
    console.log(res)
    htmlMaker(res.data)
  })
  .catch(err=>{
    console.log('err:' + err)
  })
}



