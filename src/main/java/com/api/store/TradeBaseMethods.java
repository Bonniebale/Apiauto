package com.api.store;

import com.alibaba.fastjson.JSONObject;
import com.api.config.Interface;
import com.api.store.TradeAPIList;
import com.api.utils.HttpClientUtil;
import com.beust.jcommander.internal.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeBaseMethods {
    TradeAPIList tradeAPIList = new TradeAPIList();
    JSONObject resultJSONObject = new JSONObject();

    /**
     * 新增手工订单
     * @param httpClient
     * @return 订单的sid
     */
    public Object saveTrade(HttpClientUtil httpClient) {
        //添加请求参数
        JSONObject params = new JSONObject();
        params.put("receiverName","20210706");
        params.put("receiverState","浙江省");
        params.put("receiverCity","杭州市");
        params.put("receiverDistrict","上城区");
        params.put("receiverAddress","恒鑫大厦详细地址");
        params.put("receiverMobile","18790980000");
        params.put("userId","34457");//店铺id
        params.put("warehouseName","默认仓库");
        params.put("warehouseId","19677");
        params.put("templateType","1");
        //订单商品信息
        Map<String, String> orderMap = new HashMap<>();
        orderMap.put("itemSysId","409313320475136");
        orderMap.put("skuSysId","-1");
        orderMap.put("num","1");
        orderMap.put("outerId","Orange");
        orderMap.put("title","橘橘橘");
        orderMap.put("payment","345.56");
        orderMap.put("price","345.56");
        orderMap.put("totalFee","345.56");
        orderMap.put("discountFee","0");
        List<Map<String, String>> orders = Lists.newArrayList(orderMap);
        params.put("orders", orders);
        params.put("payment","345.56");
        params.put("totalFee","345.56");
        resultJSONObject = tradeAPIList.json(httpClient, Interface.SAVE_TRADE,params);
        return resultJSONObject.getString("sid");
    }

    /**
     * 保存快递模板
     * @param httpClient
     * @param sids 需要保存快递模板的sid
     */
    public void saveTemplate(HttpClientUtil httpClient, String sids) {
        //1.硬编码方式
        Map<String, String> params = new HashMap<>();
        params.put("sids",sids);
        params.put("templateId","48671");
        params.put("taobaoId","168357705073152");
        tradeAPIList.saveCloudTemplate(httpClient, Interface.TRADE_SAVE_CLOUD,params);
    }

    /**
     * 审核订单
     * @param httpClient
     * @param sids 需要审核的订单id
     * @return
     */
    public Object audit(HttpClientUtil httpClient, String sids, String status){
        Map<String, String> params = new HashMap<>();
        params.put("sids",sids);
        resultJSONObject = (JSONObject) tradeAPIList.auditTrade(httpClient, Interface.TRADE_AUDIT, params, status);
        return resultJSONObject;
    }

}
