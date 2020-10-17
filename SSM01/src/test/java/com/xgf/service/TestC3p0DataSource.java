package com.xgf.service;

import com.xgf.bean.Person;
import com.xgf.dao.IPersonDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
//测试c3p0数据库连接池，数据源是否配置对，能否拿到连接
//测试查询person、增加person
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestC3p0DataSource {
    private static final Logger log = Logger.getLogger(TestC3p0DataSource.class.getName());

    @Autowired
    DataSource dataSource;
    //测试能否通过链接拿到数据
    @Test
    public void testDataSource() throws SQLException {
        log.info("testDataSource获取连接："+dataSource.getConnection());
    }

    @Autowired
    IPersonDao personDao;

    //测试查询
    @Test
    public void test01(){
        List<Person> personList = personDao.findAll();
        System.out.println(personList);
    }
    //测试新增
    @Test
    public void test02(){
        Person person =  new Person(null,"TestC3p0DataSource",200.00);
        personDao.savePerson(person);
    }

}

