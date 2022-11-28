package com.skywalker.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author Code SkyWalker
 * @Date 17:09 2022/11/25
 * @Classname OrderApplication
 * @Description TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.skywalker.oms.dao"})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
