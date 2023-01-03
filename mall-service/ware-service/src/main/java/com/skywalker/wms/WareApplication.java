package com.skywalker.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author Code SkyWalker
 * @Date 9:39 2022/11/28
 * @Classname WareApplication
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.skywalker.wms.feign", "com.skywalker.pms.feign"})
@MapperScan(basePackages = {"com.skywalker.wms.dao"})
public class WareApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class, args);
    }
}
