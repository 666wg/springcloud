package com.xjw.springcloudconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/sync")
    public Object sync() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud-config");
        String url = String.format("http://%s:%s/actuator/bus-refresh", serviceInstance.getHost(), serviceInstance.getPort());
        restTemplate.postForObject(url, map, Object.class);
        map.put("code", 0);
        return map;
    }
}
