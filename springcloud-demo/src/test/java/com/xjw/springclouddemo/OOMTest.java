package com.xjw.springclouddemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * OnOutOfMemory测试
 */
@Slf4j
public class OOMTest {

	/**
	 * 生成*.hprof 文件，输出到指定目录D:
	 * 虚拟机参数：
	 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:
	 */
	@Test
	public void oomTest() {
		List<Integer> list = new ArrayList<>();
		try {
			while (true) {
				list.add(RandomUtils.nextInt());
			}
		} catch (Exception e) {
			log.error("异常，{}",e.getMessage(),e);
		}
	}

}
