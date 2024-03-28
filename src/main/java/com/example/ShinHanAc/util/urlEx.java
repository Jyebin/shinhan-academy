package com.example.ShinHanAc.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class urlEx {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.hrd.go.kr/hrdp/ma/pmmao/newIndexRenewal.do"); //.do로 끝나는 것들은 대부분 spring을 통해 개발된 주소임
        System.out.println(url.getHost()); //주소를 갖고오는 메소드
        System.out.println(url.getPath()); //경로를 갖고오는 메소드
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        int data = 0;
        while ((data = is.read()) != -1) {
            System.out.print((char) data);
        }

        URLConnection con = url.openConnection();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
        int data2 = 0;
        while ((data2 = br2.read()) != -1) {
            System.out.print((char) data2);
        }
    }
}
