package com.api.base;

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
    public JSONObject saveTrade( String savePath,Map<String, Object> trade) {
        String str = JSONObject.toJSONString(trade);

        HttpClientUtil.ResultBean resultBean = httpClientUtil.postJson(savePath,str);

        return ((JSONObject) resultBean.getData()).getJSONArray("list").getJSONObject(0);
    }


}
