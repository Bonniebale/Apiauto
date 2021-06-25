package com.api.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.model.InterfaceName;
import com.api.utils.HttpClientUtil;
import com.api.utils.ConfigFile;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LoginDemo extends BaseTest {
    private String url;
    HttpClientUtil httpClientUtil;
    CloseableHttpResponse closeableHttpResponse;
    //BaseTest baseTest;

    @BeforeClass
    public void setUp(){
       // baseTest = new BaseTest();
        url = ConfigFile.getUrl(InterfaceName.LOGIN);
        System.out.println("url:"+url);


    }

    @Test(description = "登录接口")
    public void login() throws IOException {
        httpClientUtil = new HttpClientUtil();
        //添加请求参数
        List<NameValuePair> params = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("companyName","测试专用02");
        BasicNameValuePair param2 = new BasicNameValuePair("userName","admin");
        BasicNameValuePair param3 = new BasicNameValuePair("password","55A86C51427E48F486272A465CE15D73");
        params.add(param1);
        params.add(param2);
        params.add(param3);
        //还有一种写法
       // params.add(new BasicNameValuePair("companyName","测试专用02"));

        //准备请求头信息
        HashMap<String,String> headerMap = new HashMap<String,String>();
        headerMap.put("Content-Type","application/x-www-form-urlencoded");

        closeableHttpResponse = httpClientUtil.post(url,headerMap,params, null);

        //直接写死也行
       // final String requestParams = "companyName=%E6%B5%8B%E8%AF%95%E4%B8%93%E7%94%A802&userName=admin&password=55A86C51427E48F486272A465CE15D73&salt=1624335991904&validationCode=&phoneVerifyCode=&deviceId=jd_D77BXUVRJXVIVFYY33MN2K7PL76S7UJELBQ2FZRNPQR2Y367QLVAQJU2V7M5YITL26ESIH3VLKQS36GBJ2RD5NKOTU%2Cvipjit_1624335991902_59e9e9e6252b9ca632dd6cb5a62e09b2";
        //closeableHttpResponse = httpClientUtil.post(url, requestParams, headerMap);

        //验证状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpURLConnection.HTTP_OK,"status code is not 200.");
        System.out.println("statusCode:"+statusCode);

        String status ;

        //断言响应json中是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());//获取响应结果
        JSONObject responseJson = JSON.parseObject(responseString);//是将str转化为相应的JSONObject对象

        System.out.println("responseString"+responseString);
    }


}
