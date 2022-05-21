<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="<c:url value='/css/style.css'></c:url>">
<link rel="stylesheet" href="<c:url value='/css/search.css'></c:url>">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">



  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<!-- 메시지 관련 script -->
<script>
	function message_open(caller_id) {
		window.open("<c:url value='/chat/" + caller_id + "'/>", "people",
				"width=530, height=500, location=no, status=no");

	}
</script>


<style>
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

.box-radio-input input[type="radio"] {
	display: none;
}

.box-radio-input input[type="radio"]+span {
	display: inline-block;
	background: none;
	border: 1px solid #dfdfdf;
	padding: 0px 10px;
	text-align: center;
	height: 35px;
	line-height: 33px;
	font-weight: 500;
	cursor: pointer;
}

.box-radio-input input[type="radio"]:checked+span {
	border: 1px solid #977765;
	background: #977765;
	color: #fff;
}


#custom-search-input{
    padding: 3px;
    border: solid 1px #E4E4E4;
    border-radius: 6px;
    background-color: #fff;
    width: 40%
}

#custom-search-input input{
    border: 0;
    box-shadow: none;
}

#custom-search-input button{
    margin: 2px 0 0 0;
    background: none;
    box-shadow: none;
    border: 0;
    color: #666666;
    padding: 0 8px 0 10px;
    border-left: solid 1px #ccc;
}

#custom-search-input button:hover{
    border: 0;
    box-shadow: none;
    border-left: solid 1px #ccc;
}

#custom-search-input .glyphicon-search{
    font-size: 23px;
}


</style>

</head>
<body>
	<section class="header-top-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<div class="header-top-menu">
						<ul class="nav nav-pills navbar-right">
							<li><a href="<c:url value='/member/mypage'></c:url>">My
									Potato</a></li>
							<li><a href="<c:url value='/member/likes1'></c:url>">Wishlist</a></li>
							<c:if test="${!isLogin}">
								<li><a href="<c:url value='/member/login'/>"><i
										class="pe-7s-lock"></i>Login/Register</a></li>
							</c:if>
							<c:if test="${isLogin}">
								<li><a href="<c:url value='/member/logout'/>"><i
										class="pe-7s-lock"></i>Logout</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

	<header class="header-section">
		<nav class="navbar navbar-default">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/"> <img src="/images/logo.png"
						width="50" height="50" class="d-inline-block brand-image" alt=""
						loading="lazy"></a> <a class="navbar-brand" href="/"><b>감자</b>마켓</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/">Home</a></li>
						<li><a href="/list/item">직거래</a></li>
						<li><a href="/list/group">공동구매</a></li>
						<li><a href="/list/auction">경매</a></li>
						<c:if test="${!isLogin}">
							<li><a href="<c:url value='/member/login'/>">감자톡</a></li>
						</c:if>
						<c:if test="${isLogin}">
							<li><a href="#"
								onclick="message_open('<%=(String) session.getAttribute("member_id")%>'); return false;">감자톡</a></li>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right cart-menu">
                  		<li><a class="search-btn"><i class="fa fa-search"
                        aria-hidden="true">&nbsp;&nbsp;&nbsp;&nbsp;</i></a></li>

						<c:if test="${isLogin}">
							<li><a href="/shop/viewCart1"><span> Cart&nbsp;</span> <span
									class="shoping-cart">&nbsp;</span></a></li>
						</c:if>
						<c:if test="${!isLogin}">
							<li><a href="/member/login"><span> Cart&nbsp;</span> <span
									class="shoping-cart">&nbsp;</span></a></li>
						</c:if>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
	</header>

	<!-- 검색뷰 시작 -->
	<section class="search-section">

		<!-- 
		<form action="<c:url value='/search'/>" accept-charset="utf-8">
			회원 간 거래 <input type="radio" checked="checked" name="type" value="item">
			공동구매 <input type="radio" name="type" value="group">
			경매 <input type="radio" name="type" value="auction">			
			<br>
			
			
			<input type="search" name="search">
			
			<button type="submit"> 검색하기 </button>
		</form>
		-->
		<div align="center">
		<form action="<c:url value='/search'/>" accept-charset="utf-8">
			<label class="box-radio-input"><input type="radio"
				name="type" value="item" checked="checked"><span>직거래</span></label> <label class="box-radio-input"><input type="radio"
				name="type" value="group"><span>공동구매</span></label> <label
				class="box-radio-input"><input type="radio" name="type"
				value="auction"><span>경매</span></label> <br>
		
			<br>


            <div id="custom-search-input">
                <div class="input-group col-md-12">
                    <input type="text" class="form-control input-lg" placeholder="검색어를 입력하세요." name="search"/>
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="submit">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>


</div>
		</form>
		</div>
	</section>
	<!-- 검색 끝 -->

	<!-- JQUERY -->
	<script src="/js/vendor/jquery-1.11.2.min.js"></script>
	<script src="/js/vendor/bootstrap.min.js"></script>
	<script src="/js/isotope.pkgd.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/wow.min.js"></script>
	<script src="/js/custom.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>