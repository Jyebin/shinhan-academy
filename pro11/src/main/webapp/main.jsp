<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = "홍길동";
String pageName = "header.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%
int a = 1;
%>
<script>
<%if (a % 2 == 1) {%>
	alert('홀수입니다.');
<%} else {%>}
alert('짝수입니다.';
<%}%> --%>
<%!int a = 2;
	String v = a % 2 == 1 ? "홀수" : "짝수";%>

<script>
	alert('<%out.print(v);%>');
	alert('<%=v%>
	입니다.');
</script>
</head>
<body>
	<%
	for (int i = 0; i < 10; i++) {
	%>
	<h1>여기는 main.jsp</h1>
	<%
	}
	%>
	<%@ include file="header.jsp"%>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
</body>
</html>