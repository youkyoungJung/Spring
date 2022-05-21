<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관심목록</title>
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

.thumbnail {
   width: 130px;
   height: 130px;
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

.info {
   border: 1px solid #c2c2c2;
   border-radius: 15px;
   padding-left: 40px;
   padding-right: 20px;
   padding-top: 10px;
   font-size: 15px;
   width: 700px;
   background-color: #edf2ee;
}

.bold {
   font-weight: bold;
}

.btn-outline-primary:hover {
   background-color: #f0deb9;
}

.highlight {
   color: #1fa35d;
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
</style>
</head>
<body>
   <div class="cart">
      <div class="category">
         <span class="bold">관심목록</span> | 
         <c:if test="${category eq '1' }">
            <a class="btn btn-outline-primary" id="buttons"
               href='<c:url value='/member/likes1'></c:url>'>직거래</a> 
         </c:if>
         <c:if test="${category ne '1' }">
            <a class="btn buy" id="buttons"
                  href='<c:url value='/member/likes1'></c:url>'>직거래</a>
         </c:if>
         <c:if test="${category eq '2' }">
            <a class="btn btn-outline-primary" id="buttons"
            href='<c:url value='/member/likes2'></c:url>'>공동 구매</a>  
         </c:if>
         <c:if test="${category ne '2' }">
            <a class="btn buy" id="buttons"
            href='<c:url value='/member/likes2'></c:url>'>공동 구매</a> 
         </c:if>
         <c:if test="${category eq '3' }">
            <a class="btn btn-outline-primary" id="buttons"
            href='<c:url value='/member/likes3'></c:url>'>경매</a>
         </c:if>
         <c:if test="${category ne '3' }">
            <a class="btn buy" id="buttons"
            href='<c:url value='/member/likes3'></c:url>'>경매</a>
         </c:if>
      </div>
      <br>
      <c:if test="${category eq '1' }">
         <div>
            <table>
               <c:if test="${empty productList}">
                  <tr>
                     <td colspan="3"><span class="empty bold">  ♡찜항목에 담긴
                           상품이 없습니다.</span> <br> <span class="empty">원하는 상품을 관심목록에
                           담아보세요!</span>
                     </td>
                  </tr>
               </c:if>
               <c:if test="${not empty productList}">
                  <tr>
                     <td class="pTitle">상품 정보</td>
                     <td class="pPrice">가격</td>
                     <td class="pButton">관심 목록</td>
                  </tr>
                  <c:forEach var="likesItem" items="${productList}">
                     <tr class="list">
                        <td class="pTitle"><a class="go title" 
                           href='<c:url value="/detail/item">
                                 <c:param name="item_id" value="${likesItem.item_id }"/></c:url>'>
                              <img src="/images/${likesItem.fileName }" class="thumbnail title">
                        </a>&nbsp; <a class="go title"
                           href='<c:url value="/detail/item">
                                 <c:param name="item_id" value="${likesItem.item_id }"/></c:url>'>
                              [제목] <c:out value="${likesItem.title}" />
                        </a></td>
                        <td class="pPrice"><c:out value="${likesItem.price}" />원</td>
                        <td class="pButton"><a class="btn delete" id="buttons"
                           href='<c:url value='/delete/itemLike2'>
                                 <c:param name="item_id" value="${likesItem.item_id}"/></c:url>' onclick = "return confirm('정말 삭제 하시겠습니까?')">
                              관심목록 삭제</a></td>
                     </tr>
                  </c:forEach>
               </c:if>
            </table>
         </div>
      </c:if>
      <c:if test="${category eq '2' }">
         <div>
            <table>
               <c:if test="${empty productList}">
                  <tr>
                     <td colspan="3"><span class="empty bold">  ♡찜항목에 담긴
                           상품이 없습니다.</span> <br> <span class="empty">원하는 상품을 관심목록에
                           담아보세요!</span></td>
                  </tr>
               </c:if>
               <c:if test="${not empty productList}">
                  <tr>
                     <td class="pTitle">상품 정보</td>
                     <td class="pPrice">가격</td>
                     <td class="pButton">관심 목록</td>
                  </tr>
                  <c:forEach var="likesGroup" items="${productList}">
                     <tr class="list">
                        <td class="pTitle"><a class="go title"
                           href='<c:url value="/detail/group">
                           <c:param name="group_id" value="${likesGroup.group_id }"/></c:url>'>
                              <img src="/images/${likesGroup.fileName }" class="thumbnail title">
                        </a>&nbsp; <a class="go"
                           href='<c:url value="/detail/group">
                           <c:param name="group_id" value="${likesGroup.group_id }"/></c:url>'>
                              [제목] <c:out value="${likesGroup.title}" />
                        </a></td>
                        <td class="pPrice"><c:out
                              value="${likesGroup.discountPrice}" />원 / 인</td>
                        <td class="pButton"><a class="btn delete" id="buttons"
                           href='<c:url value='/delete/groupLike2'>
                           <c:param name="group_id" value="${likesGroup.group_id}"/></c:url>' onclick = "return confirm('정말 삭제 하시겠습니까?')">
                              관심목록 삭제</a> 
                     </tr>
                  </c:forEach>
               </c:if>
            </table>
         </div>
      </c:if>
      <c:if test="${category eq '3' }">
      <div>
         <table>
            <!-- 장바구니에 상품이 없을 때 만들어야함. -->
            <c:if test="${empty productList}">
               <tr>
                  <td colspan="3"><span class="empty bold">  ♡찜항목에 담긴
                           상품이 없습니다.</span> <br> <span class="empty">원하는 상품을 관심목록에
                           담아보세요!</span></td>
               </tr>
            </c:if>
            <c:if test="${not empty productList}">
               <tr>
                  <td class="pTitle">상품 정보</td>
                  <td class="pPrice">시작가</td>
                  <td class="pButton">관심 목록</td>
               </tr>
               <c:forEach var="likesAuction" items="${productList}">
                  <tr class="list">
                      <td class="pTitle"><a class="go title" href='<c:url value="/detail/auction">
                        <c:param name="auction_id" value="${likesAuction.auction_id }"/></c:url>'>
                              <img src="/images/${likesAuction.fileName}" class="card-img-top thumbnail title">
                        </a>&nbsp; <a class="go title" href='<c:url value="/detail/auction">
                           <c:param name="auction_id" value="${likesAuction.auction_id }"/></c:url>'>
                              [제목] <c:out value="${likesAuction.title}" />
                        </a></td>
                     <td class="pPrice"><c:out value="${likesAuction.price}" />원</td>
                     <td class="pButton"><a class="btn delete" id="buttons" href='<c:url value='/delete/auctionLike2'>
                           <c:param name="auction_id" value="${likesAuction.auction_id}"/></c:url>'  onclick = "return confirm('정말 삭제 하시겠습니까?')">
                           관심목록 삭제</a> 
                  </tr>
               </c:forEach>
            </c:if>
         </table>
        </div>
      </c:if>
   </div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>