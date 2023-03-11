const reqURL = 'http://localhost:8080/Survival/front/posts/ajax/text';

const output = document.querySelector('.output');

$('.my-posts-data-btn').click(function(e){
    $.ajax({
        url:reqURL,
        method:'POST',
        success: function(res){
            console.log(res)
        },
        error: function(err){
            console.log(err)
        }
    })
})