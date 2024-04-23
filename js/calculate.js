// //수량과 개수를 곱해 가격을 계산하는 함수
// //컴퓨터 1대당 100만원
// //TV 1대당 150만원
// //냉장고 1대당 200만원
// //추가상품 홈시어터 10만원, 전자렌지 20만원, 세탁기 50만원(+ 버튼 클릭시 선택란 추가)
// //수량 입력시, 상품선택시 합계자동계산(공급가격, 부가세, 총 견적비용) 후 해당 위치에 표기
// //총 견적비용이 200만원 초과시 10% 할인, 300만원 초과시 20% 할인 적용

// var result = 0; //총 견적 비용
// var computer = 0; //컴퓨터 전체 비용
// var TV = 0; //tv전체 비용
// var home = 0; //홈시어터 전체 비용
// var microWave = 0; //전자레인지 전체 비용
// var washing = 0; //세탁기 전체 비용
// result = computer + TV + home + microWave + washing;

// var computerSelect = document.querySelector('select[name="computer"]');
// document.write(computerSelect);
// var computerNum = computerSelect.value


// document.getElementById("calbtn").addEventListener("click", calculatePrice);
// if (result > 200) {
//     result = result * 0.9;
// } else if (result > 300) {
//     result = result * 0.8;
// }