<%@ page contentType="text/html; charset=utf-8" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
  <jsp:include page="navbar.jsp" />
<script type="text/javascript">
</script>
<html>
<title>마이페이지 - 회원 정보</title>
<style>

#menus {
   font-family: Cafe24Simplehae;
   font-weight: bold;
   font-size: 20px;
}

#text {
   font-family: Cafe24Simplehae;
   font-size: 20px;
}

#buttons {
   width: 15%;
   font-size: 16px;
   float: none;
   margin: 0 auto;
}

table {
   table-layout: fixed;
}

th {
   width: 200px;
}
</style>
</head>

<!-- Custom styles for this template -->
<body class="bg-light">
   <div class="py-5">
      <h2 style="text-align: center;" id="logo">회원 정보</h2>
      <a class="btn float-right btn-danger"
         style="margin-left: 1000px; width: 9%;" id="buttons"
         href="<c:url value='/member/delete'>
                 <c:param name='member_id' value='${member_id}'/>
              </c:url>"
         onClick="return confirm('정말삭제하시겠습니까?')">회원 탈퇴</a>
         <p>
   </div>
   <div class="container"
      style="display: flex; justify-content: center; align-items: center;">
      <form name="form" method="POST"
         action="<c:url value='/member/profile' />" class="needs-validation"
         novalidate>
         <table class="table" style="width: 800px">
            <tbody>
               <tr>
                  <th class="table-secondary text-center" id="menus">이름</th>
                  <td id="text">${name}</td>
               </tr>
               <tr>
                  <th class="table-secondary text-center" id="menus">아이디</th>
                  <td id="text">${member_id}</td>
               </tr>
               <tr>
                  <th class="table-secondary text-center" id="menus">비밀번호</th>
                  <td id="text">***********</td>
               </tr>
               <tr>
                  <th class="table-secondary text-center" id="menus">이메일</th>
                  <td id="text">${email}</td>
               </tr>
               <tr>
                  <th class="table-secondary text-center" id="menus">휴대전화</th>
                  <td id="text">${tel}</td>
               </tr>
            </tbody>
         </table>
         <hr class="mb-4">
         <div align="center">
            <a class="btn btn-primary btn-dark" id="buttons" style="width: 9%;"
               href="<c:url value='/member/update'>
              </c:url>">수정</a>&nbsp;
            &nbsp; <a class="btn btn-primary btn-secondary" id="buttons"
               style="width: 9%;"
               onClick="location.href='/member/mypage'">
              취소</a>&nbsp;
            &nbsp;
         </div>
      </form>
   </div>
</body>
</html>
<%@ include file="IncludeBottom.jsp"%>