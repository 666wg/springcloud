package com.xjw.springclouddemo;

import org.junit.Test;

/**
 * 加载器
 */
public class ClassLoaderTest {

	@Test
	public void ClassLoaderTest() {
		ClassLoader applicationClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("应用类加载器" + applicationClassLoader);

		ClassLoader extensionClassLoader = applicationClassLoader.getParent();
		System.out.println("拓展类加载器" + extensionClassLoader);
		System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));

		ClassLoader bootstrapLoader = extensionClassLoader.getParent();
		System.out.println("启动类加载器" + bootstrapLoader);
		System.out.println("启动类加载器的加载路径：" + System.getProperty("sun.boot.class.path"));

	}

}
