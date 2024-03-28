package com.example.ShinHanAc.util;

public class Main {
    public static void main(String[] args){
        Switch s = new Switch(); //Game110V s = new Switch(); 로 해도 됨
        SamsungTV tv = new SamsungTV();
        Adapter a = new Adapter(tv);
        connect(a);
        connect(s);
    }
    static void connect(Game110V v){
        v.on();
    }
}
