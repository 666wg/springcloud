package com.xjw.springcloudeureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description: 搭建的SpringCloud的Eureka添加了安全验证，但是其他的服务注册不上了。
   Spring Security启用csrf，然后会对URL请求进行token验证，如果请求中没有token,浏览器会任务是非法网页的请求，然后就会拒绝。
  新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false;
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        super.configure(httpSecurity);
    }

}
