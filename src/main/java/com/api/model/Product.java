package com.api.model;

public class Product {

//import com.google.common.collect.Lists;
//import com.raycloud.dmj.domain.UserShopKit;
//import com.raycloud.dmj.domain.contants.ErrorResult;
//import com.raycloud.dmj.domain.item.params.ItemUpdateParams;
//import com.raycloud.dmj.domain.item.record.ItemCustomerBridge;
//import com.raycloud.dmj.domain.sku.DmjSku;
//import com.raycloud.dmj.domain.stock.FarERPStock;
//import com.raycloud.dmj.domain.stock.StockConstants;
//import com.raycloud.dmj.domain.supplier.ItemSupplier;
//import com.raycloud.dmj.domain.user.Shop;
//import com.raycloud.dmj.domain.utils.CommonConstants;
//import com.raycloud.dmj.domain.utils.DMJItemUtils;
//import com.raycloud.erp.db.model.Column;
//import com.raycloud.erp.db.model.Model;
//import com.raycloud.erp.db.model.Table;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import java.sql.Types;
//import java.util.*;

    /**
     * 大卖家商品库存类
     */
//    @Deprecated
//    @Table(name = "dmj_item", routerKey = "dmjItemDbNo")
//    public class DmjItem extends Model {
//
//        private static final long serialVersionUID = -3893058038407937016L;
//
//        public static final int copySource = 6; //从平台复制过来的系统商品
//
//
//        //错误信息
//        private List<ErrorResult> errorResultList;
//        private ErrorResult errorResult;
//        private List<ItemSalePriceBrige> itemSalePriceBrigeList;
//        protected List<Shop> shops = Lists.newArrayList();
//        private List<ShopSellerCat> shopSellerCats = new LinkedList<ShopSellerCat>();
//        private List<ItemSupplierBridge> itemSupplierBridgeList;
//        /**
//         * 商品中的SKU信息列表
//         */
//        private List<DmjSku> skuERP;
//        //  套件下的单品
//        private List<SuiteSingle> suiteSingleList;
//        private List<UserShopKit> userShopKit;
//        private List<FarERPStock> farERPStocks;

//        /**
//         * 根据最低进价选择最优供应商
//         */
//        private ItemSupplierBridge bestItemSupplierBridge;
//
//        /**
//         * 商品被其他模块占用的信息
//         */
//        private List<ItemUserOrderVo> itemUserOrderVoList;
//
//        private Long id;
//        private Integer DB;
//
//        /**
//         * 公司
//         */
//        @Column(name = "company_id", type = Types.BIGINT)
//        private Long companyId;
//
//        /**
//         * 简称
//         */
//        @Column(name = "short_title", type = Types.VARCHAR)
//        private String shortTitle;
//        /**
//         * 是否上架 0=仓库  1=出售中  4-系统新建
//         */
//        @Column(name = "on_sale", type = Types.INTEGER)
//        private Integer onSale;
////
////        /**
////         * 进货市场名称
////         */
////        @Column(name = "market", type = Types.VARCHAR)
////        private String market;
////
////        @Column(name = "cost_price", type = Types.DOUBLE)
////        private Double costPrice;
//
//        /**
//         * 重量，单位kg
//         */
//        @Column(name = "weight", type = Types.DOUBLE)
//        private Double weight;
//
//        /**
//         * 条形码
//         */
//        @Column(name = "barcode", type = Types.VARCHAR)
//        private String barcode;
//
//        /**
//         * 货位字段
//         */
//        @Column(name = "goods_allocation", type = Types.VARCHAR)
//        private String goodAllocation;
//
//        /**
//         * 创建时间
//         */
//        @Column(name = "created", type = Types.TIMESTAMP)
//        private Date created;
//
//        /**
//         * 更新时间
//         */
//        @Column(name = "modified", type = Types.TIMESTAMP)
//        private Date modified;
//
//        /**
//         * 商品图片URL
//         */
//        @Column(name = "pic_path", type = Types.VARCHAR)
//        private String picPath;
//
//        /**
//         * 数据的删除状态，0表示删除，1表示正常
//         */
//        @Column(name = "enable_status", type = Types.TINYINT)
//        private Integer enableStatus;
//        /**
//         * 数据的可用状态，0表示停用，1表示启用
//         */
//        @Column(name = "active_status", type = Types.TINYINT)
//        private Integer activeStatus;
//
//        /**
//         * 商品标题
//         */
//        @Column(name = "title", type = Types.VARCHAR)
//        private String title;
//        /**
//         * 品牌
//         */
//        @Column(name = "brand", type = Types.VARCHAR)
//        private String brand;
//        /**
//         * 商品状态
//         * 1:出售中 2：已下架 ，3：橱窗中 4：停用 5：系统本地 6:平台复制过来
//         * <p/>
//         * todo:xy.cao
//         * 现在只有 正常 和 停用 两种状态 上面的五种状态后续可能还是需要的。
//         * 故而这里约定值时在原先状态的基础上进行
//         * <p/>
//         * 这个值只是用于前端显示，需要通过onSale。activeStatus,等字段判断显示的优先级
//         * 5：系统本地 是在系统里新建的商品。其他状态是复制平台商品进入系统。
//         */
//        @Column(name = "status", type = Types.INTEGER)
//        private Integer status;
//
//        /**
//         * 商品的商家编码
//         */
//        @Column(name = "outer_id", type = Types.VARCHAR)
//        private String outerId;
//
//        /**
//         * 淘宝的商品库存
//         */
//        @Column(name = "num", type = Types.BIGINT)
//        private Long num;
//
//        /**
//         * 库存警戒值
//         */
//        @Column(name = "stock_alarm_num", type = Types.BIGINT)
//        private Long stockAlarmNum;
//
//        /**
//         * 包材预警值
//         */
//        private Long packmaAlarmNum;
//
//        /**
//         * 包材剩余数
//         */
//        private Long packmaSurplus;
//
//        /**
//         * 备注
//         */
//        @Column(name = "remark", type = Types.VARCHAR)
//        private String remark;
//
//        /**
//         * 商品类型
//         * 0-普通（含虚拟商品，用 isVirtual字段描述|组合装商品） 1-sku套件 2-纯套件 3-包材商品
//         */
//        @Column(name = "type", type = Types.VARCHAR)
//        private String type;
//
//        /**
//         * 基于type下的二级分类
//         * type=0 : 0-正常商品，1-sku加工商品，2-纯加工商品 3-含sku组合装商品 4-不含sku组合装商品
//         */
//        @Column(name = "type_tag", type = Types.TINYINT)
//        private Integer typeTag;
//
//        /**
//         * 商品类目
//         */
//        @Column(name = "cat_id", type = Types.VARCHAR)
//        private String catId;
//
//        /**
//         * 商品分类
//         * todo 这里关联的是 seller_cat 的cid，cid不是唯一的概率很小。有时间后面需要改造
//         */
//        @Column(name = "seller_cids", type = Types.VARCHAR)
//        private String sellerCids;
//        /**
//         * 品牌
//         */
//        @Column(name = "props_name", type = Types.VARCHAR)
//        private String propsName;
//
//        /**
//         * 单位
//         */
//        @Column(name = "unit", type = Types.VARCHAR)
//        private String unit;
//
//        /**
//         * 成本价
//         */
//        @Column(name = "purchase_price", type = Types.DOUBLE)
//        private Double priceImport;
//
//        /**
//         * 历史成本价
//         */
//        @Column(name = "history_price_import", type = Types.VARCHAR)
//        private String historyPriceImport;
//
//        /**
//         * 销售价
//         */
//        @Column(name = "selling_price", type = Types.DOUBLE)
//        private Double priceOutput;
//
//        /**
//         * 客户销售价
//         */
//        private boolean hasCustomerPrice;
//
//        /**
//         * 批发价
//         */
//        @Column(name = "wholesale_price", type = Types.DOUBLE)
//        private Double wholesalePrice;
//
//        /**
//         * 长
//         */
//        @Column(name = "x", type = Types.DOUBLE)
//        private Double x;
//        /**
//         * 宽
//         */
//        @Column(name = "y", type = Types.DOUBLE)
//        private Double y;
//        /**
//         * 高
//         */
//        @Column(name = "z", type = Types.DOUBLE)
//        private Double z;
//
//        /**
//         * 体积 长 * 宽 * 高
//         */
//        @Column(name = "volume", type = Types.DOUBLE)
//        private Double volume;
//        /**
//         * 是否自动计算 0-非自动计算 1-自动计算
//         */
//        @Column(name = "isSysVolume", type = Types.DOUBLE)
//        private Integer isSysVolume;
//
//        /**
//         * 消耗周期/保质期
//         */
//        @Column(name = "period_cast", type = Types.INTEGER)
//        private Integer periodCast;
//        /**
//         * 产地
//         */
//        @Column(name = "place", type = Types.VARCHAR)
//        private String place;
//        /**
//         * 年份
//         */
//        @Column(name = "age", type = Types.INTEGER)
//        private Integer age;
//        /**
//         * 生产日期
//         */
//        @Column(name = "production_date", type = Types.TIMESTAMP)
//        private Date productionDate;
//
//        /**
//         * 系统商品编码
//         */
//        @Column(name = "sys_item_id", type = Types.BIGINT, key = true)
//        private Long sysItemId;
//        /**
//         * 自定义1
//         */
//        @Column(name = "defined1", type = Types.VARCHAR)
//        private String defined1;
//        /**
//         * 自定义1 key
//         */
//        @Column(name = "defined1_key", type = Types.VARCHAR)
//        private String defined1Key;
//        /**
//         * 自定义2
//         */
//        @Column(name = "defined2", type = Types.VARCHAR)
//        private String defined2;
//        /**
//         * 自定义2 key
//         */
//        @Column(name = "defined2_key", type = Types.VARCHAR)
//        private String defined2Key;
//        /**
//         * 自定义3
//         */
//        @Column(name = "defined3", type = Types.VARCHAR)
//        private String defined3;
//        /**
//         * 自定义3 key
//         */
//        @Column(name = "defined3_key", type = Types.VARCHAR)
//        private String defined3Key;
//        /**
//         * 自定义4
//         */
//        @Column(name = "defined4", type = Types.VARCHAR)
//        private String defined4;
//        /**
//         * 自定义4 key
//         */
//        @Column(name = "defined4_key", type = Types.VARCHAR)
//        private String defined4Key;
//        /**
//         * 自定义5
//         */
//        @Column(name = "defined5", type = Types.VARCHAR)
//        private String defined5;
//        /**
//         * 自定义5 key
//         */
//        @Column(name = "defined5_key", type = Types.VARCHAR)
//        private String defined5Key;
//        /**
//         * 自定义6
//         */
//        @Column(name = "defined6", type = Types.VARCHAR)
//        private String defined6;
//        /**
//         * 自定义6 key
//         */
//        @Column(name = "defined6_key", type = Types.VARCHAR)
//        private String defined6Key;
//
//        /**
//         * 自定义属性。 上面那些自定义字段都不用了。 统一用这个字段
//         * 解析在dmjItemUtils.dealDefinedJson方法
//         */
//        @Column(name = "defined_json", type = Types.VARCHAR)
//        private String definedJson;
//
//        /**
//         * 规格属性json字段
//         */
//        @Column(name = "specification_json", type = Types.VARCHAR)
//        private String specificationJson;
//
//        /**
//         * 合并参数
//         */
//        @Column(name = "merge_type", type = Types.TINYINT)
//        private Integer mergeType;
//
//        /**
//         * 是否无库存 0：无库存 1：有库存
//         */
//        @Column(name = "has_inventory", type = Types.INTEGER)
//        private Integer hasInventory;
//        /**
//         * 是否超卖 0：未超卖 1：超卖
//         */
//        @Column(name = "over_sell", type = Types.INTEGER)
//        private Integer overSell;
//        /**
//         * 是否预警 0：警戒 1：警戒
//         */
//        @Column(name = "alarmed", type = Types.INTEGER)
//        private Integer alarmed;
//        /**
//         * 是否设置预警
//         */
//        @Column(name = "has_set_alarm", type = Types.INTEGER)
//        private Integer hasSetAlarm;
//        /**
//         * 是否未设置预警
//         */
//        @Column(name = "has_not_set_alarm", type = Types.INTEGER)
//        private Integer hasNotSetAlarm;
//        /**
//         * 库存状态是否正常：只要有个sku的库存状态是正常的。商品的库存正常状态就为1
//         */
//        @Column(name = "is_stock_normal", type = Types.TINYINT)
//        private Integer isStockNormal;
//
//        /**
//         * 是否是含有sku的商品，是：1，否：0
//         */
//        @Column(name = "is_sku_item", type = Types.INTEGER)
//        private Integer isSkuItem;
//
//        @Column(name = "brand_id", type = Types.BIGINT)
//        private Long brandId;
//
//        /**
//         * 货主
//         */
//        @Column(name = "shipper", type = Types.VARCHAR)
//        private String shipper;
//
//        /**
//         * 是否是虚拟商品，是：1，否：0
//         */
//        @Column(name = "is_virtual", type = Types.TINYINT)
//        private Integer isVirtual;
//
//        /**
//         * 是否关联供应商 是：1 否：0
//         */
//        @Column(name = "has_supplier", type = Types.INTEGER)
//        private Integer hasSupplier;
//
//        /**
//         * 记录是否是系统重量
//         * 0 非系统自动计算  1系统自动计算
//         */
//        @Column(name = "is_sys_weight", type = Types.TINYINT)
//        private Integer isSysWeight;
//        /**
//         * 记录是否系统计算成本价
//         * 0-否，1-是
//         */
//        @Column(name = "is_sys_purchase_price", type = Types.INTEGER)
//        private Integer isSysPriceImport;
//        /**
//         * 记录是否系统计算销售价
//         * 0-否，1-是
//         */
//        @Column(name = "is_sys_selling_price", type = Types.INTEGER)
//        private Integer isSysPriceOutput;
//
//        /**
//         * 记录是否系统计算批发价
//         * 0 -否 1- 是
//         */
//        @Column(name = "is_sys_wholesale_price", type = Types.INTEGER)
//        private Integer isSysWholesalePrice;
//
//        /**
//         * 是否开启批次设置  0-否 1-是
//         */
//        @Column(name = "has_batch", type = Types.INTEGER)
//        private Integer hasBatch;
//
//        /**
//         * 批次出库规则  1-先进先出 2-先进后出
//         * 默认：1
//         */
//        @Column(name = "batch_rule", type = Types.INTEGER)
//        private Integer batchRule;
//
//        /**
//         * 临保天数
//         */
//        @Column(name = "near_date", type = Types.INTEGER)
//        private Integer nearDate;
//        /**
//         * 加权成本价
//         */
//        @Column(name = "weight_avg_price", type = Types.DOUBLE)
//        private Double weightAvgPrice;
//        /**
//         * 中文报关名
//         */
//        @Column(name = "declare_name_zh", type = Types.VARCHAR)
//        private String declareNameZh;
//
//        /**
//         * 英文报关名
//         */
//        @Column(name = "declare_name_en", type = Types.VARCHAR)
//        private String declareNameEn;
//
//        /**
//         * 海关编码
//         */
//        @Column(name = "hs_code", type = Types.VARCHAR)
//        private String hsCode;
//
//        /**
//         * 申报金额
//         */
//        @Column(name = "declare_amount", type = Types.DOUBLE)
//        private Double declareAmount;
//        /**
//         * 申报重量
//         */
//        @Column(name = "declare_weight", type = Types.DOUBLE)
//        private Double declareWeight;
//
//        /**
//         * 成份
//         */
//        @Column(name = "component", type = Types.VARCHAR)
//        private String component;
//
//        /**
//         * 执行标准
//         */
//        @Column(name = "standard", type = Types.VARCHAR)
//        private String standard;
//
//        /**
//         * 记录
//         */
//        @Column(name = "record", type = Types.VARCHAR)
//        private String record;
//
//        /**
//         * 安全类别
//         */
//        @Column(name = "safekind", type = Types.VARCHAR)
//        private String safekind;
//
//        /**
//         * 开票名称
//         */
//        @Column(name = "invoice", type = Types.VARCHAR)
//        private String invoice;
//
//        /**
//         * 箱规
//         */
//        @Column(name = "boxnum", type = Types.INTEGER)
//        private Integer boxnum;
//
//        /**
//         * 是否标记为赠品
//         */
//        @Column(name = "make_gift", type = Types.SMALLINT)
//        private Boolean makeGift;
//
//        /**
//         * 单件拣选积分
//         */
//        private Double oneIntegral;
//        /**
//         * 多件拣选积分
//         */
//        private Double moreIntegral;
//        /**
//         * 单件包装积分
//         */
//        private Double onePackageIntegral;
//        /**
//         * 多件包装积分
//         */
//        private Double morePackageIntegral;
//        /**
//         * 单件拣货积分
//         */
//        private Double oneInspectionIntegral;
//        /**
//         * 多件拣货积分
//         */
//        private Double moreInspectionIntegral;
//
//        /**
//         * 单件称重积分
//         */
//        private Double oneWeightIntegral;
//
//        /**
//         * 多件称重积分
//         */
//        private Double moreWeightIntegral;
//
//        /**
//         * 大图
//         */
//        @Column(name = "big_pic", type = Types.VARCHAR)
//        private String bigPic;
//
//        /**
//         * 扩展字段值
//         */
//        @Column(name = "extend_field_values", type = Types.VARCHAR)
//        private String extendFieldValues;
//
//        /**
//         * 是否同步库存
//         */
//        @Column(name = "sync_stock", type = Types.TINYINT)
//        private Boolean syncStock;
//
//        /**
//         * 商品关联信息，存的是大Json字符串，以后有新加的关联信息都可以存在这个字段里，因为中间可能有很多字段，所以保存的时候注意不要影响其他信息了
//         *  供应商信息: "suppliers":[{"supplierId":123,"supplierName":"xxx","supplierItemOuterId":"xxx"},{...]  因为系统里之前只有纯商品和sku有供应商信息概念，现在需要给带sku的item也加上，存在该字段中
//         */
//        private String extendRelationInfo;
//
//        /*-------------分割线，以上为数据库字段，以下为附加字段-----------*/
//
//        /**
//         * 1-需要加载 0-不需要加载
//         */
//        private Integer needLoad;
//
//        // 库存数量
//        private Long availableInStock = 0L;
//
//        /**
//         * 次品数
//         */
//        private Long defectiveStock;
//
//        /**
//         * 虚拟库存
//         */
//        private Long virtualStock;
//
//        //可分配数
//        private Long allocatableNum = 0L;
//
//        /**
//         * 锁定库存
//         */
//        private Long lockStock = 0L;
//
//        /**
//         * 单件全部锁定数
//         */
//        private Long singleAllLockStock = 0L;
//
//        /**
//         * 多件全部锁定数
//         */
//        private Long multiAllLockStock = 0L;
//
//        /**
//         * 单件缺货锁定数
//         */
//        private Long singleOutOfLockStock = 0L;
//
//        /**
//         * 多件缺货锁定数
//         */
//        private Long multiOutOfLockStock = 0L;
//
//
//        private Long associateId;
//
//        private boolean suite;
//        /**
//         * 虚拟商品--for多匹配
//         * true 多匹配
//         */
//        private Boolean isMultiMatched;
//        /**
//         * 供应商名称组合，逗号分隔
//         * @return
//         */
//        private String supplierNames;
//        /**
//         * 采购链接
//         */
//        private String caigouUrl;
//        /**
//         * 加权开始时间
//         */
//
//        private Date weightAvgDate;
//
//        /**
//         * 是否移动加权用户 0-否，1-是
//         */
//        private Integer isWeightAvgPrice;
//
//        /**
//         * 仓库名称
//         */
//        private String warehouseName;
//        /**
//         * 档口
//         */
//        private String stall;
//
//        /**
//         * 额外字段，数据库没有。
//         * sku或者商品有未匹配时为0，否则为1
//         */
//        private Integer matched;
//        /**
//         * 高亮的字段信息
//         */
//        private Map<String, Object> highlights;
//
//        /**
//         * 商品客户销售价关系
//         */
//        List<ItemCustomerBridge> itemCustomerBridges;
//
//        /**
//         * 对应的平台id
//         */
//        private String platformId;
//
//        /**
//         * 商品用于修改的构建参数
//         */
//        private  ItemUpdateParams itemUpdateParams;
//        /**
//         * 分类名称
//         */
//        private String cidName;
//
//        /**
//         * 判断编码是否是中文 1-是，0-否
//         */
//        private Integer hasChineseInOuterId;
//
//        //比例值
//        private Integer ratio;
//
//        /**
//         *
//         * 数据库存储的catid
//         */
//        private String catId4DB;
//        private String definedJson4DB;
//        //去除所有空格后的SKU商家编码
//        private String outerIdPure;
//        private Integer hide ;
//
//        /**
//         * 是否已经填充了分销价
//         */
//        private boolean filledSalePrice;
//
//        /**
//         * 上架时间
//         */
//        private Date listTime;
//
//        private boolean endMatchCustomerSalePrice;
//
//        /**
//         * 订单付款时间
//         */
//        private Date payTime;
//        /*-------------分割线，以上为附加字段-----------*/
//
//
//
//        /**
//         * 创建人
//         */
//        private String creator;
//
//        /**
//         * 自定义字段解析类
//         */
//        public static class ItemDefined {
//            // 自定义名称
//            private String definedKey = "";
//            // 自定义描述
//            private String definedValue = "";
//
//        }

}
