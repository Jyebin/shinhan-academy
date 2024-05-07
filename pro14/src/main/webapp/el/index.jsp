<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
request : ${name } <br>
requestScope : ${requestScope.name }<br>
session : ${id } <br>
sessionScope : ${sessionScope.name }<br>
id : ${test.id }<br>
name : ${test.nickname }<br>
map > tel : ${map.tel }<br>
map > MemberVO > id : ${map.vo.id }<br>
${map.vo.id eq 'choi님' }<br>
${not empty map.vo2 }<br>
${empty name }<br>
${param.searchWord }
</body>
</html>



