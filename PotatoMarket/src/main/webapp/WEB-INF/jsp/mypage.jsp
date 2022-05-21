
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>

<head>
<jsp:include page="navbar.jsp" />
   <title>My Potato</title>
</head>
<style>
body
{
   background:#f0deb9;
}

h1
{
   color:#fff;
   margin:40px 0 60px 0;
   font-weight:300;
}

.our-team-main
{
   float:left;
   width:100%;
   height:auto;
   border-bottom:5px #323233 solid;
   background:#fff;
   text-align:center;
   border-radius:10px;
   overflow:hidden;
   position:relative;
   transition:0.5s;
   margin-bottom:28px;
}


.our-team-main img
{
   border-radius:50%;
   margin-bottom:20px;
   width: 90px;
}

.our-team-main h3
{
   font-size:20px;
   font-weight:700;
}

.our-team-main p
{
   margin-bottom:0;
}


.team-front
{
   width:100%;
   height:auto;
   position:relative;
   z-index:10;
   background:#fff;
   padding:15px;
   bottom:0px;
   transition: all 0.5s ease;
}
/*
.our-team-main .team-front
{
   bottom:-200px;
   transition: all 0.5s ease;
}

.our-team-main
{
   border-color:#777;
   transition:0.5s;
}
*/
/*our-team-main*/


     
</style>

<section id="my_page">

    <h1 class="text-center">MY POTATO</h1>

   
   <div class="container">
   <div class="row">
   
   <!--team-1-->
   <div class="col-lg-4">
   <div class="our-team-main">
   
   <div class="team-front">
    <a href="<c:url value="/member/profile"/>">
     <img src="/images/annoy.png" width="100" height="90" class="img-fluid"/></a>
   <h3>회원정보 수정/탈퇴</h3>
   </div>
   
   
   </div>
   </div>
   <!--team-1-->
   
   <!--team-2-->
   <div class="col-lg-4">
   <div class="our-team-main">
   
   <div class="team-front">
    <a href="<c:url value="/member/purchaseDetail1"/>">
   <img src="/images/cook.png" width="50" height="90"  class="img-fluid" /></a>
   <h3>구매내역</h3>
   </div>
   
   
   </div>
   </div>
   <!--team-2-->
   
   <!--team-3-->
   <div class="col-lg-4">
   <div class="our-team-main">
   
   <div class="team-front">
    <a href="<c:url value="/member/likes1"/>">
   <img src="/images/logo.png" width="50" height="90" class="img-fluid" /></a>
    <h3>관심목록확인</h3>
   </div>

   
   </div>
   </div>
   <!--team-3-->
   
   <!--team-4-->
   <div class="col-lg-4">
   <div class="our-team-main">
   
   <div class="team-front">
   <a href='<c:url value="/check/addList">
     <c:param name="category" value="직거래"/></c:url>'>
   <img src="/images/stop.png" width="50" height="90" class="img-fluid" />
   </a>
   <h3>직거래</h3>
   </div>
   </div>
   </div>
   <!--team-4-->
   
   <!--team-5-->
   <div class="col-lg-4">
   <div class="our-team-main">
   
   <div class="team-front">
   <a href='<c:url value="/check/addList">
     <c:param name="category" value="공구"/></c:url>'>
   <img src="/images/happy.png" width="50" height="90" class="img-fluid" /></a>
   <h3>공동구매</h3>
   
   </div>
   </div>
   </div>
   <!--team-5-->
   
   <!--team-6-->
   <div class="col-lg-4">
   <div class="our-team-main">
   
   <div class="team-front">
   <a href='<c:url value="/check/addList">
     <c:param name="category" value="경매"/></c:url>'>
   <img src="/images/mad.png" width="200" height="90" class="img-fluid" />
   </a>
   <h3>경매</h3>

   </div>
   
   </div>
   </div>
   <!--team-6-->
   
   
   
   </div>
   </div>
</section>
<%@ include file="IncludeBottom.jsp"%>