<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri=http://java.sun.com/jsp/jstl/core" %>
<%@ page import="member.*"%>
<%@ page import="java.util.*"%>
<%
List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list }" var="member"> <!-- for문 대신 사용. 코드가 더 깔끔해짐 -->
		${member.id } ${member.name }<br>
</c:forEach>

</body>
</html>