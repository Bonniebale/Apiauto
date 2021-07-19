package com.api.Tests;

import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.model.TradeModel;
import com.api.store.TradeAPIList;
import com.api.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class DataTest extends BaseTest {

    /**
     * 第1种方法
     * 返回类型是Iterator<Object[]>,不用管有多少组测试数据，可以抽取出来以map的id为参数作为公用的提取数据方法。
     * @return
     * @throws IOException
     */
    @DataProvider(name="loginData")
    private Iterator<Object[]> LoginDataProvider() throws IOException {
        List<Object[]> result = new ArrayList<Object[]>();
        SqlSession session= DatabaseUtil.getSqlSession();
        List<Object> alldata = session.selectList("loginTestAll");
        Iterator it = alldata.iterator();
        while(it.hasNext()){
            result.add(new Object[] { it.next() });
        }
        return  result.iterator();

    }

    /**
     * 第二种方法
     * 返回类型是Object[][]，明确知道有几组测试数据
     * @return
     * @throws IOException
     */
    @DataProvider(name="saveTemplate")
    private Object[][] saveTemplate() throws IOException {
        Object[][] result = null;
        SqlSession session = DatabaseUtil.getSqlSession();
        result = new Object[][]{
//                {session.selectOne("saveTemplate",1)},{session.selectOne("loginTest",2)}
                {session.selectOne("saveTemplate",1)}
        };
        return  result;
    }

    //调用
//    @Test(groups="login",dataProvider = "loginData")
//    public void loginTestCase(LoginTest loginTest) throws IOException {
//        //用测试数据发起请求，获取响应
//        String response = getResult(loginTest);
//
//        //响应断言
//        JSONObject rj = new JSONObject(response);
//        String code = rj.getInt("code")+"";
//        Assert.assertEquals(code,loginTest.getExpected());
//
//    }
    @Test(dataProvider = "saveTemplate",description = "保存快递模板")//data[1]/[0]/templateName data-trades-[0]/templateName=K_圆通一联单
    public void saveTemplate(TradeModel tradeOrderModer) throws IOException {
        JSONObject trade = new JSONObject();
        TradeAPIList tradeAPIList = new TradeAPIList();
//        sqlSession = DatabaseUtil.getSqlSession();
//        tradeOrderModer = sqlSession.selectOne("saveTemplate",1);
//        //保存快递模板
        //1.硬编码方式
//        String sids = trade.getString("sid");
//        Map<String, String> params = new HashMap<>();
//        params.put("sids",sids);
//        params.put("templateId","48671");
//        params.put("taobaoId","168357705073152");
//        System.out.println("params:"+params);
//        trade = (JSONObject) tradeAPIList.saveCloudTemplate(httpClientUtil, Interface.TRADE_SAVE_CLOUD,params);
//        Assert.assertEquals(trade.getString("templateName"),"K_圆通蓝牙一联单","保存的快递模板不是K_圆通蓝牙一联单");
        System.out.println("获取到的信息："+tradeOrderModer);
        //2.用例存放在数据库中
//        String sids = trade.getString("sid");
//        Map<String, String> params = new HashMap<>();
//        params.put("sids", tradeOrderModer.getSid());
//        params.put("templateId", String.valueOf(tradeOrderModer.getTemplateId()));
//        params.put("taobaoId", String.valueOf(tradeOrderModer.getTaobaoId()));
//        System.out.println("params:"+params);
//        trade = (JSONObject) tradeAPIList.saveCloudTemplate(httpClientUtil, Interface.TRADE_SAVE_CLOUD,params);
//        Assert.assertEquals(trade.getString("templateName"),tradeOrderModer.getTemplateName(),"保存的快递模板不是K_圆通蓝牙一联单");
        //3.dataProvider与sql结合

        //Object 转成map
//        Map map = JSONObject.parseObject(JSONObject.toJSONString(tradeOrderModer),Map.class);
//        Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(tradeOrderModer));
//        trade = (JSONObject) tradeAPIList.saveCloudTemplate(httpClientUtil, Interface.TRADE_SAVE_CLOUD, map);


    }

}
