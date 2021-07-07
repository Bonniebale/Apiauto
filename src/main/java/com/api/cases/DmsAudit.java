package com.api.cases;

import com.alibaba.fastjson.JSONObject;
import com.api.store.DmsBaseMethods;
import com.api.base.BaseTest;
import com.api.store.TradeBaseMethods;
import com.api.config.TradeOrderSidStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 分销订单审核规则校验
 */
public class DmsAudit extends BaseTest {
    DmsBaseMethods dmsBaseMethods = new DmsBaseMethods();
    TradeBaseMethods tradeBaseMethods = new TradeBaseMethods();
    JSONObject resultJSONObject = new JSONObject();
    String sid;

    @BeforeMethod
    public void setup(){
        //新增订单
        sid = (String) tradeBaseMethods.saveTrade(httpClientUtil);
        System.out.println("sid:"+sid);
        //新增分销属性
        dmsBaseMethods.dmsAddDistributor(httpClientUtil,sid);
        //强制指定供应商
        dmsBaseMethods.forceDistributor(httpClientUtil,sid,"31515");
        //保存快递模板
        tradeBaseMethods.saveTemplate(httpClientUtil,sid);
    }

    /***
     * 订单所属店铺是否在允许的代发店铺范围
     */
//    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditInsteadUserSuccess(){
        //设置店铺代发范围
        dmsBaseMethods.UpdateSupplierInfo(httpClientUtil,"2411","API","34457,47060,76803");
        //审核
        resultJSONObject = (JSONObject) tradeBaseMethods.audit(httpClientUtil,sid,"success");
        //判断审核是否成功
        Assert.assertEquals(resultJSONObject.getString("sysStatus"), TradeOrderSidStatus.WAIT_DEST_SEND_GOODS,"订单审核失败");
    }

//    @Test(groups = "auditFail", description = "订单审核校验代发店铺-失败")
    public void auditInsteadUserFail(){//订单的店铺是34457
        //设置店铺代发范围
        dmsBaseMethods.UpdateSupplierInfo(httpClientUtil,"2411","API","47060,76803");
        //审核
        resultJSONObject = (JSONObject) tradeBaseMethods.audit(httpClientUtil,sid,"fail");

        //判断审核是否成功
        String errorMsg = resultJSONObject.getString("errorMsg");
        Assert.assertTrue(errorMsg.contains("不属于供销商的代发店铺"));

    }

    /**
     * 商品在供销商处是否允许分销
     */
    @Test(groups = "auditSuccess", description = "商品在供销商处允许分销-成功")
    public void auditAllowProduct(){
        //设置商品允许分销

    }
    /**
     * 允许推送分销价为0的商品配置
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditSalePriceZero(){

    }
    /**
     * 供销推送订单校验库存配置
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditStock(){

    }
    /**
     * 允许分销商指定快递公司配置
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditExpress(){

    }
    /**
     * 供销设置分销等级的管控销售价
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditDmsSalePrice(){

    }
    /**
     * 异常标记及订单状态
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditOrderStatus(){

    }
    /**
     * 分销商余额情况
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditDmsBalance(){

    }
    /**
     * 订单商品匹配供销系统使用编码类型
     */
    @Test(groups = "auditSuccess", description = "订单审核校验代发店铺-成功")
    public void auditCodeType(){

    }
    /**
     * 自动审核
     */
    public void auditAuto(){

    }
    /**
     * 新增分销属性时自动审核
     */
    public void auditAutoAddDms(){

    }


}
