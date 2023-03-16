<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html>

        <style>
            body {
                width: 100vw;
                height: auto;
                margin: 0;
            }

            .wrapper {
                width: 90%;
                margin: 20px 35px 0;
            }

            #photos__container {
                position: relative;
                width: 100vw;
            }

            .photo {
                width: 200px;
                /* width: 18%; */
                height: auto;
                position: absolute;
            }

            .photo img {
                width: 100%;
                display: block;
                border-radius: 15px;
                box-shadow: 0 0 10px 0 rgb(0 0 0 / 30%);
            }
        </style>


        <!-- Loading Effects for Grid Items Demo6 Demo3 -->
        <!-- https://codepen.io/pinkymini/pen/oNwEBzJ -->

        <head>
            <meta charset="UTF-8">
            <title>測試</title>
            <jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
        </head>

        <body>


            <jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

            <div class="text-center mx-auto mb-5 wow fadeInUp">
                <h1>測試</h1>
                <div>

                    <div id="photos__container">
                        <div class="photo">
                            <img src="${contextRoot}/img/product-img/product-2.jpg" alt="photo">
                        </div>


                        <c:forEach items="${list}" var="show_Product" varStatus="Status">
                            <div class="photo">
                                <a href="${contextRoot}/front/Market/productId?id=${show_Product.id}"><img
                                        src="${contextRoot}/Market/id?id=${show_Product.id}" alt="photo"></a>
                            </div><br><br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!-- --------------------------------------------------------------------------------------------------------------------- -->

            <script>
                const gap = 14
                const photosContainer = document.getElementById('photos__container')
                const photos = document.getElementsByClassName('photo')

                function cascadeDisplay() {
                    const photosContainerWidth = photosContainer.offsetWidth
                    const photoWidth = photos[0].offsetWidth
                    // 計算一列最多有幾欄
                    const columnsCount = parseInt((photosContainerWidth) / (photoWidth + gap))
                    const fistRowPhotosHeightArray = []
                    // 進行照片排序
                    for (let i = 0; i < photos.length; i++) {
                        // 放上第一列的照片
                        if (i < columnsCount) {
                            photos[i].style.top = 0
                            photos[i].style.left = (photoWidth + gap) * i + 'px'
                            // 紀錄第一列的照片高
                            fistRowPhotosHeightArray.push(photos[i].offsetHeight)
                        } else {
                            // 放上第二列開始的照片
                            // 找出第一列的最小高度
                            let minHeight = Math.min(...fistRowPhotosHeightArray)
                            // 紀錄最小高度的index，以取得對應到第一列的位置，來決定left要移動多少
                            let index = fistRowPhotosHeightArray.indexOf(minHeight)
                            // 調整接續的photo位置，放到目前最小高度的地方
                            photos[i].style.top = minHeight + gap + 'px'
                            // 取得對應到第一列photo的left位置
                            photos[i].style.left = photos[index].offsetLeft + 'px'
                            // 最後!!再把原本儲存在陣列裡面為最小高度的值，更新上最新的高度(原本的高度+新的高度+間隔)
                            fistRowPhotosHeightArray[index] = fistRowPhotosHeightArray[index] + photos[i].offsetHeight + gap
                        }
                    }

                }

                // 畫面一進來
                window.onload = function () {
                    cascadeDisplay()
                }

                // 畫面寬度有變動
                window.onresize = function () {
                    cascadeDisplay()
                }
            </script>


            <jsp:include page="../../Template/front/footer.jsp"></jsp:include>
            <jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>

        </body>

        </html>