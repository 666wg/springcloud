package com.xjw.springcloudclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xjw.springcloudclient.mapper")
public class SpringcloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudClientApplication.class, args);
	}

}
