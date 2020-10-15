package com.xgf.service;//package com.xgf.service;

import com.xgf.bean.Person;
import com.xgf.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

//用spring自带的test测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPersonService {
    //日志
    private static final Logger log = Logger.getLogger(TestPersonService.class.getName());

    //自动装载
    @Autowired
    IPersonService personService;


    //编写两个业务功能，查找所有的Person，保存一个person，一般测试写两个就行
    //Spring和MyBatis整合，IOC（bean注入）和AOP（事务）测试

    //原始版本写法，改为Spring自带Test，注入进行测试
//    @Test
//    public void test01(){
//        //将结果输出到日志中，以后使用的时候不会通过sout输出到控制台，减少性能损耗

//        //创建业务对象
//        IPersonService personService = new PersonServiceImpl();
//
//        //调用查询
//        List<Person> list= personService.findAll();
//        log.info(list);//记录日志
//        //新增保存
//        Person person = new Person(null,"DemoGF",200000lf);
//        int code = personService.saveService(person);
//        System.out.println("code = " + code);
//        //调用查询
//        List<Person> = personService.findAll();
//        log.info(list);//记录日志
//
//    }




    //测试IOC DI依赖注入是否成功
    @Test
    public void test02(){
        System.out.println(personService);
    }


    //测试查询方法
    @Test
    public void test03(){
        //记录日志
        log.info(personService+"");
        //查询所有
        List<Person> list = personService.findAll();
        //调用保存
        log.info("allPerson："+list+"");
    }

    @Test
    public void test04(){
        Person person = new Person(null,"striveday",20000000.68);
        personService.savePerson(person);

        List<Person> list = personService.findAll();
        log.info("allPerson："+list+"");
    }


}
