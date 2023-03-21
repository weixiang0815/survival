const submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click', e =>{
    e.preventDefault();  // 如果是用 form 表單，要把表單送出的功能取消

    let inputText = document.getElementById('myPosts').value;
    console.log(inputText)
    console.log(typeof inputText)
    let URL = 'http://localhost:8080/Survival/front/posts/ajax/postpage'

    axios({
      url:URL,
      method:'GET',
      params:{
        SearchStr:inputText
      }
    })
    .then(res=>{
      console.log(res)
      htmlMaker(res.data,inputText)
    })
    .catch(err=>{
      console.log('err:' + err)
    })
})

function htmlMaker(data,name){
  console.log(name)
   msg_data = '<tbody>'
   data.content.forEach( el =>{
    msg_data += '<tr>'
    msg_data += `<td>[${el.classify}]<a href="http://localhost:8080/Survival/front/posts/content?id=${el.id}">${el.name}</a></td>`
    msg_data += '</tr>'
   })
   
   msg_data += '<tbody>'

   console.log('data.totalPages', data.totalPages)

   let totalPages =  data.totalPages;


   for(let i =1; i <= totalPages; i++){
     msg_data += '<button class="pageBtn" data-page="'+ i +'">' + i + '</button>'
   }

   

   let myTable = document.getElementById('list_table_json')
    
   myTable.getElementsByTagName('tbody')[0].innerHTML = msg_data

   let buttonsArray = document.getElementsByClassName('pageBtn');

   for(i=0; i<buttonsArray.length; i++){
    buttonsArray[i].addEventListener('click', function(e){
      let pageNumber = this.getAttribute('data-page');
      
      loadThatPage(pageNumber,name)
    })
   }

}
///////////////////pageBtn 按下後送出/////////////////////
function loadThatPage(pageNumber,name){
  axios({
    url:'http://localhost:8080/Survival/front/posts/ajax/page',
    method:'get',
    params:{
      p:pageNumber,
      SearchStr:name
    }
  })
  .then(res=>{
    console.log(res)
    htmlMaker(res.data,name)
  })
  .catch(err=>{
    console.log('err:' + err)
  })
}



