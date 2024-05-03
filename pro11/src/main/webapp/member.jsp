<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<%=list.get(i).getId()%>
	<%=list.get(i).getName()%>
	<%
	}
	%>

</body>
</html>