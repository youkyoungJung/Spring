<%@ page contentType="text/html; charset=utf-8" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입찰 확인창</title>
<jsp:include page="navbar.jsp" />
<style>
@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

th {
	vertical-align: middle !important;
	text-align: center !important;
}

h3, th, td {
	font-family: Cafe24Simplehae;
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
.empty{
	color: gray;
	font-size: 20px;
	margin-left:auto;
	margin-right: auto;
}
.bold {
	font-weight: bold;
}

span {
	padding-left:350px;
}
.btns {
	padding-left:380px;
}
.buy {
	background-color: #f0deb9;
	vertical-align: 50%;
	margin-left: 10px;
}
#buttons {
	color: black;
}
</style>
</head>
<body>
	<div class="main">
		<h3>' <c:out value="${title}" /> ' 의 입찰 현황</h3>
		<div>
			<table class="table table-bordered">
				<thead>
					<tr class="active">
						<th></th>
						<th>입찰자 아이디</th>
						<th>입찰 금액</th>
						<th>입찰 시간</th>
					</tr>
				</thead>
				<c:if test="${empty bidlist}">
					<tr>
						<td colspan="4">
							<span class="empty bold"> 입찰자가 없습니다. </span>
							<br>
						</td>
					</tr>
				</c:if>
				<c:if test="${not empty bidlist}">
				<c:forEach var="bidList" items="${bidlist}" varStatus="status">
					<tbody>
						<tr class="bidlistdata">
							<td>${status.count}</td>
							<td>${bidList.buyer_id}</td>
							<td>${bidList.bid_price}원</td>
							<td>${bidList.bid_date}</td>
						</tr>
					</tbody>
				</c:forEach>
				</c:if>
			</table>
		</div>
		<p>
		<div class="btns">
		<a class="btn buy " id="buttons" href="<c:url value='/list/auction'></c:url>">경매 HOME</a>
        </div>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp" %>