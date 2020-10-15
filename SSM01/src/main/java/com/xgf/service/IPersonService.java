package com.xgf.service;

import com.xgf.bean.Person;

import java.util.List;

public interface IPersonService {
    //查找所有person
    List<Person> findAll();
    //新增一个person
    int savePerson(Person person);
}
