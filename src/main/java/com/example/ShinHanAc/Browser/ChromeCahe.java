package com.example.ShinHanAc.Browser;

public class ChromeCahe implements Browser {
    private String url;
    private WebSite site;

    public ChromeCahe(String url) {
        this.url = url;
    }

    @Override
    public WebSite rendering() {
        if (site == null) {
            site = new WebSite(this.url);
        }
        System.out.println("캐싱");
        return site;
    }
}
