<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request : ${name }
	<br>
	<br> requestScope : ${requestScope.name }
	<br>
	<%-- <%=request.getAttribute("name2") %>로 출력해보면 Null임을 알 수 있다.
	별도로 Null값에 대한 예외처리를 하지 않아도 자동으로 Null값으로 출력이 된다 --%>
	session : ${id }
	<br> sessionScope : ${sessionScope.name}
	<br> id : ${memberVO.id }
	<br> name :${memberVO.name }
	<br>
	<!-- getId라고 안하고 id라고 하는 이유 : vo는 field가 private인데 어떻게 쓸 수 있을까?
		실제로는 el이 getter method를 호출하고 있음 -->
	map > tel : ${map.tel }
	<br> map > MemberVO > id : ${map.vo.id }
	<br> ${map.vo.id eq 'choi님' }
	<br>
	<!-- eq대신 ==을 써도 동일함 -->
	${empty map.vo2 }
	<br>
	<!-- 비어있으면 true 반환 -->
	${empty name }
	<br> ${param.searchWord } <!--  -->
	<br>

</body>
</html>