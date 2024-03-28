package com.example.ShinHanAc.util;

public class SamsungTV implements Electric220V{
    @Override
    public void powerOn(){
        System.out.println("삼성티비 220V");
    }
}