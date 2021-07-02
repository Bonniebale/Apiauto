package com.api.Tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.model.useless.InterfaceName;
import com.api.model.useless.User;
import com.api.utils.HttpClientUtil;
import com.api.utils.ConfigFile;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class PostApiTest extends BaseTest{

    HttpClientUtil httpClientUtil;
    CloseableHttpResponse closeableHttpResponse;
    BaseTest baseTest;


    @BeforeClass
    public void setUp(){
        baseTest = new BaseTest();
        BaseTest.demoPostUrl = ConfigFile.getUrl(InterfaceName.POSTAPI);
        System.out.println("demoPostUrl:"+BaseTest.demoPostUrl);


    }
    @Test
    public void postAPITest() throws IOException {
        httpClientUtil = new HttpClientUtil();
        //准备请求头信息
        HashMap<String,String> headerMap = new HashMap<String,String>();
        headerMap.put("Content-Type","application/json");

        //对象转成JSON字符串
        User user = new User("morpheus","leader");
        String userJSONString = JSON.toJSONString(user);
        System.out.println(userJSONString);

 //       closeableHttpResponse = httpClientUtil.post(BaseTest.demoPostUrl,headerMap,userJSONString);

        //验证状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
//        Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_201,"status code is not 201.");

        //断言响应json中name和job是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONObject responseJson = JSON.parseObject(responseString);//是将str转化为相应的JSONObject对象
        System.out.println(responseString);

//        String name = JsonUtil.getValueByJPath(responseJson,"name");
//        String job =JsonUtil.getValueByJPath(responseJson,"job");
//        Assert.assertEquals(name,"morpheus","name is not same");
//        Assert.assertEquals(job,"leader","job is not same");
//        httpClientUtil.get(BaseTest.demoPostUrl);

    }
}
