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
            <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
            <meta charset="UTF-8">
            <title>戰略商城</title>
            <!-- Favicon  -->
            <link rel="icon" href="${contextRoot}/img/market_favicon.ico">
            <!-- Core Style CSS -->
            <link rel="stylesheet" href="css/core-style.css">
            <link rel="stylesheet" href="style.css">
            <jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
            <link rel="stylesheet" href="${contextRoot}/css/front/Market/front/shop.css">
        </head>

        <body>
            <jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
            <!-- Carousel Start -->
            <div class="container-fluid p-0 mb-5 wow fadeIn" data-wow-delay="0.1s">
                <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <video class="w-100" preload="auto" autoplay loop="loop" muted="muted">
                                <source src="${contextRoot}/videos/kalashnikov-99910.mp4" type="video/mp4">
                                Your browser does not support the video tag.
                            </video>
                            <div class="carousel-caption d-flex align-items-center justify-content-center text-start">
                                <div class="mx-sm-5 px-5" style="max-width: 900px;">
                                    <h1 class="display-2 text-white text-uppercase mb-4 animated slideInDown">
                                       生存最重要，裝備最關鍵</h1>
                                    <h4 class="text-white text-uppercase mb-4 animated slideInDown">
                                        <i class="fa fa-map-marker-alt text-primary me-3"></i>台北市復興南路一段390號2樓
                                    </h4>
                                    <h4 class="text-white text-uppercase mb-4 animated slideInDown">
                                        <i class="fa fa-phone-alt text-primary me-3"></i>（02）6631-6588
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <video class="w-100" preload="auto" autoplay loop="loop" muted="muted">
                                <source src="${contextRoot}/videos/war-16391.mp4" type="video/mp4">
                            </video>
                            <div class="carousel-caption d-flex align-items-center justify-content-center text-start">
                                <div class="mx-sm-5 px-5" style="max-width: 900px;">
                                    <h1 class="display-2 text-white text-uppercase mb-4 animated slideInDown">
                                       只有最強者才能生存下去</h1>
                                    <h4 class="text-white text-uppercase mb-4 animated slideInDown">
                                        <i class="fa fa-map-marker-alt text-primary me-3"></i>台北市復興南路一段390號2樓
                                    </h4>
                                    <h4 class="text-white text-uppercase mb-4 animated slideInDown">
                                        <i class="fa fa-phone-alt text-primary me-3"></i>（02）6631-6588
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">上一頁</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#header-carousel"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">下一頁</span>
                    </button>
                </div>
            </div>
            <!-- Carousel End -->

            <!-- Page Header Start -->
            <div class="container-fluid page-header py-5 mb-5 wow fadeIn" data-wow-delay="0.1s">
                <div class="container text-center py-5">
                    <h1 class="display-3 text-white text-uppercase mb-3 animated slideInDown">商城</h1>
                    <nav aria-label="breadcrumb animated slideInDown">
                        <ol class="breadcrumb justify-content-center text-uppercase mb-0">
                            <li class="breadcrumb-item"><a class="text-white" href="${contextRoot}">首頁</a></li>
                            <!-- <li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li> -->
                            <li class="breadcrumb-item text-primary active" aria-current="page">商城頁面</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <!-- Page Header End -->

            <!-- ##### Top Catagory Area Start ##### -->
            <div class="top_catagory_area section-padding-80 clearfix">
                <div class="container">
                    <div class="row justify-content-center">
                        <!-- Single Catagory -->
                        <div class="col-12 col-sm-6 col-md-4">
                            <div class="single_catagory_area d-flex align-items-center justify-content-center bg-img"
                                style="background-image: url(${contextRoot}/img/bg-img/bg-2.jpg);">
                                <div class="catagory-content">
                                    <a href="${contextRoot}/Market/findProductClassLike?product_class=槍">槍枝</a>
                                </div>
                            </div>
                        </div>
                        <!-- Single Catagory -->
                        <div class="col-12 col-sm-6 col-md-4">
                            <div class="single_catagory_area d-flex align-items-center justify-content-center bg-img"
                                style="background-image: url(${contextRoot}/img/bg-img/bg-3.jpg);">
                                <div class="catagory-content">
                                    <a href="${contextRoot}/Market/findProductClassLike?product_class=配">配件</a>
                                </div>
                            </div>
                        </div>
                        <!-- Single Catagory -->
                        <div class="col-12 col-sm-6 col-md-4">
                            <div class="single_catagory_area d-flex align-items-center justify-content-center bg-img"
                                style="background-image: url(${contextRoot}/img/bg-img/bg-4.jpg);">
                                <div class="catagory-content">
                                    <a href="${contextRoot}/Market/findProductClassLike?product_class=服">服裝</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ##### Top Catagory Area End ##### -->

            <!-- ##### CTA Area Start ##### -->
            <div class="cta-area">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="cta-content bg-img background-overlay"
                                style="background-image: url(${contextRoot}/img/bg-img/bg-5.jpg);">
                                <div class="h-100 d-flex align-items-center justify-content-end">
                                    <div class="cta--text">
                                        <h6>-30%</h6>
                                        <h2 style="color: azure;">全球折扣</h2>
                                        <a href="${contextRoot}/front/Market/getAllProductFront" class="btn essence-btn"
                                            style="font-size:2em">立即購買</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ##### CTA Area End ##### -->
            <!-- ##### New Arrivals Area Start ##### -->
            <section class="new_arrivals_area section-padding-80 clearfix">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="section-heading text-center">
                                <h2 style="color: #ffffff;">熱門商品</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <!------------------------- 瀑布流排版方式 ------------------------->
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="popular-products-slides owl-carousel">
                                <!-- Single Product -->
                                <div class="single-product-wrapper">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src="${contextRoot}/img/product-img/product-1.jpg" alt="">
                                        <!-- Hover Thumb -->
                                        <img class="hover-img" src="${contextRoot}/img/product-img/product-1.jpg"
                                            alt="">
                                        <!-- Favourite -->
                                        <div class="product-favourite">
                                            <a href="#" class="favme fa fa-heart"></a>
                                        </div>
                                    </div>
                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <span>頂級商品</span>
                                        <a href="single-product-details.html">
                                            <h6>特勤黑衣套裝</h6>
                                        </a>
                                        <p class="product-price">8000元</p>
                                        <!-- Hover Content -->
                                        <div class="hover-content">
                                            <!-- Add to Cart -->
                                            <div class="add-to-cart-btn">
                                                <a href="#" class="btn essence-btn">加入購物車</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Single Product -->
                                <div class="single-product-wrapper">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src="${contextRoot}/img/product-img/product-6.jpg" alt="">
                                        <!-- Hover Thumb -->
                                        <img class="hover-img" src="${contextRoot}/img/product-img/product-6.jpg"
                                            alt="">
                                        <!-- Favourite -->
                                        <div class="product-favourite">
                                            <a href="#" class="favme fa fa-heart"></a>
                                        </div>
                                    </div>
                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <span>頂級商品</span>
                                        <a href="single-product-details.html">
                                            <h6>左輪手槍</h6>
                                        </a>
                                        <p class="product-price">8000元</p>
                                        <!-- Hover Content -->
                                        <div class="hover-content">
                                            <!-- Add to Cart -->
                                            <div class="add-to-cart-btn">
                                                <a href="#" class="btn essence-btn">加入購物車</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Single Product -->
                                <div class="single-product-wrapper">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src="${contextRoot}/img/product-img/product-5.jpg" alt="">
                                        <!-- Hover Thumb -->
                                        <img class="hover-img" src="${contextRoot}/img/product-img/product-5.jpg"
                                            alt="">
                                        <!-- Product Badge -->
                                        <div class="product-badge offer-badge">
                                            <span>-5000</span>
                                        </div>
                                        <!-- Favourite -->
                                        <div class="product-favourite">
                                            <a href="#" class="favme fa fa-heart"></a>
                                        </div>
                                    </div>
                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <span>單一商品</span>
                                        <a href="single-product-details.html">
                                            <h6>AWV狙擊槍</h6>
                                        </a>
                                        <p class="product-price"><span class="old-price">60000元</span> 55000元</p>
                                        <!-- Hover Content -->
                                        <div class="hover-content">
                                            <!-- Add to Cart -->
                                            <div class="add-to-cart-btn">
                                                <a href="#" class="btn essence-btn">加入購物車</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Single Product -->
                                <div class="single-product-wrapper">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src="${contextRoot}/img/product-img/product-4.jpg" alt="">
                                        <!-- Hover Thumb -->
                                        <img class="hover-img" src="${contextRoot}/img/product-img/product-4.jpg"
                                            alt="">

                                        <!-- Product Badge -->
                                        <div class="product-badge new-badge">
                                            <span>新貨</span>
                                        </div>

                                        <!-- Favourite -->
                                        <div class="product-favourite">
                                            <a href="#" class="favme fa fa-heart"></a>
                                        </div>
                                    </div>
                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <span>單一商品</span>
                                        <a href="single-product-details.html">
                                            <h6>Kar.98狙擊槍</h6>
                                        </a>
                                        <p class="product-price">80000元</p>

                                        <!-- Hover Content -->
                                        <div class="hover-content">
                                            <!-- Add to Cart -->
                                            <div class="add-to-cart-btn">
                                                <a href="#" class="btn essence-btn">加入購物車</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- ##### New Arrivals Area End ##### -->

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
    
                    // :: Favorite Button Active Code
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
            </script>
        </body>
        </html>