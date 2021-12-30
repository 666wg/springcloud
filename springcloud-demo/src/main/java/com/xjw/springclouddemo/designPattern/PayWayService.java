package com.xjw.springclouddemo.designPattern;


public interface PayWayService {

    PayTypeService choosePayType(String payTye,Object object);

}
