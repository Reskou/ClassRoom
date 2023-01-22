package com.hcy.classroom.vod;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 韩传勇
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.hcy")
@EnableDiscoveryClient
@MapperScan("com.hcy.classroom.vod.mapper")
public class ServiceVodApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceVodApplication.class,args);

    }

}
