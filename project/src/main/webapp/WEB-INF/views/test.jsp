<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function() {
   $.ajax({
      url:'http://localhost:8090/test/api/member/all',
      method:'get',
      type:'JSON',
      success : function(res) {
         console.log(res);
      }
   });
   $("#btn").click(function(){
      let param = {
            id:$("#id").val(),
            password:$("#password").val()
      }
      $.ajax({
         url:'http://localhost:8090/test/api/member/regist',
         method:'put',
         type:'JSON',
         data:JSON.stringify(param),
         contentType:'application/json;charset=utf-8',
         success : function(res) {
            console.log(res);
         }
      })
   })
})
</script>
</head>
<body>
<form id="frm">
아이디:<input type="text" name="id" id="id"><br>
비밀번호:<input type="text" name="password" id="password"><br>
<input type="button" value="전송" id="btn">
</form>
<table border="1" id="tbl">
<tr>
   <th>번호</th>
   <th>이름</th>
   <th>아이디</th>
</tr>
</table>
</body>
</html>