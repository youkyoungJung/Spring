<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="navbar.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<title>공동구매 상세</title>
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
	padding: 20px;
	width: 890px;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
	border: 1px solid #e9ecef;
	background-color: white;
	border-radius: 20px;
}

.top, .store, .content {
	display: inline-block;
}

.info {
	padding-top: 30px;
}

.top {
	margin-top: 30px;
	margin-bottom: 30px;
}

.pic {
	margin-right: 30px;
}

.info, .pic {
	width: 400px;
	height: 400px;
	vertical-align: top;
}

.title {
	font-family: Cafe24Simplehae;
	text-decoration: underline;
	font-weight: bold;
	font-size: 40px;
}

h3 {
	font-family: Cafe24Simplehae;
	text-decoration: underline;
}

.detail {
	font-size: 20px;
	vertical-align: middle;
}

.seller {
	width: 50px;
	height: 50px;
	object-fit: cover;
	border-radius: 50%;
}

.name {
	margin-left: 20px;
	font-size: 20px;
	color: balck;
	vertical-align: 50%;
}

.talk, .buy {
	background-color: #f0deb9;
	vertical-align: 50%;
	margin-left: 10px;
}

.like {
	background-color: white;
	border: solid 1px #f0deb9;
	vertical-align: 50%;
	margin-left: 10px;
}

.btn-outline-primary:hover {
	background-color: #f0deb9;
}

.content {
	min-height: 1000px;
}

.cont_detail {
	font-size: 20px;
}

.prod_detail {
	font-family: Cafe24Simplehae;
	font-size: 40px;
}

#buttons {
	color: black;
}

.close, .close:hover {
	color: red;
}
</style>

<script>
	function toMessage(caller_id, receiver_id) {
		window.open(
				"<c:url value='/chat/" + caller_id + "/" + receiver_id + "'/>",
				"chatting", "width=600,height=725,location=no,status=no");

	}
</script>

</head>
<body>
	<div class="main">
		<div class="top pic">
			<img src="/images/${product.fileName }" class="pic">
		</div>
		<div class="top info">
			<span class="title"><c:out value="${product.title }" /></span><br>
			<br> <br> <span class="detail">판매가 : <c:out
					value="${product.price }" />원
			</span><br> <br> <span class="detail">할인 금액 : <c:out
					value="${product.discountPrice }" />원
			</span><br> <br> <span class="detail">최대 인원 : <c:out
					value="${product.maxPeople }" />명
			</span><br> <br> <span class="detail">구매가능일자 : <c:out
					value="${product.startDate }" /> ~ <c:out
					value="${product.endDate }" /></span><br> <br> <span
				class="detail">현재 구매 인원: <c:out
					value="${product.currentPeople }" />명
			</span><br> <br> <br>
			<c:if test="${product.status eq 'OPEN'}">
				<a class="btn buy" id="buttons"
					href='<c:url value='/shop/addGroupToCart'>
	            <c:param name="group_id" value="${product.group_id}"/></c:url>'>구매예약</a>
				<a class="btn btn-outline-primary like" id="buttons"
					href='<c:url value='/shop/addGroupLike'>
		    	 <c:param name="group_id" value="${product.group_id}"/></c:url>'>♡
					찜 <c:out value="${product.likes }" />
				</a>
			</c:if>
			<c:if test="${product.status eq 'CLOSE'}">
				<span class="close info">이 상품은 구매 불가 상품입니다.</span>
			</c:if>
		</div>
		<hr>
		<div class="store">
			<h3>상점 정보</h3>
			<img src="/images/profile.png" class="seller"> <a href="#"><span
				class="name"><c:out value="${product.seller_id }" /></span></a>

			<c:if test="${!isLogin}">
				<input type="button" class="btn talk" value="감자톡"
					onClick="location.href='<c:url value='/member/login'/>'">
			</c:if>
			<c:if test="${isLogin}">
				<c:set var="id" value="${sessionScope.member_id}" />

				<c:if test="${id eq product.seller_id}">
				
				</c:if>

				<c:if test="${id ne product.seller_id}">
					<input type="button" class="btn talk" value="감자톡"
						onClick="toMessage('${id}', '${product.seller_id }'); false;">
				</c:if>
			</c:if>

		</div>
		<hr>
		<br>
		<div class="content">
			<span class="prod_detail">상품 정보</span>
			<hr width="500px">
			<div class="cont_detail">
				<c:out value="${product.content }" />
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>