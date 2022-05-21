<%@ page contentType="text/html; charset=utf-8" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<head>
<jsp:include page="navbar.jsp" />
<script>

function login(targetUri) {
	form.action = targetUri;
	form.submit();	
}
function onCreate() {
	form.submit();	
}
</script>
<html>
<title>회원 가입</title>
<style>
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

label
{
	color:#9A6B31;
}


#buttons {
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
</style>
</head>

<!-- Custom styles for this template  action="<c:url value='/member/join' />"-->
<body class="body">
	
	<div class="py-5 text-center">
		<h2 id="logo">회원 가입</h2>
	</div>
	<div class="container"
		style="display: flex; justify-content: center; align-items: center;">
		<div>
			<form:form method="POST" modelAttribute="member" action="/member/save"
				 class="needs-validation">
				<div class="row">
					<div class="col-md-12">
						<label for="name" id="menu">이름</label>
					</div>
					<div class="col-md-12 mb-3">
						<form:input path="name" type="text" class="form-control" placeholder="이름" value=""
							width="50%" name="name"/>
						<form:errors path="name"/>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label for="member_id" id="menu">아이디</label>
						<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
					<c:if test="${registerFailed}">
						<font color="red"><c:out value="${exception.getMessage()}" /></font>
					</c:if>
					</div>
					<div class="col-md-12 mb-3">
						<form:input type="text" class="form-control" path="member_id" value=""
							placeholder="아이디"/>
						<form:errors path="member_id"/>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label for="pw" id="menu">비밀번호 <span
							class="text-muted"></span></label>
					</div>
					<div class="col-md-12 mb-3">
						<form:input  class="form-control" placeholder="비밀번호"
							value="" path="pw" />
						<form:errors path="pw"/>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label for="pw2" id="menu">비밀번호 확인 <span
							class="text-muted"></span></label>
					</div>
					<div class="col-md-12 mb-3">
						<form:input  class="form-control" placeholder="비밀번호"
							value="" path="pw2" />
						<form:errors path="pw2"/>
						<form:errors path="samePasswordConfirmPassword"/>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<label for="email" id="menu">Email</label>
					</div>
					<div class="col-md-12 mb-3">
						<form:input type="text" class="form-control"
							placeholder="you@example.com" path="email"/>
						<form:errors path="email"/>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label for="phoneNumber" id="menu">휴대전화</label>
					</div>
					<div class="col-md-12 mb-3">
						<form:input type="text" class="form-control"
							placeholder="예) 010-xxxx-xxxx" value="" path="tel" />
						<form:errors path="tel"/>
					</div>
				</div>
				<hr class="mb-3">
				<div style="text-align: center;">
					<button class="btn btn-primary btn-secondary" id="buttons"
						type="submit" style="width: 30%"onClick="login('value='/member/save'/>')">회원가입</button>
					&nbsp; &nbsp;
					<button class="btn btn-primary btn-secondary" id="buttons"
						type="button" style="width: 20%"
						onClick="location.href='/member/login'">취소</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>