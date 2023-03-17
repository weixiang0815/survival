<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>商品詳情</title>
      <jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
    </head>

    <style>
      .ps-4 {
        display: flex;
        /* 水平置中 */
        justify-content: center;
        /* 垂直置中 */
        align-content: center;
        flex-wrap: wrap;
      }
    </style>

    <body>
      <jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
      <div class="container text-center">
        <h1>商品詳情</h1>
      </div>
      <div class="container text-center">
        <!-- Service Start -->
        <div class="container-xxl py-5">
          <div class="container">
            <div class="row g-4">
              <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
                  <div class="ps-4 ">
                    <h3 class="text-uppercase mb-3">商品名稱:${product.name}</h3>
                    <img alt="" height="270" width="350" src="${contextRoot}/Market/id?id=${product.id}">
                  </div>
                  <div class="i_item">
                  </div>
                </div>
              </div>
              <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
                  <div class="ps-4">
                    <h3 class="text-uppercase mb-3">商品介紹</h3>
                    <p>${product.context}</p>
                  </div>

                </div>
              </div>
              <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                <div class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">

                  <div class="ps-4">
                    <h3 class="text-uppercase mb-3"></h3>

                    <table class="table1" style="margin-left: 110px">
                      <tr>
                        <td>
                          <h3 class="text-uppercase mb-3">販賣${product.price}</h3>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <h3 class="text-uppercase mb-3">租賃${product.rent_fee}</h3>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <form action="${contextRoot}" method="get">
                            <input name="id" type="hidden" value="${product.id}" />
                            <input type="submit" class="btn-info btn-sm" value="加到我的最愛" />
                          </form>
                        </td>
                      <tr>
                        <td>
                          <form action="${contextRoot}/Market/Cart/add" method="post">
                            <input name="_method" type="hidden" value="post" />
                            <input name="productId" type="hidden" value="${product.id}" />
                            <input name="playerId" type="hidden" value="1" />
                            <input name="quantity" type="hidden" value="1" />
                            <input type="submit" class=" btn-danger btn-sm" value="加入購物車" />
                          </form>
                        </td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>


      <jsp:include page="../../Template/front/footer.jsp"></jsp:include>
      <jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
    </body>

    </html>