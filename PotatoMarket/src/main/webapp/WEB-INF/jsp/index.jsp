<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>감사합니다. 자알먹을게요! 감자마켓</title>
<style>
.thumb{
	width:250px;
	height:270px;
}

h3{
	width:180px;
	text-overflow: ellipsis;
	overflow:hidden;
	white-space:nowrap;
}
.thumb-image{
	margin: auto;
	width:250px;
	height:250px;
}
</style>
<jsp:include page="navbar.jsp" />

</head>
<body>


	<section class="slider-section">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators slider-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="images/slider1.jpg" width="1648" height="600" alt="">
					<div class="carousel-caption">
						<h2>
							PUMPKIN <b>&</b> POTATO
						</H2>
						<H2>
							<b>&</b> SWEET POTATO
						</h2>
						<h3>
							<Span>SALE</Span>
						</h3>
						<a href="#">Buy Now</a>
					</div>
				</div>
				
			</div>

			<!-- Controls 버튼 -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="pe-7s-angle-left glyphicon-chevron-left" aria-hidden="true"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="pe-7s-angle-right glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
	</section>

	<section class="featured-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titie-section wow fadeInDown animated ">
						<h1>NEW ITEMS</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="filter-menu">
						<ul class="button-group sort-button-group">
							<li class="button active" data-category="all">All</li>
							<!-- 여기서 span은 아이템 개수 -->
							<li class="button" data-category="cat-1">직거래</li>
							<li class="button" data-category="cat-2">공동구매</li>
							<li class="button" data-category="cat-3">경매</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row featured isotope">
				<c:forEach var="product" items="${productList.pageList }">
					<c:if test="${product.transaction eq 1}">
						<div class="col-md-3 col-sm-6 col-xs-12 cat-1 featured-items isotope-item">
							<div class="product-item">
							<div class="thumb">
								<c:if test="${empty product.filename }">
								<img src="images/logo.png" class="img-responsive thumb-image" alt="">
								</c:if>
								<c:if test="${not empty product.filename }">
								<img src="images/${product.filename }" class="img-responsive thumb-image"  alt="">
								</c:if>
							</div>
								<div class="product-hover">
									<div class="product-meta">
									<c:if test="${!isLogin}">
										<a href="/member/login"><i class="pe-7s-cart">
											</i>Add to Cart</a>
									</c:if>
									<c:if test="${isLogin}">
										<a href='<c:url value="/shop/addItemToCart">
		          				  <c:param name="item_id" value="${product.id }"/></c:url>'><i class="pe-7s-cart">
											</i>Add to Cart</a>
									</c:if>
										
									</div>
								</div>
								<div class="product-title">
									<a href='<c:url value="/detail/item">
		          				  <c:param name="item_id" value="${product.id }"/></c:url>'>
										<h3><c:out value="${product.title }"/></h3> <span><c:out value="${product.price }"/>원</span>
									</a>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${product.transaction eq 2}">
						<div class="col-md-3 col-sm-6 col-xs-12 cat-2 featured-items isotope-item right">
							<div class="product-item">
							<div class="thumb">
								<c:if test="${empty product.filename }">
								<img src="images/logo.png" class="img-responsive thumb-image" width="250"
									height="300" alt="">
								</c:if>
								<c:if test="${not empty product.filename }">
								<img src="images/${product.filename }" class="img-responsive thumb-image" width="250"
									height="300" alt="">
								</c:if>
								</div>
								<div class="product-hover">
									<div class="product-meta">
										<c:if test="${!isLogin}">
										<a href="/member/login"><i class="pe-7s-cart">
											</i>Add to Cart</a>
										</c:if>
										<c:if test="${isLogin}">
											<a href='<c:url value="/shop/addGroupToCart">
			          				  <c:param name="group_id" value="${product.id }"/></c:url>'><i class="pe-7s-cart">
												</i>Add to Cart</a>
										</c:if>
									</div>
								</div>
								<div class="product-title">
									<a href='<c:url value="/detail/group">
		          				  <c:param name="group_id" value="${product.id }"/></c:url>'>
										<h3><c:out value="${product.title }"/></h3> <span><c:out value="${product.price }"/>원</span>
									</a>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${product.transaction eq 3}">
						<div class="col-md-3 col-sm-6 col-xs-12 cat-3 featured-items isotope-item right">
							<div class="product-item">
							<div class="thumb">
								<c:if test="${empty product.filename }">
								<img src="images/logo.png" class="img-responsive thumb-image" width="250"
									height="300" alt="">
								</c:if>
								<c:if test="${not empty product.filename }">
								<img src="images/${product.filename }" class="img-responsive thumb-image" width="250"
									height="300" alt="">
								</c:if>
							</div>	
								<div class="product-title">
									<a href='<c:url value="/detail/auction">
		          				  <c:param name="auction_id" value="${product.id }"/></c:url>'>
										<h3><c:out value="${product.title }"/></h3> <span><c:out value="${product.price }"/>원</span>
									</a>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</section>

	<hr class="mb-4">
	<footer class="my-3 pt-3 text-muted text-center text-small">
		<p class="mb-1">&copy; 2021 POTATO MARKET</p>
		<ul class="list-inline">
			<li class="list-inline-item"><a href="#">Privacy</a></li>
			<li class="list-inline-item"><a href="#">Terms</a></li>
			<li class="list-inline-item"><a href="#">Support</a></li>
		</ul>
	</footer>

	
</body>
</html>