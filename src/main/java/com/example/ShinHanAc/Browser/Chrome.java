package com.example.ShinHanAc.Browser;

public class Chrome implements Browser{
    private String url;
    public Chrome(String url){
        this.url = url;
    }
    @Override
    public WebSite rendering(){ //재정의된 메소드
        System.out.println("웹사이트 랜더링");
        WebSite site = new WebSite(this.url); //브라우저에서 넘겨주는 것
        return site;
    }
}
