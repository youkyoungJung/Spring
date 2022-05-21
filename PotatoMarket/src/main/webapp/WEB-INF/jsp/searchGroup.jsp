<%@ page contentType="text/html; charset=utf-8" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공동 구매 - 전체 상품 화면</title>
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

#buttons {
   background-color: #EFEFEF;
}
.close{
	background-color : #c2c2c2;
}
</style>
</head>
<body>
	<div class="row row-cols-1 row-cols-md-3 g-4 main">
		<h2>
			<c:out value="${category}" />
			<c:if test="${isLogin}">
				<a class="btn pull-right" style="margin-right: 30px;" id="buttons"
					href="<c:url value='/add/group'>
            <c:param name='memberId' value='${member_id}'/>
            <c:param name='group_id' value='0'/></c:url>">상품
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
		<c:forEach var="product" items="${productList.pageList}">
			<c:if test="${product.status eq 'OPEN'}">
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
										value="${product.discountPrice}" />원</a>
							</p>
						</div>
						<div class="card-footer">
							<small class="text-muted"> 현재 인원 : <c:out
									value="${product.currentPeople }" />명
							</small>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${product.status eq 'CLOSE'}">
				<div class="col list-card close">
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
										value="${product.discountPrice}" />원</a>
							</p>
						</div>
						<div class="card-footer">
							판매 완료
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
				href='<c:url value="/list/group2">
            <c:param name="page" value="previous"/></c:url>'>
				<B>&lt;&lt; Prev</B>
			</a>
		</c:if>
		<c:if test="${!productList.lastPage}">
			<a
				href='<c:url value="/list/group2">
            <c:param name="page" value="next"/></c:url>'>
				<B>Next &gt;&gt;</B>
			</a>
		</c:if>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>