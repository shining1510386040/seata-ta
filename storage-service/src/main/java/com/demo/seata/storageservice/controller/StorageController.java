package com.demo.seata.storageservice.controller;

import com.demo.seata.storageservice.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2021/1/6 17:58
 * @see
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageMapper storageMapper;

    @GetMapping("/decrease")
    public String decrease(Long productId, Integer count) throws Exception {
        storageMapper.decrease(productId, count);
        return "减少商品库存成功";
    }
}
