<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="description" content="">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>歡迎蒞臨商城</title>
            <!-- Favicon  -->
            <link rel="icon" href="${contextRoot}/img/market_favicon.ico">
            <jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
            <link rel="stylesheet" href="${contextRoot}/css/front/Market/front/shop.css">
        </head>

        <body>
            <jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

            <div class="container text-center">
                <h1>戰略商城</h1>
            </div>
            <!---------------------------------------------------------------------------------------------------------->
            <!-- ##### Shop Grid Area Start ##### -->
            <section class="shop_grid_area section-padding-80">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-4 col-lg-3">
                            <div class="shop_sidebar_area">

                                <!-- ##### Single Widget ##### -->
                                <div class="widget catagory mb-50">
                                    <!-- Widget Title -->
                                    <h6 class="widget-title mb-30">商品類別</h6>

                                    <!--  Catagories  -->
                                    <div class="catagories-menu">
                                        <ul id="menu-content2" class="menu-content collapse show">

                                            <!-- Single Item -->
                                            <li data-toggle="collapse" data-target="#guns" class="nav-item">
                                                <a href="#submenu-guns" data-bs-toggle="collapse"
                                                    data-bs-parent="#sidebarMenu" class="nav-link"
                                                    style="color: #ffffff;">槍枝</a>
                                                <ul class="collapse" id="submenu-guns">
                                                    <form action="" id="searchFormData">

                                                        <label class="nav-link">分類</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox" class="clazz"
                                                                name="check_class" value="手槍"
                                                                id="check_clazz">手槍</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox" class="clazz"
                                                                name="check_class" value="步槍"
                                                                id="check_clazz">步槍</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox" class="clazz"
                                                                name="check_class" value="衝鋒槍"
                                                                id="check_clazz">衝鋒槍</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox" class="clazz"
                                                                name="check_class" value="狙擊槍"
                                                                id="check_clazz">狙擊槍</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox" class="clazz"
                                                                name="check_class" value="霰彈槍"
                                                                id="check_clazz">霰彈槍</label><br> <br> <label
                                                            class="nav-link">價格</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox"
                                                                class="price_multi" name="check_price" value="low"
                                                                id="check_low">0元- 5000元</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox"
                                                                class="price_multi" name="check_price" value="mid"
                                                                id="check_mid">5000 - 9000元</label><br> <label
                                                            style="color: #ffffff;"><input type="checkbox"
                                                                class="price_multi" name="check_price" value="high"
                                                                id="check_high">9000元 - 100000元</label> <br> <br>
                                                        <button type="button" style="color: #ff0000;"
                                                            class="btn btn-outline-secondary" data-bs-dismiss="modal"
                                                            id="submitBtn">確認</button>
                                                    </form>
                                                </ul>
                                            </li>

                                            <!-- Single Item -->
                                            <li data-toggle="collapse" data-target="#accessories" class="nav-item"><a
                                                    href="#submenu-accessories" data-bs-toggle="collapse"
                                                    data-bs-parent="#sidebarMenu" class="nav-link"
                                                    style="color: #ffffff;">配件</a>
                                                <form action="${contextRoot}/Market/productIn2" method="get">
                                                    <ul class="collapse" id="submenu-accessories">
                                                        <li>
                                                            <div class="nav-link" style="color: #ffffff;">
                                                                <input type="checkbox" id="vehicle1"
                                                                    name="product_class" value="倍鏡"> 倍鏡
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="nav-link" style="color: #ffffff;">
                                                                <input type="checkbox" id="vehicle2"
                                                                    name="product_class" value="彈夾"> 彈夾
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="nav-link" style="color: #ffffff;">
                                                                <input type="checkbox" id="vehicle3"
                                                                    name="product_class" value="消音器"> 消音器
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="nav-link" style="color: #ffffff;">
                                                                <input type="checkbox" id="vehicle4"
                                                                    name="product_class" value="雷射瞄準器"> 雷射瞄準器
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="nav-link" style="color: #ffffff;">
                                                                <input type="checkbox" id="vehicle5"
                                                                    name="product_class" value="手電筒"> 手電筒
                                                            </div>
                                                        </li>
                                                        <input type="submit" value="送出">
                                                </form>
                                        </ul>
                                        <!-- Single Item -->
                                        <li data-toggle="collapse" data-target="#clothing" class="nav-item"><a
                                                href="#submenu-clothing" data-bs-toggle="collapse"
                                                data-bs-parent="#sidebarMenu" class="nav-link"
                                                style="color: #ffffff;">服飾</a>

                                            <ul class="collapse" id="submenu-clothing">
                                                <form action="${contextRoot}/Market/productIn2" method="get">
                                                    <li>
                                                        <div class="nav-link" style="color: #ffffff;">
                                                            <input type="checkbox" id="vehicle1" name="product_class"
                                                                value="夏季"> 夏季
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nav-link" style="color: #ffffff;">
                                                            <input type="checkbox" id="vehicle2" name="product_class"
                                                                value="冬季"> 冬季
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nav-link" style="color: #ffffff;">
                                                            <input type="checkbox" id="vehicle3" name="product_class"
                                                                value="海軍"> 海軍
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nav-link" style="color: #ffffff;">
                                                            <input type="checkbox" id="vehicle4" name="product_class"
                                                                value="陸軍"> 陸軍
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nav-link" style="color: #ffffff;">
                                                            <input type="checkbox" id="vehicle5" name="product_class"
                                                                value="空軍"> 空軍
                                                        </div>
                                                    </li> <input type="submit" value="送出">
                                                </form>
                                            </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-md-8 col-lg-9">
                            <div class="shop_grid_product_area">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="product-topbar d-flex align-items-center justify-content-between">

                                            <!-- Total Products -->
                                            <div class="total-products">
                                                <p>
                                                    <span>21</span> products found
                                                </p>
                                            </div>

                                            <!-- Sorting -->
                                            <div class="product-sorting d-flex">
                                                <p>Sort by:</p>
                                                <form action="#" method="get">
                                                    <select name="select" id="sortByselect" style="color: #f90000;">
                                                        <option value="value">選擇搜尋的方式</option>
                                                        <option value="value">Highest Rated</option>
                                                        <option value="value">Newest</option>
                                                        <option value="value">Price: $$ - $</option>
                                                        <option value="value">Price: $ - $$</option>
                                                    </select> <input type="submit" class="d-none" value="">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="text-center mx-auto mb-5 wow fadeInUp">
                                    <div>
                                        <div id="photos__container">
                                            <div class="photo">
                                                <img src="${contextRoot}/img/product-img/product-2.jpg" alt="photo">
                                            </div>


                                            <c:forEach items="${list}" var="show_Product" varStatus="Status">
                                                <div class="photo">
                                                    <a
                                                        href="${contextRoot}/front/Market/productId?id=${show_Product.id}"><img
                                                            src="${contextRoot}/Market/id?id=${show_Product.id}"
                                                            alt="photo"></a>
                                                </div>
                                                <br>
                                                <br>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>

                                <!-- Pagination -->
                                <!-- <nav aria-label="navigation">
							<ul class="pagination mt-50 mb-70">
								<li class="page-item"><a class="page-link" href="#"><i
										class="fa fa-angle-left"></i></a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>

								<li class="page-item"><a class="page-link" href="#"><i
										class="fa fa-angle-right"></i></a></li>
							</ul>
						</nav> -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <jsp:include page="../../Template/front/footer.jsp"></jsp:include>
            <jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
            <script>
                (function ($) {
                    'use strict';

                    var $window = $(window);

                    // :: Nav Active Code
                    if ($.fn.classyNav) {
                        $('#essenceNav').classyNav();
                    }

                    // :: Sliders Active Code
                    if ($.fn.owlCarousel) {
                        $('.popular-products-slides').owlCarousel({
                            items: 4,
                            margin: 30,
                            loop: true,
                            nav: false,
                            dots: false,
                            autoplay: true,
                            autoplayTimeout: 5000,
                            smartSpeed: 1000,
                            responsive: {
                                0: {
                                    items: 1
                                },
                                576: {
                                    items: 2
                                },
                                768: {
                                    items: 3
                                },
                                992: {
                                    items: 4
                                }
                            }
                        });
                        $('.product_thumbnail_slides').owlCarousel({
                            items: 1,
                            margin: 0,
                            loop: true,
                            nav: true,
                            navText: ["<img src='img/core-img/long-arrow-left.svg' alt=''>", "<img src='img/core-img/long-arrow-right.svg' alt=''>"],
                            dots: false,
                            autoplay: true,
                            autoplayTimeout: 5000,
                            smartSpeed: 1000
                        });
                    }

                    // :: Header Cart Active Code
                    var cartbtn1 = $('#essenceCartBtn');
                    var cartOverlay = $(".cart-bg-overlay");
                    var cartWrapper = $(".right-side-cart-area");
                    var cartbtn2 = $("#rightSideCart");
                    var cartOverlayOn = "cart-bg-overlay-on";
                    var cartOn = "cart-on";

                    cartbtn1.on('click', function () {
                        cartOverlay.toggleClass(cartOverlayOn);
                        cartWrapper.toggleClass(cartOn);
                    });
                    cartOverlay.on('click', function () {
                        $(this).removeClass(cartOverlayOn);
                        cartWrapper.removeClass(cartOn);
                    });
                    cartbtn2.on('click', function () {
                        cartOverlay.removeClass(cartOverlayOn);
                        cartWrapper.removeClass(cartOn);
                    });

                    // :: ScrollUp Active Code
                    if ($.fn.scrollUp) {
                        $.scrollUp({
                            scrollSpeed: 1000,
                            easingType: 'easeInOutQuart',
                            scrollText: '<i class="fa fa-angle-up" aria-hidden="true"></i>'
                        });
                    }

                    // :: Sticky Active Code
                    $window.on('scroll', function () {
                        if ($window.scrollTop() > 0) {
                            $('.header_area').addClass('sticky');
                        } else {
                            $('.header_area').removeClass('sticky');
                        }
                    });

                    // :: Nice Select Active Code
                    if ($.fn.niceSelect) {
                        $('select').niceSelect();
                    }

                    // :: Slider Range Price Active Code
                    $('.slider-range-price').each(function () {
                        var min = jQuery(this).data('min');
                        var max = jQuery(this).data('max');
                        var unit = jQuery(this).data('unit');
                        var value_min = jQuery(this).data('value-min');
                        var value_max = jQuery(this).data('value-max');
                        var label_result = jQuery(this).data('label-result');
                        var t = $(this);
                        $(this).slider({
                            range: true,
                            min: min,
                            max: max,
                            values: [value_min, value_max],
                            slide: function (event, ui) {
                                var result = label_result + " " + unit + ui.values[0] + ' - ' + unit + ui.values[1];
                                console.log(t);
                                t.closest('.slider-range').find('.range-price').html(result);
                            }
                        });
                    });

                    // :: Favorite Button Active Code 我的最愛
                    var favme = $(".favme");

                    favme.on('click', function () {
                        $(this).toggleClass('active');
                    });

                    favme.on('click touchstart', function () {
                        $(this).toggleClass('is_animating');
                    });

                    favme.on('animationend', function () {
                        $(this).toggleClass('is_animating');
                    });

                    // :: Nicescroll Active Code
                    if ($.fn.niceScroll) {
                        $(".cart-list, .cart-content").niceScroll();
                    }

                    // :: wow Active Code
                    if ($window.width() > 767) {
                        new WOW().init();
                    }

                    // :: Tooltip Active Code
                    if ($.fn.tooltip) {
                        $('[data-toggle="tooltip"]').tooltip();
                    }

                    // :: PreventDefault a Click
                    $("a[href='#']").on('click', function ($) {
                        $.preventDefault();
                    });
                })(jQuery);

                //瀑布流圖片顯示
                const gap = 14
                const photosContainer = document.getElementById('photos__container')

                function cascadeDisplay() {
                    let photos = document.getElementsByClassName('photo')
                    console.log(photos);
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

                // 多條件搜尋 清除按鈕觸發事件
                // clearBtn.addEventListener('click', e => {
                //           console.log("有按到確認")
                //           document.getElementById("searchFormData").reset();  // 欄位設空
                //         })

                // 多條件搜尋 確定按鈕觸發事件
                submitBtn.addEventListener('click', e => {
                    e.preventDefault();
                    let check_context = document.querySelectorAll("input[name='check_context']:checked");
                    let check_class = document.querySelectorAll("input[name='check_class']:checked");
                    let check_price = document.querySelectorAll("input[name='check_price']:checked");

                    let obj = {}
                    let arr_context = new Array();
                    check_context.forEach(el => {
                        arr_context.push(el.value);
                        console.log(el.value);
                    });
                    obj["context"] = arr_context;

                    let arr_class = new Array();
                    check_class.forEach(el => {
                        arr_class.push(el.value);
                        console.log(el.value);
                    });
                    obj["clazz"] = arr_class;

                    let arr_price = new Array();
                    check_price.forEach(el => {
                        arr_price.push(el.value);
                        console.log(el.value);
                    });
                    obj["priceRange"] = arr_price;
                    console.log(obj);
                    console.log(JSON.stringify(obj))
                    sendSearchRequest(JSON.stringify(obj));
                })

                function sendSearchRequest(form) {
                    $.ajax({
                        url: "http://localhost:8080/Survival/Market/multisearch2",
                        method: 'post',
                        data: form,
                        contentType: "application/json;charset:UTF-8",
                        success: function (res) {
                            console.log(res);
                            htmlMaker(res);
                        },
                        error: function (err) {
                            console.log(err);
                        }
                    });
                }

                function htmlMaker(res) {
                    let str = `<div class="photo">
                            <img src="http://localhost:8080/Survival/img/product-img/product-2.jpg"
                                alt="photo">
                        </div>`;
                    res.forEach(product => {
                        str += `<div class="photo">
                            <a
                                href="http://localhost:8080/Survival/front/Market/productId?id=` + product.id + `"><img
                                src="http://localhost:8080/Survival/Market/id?id=` + product.id + `"
                                alt="photo"></a>
                        </div>
                        <br>
                        <br>`;
                    });
                    photosContainer.innerHTML = str;
                    cascadeDisplay();
                }
            </script>
        </body>

        </html>