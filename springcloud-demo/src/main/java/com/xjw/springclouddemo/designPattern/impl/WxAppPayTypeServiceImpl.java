package com.xjw.springclouddemo.designPattern.impl;

import org.springframework.stereotype.Service;

@Service
public class WxAppPayTypeServiceImpl implements WxPayTypeService {


    @Override
    public void pay(Object object) {
        System.out.println("微信--APP支付");
    }

}
