package com.api.store;

import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.config.Interface;
import com.api.utils.HttpClientUtil;
import java.util.HashMap;
import java.util.Map;

public class DmsBaseMethods extends BaseTest {
    TradeAPIList tradeAPIList = new TradeAPIList();
    JSONObject resultJSONObject = new JSONObject();

    /**
     * 新增分销属性
     * @param httpClient
     * @param sids 需要新增分销属性的订单号
     */
    public void dmsAddDistributor(HttpClientUtil httpClient, String sids){
        //添加请求参数
        Map<String, String> params = new HashMap<>();
        params.put("sids",sids);
        tradeAPIList.form(httpClient,Interface.DMS_ADD_DISTRIBUTOR,params);
    }

    /**
     * 强制指定供销商
     * @param httpClient
     * @param sids 需要强制指定供销商的订单
     * @param destId 指定的供销商Id
     */
    public void forceDistributor(HttpClientUtil httpClient, String sids, String destId ){
        //添加请求参数
        Map<String, String> dmsParams = new HashMap<>();
        dmsParams.put("sids",sids);
        dmsParams.put("destId",destId);
        resultJSONObject = (JSONObject) tradeAPIList.form(httpClient, Interface.DMS_FORCE_DISTRIBUTOR,dmsParams);
    }

    /**
     * 设置分销商代发店铺
     * @param httpClient
     * @param id 供销商管理的id
     * @param supplierName 供销商名称
     * @param insteadUserIds 代发店铺ID
     */
    public void UpdateSupplierInfo(HttpClientUtil httpClient, String id, String supplierName, String insteadUserIds){
        Map<String, String> params = new HashMap<>();
        params.put("id",id);
        params.put("supplierName",supplierName);
        params.put("insteadUserIds",insteadUserIds);
        tradeAPIList.formData(httpClient,Interface.DMS_UPDATE_SUPPLIER_INFO,params);
    }

    /**
     * 分销商品管理-规则设置
     * @param httpClient
     */
    public void saveOptItemRule(HttpClientUtil httpClient){
        JSONObject params = new JSONObject();
        params.put("distributorCompanyIds","15974");
        params.put("distributorNames","测试专用02");
        params.put("id","466");
        params.put("optType","2");
        params.put("ruleName","API");
        params.put("ruleType","allowSaleOuter");
        tradeAPIList.jsonGetData(httpClient,Interface.DMS_OPTITEM_RULE,params);
    }



}
