package com.example.ShinHanAc.ch15.sec06.exam01;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;
        int size = map.size();
        for (String k : map.keySet()) {
            totalScore += map.get(k);
            if (maxScore < map.get(k)) {
                maxScore = map.get(k);
                name = k;
            }
        }
        System.out.println("평균 점수: " + totalScore / size);
        System.out.println("최고 점수: " + maxScore);
        System.out.println("최고 점수를 받은 아이디: " + name);
    }

}
