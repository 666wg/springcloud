package com.xjw.springclouddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xjw.springclouddemo.mapper")
@EnableScheduling
public class SpringcloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDemoApplication.class, args);
	}

}
