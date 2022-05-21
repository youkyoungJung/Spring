<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html>

<head>
   <title>구매 내역</title>
   <jsp:include page="navbar.jsp" />
</head>
<style>
@font-face {
   font-family: 'Cafe24Danjunghae';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Danjunghae.woff')
      format('woff');
   font-weight: normal;
   font-style: normal;
}

@font-face {
   font-family: 'Cafe24Simplehae';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
      format('woff');
   font-weight: normal;
   font-style: normal;
}


.buy {
   background-color: #f0deb9;
   vertical-align: 50%;
   margin-left: 10px;
}

.delete {
   background-color: white;
   border: solid 1px #f0deb9;
   vertical-align: 50%;
   margin-left: 10px;
}

.cart {
   margin-left: 100px;
   margin-right: 100px;
   margin-top: 30px;
   margin-bottom: 30px;
   font-family: Cafe24Simplehae;
}

.category {
   font-size: 25px;
}

table {
   border: 2px solid gray;
   border-collapse: collapse;
   width: 100%;
   padding: 10px;
   font-size: 20px;
}

.list {
   height: 70px;
}

td, tr {
   border: 1px solid gray;
   padding-left: 20px;
   padding-right: 20px;
   padding-top: 10px;
   padding-bottom: 10px;
}

tr {
   border-left-style: hidden;
   border-right-style: hidden;
}

.pPirce {
   width: 30px;
}

.bold {
   font-weight: bold;
}

.btn-outline-primary:hover {
   background-color: #f0deb9;
}

.title {
   display: inline-block;
}

.empty {
   color: gray;
   font-size: 20px;
   margin-left: auto;
   margin-right: auto;
}

#buttons {
   color: black;
}

.buy {
   background-color: #f0deb9;
   vertical-align: 50%;
   margin-left: 10px;
}
.btn-outline-primary:hover {
   background-color: #f0deb9;
}
.btn-outline-primary {
   background-color: white;
   border: solid 1px #f0deb9;
   vertical-align: 50%;
   margin-left: 10px;
}

.main {
   width: 890px;
   margin-top: 20px;
   margin-left: auto;
   margin-right: auto;
   padding: 20px;
   border: 1px solid #e9ecef;
   background-color: white;
   border-radius: 20px;
}

.page {
   width: 890px;
   text-align: center;
   margin-top: 20px;
   margin-left: auto;
   margin-right: auto;
}

.thumbnail {
   width: 250px;
   height: 250px;
   margin-top: 20px;
   margin-left: auto;
   margin-right: auto;
}

.card {
   width: 260px;
}

img, .card-body, .card-footer {
   margin: 5px;
   border: none;
}

.go:link {
   text-decoration: none;
}

.go {
   color: black;
}

.list-card {
   border: 1px solid #c2c2c2;
   width: 260px;
   border-radius: 10px;
   float: left;
   margin-left: 9px;
   margin-right: 9px;
   margin-bottom: 20px;
}

.card-footer {
   border-top: 1px solid #c2c2c2;
}

</style>
<!-- Team -->

</body>
<!-- Team -->

<div class="cart">
      <div class="category">
         <span class="bold">구매내역</span> | 
         <c:if test="${category eq '1' }">
            <a class="btn btn-outline-primary" id="buttons"
               href='<c:url value='/member/purchaseDetail1'></c:url>'>직거래</a> 
         </c:if>
         <c:if test="${category ne '1' }">
            <a class="btn buy" id="buttons"
                  href='<c:url value='/member/purchaseDetail1'></c:url>'>직거래</a>
         </c:if>
         <c:if test="${category eq '2' }">
            <a class="btn btn-outline-primary" id="buttons"
            href='<c:url value='/member/purchaseDetail2'></c:url>'>공동 구매</a>  
         </c:if>
         <c:if test="${category ne '2' }">
            <a class="btn buy" id="buttons"
            href='<c:url value='/member/purchaseDetail2'></c:url>'>공동 구매</a> 
         </c:if>
         <c:if test="${category eq '3' }">
            <a class="btn btn-outline-primary" id="buttons"
            href='<c:url value='/member/purchaseDetail3'></c:url>'>경매 낙찰</a>
         </c:if>
         <c:if test="${category ne '3' }">
            <a class="btn buy" id="buttons"
            href='<c:url value='/member/purchaseDetail3'></c:url>'>경매 낙찰</a>
         </c:if>
      </div>
      <br>
      
      <c:if test="${category eq '1' }">
      <div class="row row-cols-1 row-cols-md-3 g-4 main">
         <div>
            <c:if test="${empty productList.pageList}">
               <tr>
                  <td colspan="3">
                     <span class="empty bold"> 구매한 상품이 없습니다.</span>
                     <br>
                  </td>
               </tr>
            </c:if>
         </div>   
         <c:if test="${not empty  productList}">
         <c:forEach var="product" items="${productList.pageList}">
               <div class="col list-card">
                  <div class="card h-100">
                        <a class="go"
                           href='<c:url value="/detail/item">
                     <c:param name="item_id" value="${product.item_id }"/></c:url>'>
                           <img src="/images/${product.fileName}"
                           class="card-img-top thumbnail">
                        </a>
                     <div class="card-body">
                        <h5 class="card-title">
                           <a class="go"
                              href='<c:url value="/detail/item">
                  <c:param name="item_id" value="${product.item_id }"/></c:url>'><c:out
                                 value="${product.title}" /></a>
                        </h5>
                        <p class="card-text">
                           <a class="go"
                              href='<c:url value="/detail/item">
                  <c:param name="item_id" value="${product.item_id }"/></c:url>'><c:out
                                 value="${product.price}" />원</a>
                        </p>
                     </div>
                     <div class="card-footer">
                        <small class="text-muted"> 구매일 : <c:out
                              value="${product.purchasedDate }" />
                        </small>
                     </div>
                  </div>
                 </div>
            </c:forEach>
         </c:if>
         </div>
      </c:if>


      <!-- 카테고리1 끝 -->
      <!-- 카테고리2 시작 -->
      <c:if test="${category eq '2' }">
         <div class="row row-cols-1 row-cols-md-3 g-4 main">
         <div>
            <c:if test="${empty productList.pageList}">
               <tr>
                  <td colspan="3">
                     <span class="empty bold"> 구매한 상품이 없습니다.</span>
                     <br>
                  </td>
               </tr>
            </c:if>
         </div>   
         <c:if test="${not empty  productList}">
         <c:forEach var="product" items="${productList.pageList}">
               <div class="col list-card">
                  <div class="card h-100">
                        <a class="go"
                           href='<c:url value="/detail/group">
                     <c:param name="group_id" value="${product.group_id }"/></c:url>'>
                           <img src="/images/${product.fileName}"
                           class="card-img-top thumbnail">
                        </a>
                     <div class="card-body">
                        <h5 class="card-title">
                           <a class="go"
                              href='<c:url value="/detail/group">
                  <c:param name="group_id" value="${product.group_id }"/></c:url>'><c:out
                                 value="${product.title}" /></a>
                        </h5>
                        <p class="card-text">
                           <a class="go"
                              href='<c:url value="/detail/group">
                  <c:param name="group_id" value="${product.group_id }"/></c:url>'><c:out
                                 value="${product.price}" />원</a>
                        </p>
                     </div>
                     <div class="card-footer">
                        <small class="text-muted"> 구매일 : <c:out
                              value="${product.purchasedDate }" />
                        </small>
                     </div>
                  </div>
                 </div>
            </c:forEach>
         </c:if>
         </div>
      </c:if>
   <!-- 카테고리2 끝 -->
   <!-- 카테고리2 시작 -->
      <c:if test="${category eq '3' }">
         <div class="row row-cols-1 row-cols-md-3 g-4 main">
         <div>
            <c:if test="${empty productList.pageList}">
               <tr>
                  <td colspan="3">
                     <span class="empty bold"> 구매한 상품이 없습니다.</span>
                     <br>
                  </td>
               </tr>
            </c:if>
         </div>   
         <c:if test="${not empty  productList}">
         <c:forEach var="product" items="${productList.pageList}">
               <div class="col list-card">
                  <div class="card h-100">
                        <a class="go"
                           href='<c:url value="/detail/auction">
                     <c:param name="auction_id" value="${product.auction_id }"/></c:url>'>
                           <img src="/images/${product.fileName}"
                           class="card-img-top thumbnail">
                        </a>
                     <div class="card-body">
                        <h5 class="card-title">
                           <a class="go"
                              href='<c:url value="/detail/auction">
                  <c:param name="auction_id" value="${product.auction_id }"/></c:url>'><c:out
                                 value="${product.title}" /></a>
                        </h5>
                        <p class="card-text">
                           <a class="go"
                              href='<c:url value="/detail/auction">
                  <c:param name="auction_id" value="${product.auction_id }"/></c:url>'><c:out
                                 value="${product.payment}" />원</a>
                        </p>
                     </div>
                     <div class="card-footer">
                        <small class="text-muted"> 구매일 : <c:out
                              value="${product.purchasedDate }" />
                        </small>
                     </div>
                  </div>
                 </div>
            </c:forEach>
         </c:if>
         </div>
      </c:if>
   <!-- 카테고리2 끝 -->

</div>


</html>
<%@ include file="IncludeBottom.jsp"%>