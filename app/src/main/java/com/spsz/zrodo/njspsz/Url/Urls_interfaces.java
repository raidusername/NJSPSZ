package com.spsz.zrodo.njspsz.Url;

public class Urls_interfaces {
    private final static String HOST = "http://sy.zrodo.com";

    public static String CZlogin() {
        return HOST + "/nanjing/mobile/doLoginByPwd";
    }
    public static String SZlogin(){
        return HOST + "/nanjing/mobile/doLoginForStallmanByPwd";
    }
}
