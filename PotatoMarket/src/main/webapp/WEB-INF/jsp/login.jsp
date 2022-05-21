<%@ page contentType="text/html; charset=utf-8" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
<jsp:include page="navbar.jsp" />
 <script>
function login() {
	if (form.member_id.value == "") {
		alert("아이디를 입력하십시오.");
		form.member_id.focus();
		return false;
	} 
	if (form.pw.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.pw.focus();
		return false;
	}		
	form.submit();
}

function memberCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<html>
<title>로그인</title>
<style>
#buttons {
	background:#966147;
	color:#fff;
	width: 50%;
	font-size: 16px;
	float: none;
	margin: 0 auto;
}

#btn{
		background:#966147;
	color:#fff;
	width: 50%;
	font-size: 16px;
	float: none;
	margin: 0 auto;
}

@media ( min-width : 1200px) {
	.container {
		width: 1170px;
	}
}

body
{
	background:#f0deb9;
	background-image: url('../images/join_potato.png')
}

h2
{
	color:#966147;
	margin:40px 0 0px 0;
	font-weight:300;
}

#input_id, #pw{
	
  font-family:'굴림체';
}
}

</style>
</head>

<!-- Custom styles for this template -->
<body class="body">
<body>
	<br>
	<!-- login form  -->
	<div class="py-4 text-center">
		<h2 id="logo">로그인</h2>
	</div>
	<div class="container"
		style="display: flex; justify-content: center; align-items: center;">
		<div>
			<form name="form" method="POST"
				action="<c:url value='/member/login' />">
				<div class="row">
					<div class="col-md-12">
						<label for="id" id="menu">아이디</label>
					</div>
					<div class="col-md-12 mb-3">
						<input type="text" class="form-control" name="member_id" value="" id="input_id"
							placeholder="아이디">
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label for="password" id="menu">비밀번호 <span
							class="text-muted"></span></label>
					</div>
					<div class="col-md-12 mb-3">
						<input type="password" class="form-control" placeholder="비밀번호" id="pw"
							value="" name="pw" required>
					</div>
				</div>
				<c:if test="${loginFailed}">
					<br>
					<font color="red"><c:out value="${exception.getMessage()}" /></font>
					<br>
				</c:if>
				
				<hr class="mb-4">
				<div style="text-align: center;">
					<button class="btn btn-primary btn-dark" id="btn" type="button"
						onClick="login()" style="width:30%">로그인</button>
					&nbsp; &nbsp;				

					<button class="btn btn-primary btn-dark" id="buttons"
						type="button" style="width:35%"
						onClick="location.href='/member/join'">회원가입</button>
				</div>
			</form>	
		</div>
	</div>
</body>

<!-- 엔터 키 인식 -->
<script>
var input = document.getElementById("pw");
input.addEventListener("keyup", function(event) {
  if (event.keyCode === 13) {
   event.preventDefault();
   document.getElementById("btn").click();
  }
});
</script>
</html>
<%@ include file="IncludeBottom.jsp"%>