package com.api.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.config.Interface;
import com.api.config.TradeOrderSidStatus;
import com.api.model.TradeOrderModel;
import com.api.store.TradeAPIList;
import com.api.utils.DatabaseUtil;
import com.api.utils.HttpClientUtil;
import com.beust.jcommander.internal.Lists;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeOrder extends BaseTest {
    TradeAPIList tradeAPIList = new TradeAPIList();
    JSONObject tradeJSONObject = new JSONObject();
    SqlSession sqlSession;
//    SqlSession sqlSession = DatabaseUtil.getSqlSession();
    TradeOrderModel tradeOrderModer = new TradeOrderModel();

    @Test(description = "新增手工订单")
    public void addTradeOrder() {

        //添加请求参数
       JSONObject params = new JSONObject();
        params.put("receiverName","20210629-2");
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
        orderMap.put("num","1000000000");
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

//        //*****需要抛出异常的做法
//        HttpClientUtil.ApiException exception = null;
//        try {
//            tradeJSONObject = tradeAPIList.json(httpClientUtil,Interface.SAVE_TRADE,params);
//        } catch (HttpClientUtil.ApiException e) {
//            exception = e;
//        }
//
//        Assert.assertNotNull(exception);
//        System.out.println("code:"+exception.getSubCode());
//        Assert.assertEquals(exception.getSubCode(), Integer.valueOf(101));
//        Assert.assertTrue(exception.getMessage().contains("库存不足"));
        tradeJSONObject = tradeAPIList.json(httpClientUtil, Interface.SAVE_TRADE,params);
        //trade = tradeAPIList.saveTrade(httpClientUtil,Interface.saveTradeUrl,params);//用这个会提示空指针,不是同一个httpclient的原因？---需要传递该
        //JSONObject trade = saveTrade(params);
        System.out.println(tradeJSONObject.get("sid"));

    }

//    @Test(dependsOnMethods = {"addTradeOrder"},description = "新增分销属性")
// convertType=1 为分销订单,form-data,如果用dependMethods 该test执行顺序为最后
    @Test(description = "新增分销属性AND 强制指定供销商")
    public void dmsAddDistributor(){
        String sids = (String) tradeJSONObject.get("sid");
        System.out.println("sid:"+sids);
        //添加请求参数
        Map<String, String> params = new HashMap<>();
        params.put("sids",sids);

        //tradeAPIList.form(httpClient,Interface.DMS_ADD_DISTRIBUTOR,params); 调用tradeAPIList封装的方法
        HttpClientUtil.ResultBean resultBean = httpClientUtil.post(Interface.DMS_ADD_DISTRIBUTOR,params);//直接调用httpclientUtil类的post方法
        JSONObject data = (JSONObject) resultBean.getData();
        JSONArray list = data.getJSONArray("list");
        Assert.assertEquals(list.getJSONObject(0).getString("convertType"),"1","订单号"+sids+"不是分销订单");
        //强制指定供应商
        //添加请求参数
        Map<String, String> dmsParams = new HashMap<>();
        dmsParams.put("sids",sids);
        dmsParams.put("destId","31515");
        tradeJSONObject = (JSONObject) tradeAPIList.form(httpClientUtil, Interface.DMS_FORCE_DISTRIBUTOR,dmsParams);
        Assert.assertEquals(tradeJSONObject.getString("destName"),"API","供销商名称不是API");
    }

//    public JSONObject saveTrade(Map<String, Object> trade) {
//        String str = JSONObject.toJSONString(trade);
//
//        HttpClientUtil.ResultBean resultBean = httpClientUtil.postJson(savePath, str);
//
//        return ((JSONObject) resultBean.getData()).getJSONArray("list").getJSONObject(0);
//    }
//public Object auditTrade(Long sid) {
//
//    return null;
//}
    @Test(description = "保存快递模板")//data[1]/[0]/templateName data-trades-[0]/templateName=K_圆通一联单
    public void saveTemplate() throws IOException {
        //1.硬编码方式
//        String sids = trade.getString("sid");
//        Map<String, String> params = new HashMap<>();
//        params.put("sids",sids);
//        params.put("templateId","48671");
//        params.put("taobaoId","168357705073152");
//        System.out.println("params:"+params);
//        trade = (JSONObject) tradeAPIList.saveCloudTemplate(httpClientUtil, Interface.TRADE_SAVE_CLOUD,params);
//        Assert.assertEquals(trade.getString("templateName"),"K_圆通蓝牙一联单","保存的快递模板不是K_圆通蓝牙一联单");
        sqlSession = DatabaseUtil.getSqlSession();
        tradeOrderModer = sqlSession.selectOne("saveTemplate",1);
        System.out.println("获取到的信息："+tradeOrderModer.toString());
        //2.用例存放在数据库中
        String sids = tradeJSONObject.getString("sid");
        Map<String, String> params = new HashMap<>();
        params.put("sids", sids);
//        params.put("sids", tradeOrderModer.getSid());//数据库里面订单号写死了
        params.put("templateId", String.valueOf(tradeOrderModer.getTemplateId()));
        params.put("taobaoId", String.valueOf(tradeOrderModer.getTaobaoId()));
        System.out.println("params:"+params);
        tradeJSONObject = (JSONObject) tradeAPIList.saveCloudTemplate(httpClientUtil, Interface.TRADE_SAVE_CLOUD,params);
        Assert.assertEquals(tradeJSONObject.getString("templateName"),tradeOrderModer.getTemplateName(),"保存的快递模板不是K_圆通蓝牙一联单");
        //3.dataProvider与sql结合
    }

    @Test(description = "审核订单")//form
    public void tradeAudit(){
        //String sids = (String) trade.get("sid");用这个会提示类型转换异常java.lang.Long cannot be cast to java.lang.String
        String sids = String.valueOf(tradeJSONObject.get("sid"));//long转成String
        Map<String, String> params = new HashMap<>();
        params.put("sids",sids);

        //审核订单
        tradeJSONObject = (JSONObject) tradeAPIList.auditTrade(httpClientUtil, Interface.TRADE_AUDIT,params,"success");
        Assert.assertEquals(tradeJSONObject.getString("sysStatus"), TradeOrderSidStatus.WAIT_DEST_SEND_GOODS,"订单"+sids+"状态不是待供销商发货，审核失败");

    }

    @Test(dependsOnMethods = {"tradeAudit"},description = "根据订单id查询订单数据")
    public void searchTradeInfoBySid() {
        loginDms();
        // dmsClient.post();

        String tid = String.valueOf(tradeJSONObject.get("sid"));
        //添加请求参数
//        JSONObject params = new JSONObject();//json用这个
        Map<String, String> params = new HashMap<>();
        params.put("tid",tid);
//        String jsonStr = JSONObject.toJSONString(params);
        tradeJSONObject = (JSONObject) tradeAPIList.form(dmsClient, Interface.SEARCH_TRADE,params);
        Assert.assertEquals(tradeJSONObject.getJSONArray("tids").getString(0),tid,"平台订单号不为"+tid);//根据tid查出来的返回值中tid是一个数组
        System.out.println("tid="+tradeJSONObject.getJSONArray("tids").getString(0));
        System.out.println("tid="+tradeJSONObject.getString("tids"));
        System.out.println("sid="+tradeJSONObject.getString("sid"));

//        //发送请求获取结果
//        HttpClientUtil.ResultBean resultBean = dmsClient.post(Interface.SEARCH_TRADE,params);
//
//        JSONObject data = (JSONObject) resultBean.getData();
//        JSONArray list = data.getJSONArray("list");
//        Assert.assertEquals(list.getJSONObject(0).getString("sid"),sids,"订单号不是"+sids);
    }
}
