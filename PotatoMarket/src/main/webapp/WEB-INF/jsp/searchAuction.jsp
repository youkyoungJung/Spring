<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>경매 - 전체 상품 화면</title>
<jsp:include page="navbar.jsp" />
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

body {
   font-family: Cafe24Simplehae;
   background-color: #f8f9fa;
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

#buttons {
   background-color: #EFEFEF;
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

.close {
   background-color: #c2c2c2;
}

.finish {
   color: red;
}
</style>
</head>
<body>
   <div class="row row-cols-1 row-cols-md-3 g-4 main">
      <h2>
         <c:out value="${ category }" />
         <c:if test="${isLogin}">
            <a class="btn pull-right" style="margin-right: 30px;" id="buttons"
               href="<c:url value='/add/auction'>
            <c:param name='memberId' value='${member_id}'/><c:param name='auction_id' value='0'/></c:url>">상품
               등록</a>
         </c:if>
      </h2>
      <c:choose>
      <c:when test="${fn:length(productList.pageList) == 0 }">
      <div>
         검색된 상품이 없습니다.
      </div>
      </c:when>
      <c:otherwise>
      <c:forEach var="product" items="${ productList.pageList }">
         <c:if test="${product.status eq 'OPEN'}">
            <div class="col list-card">
               <div class="card h-100">
                  <a class="go" href='<c:url value="/detail/auction">
                  <c:param name="auction_id" value="${product.auction_id }"/></c:url>'>
                        <img src="/images/${product.fileName}"
                        class="card-img-top thumbnail">
                     </a>
                  <div class="card-body">
                     <h5 class="card-title">
                        <a class="go"
                           href='<c:url value="/detail/auction">
            <c:param name="auction_id" value="${ product.auction_id }"/></c:url>'>&nbsp;<c:out
                              value="${ product.title }" /></a>
                     </h5>
                     <p class="card-text">
                        &nbsp;시작 가격 :
                        <c:out value="${ product.price }" />
                        원
                     </p>
                  </div>
                  <div class="card-footer">
                     <small class="text-muted">&nbsp; 입찰 단위 : <c:out
                           value="${ product.auctionPrice }" />원
                     </small><br> <small class="text-muted">&nbsp; 경매 종료일 : <c:out
                           value="${ product.end_date }" />
                     </small>
                  </div>
               </div>
            </div>
         </c:if>
         <c:if test="${product.status eq 'CLOSE'}">
            <div class="col list-card close">
               <div class="card h-100">
                  <a class="go" href='<c:url value="/detail/auction">
                  <c:param name="auction_id" value="${product.auction_id }"/></c:url>'>
                        <img src="/images/${product.fileName}" class="card-img-top thumbnail">
                     </a>
                  <div class="card-body">
                     <h5 class="card-title">
                        &nbsp;<a class="go"
                           href='<c:url value="/detail/auction">
            <c:param name="auction_id" value="${ product.auction_id }"/></c:url>'><c:out
                              value="${ product.title }" /></a>
                     </h5>
                     <p class="card-text">
                        &nbsp;시작 가격 :
                        <c:out value="${ product.price }" />
                        원
                     </p>
                  </div>
                  <div class="card-footer">
                     <small class="finish"> 경매가 종료된 상품입니다. </small>
                  </div>
               </div>
            </div>
         </c:if>
      </c:forEach>
      </c:otherwise>
      </c:choose>
   </div>
   <div class="page">
      <c:if test="${!productList.firstPage}">
         <a
            href='<c:url value="/list/auction2">
            <c:param name="page" value="previous"/></c:url>'>
            <B>&lt;&lt; Prev</B>
         </a>
      </c:if>
      <c:if test="${!productList.lastPage}">
         <a
            href='<c:url value="/list/auction2">
            <c:param name="page" value="next"/></c:url>'>
            <B>Next &gt;&gt;</B>
         </a>
      </c:if>
   </div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>