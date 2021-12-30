package com.xjw.springclouddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xjw.springclouddemo.mapper")
public class SpringcloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDemoApplication.class, args);
	}

}
