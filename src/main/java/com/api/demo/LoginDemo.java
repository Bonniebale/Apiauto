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
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

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
        //准备请求头信息
        HashMap<String,String> headerMap = new HashMap<String,String>();
        headerMap.put("Content-Type","application/json");

        JSONObject param = new JSONObject();
        param.put("测试最棒",company.getCompanyName());
        param.put("admin",company.getUserName());
        param.put("cjzg123456",company.getPassword());
        System.out.println("param:"+param);


        //对象转成JSON字符串
//        Company company = new Company("测试最棒","admin","cjzg123456");
//        String companyJSONString =JSON.toJSONString(company);
//        System.out.println("companyJSONString:"+companyJSONString);

        closeableHttpResponse = restClient.post(url,headerMap,param);
//        closeableHttpResponse = restClient.post(url,companyJSONString,headerMap);
        //验证状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200,"status code is not 201.");
        System.out.println("statusCode:"+statusCode);

        //断言响应json中name和job是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONObject responseJson = JSON.parseObject(responseString);//是将str转化为相应的JSONObject对象
        System.out.println(responseString);
//
//        String userName = TestUtil.getValueByJPath(responseJson,"userName");
//        String companyName =TestUtil.getValueByJPath(responseJson,"companyName");
//        String password = TestUtil.getValueByJPath(responseJson,"password");
//
//        Assert.assertEquals(userName,"","");
//        Assert.assertEquals(companyName,"","");
//        Assert.assertEquals(userName,"","");





        restClient.get(url);
    }


}
