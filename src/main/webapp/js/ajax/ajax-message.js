const submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click', e =>{
    // e.preventDefault();  // 如果是用 form 表單，要把表單送出的功能取消

    let inputText = document.getElementById('myMessage').value;

    let dtoObject = {text : inputText}
    
    let url = 'http://localhost:8080/my-app/message/ajax/post'

    axios.post(url, dtoObject)
    .then(res =>{
        console.log(res.data)
        let springPage = res.data;
        htmlMaker(springPage)
        document.getElementById('myMessage').value = '';
    })
    .catch(err =>{

    })
})

function htmlMaker(data){
   msg_data = '<tbody>'
   data.content.forEach( el =>{
    msg_data += '<tr>'
    msg_data += `<td>${el.text}</td>`
    // msg_data += '<tr>' + el.text + '</td>'
    msg_data += `<td>${el.added}</td>`
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

   for(i=0; i<=buttonsArray.length; i++){
    buttonsArray[i].addEventListener('click',function(e){
        var pageNumber = this.getAttribute('data-page');
        // console.log('up',pageNumber)
        loadThatPage(pageNumber)
    })
        
   }
   
}

/////// 點 page button 發送的 ajax ////////
function loadThatPage(pageNumber){
    
   axios({
    url:'http://localhost:8080/my-app/message/api/page',
    method: 'get',
    params:{
        p: pageNumber
    }
   })
   .then(res =>{
     console.log(res.data)
     htmlMaker(res.data)
   })
   .catch(err =>{
    console.log(err)
   })
}