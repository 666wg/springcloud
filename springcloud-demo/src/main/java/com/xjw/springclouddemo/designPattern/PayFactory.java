package com.xjw.springclouddemo.designPattern;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付 设计模式
 * @Description: 工厂模式+策略模式 ，去掉if else ，让代码更优雅
 * @Date: 2021/12/23 18:09
 */
@Component
public class PayFactory {

    @Resource
    private Map<String,PayWayService> payWayMap = new HashMap();

    public void toPay(String payWay,String payType,Object object) {
        payWayMap.get(payWay+"PayWayServiceImpl").choosePayType(payType,object).pay(object);
    }

}
