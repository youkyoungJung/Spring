<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
   href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
   rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="/css/message.css">

<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
   src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet">

<meta charset="EUC-KR">
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


</style>
<script type="text/javascript">
   
   var caller_id = "<c:out value='${caller}' />";
   var receiver_id = "<c:out value='${receiver}' />";
   var url = "/chat/" + caller_id + "/" + receiver_id;
   
   var size = "<c:out value='${fn:length(list)}' />"; //들어올 때 message_size(처음)

   var list_size = "<c:out value='${fn:length(list)}' />";; //계속 받아오는 size
   
   $(document).ready(function() {
      getMessage();
      $("#history").scrollTop($("#history")[0].scrollHeight);
   });


   function submitFunction() {
         var content = $('#content').val();

         var param = {
            "caller_id" : caller_id,
            "receiver_id" : receiver_id,
            "content" : content
         };

         $.ajax({
            type : "POST",
            data : param,
            url : "/chat/send",
            dataType : "json",
            async : true
         });
         
         $('#content').val('');   
   }

   function enterkey(){
      if (window.event.keyCode == 13){
         submitFunction();
      }
   }
   
   function readMessage() {
      $.ajax({
         type : "GET",
         url : "/chat/" + caller_id + "/" + receiver_id + "/list.json",
         contentType: "application/json",
      
         success : function(data) {
            list_size = Object.keys(data).length; //size 계속 불러옴
            
            if (list_size > size){ //처음보다 불러온 size가 크면
               
               if (data[list_size - 1].caller_id == caller_id){ //JSON에서 caller_id가 로그인한 유저일 경우(내가 보낸 메시지)
                  $('#area').append("<div class='outgoing_msg' id='outgoing_msg'>"
                        + "<div class='sent_msg'>" 
                        + "<p>" + data[list_size - 1].content + "</p>"
                        + "<span class='time_date'>" + data[list_size - 1].senttime + "</span>"
                        + "</div>"
                        + "</div>"
                        );
                  
                  size = list_size;
               }
            
               else if (data[list_size - 1].receiver_id == caller_id){
                  $('#area').append("<div class='incoming_msg' id='incoming_msg'>" 
                        + "<div class='incoming_msg_img'>"
                        + "<img src='/images/logo.png' alt='sunil'>"
                        + "</div>"
                        + "<div class='received_msg'>"
                        + "<div class='received_withd_msg'>"
                        + "<p>" + data[list_size - 1].content + "</p>"
                        +  "<span class='time_date'>" + data[list_size - 1].senttime + "</span>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "<br>"
                        );
                  
                  size = list_size;
               }
            
               $("#history").scrollTop($("#history")[0].scrollHeight); // 스크롤바 항상 맨 밑으로 유지
            }
         }

      });
   }
   
   function getMessage() {
      setInterval(function() {
         readMessage();
         
      }, 200);
   }
   
   function isitEmpty(){
	   if ($("#content").val().length==0){
		   alert("내용을 입력해주세요.");
	   }
	   else{
		   submitFunction();
	   }
   }
   
   
</script>

<title>메세지창</title>
</head>
<body>
   <c:set var="id" value="${sessionScope.member_id}" />

   <div class="messaging">
      <div class="mesgs">

         <div class="msg_history" id="history">
            <div id="area">
               <c:forEach var="list" items="${list}">

                  <c:if test="${list.caller_id eq id}">

                     <div class="outgoing_msg" id="outgoing_msg">
                        <div class="sent_msg">
                           <p>${list.content}</p>
                           <span class="time_date">${list.senttime}</span>
                        </div>
                     </div>
                  </c:if>

                  <c:if test="${list.caller_id ne id}">
                     <div class="incoming_msg" id="incoming_msg">
                        <div class="incoming_msg_img">
                           <img src="/images/logo.png" alt="sunil">
                        </div>
                        <div class="received_msg">
                           <div class="received_withd_msg">
                              <p>${list.content}</p>
                              <span class="time_date">${list.senttime}</span>

                           </div>
                        </div>
                     </div>
                     <br>
                  </c:if>
               </c:forEach>
            </div>
         </div>
         <div class="type_msg" id="enter">
            <div class="input_msg_write">
               <input type="text" id="content" class="write_msg"
                  placeholder="Type a message" />
               <button class="msg_send_btn" type="button" id="btn"
               onClick="isitEmpty(); false;">
                  <i class="fa fa-paper-plane-o" aria-hidden="true"></i>
               </button>
            </div>
         </div>
      </div>
   </div>
</body>

<!-- 엔터키 인식하기 -->
<script>
var input = document.getElementById("content");
input.addEventListener("keyup", function(event) {
  if (event.keyCode === 13) {
   event.preventDefault();
   document.getElementById("btn").click();
  }
});
</script>

</html>