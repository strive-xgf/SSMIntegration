package com.xgf.dao;
import java.util.List;
import com.xgf.bean.Person;


public interface IPersonDao {
    //查询所有用户
    List<Person> findAll();
    //新增一个person
    int savePerson(Person person);
}
