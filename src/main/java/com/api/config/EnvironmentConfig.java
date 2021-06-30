package com.api.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnvironmentConfig {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    static String envi = bundle.getString("pub.test.url");

    public static String environment = envi;
}
