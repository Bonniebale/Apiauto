package com.api.store;

import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.config.Interface;
import com.api.utils.HttpClientUtil;
import java.util.HashMap;
import java.util.Iterator;
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
     * @param newAddIds 商品商家编码
     * @param ruleType allowSaleOuter 允许销售款式；forbidSaleOuter 禁止销售款式；allowSaleMiniOuter允许销售的商品编码；forbidSaleMiniOuter禁止销售的商品编码
     */
    public void saveOptItemRule(HttpClientUtil httpClient,String newAddIds, String ruleType){
        JSONObject params = new JSONObject();
        params.put("deletedIds","");//删掉的商品id
        params.put("distributorCompanyIds","15974");
        params.put("distributorNames","测试专用02");
        params.put("id","466");//规则id
        params.put("newAddIds",newAddIds);
        params.put("optType","2");//2编辑,1新增,3打开规则,4关闭规则,5删除
        params.put("ruleName","API");//规则名称
        params.put("ruleType",ruleType);
        tradeAPIList.jsonGetData(httpClient,Interface.DMS_OPTITEM_RULE,params);

    }

    /**
     * 分销商品管理-规则设置-规则的关闭/打开/删除
     * @param httpClient
     * @param optType 操作规则类型 2编辑,1新增,3打开规则,4关闭规则,5删除
     * @param id 规则id
     * @param ruleName 规则名称
     */
    public void saveOptItemRule(HttpClientUtil httpClient, String optType, String id, String ruleName){
        JSONObject params = new JSONObject();
        params.put("id",id);//
        params.put("optType",optType);
        params.put("ruleName",ruleName);
        tradeAPIList.jsonGetData(httpClient,Interface.DMS_OPTITEM_RULE,params);
    }

    /**
     * 供销基础设置
     * @param httpClient
     */
    public void SaveSetting(HttpClientUtil httpClient) {//供销基础设置

        Map<String, String> setMap = new HashMap<>();
        setMap.put("allowAssignExpress","false");
        setMap.put("allowZeroDistributorPrice","true");//允许推送分销价为0
        setMap.put("warehouseId","-1");
        setMap.put("warehouseName","全部仓库");
        setMap.put("showSellingPrice","true");
        setMap.put("autoPay","true");
        setMap.put("autoSyncException","true");
        setMap.put("autoApproval","true");
        setMap.put("autoAddCredit","false");
        setMap.put("autoAddCreditMoney","1000");
        setMap.put("interceptType","0");//0关闭 1可用数 2可用数+采购在途

        httpClient.get(Interface.DMS_SAVE_SETTING,setMap);

    }


    public void saveDmsSetting(HttpClientUtil httpClient){//分销基础设置
        Map<String, String> setMap = new HashMap<>();
        setMap.put("autoSeparateTrade","");
        setMap.put("autoAuditWhenAddAttribute","");
        setMap.put("autoPushWhenBalanceLessThen","");
        setMap.put("autoPushWhenBalanceLessThenMoney","");
        setMap.put("autoPushWhenAs","");
        setMap.put("autoSyncStock","");
        setMap.put("useSupplierCode","");//0 系统商家编码 1 供应商商家编码
    }


    /**
     * 将一个Map类转成具体和字符串用&隔开，但最后一个不加。
     * @param map 需要转换的Map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> String handleMapToString(Map map) {

        Iterator<Map.Entry<K,V>> i = map.entrySet().iterator();

        StringBuilder sb = new StringBuilder();

        for(;;){//没有条件的for循环,这么写是死循环，需要使用return或者break退出
            Map.Entry<K,V> m = i.next();
            K key = m.getKey();
            V value= m.getValue();
            sb.append(key);
            sb.append('=');
            sb.append(value);
            if(!i.hasNext()){
                return sb.toString();
            }
            sb.append('&');
        }
    }



}
