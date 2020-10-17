package com.xgf.service;

import com.xgf.bean.Person;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//用spring自带的test测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPersonService {
    //日志
    private static final Logger log = Logger.getLogger(TestPersonService.class.getName());

    //自动装载
    @Autowired
    IPersonService personService;

    //测试IOC DI依赖注入是否成功
    @Test
    public void test01(){
        System.out.println(personService);
    }

    //测试查询方法
    @Test
    public void test02(){
        //记录日志
        log.info(personService+"");
        //查询所有
        List<Person> list = personService.findAll();
        //调用保存
        log.info("allPerson："+list.toString()+"");
    }

    //测试增加方法
    @Test
    public void test03(){
        Person person = new Person(null,"striveday",20000000.68);
        personService.savePerson(person);

        List<Person> list = personService.findAll();
        log.info("allPerson："+list+"");
    }
}
