<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니</title>
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
			<span class="bold">장바구니</span> | 
			<c:if test="${category eq '1' }">
				<a class="btn btn-outline-primary" id="buttons"
					href='<c:url value='/shop/viewCart1'></c:url>'>직거래</a> 
			</c:if>
			<c:if test="${category ne '1' }">
				<a class="btn buy" id="buttons"
						href='<c:url value='/shop/viewCart1'></c:url>'>직거래</a>
			</c:if>
			<c:if test="${category eq '2' }">
				<a class="btn btn-outline-primary" id="buttons"
				href='<c:url value='/shop/viewCart2'></c:url>'>공동 구매</a>  
			</c:if>
			<c:if test="${category ne '2' }">
				<a class="btn buy" id="buttons"
				href='<c:url value='/shop/viewCart2'></c:url>'>공동 구매</a> 
			</c:if>
			<c:if test="${category eq '3' }">
				<a class="btn btn-outline-primary" id="buttons"
				href='<c:url value='/shop/viewCart3'></c:url>'>경매 낙찰</a>
			</c:if>
			<c:if test="${category ne '3' }">
				<a class="btn buy" id="buttons"
				href='<c:url value='/shop/viewCart3'></c:url>'>경매 낙찰</a>
			</c:if>
		</div>
		<br>
		<c:if test="${category eq '1' }">
			<div class="info">
				<ul>
					<li class="highlight">판매자와 직접 만나서 거래하는 상품입니다.</li>
					<li>예약 내역으로 판매자가 판매 완료 버튼을 눌러야 거래가 완료됩니다.</li>
					<li>구매를 원하지 않으실 경우 삭제 버튼을 누르시면 정상적으로 삭제가 됩니다.</li>
				</ul>
			</div>
			<hr>
			<div>
				<table>
					<c:if test="${empty productList}">
						<tr>
							<td colspan="3"><span class="empty bold"> 장바구니에 담긴
									상품이 없습니다.</span> <br> <span class="empty">원하는 상품을 장바구니에
									담아보세요!</span></td>
						</tr>
					</c:if>
					<c:if test="${not empty productList}">
						<tr>
							<td class="pTitle">상품 정보</td>
							<td class="pPrice">가격</td>
							<td class="pButton">구매 여부</td>
						</tr>
						<c:forEach var="cartItem" items="${productList}">
							<tr class="list">
								<td class="pTitle"><a class="go"
									href='<c:url value="/detail/item">
		                           <c:param name="item_id" value="${cartItem.item_id }"/></c:url>'>
										<img src="/images/${cartItem.fileName }" class="thumbnail title">
								</a>&nbsp; <a class="go"
									href='<c:url value="/detail/item">
		                           <c:param name="item_id" value="${cartItem.item_id }"/></c:url>'>
										[제목] <c:out value="${cartItem.title}" />
								</a></td>
								<td class="pPrice"><c:out value="${cartItem.price}" />원</td>
								<td class="pButton"><a class="btn delete" id="buttons"
									href='<c:url value='/item/delete'>
		                           <c:param name="item_id" value="${cartItem.item_id}"/></c:url>' onclick = "return confirm('정말 삭제 하시겠습니까?')">
										예약 취소</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</c:if>
		<c:if test="${category eq '2' }">
			<div class="info">
				<ul>
					<li class="highlight">예약 내역으로 마감 기간안에 구매 버튼을 눌러서 구매를 완료해주셔야
						합니다.</li>
					<li>나와있는 가격은 최대 인원에 맞게 계산된 실제 결제될 가격입니다.</li>
					<li>구매를 원하지 않으실 경우 삭제 버튼을 누르시면 정상적으로 삭제가 됩니다.</li>
				</ul>
			</div>
			<hr>
			<div>
				<table>
					<c:if test="${empty productList}">
						<tr>
							<td colspan="3"><span class="empty bold"> 장바구니에 담긴
									상품이 없습니다.</span> <br> <span class="empty">원하는 상품을 장바구니에
									담아보세요!</span></td>
						</tr>
					</c:if>
					<c:if test="${not empty productList}">
						<tr>
							<td class="pTitle">상품 정보</td>
							<td class="pPrice">가격</td>
							<td class="pButton">구매 여부</td>
						</tr>
						<c:forEach var="cartGroup" items="${productList}">
							<tr class="list">
								<td class="pTitle"><a class="go"
									href='<c:url value="/detail/group">
                           <c:param name="group_id" value="${cartGroup.group_id }"/></c:url>'>
										<img src="/images/${cartGroup.fileName }" class="thumbnail title">
								</a>&nbsp; <a class="go"
									href='<c:url value="/detail/group">
                           <c:param name="group_id" value="${cartGroup.group_id }"/></c:url>'>
										[제목] <c:out value="${cartGroup.title}" />
								</a></td>
								<td class="pPrice"><c:out
										value="${cartGroup.discountPrice}" />원 / 인</td>
								<td class="pButton"><a class="btn delete" id="buttons"
									href='<c:url value='/group/delete'>
                           <c:param name="group_id" value="${cartGroup.group_id}"/></c:url>' onclick = "return confirm('정말 삭제 하시겠습니까?')">
										삭제</a> <a class="btn btn-outline-primary buy" id="buttons"
									href='<c:url value='/group/purchase'>
                           <c:param name="group_id" value="${cartGroup.group_id}"/></c:url>' >
										구매</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</c:if>
		<c:if test="${category eq '3' }">
			<div class="info">
         <ul>
            <li class="highlight">현재는 예약 내역으로 구매 버튼을 누르셔야 최종 구매가 확정됨을 알려드립니다.</li>
            <li>현재 보이는 가격은 경매에서 입찰된 최고 입찰 금액임을 알려드립니다.</li>
            <li>구매를 원하지 않으실 경우, 포기 버튼을 누르시면 낙찰이 포기됨을 알려드립니다.</li>
         </ul>
      </div>
      <hr>
      <div>
         <table>
            <!-- 장바구니에 상품이 없을 때 만들어야함. -->
            <c:if test="${empty productList}">
               <tr>
                  <td colspan="3"><span class="empty bold"> 낙찰된 상품이 없습니다. </span> <br> <span class="empty">원하는 상품을 입찰해보세요! </span></td>
               </tr>
            </c:if>
            <c:if test="${not empty productList}">
               <tr>
                  <td class="pTitle">상품 정보</td>
                  <td class="pPrice">낙찰 금액</td>
                  <td class="pButton">구매 여부</td>
               </tr>
               <c:forEach var="cartAuction" items="${productList}">
                  <tr class="list">
                     <td class="pTitle"><a class="go title" href='<c:url value="/detail/auction">
                        <c:param name="auction_id" value="${cartAuction.auction_id }"/></c:url>'>
                              <img src="/images/${cartAuction.fileName}" class="card-img-top thumbnail title">
                        </a>&nbsp; <a class="go title" href='<c:url value="/detail/auction">
                           <c:param name="auction_id" value="${cartAuction.auction_id }"/></c:url>'>
                              [제목] <c:out value="${cartAuction.title}" />
                        </a></td>
                     <td class="pPrice"><c:out value="${cartAuction.sucbid_price}" />원</td>
                     <td class="pButton"><a class="btn delete" id="buttons" href='<c:url value='/auction/delete'>
                           <c:param name="auction_id" value="${cartAuction.auction_id}"/></c:url>' onclick = "return confirm('낙찰을 포기하시겠습니까?')">
                           포기</a> <a class="btn btn-outline-primary buy" id="buttons" href='<c:url value='/auction/purchase'>
                           <c:param name="auction_id" value="${cartAuction.auction_id}"/></c:url>' onclick = "return confirm('구매하시겠습니까?')">
                           구매</a></td>
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