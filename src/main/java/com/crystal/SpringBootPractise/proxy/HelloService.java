package com.crystal.SpringBootPractise.proxy;

public class HelloService {
    public String sayHello(String name) {
        System.out.println(name + " 你好！我是一个类");
        return name;
    }
}
