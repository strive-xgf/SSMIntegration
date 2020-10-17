package com.xgf.service;

import com.xgf.bean.Person;
import com.xgf.dao.IPersonDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;
import java.io.InputStream;

public class TestMyBatis {
    private static SqlSessionFactory factory;
    private SqlSession session;

    //@BeforeClass只在类中执行一次, 必须声明为public static
    @BeforeClass
    public static void getFactory(){
        // 加载配置文件
        InputStream in = TestMyBatis.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    //@Before在每个测试方法之前都执行一次, 方法需要声明为public
    @Before
    public void init(){
        // 每个方法执行前创建SqlSession对象
        session = factory.openSession();
    }
    //每个方法执行结束进行提交和关闭
    @After
    public void destory(){
        session.commit();
        session.close();
    }
    //查询所有person
    @Test
    public void test01(){
        //最核心对象是session
        // System.out.println(session);
        //Mybastis的特点是sql与代码是分开的，需要映射文件，通过getMapper生成代理类
        IPersonDao personDao =  session.getMapper(IPersonDao.class);
        List<Person> personList = personDao.findAll();
        System.out.println(personList);
    }
    //保存person
    @Test
    public void test02(){
        //最核心对象是session
        IPersonDao dao =  session.getMapper(IPersonDao.class);
        dao.savePerson(new Person(null,"strive_day",200.00));
    }
}

