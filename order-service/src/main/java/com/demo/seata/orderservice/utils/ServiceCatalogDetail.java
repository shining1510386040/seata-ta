package com.demo.seata.orderservice.utils;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 服务具体的接口
 * @date 2021/1/7 11:08
 * @see
 */
public class ServiceCatalogDetail {
    // ================分布式id生成服务================start
    /**
     * 基于数据库生成分布式id
     */
    public static final String NEXT_ID_FORMDB = "/segment/ids/next_id";
    // ================分布式id生成服务================end
    // ================账户-支付服务================start
    /**
     * 账户扣款
     */
    public static final String ACCOUNT_DECREASE = "/account/decrease";
    // ================账户-支付服务================end
    // ================库存-仓储服务================start
    /**
     * 扣减库存
     */
    public static final String STORAGE_DECREASE = "/storage/decrease";
    // ================库存-仓储服务================end


    // .....
}
