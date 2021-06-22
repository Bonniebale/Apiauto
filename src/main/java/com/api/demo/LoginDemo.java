package com.api.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.model.Company;
import com.api.model.InterfaceName;
import com.api.model.User;
import com.api.restclient.RestClient;
import com.api.utils.ConfigFile;
import com.api.utils.TestUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LoginDemo extends BaseTest {
    public String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
    BaseTest baseTest;

    @BeforeClass
    public void setUp(){
        baseTest = new BaseTest();
        url = ConfigFile.getUrl(InterfaceName.LOGIN);
        System.out.println("url:"+url);


    }

    @Test(groups = "",description = "登录接口")
    public void login() throws IOException {
        Company company = new Company();
        restClient = new RestClient();
        //添加请求参数
        List<NameValuePair> params = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("companyName","Nono测试");
        BasicNameValuePair param2 = new BasicNameValuePair("userName","admin");
        BasicNameValuePair param3 = new BasicNameValuePair("password","55A86C51427E48F486272A465CE15D73");
        params.add(param1);
        params.add(param2);
        params.add(param3);
        System.out.println("params:"+params);

        //准备请求头信息
        HashMap<String,String> headerMap = new HashMap<String,String>();
        headerMap.put("Content-Type","application/json");



//         第二种
//        JSONObject param = new JSONObject();
//        param.put("测试最棒",company.getCompanyName());
//        param.put("admin",company.getUserName());
//        param.put("cjzg123456",company.getPassword());
//        System.out.println("param:"+param);

//第一种
        //对象转成JSON字符串
//        Company company = new Company("测试最棒","admin","cjzg123456");
//        String companyJSONString =JSON.toJSONString(company);
//        System.out.println("companyJSONString:"+companyJSONString);

        closeableHttpResponse = restClient.post(url,headerMap,params);
//        closeableHttpResponse = restClient.post(url,companyJSONString,headerMap);
        //验证状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200,"status code is not 200.");
        System.out.println("statusCode:"+statusCode);

        String status ;

        //断言响应json中name和job是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONObject responseJson = JSON.parseObject(responseString);//是将str转化为相应的JSONObject对象
        System.out.println(responseString);


        restClient.get(url);
    }


}
