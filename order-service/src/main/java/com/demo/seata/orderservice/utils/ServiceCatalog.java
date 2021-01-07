package com.demo.seata.orderservice.utils;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 远程服务列表的目录类
 * @date 2021/1/7 11:08
 * @see
 */
public class ServiceCatalog {

    /**
     * 分布式id生成服务
     */
    public static final String ID_GENERATOR_SERVICE = "http://localhost:9090";
    /**
     * 仓储服务
     */
    public static final String STORAGE_SERVICE = "";
    /**
     * 账户-支付扣款服务
     */
    public static final String ACCOUNT_SERVICE = "";

    // .....
}
