package com.crystal.SpringBootPractise.proxy;

public class UserServiceImpl implements UserService {

	@Override
	public String sayHello(String name) {
		System.out.println(name + " 你好！");
		return name;
	}

}
