package com.api.model;

import lombok.Data;

///**
// * ERP的子订单领域，所有平台的业务领域都应该要继承这个类
// */
@Data
public class SonTrade {
        /**
         * 用例编号
         */
        private int id;
        /**
         * 用例描述
         */
        private String description;
        /**
         * 匹配到的系统商品ID
         */
//        @Column(name = "item_sys_id", type = Types.BIGINT)
        private Long itemSysId;
        /**
         * 匹配到的系统规格ID
         */
//        @Column(name = "sku_sys_id", type = Types.BIGINT)
        private Long skuSysId;
        /**
         * 商家编码，不做持久化，仅仅只是为了系统订单添加商品使用
         */
        private String outerId;
        /**
         * outer_sku_id
         */
        private String outerSkuId;
        /**
         * 商品销售价
         */
        private String price;
        /**
         * 应付金额, 公式: 应付金额 = 商品数量 * 商品单价 + 手工调整价
         */
        private String totalFee;
        /**
         * 商品标题
         */
        private String title;
        /**
         * 实付金额, 公式: 实付金额 = 应付金额 - 优惠金额
         */
        private String payment;
        /**
         * 优惠金额
         */
        private String discountFee;
        /**
         * 是否虚拟商品，虚拟商品不需要申请库存，发货时也不需要消费库存、归还库存
         */
//        @Column(name = "is_virtual", type = Types.TINYINT)
        private Integer isVirtual;
        /**
         * 子订单商品数量
         */
//        @Column(name = "num", type = Types.INTEGER)
        private Integer num;
        /**
         * 规格属性名
         */
        private String skuPropertiesName;
        /**
         * 折扣率
         */
        private Double discountRate;
        /**
         * 自定义赠品类型，暂定0 原有逻辑，1手工新增赠品
         */
        private int customGiftType;
        /**
         * 分销金额
         */
        private String saleFee;
        /**
         * 分销价格
         */
        private String salePrice;
//
//
//
//    private static final long serialVersionUID = -5237783229703216767L;
//
//        public static final String REFUND_WAIT_SELLER_AGREE = "WAIT_SELLER_AGREE";//待卖家同意退款
//
//        public static final String REFUND_WAIT_BUYER_RETURN_GOODS = "WAIT_BUYER_RETURN_GOODS";//待买家退货
//
//        public static final String REFUND_WAIT_SELLER_CONFIRM_GOODS = "WAIT_SELLER_CONFIRM_GOODS";//待卖家确认收货
//
//        public static final String REFUND_SELLER_REFUSE_BUYER = "SELLER_REFUSE_BUYER";//卖家同意退款
//
//        public static final String REFUND_CLOSED = "CLOSED";//退款关闭
//
//        public static final String REFUND_SUCCESS = "SUCCESS";//退款成功
//
//        public static final String NO_REFUND = "NO_REFUND";//未退款
//
//        /**
//         * 这个是系统的一个退款状态，当平台订单的状态为待发货时，买家申请了退款，卖家是不能直接拒绝退款，只能强制发货，所以这个时候需要把退款状态设置为这个状态
//         */
//        public static final String REFUND_SELLER_CONTINUE_CONSIGN = "SELLER_CONTINUE_CONSIGN";
//
//        public final static int TypeOfNormal = 0;
//        public final static int TypeOfGiftOrder = 1;
//        public final static int TypeOfCombineOrder = 2;
//        public final static int TypeOfGroupOrder = 3;//组合装商品
//        public final static int TypeOfProcessOrder = 4;//加工商品
//
//        //商品停用
//        public final static int ITEM_SHUTOFF = 1 << 4;
//        /**
//         * 子订单系统编号
//         */
//       @Column(name = "id", type = Types.BIGINT, key = true)//@Column标记表示所持久化属性所映射表中的字段
//        private Long id;
//
//        /**
//         * 订单所属店铺用户ID
//         */
//        private Long userId;
//        /**
//         * 所属主订单的系统编号
//         */
//        @Column(name = "sid", type = Types.BIGINT)
//        private Long sid;
//        /**
//         * 原先属于哪个订单
//         */
//        private Long sourceSid;
//
//        /**
//         * 公司编号
//         */
//        @Column(name = "company_id", type = Types.BIGINT)
//        private Long companyId;
//        /**
//         * 订单来源 tb,tm,jd,sys
//         */
//        @Column(name = "source", type = Types.VARCHAR)
//        private String source;
//
//        /**
//         * 是否为预售订单 0:正常订单，1：是预售；2预售转正常；3：系统预售
//         */
//        @Column(name = "is_presell", type = Types.TINYINT)
//        private Integer isPresell;
//        /**
//         * 商品简称
//         */
//        @Column(name = "short_title", type = Types.VARCHAR)
//        private String shortTitle;
//        /**
//         * 0 已删除 1正常
//         */
//        @Column(name = "enable_status", type = Types.TINYINT)
//        private Integer enableStatus = 1;
//        /**
//         * 订单系统状态
//         */
//        @Column(name = "sys_status", type = Types.VARCHAR)
//        private String sysStatus;
//        /**
//         * 旧的系统状态，不做持久化，一般用于订单同步更新时的比较
//         */
//        private String oldSysStatus;
//
//        /**
//         * 是否取消库存缺货异常（INSUFFICIENT,EMPTY,EXCEP）：0 否，1 是
//         */
//        @Column(name = "insufficient_canceled", type = Types.TINYINT)
//        private Integer insufficientCanceled;
//        /**
//         * 商品对应关系是否改动: 0 否，1 是
//         */
//        @Column(name = "relation_changed", type = Types.TINYINT)
//        private Integer relationChanged;
//        /**
//         * 当前子订单的库存状态,如库存正常(NORMAL),库存不足(INSUFFICIENT)
//         */
//        @Column(name = "stock_status", type = Types.VARCHAR)
//        private String stockStatus;
//
//        /**
//         * 之前子订单的库存状态,如库存正常(NORMAL),库存不足(INSUFFICIENT)
//         */
//        private String oldStockStatus;
//
//        private Date oldPtConsignTime;
//
//        public Date getOldPtConsignTime() {
//            return oldPtConsignTime;
//        }
//
//        public void setOldPtConsignTime(Date oldPtConsignTime) {
//            this.oldPtConsignTime = oldPtConsignTime;
//        }
//
//        /**
//         * 分配的库存数量
//         */
//        @Column(name = "stock_num", type = Types.INTEGER)
//        private Integer stockNum;
//        /**
//         * 在作库存操作之前的库存分配数
//         */
//        private Integer oldStockNum;
//
//        /**
//         * 缺货数量=num-stockNum（不需要持久化）
//         */
//        private Integer diffStockNum;
//

//        /**
//         * 修改套件明细前系统商品ID
//         */
//        private Long oldItemSysId;
//        /**
//         * 修改套件明细前系统规格ID
//         */
//        private Long oldSkuSysId;
//        /**
//         * 修改套件明细前商家编码
//         */
//        private String oldSysOuterId;
//        /**
//         * outer_iid
//         */
//        @Column(name = "outer_iid", type = Types.VARCHAR)
//        private String outerIid;

//
//        /**
//         * 系统主商家编码，暂不做持久化
//         */
//        private String sysItemOuterId;
//

//        /**
//         * 商品成本价 cost*num 该商品总成本价
//         */
//        @Column(name = "cost", type = Types.DOUBLE)
//        private Double cost;

//
//        /**
//         * 原商品销售价，在套件转单品去匹配赠品时候使用
//         */
//        private String oldPrice;
//
//        /**
//         * 系统商品数量单位
//         */
//        @Column(name = "unit", type = Types.VARCHAR)
//        private String unit;
//        /**
//         * 系统规格计量单位
//         */
//        @Column(name = "sku_unit", type = Types.VARCHAR)
//        private String skuUnit;

//        /**
//         * 更新之前的商品数量，不做持久化，用于订单调整商品数量的业务
//         */
//        private Integer oldNum;


//        /**
//         * 子订单退款状态
//         */
//        @Column(name = "refund_status", type = Types.VARCHAR)
//        private String refundStatus;
//        private String oldRefundStatus;
//        /**
//         * 下单时间
//         */
//        @Column(name = "created", type = Types.TIMESTAMP)
//        private Date created;
//        /**
//         * 子订单平台的修改时间
//         */
//        @Column(name = "modified", type = Types.TIMESTAMP)
//        private Date modified;
//        /**
//         * 平台退款编号
//         */
//        @Column(name = "refund_id", type = Types.VARCHAR)
//        private String refundId;
//        /**
//         * 子订单平台状态
//         */
//        @Column(name = "status", type = Types.VARCHAR)
//        private String status;
//        /**
//         * 子订单旧的平台状态，不做持久化，一般用于订单同步更新时的判断比较
//         */
//        private String oldStatus;
//
//        /**
//         * 子订单中单个商品净重
//         */
//        @Column(name = "net_weight", type = Types.DOUBLE)
//        private Double netWeight;
//        /**
//         * 单个商品体积
//         */
//        @Column(name = "volume", type = Types.DOUBLE)
//        private Double volume;
//        /**
//         * 平台商品图片链接
//         */
//        @Column(name = "pic_path", type = Types.VARCHAR)
//        private String picPath;
//        /**
//         * 系统商品图片链接
//         */
//        @Column(name = "sys_pic_path", type = Types.VARCHAR)
//        private String sysPicPath;
//        /**
//         * 子订单的交易结束时间
//         */
//        @Column(name = "end_time", type = Types.TIMESTAMP)
//        private Date endTime;
//        /**
//         * 子订单发货时间
//         */
//        @Column(name = "consign_time", type = Types.TIMESTAMP)
//        private Date consignTime;
//
//        /**
//         * 平台发货时间
//         */
//        @Column(name = "pt_consign_time", type = Types.TIMESTAMP)
//        private Date ptConsignTime;
//
//        /**
//         * 是否在系统发货 1 是，0 否
//         */
//        @Column(name = "sys_consigned", type = Types.TINYINT)
//        private Integer sysConsigned;

//
//        private Double paymentDouble;
//
//        /**
//         * 不变的实付金额, 进来后不变
//         */
//        @Column(name = "ac_payment", type = Types.VARCHAR)
//        private String acPayment;
//
//
//

//        /**
//         * 子订单平台编号(淘宝有,京东没有)
//         */
//        @Column(name = "oid", type = Types.BIGINT)
//        private Long oid;
//
//        /**
//         * 包裹，抖音特有
//         */
//        private Parcel parcel;
//


//        /**
//         * 手工调整金额
//         */
//        @Column(name = "adjust_fee", type = Types.VARCHAR)
//        private String adjustFee;
//        /**
//         * 订单店铺的平台ID
//         */
//        @Column(name = "taobao_id", type = Types.BIGINT)
//        private Long taobaoId;
//        /**
//         * 所属订单的平台编号
//         */
//        @Column(name = "tid", type = Types.VARCHAR)
//        private String tid;
//        /**
//         * 付款时间
//         */
//        @Column(name = "pay_time", type = Types.TIMESTAMP)
//        private Date payTime;
//        /**
//         * 数据更新时间
//         */
//        @Column(name = "upd_time", type = Types.TIMESTAMP)
//        private Date updTime;
//
//        /**
//         * 平台商品数字编号
//         */
//        @Column(name = "num_iid", type = Types.VARCHAR)
//        private String numIid;
//        /**
//         * 平台规格编号
//         */
//        @Column(name = "sku_id", type = Types.VARCHAR)
//        private String skuId;
//        /**
//         * 是否为拍下减库存还是付款减库存，1表示付款减库存，0表示拍下减库存, 目前只用于淘宝
//         */
//        @Column(name = "sub_stock", type = Types.TINYINT)
//        private Integer subStock;
//        /**
//         * 系统商家编码，如果是商品则为商品的商家编码，如果为SKU则为SKU的商家编码
//         */
//        @Column(name = "sys_outer_id", type = Types.VARCHAR)
//        private String sysOuterId;
//
//        /**
//         * 系统SKU的规格属性名称
//         */
//        @Column(name = "sys_sku_properties_name", type = Types.VARCHAR)
//        private String sysSkuPropertiesName;
//        /**
//         * 系统SKU规格属性别名
//         */
//        @Column(name = "sys_sku_properties_alias", type = Types.VARCHAR)
//        private String sysSkuPropertiesAlias;
//        /**
//         * 系统规商品备注
//         */
//        @Column(name = "sys_item_remark", type = Types.VARCHAR)
//        private String sysItemRemark;
//        /**
//         * 系统规格备注
//         */
//        @Column(name = "sys_sku_remark", type = Types.VARCHAR)
//        private String sysSkuRemark;
//        /**
//         * 系统商品的标题
//         */
//        @Column(name = "sys_title", type = Types.VARCHAR)
//        private String sysTitle;
//        /**
//         * 系统商品类目ID,以逗号分隔
//         */
//        @Column(name = "cids", type = Types.VARCHAR)
//        private String cids;
//        /**
//         * 用于订单同步时记录平台商品(规格)是否变更过 0:未变 1：有变
//         */
//        @Column(name = "item_changed", type = Types.TINYINT)
//        private Integer itemChanged;
//        /**
//         * 标志系统商品是否更换过
//         */
//        @Column(name = "sys_item_changed", type = Types.TINYINT)
//        private Integer sysItemChanged;
//
//        /**
//         * 如果是套件单品,则该字段的值为其所属的套件子订单的id,否则为0
//         */
//        @Column(name = "combine_id", type = Types.BIGINT)
//        private Long combineId;
//
//        /**
//         * 赠品的order数量
//         */
//        @Column(name = "gift_num", type = Types.INTEGER)
//        private Integer giftNum;
//        /**
//         * 强制验货数量
//         */
//        @Column(name = "force_pack_num", type = Types.BIGINT)
//        private Integer forcePackNum;
//
//        /**
//         * 0 普通商品
//         * 1 赠品 是否是赠品不能根据type来判断，而要根据giftNum>0 来判断
//         * 2 套件商品
//         * 3 组合商品
//         * 4 加工商品
//         *
//         */
//        @Column(name = "type", type = Types.INTEGER)
//        private Integer type;
//
//        /**
//         * 3: 按sku拆分
//         * 4：按数量拆分
//         */
//        private Integer splitType;
//
//        /**
//         * <p>
//         * 目前使用场景(以后可继续增加):
//         * 1. 订单修改时判断该子订单(商品)是否可修改
//         * 2. 订单同步时判断该子订单(商品)是否可修改
//         * 3. 订单发货时判断该子订单(商品)是否需要消费库存
//         * true 可修改, false 不可修改, 默认值为true
//         * </p>
//         */
//        private boolean operable = true;
//
//        /**
//         * 覆盖模式下已上传订单不覆盖状态,但平台部分退款成功，得把相应子订单关闭
//         */
//        private boolean canBeUpdated = true;
//        /**
//         * 子订单商品库存操作时的仓库ID,要保证与所属trade中的warehouseId一致
//         */
//        private Long warehouseId;
//
//        /**
//         * 换仓库之前的仓库ID,不做持久化
//         */
//        private Long oldWarehouseId;
//
//        /**
//         * 识别码
//         */
//        @Column(name = "ident_code", type = Types.VARCHAR)
//        private String identCode;
//        /**
//         * 非首次订单同步时,平台子订单所对应的系统中已存在的平台子订单
//         */
//        private Order origin;
//
//        /**
//         * 对应的平台订单
//         */
//        private Order platformOrder;
//
//        /**
//         * 套件商品下的单品集合,只针对套件而言
//         */
//        private List<Order> suits;
//        /**
//         * 匹配系统商品时设置的标志
//         * <p>
//         * 0.默认值
//         * 1.一个子订单在匹配系统商品时若匹配到了套件,则flag设为1,新产生的所有单品子订单flag也设为1
//         * 2.系统换商品时,若换成套件,则当前子订单及新产生的套件子订单flag设为1
//         * 3.系统新增或修改订单,添加的商品若是套件,则该子订单及其下的套件子订单的flag设为1
//         * 其它: 临时定义
//         * </p>
//         */
//        private int flag;
//
//        /**
//         * 使用分销的status覆盖供销的status，默认用sys_status覆盖status
//         */
//        private boolean coverGxWithFxStatus;
//
//        private List<SplitUploadRecord> splitUploadRecords;
//
//        private SplitUploadRecord insertSplitUploadRecord;
//
//        private Order needUploadOrder;
//
//        /**
//         * 批量修改商品数量
//         */
//        private Integer batchChangeNum;
//

//
//        /**
//         * 子订单平台编号（由于某些平台的子订单号为字符类型，需要用此字段保存，后续可将oid修改为String类型）
//         */
//        @Column(name = "soid", type = Types.VARCHAR)
//        private String soid;

//
//        /**
//         * 混合拆分的时候，记录前端传过来的拆分数量，不做持久化
//         */
//        private Integer splitNum;
//        /**
//         * 是否作废，未发货的子订单与所属的trade保持一致
//         */
//        @Column(name = "is_cancel", type = Types.TINYINT)
//        private Integer isCancel;
//
//        /**
//         * 预计发货时间
//         */
//        @Column(name = "estimate_con_time", type = Types.TIMESTAMP)
//        private Date estimateConTime;
//

//
//        /**
//         * 合单对应的主单，不做持久化
//         */
//        private Long mergeSid;
//
//        /**
//         * 该order属于真实的系统id
//         */
//        private Long belongSid;
//

////
////        /**
////         * 刷单，取trade中，不持久化
////         */
////        private Integer scalping;
////
////        /**
////         * 当子订单是赠品的时候（giftNum>0），判断赠品是否参与拣选
////         * 增加（是否参与验货）属性判断
////         * 0：不拣选不验货；1：拣选不验货；2：拣选验货；3：验货不拣选
////         */
////        private Integer isPick;
////
////        /**
////         * 条形码
////         */
////        private String barcode;
////
////        /**
////         * 对应的播种信息
////         */
////        private WaveSortingDetail waveSortingDetail;
////
////        /**
////         * 子订单异常信息
////         */
////        private Set<String> exceptions;
////
////        /**
////         * 批量修改商品时保存平台商家编码
////         */
////        private String platformOuterId;
////
////        /**
////         * 新增的order
////         */
////        private boolean insert;
////
////
////        private String goodsSectionNumStr;
////
////        /**
////         * 是否保持之前的缺货库存状态，在开启后置锁定时候使用
////         */
////        private boolean keepInsufficientStockStatus = false;
////        /**
////         * 订单转化类型 0表示正常订单，1表示分销系统
////         */
////        @Column(name = "convert_type", type = Types.INTEGER)
////        private Integer convertType;
////
////        /**
////         * 1、订单来源于哪里 分销系统里记为分销商id（companyId）order不一定需要
////         * 2、按数量拆分，从哪个子订单中拆分出去的 不持久化到数据库
////         */
////        private Long sourceId;
////
////        /**
////         * 从哪个套件拆分出来的
////         */
////        private Long fromOriginSuitSelfId;
////
////        /**
////         * 品牌（不持久化）
////         */
////        private List<Long> brandIds;
////        /**
////         * 供应商（不持久化）
////         */
////        private List<Long> supplierIds;
////
////        private String mainOuterId;
////
////        private String FxSoid;
////
////        /**
////         * 关联的唯一码，不持久化
////         */
////        private List<String> uniqueCodes;
////
////        /**
////         * 是否使用截取的outerId去匹配
////         */
////        private Boolean useOuterIdMatch;

//
//        /**
//         * 订单归属于哪里 分销系统里记为供销商id（companyId）
//         */
//        @Column(name = "dest_id", type = Types.BIGINT)
//        private Long destId;
//
//        /**
//         * 订单属于soure or dest ,0表示正常订单，1表示source，2表示dest
//         */
//        @Column(name = "belong_type", type = Types.INTEGER)
//        private Integer belongType;
//        /**
//         * 是否是取消分销属性触发的订单同步，如果是1，则不需要匹配供应商，因为是取消分销属性
//         */
//        private Integer isCancelDistributorAttribute;
//
//
//
////        /**
////         * 二进制标志位，从低位到高位依次表示
////         * 2^0 已取消换商品异常（反审核时会取消该标记）
////         */
////        private Long v;
////        /**
////         * 记录在业务中改order做了那些操作
////         */
////        private Map<OpEnum, String> operations = new HashMap<>();
////
////        /**
////         * 平台实付(平台分摊之后的实付金额) http://doc.raycloud.com/pages/viewpage.action?pageId=30544685
////         */
////        private String divideOrderFee;
////
////        /**
////         * 前N有礼活动id
////         */
////        private String osActivityId;
////
////        /**
////         * 前N有礼赠品id
////         */
////        private String osFgItemId;
////
////        /**
////         * 前N有礼赠品数量
////         */
////        private String osGiftCount;
////
////        /**
////         * 前N有礼中奖名次，获得奖品的订单才会有该字段
////         */
////        private String osSortNum;
////
////        /**
////         * 是否需要上传发货信息，非持久化
////         */
////        private boolean needUploadConsign;
////
////        /**
////         * 是否系统触发过上传发货
////         */
////        private boolean sysTriggerUpload;
////        /**
////         * 新的不需要落库的属性可以加到这里面，防止类爆炸
////         */
//        private OrderExt orderExt;
//
//        /**
//         * 销货单备注信息（批发收银，无需落库）
//         */
//        private String saleRemark;
//
//
//
//        /**
//         * 商品状态
//         */
//        private Integer itemActiveStatus;
//
//        /**
//         * 供应商分类 不持久化
//         */
//        private List<Supplier> supplierList = new ArrayList<>();
//
//
//        /**
//         * 可用库存，非持久化
//         */
//        private long availableStock;
//
//        /**
//         * 是否是预售订单
//         *
//         * @return
//         */
//        public boolean isPresellOrder() {
//            if (this.isPresell != null && (this.getIsPresell() == 1 || this.getIsPresell() == 3)) {
//                return true;
//            }
//            return false;
//        }
//
//        /**
//         * 预售订单转正常订单
//         * @return
//         */
//        public Boolean presell2Normal(){
//            if (Objects.nonNull(getIsPresell()) && 2 - getIsPresell() == 0) {
//                return true;
//            }
//            return false;
//        }
//
//        /**
//         * 判断子订单是否可编辑修改
//         *
//         * @return
//         */
//        public boolean canUpdate() {
//            if (TradeStatusUtils.getSysStatusWeight(sysStatus) > TradeConstants.WEIGHT_WAIT_AUDIT) {
//                return false;
//            }
//            return isOperable();
//        }
//
//        /**
//         * 判断一个子订单是否为套件子订单下的单品或套件子订单本身,套件子订单及其下面的单品type=2,但单品的enableStatus=2
//         *
//         * @param single true 判断是否为单品, false 判断是否为套件子订单本身
//         * @return
//         */
//        public boolean isSuit(boolean single) {
//            int orderType = getType() == null ? 0 : getType();
//            long combineId = getCombineId() == null ? 0 : getCombineId();
//            return orderType == TypeOfCombineOrder && (single ? combineId > 0 : combineId == 0);
//        }
//
//        /**
//         * 判断一个子订单是否为套件
//         *
//         * @return
//         */
//        public boolean isSuit() {
//            return getType() != null && getType() == TypeOfCombineOrder;
//        }
//
//        /**
//         * 是否组合
//         */
//        public boolean isGroup(){
//            return getType() == null ? false : getType() == TypeOfGroupOrder;
//        }
//
//        /**
//         * 是否加工
//         */
//        public boolean isProcess(){
//            return getType() == null ? false : getType() == TypeOfProcessOrder;
//        }
//
//        /**
//         * 判断一个套件是单品还是套件本身
//         *
//         * @return
//         */
//
//        public boolean isSuitSingle() {
//            return getType() != null && getType() == TypeOfCombineOrder && getCombineId() != null && getCombineId() > 0;
//        }
//
//        public boolean isVirtual() {
//            return getIsVirtual() != null && getIsVirtual() - 1 == 0;
//        }
//
//
//        public Long getV() {
//            return v;
//        }
//
//        public void setV(Long v) {
//            this.v = v;
//        }
//
//        public boolean addV(int v) {
//            if (this.v != null) {
//                if ((this.v | v) != this.v) {
//                    this.v |= v;
//                    return true;
//                }
//                return false;
//            }
//            this.v = (long) v;
//            return true;
//        }
//
//        public boolean removeV(int v) {
//            if (this.v != null && (this.v | v) - this.v == 0) {
//                this.v = this.v - v;
//                return true;
//            }
//            return false;
//        }
//
//        public boolean isItemChangeCancelled() {
//            return v != null && (v | 1) - v == 0;
//        }
//
//        public boolean isSuiteChanged() {
//            return v != null && (v | (1 << 3)) - v == 0;
//        }
//
//        public Map<OpEnum, String> getOperations() {
//            return operations;
//        }
//
//
//
//        /**
//         * 赠品是否参与拣选
//         * @return
//         */
//        public boolean needPicking(){
//            if (this.giftNum != null && this.giftNum > 0){
//                if (this.isPick != null && (this.isPick == 1 || this.isPick == 2)){
//                    return true;
//                }
//            } else {
//                return false;
//            }
//            return false;
//        }
//
//        /**
//         * 赠品是否参与验货
//         * @return
//         */
//        public boolean needVerify(){
//            if (this.giftNum != null && this.giftNum > 0){
//                if (this.isPick != null && (this.isPick == 2 || this.isPick == 3)){
//                    return true;
//                }
//            } else {
//                return false;
//            }
//            return false;
//        }
//
//
//
//        /**
//         * 是否是平台纯商品
//         * @return
//         */
//        public boolean isPfPureItem(){
//            if(StringUtils.isEmpty(this.skuId) && StringUtils.isNotEmpty(this.numIid)){
//                return true;
//            }
//
//            return false;
//        }
//
//
//        /**
//         * @return 是否平台预售
//         */
//        public boolean isPlatformPresell() {
//            return Objects.nonNull(getIsPresell()) && getIsPresell() - 4 == 0;
//        }

}
