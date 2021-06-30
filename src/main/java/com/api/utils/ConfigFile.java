package com.api.utils;

import com.api.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    /***
     * 不用这种方式获取url了，此文件作废
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String environment = bundle.getString("pub.test.url");
        String uri ="";
        String testUrl;
//        //调试接口
//        if (name == InterfaceName.POSTAPI){
//            uri = bundle.getString("demo.post.uri");
//        }
//        if (name == InterfaceName.GETAPI){
//            uri = bundle.getString("demo.get.uri");
//        }
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login");
        }
        if (name == InterfaceName.SEARCH_TRADE){
            uri = bundle.getString("trade.search");
        }
        if (name == InterfaceName.SAVE_TRADE){
            uri = bundle.getString("trade.save");
        }
        if (name == InterfaceName.SEARCH_TRADE_BY_SIDS){
            uri = bundle.getString("trade.search.sids");
        }
        if (name == InterfaceName.TRADE_DMS_ADDDISTRIBUTORATTRIBUTE){
            uri = bundle.getString("trade.add.dms.addDistributorAttribute");
        }
        if (name == InterfaceName.TRADE_AUDIT){
            uri = bundle.getString("trade.audit");
        }
//        if (name == InterfaceName.VIP){
//            uri = bundle.getString("vip.test.url");
//        }

        testUrl = environment + uri;
        return testUrl;
    }

}
