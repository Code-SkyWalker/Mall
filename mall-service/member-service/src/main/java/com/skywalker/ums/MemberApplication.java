package com.skywalker.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author Code SkyWalker
 * @Date 9:24 2022/11/28
 * @Classname MemberApplication
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.skywalker.ums.dao"})
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
