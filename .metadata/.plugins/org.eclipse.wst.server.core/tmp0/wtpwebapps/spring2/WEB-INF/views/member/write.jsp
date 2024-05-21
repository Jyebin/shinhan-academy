<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function idCheck() {
		var run = true;
		//id를 입력해야 전송할 수 있으므로 먼저 check를 해 주어야 함
		if ($("input[name=id]").val() == '') {
			alert("아이디를 입력하세요");
		} else {
			$.ajax({
				url : 'idCheck.do?id=' + $("input[name=id]").val(),
				success : function(res) {
					console.log(res);
					//여기까지 하면 json으로 전달할 수 있음
					if (res != '0') {
						alert('중복된 아이디 입니다.');
						$("input[name=id]").val(''); //빈 값으로 바꿈
						run = false; //중복된 아이디면 false로 바꿈
					}
				}
			})
		}
		if (run) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<h1>회원 등록</h1>
	<form action="insert.do" method="post" enctype="multipart/form-data" onsubmit=idCheck()>
		<!-- 데이터를 전송해 db에 전송할 url -->
		아이디 : <input type="text" name="id">아이디<br> 
		비밀번호 : <input type="text" name="pwd">비밀번호<br> 
		이름 : <input type="text" name="name">이름<br> 
		취미 : <input type="checkbox" name="hobby">취미<br>
		<input type="checkbox" name="hobbyname" value="독서">독서<br>
		<input type="checkbox" name="hobbyname" value="게임">게임<br>
		프로필 : <input type="file" name="profile"><br>
		<input type="submit" value="등록"><br>
			
	</form>
</body>
</html>
