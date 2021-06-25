package com.api.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.store.TradeAPIList;
import com.api.utils.HttpClientUtil;
import com.beust.jcommander.internal.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeOrder extends BaseTest {
    //public String url = ConfigFile.getUrl(InterfaceName.SEARCHOFTRADE);
    final String path = "/trade/search/sids";
    final String savePath = "/trade/save";
    TradeAPIList tradeAPIList = new TradeAPIList();


    @Test(description = "新增手工订单")
    public void addTradeOrder() throws IOException {
        //添加请求参数
       JSONObject params = new JSONObject();
        params.put("receiverName","自动化API 周五wans ");
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
        orderMap.put("num","2");
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
        System.out.println("params:"+params);
        JSONObject trade = tradeAPIList.saveTrade(httpClientUtil,savePath,params);//用这个会提示空指针,不是同一个httpclient的原因？---需要传递该
        //JSONObject trade = saveTrade(params);
        System.out.println(trade.get("sid"));

        loginDms();
       // dmsClient.post();
    }

    public JSONObject saveTrade(Map<String, Object> trade) {
        String str = JSONObject.toJSONString(trade);

        HttpClientUtil.ResultBean resultBean = httpClientUtil.postJson(savePath, str);

        return ((JSONObject) resultBean.getData()).getJSONArray("list").getJSONObject(0);
    }

    public Object auditTrade(Long sid) {

        return null;
    }


    @Test(description = "根据订单id查询订单数据")
    public void searchTradeInfoBySid() throws IOException {
        //添加请求参数
        Map<String, String> param1 = new HashMap<>();
        param1.put("sids","3315593247583747");

        //发送请求获取结果
        HttpClientUtil.ResultBean resultBean = httpClientUtil.post(path, param1);

        JSONObject data = (JSONObject) resultBean.getData();
        JSONArray list = data.getJSONArray("list");
        Assert.assertEquals(list.getJSONObject(0).getString("sid"),"3315593247583747","订单号不是3315593247583747");
    }
}
