package com.hcy.classroom.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 韩传勇
 * @version 1.0
 */
@MapperScan("com.hcy.classroom.front.mapper")
@SpringBootApplication
public class ServiceFrontApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceFrontApplication.class,args);

    }

}
