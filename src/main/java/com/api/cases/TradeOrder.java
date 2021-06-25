package com.api.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.utils.HttpClientUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TradeOrder extends BaseTest {
    //public String url = ConfigFile.getUrl(InterfaceName.SEARCHOFTRADE);
    final String url = "/trade/search/sids";

    @Test(description = "根据订单id查询订单数据")
    public void searchTradeInfoBySid() throws IOException {
        //添加请求参数
        Map<String, String> param1 = new HashMap<>();
        param1.put("sids","3315593247583747");

        //发送请求获取结果
        HttpClientUtil.ResultBean resultBean = httpClientUtil.post(url, param1);

        JSONObject data = (JSONObject) resultBean.getData();
        JSONArray list = data.getJSONArray("list");
        Assert.assertEquals(list.getJSONObject(0).getString("sid"),"3315593247583747","订单号不是3315593247583747");
    }
}
