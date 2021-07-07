package com.api.base;

import com.api.config.CompanyConfig;
import com.api.utils.HttpClientUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    public static String demoPostUrl;
    public static String demoGetUrl;
    protected HttpClientUtil httpClientUtil;
    protected HttpClientUtil dmsClient; //新增分销系统专用client

    @BeforeTest
    public void login() {
        httpClientUtil = new HttpClientUtil();
        httpClientUtil.login(CompanyConfig.COMPANY_NAME, CompanyConfig.USER_NAME, CompanyConfig.PASSWORD);
    }


    public HttpClientUtil loginDms() {
        dmsClient = new HttpClientUtil();
        dmsClient.login(CompanyConfig.DMS_COMPANY_NAME,CompanyConfig.DMS_USER_NAME,CompanyConfig.DMS_PASSWORD);
        return dmsClient;
    }

}
