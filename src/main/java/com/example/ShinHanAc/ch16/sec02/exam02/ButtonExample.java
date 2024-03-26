package com.example.ShinHanAc.ch16.sec02.exam02;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button(); //OK 버튼 객체 생성

        btnOk.setClickListener(() -> { //Ok 버튼 객체에 람다식(ClickListner 익명 구현 객체) 주입
            System.out.println("Ok 버튼을 클릭했습니다.");
        });

        btnOk.click(); //Ok 버튼 클릭

        Button btnCancel = new Button();

        btnCancel.setClickListener(() -> { //Cancel 버튼 객체에 람다식(ClickListner 익명 구현 객체) 주입
            System.out.println("Cancel의 버튼을 클릭했습니다.");
        });

        btnCancel.click();
    }
}
