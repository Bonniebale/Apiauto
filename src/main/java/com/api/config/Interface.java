package com.api.config;


public class Interface {

    /**登录接口*/
    public static String LOGIN = "/account/login";
    //交易模块
    /**
     * 指定下载
     */
    public static String SINGLE_DOWNLOAD = "/trade/sync/single";

    /**保存订单接口**/
    public static String SAVE_TRADE = "/trade/save";

    /**
     * 查询订单接口
     */
    public static String SEARCH_TRADE = "/trade/search";

    /**
     * 查询订单(sid)接口
     */
    public static String TRADE_SEARCH_SIDS = "/trade/search/sids";

    /**
     * 审核订单接口
     */
    public static String TRADE_AUDIT="/trade/audit";

    /**
     * 保存快递模板接口-云打印模板
     */
    public static String TRADE_SAVE_CLOUD = "/trade/logistics/cloud/save";

    /**
     * 获取菜鸟电子面单单号
     */
    public static String GET_EXPRESS_ID = "/trade/logistics/cloud/waybill/get";

    //分销模块
    /**
     * 设置代发店铺接口
     */
    public static String DMS_UPDATE_SUPPLIER_INFO = "/dms/updateSupplierInfo";

    /**新增分销属性接口**/
    public static String DMS_ADD_DISTRIBUTOR="/trade/dms/addDistributorAttribute";

    /**强制指定供销商接口**/
    public static String DMS_FORCE_DISTRIBUTOR="/trade/dms/forceDistributorAttribute";


    //以下为供销商专用
    /**
     * 供销商基础设置 GET
     */
    public static String DMS_SAVE_SETTING = "/dms/saveSetting?api_name=dms_saveSetting&";

    /**
     * 取消分销属性接口
     */
    public static String DMS_CANCEL_DISTRIBUTOR ="/trade/dms/cancelDistributorAttribute";

    /**
     * 分销资金管理-充值资金
     */
    public static String DMS_MONEY_OPT= "/dms/dmsDistributorMoneyOpt";

    /**
     * 分销商品管理-规则设定
     */
    public static String DMS_OPTITEM_RULE = "/dms/optItemRule";

    /** 打回供销订单接口*/
    public static String DMS_REPULSE_GX_TRADE = "/trade/dms/repulseGxTrade";


    /**分销商付款接口**/

    /**供销缺货拆分接口**/

}
