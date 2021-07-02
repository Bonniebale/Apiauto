package com.api.model;

import lombok.Data;

import java.sql.Types;
import java.util.Date;

/***
 * 订单中所有可能遇到的字段，与database一一对应
 */
@Data
public class TradeOrder {

    /**
     * 分销金额
     */
//    @Column(name = "sale_price", type = Types.VARCHAR)
    private String saleFee;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件省份
     */
//    @Column(name = "receiver_state", type = Types.VARCHAR)
    private String receiverState;

    /**
     * 收件市
     */
//    @Column(name = "receiver_city", type = Types.VARCHAR)
    private String receiverCity;
    /**
     * 收件区县
     */
    private String receiverDistrict;

    /**
     * 收件详细地址
     */
    private String receiverAddress;
    /**
     * 收件人手机号
     */
    private String receiverMobile;

    /**
     * 订单来源于哪里 分销系统里记为分销商id（companyId）
     */
//        @Column(name = "source_id", type = Types.BIGINT)
    private Long sourceId;

    /**
     * 订单归属于哪里 分销系统里记为供销商id（companyId）
     */
//        @Column(name = "dest_id", type = Types.BIGINT)
    private Long destId;

    /**
     * 订单来源于哪里 分销系统里记为分销商name（不持久化）
     */
    private String sourceName;

    /**
     * 订单归属于哪里 分销系统里记为供销商nname（不持久化）
     */
    private String destName;
//    /**
//     * 如果是供销订单，这个值代表对应的分销订单
//     * 如果是分销订单，这个值代表对应的供销订单
//     */
//    private Trade sourceTrade;
    /**
     * 供销订单用
     */
    private Integer wlbTemplateType;
    /**
     * 分销订单是否在系统上传（供销订单用）
     */
    private Integer fxIsUpload;

    /**
     * 供销订单使用,分销作废来源
     * 0,取消分销属性
     * 1，分销订单作废
     */
    private Integer cancelFrom;

    /**
     * 是否是取消分销属性触发的订单同步，如果是1，则不需要匹配供应商，因为是取消分销属性
     */
    private Integer isCancelDistributorAttribute;



//    private String taxFee;
    /**
     * 快递模板编号
     */
//        @Column(name = "template_id", type = Types.BIGINT)
    private Long templateId;

    /**
     * 快递模版类型，0表示普通快递，1表示电子面单快递，默认为0
     */
//        @Column(name = "template_type", type = Types.TINYINT)
    private Integer templateType;
    /**
     * 订单转化类型 0表示正常订单，1表示分销系统
     */
//        @Column(name = "convert_type", type = Types.INTEGER)
    private Integer convertType;



    /**
     * 系统订单号
     */
//        @Column(name = "sid", type = Types.BIGINT, key = true)
    private Long sid;

    /**
     * 店铺用户编号
     */
//        @Column(name = "user_id", type = Types.BIGINT)
    private Long userId;
    /**
     * 公司编号
     */
    //@Column(name = "company_id", type = Types.BIGINT)@Column 用来标识实体类中属性与数据表中字段的对应关系
    //
    private Long companyId;

    /**
     * 平台的卖家账户
     */
//        @Column(name = "taobao_id", type = Types.BIGINT)
    private Long taobaoId;

//    /**
//     * 订单来自哪个平台，例如 tb(淘宝或者天猫平台),jd(京东平台),sys(系统手工订单)
//     */
////        @Column(name = "source", type = Types.VARCHAR)
//    private String source;


    /**
     * 平台订单号
     */
    private String tid;

    /**
     * 总额
     */
//        @Column(name = "total_fee", type = Types.VARCHAR)
    private String totalFee;

    /**
     * 实付金额
     */
    //@Column(name = "payment", type = Types.VARCHAR)
    private String payment;

    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 仓库编号
     */
    //@Column(name = "warehouse_id", type = Types.BIGINT)
    private Long warehouseId;
    /**
     * 快递公司的编号，不做持久化处理
     */
    private Long expressCompanyId;

    /**
     * 模板名称,不做持久化处理
     */
    private String templateName;

    /**
     * 需要反审核的分销/供销订单
     */
    private boolean fxNeedUnaudit;

    /**
     *
     */
    private String fxSysStatus;

    /**
     * 分销订单是否撤销发货

     */
    private boolean fxCancelConsign;

    /**
     * 是否是分销订单重推过来的（供销订单用）
     */
    private boolean isFxReAudit;

    /**
     * 分销商支付方式，目前仅用于档口订单excel导入
     */
    private String fxPayType;


    /**
     * 订单属于soure or dest ,0表示正常订单，1表示source，2表示dest
     */
//        @Column(name = "belong_type", type = Types.INTEGER)
    private Integer belongType;

    /**
     * 订单级别的系统异常，参考itemExcep 目前不明确供销商”、“分销商反审核”、“分销商未付款“
     */
//        @Column(name = "excep", type = Types.BIGINT)
    private Long excep;
    /**
     * 订单实收金额
     */
    private Double tradePurchaseAmount;
    /**
     * 平台支付金额
     */
    private Double platformPaymentAmount;
    /**
     * 手工支付金额
     */
    private Double manualPaymentAmount;

    /**
     * 毛利润
     */
    private Double grossProfit;
    /**
     * 供销订单流水号
     */
    private Long flowNumber;
//    /**
//     * 收件人固话
//     */
//    //@Column(name = "receiver_phone", type = Types.VARCHAR)
//    private String receiverPhone;
    //    /**
//     * 运单号
//     */
////        @Column(name = "out_sid", type = Types.VARCHAR)
//    private String outSid;

    //
//    /**
//     * 平台上的卖家备注
//     */
////    @Column(name = "seller_memo", type = Types.VARCHAR)
//    private String sellerMemo;


//    /**
//     * 地址加密的的信息：receiverName+receiverPhone+receiverMobile+receiverZip+receiverState+receiverCity+receiverDistrict+receiverAddress
//     */
//    @Column(name = "address_md5", type = Types.VARCHAR)
//    private String addressMd5;

//    /**
//     * 收件地址类型 0 城区地址，1 非城区地址（详细地址中包含镇、乡、村、左旗、右旗等关键字，因此可能存在误差）
//     */
//    @Column(name = "address_type", type = Types.TINYINT)
//    private Integer addressType;

//    /**
//     * 收件邮编
//     */
//    @Column(name = "receiver_zip", type = Types.VARCHAR)
//    private String receiverZip;
//
//    /**
//     //     * 订单短号
//     //     */
//    private Long shortId;


//    /**
//     * 扫描手动拆单个数时 ,做记录
//     */
//        @Column(name = "check_manual_merge_count", type = Types.INTEGER)
//    private Integer checkManualMergeCount;

//    /**
//     * 订单类型
//     */
////        @Column(name = "type", type = Types.VARCHAR)
//    private String type;

    /**
     * 订单的平台状态
     */
//        @Column(name = "status", type = Types.VARCHAR)
    private String status;
    /**
     * 订单的系统状态，平台订单的系统状态由所有平台子订单综合计算得出
     */
//        @Column(name = "sys_status", type = Types.VARCHAR)
    private String sysStatus;

//    /**
//     * 各平台状态映射后的统一状态
//     */
////        @Column(name = "unified_status", type = Types.VARCHAR)
//    private String unifiedStatus;
//
//    /**
//     * 平台之前的订单状态，不持久，一般用于订单同步用
//     */
//    private String oldStatus;


//
//    /**
//     * 订单系统状态的中文说明
//     */
//    private String chSysStatus;
//
//    /**
//     * 更新之前的系统状态，不做持久化，一般用于订单同步
//     */
//    private String oldSysStatus;

    /**
     * 库存状态
     */
//        @Column(name = "stock_status", type = Types.VARCHAR)
    private String stockStatus;

    /**
     * 做库存更新之前的库存状态，不做持久化
     */
    private String oldStockStatus;

//    /**
//     * 当前有效的商品数,部分发货的订单只包含尚未发货的商品数（非持久化字段）
//     */
//    private Integer validItemNum;
//    /**
//     * 订单缺货数量（所有子订单缺货数量之和）
//     */
//    @Column(name = "insufficient_num", type = Types.INTEGER)
//    private Integer insufficientNum;
//
//    /**
//     * 缺货比例
//     */
//    private Double insufficientRate;
//
//    /**
//     * 下单时间
//     */
//    @Column(name = "created", type = Types.TIMESTAMP)
//    private Date created;
//
//    /**
//     * 付款时间
//     */
//    @Column(name = "pay_time", type = Types.TIMESTAMP)
//    private Date payTime;

//    /**
//     * 订单在平台上的修改时间
//     */
////        @Column(name = "modified", type = Types.TIMESTAMP)
//    private Date modified;

//    /**
//     * 发货时间
//     */
////        @Column(name = "consign_time", type = Types.TIMESTAMP)
//    private Date consignTime;
//
//    /**
//     * 平台发货时间
//     */
////        @Column(name = "pt_consign_time", type = Types.TIMESTAMP)
//    private Date ptConsignTime;

//    /**
//     * 发货类型，非持久化字段
//     */
//        private SendType consignType;

//    /**
//     * 是否在系统发货 1 是，0 否
//     */
////        @Column(name = "sys_consigned", type = Types.TINYINT)
//    private Integer sysConsigned;

//    /**
//     * 完结时间
//     */
//    @Column(name = "end_time", type = Types.TIMESTAMP)
//    private Date endTime;

//    /**
//     * 数据库最后更新时间
//     */
////        @Column(name = "upd_time", type = Types.TIMESTAMP)
//    private Date updTime;



//    /**
//     * 快递是否可送达，0表示不可送达，1表示可送达，默认为1，需要持久化
//     */
////        @Column(name = "can_delivered", type = Types.TINYINT)
//    private Integer canDelivered;

//    /**
//     * 是否可确认发货或者取消发货，0表示不能确认或者取消，1表示可用。这个字段一般在使用了
//     * 在线发货功能的时候，使用到。在线发货如果没有填写运单号，应该要将这个字段设置为1
//     */
////        @Column(name = "can_confirm_send", type = Types.TINYINT)
//    private Integer canConfirmSend;

    /**
     * 订单使用的模板是否为手工填写单号模板
     */
//        private Integer isManulfill;





    /**
     * 备选快递模板，不做持久化
     */
//        private List<IExpressTemplateBase> backTemplateList;

    /**
     * 标签名称，不做持久化处理
     */
//        private List<String> tagName;
    /**
     *标签列表
     */
//        private List<TradeTag> tags;




//    /**
//     * 快递公司的编码，不做持久化处理
//     */
//    private String expressCode;



//    /**
//     * 快递单打印时间
//     */
////        @Column(name = "express_print_time", type = Types.TIMESTAMP)
//    private Date expressPrintTime;
//
//    /**
//     * 发货单打印时间
//     */
//    @Column(name = "deliver_print_time", type = Types.TIMESTAMP)
//    private Date deliverPrintTime;
//
//    /**
//     * 配货单打印时间
//     */
//    @Column(name = "assembly_print_time", type = Types.TIMESTAMP)
//    private Date assemblyPrintTime;
//    /**
//     * 首次订单同步时匹配到的仓库规则id,非持久化字段
//     */
//    private Long warehouseMatchRuleId;
//
//    /**
//     * 换仓库之前的仓库ID,不做持久化
//     */
//    private Long oldWarehouseId;


    /**
     * 审核时间
     */
//        @Column(name = "audit_time", type = Types.TIMESTAMP)
//        private Date auditTime;

    /**
     * 自动审核字段： 0：未审核 1：自动审核 2：人工审核 3：反审核
     */
//        @Column(name = "is_auto_audit", type = Types.TINYINT)
//        private Integer isAutoAudit;

    /**
     * 实际的物流费用，通过weight重量、收货地址，运费模板等字段运算出来
     */
//        @Column(name = "actual_post_fee", type = Types.VARCHAR)
//        private String actualPostFee;

    /**
     * 邮费
     */
//        @Column(name = "post_fee", type = Types.VARCHAR)
//        private String postFee;

    /**
     * 优惠
     */
//        @Column(name = "discount_fee", type = Types.VARCHAR)
//        private String discountFee;

//    /**
//     * 手工调整订单价格
//     */
////        @Column(name = "adjust_fee", type = Types.VARCHAR)
//    private String adjustFee;




//    /**
//     * 不变的实付金额
//     */
////        @Column(name = "ac_payment", type = Types.VARCHAR)
//    private String acPayment;
//
//    private String oldAcPayment;





//    /**
//     * 手机后四位尾号
//     */
//    private String mobileTail;



//    /**
//     * 平台订单上的买家昵称
//     */
//    @Column(name = "buyer_nick", type = Types.VARCHAR)
//    private String buyerNick;


//    /**
//     * 是否有买家留言
//     */
//    private Boolean hasBuyerMessage;

//    /**
//     * 平台订单上的买家留言
//     */
//    @Column(name = "buyer_message", type = Types.VARCHAR)
//    private String buyerMessage;
//
//    /**
//     * 平台上的卖家旗帜
//     */
//    @Column(name = "seller_flag", type = Types.TINYINT)
//    private Long sellerFlag;



//    /**
//     * 卖家备注是否有修改 1：有修改 0：未修改
//     */
////    @Column(name = "seller_memo_update", type = Types.TINYINT)
//    private Integer sellerMemoUpdate;
//
//    /**
//     * 订单系统备注
//     */
////    @Column(name = "sys_memo", type = Types.VARCHAR)
//    private String sysMemo;

//        /**
//         * 发票种类（ 1 电子发票 2 纸质发票 ）
//         */
//        @Column(name = "invoice_kind", type = Types.VARCHAR)
//        private String invoiceKind;
//
//        /**
//         * 发票抬头
//         */
//        @Column(name = "invoice_name", type = Types.VARCHAR)
//        private String invoiceName;
//
//        /**
//         * 发票类型
//         */
//        @Column(name = "invoice_type", type = Types.VARCHAR)
//        private String invoiceType;
//
//        /**
//         * 发票备注
//         */
//        @Column(name = "invoice_remark", type = Types.VARCHAR)
//        private String invoiceRemark;
//
//        /**
//         * 需要开具发票 1开启，0关闭
//         */
//        @Column(name = "need_invoice", type = Types.TINYINT)
//        private Integer needInvoice;
//
//        /**
//         * 发票类型 1普通 2增值
//         */
//        @Column(name = "invoice_format", type = Types.TINYINT)
//        private Integer invoiceFormat;
//
//        /**
//         * 买家税号
//         */
//        @Column(name = "buyer_tax_no", type = Types.VARCHAR)
//        private String buyerTaxNo;
//
//        /**
//         * 3PL有时效订单标，值true 或者 false
//         */
//        @Column(name = "three_pl_timing", type = Types.TINYINT)
//        private Integer threePlTiming;
//
//        /**
//         * 天猫直送，值true 或者 false
//         */
//        @Column(name = "is_tmall_delivery", type = Types.TINYINT)
//        private Integer isTmallDelivery;
//
//
//        /**
//         * 订单来源，例如手机端或者PC端
//         */
//        @Column(name = "trade_from", type = Types.VARCHAR)
//        private String tradeFrom;

//    /**
//     * 订单总成本价,所有商品总成本价之和
//     */
//    //@Column(name = "cost", type = Types.DOUBLE)
//    private Double cost;

//    /**
//     * 重量
//     */
//    @Column(name = "weight", type = Types.DOUBLE)
//    private Double weight;
//
//    /**
//     * 订单净重，由子订单综合计算得出，参照Order#netWeight
//     */
//    @Column(name = "net_weight", type = Types.DOUBLE)
//    private Double netWeight;
//
//    /**
//     * 订单体积
//     */
//    @Column(name = "volume", type = Types.DOUBLE)
//    private Double volume;
//
//    /**
//     * 订单下的商品数量
//     */
//    @Column(name = "item_num", type = Types.INTEGER)
//    private Integer itemNum;
//
//    /**
//     * 波次计算使用
//     */
//    private Integer oldItemNum;
//
//    /**
//     * 订单下的商品种类数
//     */
//    @Column(name = "item_kind_num", type = Types.INTEGER)
//    private Integer itemKindNum;
//
//    /**
//     * 波次计算使用
//     */
//    private Integer oldItemKindNum;
//
//    /**
//     * 商品单品种类, 最小粒度
//     */
//    private Integer singleItemKindNum;
//
//    /**
//     * 是否门店分单 0 否，1 是
//     */
//    @Column(name = "is_store", type = Types.TINYINT)
//    private Integer isStore;
//
//    /**
//     * 是否刷单 1 是, 0 否
//     */
//    @Column(name = "scalping", type = Types.TINYINT)
//    private Integer scalping;
//
//    /**
//     * 是否包含退款订单
//     */
//    @Column(name = "is_refund", type = Types.TINYINT)
//    private Long isRefund;
//
//    /**
//     * 是否挂起订单
//     */
//    @Column(name = "is_halt", type = Types.TINYINT)
//    private Integer isHalt;
//
//    /**
//     * 是否异常订单
//     */
//    @Column(name = "is_excep", type = Types.TINYINT)
//    private Integer isExcep;
//
//    /**
//     * 是否为作废订单
//     */
//    @Column(name = "is_cancel", type = Types.TINYINT)
//    private Integer isCancel;
//
//    /**
//     * 订单是否打包
//     */
//    @Column(name = "is_package", type = Types.TINYINT)
//    private Integer isPackage;
//
//
//    /**
//     * 是否称重
//     */
//    @Column(name = "is_weigh", type = Types.TINYINT)
//    private Integer isWeigh;
//
//    /**
//     * 是否是加急订单
//     */
//    @Column(name = "is_urgent", type = Types.TINYINT)
//    private Integer isUrgent;
//
//    /**
//     * 是否为预售订单：0:正常订单，1：是预售；2预售转正常；3：系统预售
//     */
//    @Column(name = "is_presell", type = Types.TINYINT)
//    private Integer isPresell;
//
//    /**
//     * 预售规则ID
//     */
//    @Column(name = "presell_rule_id", type = Types.BIGINT)
//    private Long presellRuleId;
//
//    private PresellRule presellRule;

//    /**
//     * 平台timeout_action_time
//     */
//    @Column(name = "timeout_action_time", type = Types.TIMESTAMP)
//    private Date timeoutActionTime;
//
//    /**
//     * 波次id
//     */
//    @Column(name = "wave_id", type = Types.BIGINT)
//    private Long waveId;

//    /**
//     * 位置号
//     */
//    private Long positionNo;
//
//
//    /**
//     * 是否系统触发过上传
//     */
//    private boolean sysTriggerUpload;

//    /**
//     * 装箱清单明细json串
//     */
//    @Column(name = "boxing_list", type = Types.VARCHAR)
//    private String boxingList;

//        /**
//         * 唯品会po单号
//         */
//        @Column(name = "po_nos", type = Types.VARCHAR)
//        private String poNos;
//
//        /**
//         * 唯品会拣货单号
//         */
//        @Column(name = "vip_pick_no", type = Types.VARCHAR)
//        private String vipPickNo;
//
//        /**
//         * 唯品会出仓单号
//         */
//        @Column(name = "vip_storage_no", type = Types.VARCHAR)
//        private String vipStorageNo;

//    /**
//     * enable_status=0 Delete操作
//     * enable_status=1 常规状态
//     * enable_status=2 合单操作,被合单订单
//     */
//    @Column(name = "enable_status", type = Types.VARCHAR)
//    private Integer enableStatus;

//    /**
//     * 新建订单库存不足时是否强制生成
//     */
//    private boolean force;

//    /**
//     * 0位为1表示，对应关系改变，1位为1表示缺货，
//     */
//    @Column(name = "item_excep", type = Types.TINYINT)
//    private Integer itemExcep;
//
//
//    /**
//     * 订单打印次数
//     */
//    @Column(name = "print_count", type = Types.INTEGER)
//    private  Integer printCount;
//
//    /**
//     * 库区类型
//     * @see com.raycloud.dmj.domain.wms.enums.StockRegionTypeEnum
//     */
//    private Integer stockRegionType;

//    /**
//     * 只更新子订单，这个不做存储，只做逻辑分析
//     */
//    private boolean isSplitTrade = false;

//        /**
//         * （星盘）分单渠道信息系
//         */
//        private List<OrderChannel> channels;
//
//        /**
//         * 赠品子订单
//         */
//        protected List<GiftOrder> giftOrders;
//
//        /**
//         * 订单异常信息
//         */
//        private Set<TradeExcStatus> excStauses;

//    /**
//     * 再次同步订单时,欲更新的平台订单所对应的系统中已存在的订单,目前只在订单同步时使用
//     */
//    private Trade origin;

//    /**
//     * 是否需要重算cost，volume，netWeight,默认需要重算
//     */
//    private boolean needRecal = true;

//    /**
//     * 当只有合单的订单，这个属性才会被创建出来
//     */
//    private List<MessageMemo> messageMemos;
//
//    /**
//     * 订单同步的时候地址是否有变更
//     */
//    @Column(name = "address_changed", type = Types.TINYINT)
//    private Integer addressChanged;
//
//    /**
//     * 合单类型
//     * @see com.raycloud.dmj.domain.enums.TradeMergeEnum
//     */
//    @Column(name = "merge_type", type = Types.INTEGER)
//    private Integer mergeType;
//
//    /**
//     * 如果merge_type等于1或2。则对应合单后主单的sid。否则为0
//     */
//    @Column(name = "merge_sid", type = Types.BIGINT)
//    private Long mergeSid;
//
//    /**
//     * 拆单类型
//     */
//    @Column(name = "split_type", type = Types.INTEGER)
//    private Integer splitType;
//
//    /**
//     * 如果split_type等于1。则对应拆单的主单的sid。否则为0
//     */
//    @Column(name = "split_sid", type = Types.BIGINT)
//    private Long splitSid;
//
//    /**
//     * 库存调剂类型 1：被调剂的订单 2：接受调剂的订单
//     */
//    private Integer swapStockType;

//    /**
//     * 经过分销处理后，要从列表中删除
//     */
//    private boolean removeAfterFxPre;

//        /**
//         * 0：非黑名单 1：黑名单 2：取消黑名单
//         */
//        @Column(name = "black_buyer_nick", type = Types.TINYINT)
//        private Integer blackBuyerNick;
//        /**
//         * 订单下第一个匹配系统商品的子订单的系统商家编码，若都没有匹配，则直接取第一个商品的平台商家编码
//         */
//        @Column(name = "sys_outer_id", type = Types.VARCHAR)
//        private String sysOuterId;
//
//        /**
//         * 波次计算使用
//         */
//        private String oldSysOuterId;
//
//        /**
//         * 拆分装箱
//         */
//        private List<TradePackSplit> tradePackSplits;
//
//        /**
//         * 是否智选物流订单
//         */
//        @Column(name = "is_smart", type = Types.TINYINT)
//        private Integer isSmart;
//
//        /**
//         * 0：非家装类型 1：家装类型
//         */
//        @Column(name = "is_jz", type = Types.TINYINT)
//        private Integer isJz;
//
//        /**
//         * 该订单是否扣过费(打印快递单或系统发货时设置为1)
//         */
//        private Integer isDeduct;
//        /**
//         * 收件国家，跨境订单使用
//         */
//        @Column(name = "receiver_country", type = Types.VARCHAR)
//        private String receiverCountry;

//    /**
//     * 次来源地 {@link com.raycloud.dmj.domain.user.User#subSource}
//     *     jd 保存订单来源
//     */
//    @Column(name = "sub_source", type = Types.VARCHAR)
//    private String subSource;

//        /**
//         * 税费
//         */
//        @Column(name = "tax_fee", type = Types.VARCHAR)
//        private String taxFee;
//
//    /**
//     * 是否含有套件
//     */
//    private Boolean hasSuit;
//
//    /**
//     * 所在货位
//     */
//    private List<String> goodsSectionCodes;
//
//    /**
//     * 商品对应的货位
//     */
//    private Map<String, List<String>> itemGoodsSectionCodes;
//
//    /**
//     * 所有的供应商id
//     */
//    private Set<Long> supplierIds;
//    /**
//     * 所有的商品品牌
//     */
//    private Set<String> brands;
//    /**
//     * 所有的商品分类
//     */
//    private Set<Long> sellerCids;
//
//    /**
//     * 所在库区
//     */
//    private String sectionAreaCodes;

//    /**
//     * 标签id,以,分隔
//     */
//    @Column(name = "tag_ids", type = Types.VARCHAR)
//    private String tagIds;
//    /**
//     * 自定义异常ID,多个以逗号分隔
//     */
//    private String exceptIds;
//    /**
//     * 手动添加的标签或异常备份放到这里，用于判断原字段里的哪些是手动添加的，多个逗号分隔，id_1为标签，id_2为自定义异常
//     */
//    @Column(name = "manual_mark_ids", type = Types.VARCHAR)
//    private String manualMarkIds;
//
//    /**
//     * 自定义异常,非持久化字段
//     */
//    private List<String> exceptNames;
//
//    /**
//     * 包材成本
//     */
//    @Column(name = "packma_cost", type = Types.DOUBLE)
//    private Double packmaCost;

//    /**
//     * sale_price 修复bug 不参与计算
//     */
//    private String salePrice;
//
//    /**
//     * 是否包含赠品
//     */
//    private Boolean containGift;
//
//    /**
//     * 订单操作记录 不持久化到数据库,后续不用在为了打操作记录而去加trade中字段
//     */
//    private String tradeTrace;
//
//    /**
//     * 不计算到波次的原因
//     */
//    private String notInWaveReason;
//    /**
//     * 不匹配到波次的原因（规则）
//     */
//    private String notMatchWaveReason;
//
//    /**
//     * 店铺名称
//     */
//    private   String  shopName;

    /**
     * 订单的异常信息
     */
//    private Set<String> exceptions;

//    /**
//     * 异常备注
//     */
////        @Column(name = "except_memo", type = Types.VARCHAR)
//    private String exceptMemo;

//        /**
//         * 是否发送消息给快麦客服
//         */
//        @Column(name = "is_sendmessage", type = Types.TINYINT)
//        private Integer isSendmessage;
//        /**
//
//         /**
//         * 提货类型 1-自提 2-快递邮寄
//         */
//        @Column(name = "pick_goods_type", type = Types.TINYINT)
//        private Integer pickGoodsType;

//        /**
//         * 是否处理买家留言： 0：未处理 1：已处理
//         */
//        @Column(name = "is_handler_message", type = Types.TINYINT)
//        private Integer isHandlerMessage;

//        /**
//         * 是否处理买家留言： 0：未处理 1：已处理
//         */
//        @Column(name = "is_handler_memo", type = Types.TINYINT)
//        private Integer isHandlerMemo;

//        /**
//         * 快递停发异常： 0 或者 null: 无异常； 1：异常
//         */
//        @Column(name = "unattainable", type = Types.TINYINT)
//        private Integer unattainable;

//    /**
//     * 地址、手机/固话、收件人、商品信息缺失的订单
//     */
//    private Integer isLostMsg;



//    /**
//     * 服务身份标识
//     */
//    private String timingPromise;

//        /**
//         * 承诺服务类型，会有多个服务值，以英文半角逗号","切割，其中 tmallpromise.arrival.timing 代表到货承诺时效 tmallpromise.consign.timing代表发货承诺时效
//         */
//        private String promiseService;
//
//        /**
//         * 最晚发货时间，日期，格式2019-04-12 16:00:00 时间等同于最晚揽收时间；
//         */
//        private Date deliveryTime;
//
//        /**
//         * 最晚揽收时间，日期，格式2019-04-12 16:00:00 因发货以有物流揽收记录为准，因此发货和到货订单都会基于该字段进行发货的判责；
//         */
//        private Date collectTime;
//
//        /**
//         * 最晚签收时间，日期，格式2019-04-12 16:00:00 到货订单会依据该字段进行到货的判责；
//         */
//        private Date signTime;
//
//        /**
//         * 相对到达时间，单位为天，0当日达，1次日达，2三日达，3四日达，4五日达
//         */
//        private Integer esTime;
//
//        /**
//         * 同步订单时标记pdd风控异常
//         */
//        private Integer riskExcep;
//
//        /**
//         * 智能审核的时候是否需要激活
//         */
//        private boolean needActive = true;
//    /**
//     * 二进制标志字段,从低位到高位依次表示
//     * 2^0 = 1. 已取消平台换地址异常（反审核时会取消该标记）
//     * 2^1 = 2. 地址已处理
//     * 2^2 = 4. 上传失败标记
//     * 2^3 = 8. 已取消单价异常标签
//     */
//    private Long v;
//
//    /**
//     * 理论运费
//     */
////        @Column(name = "theory_post_fee", type = Types.DOUBLE)
//    private Double theoryPostFee;
//    /**
//     * 如果该订单是合单后的主单，该字段记录该主单下隐藏的订单
//     */
//    private List<Trade> mergeList;


//    private Boolean needUploadTrade;
//
//    /**
//     * 是否需要上传整笔订单 tradeConfig.sysSourceSplitConsignUploadAll()=true 会使用
//     */
//    private boolean needUploadTradeAll;

//    /**
//     * 拆分的系统单触发整笔上传时候，对应的平台子订单 tradeConfig.sysSourceSplitConsignUploadAll()=true 会使用
//     */
//    private List<Order> uploadPlatSplitOrders;
//
//    private Map<OpEnum, String> operations = new LinkedHashMap<OpEnum, String>();
//    /**
//     * 所有的order都被上传过滤
//     */
//    private Boolean needPreUpload;
//
//    /**
//     * 是否使用截取的outerId去匹配
//     */
//    private Boolean useOuterIdMatch;
//
//    /**
//     * 记录原始订单的sid
//     */
//    private Long sourceSid;
//    /**
//     * 京东京品试订单标示
//     */
//    private String isJps;


//    /**
//     * 订单是否新增
//     */
//    private boolean insert;

//    /**
//     * pdd缺货处理
//     */
//    private Integer pddStockOut;
//
//    /**
//     * 扩展表
//     */
//        private TradeExt tradeExt;

//    /**
//     * 订单差额=系统实付金额-平台实收金额 区间值
//     * @return
//     */
//    private Double paymentDiff;





//    /**
//     * 匹配规则用，用逗号分开
//     */
//    private String  sellerFlagString;
//
//    /**
//     * 匹配规则用，用逗号分开
//     */
//    private String sellerMemoString;



//    private boolean fxSplit;
//    private String fxSource;
//    private Long guid;
//    private Integer tradeType;
//
//    private Long finalDestCompanyId;

//
//    /**
//     * 智能审核规则匹配结果
//     */
//    private Integer auditMatchRule;
//
//    /**
//     * 车型memo
//     */
//    private String carAttrMemo;
//
//    private String maskReceiverName;
//
//    private Boolean needCoverAddress = false;
//
//    /**
//     * 延迟返货时间
//     */
//    private Integer delayShipTime;





    @Override
    public String toString() {
        return "Trade{" +
                "userId=" + userId +
//                ", source='" + source + '\'' +
                ", sid=" + sid +
                ", tid='" + tid + '\'' +
                ", sysStatus='" + sysStatus + '\'' +
                ", stockStatus='" + stockStatus + '\'' +
                ", status='" + status + '\'' +
//                ", tagName=" + tagName +
//                ", tags=" + tags +
//                ", tagIds=" + tagIds +
//                ", sysMemo=" + sysMemo +
//                ", exceptIds=" + exceptIds +
                ", warehouseId=" + warehouseId +
                "} ";
    }





}
