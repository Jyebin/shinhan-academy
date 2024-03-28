package com.example.ShinHanAc.Browser;


public class Main {
    public static void main(String[] args){
        Browser chrome = new Chrome("www.naver.com");
        chrome.rendering();
        chrome.rendering();
        chrome.rendering();
        chrome.rendering();

        Browser chrome2 = new ChromeCahe("www.naver.com");
        chrome2.rendering();
        chrome2.rendering();
        chrome2.rendering();
        chrome2.rendering();

        long start = 0;
        long end = 0;

        Browser aop = new AoPBrowser("www.naver.com",
                ()-> {
                    System.out.println("시작");
                    start.set(System.nanoTime());
                },
                    ()->{
                System.out.println("끝");
                    end.set(System.nanoTime());
                    System.out.println(end.get()-start.get());
                });
    }
}
