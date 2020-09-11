package com.crystal.SpringBootPractise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理测试
 * 
 * @author zhanglei
 * @Date 2020年5月12日 下午1:30:51
 */
public class ProxyTest {

	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserService userService = (UserService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
				new Class[] { UserService.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("调用前");
						Object result = method.invoke(userServiceImpl, args);
						System.out.println("调用之后");
						return result;
					}
				});
		userService.sayHello("jack");
	}

}
