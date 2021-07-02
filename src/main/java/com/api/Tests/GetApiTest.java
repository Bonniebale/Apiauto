package com.api.Tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.model.useless.InterfaceName;
import com.api.utils.HttpClientUtil;
import com.api.utils.ConfigFile;
import com.api.utils.JsonUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

public class GetApiTest extends BaseTest {
    HttpClientUtil httpClientUtil;
    CloseableHttpResponse closeableHttpResponse;
    BaseTest baseTest;
    public  String url;

    @BeforeClass
    public void setUp(){

        baseTest = new BaseTest();
        //url = BaseTest.demoGetUrl= ConfigFile.getUrl(InterfaceName.GETAPI);//一般不这么写，需要写两行
        url = ConfigFile.getUrl(InterfaceName.GETAPI);
        BaseTest.demoGetUrl = url;
        System.out.println("url:"+url);

    }

    @Test
    public void getApiTest() throws IOException {
        httpClientUtil = new HttpClientUtil();
        closeableHttpResponse = httpClientUtil.get(url);

        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("statusCode:"+statusCode);
        Assert.assertEquals(statusCode, HttpURLConnection.HTTP_OK,"response status code is not 200.");

        //把响应内容存储在字符串对象
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"utf-8");

        //创建json对象吧，将responseString转成JSON对象
        JSONObject responseJSON = JSON.parseObject(responseString);

        //解析JSON内容
        String s = JsonUtil.getValueByJPath(responseJSON,"data[0]/first_name");
        Assert.assertEquals(s,"Michael","name is not Michael.");
        System.out.println(s);

    }

}
