package com.api.restclient;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@Slf4j
public class RestClient {
    public static BasicCookieStore basicCookieStore;
    public static CloseableHttpClient httpClient;
    private String url = "https://puberp.superboss.cc";


    //Get请求方法
    public CloseableHttpResponse get(String url) throws IOException {
        //创建一个可关闭的httpClient对象
        //CloseableHttpClient httpClient = HttpClients.createDefault();
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }

    //Get请求方法 带参数
    public ResultBean get(String path, Map<String, String> params) throws Exception {
        List<NameValuePair> pairs = new ArrayList<>();
        if (params != null) {
            params.forEach((k, v) -> {
                pairs.add(new BasicNameValuePair(k, v));
            });
        }

        HttpGet httpGet = new HttpGet(url + path);
        buildDefaultHeader(httpGet);

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return handleResponse(response);
        } catch (Exception e) {
            log.error("访问报错", e);
            throw new IllegalArgumentException("访问报错" + e.getMessage());
        }
    }

//    //带请求头的Get请求方法
//    public CloseableHttpResponse get(String url, HashMap<String,String> headerMap) throws IOException {
//        //CloseableHttpClient httpClient = HttpClients.createDefault();
//        httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        //加载请求头到httpGet的请求对象
//        for (Map.Entry<String,String> entry : headerMap.entrySet()){
//            httpGet.addHeader(entry.getKey(),entry.getValue());
//        }
//        //执行请求
//        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//        return httpResponse;
//
//    }

    //post方法 json
    public CloseableHttpResponse post(String url, HashMap<String,String> headerMap, String entityString) throws IOException {
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        httpPost.setEntity(new StringEntity(entityString));
        //加载请求头
        for (Map.Entry<String,String> entry : headerMap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }

        return httpClient.execute(httpPost);
    }

    public void login(String companyName, String userName, String password) {
        basicCookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();//将cookieStore设置到httpclient中
        Map<String, String> params = new HashMap<>();
        params.put("companyName", companyName);
        params.put("userName", userName);
        params.put("password", password);
        ResultBean response = post( "/account/login", params);
        System.out.println("@Test:"+response);
    }
//     //调试代码专用
//    public static void main(String[] args) throws Exception {
//        RestClient client = new RestClient();
//        client.login("咖啡测试3", "admin", "55A86C51427E48F486272A465CE15D73");
//        ResultBean resultBean = client.get("/wms/config/get", null);
//        System.out.println(resultBean.getResult());
//        System.out.println(resultBean.getData());
//    }

    //post方法 form-data
    public CloseableHttpResponse post(String path, HashMap<String, String> headerMap, List<NameValuePair> params) throws IOException {
        Assert.notNull(httpClient, "请先登录");
        HttpPost httpPost = new HttpPost(url + path);
        //添加请求参数

        //加载请求头
        if (headerMap != null) {
            for (Map.Entry<String,String> entry : headerMap.entrySet()){
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }

        buildDefaultHeader(httpPost);

        if (params != null) {
            //执行表单的一定要用这个UrlEncodedFormEntity类
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf-8");
            httpPost.setEntity(formEntity);
        }

        return httpClient.execute(httpPost);
    }

    private Map<String, String> buildDefaultHeader(AbstractHttpMessage message) {
        Map<String, String> header = new HashMap<>();
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        header.put("Referer", "https://puberp.superboss.cc/index.html");

        header.forEach(message::addHeader);
        return header;
    }

    private ResultBean handleResponse(HttpResponse response) {
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IllegalArgumentException("访问异常，code=" + response.getStatusLine().getStatusCode());
        }

        String responseStr = "";
        try {
            responseStr = EntityUtils.toString(response.getEntity());
            System.out.println(responseStr);
        } catch (Exception e) {
            log.error("解析失败", e);
            throw new IllegalArgumentException("解析失败" + e.getMessage());
        }

        return JSONObject.parseObject(responseStr, ResultBean.class);
    }

    public ResultBean post(String path, Map<String, String> params)  {
        List<NameValuePair> pairs = new ArrayList<>();
        if (params != null) {
            params.forEach((k, v) -> {
                pairs.add(new BasicNameValuePair(k, v));
            });
        }

        try {
            CloseableHttpResponse response = post(path, null, pairs);
            return handleResponse(response);
        } catch (Exception e) {
            log.error("访问报错", e);
            throw new IllegalArgumentException("访问报错" + e.getMessage());
        }

    }

    @Data
    public static class ResultBean implements Serializable {
        private Integer result;
        private String message;
        private Integer qTime;
        private Object data;
    }

    //暂时做不到动态获取cookie并传递
    //post方法 携带Cookie才能访问 json
//    public CloseableHttpResponse  postWithCookies(String url, HashMap<String, String> headerMap, ArrayList cookieList,String entityString) throws IOException {
//        //设置cookie信息
//        basicCookieStore = new BasicCookieStore();
//        for (Object x : cookieList){
//            basicCookieStore.addCookie((Cookie) x);
//        }
//        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
//        //CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost();
//        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//
//        return httpResponse;
//
//    }

//    public CloseableHttpResponse  postWithCookies(String url, HashMap<String, String> headerMap,
//                                                  ArrayList cookieList,String entityString) throws IOException {
//        //设置cookie信息
//        basicCookieStore = new BasicCookieStore();
//        basicCookieStore.addCookie((Cookie)cookieList);
//        httpClient = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
//        //CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        //设置payload
//        httpPost.setEntity(new StringEntity(entityString));
//        //加载请求头
//        for (Map.Entry<String,String> entry : headerMap.entrySet()){
//            httpPost.addHeader(entry.getKey(),entry.getValue());
//        }
//        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//
//        return httpResponse;
//
//    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
