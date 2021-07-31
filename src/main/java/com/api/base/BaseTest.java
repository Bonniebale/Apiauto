package com.api.base;

import com.api.config.CompanyConfig;
import com.api.utils.HttpClientUtil;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    public static String demoPostUrl;
    public static String demoGetUrl;
    protected HttpClientUtil httpClientUtil;
    protected HttpClientUtil dmsClient; //新增分销系统专用client

    @BeforeSuite
    public void login() {
        httpClientUtil = new HttpClientUtil();
        httpClientUtil.login(CompanyConfig.COMPANY_NAME, CompanyConfig.USER_NAME, CompanyConfig.PASSWORD);
    }


    @BeforeSuite
    public HttpClientUtil loginDms() {
        dmsClient = new HttpClientUtil("gongxiao");
        dmsClient.login(CompanyConfig.DMS_COMPANY_NAME,CompanyConfig.DMS_USER_NAME,CompanyConfig.DMS_PASSWORD);
        return dmsClient;
    }

}
