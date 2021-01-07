package com.demo.seata.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 账户实体类
 * @date 2021/1/6 16:21
 * @see
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    // 主键
    private Long id;
    // 用户id
    private Long userId;
    // 总金额
    private BigDecimal total;
    // 使用金额
    private BigDecimal used;
    // 可用余额
    private BigDecimal residue;
    // 冻结金额
    private BigDecimal frozen;

}
