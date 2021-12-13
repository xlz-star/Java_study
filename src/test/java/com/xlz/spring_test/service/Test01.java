package com.xlz.spring_test.service;

import com.xlz.spring_test.service.impl.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01() {
        SomeServiceImpl someService = new SomeServiceImpl();
        someService.doSome();
    }

    @Test
    public void test02() {
        // 使用spring容器创建的对象
        // 指定spring配置文件的名称
        String config = "beans.xml";
        // 创建表示spring容器的对象， Applicationcontent
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象
        SomeService someService = (SomeService) ac.getBean("someService");
        someService.doSome();
    }
}
