package com.demo.seata.orderservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.seata.orderservice.entity.Order;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 订单操作接口
 * @date 2021/1/6 18:02
 * @see
 */
public interface OrderMapper extends BaseMapper<Order> {


    /**
     * @param order 订单
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 创建订单接口
     * @date 2021/1/6 18:05
     */
    void create(Order order);
}
