package com.xgf.dao;
import java.util.List;
import com.xgf.bean.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDao {
    //查询所有用户
    List<Person> findAll();
    //新增一个person
    int savePerson(Person person);
    //保存多个person
    int savePersonList(List<Person> personList);
}
