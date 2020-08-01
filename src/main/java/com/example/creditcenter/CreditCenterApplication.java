package com.example.creditcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.example.creditcenter.Dao")
@ImportResource("classpath:applicationContext.xml")
@EnableTransactionManagement
/*@EnableAspectJAutoProxy*/
public class CreditCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCenterApplication.class, args);
    }

}
