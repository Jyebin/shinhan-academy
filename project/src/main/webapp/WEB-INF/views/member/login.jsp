<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
<META name="viewport"
   content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<link rel="stylesheet" href="/css/reset.css" />
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/contents.css" />
<script src="/js/script.js"></script>
<script>
   function loginCheck() {
      if ($('#email').val() == '') {
         alert('이메일을 입력해주세요');
         $('#email').focus();
         return false;
      }
      else if ($('#pwd').val() == '') {
         alert('비밀번호를 입력해주세요');
         $('#pwd').focus();
         return false;
      }
   }
</script>
</head>
<body>
   <div class="wrap">
      <%@ include file="/WEB-INF/views/include/header.jsp"%>
      <form action="/member/login.do" method="post" onsubmit="return loginCheck();">
         <div class="sub">
            <div class="size">
               <h3 class="sub_title">로그인</h3>
               <div class="member">
                  <div class="box">
                     <fieldset class="login_form">
                        <ul>
                           <li><input type="text" id="email" name="email"
                              placeholder="이메일"></li>
                           <li><input type="password" id="pwd" name="pwd"
                              placeholder="비밀번호"></li>
                           <li><label><input type="checkbox" name="reg"
                                 id="reg1" /> 아이디저장</label></li>
                        </ul>
                        <div class="login_btn">
                           <input type="submit" value="로그인" alt="로그인" />
                        </div>
                     </fieldset>
                     <div class="btnSet clear">
                        <div>
                           <a href="join.do" class="btn">회원가입</a> <a href="idsearch.do"
                              class="btn">이메일/비밀번호 찾기</a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </form>
      <%@ include file="/WEB-INF/views/include/footer.jsp"%>
   </div>
</body>
</html>