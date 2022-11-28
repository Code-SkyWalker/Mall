package com.skywalker.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author Code SkyWalker
 * @Date 8:56 2022/11/28
 * @Classname ProductApplication
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.skywalker.pms.dao"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
