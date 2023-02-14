<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html>

        <head>
          <meta charset="UTF-8">
          <title>新增商品</title>
          <style>
            .st1 {
              width: 450px;
              margin: 20px;
              padding-bottom: 10px;
            }

            .t1 {
              width: 100px;
              float: left;
              text-align: right;

            }

            /* .img{
              float: right;
              text-align: right;
              clear:left;
              margin: 0 auto;
            } */

            .sub {
              /* width: 450px;
            margin: 20px; */
              text-align: center;
            }
          </style>

        </head>

        <body>
          <jsp:include page="Layout/navbar_market.jsp"></jsp:include>
          <div class="container">
            <div class="st1">
                <h1>新增商品</h1>
            </div>
            <form action="${contextRoot}/ProductRepository/addproduct" method="post" enctype="multipart/form-data">

              <div class="st1">
                <label class="t1"> 商品名稱: </label>
                <input type="text" style="width:253px" name="photoName" />
              </div>

              <div class="st1">
                <label class="t1"> 商品介紹: </label>
                <textarea name="photoContext" id="comment1" cols="30" rows="5"></textarea>
                <!-- <input type="text"  name="photoContext" /> -->
              </div>

              <div class="st1">
                <label class="t1"> 商品種類: </label>
                <input type="text" style="width:253px" name="Product_class" />
              </div>

              <div class="st1">
                <label class="t1"> 售出價格: </label>
                <input type="text" style="width:253px" name="Price" />
              </div>

              <div class="st1">
                <label class="t1"> 租賃價格: </label>
                <input type="text" style="width:253px" name="setRent_fee" />
              </div>

              <div class="st1">
                <label class="t1"> 商品圖片: </label>
                <input accept="image/*" type="file" name="photoFile" id="photoFileInput">
                <label class="t1">
                  <img id="blah" height="150" src="#" alt="" /></label>
              </div>


              <div class="sub">
                <input id="uploadBtn" type="submit" value="新增商品">
              </div>



              <script>
                photoFileInput.onchange = evt => {
                  const [file] = photoFileInput.files
                  if (file) {
                    blah.src = URL.createObjectURL(file)
                  }
                }
              </script>
          </div>
        </body>

        </html>