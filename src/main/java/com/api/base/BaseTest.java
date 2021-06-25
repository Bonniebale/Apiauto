package com.api.base;

import com.api.utils.ConfigFile;
import com.api.utils.HttpClientUtil;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public static String demoPostUrl;
    public static String demoGetUrl;
    protected HttpClientUtil httpClientUtil;
    protected HttpClientUtil dmsClient; //新增分销系统专用client


    @BeforeClass
    public void setUp() {
        httpClientUtil = new HttpClientUtil();
        httpClientUtil.login("测试专用02", "admin", "55A86C51427E48F486272A465CE15D73");
        //httpClientUtil.login(ConfigFile.companyName,ConfigFile.userName,ConfigFile.password);
    }


    public HttpClientUtil loginDms() {
        dmsClient = new HttpClientUtil();
        dmsClient.login("测试专用02", "admin", "55A86C51427E48F486272A465CE15D73");
        return dmsClient;
    }

}
