package com.api.store;

import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.utils.HttpClientUtil;

import java.util.Map;

public class TradeAPIList extends BaseTest{

    /***
     * 新增手工单
     * @param trade 订单的具体字段 K-V
     * @return
     */
    public JSONObject saveTrade(HttpClientUtil httpClient, String savePath, Map<String, Object> trade) {
        String str = JSONObject.toJSONString(trade);

        HttpClientUtil.ResultBean resultBean = httpClient.postJson(savePath,str);

        return ((JSONObject) resultBean.getData()).getJSONArray("list").getJSONObject(0);
    }

    public Object auditTrade(Long sid) {

        return null;
    }


}
