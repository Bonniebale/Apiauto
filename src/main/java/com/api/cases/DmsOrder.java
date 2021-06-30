package com.api.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.config.TradeOrderSidStatus;
import com.api.config.UrlConfig;
import com.api.store.TradeAPIList;
import com.api.utils.HttpClientUtil;
import com.beust.jcommander.internal.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DmsOrder extends BaseTest {
    TradeAPIList tradeAPIList = new TradeAPIList();
    JSONObject trade = new JSONObject();



    @Test(description = "新增手工订单-新增分销属性-强制指定供销商-选择快递模板-审核")
    public void addTradeOrder() throws IOException {
        //添加请求参数
        JSONObject params = new JSONObject();
        params.put("receiverName","DMS最终版本");
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
        trade = tradeAPIList.saveTrade(httpClientUtil, UrlConfig.SAVE_TRADE,params);

        System.out.println(trade.get("sid"));

        //新增分销属性
        String sids = String.valueOf(trade.get("sid"));//long转成String
        //添加请求参数
        Map<String, String> sidsParam = new HashMap<>();
        sidsParam.put("sids",sids);
        trade = (JSONObject) tradeAPIList.form(httpClientUtil,UrlConfig.DMS_ADD_DISTRIBUTOR,sidsParam);
        Assert.assertEquals(trade.getString("convertType"),"1","订单号"+sids+"不是分销订单");

//        HttpClientUtil.ResultBean resultBean = httpClientUtil.post(UrlConfig.DMS_ADD_DISTRIBUTOR,sidsParam);
//        JSONObject data = (JSONObject) resultBean.getData();
//        JSONArray list = data.getJSONArray("list");
//        Assert.assertEquals(list.getJSONObject(0).getString("convertType"),"1","订单号"+sids+"不是分销订单");
        //强制指定供应商
        //添加请求参数
        Map<String, String> dmsParams = new HashMap<>();
        dmsParams.put("sids",sids);
        dmsParams.put("destId","31515");
        trade = (JSONObject) tradeAPIList.form(httpClientUtil,UrlConfig.DMS_FORCE_DISTRIBUTOR,dmsParams);
        Assert.assertEquals(trade.getString("destName"),"API","供销商名称不是API");

        //保存快递模板
        Map<String, String> saveTemplateParams = new HashMap<>();
        saveTemplateParams.put("sids",sids);
        saveTemplateParams.put("templateId","48671");
        saveTemplateParams.put("taobaoId","168357705073152");
        System.out.println("saveTemplateParams:"+saveTemplateParams);
        trade = (JSONObject) tradeAPIList.saveCloudTemplate(httpClientUtil,UrlConfig.TRADE_SAVE_CLOUD,saveTemplateParams);
        Assert.assertEquals(trade.getString("templateName"),"K_圆通蓝牙一联单","保存的快递模板不是K_圆通蓝牙一联单");
        //审核订单
        //String sids = (String) trade.get("sid");用这个会提示类型转换异常java.lang.Long cannot be cast to java.lang.String

        //审核订单
        trade = (JSONObject) tradeAPIList.auditTrade(httpClientUtil,UrlConfig.TRADE_AUDIT,sidsParam);
        Assert.assertEquals(trade.getString("sysStatus"), TradeOrderSidStatus.WAIT_DEST_SEND_GOODS,"订单"+sids+"状态不是待供销商发货，审核失败");
    }
}
