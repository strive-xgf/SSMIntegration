//package com.xgf.dao.impl;
//
//import com.xgf.bean.Person;
//import com.xgf.dao.IPersonDao;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository //整合MyBatis,就不需要dao的实现类了，由映射文件完成
//@Deprecated  //添加注解@Deprecated表示这个类过时
//public class PersonDaoImpl implements IPersonDao {
//    @Override
//    public List<Person> findAll() {
//        System.out.println("findAll");
//        //因为没有整合mybatis，这里设置初始化数据进行模拟
//        List<Person> personList = new ArrayList<>();
//
//        Person person1 = new Person(null,"studyday",10000.0);
//        Person person2 = new Person(null,"striveday",20000.0);
//        personList.add(person1);
//        personList.add(person2);
//        return personList;
//    }
//
//    @Override
//    public int savePerson(Person person) {
//        System.out.println("savePerson");
//        return 1;
//    }
//}
