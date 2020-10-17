package com.xgf.service;

import com.xgf.bean.Person;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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

    //模拟看是否发生事务回滚 批量保存（保存的过程中有一个地方抛出异常，就应该全部回滚）
    @Test
    public void test04(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(null,"savePerson_001",100.00));
        personList.add(new Person(null,"savePerson_002",200.00));
        //抛出1/0异常
        System.out.println(1/0);
        personList.add(new Person(null,"savePerson_003",300.00));

        int code = personService.savePersonList(personList);
        log.info("插入" + code + "条person数据");
    }

}
