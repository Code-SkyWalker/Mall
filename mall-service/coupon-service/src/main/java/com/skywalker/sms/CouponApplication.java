package com.skywalker.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author Code SkyWalker
 * @Date 9:08 2022/11/28
 * @Classname CouponApplication
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.skywalker.sms.dao"})
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }
}
