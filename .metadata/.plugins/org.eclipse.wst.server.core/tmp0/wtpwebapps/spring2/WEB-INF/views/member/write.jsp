<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function idCheck(){
	alert(1);
	return false;
}
</script>
</head>
<body>
<h1>회원 등록</h1>
<form action = "insert.do" method="post"> <!-- 데이터를 전송해 db에 전송할 url -->
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="text" name="pwd"><br>
이름 : <input type="text" name="name"><br>
취미 : <input type="checkbox" name="hobby"="><br>
<input type="name"=""hobbyname" value="독서"><br>
<input type="name"=""hobbyname" value="게임"><br>
</form>
</body>
</html> <! -->