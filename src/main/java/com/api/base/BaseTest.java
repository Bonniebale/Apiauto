package com.api.base;

import com.api.config.CompanyConfig;
import com.api.utils.HttpClientUtil;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public static String demoPostUrl;
    public static String demoGetUrl;
    protected HttpClientUtil httpClientUtil;
    protected HttpClientUtil dmsClient; //新增分销系统专用client

    @BeforeClass
    public void login() {
        httpClientUtil = new HttpClientUtil();
        httpClientUtil.login(CompanyConfig.COMPANY_NAME, CompanyConfig.USER_NAME, CompanyConfig.PASSWORD);
        //httpClientUtil.login("测试专用02", "admin", "55A86C51427E48F486272A465CE15D73");
    }


    public HttpClientUtil loginDms() {
        dmsClient = new HttpClientUtil();
        dmsClient.login(CompanyConfig.DMS_COMPANY_NAME,CompanyConfig.DMS_USER_NAME,CompanyConfig.DMS_PASSWORD);
        return dmsClient;
    }

}
