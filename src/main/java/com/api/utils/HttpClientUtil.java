package com.api.utils;


import com.alibaba.fastjson.JSONObject;
import com.api.config.EnvironmentConfig;
import com.api.config.Interface;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.util.*;

@Slf4j
public class HttpClientUtil {
    public static BasicCookieStore basicCookieStore;
    public static CloseableHttpClient httpClient;
    private final String url = EnvironmentConfig.environment;


    /***
     * 普通的get请求方法
     * @param url
     * @return
     * @throws IOException
     */
    public CloseableHttpResponse get(String url) throws IOException {
        //创建一个可关闭的httpClient对象
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //执行请求
        log.info("开始执行get请求");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }


    /***
     * Get请求方法 带参数
     * @param path uri
     * @param params form-data 形式的参数list
     * @return response结果
     */
    public ResultBean get(String path, Map<String, String> params) {
        List<NameValuePair> pairs = new ArrayList<>();
        if (params != null) {
            params.forEach((k, v) -> {
                pairs.add(new BasicNameValuePair(k, v));
            });
        }

        HttpGet httpGet = new HttpGet(url+path);
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


    /**
     *设置默认的请求头信息
     * @param message
     * @return header请求头
     */
    private Map<String, String> buildDefaultHeader(AbstractHttpMessage message) {
        Map<String, String> header = new HashMap<>();
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        header.put("Referer", "https://puberp.superboss.cc/index.html");

        header.forEach(message::addHeader);
        return header;
    }

    /***
     * 当httpclient传参方式为json时，接受传递过来的url、字符串数据并并执行处理response结果方法
     * @param path path路径
     * @param jsonStr json串
     * @return
     */
    public ResultBean postJson(String path, String jsonStr)  {
        CloseableHttpResponse response;
        try {
            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("content-type", "application/json");
            response =post(path,headerMap,null,jsonStr);
        } catch (Exception e) {
            log.error("访问报错", e);
            throw new IllegalArgumentException("访问报错" + e.getMessage());
        }
        return handleResponse(response);
    }

    /****
     *当httpclient传参方式为form_data时，接受传递过来的url、form-data数据并执行处理response结果方法
     * @param path 传递的URI
     * @param params form-data params
     * @return
     */
    public ResultBean post(String path, Map<String, String> params)  {
        List<NameValuePair> pairs = new ArrayList<>();
        if (params != null) {
            params.forEach((k, v) -> {
                pairs.add(new BasicNameValuePair(k, v));
            });
        }

        try {
            CloseableHttpResponse response = post(path, null, pairs, null);
            return handleResponse(response);
        } catch (Exception e) {
            log.error("访问报错", e);
            throw new IllegalArgumentException("访问报错" + e.getMessage());
        }

    }

    /***
     * 处理请求的返回结果
     * @param response
     * @return response中的具体的返回对象
     */
    private ResultBean handleResponse(HttpResponse response) {
        if (response.getStatusLine().getStatusCode() != HttpURLConnection.HTTP_OK) {//200
            throw new IllegalArgumentException("访问异常，code=" + response.getStatusLine().getStatusCode());
        }

        String responseStr = "";
        try {
            responseStr = EntityUtils.toString(response.getEntity());
            System.out.println("responseStr："+responseStr);
        } catch (Exception e) {
            log.error("解析失败", e);
            throw new IllegalArgumentException("解析失败" + e.getMessage());
        }

        ResultBean resultBean = JSONObject.parseObject(responseStr, ResultBean.class);
        if (resultBean.getResult() != 1) {
            throw new ApiException(resultBean.getResult(), resultBean.getSubCode(), resultBean.getMessage(), resultBean.getData());
        }
        return resultBean;
    }

    @Data
    public static class ApiException extends RuntimeException implements Serializable {
        private Object data;
        private Integer result;
        private Integer subCode;

        public ApiException() {

        }

        public ApiException(Integer result, Integer subCode, String message, Object data) {
            super(message);
            this.result = result;
            this.subCode = subCode;
            this.data = data;
        }
    }

    @Data
    public static class ResultBean implements Serializable {

        private Integer result;
        private Integer subCode;
        private String message;
        private Integer qTime;
        private Object data;
    }
    /***
     *
     * @param path url_path
     * @param headerMap 浏览器header信息
     * @param params 若传参方式为form_data 格式则传入K,V
     * @param jsonStr 若传参方式为JSON 格式则传入String
     * @return httpClient
     * @throws IOException
     */

    public CloseableHttpResponse post(String path, Map<String, String> headerMap, List<NameValuePair> params, String jsonStr) throws IOException {
        Assert.notNull(httpClient, "请先登录");//判断传进来的参数值是否不为空值，如果为空就抛出异常throw new IllegalArgumentException(msg)，代码如果不捕捉处理这个异常，代码不往下执行，不为空代码继续向下执行。
        HttpPost httpPost = new HttpPost(url+path);
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

        if (jsonStr != null && jsonStr.length() > 0) {
            StringEntity stringEntity = new StringEntity(jsonStr, "utf-8");
            httpPost.setEntity(stringEntity);
        }
        return httpClient.execute(httpPost);//等同于CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
    }

    /***
     * login方法
     * @param companyName 公司名称
     * @param userName 用户名称
     * @param password 密码
     */
    public void login(String companyName, String userName, String password) {
        basicCookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();//将cookieStore设置到httpclient中
        Map<String, String> params = new HashMap<>();
        params.put("companyName", companyName);
        params.put("userName", userName);
        params.put("password", password);
        ResultBean response = post( Interface.LOGIN, params);
    }

    //     //调试代码专用
    //    public static void main(String[] args) throws Exception {
    //        HttpClientUtil client = new HttpClientUtil();
    //        client.login("咖啡测试3", "admin", "55A86C51427E48F486272A465CE15D73");
    //        ResultBean resultBean = client.get("/wms/config/get", null);
    //        System.out.println(resultBean.getResult());
    //        System.out.println(resultBean.getData());
    //    }
}
