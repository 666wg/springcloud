package com.xjw.springclouddemo.designPattern.impl;

import com.xjw.springclouddemo.designPattern.PayTypeService;
import com.xjw.springclouddemo.designPattern.PayWayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ZfbPayWayServiceImpl implements PayWayService {

    @Resource
    private Map<String, ZfbPayTypeService> payTypeMap = new HashMap<>();

    @Override
    public PayTypeService choosePayType(String payTye, Object object) {
        return payTypeMap.get(payTye+"PayTypeServiceImpl");
    }

}
