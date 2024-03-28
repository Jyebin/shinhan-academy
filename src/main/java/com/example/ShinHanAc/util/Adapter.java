package com.example.ShinHanAc.util;


public class Adapter implements Game110V{
    private Electric220V e220;

    public Adapter(Electric220V e220){ //매개변수로 입력받아 초기화. 생성자
        this.e220 = e220;
    }
    @Override
    public void on(){ //재정의
        this.e220.powerOn(); //e220의 powerOn을 실행 -> adapter가 connector에 들어갈 수 있게 구현 완료
    }
}
