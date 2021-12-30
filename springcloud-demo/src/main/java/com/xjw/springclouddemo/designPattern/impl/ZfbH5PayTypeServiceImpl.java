package com.xjw.springclouddemo.designPattern.impl;

import org.springframework.stereotype.Service;

@Service
public class ZfbH5PayTypeServiceImpl implements ZfbPayTypeService {


    @Override
    public void pay(Object object) {
        System.out.println("支付宝--H5支付");
    }

}
