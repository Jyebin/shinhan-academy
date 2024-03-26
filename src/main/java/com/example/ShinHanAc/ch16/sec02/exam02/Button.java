package com.example.ShinHanAc.ch16.sec02.exam02;

public class Button {
    @FunctionalInterface //함수형 인터페이스
    public static interface ClickListener{
        void onClick();
    }

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void click(){
        this.clickListener.onClick();
    }
}

