package com.api.config;

import java.sql.Types;
import java.util.Date;

public class TradeStatus {

    //========================= 系统状态枚举 =======================//
    /**
     * 待打印快递单
     */
    public static String WAIT_EXPRESS_PRINT = "WAIT_EXPRESS_PRINT";
    /**
     * 审核完成
     */
    public static String FINISHED_AUDIT= "FINISHED_AUDIT";
    public static String SUCCESS = "true";
    /**
     * 待供销商发货
     */
    public static String WAIT_DEST_SEND_GOODS = "WAIT_DEST_SEND_GOODS";

    /**
     * ERP的订单领域，所有平台的业务领域

     *
     */


        private static final long serialVersionUID = -210827514234904523L;


        /**
         * 待付款
         */
        public static final String SYS_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";

        /**
         * 待审核
         */
        public static final String SYS_STATUS_WAIT_AUDIT = "WAIT_AUDIT";

        /**
         * 等待财审
         */
        public static final String SYS_STATUS_WAIT_FINANCE_AUDIT = "WAIT_FINANCE_AUDIT";

        /**
         * 等待人工审核，一般由系统的自动审核触发，如果订单在自动审核的过程中被拒绝了，那么状态将转变为人工审核
         */
        public static final String SYS_STATUS_WAIT_MANUAL_AUDIT = "WAIT_MANUAL_AUDIT";

        /**
         * 审核完成
         */
        public static final String SYS_STATUS_FINISHED_AUDIT = "FINISHED_AUDIT";

        /**
         * 待打印快递单，这个状态和FINISHED_AUDIT一样，这个状态在视图上进行转变
         */
        public static final String SYS_STATUS_WAIT_EXPRESS_PRINT = "WAIT_EXPRESS_PRINT";

        /**
         * 待打印发货单，这个状态和FINISHED_AUDIT一样，这个状态在视图上进行转变
         */
        public static final String SYS_STATUS_WAIT_DELIVERY_PRINT = "WAIT_DELIVERY_PRINT";

        /**
         * 待打包，这个状态和FINISHED_AUDIT一样，这个状态在视图上进行转变
         */
        public static final String SYS_STATUS_WAIT_PACKAGE = "WAIT_PACKAGE";

        /**
         * 待称重，这个状态和FINISHED_AUDIT一样，这个状态在视图上进行转变
         */
        public static final String SYS_STATUS_WAIT_WEIGHT = "WAIT_WEIGHT";

        /**
         * 待发货，这个状态和FINISHED_AUDIT一样，这个状态在视图上进行转变
         */
        public static final String SYS_STATUS_WAIT_SEND_GOODS = "WAIT_SEND_GOODS";

        /**
         * 待供销商发货，这个状态和FINISHED_AUDIT一样，这个状态在视图上进行转变
         */
        public static final String SYS_STATUS_WAIT_DEST_SEND_GOODS = "WAIT_DEST_SEND_GOODS";

        /**
         * 卖家已发货
         */
        public static final String SYS_STATUS_SELLER_SEND_GOODS = "SELLER_SEND_GOODS";

        /**
         * 交易完成
         */
        public static final String SYS_STATUS_FINISHED = "FINISHED";

        /**
         * 交易关闭
         */
        public static final String SYS_STATUS_CLOSED = "CLOSED";

        /**
         * 交易作废
         */
        public static final String SYS_STATUS_CANCEL = "CANCEL";

        //========================= 库存状态枚举 =======================//
        /**
         * 库存空值，未进行过匹配操作
         *
         */
//        public static final String STOCK_STATUS_EMPTY = StockStatusEnum.STOCK_STATUS_EMPTY.stockStatus;

        /**
         * 库存正常
         */
//        public static final String STOCK_STATUS_NORMAL = StockStatusEnum.STOCK_STATUS_NORMAL.stockStatus;

        /**
         * 商品未分配
         */
//        public static final String STOCK_STATUS_UNALLOCATED = StockStatusEnum.STOCK_STATUS_UNALLOCATED.stockStatus;

        /**
         * 库存不足
         */
//        public static final String STOCK_STATUS_INSUFFICIENT = StockStatusEnum.STOCK_STATUS_INSUFFICIENT.stockStatus;

        /**
         * 商品对应关系修改
         */
//        public static final String STOCK_STATUS_RELATION_MODIFIED = StockStatusEnum.STOCK_STATUS_RELATION_MODIFIED.stockStatus;

        /**
         * 库存不足
         */
//        public static final String STOCK_STATUS_EXCEP = StockStatusEnum.STOCK_STATUS_EXCEP.stockStatus;



}
