package com.xjw.springclouddemo;

import com.xjw.springclouddemo.designPattern.PayFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 设计模式 测试类
 * @Date: 2021/12/30 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternTest {

	@Autowired
	private PayFactory payFactory;

	/**
	 * 支付 设计模式
	 * @Description: 工厂模式+策略模式 ，去掉if else ，让代码更优雅
	 * @Date: 2021/12/23 18:09
	 */
	@Test
	public void payRoute() {
		payFactory.toPay("wx","wxH5","入参对象");
		System.out.println("路由 - end");
	}

}
