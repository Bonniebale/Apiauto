package com.api.utils;

import com.api.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("pub.test.url");
        String uri ="";
        String testUrl;
        if (name == InterfaceName.POSTAPI){
            uri = bundle.getString("demo.post.uri");
        }
        if (name == InterfaceName.GETAPI){
            uri = bundle.getString("demo.get.uri");
        }
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login");
        }
        if (name == InterfaceName.SEARCHOFTRADE){
            uri = bundle.getString("search.trade");
        }

        testUrl = address + uri;
        return testUrl;
    }
}
