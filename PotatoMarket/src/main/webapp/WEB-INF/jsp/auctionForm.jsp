<%@ page contentType="text/html; charset=utf-8" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 등록 - 경매</title>
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

.top, .store {
	margin-left: 150px;
	display: inline-block;
}

.info {
	padding-top: 30px;
}

.top {
	margin-top: 30px;
	margin-bottom: 30px;
}

.info, .pic {
	width: 150px;
	height: 150px;
}

.title {
	font-family: Cafe24Simplehae;
	text-decoration: underline;
	font-weight: bold;
	font-size: 40px;
}

h3, h4 {
	font-family: Cafe24Simplehae;
}

label {
	font-family: Cafe24Simplehae;
	font-weight: bold;
	font-size: 18px;
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

textarea {
	resize: none;
}

#buttons {
	font-family: Cafe24Simplehae;
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

hr {
	width: 850px;
	align: left;
}
</style>
</head>
<script>
function cancle(targetUri) {
	form.action = targetUri;
	form.submit();	
}
</script>
<body>
	<div class="main">
		<form:form modelAttribute="auctionForm" method="post" enctype="multipart/form-data" name="form">
			<h3>상품 등록 : 경매</h3>
			<hr>
			<h4>기본정보</h4>
			<hr>
			<label>상품 이미지</label>
			<p><input type="file" name="files" id="files" required>
			<hr>
			<form:hidden path="auction.member_id" value="${memberId}"/>
			<label for="auction.title">제목</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<form:input path="auction.title" type="text" name="title" value="" placeholder="상품 제목을 입력해주세요." size="80" maxlength="50" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><form:errors path="auction.title"/></font>
			<hr>
			<label for="auction.auction.price">가격</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<form:input path="auction.price" type="number" name="price" value="" placeholder="숫자만 입력해주세요." />원
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><form:errors path="auction.price"/></font>
			<hr>
			<label for="auction.auctionPrice">입찰 단위</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<form:input path="auction.auctionPrice" type="number" name="auctionPrice" value="" placeholder="숫자만 입력해주세요." />원
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><form:errors path="auction.auctionPrice"/></font>
			<hr>
			<label for="auction.end_date">경매 종료일</label>&nbsp;&nbsp;
			<form:input path="auction.end_date" type="date" name="end_date" value="2021-06-19" min="2021-06-19" max="2022-06-19" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><form:errors path="auction.end_date"/></font>
			<hr>
			<label for="auction.content">상품 설명</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><form:errors path="auction.content"/></font>
			<p><form:textarea path="auction.content" class="form-control content" id="exampleFormControlTextarea1" cols="100" rows="10"
					name="content" placeholder="상품 설명을 입력해주세요." />
			<div style="text-align: center">	
				<input class="btn btn-warning btn-primary" id="buttons" type="submit" value="등록">	
				&nbsp;
				<button class="btn btn-outline-warning btn-primary" id="buttons" type="submit"
				onClick="cancle('<c:url value='/list/auction' />')">취소</button>
			</div>
		</form:form>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>