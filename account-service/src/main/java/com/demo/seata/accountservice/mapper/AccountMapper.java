package com.demo.seata.accountservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.seata.accountservice.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 账户接口
 * @date 2021/1/6 16:20
 * @see
 */
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * @param userId 用户id
     * @param money  金额
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 扣减金额
     * @date 2021/1/6 16:25
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
