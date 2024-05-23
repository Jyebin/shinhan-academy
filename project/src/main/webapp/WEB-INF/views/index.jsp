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
<script src="/js/script.js"></script>
<script src="/js/main.js"></script>
</head>
<body>
   <div id="popup">
      <img src="/img/event_popup.png">
   </div>
   <div class="wrap">
      <%@ include file="/WEB-INF/views/include/header.jsp" %>
      <div class="visual">
         <div class="swiper swiper-visual">
            <div class="swiper-wrapper">
               <div class="swiper-slide"
                  style="background-image: url('/img/visual1.png');"></div>
               <div class="swiper-slide"
                  style="background-image: url('/img/visual2.png');"></div>
               <div class="swiper-slide"
                  style="background-image: url('/img/visual3.png');"></div>
               <div class="swiper-slide"
                  style="background-image: url('/img/visual4.png');"></div>
            </div>
         </div>

      </div>
      <div class="container">
         <div class="size">
            <div class="section">
               <img src="/img/section1_1.png">
            </div>
            <div class="section">
               <img src="/img/section1_2.png">
            </div>
            <div class="section">
               <img src="/img/section1_3.png">
            </div>
            <div class="section">
               <img src="/img/section1_4.png">
            </div>
            <div class="section">
               <img src="/img/section1_5.png">
            </div>
            <div class="section">
               <img src="/img/section1_6.png">
            </div>
         </div>
      </div>
      <div class="info">
         <div class="content">
            <div class="board_area">
               <div class="board_title on">공지사항</div>
               <div class="board_title">자료실</div>
               <div class="board_contents" id="board_notice">
                  <ul>
                     <li>공지사항입니다.<span>2023-10-18</span></li>
                     <li>공지사항입니다.<span>2023-10-18</span></li>
                     <li>공지사항입니다.<span>2023-10-18</span></li>
                     <li>공지사항입니다.<span>2023-10-18</span></li>
                     <li>공지사항입니다.<span>2023-10-18</span></li>
                     <li>공지사항입니다.<span>2023-10-18</span></li>
                  </ul>
               </div>
               <div class="board_contents" id="board_data">
                  <ul>
                     <li>자료실입니다.<span>2023-10-18</span></li>
                     <li>자료실입니다.<span>2023-10-18</span></li>
                     <li>자료실입니다.<span>2023-10-18</span></li>
                     <li>자료실입니다.<span>2023-10-18</span></li>
                     <li>자료실입니다.<span>2023-10-18</span></li>
                     <li>자료실입니다.<span>2023-10-18</span></li>
                  </ul>
               </div>
            </div>
         </div>
         <div class="content">
            <div class="video_container">
               <iframe width="100%" height="360"
                  src="https://www.youtube.com/embed/4bIX8HsLm9c"
                  title="Working Jazz - Unwind and Work - Jazz Music for Stress Relief and Concentration"
                  frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  allowfullscreen></iframe>
            </div>
         </div>
      </div>
      <%@ include file="/WEB-INF/views/include/footer.jsp" %>
      <div id="quickMenu">
         <div>
            <img src="/img/quick_01.jpg">
         </div>
         <div>
            <img src="/img/quick_02.jpg">
         </div>
         <div>
            <img src="/img/quick_03.jpg">
         </div>
         <div>
            <img src="/img/quick_04.jpg">
         </div>
         <div>
            <img id="goTop" src="/img/quick_05.jpg">
         </div>
      </div>
   </div>
</body>
</html>