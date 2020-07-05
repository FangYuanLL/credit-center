package com.example.creditcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.example.creditcenter.Dao")
public class CreditCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCenterApplication.class, args);
    }

}
