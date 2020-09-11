package com.crystal.SpringBootPractise.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib动态代理
 * 
 * @author zhanglei
 * @Date 2020年5月12日 下午1:55:25
 */
public class TestCglib {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloService.class);
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("cglib调用前");
				Object result;
				result = proxy.invokeSuper(object, args);
				System.out.println("cglib调用后");
				return result;
			}
		});
		HelloService usImpl = (HelloService) enhancer.create();
		usImpl.sayHello("jack");
	}

}
