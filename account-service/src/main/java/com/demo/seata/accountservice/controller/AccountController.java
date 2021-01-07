package com.demo.seata.accountservice.controller;

import com.demo.seata.accountservice.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 账户controller
 * @date 2021/1/6 16:28
 * @see
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 扣减金额
     * @date 2021/1/6 16:30
     */
    @GetMapping("/decrease")
    public String decrease(@RequestParam long userId, @RequestParam BigDecimal money) {
        accountMapper.decrease(userId, money);
        return "扣减金额成功";
    }
}
