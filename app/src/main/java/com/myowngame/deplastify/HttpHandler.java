package com.myowngame.deplastify;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {
    public void handler(int impact){
        new Thread() {
            public void run() {
                try{
                    String url = "http://testapp-346501.wm.r.appspot.com/message?message="+impact;
                    URL urlObj = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    int rescode = conn.getResponseCode();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
