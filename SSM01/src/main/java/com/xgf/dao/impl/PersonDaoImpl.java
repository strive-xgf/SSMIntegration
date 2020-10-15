package com.xgf.dao.impl;

import com.xgf.bean.Person;
import com.xgf.dao.IPersonDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements IPersonDao {
    @Override
    public List<Person> findAll() {
        System.out.println("findAll");
        return null;
    }

    @Override
    public int savePerson(Person person) {
        System.out.println("savePerson");
        return 1;
    }
}
