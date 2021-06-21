package com.api.restclient;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {


    //Get请求方法
    public CloseableHttpResponse get(String url) throws IOException {
        //创建一个可关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }

    //带请求头的Get请求方法
    public CloseableHttpResponse get(String url, HashMap<String,String> headerMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //加载请求头到httpGet的请求对象
        for (Map.Entry<String,String> entry : headerMap.entrySet()){
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;

    }

    //post方法(json)
    public CloseableHttpResponse post(String url, String entityString, HashMap<String,String> headerMap) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置payload
        httpPost.setEntity(new StringEntity(entityString));
        //加载请求头
        for (Map.Entry<String,String> entry : headerMap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        return httpResponse;

    }

    //post方法(param)
    public CloseableHttpResponse post(String url, HashMap<String, String> headerMap, JSONObject param) throws IOException {
        CloseableHttpClient  httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //加载请求头
        for (Map.Entry<String,String> entry : headerMap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        return httpResponse;

    }



}
