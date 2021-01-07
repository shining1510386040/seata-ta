package com.demo.seata.orderservice.service;

import com.demo.seata.orderservice.entity.Order;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 订单接口
 * @date 2021/1/6 18:06
 * @see
 */
public interface OrderService {

    void create(Order order);
}
