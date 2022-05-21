<%@ page contentType="text/html; charset=utf-8" %>  
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공동구매 - 등록 상품 List</title>
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

.group, .auction{
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

.cart {
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
	padding-top:10px;
	padding-bottom : 10px;
}

tr {
	border-left-style: hidden;
	border-right-style: hidden;
}

.pPirce{
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
	background-color:#edf2ee;
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
.title{
	display: inline-block; 
}
.empty{
	color: gray;
	font-size: 20px;
	margin-left:auto;
	margin-right: auto;
}
.complete{
	color:red;
}
</style>
</head>
<body>
	<div class="group">
		<div class="cart">
			<span class="bold">등록 확인</span> | <c:out value="${category}"/>
		</div>
		<br>
		<hr>
		<div>
			<table>
				<c:if test="${empty productList}">
					<tr>
						<td colspan="3">
							<span class="empty bold"> 등록된 상품이 없습니다.</span>
							<br>
						</td>
					</tr>
				</c:if>
				<c:if test="${not empty productList}">
					<c:forEach var="product" items="${productList}">
					<tr class="list">
						<td class="pTitle"><a class="go" href='<c:url value="/detail/group">
	          				  <c:param name="group_id" value="${product.group_id }"/></c:url>'>
	          				  <img src="/images/${product.fileName }" class="thumbnail title"></a>&nbsp;
							<a class="go" href='<c:url value="/detail/group">
	          				  <c:param name="group_id" value="${product.group_id }"/></c:url>'>
	          				  [제목] <c:out value="${product.title}" />
	          				</a>
	          			</td>
	          			<c:if test="${product.status eq 'OPEN'}">
						<td class="pButton">
							<a class="btn btn-outline-primary buy" id="buttons" href='<c:url value='/edit/group'>
		            				<c:param name="group_id" value="${product.group_id}"/></c:url>'>
		            			수정</a>
							<a class="btn delete" id="buttons" href='<c:url value='/delete/group'>
	            				<c:param name="group_id" value="${product.group_id}"/></c:url>' onclick = "return confirm('정말 삭제하시겠습니까?')">
	            			삭제</a> 
						</td>
						</c:if>
						<c:if test="${product.status eq 'CLOSE'}">
							<td class="pButton">
								<h3 class = "complete">판매 완료</h3>
							</td>
						</c:if>
					</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp" %>