package com.example.ShinHanAc.codingTest;

public class Solution {
    public int[] Solution(int n, int[] amounts) {
        //n : 경매 물품, m : 경매 참가자
        //자본이 가장 많이 남은 참가자가 1명일 경우 -> 두 번째로 많이 남은 참가자의 지본 + 10000지불 + 물품 낙찰
        //  => 자본이 가장 많은 사람이 1명인 경우
        //자본이 가장 많이 남은 참가자가 2명 이상인 경우 -> 번호가 가장 낮은 참가자가 자신의 남은 자본을 모두 지불하고 물품을 낙찰받음
        //참가자 자본이 모두 0원 남았을 때의 물품 낙찰 금액은 0원
        int length = amounts.length;
        int biggest = 0;
        int caseNum = 1; //1번 케이스 : 가장 돈 많은 사람이 1명, 2번 케이스 : 돈 많은 사람이 2명 이상
        int money = 0; //낙찰가

        for (int i = 0; i < length; i++) {
            if (biggest <= amounts[i]) {
                if(biggest == amounts[i]){
                    caseNum = 2;
                }
                biggest = amounts[i];
            }
        }
        if(caseNum == 1){ //가장 돈 많은 사람이 한 명인 경우

        }else{ //가장 돈 많은 사람이 두 명 이상인 경우

        }

        int[] answer = {0};

        return answer;

    }
}