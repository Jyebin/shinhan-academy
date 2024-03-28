package com.example.ShinHanAc.Browser;

public class AoPBrowser implements Browser{
    private String url;
    private WebSite site;
    private Runnable start;
    private Runnable end;

    public AoPBrowser(String url, Runnable start, Runnable end){
        this.url = url;
        this.start = start;
        this.end = end;
    }

    @Override
    public WebSite rendering(){
        start.run();
        if(site==null){
            System.out.println("랜더링");
            site = new WebSite(this.url);
        }
        System.out.println("캐싱");
        end.run();
        return site;
    }
}
