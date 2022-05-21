<%@ page contentType="text/html; charset=utf-8" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="navbar.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<title>공동구매 - 결제 완료</title>
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
.main{
	padding: 20px;
	width: 890px;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
	border: 1px solid #e9ecef;
	background-color: white;
	border-radius: 20px;
}

/* .top, .store, .content {
	display: inline-block;
} */

.info {
	padding-top: 30px;
}

.top {
	margin-left:30px;
	margin-right: 30px;
	margin-bottom:30px;
	margin-top:30px;
}
.pic {
	width: 500px;
	height: 400px; 
	vertical-align: top;
}

.title {
	font-family: Cafe24Simplehae;
	text-decoration: underline;
	font-weight: bold;
	font-size: 30px;
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
.precautions{
	font-size:15px;
	color: #1fa35d;
}
.potato{
	color: #1fa35d;
}
</style>
</head>
<body>
	<div class="main">
		<div class="top pic">
			<h2><span class="potato">감</span>사합니다! <span class="potato">자</span>알~결제되었습니다!</h2>
			<br>
			<img src="/images/success.png" class="pic">
		</div>
		<br><br><br><br>
		<div class="top info">
			<span class="title">구매 상품 : <c:out value="${product.title }" /></span><br>
			<br> <br> 
			<span class="detail">결제 금액 : <c:out value="${product.discountPrice }" />원</span>
			<br> <br> 
		</div>
		<hr>
		<div class="top precautions">
		*본 상품은 환불 및 교환이 어려운 상품입니다. <br>
		*판매자의 문제로 상품을 취소 해야할 경우, potato@gmail.com 으로 메일을 남겨주시면 3일안에 처리해드리겠습니다.
		</div>
		<div class="top">
		
		</div>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>