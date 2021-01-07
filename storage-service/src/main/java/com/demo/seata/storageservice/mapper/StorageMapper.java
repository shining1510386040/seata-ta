package com.demo.seata.storageservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.seata.storageservice.entity.Storage;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2021/1/6 17:53
 * @see
 */
public interface StorageMapper extends BaseMapper<Storage> {

    /**
     * @param productId 商品id
     * @param count     数量
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 扣减库存
     * @date 2021/1/6 17:57
     */
    void decrease(Long productId, Integer count);

}
