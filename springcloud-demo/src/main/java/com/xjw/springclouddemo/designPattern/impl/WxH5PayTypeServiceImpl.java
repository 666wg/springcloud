package com.xjw.springclouddemo.designPattern.impl;

import org.springframework.stereotype.Service;

@Service
public class WxH5PayTypeServiceImpl implements WxPayTypeService {


    @Override
    public void pay(Object object) {
        System.out.println("微信--H5支付");
    }

}
