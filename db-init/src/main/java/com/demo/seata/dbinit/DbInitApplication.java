package com.demo.seata.dbinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class DbInitApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DbInitApplication.class, args);
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description springboot应用初始化完成之后会执行此方法；
     * @date 2021/1/6 15:31
     */
    @PostConstruct
    public void init() throws SQLException {
        // 账户-支付库
        exec("sql/account.sql");
        // 订单库
        exec("sql/order.sql");
        // 库存库
        exec("sql/storage.sql");
        // seata- 服务端库
        exec("sql/seata-server.sql");
    }

    /**
     * @param sqlPath sql的路径
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 执行sql脚本
     * @date 2021/1/6 15:33
     */
    private void exec(String sqlPath) throws SQLException {

        ClassPathResource classPathResource = new ClassPathResource(sqlPath, this.getClass().getClassLoader());
        EncodedResource encodedResource = new EncodedResource(classPathResource, "UTF-8");
        // spring - jdbc 提供
        ScriptUtils.executeSqlScript(dataSource.getConnection(), encodedResource);
    }


}
