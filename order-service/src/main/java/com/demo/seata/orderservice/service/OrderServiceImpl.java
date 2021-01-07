package com.demo.seata.orderservice.service;

import com.demo.seata.orderservice.entity.Order;
import com.demo.seata.orderservice.mapper.OrderMapper;
import com.demo.seata.orderservice.utils.ServiceCatalog;
import com.demo.seata.orderservice.utils.ServiceCatalogDetail;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2021/1/6 18:07
 * @see
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;


    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 下单，开启全局事务
     * @date 2021/1/7 14:05
     */
    @GlobalTransactional
    public void create(Order order) {

        logger.error("开启全局事务，事务id：" + RootContext.getXID());

        Map<String, String> parms = new HashMap<String, String>(3);
        parms.put("businessType", "order_business");
        Long orderId = restTemplate.getForObject(ServiceCatalog.ID_GENERATOR_SERVICE + ServiceCatalogDetail
                .NEXT_ID_FORMDB, Long.class, parms);
        order.setId(orderId);
        orderMapper.create(order);

        // 扣减库存
        Map paramStorage = new HashMap(6);
        paramStorage.put("productId", order.getProductId());
        paramStorage.put("count", order.getCount());
        String storageRet = restTemplate.getForObject(ServiceCatalog.STORAGE_SERVICE + ServiceCatalogDetail.STORAGE_DECREASE, String.class, paramStorage);
        // 修改账户余额

        Map<String, Object> paramAccount = new HashMap<String, Object>(5);
        paramAccount.put("userId", order.getUserId());
        paramAccount.put("money", order.getMoney());
        String accountRet = restTemplate.getForObject(ServiceCatalog.ACCOUNT_SERVICE + ServiceCatalogDetail.ACCOUNT_DECREASE, String.class, paramAccount);

    }
}
