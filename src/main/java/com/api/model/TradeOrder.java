package com.api.model;

import lombok.Data;

@Data
public class TradeOrder {
    //系统订单号
    private String sid;
    //内部单号
    private String shortId;
    //平台订单号
    private String tid;
    private String deliverStatus;
    private String timeType;
    private String outSid;
    private String expressStatus;
    private String key;
    private String queryType;
    private String itemType;
    private String text;
    private String skuProp;
    private String itemTitle;
    //店铺id
    private String userId;
    //发货仓库Id
    private String warehouseId;
    //发货仓库名称
    private String warehouseName;
    private Boolean highlight;
    private String field;
    private String order;
    private String queryId;
    private String pageSize;
    private String needOrder;
    private String useCompress;

    //昵称
    private String buyerNick;
    //
    private String buyerTaxNo;
    private String discountFee;
    private String expressCompanyId;
    private boolean force;
    private String invoiceName;
    private String isUrgent;
    private String customGiftType;
    private String discountRate;
    private String isVirtual;
    private String itemSysId;
    private String num;
    private String outerId;
    private String outerSkuId;
    //实付金额
    private String payment;
    private String picPath;
    private String price;
    private String saleFee;
    private String salePrice;
    private String skuPropertiesName;
    private String skuSysId;
    private String title;
    private String totalFee;
    private String postFee;

    //省
    private String receiverState;
    //市
    private String receiverCity;
    //区/县
    private String receiverDistrict;
    //收件人详细地址
    private String receiverAddress;
    //收件人手机号码
    private String receiverMobile;
    //收件人姓名
    private String receiverName;
    //收件人电话
    private String receiverPhone;
    //供销商名称
    private String destName;
    //分销商名称
    private String sourceName;

    private String receiverZip;
    private String sellerMemo;
    private String sysMemo;
    private String taxFee;
    private String templateId;
    //模板类型
    private String templateType;


}
