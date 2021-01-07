package com.demo.seata.orderservice.controller;

import com.demo.seata.orderservice.entity.Order;
import com.demo.seata.orderservice.mapper.OrderMapper;
import com.demo.seata.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2021/1/6 18:03
 * @see
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 创建订单；下单
     * 访问路径：
     * http://localhost:8083/create?userId=1&productId=1&count=10&money=100
     * @date 2021/1/7 12:13
     */
    @GetMapping("/create")
    public String create(Order order) {
        orderService.create(order);
        return "创建订单成功";
    }
}
